package com.robert.szebenyi.ticket.service.coremodule.events;

import com.robert.szebenyi.ticket.service.coremodule.domain.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class EventService {

    private final UsersRepository usersRepository;

    // Dummy test TODO delete it later
    public void test() {
        System.out.println(usersRepository.findAll());
    }
}
