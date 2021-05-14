package com.robert.szebenyi.ticket.service.coremodule.users;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
@RunWith(SpringRunner.class)
public class UsersServiceTest {

    @Autowired
    private UsersService usersService;

    // TODO dummy test delete it later
    @Test
    public void test() {
        usersService.test();
        assertTrue(true);
    }

}