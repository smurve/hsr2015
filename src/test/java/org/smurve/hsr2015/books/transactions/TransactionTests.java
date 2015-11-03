package org.smurve.hsr2015.books.transactions;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.smurve.hsr2015.ApplicationMain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.ConfigFileApplicationContextInitializer;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 *  This class tests a setup of an outer method calling two other (inner) methods with REQUIRES_NEW semantic
 *  that means the inner methods execute in their own isolated Tx
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ApplicationMain.class, initializers = ConfigFileApplicationContextInitializer.class)
public class TransactionTests {

    @Autowired
    private OuterService outer;

    @PersistenceContext
    private EntityManager em;

    @Before
    public void prepare () {
        outer.clearAllTestRecords();
    }

    @Test
    public void testNestedTransactionsHappyPath () throws Exception {

        // when all methods perform well
        outer.outerMethod(null, null);

        // there should be three records in the DB
        Assert.assertEquals(3, findAllRecords().size());
    }

    @Test
    public void testNestedTransactionsWhenOuterCodeFailsWithRuntimeException () {

        // when the outer method fails
        try {
            outer.outerMethod(new IllegalArgumentException("Let it fail!"), null);

        } catch (Exception e) {
            // there should be the exception, of course
            Assert.assertTrue(e instanceof IllegalArgumentException);
        }

        List<TestRecord> records = findAllRecords();

        // and there should be two records from the inner nested tx
        Assert.assertEquals(2, records.size());

        // that contain the words "FIRST" or "LAST"
        Assert.assertTrue(records.stream().allMatch(
                r -> r.getInnerOrOuter().contains("FIRST") || r.getInnerOrOuter().contains("SECOND")));

    }


    @Test
    public void testNestedTransactionsWhenSecondInnerMethodFailsWithRuntimeException () {

        // when the second inner method fails
        try {
            outer.outerMethod(null, new IllegalArgumentException("Let it fail!"));
            Assert.fail("There should have been an Exception");

        } catch (Exception e) {
            // there should be the exception, of course
            Assert.assertTrue(e instanceof IllegalArgumentException);
        }

        List<TestRecord> records = findAllRecords();

        // and there should be only a single record from the first inner nested tx
        Assert.assertEquals(1, records.size());

        // that contains the word "FIRST"
        Assert.assertTrue(records.get(0).getInnerOrOuter().contains("FIRST"));

    }


    @Test
    public void testNestedTransactionsWhenOuterFailsWithCheckedException () {

        // when the outer method fails with a checked exception
        try {
            outer.outerMethod(new MyOwnCheckedException("Let it fail!"), null);
            Assert.fail("There should have been an Exception");
        } catch (Exception e) {
            // there should be the exception, of course
            Assert.assertTrue(e instanceof MyOwnCheckedException);
        }

        List<TestRecord> records = findAllRecords();

        // and there should be all three records, since no rollback will occurs for checked exceptions.
        // That's the default behaviour
        Assert.assertEquals(3, records.size());

    }


    @Test
    public void test_Nested_Transactions_With_Additional_Semantics_When_Outer_Fails_With_CheckedException () {

        // when the outer method fails with a checked exception
        try {
            outer.outerMethodWithRollbackOnSpecialCheckedException(new MyOwnCheckedException("Let it fail!"), null);
            Assert.fail("There should have been an Exception");
        } catch (Exception e) {
            // there should be the exception, of course
            Assert.assertTrue(e instanceof MyOwnCheckedException);
        }

        List<TestRecord> records = findAllRecords();

        // and there should be all three records, since here the rollback will occur for the particular checked exceptions.
        Assert.assertEquals(2, records.size());

        // that contain the words "FIRST" or "LAST"
        Assert.assertTrue(records.stream().allMatch(
                r -> r.getInnerOrOuter().contains("FIRST") || r.getInnerOrOuter().contains("SECOND")));
    }




    // Java can be truly verbose!
    private List<TestRecord> findAllRecords () {
        CriteriaQuery<TestRecord> q = em.getCriteriaBuilder().createQuery(TestRecord.class);
        Root<TestRecord> root = q.from(TestRecord.class);
        q.select(root);
        TypedQuery<TestRecord> query = em.createQuery(q);
        return query.getResultList();
    }

    public static class MyOwnCheckedException extends Exception {

        public MyOwnCheckedException(String s) {
            super (s);
        }
    }
}
