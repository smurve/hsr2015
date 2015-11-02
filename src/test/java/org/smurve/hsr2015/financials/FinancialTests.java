package org.smurve.hsr2015.financials;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.smurve.hsr2015.ApplicationMain;
import org.smurve.hsr2015.books.BookRepo;
import org.smurve.hsr2015.books.domain.Author;
import org.smurve.hsr2015.books.domain.Book;
import org.smurve.hsr2015.books.domain.Category;
import org.smurve.hsr2015.financials.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes=ApplicationMain.class)
public class FinancialTests {

    public static final String BERNIES_ACCOUNT="01040567";

    @Autowired
    private AccountService service;

    @Autowired
    private BookRepo bookRepo;

    @Autowired
    private AccountRepo accountRepo;

    private Book karl;

    private Author bernie;

    @Before
    public void clearDb () {
        accountRepo.deleteAll();
        bookRepo.deleteAll();
    }

    @Test
    public void testBookPurchase () {

        given_accounts_receivables();

        given_book_karl_by_author_bernie();

        when_someone_buys_the_book();

        bernie_should_get_his_share();
    }

    private void given_accounts_receivables() {
        Account receivables = new Account(AccountService.ACC_NO_RECEIVABLES, null, 0);
        accountRepo.save(receivables);
    }

    private void given_book_karl_by_author_bernie() {
        bernie = new Author("Bernie", "Giersche", Category.FICTION);
        karl = new Book("Karl", bernie, Category.FICTION, 39.50);
        bookRepo.save(karl);

        Account berniesAccount = new Account(BERNIES_ACCOUNT, bernie, 0);
        accountRepo.save(berniesAccount);
    }

    private void when_someone_buys_the_book() {
        service.recordSales ( karl );
    }

    private void bernie_should_get_his_share() {
        Account berniesAccount = accountRepo.findByAccountOwner(bernie);
        Assert.assertTrue("Bernie should have some money", berniesAccount.getAmount() > 0);
    }

}
