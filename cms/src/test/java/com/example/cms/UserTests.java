package com.example.cms;

import com.example.cms.model.entity.User;
import com.example.cms.model.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserTests {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private UserRepository userRepository;

    @Test
    void addUser() throws Exception{
        ObjectNode userJson = objectMapper.createObjectNode();
        userJson.put("userName", "JackTheDripper");
        userJson.put("password", "drip123");
        userJson.put("email", "jack@drip.com");

        MockHttpServletResponse response_users = mockMvc.perform(post("/signup").
                        contentType("application/json").
                        content(userJson.toString())).
                andReturn().getResponse();

        assertEquals(200, response_users.getStatus());

        assertTrue(userRepository.findById("JackTheDripper").isPresent());
        User addedUser = userRepository.findById("JackTheDripper").get();

        assertEquals("drip123", addedUser.getPassword());
        assertEquals("jack@drip.com", addedUser.getEmail());
    }

    @Test
    void deleteUser() throws Exception{
        User u = new User();
        u.setUserName("GigaChad");
        u.setEmail("giga@chad.com");
        u.setPassword("NO");
        userRepository.save(u);

        MockHttpServletResponse response = mockMvc.perform(
                        delete("/users/GigaChad/delete").
                                contentType("application/json"))
                .andReturn().getResponse();

        assertEquals(200, response.getStatus());
        assertTrue(userRepository.findById("GigaChad").isEmpty());
    }

    @Test
    void changeUserPassword() throws Exception{
        User u = new User();
        u.setUserName("JackTheDripper");
        u.setEmail("jack@drip.com");
        u.setPassword("drip123");
        userRepository.save(u);

        ObjectNode userJson = objectMapper.createObjectNode();
        userJson.put("userName", "JackTheDripper");
        userJson.put("password", "drip-182");

        MockHttpServletResponse response = mockMvc.perform(
                        put("/users/JackTheDripper/change").
                                contentType("application/json").
                                content(userJson.toString())).
                andReturn().getResponse();

        assertEquals(200, response.getStatus());

        User updatedUser = userRepository.findById("JackTheDripper").get();
        assertEquals("drip-182", updatedUser.getPassword());
    }

    @Test
    void getUser() throws Exception{
        MockHttpServletResponse response = mockMvc.perform(get("/users/admin"))
                .andReturn().getResponse();

        assertEquals(200, response.getStatus());

        ObjectNode receivedJson = objectMapper.readValue(response.getContentAsString(), ObjectNode.class);
        assertEquals("admin", receivedJson.get("userName").textValue());
        assertEquals("admin@hotmail.ca", receivedJson.get("email").textValue());
        assertEquals("password1", receivedJson.get("password").textValue());
        assertEquals(0, receivedJson.get("loggedIn").longValue());
    }
}
