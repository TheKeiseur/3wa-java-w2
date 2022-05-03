package com.example.wajavaw2.services;

import com.example.wajavaw2.models.Teacher;
import com.example.wajavaw2.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;

    public List<Teacher> getTeachers() {
        return this.teacherRepository.findAll();
    }

    public Teacher createTeacher(Teacher teacher) {
        return this.teacherRepository.save(teacher);
    }
}
