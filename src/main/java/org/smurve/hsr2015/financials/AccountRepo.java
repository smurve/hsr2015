package org.smurve.hsr2015.financials;

import org.smurve.hsr2015.books.domain.Author;
import org.smurve.hsr2015.financials.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepo extends JpaRepository<Account, Long> {

    Account findByAccountOwner(Author author);

    Account findByAccountNumber(String accNoReceivables);
}
