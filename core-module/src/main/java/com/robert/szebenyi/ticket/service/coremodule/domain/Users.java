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
//@Table(name = "Users")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString()
public class Users extends BaseDomain {

    @Column(name = "userId", nullable = false, unique = true)
    private String userId;

    @Column(name = "name")
    private String name;


    @Column(name = "email")
    private String email;


}