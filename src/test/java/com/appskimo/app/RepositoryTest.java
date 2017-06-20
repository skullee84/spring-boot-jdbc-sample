package com.appskimo.app;

import com.appskimo.app.domain.model.User;
import com.appskimo.app.domain.repository.UserRepository;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertNotNull;

/**
 * Created by dominic on 2016. 9. 21..
 */
@Ignore
@ActiveProfiles("dev")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
public class RepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Before
    public void before() {
        assertNotNull(userRepository);
    }

    @Test
    @Transactional
    public void testInsert() {
        User user = new User();
        user.setName("sample");

        userRepository.insert(user);
        assertNotNull(user.getId());
    }
}
