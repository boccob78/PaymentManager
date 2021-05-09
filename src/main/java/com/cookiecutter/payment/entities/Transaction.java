package com.cookiecutter.payment.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.Instant;
import java.util.UUID;

/**
 * The transaction entity
 *
 * @author      Farzan Zubair
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "transaction", uniqueConstraints = @UniqueConstraint(name = "uc_id", columnNames = { "id" }))
public class Transaction {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private final Instant createdAt = Instant.now();

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Instant updatedAt;

    @OneToOne
    @JoinColumn(name = "fromAccount")
    private Account from;

    @Column(nullable = false)
    private double amount;

    @OneToOne
    @JoinColumn(name = "toAccount")
    private Account to;

}
