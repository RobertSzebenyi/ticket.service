package com.robert.szebenyi.ticket.service.coremodule.users;

import com.robert.szebenyi.ticket.service.coremodule.domain.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class UsersService {

    private final UsersRepository usersRepository;

    public void test() {
        System.out.println(usersRepository.findAll());
    }
}
