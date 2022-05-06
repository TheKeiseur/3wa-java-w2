package com.example.wajavaw2.service;

import com.example.wajavaw2.model.Subject;
import com.example.wajavaw2.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectService {

    @Autowired
    SubjectRepository subjectRepository;

    public Subject createSubject(Subject subject) {
        try {
            return subjectRepository.save(subject);
        } catch (RuntimeException ex) {
            throw new RuntimeException();
        }
    }
}
