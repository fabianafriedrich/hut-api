package com.cct.hut.api.repository.tests;

import com.cct.hut.api.model.User;
import com.cct.hut.api.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest
public class UserRepositoryIntegrationTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepositoryUnderTest;

    @Test
    public void whenFindByEmailThenReturnUser(){

        //given
        User user = new User();
        user.setEmail("fabi@gmail.com");
        entityManager.persist(user);
        entityManager.flush();

        //when
        User found = userRepositoryUnderTest.findByEmail(user.getEmail());

        //then
        Assertions.assertEquals(user.getEmail(), found.getEmail());

    }

}
