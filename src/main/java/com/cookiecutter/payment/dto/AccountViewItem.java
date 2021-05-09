package com.cookiecutter.payment.dto;

import com.cookiecutter.payment.entities.Account;
import lombok.*;

import java.time.Instant;
import java.time.ZonedDateTime;

/**
 * The DTO for the data to view layer conversion
 * for accounts
 * @author      Farzan Zubair
 */


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountViewItem {

    private String id;
    private String name;
    private double balance;
    private String emailAddress;

    public AccountViewItem(Account account) {
        this.id = account.getId().toString();
        this.name = account.getName();
        this.emailAddress = account.getEmailAddress();
    }

    @Override
    public boolean equals(Object other) {
        return (other instanceof AccountViewItem) && (id != null)
                ? id.equals(((AccountViewItem) other).id)
                : (other == this);
    }

    @Override
    public int hashCode() {
        return (id != null)
                ? (this.getClass().hashCode() + id.hashCode())
                : super.hashCode();
    }


}
