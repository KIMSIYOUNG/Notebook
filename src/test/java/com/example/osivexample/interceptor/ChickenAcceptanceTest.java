package com.example.osivexample.interceptor;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class ChickenAcceptanceTest {

    @Autowired MockMvc mockMvc;

    @Test
    void update() throws Exception {

        mockMvc.perform(put("/chicken")
            .header("id", 1L)
            .accept(MediaType.APPLICATION_JSON)
        )
            .andExpect(status().isOk())
            .andDo(print());

        mockMvc.perform(get("/chicken")
            .header("id", 1L)
            .accept(MediaType.APPLICATION_JSON)
        )
            .andExpect(status().isOk())
            .andDo(print());
    }
}