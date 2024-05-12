package com.test.gestionticket;

import com.test.gestionticket.model.Users;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class UserServiceTest {
    @Test
    public void testCreateUser() {
        Users user = new Users(10L, "JohnDoe", "john.doe@example.com",null);

        assertNotNull(user);
        assertEquals("JohnDoe", user.getUsername());
        assertEquals("john.doe@example.com", user.getEmail());
    }

    @Test
    public void testUpdateUser() {
        Users user = new Users(11L, "JaneSmith", "jane.smith@example.com",null);

        user.setUsername("JaneDoe");
        user.setEmail("jane.doe@example.com");

        assertEquals("JaneDoe", user.getUsername());
        assertEquals("jane.doe@example.com", user.getEmail());
    }
}
