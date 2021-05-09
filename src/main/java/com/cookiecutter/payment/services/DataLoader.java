package com.cookiecutter.payment.services;

import com.cookiecutter.payment.entities.Account;
import com.cookiecutter.payment.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.Instant;

/**
 * Loads accounts data on context startup
 *
 * @author      Farzan Zubair
 */

@Component
public class DataLoader implements ApplicationRunner {

    private AccountRepository accountRepository;

    @Autowired
    public DataLoader(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void run(ApplicationArguments args) {
        Account data = new Account();
        data.setEmailAddress("secretescapes-green@mailinator.com");
        data.setName("secretescapes-green");
        data.setUpdatedAt(Instant.now());
        data.setBalance(200.00);
        accountRepository.save(data);
        data = new Account();
        data.setEmailAddress("secretescapes-blue@mailinator.com");
        data.setUpdatedAt(Instant.now());
        data.setName("secretescapes-blue");
        data.setBalance(200.00);
        accountRepository.save(data);
        data = new Account();
        data.setEmailAddress("secretescapes-red@mailinator.com");
        data.setName("secretescapes-red");
        data.setUpdatedAt(Instant.now());
        data.setBalance(200.00);
        accountRepository.save(data);
        data = new Account();
        data.setEmailAddress("secretescapes-yellow@mailinator.com");
        data.setName("secretescapes-yellow");
        data.setUpdatedAt(Instant.now());
        data.setBalance(200.00);
        accountRepository.save(data);

    }
}