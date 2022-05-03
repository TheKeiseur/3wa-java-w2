package com.example.wajavaw2.service;

import com.example.wajavaw2.model.Student;
import com.example.wajavaw2.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Email;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getStudents() {
        return this.studentRepository.findAll();
    }

    public List<Student> createStudents(List<Student> students) {
        return this.studentRepository.saveAll(students);
    }

    public Student createStudent(Student student) {
        return this.studentRepository.save(student);
    }

    public Student getStudentByEmail(String email) {
        return this.studentRepository.findByEmail(email);
    }
}
