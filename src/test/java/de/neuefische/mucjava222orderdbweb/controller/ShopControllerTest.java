package de.neuefische.mucjava222orderdbweb.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class ShopControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DirtiesContext
    void getAllProducts() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/shop/products"))
                .andExpect(status().isOk())
                .andExpect(content().json("[]"));
    }

    @Test
    @DirtiesContext
    void addProduct() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/shop/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                "name": "testName",
                                "id": "123"
                                }
                                """))
                .andExpect(status().isOk())
                .andExpect(content().json("""
                        {
                        "name": "testName",
                        "id": "123"
                        }
                        """));
    }
}
