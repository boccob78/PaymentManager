package com.cookiecutter.payment.controller;

import com.cookiecutter.payment.dto.AccountViewItem;
import com.cookiecutter.payment.dto.TransactionViewItem;
import com.cookiecutter.payment.entities.Account;
import com.cookiecutter.payment.entities.Transaction;
import com.cookiecutter.payment.repository.AccountRepository;
import com.cookiecutter.payment.repository.TransactionRepository;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


/**
 * JSF View component for the transactions page
 * @author      Farzan Zubair
 */


@Slf4j
@Component
@RequestScoped
public class TransactionsView {

    List<TransactionViewItem> allTransactions;

    @Getter
    @Setter
    private String accountId;

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    AccountRepository accountRepository;

    public List<TransactionViewItem> getAllTransactions() {
        return getTransactionsBy(accountId);

    }

    public List<TransactionViewItem> getTransactionsBy(String accountId) {
        List<Transaction> transactions = transactionRepository.findTransactionsBy(UUID.fromString(accountId));
        log.info("transactions size is "+transactions);
        this.allTransactions = new ArrayList<>();
        for(Transaction transaction:transactions){
            this.allTransactions.add(new TransactionViewItem(transaction.getId(),new AccountViewItem(transaction.getFrom()), transaction.getAmount(), new AccountViewItem(transaction.getTo()), transaction.getCreatedAt()));
        }
        return allTransactions;
    }

}
