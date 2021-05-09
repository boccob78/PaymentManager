package com.cookiecutter.payment.dto;

import lombok.*;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.UUID;

/**
 * The DTO for the data to view layer conversion
 * for transactions
 * @author      Farzan Zubair
 */


@Getter
@Setter
public class TransactionViewItem {

    private String id;
    private ZonedDateTime createdAt;
    private AccountViewItem from;
    private double amount;
    private AccountViewItem to;

    public TransactionViewItem(UUID id, AccountViewItem from, double amount, AccountViewItem to, Instant createdAt) {
        this.id = id.toString();
        this.from = from;
        this.amount = amount;
        this.to = to;
        this.createdAt = createdAt.atZone(ZoneId.systemDefault());
    }

}
