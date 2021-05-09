package com.cookiecutter.payment.repository;

import com.cookiecutter.payment.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * The Spring data repository for Accounts
 *
 * @author      Farzan Zubair
 */

@Repository
public interface AccountRepository extends JpaRepository<Account, UUID> {

}
