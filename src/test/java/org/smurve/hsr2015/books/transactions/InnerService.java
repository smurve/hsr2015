package org.smurve.hsr2015.books.transactions;

import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 */
@Component
public class InnerService {

    @PersistenceContext
    private EntityManager em;

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public void withNewTransaction ( String id, Exception exceptionToThrow ) throws  Exception {

        String exception = exceptionToThrow == null ? "none" : exceptionToThrow.getClass().getSimpleName();

        em.persist(new TestRecord( id, exception, "none"));

        if ( exceptionToThrow != null ) {
            throw  exceptionToThrow;
        }
    }

}
