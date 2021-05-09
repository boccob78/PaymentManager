package com.cookiecutter.payment.repository;


import com.cookiecutter.payment.entities.Account;
import com.cookiecutter.payment.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

/**
 * The Spring data repository for Transactions
 *
 * @author      Farzan Zubair
 */

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, UUID> {

    /**
     * <p>find transactions by account id</p>
     *
     * @param accountId      String representation of the account UUID
     * @return list of transactions
     */

    @Query(value = "SELECT t FROM Transaction t WHERE t.from.id = :accountId")
    List<Transaction> findTransactionsBy(@Param("accountId") UUID accountId);
}
