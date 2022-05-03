package com.example.wajavaw2.service;

import com.example.wajavaw2.exception.StudentSaveFailureException;
import com.example.wajavaw2.model.Student;
import com.example.wajavaw2.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getStudents() {
        return this.studentRepository.findAll();
    }

    public List<Student> createMultipleStudents(List<Student> students) {
        return this.studentRepository.saveAll(students);
    }

    public Student createStudent(Student student) {
        return this.studentRepository.save(student);
    }

    public Student getStudentByEmail(String email) {
        return this.studentRepository.findByEmail(email);
    }

    public Optional<Student> updateStudentEmail(Long id, String email) {
        try {
            return this.studentRepository.findById(id).map(student -> {
                student.setEmail(email);
                return this.studentRepository.save(student);
            });
        } catch (Exception e) {
            throw new StudentSaveFailureException();
        }
    }
}
