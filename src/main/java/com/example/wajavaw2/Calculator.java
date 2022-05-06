package com.example.wajavaw2;

import com.example.wajavaw2.model.Student;

public class Calculator {

    public int multiply(int a, int b) {
        return a * b;
    }

    public boolean isAdult(Student student) {
        final Student tempStudent = new Student(student.getName(), student.getAge(), student.getEmail());
        return tempStudent.getAge() >= 18;
    }
}
