package org.smurve.hsr2015.books.transactions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import javax.transaction.Transactional;

/**
 *  A service prototype with obvious fail semantics so that nested transactions can be studied
 *  The outerMethod method creates a tx if there's none yet, otherwise uses the existing one in the call context
 *  from within outerMethod, an inner method with nested transactions is called.
 *  Please study the resulting test records in the DB in the case of exceptions being thrown
 */
@Component
public class OuterService {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private InnerService innerService;

    @Autowired
    ApplicationContext springContext;

    private OuterService mySelf;


    /**
     *  to get an advised instance of myself without creating a circular reference at autowiring time
     *  we need to ask the Spring context to provide that instance after the wiring.
     */
    @PostConstruct
    public void findReferenceToMySelfAsABean () {
        mySelf = springContext.getBean(OuterService.class);
    }

    /**
     *  calls another method on an InnerService class two times. The first will always succeed, the second may fail
     * @param forOuter exception to be thrown in this method, after the two inner method calls, or null
     * @param forSecondInner exception to be thrown in the second inner method, or null
     * @throws Exception
     */
    @Transactional(value = Transactional.TxType.REQUIRED)
    public void outerMethod ( Exception forOuter, Exception forSecondInner ) throws Exception {

        String outerExceptionName = forOuter == null ? "none" : forOuter.getClass().getSimpleName();
        String innerExceptionName = forSecondInner == null ? "none" : forSecondInner.getClass().getSimpleName();

        em.persist ( new TestRecord ( "OUTER", outerExceptionName, innerExceptionName ));

        // this one never fails
        innerService.withNewTransaction("FIRST INNER", null);

        // this one fails if forSecondInner is not null
        innerService.withNewTransaction("SECOND INNER", forSecondInner);

        if ( forOuter != null ) {
            throw forOuter;
        }
    }

    /**
     * This method wraps "outerMethod" with additional Tx Semantics, as it rolls back on MyOwnCheckedException
     * @param forOuter exception to be thrown in this method, after the two inner method calls, or null
     * @param forSecondInner exception to be thrown in the second inner method, or null
     * @throws Exception
     */
    @Transactional(value = Transactional.TxType.REQUIRED, rollbackOn = TransactionTests.MyOwnCheckedException.class )
    public void outerMethodWithRollbackOnSpecialCheckedException ( Exception forOuter, Exception forSecondInner ) throws Exception {
        mySelf.outerMethod(forOuter, forSecondInner );
    }



        @Transactional(Transactional.TxType.REQUIRED)
    public void clearAllTestRecords() {
        CriteriaDelete<TestRecord> delete = em.getCriteriaBuilder().createCriteriaDelete(TestRecord.class);
        delete.from(TestRecord.class);
        em.createQuery(delete).executeUpdate();
    }
}
