package org.smurve.hsr2014.jooq;

import org.jooq.*;
import org.jooq.impl.DSL;
import org.junit.Test;

import static test.generated.Tables.*;

import java.sql.*;

/**
 * An example of using a simple, yet powerful SQL Query framework
 */
public class JooqTest {

    @Test
    public void testSimpleRetrieval() {

        String userName = "root";
        String password = "root";
        String url = "jdbc:mysql://localhost:3306/hsr2015";

        // Connection is the only JDBC resource that we need
        // PreparedStatement and ResultSet are handled by jOOQ, internally
        try (Connection conn = DriverManager.getConnection(url, userName, password)) {
            DSLContext ctx = DSL.using(conn, SQLDialect.MYSQL);

            ctx.deleteFrom(BOOK).execute();
            ctx.deleteFrom(ACCOUNT).execute();
            ctx.deleteFrom(AUTHOR).execute();


            ctx.insertInto(AUTHOR, AUTHOR.ID, AUTHOR.FIRSTNAME, AUTHOR.LASTNAME, AUTHOR.CATEGORY)
                    .values(10L, "Harry", "Hirsch", "Fiction").execute();

            ctx.insertInto(ACCOUNT, ACCOUNT.ID, ACCOUNT.ACCOUNTNUMBER, ACCOUNT.ACCOUNTOWNER_ID, ACCOUNT.AMOUNT)
                    .values(11L, "SAVINGS001", 10L, 1500.00).execute();

            ctx.insertInto(BOOK, BOOK.ID, BOOK.AUTHOR_ID, BOOK.TITLE, BOOK.PRICE, BOOK.CATEGORY)
                    .values(12L, 10L, "My little farm", 145.00, "Poetry").execute();

            ctx.insertInto(BOOK, BOOK.ID, BOOK.AUTHOR_ID, BOOK.TITLE, BOOK.PRICE, BOOK.CATEGORY)
                    .values(13L, 10L, "Your little farm", 146.00, "Poetry").execute();


            Result<Record> books = ctx.select().from(BOOK)
                    .where(
                            BOOK.AUTHOR_ID.equal(10L))
                    .and(
                            BOOK.TITLE.startsWith("My")
                                    .or(BOOK.TITLE.startsWith("Your")))
                    .fetch();

            for (Record r : books) {
                String title = r.getValue(BOOK.TITLE);
                System.out.println(title);
            }

        }
        // For the sake of this tutorial, let's keep exception handling simple
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}