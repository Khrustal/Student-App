package com.studapp;

import com.studapp.controller.StudentController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest
@AutoConfigureMockMvc
class StudappApplicationTests {

    @Autowired
    StudentController controller;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void shouldLoadHome() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("home"));
    }

    @Test
    public void shouldLoadCreate() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/create"))
                .andExpect(status().isOk())
                .andExpect(view().name("create"));
    }

    @Test
    public void shouldLoadStudent() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/student"))
                .andExpect(status().isOk())
                .andExpect(view().name("student"));
    }

}
