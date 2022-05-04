package com.example.wajavaw2.service;

import com.example.wajavaw2.exception.StudentSaveFailureException;
import com.example.wajavaw2.model.Student;
import com.example.wajavaw2.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public ResponseEntity<Object> create(@RequestBody Student payload) throws URISyntaxException {
        try {
            final Student savedStudent = studentRepository.save(payload);
            final URI uri = new URI("/students/" + savedStudent.getId());

            return ResponseEntity
                    .created(uri)
                    .body(savedStudent);
        }
        catch (RuntimeException e) {
            return ResponseEntity.unprocessableEntity().build();
        }
    }

    public ResponseEntity<Object> getOne(String email) {
        try {
            final Optional<Student> optionalStudent = studentRepository.findByEmail(email);

            if (optionalStudent.isEmpty()) {
                return ResponseEntity.notFound().build();
            }

            return ResponseEntity.ok().body(optionalStudent.get());
        }
        catch (RuntimeException e) {
            return ResponseEntity.unprocessableEntity().build();
        }
    }

    public ResponseEntity<Object> getAll() {
        try {
            List<Student> students = studentRepository.findAll();

            if (students.size() == 0) {
                return ResponseEntity.notFound().build();
            }

            return ResponseEntity.ok().body(students);
        }
        catch (RuntimeException e) {
            return ResponseEntity.ok().body(List.of());
        }
    }

    public ResponseEntity<Object> updateStudentEmail(Long id, Student payload) {
        try {
            final Optional<Student> optionalStudent = this.studentRepository.findById(id);

            if (optionalStudent.isEmpty()) {
                throw new StudentSaveFailureException();
            }

            final Optional<Object> finalStudent = optionalStudent.map((Student student) -> {
                student.setEmail(payload.getEmail());
                return this.studentRepository.save(student);
            });

            return ResponseEntity.ok(finalStudent);
        }
        catch (RuntimeException e) {
            throw new StudentSaveFailureException();
        }
    }
}
