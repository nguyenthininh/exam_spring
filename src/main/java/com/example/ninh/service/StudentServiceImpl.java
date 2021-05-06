package com.example.ninh.service;

import com.example.ninh.entity.StudentEntity;
import com.example.ninh.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    StudentRepo studentRepo;


//    @Override
//    public StudentEntity createStudent(StudentEntity student) {
//        return null;
//    }
//
//    @Override
//    public List<StudentEntity> getAllStudent() {
//        return null;
//    }
//
//    @Override
//    public StudentEntity getStudentByID(int id) {
//        return null;
//    }
//
//    @Override
//    public List<StudentEntity> getStudentByName(String name) {
//        return null;
//    }
//
//    @Override
//    public void DeleteByid(Integer id) {
//
//    }

    @Override
    public StudentEntity  save(StudentEntity s) {
        return studentRepo.save(s);
    }

    @Override
    public Optional<StudentEntity> findById(Integer integer) {
        return studentRepo.findById(integer);
    }

    @Override
    public Iterable<StudentEntity> findAll() {
        return studentRepo.findAll();
    }

    @Override
    public StudentEntity createStudent(StudentEntity student) {
        StudentEntity studentEntity = studentRepo.save(student);
        return studentEntity;
    }

    @Override
    public void deleteById(Integer integer) {
        studentRepo.deleteById(integer);
    }


}

