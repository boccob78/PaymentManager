package com.cookiecutter.payment.controller;

import com.cookiecutter.payment.entities.Account;
import com.cookiecutter.payment.entities.Transaction;
import com.cookiecutter.payment.repository.AccountRepository;
import com.cookiecutter.payment.repository.TransactionRepository;
import com.cookiecutter.payment.services.MailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * Business delegate for the transfer of funds
 * @author      Farzan Zubair
 */

@Component
@Slf4j
public class TransferBean {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    MailService mailService;


    public void doTransfer(Account payer, Account payee, double transferAmount) {
        Transaction transaction = new Transaction();
        transaction.setAmount(transferAmount);
        transaction.setFrom(payer);
        transaction.setTo(payee);
        transactionRepository.save(transaction);

        payer.setBalance(payer.getBalance()-transferAmount);
        accountRepository.save(payer);
        payee.setBalance(payee.getBalance()+transferAmount);
        accountRepository.save(payee);

        mailService.notifyUser("transfer sent", payer.getEmailAddress(),"Payment of "+transferAmount+" sent to "+payee.getName());
        mailService.notifyUser("transfer received", payee.getEmailAddress(),"Payment of "+transferAmount+" received from "+payer.getName());
        log.info("Transaction created with id {} ", transaction.getId());

    }
}
