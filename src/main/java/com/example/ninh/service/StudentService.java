package com.example.ninh.service;


import com.example.ninh.entity.StudentEntity;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    StudentEntity  save(StudentEntity s);

    Optional<StudentEntity> findById(Integer integer);

    Iterable<StudentEntity> findAll();

    void deleteById(Integer integer);
//    StudentEntity createStudent(StudentEntity student);
//    List<StudentEntity> getAllStudent();
//    StudentEntity getStudentByID(int id);
//    List<StudentEntity> getStudentByName(String name);
//    public void DeleteByid(Integer id);
}
