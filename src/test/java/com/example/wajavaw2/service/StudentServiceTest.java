package com.example.wajavaw2.service;

import com.example.wajavaw2.Calculator;
import com.example.wajavaw2.model.Student;
import com.example.wajavaw2.repository.StudentRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
public class StudentServiceTest {
    List<Student> students;

    @Mock
    StudentRepository studentRepository;
    @Autowired
    StudentService studentService;

    @Before
    public void setUp() {
        studentService = new StudentService();
        students = Arrays.asList(
                new Student("Gerald", 31, "gerald@something.com"),
                new Student("Arthur", 24, "arthur@something.com"),
                new Student("Hugo", 20, "hugo@something.com"),
                new Student("Alexandre", 23, "alexandre@something.com"),
                new Student("Loic", 28, "loic@something.com"),
                new Student("Ryma", 26, "ryma@something.com"),
                new Student("Teddy", 30, "teddy@something.com"),
                new Student("Anthony", 20, "anthony@something.com"));
    }

    @Test
    void getStudentAverageAgeTest() {
        List<Student> savedStudents = studentRepository.saveAll(students);
        Assertions.assertNotNull(savedStudents);
        Assertions.assertEquals(savedStudents.stream().mapToInt(Student::getAge).average(), studentService.getStudentAverageAge(savedStudents));
    }
}
