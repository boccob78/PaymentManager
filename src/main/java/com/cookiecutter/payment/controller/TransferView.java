package com.cookiecutter.payment.controller;

import com.cookiecutter.payment.services.MailService;
import com.cookiecutter.payment.dto.AccountViewItem;
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
import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * JSF View component for the transfer page
 * @author      Farzan Zubair
 */


@Component
@RequestScoped
@Slf4j
public class TransferView {

    @Getter
    List<AccountViewItem> allAccounts;

    @Autowired
    TransferBean transferBean;

    @Getter
    @Setter
    private String from;

    @Getter
    @Setter
    private String to;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    MailService mailService;

    @Getter
    @Setter
    private double transferAmount;

    private List<SelectItem> selectAccounts;

    public List<SelectItem> getSelectAccounts(){
        init();
        return selectAccounts;
    }

    @PostConstruct
    public void init() {

        List<Account> accounts = accountRepository.findAll();
        allAccounts = new ArrayList<>();
        for(Account account:accounts){
            allAccounts.add(new AccountViewItem(account.getId().toString(), account.getName(), account.getBalance(), account.getEmailAddress()));
        }
        //currentAccount.setAccount(allAccounts.get(0));
        selectAccounts = new ArrayList<>();
        for(AccountViewItem account: getAllAccounts()) {
            selectAccounts.add(new SelectItem(account.getId(), account.getName()));
        }
    }

    public void transfer(){
        final Account payer = accountRepository.findById(UUID.fromString(from)).get();
        final Account payee = accountRepository.findById(UUID.fromString(to)).get();
        if(transferAmount == 0) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Transfer a bit of bob!", ""));
            return;
        }
        if(payer.equals(payee)) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Transfer to yourself? POGGERS!", ""));
            return;
        }
        double currentBalance = payer.getBalance();
        if(transferAmount > currentBalance) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Balance transfer amount greater than current account", ""));
            return;
        }else{
            transferBean.doTransfer(payer, payee, transferAmount);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Balance transfer successful", ""));
        }

    }

}
