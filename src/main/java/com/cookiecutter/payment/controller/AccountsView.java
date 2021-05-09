package com.cookiecutter.payment.controller;

import com.cookiecutter.payment.dto.AccountViewItem;
import com.cookiecutter.payment.entities.Account;
import com.cookiecutter.payment.repository.AccountRepository;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


/**
 * JSF View component for the accounts page
 * @author      Farzan Zubair
 */

@Component
@ViewScoped
@Slf4j
public class AccountsView {


    private List<AccountViewItem> allAccounts;

    public List<AccountViewItem> getAllAccounts(){
        init();
        return allAccounts;
    }

    @Autowired
    AccountRepository accountRepository;

    /**
     * Initializes The list of accounts
     */

    @PostConstruct
    public void init() {

        List<Account> accounts = accountRepository.findAll();
        this.allAccounts = new ArrayList<>();
        for(Account account:accounts){
            this.allAccounts.add(new AccountViewItem(account.getId().toString(), account.getName(), account.getBalance(), account.getEmailAddress()));
        }
    }

}
