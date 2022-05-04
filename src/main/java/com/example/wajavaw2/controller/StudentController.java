package com.example.wajavaw2.controller;

import com.example.wajavaw2.model.Student;
import com.example.wajavaw2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URISyntaxException;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping
    public ResponseEntity<Object> createStudent(@Valid @RequestBody Student student) throws URISyntaxException {
        return ResponseEntity.ok(this.studentService.create(student));
    }

    @GetMapping
    public ResponseEntity<Object> getAllStudents() {
        return ResponseEntity.ok(this.studentService.getAll());
    }

    @GetMapping("/{email}")
    @ResponseBody
    public ResponseEntity<Object> getStudentByEmail(@PathVariable String email) {
        return ResponseEntity.ok(this.studentService.getOne(email));
    }

    @PutMapping("/{id}")
    ResponseEntity<Object> updateStudentEmail(@PathVariable Long id, @RequestBody Student payload) {
        return this.studentService.updateStudentEmail(id, payload);
    }
}
