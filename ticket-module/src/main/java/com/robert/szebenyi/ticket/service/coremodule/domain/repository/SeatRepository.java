package com.robert.szebenyi.ticket.service.coremodule.domain.repository;

import com.robert.szebenyi.ticket.service.coremodule.domain.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {

}
