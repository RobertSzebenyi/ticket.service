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
public class UserDevice extends BaseDomain {

    @Column(name = "userId", nullable = false, unique = true)
    private Long userId;

    @Column(name = "deviceHash", nullable = false)
    private String deviceHash;

}