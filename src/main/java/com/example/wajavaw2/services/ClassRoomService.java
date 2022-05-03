package com.example.wajavaw2.services;

import com.example.wajavaw2.models.ClassRoom;
import com.example.wajavaw2.repository.ClassRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassRoomService {

    @Autowired
    private ClassRoomRepository classRoomRepository;

    public List<ClassRoom> getClassRooms() {
        return this.classRoomRepository.findAll();
    }

    public ClassRoom createClassRoom(ClassRoom classRoom) {
        return this.classRoomRepository.save(classRoom);
    }
}
