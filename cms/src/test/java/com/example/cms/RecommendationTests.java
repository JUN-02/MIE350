package com.example.cms;

import com.example.cms.model.entity.User;
import com.example.cms.model.repository.RatingRepository;
import com.example.cms.model.repository.RecommendationRepository;
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class RecommendationTests {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ShoeRepository shoeRepository;

    @Autowired
    private RecommendationRepository recommendationRepository;

    @Test
    void getRec() throws Exception{
        MockHttpServletResponse response = mockMvc.perform(get("/recommendations/1"))
                .andReturn().getResponse();

        assertEquals(200, response.getStatus());

        ObjectNode receivedJson = objectMapper.readValue(response.getContentAsString(), ObjectNode.class);
        assertEquals(1, receivedJson.get("recommendationId").longValue());
        assertEquals("Free-entry to Construction Site drip", receivedJson.get("recommendName").textValue());
        assertEquals("Title self-explanatory", receivedJson.get("description").textValue());
        //assertEquals(2, receivedJson.get("recommendationId").longValue());
        //assertEquals("McDonalds General Manager Drip", receivedJson.get("recommendName").textValue());
        //assertEquals("Flip my burger", receivedJson.get("description").textValue());
    }

}
