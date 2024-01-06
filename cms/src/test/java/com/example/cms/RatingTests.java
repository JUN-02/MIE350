package com.example.cms;

import com.example.cms.model.entity.Rating;
import com.example.cms.model.entity.User;
import com.example.cms.model.repository.RatingRepository;
import com.example.cms.model.repository.ShoeRepository;
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

import static java.lang.Long.sum;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class RatingTests {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ShoeRepository shoeRepository;

    @Autowired
    private RatingRepository ratingRepository;




    @Test
    void addRating() throws Exception{
        ObjectNode ratingJson = objectMapper.createObjectNode();
        ratingJson.put("ratingId",ratingRepository.count());
        ratingJson.put("ratingScore", 4);
        ratingJson.put("description", "mid tbqh");
        ratingJson.put("shoeId", 3L);
        ratingJson.put("userName", "admin");

        MockHttpServletResponse response_users = mockMvc.perform(post("/ratings").
                        contentType("application/json").
                        content(ratingJson.toString())).
                andReturn().getResponse();

        assertEquals(200, response_users.getStatus());

        assertTrue(ratingRepository.findById(4L).isPresent());
        Rating addedRating = ratingRepository.findById(4L).get();

        assertEquals(4, addedRating.getRatingScore());
        assertEquals("mid tbqh", addedRating.getDescription());
        assertEquals(3L, addedRating.getShoeId().getShoeId());
        assertEquals("admin", addedRating.getUserName().getUserName());

    }

    @Test
    void deleteRating() throws Exception{
        Rating r = new Rating();
        r.setRatingId(6L);
        r.setShoeId(shoeRepository.findShoe(27L));
        r.setDescription("Love It!");
        r.setRatingScore(2.5F);
        r.setUserName(userRepository.findUser("admin"));
        ratingRepository.save(r);

        MockHttpServletResponse response = mockMvc.perform(
                        delete("/ratings/6").
                                contentType("application/json"))
                .andReturn().getResponse();

        assertEquals(200, response.getStatus());
        assertTrue(ratingRepository.findById(6L).isEmpty());
    }

    @Test
    void changeRating() throws Exception{
        Rating r = new Rating();
        r.setRatingId(6L);
        r.setShoeId(shoeRepository.findShoe(27L));
        r.setDescription("Love It!");
        r.setRatingScore(2.5F);
        r.setUserName(userRepository.findUser("admin"));
        ratingRepository.save(r);


        ObjectNode ratingJson = objectMapper.createObjectNode();
        ratingJson.put("ratingScore", 5.0F);
        ratingJson.put("description", "hate it!!");

        MockHttpServletResponse response = mockMvc.perform(
                        put("/users/ratings/6").
                                contentType("application/json").
                                content(ratingJson.toString())).
                andReturn().getResponse();

        assertEquals(200, response.getStatus());

        Rating updatedRating = ratingRepository.findById(6L).get();
        assertEquals(5.0F, updatedRating.getRatingScore());
        assertEquals("hate it!!", updatedRating.getDescription());
    }

}
