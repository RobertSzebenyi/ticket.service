package com.robert.szebenyi.ticket.service.coremodule.domain.repository;

import com.robert.szebenyi.ticket.service.coremodule.domain.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

}
