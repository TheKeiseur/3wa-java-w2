package com.example.wajavaw2.controller;

import com.example.wajavaw2.model.Student;
import com.example.wajavaw2.service.StudentService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.nio.charset.StandardCharsets;

@RunWith(SpringRunner.class)
@WebMvcTest
@AutoConfigureMockMvc
public class StudentControllerTest {

    @MockBean
    private StudentService studentService;

    @Autowired
    StudentController studentController;
    @Autowired
    private MockMvc mvc;



    /*@Test
    public void whenPostRequestToStudentAndValidStudent_thenCorrectResponse() throws Exception {
        String student = "{\n" +
                "    \"name\": \"Kevin\",\n" +
                "    \"age\": 24,\n" +
                "    \"email\": \"kevin@something.com\"\n" +
                "}";
        mvc.perform(MockMvcRequestBuilders.post("/api/v1/management/students")
                        .content(student)
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void whenPostRequestToStudentsAndInValidStudents_thenCorrectResponse() throws Exception {
        String student = "{\"name\": \"\", \"email\" : \"bob@domain.com\"}";
        mvc.perform(MockMvcRequestBuilders.post("/api/v1/management/students")
                        .content(student)
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }*/


}
