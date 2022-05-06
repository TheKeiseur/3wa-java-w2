package com.example.wajavaw2.controller;

import com.example.wajavaw2.model.Student;
import com.example.wajavaw2.model.Subject;
import com.example.wajavaw2.service.StudentService;
import com.example.wajavaw2.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/management")
public class StudentController {

    @Autowired
    StudentService studentService;

    @Autowired
    SubjectService subjectService;

    @PostMapping("/students")
    public ResponseEntity<Student> create(@Valid @RequestBody Student payload) throws URISyntaxException {
        final Student savedStudent = studentService.create(payload);
        final URI uri = new URI("/students/" + savedStudent.getId());

        return ResponseEntity
                .created(uri)
                .body(savedStudent);
    }

    @GetMapping("/students")
    public ResponseEntity<Object> getAllStudents() {
        return ResponseEntity.ok(studentService.getAll());
    }

    @GetMapping("/students/{email}")
    @ResponseBody
    public ResponseEntity<Object> getStudentByEmail(@PathVariable String email) {
        return ResponseEntity.ok(studentService.getOne(email));
    }

    @PutMapping("/students/{id}")
    public ResponseEntity<Object> updateStudentEmail(@PathVariable Long id, @RequestBody Student payload) {
        return studentService.updateStudentEmail(id, payload);
    }

    @PostMapping("/students/multiple")
    public ResponseEntity<List<Student>> createMultipleStudents(@RequestBody List<Student> payload) {
        return ResponseEntity.ok(studentService.createMultipleStudents(payload));
    }

    @GetMapping("/students/average")
    public ResponseEntity<OptionalDouble> getStudentAverageAge() {
        return ResponseEntity.ok(studentService.getStudentAverageAge(studentService.getAll()));
    }

    public ResponseEntity<List<Student>> filterBySubject(Subject targetSubject) {
        List<Student> filteredList = studentService.getAll()
                .stream().filter(student -> student.getSubjects().contains(targetSubject)).collect(Collectors.toList());
        return ResponseEntity.ok(filteredList);
    }

}
