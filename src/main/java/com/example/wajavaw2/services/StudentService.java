package com.example.wajavaw2.services;

import com.example.wajavaw2.models.Student;
import com.example.wajavaw2.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getStudents() {
        return this.studentRepository.findAll();
    }

    public List<Student> createStudent(List<Student> students) {
        return this.studentRepository.saveAll(students);
    }
}
