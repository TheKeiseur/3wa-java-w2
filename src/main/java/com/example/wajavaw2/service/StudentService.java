package com.example.wajavaw2.service;

import com.example.wajavaw2.exception.StudentRegistrationFailedException;
import com.example.wajavaw2.model.Student;
import com.example.wajavaw2.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student create(Student payload) {
        try {
            return studentRepository.save(payload);
        }
        catch (RuntimeException e) {
            throw new StudentRegistrationFailedException("It's not the error you are looking for");
        }
    }

    public Student getOne(String email) {
        try {
            final Optional<Student> optionalStudent = studentRepository.findByEmail(email);

            if (optionalStudent.isEmpty()) {
                throw new RuntimeException();
            }

            return optionalStudent.get();
        }
        catch (RuntimeException e) {
            throw new StudentRegistrationFailedException("That's not the error you are looking for");
        }
    }

    public List<Student> getAll() {
        try {
            List<Student> students = studentRepository.findAll();

            if (students.size() == 0) {
                throw new RuntimeException();
            }

            return students;
        }
        catch (RuntimeException e) {
            throw new StudentRegistrationFailedException("That's not the error you are looking for");
        }
    }

    public ResponseEntity<Object> updateStudentEmail(Long id, Student payload) {
        try {
            final Optional<Student> optionalStudent = this.studentRepository.findById(id);

            if (optionalStudent.isEmpty()) {
                throw new StudentRegistrationFailedException("That's not the error you are looking for");
            }

            final Optional<Object> finalStudent = optionalStudent.map((Student student) -> {
                student.setEmail(payload.getEmail());
                return this.studentRepository.save(student);
            });

            return ResponseEntity.ok(finalStudent);
        }
        catch (RuntimeException e) {
            throw new StudentRegistrationFailedException("That's not the error you are looking for");
        }
    }

    public Optional<Student> getStudentById(Long id) {
        try {
            return studentRepository.findById(id);
        } catch (RuntimeException ex) {
            throw new StudentRegistrationFailedException("Message");
        }
    }

    public List<Student> createMultipleStudents(List<Student> students) {
        try {
            return studentRepository.saveAll(students);
        } catch (RuntimeException ex) {
            throw new StudentRegistrationFailedException("Error during student registration");
        }
    }

    public OptionalDouble getStudentAverageAge(List<Student> students) {
        try {
            return students.stream().mapToInt(Student::getAge).average();
        } catch (RuntimeException ex) {
            throw new RuntimeException(ex);
        }
    }
}
