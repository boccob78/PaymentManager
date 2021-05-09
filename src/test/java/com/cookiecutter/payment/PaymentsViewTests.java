package com.cookiecutter.payment;

import com.cookiecutter.payment.controller.*;
import com.cookiecutter.payment.dto.AccountViewItem;
import com.cookiecutter.payment.dto.MessageViewItem;
import com.cookiecutter.payment.dto.TransactionViewItem;
import com.cookiecutter.payment.entities.Account;
import com.cookiecutter.payment.repository.AccountRepository;
import com.cookiecutter.payment.repository.TransactionRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class PaymentsViewTests {

    @Autowired
    private AccountsView accountsView;
    @Autowired
    private AccountRepository mockAccountRepository;
    @Autowired
    private TransactionRepository mockTransactionRepository;
    @Autowired
    private TransferBean transferBean;
    @Autowired
    private TransactionsView transactionsView;
    @Autowired
    private MessagesView messagesView;

    @Test
    public void canListAccounts() {
        List<AccountViewItem> accountViewItems = accountsView.getAllAccounts();
        List<Account> accounts = new ArrayList<>();
        accounts = mockAccountRepository.findAll();
        assertTrue(accountViewItems.size() == accounts.size());
    }

    @Test
    public void canTransfer() {
        List<Account> accounts = mockAccountRepository.findAll();

        assertTrue(accounts.size() > 1);

        Account payer = accounts.get(0);
        Account payee = accounts.get(1);

        transferBean.doTransfer(payer, payee, 20.0);

        List<TransactionViewItem> transactions = transactionsView.getTransactionsBy(payer.getId().toString());
        assertTrue(transactions.size() > 0);
        assertTrue(transactions.get(0).getFrom().getId().equals(payer.getId().toString()));
        assertTrue(transactions.get(0).getAmount() == 20.0);
        assertTrue(transactions.get(0).getTo().getId().equals(payee.getId().toString()));

        List<MessageViewItem> messageViewItems = messagesView.getMessagesBy(payer.getEmailAddress());
        assertTrue(messageViewItems.size() > 0);
        messageViewItems=messagesView.getMessagesBy(payee.getEmailAddress());
        assertTrue(messageViewItems.size() > 0);

    }

}
