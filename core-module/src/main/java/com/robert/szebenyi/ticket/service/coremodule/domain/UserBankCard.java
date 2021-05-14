package com.robert.szebenyi.ticket.service.coremodule.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString()
public class UserBankCard extends BaseDomain {

    @Column(name = "userId", nullable = false, unique = true)
    private Long userId;

    @Column(name = "cardId", nullable = false, unique = true)
    private String cardId;

    @Column(name = "cardnumber", nullable = false)
    private Long cardNumber;

    @Column(name = "cvc", nullable = false)
    private int cvc;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "amount")
    private Long amount;

    @Column(name = "currency", nullable = false)
    private String currency;
}