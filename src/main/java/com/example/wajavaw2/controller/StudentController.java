package com.example.wajavaw2.controller;

import com.example.wajavaw2.model.Student;
import com.example.wajavaw2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping
    ResponseEntity<Student> createStudent(@Valid @RequestBody Student student) {
        return ResponseEntity.ok(this.studentService.createStudent(student));
    }

    @GetMapping
    ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok(this.studentService.getStudents());
    }

    @GetMapping("/{email}")
    @ResponseBody
    ResponseEntity<Student> getStudentByEmail(@PathVariable String email) {
        return ResponseEntity.ok(this.studentService.getStudentByEmail(email));
    }
}
