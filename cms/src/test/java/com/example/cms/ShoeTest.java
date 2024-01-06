package com.example.cms;

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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ShoeTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private UserRepository shoeRepository;

    @Test
    void getShoe() throws Exception{
        MockHttpServletResponse response = mockMvc.perform(get("/shoes/5"))
                .andReturn().getResponse();

        assertEquals(200, response.getStatus());

        ObjectNode receivedJson = objectMapper.readValue(response.getContentAsString(), ObjectNode.class);
        assertEquals(5L, receivedJson.get("shoeId").longValue());
        assertEquals("Crocs Classic Clog", receivedJson.get("shoeName").textValue());
        assertEquals("Navy", receivedJson.get("color").textValue());
        assertEquals("Casual", receivedJson.get("type").textValue());
        assertEquals("Men", receivedJson.get("gender").textValue());
        assertEquals(49.99F, receivedJson.get("price").floatValue());
        assertEquals(7F, receivedJson.get("size").floatValue());
        assertEquals("Crocs", receivedJson.get("brand").textValue());
        assertEquals("https://media.crocs.com/images/t_pdphero/f_auto%2Cq_auto/products/10001_309_ALT100/crocs", receivedJson.get("image_url").textValue());
    }
}
