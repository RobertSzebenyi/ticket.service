package com.robert.szebenyi.ticket.service.coremodule.domain.repository;

import com.robert.szebenyi.ticket.service.coremodule.domain.UserBankCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserBankCardRepository extends JpaRepository<UserBankCard, Long> {

}
