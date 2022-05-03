package com.example.wajavaw2.controller;

import com.example.wajavaw2.models.ClassRoom;
import com.example.wajavaw2.models.Student;
import com.example.wajavaw2.models.Teacher;
import com.example.wajavaw2.services.ClassRoomService;
import com.example.wajavaw2.services.TeacherService;
import com.example.wajavaw2.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class ClasseController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private ClassRoomService classRoomService;

    @GetMapping("/student")
    public List<Student> createStudent() {
        Student student1 = new Student();
        student1.setName("John");
        student1.setAge(22);
        Student student2 = new Student();
        student2.setName("Alice");
        student2.setAge(23);

        Teacher teacher = new Teacher();
        teacher.setLastName("Jackson");
        this.teacherService.createTeacher(teacher);

        ClassRoom classeJava = new ClassRoom();
        classeJava.setDescription("This is a java class");
        classeJava.setTeacher(teacher);

        student1.setClassRoom(classeJava);
        student2.setClassRoom(classeJava);
        List<Student> students = Arrays.asList(student1, student2);
        classeJava.setStudents(students);

        this.classRoomService.createClassRoom(classeJava);

        return students;
    }
}
