package com.andy.authentication.repository;

import com.andy.authentication.models.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    private final String MAIL = "andyrabearimanana@gmail.com";
    private final String PASSWORD = "pass";


    @Test
    void testSave() {
        User user = new User();
        user.setMail(MAIL);
        user.setFullName("RABEARIMANANA Andy Natana");
        user.setPassword(PASSWORD);

        userRepository.save(user);
        assertNotNull(user.getUserId());
    }

    @Test
    void testFindByFullNameAndPassword() {
        User user = userRepository.findByMailAndPassword(MAIL, PASSWORD)
                .orElseThrow();

        assertNotNull(user.getMail());
        assertEquals(MAIL, user.getMail());
    }
}