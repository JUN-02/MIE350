package com.example.cms;

import com.example.cms.model.entity.*;
import com.example.cms.model.repository.RatingRepository;
import com.example.cms.model.repository.ShoeRepository;
import com.example.cms.model.repository.UserRepository;
import com.example.cms.model.repository.WishlistRepository;
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WishlistTests {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ShoeRepository shoeRepository;

    @Autowired
    private WishlistRepository wishlistRepository;


    /*
    @Test
    void addWishlist() throws Exception{
        ObjectNode wishlistJson = objectMapper.createObjectNode();
        wishlistJson.put("shoeId",38L);
        wishlistJson.put("userName", "admin");


        MockHttpServletResponse response_users = mockMvc.perform(post("/wishlists").
                        contentType("application/json").
                        content(wishlistJson.toString())).
                andReturn().getResponse();

        assertEquals(200, response_users.getStatus());

        Shoe shoe = shoeRepository.findShoe(38L);
        User user = userRepository.findUser("admin");
        WishlistKey key = new WishlistKey();
        key.setShoeId(wishlistJson.getShoeId(38L));
        key.setUserName(wishlistJson.get("admin"));


    }

     */
}
