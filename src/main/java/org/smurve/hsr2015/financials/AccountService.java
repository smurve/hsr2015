package org.smurve.hsr2015.financials;

import org.smurve.hsr2015.books.BookRepo;
import org.smurve.hsr2015.books.domain.Book;
import org.smurve.hsr2015.financials.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class AccountService {

    public static final String ACC_NO_RECEIVABLES = "0900101054";

    private final AccountRepo accountRepo;

    @Autowired
    public AccountService ( AccountRepo accountRepo ) {
        this.accountRepo = accountRepo;
    }

    @Transactional
    public void recordSales(Book book) {

        // Author's account
        Account authorsAccount = accountRepo.findByAccountOwner(book.getAuthor());

        // this company's receivables
        Account receivables = accountRepo.findByAccountNumber ( ACC_NO_RECEIVABLES );

        double authorNewAmount = authorsAccount.getAmount() + book.getPrice();
        double receivablesNewAmount = receivables.getAmount() - book.getPrice();

        authorsAccount.setAmount ( authorNewAmount );
        receivables.setAmount ( receivablesNewAmount );
    }
}
