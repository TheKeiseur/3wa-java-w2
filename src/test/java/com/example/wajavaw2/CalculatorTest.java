package com.example.wajavaw2;

import com.example.wajavaw2.controller.StudentController;
import com.example.wajavaw2.model.Student;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;


@RunWith(JUnit4.class)
public class CalculatorTest {
    Calculator calculator;

    @Before
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("Simple multiplication should work")
    public void testMultiply() {
        assertEquals(20, calculator.multiply(4, 5));
    }

    @Test
    public void isAdultTest() {
        Student student = new Student("Kevin", 22, "kevin@something.com");
        Assert.assertTrue(calculator.isAdult(student));
    }
}