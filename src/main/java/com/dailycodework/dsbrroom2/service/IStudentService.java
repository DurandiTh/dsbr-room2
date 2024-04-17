package com.dailycodework.dsbrroom2.service;

import com.dailycodework.dsbrroom2.model.Student;

import java.util.List;

public interface IStudentService {
    Student addStudent(Student student) ;
    List<Student> getStudents();
    Student updateStudent(Student student);
    Student getStudentById(Long id);

  //  void deleteStudent(Long id) throws StudentNotFoundException;
    void deleteStudent(Long id) throws StudentNotFoundException;


   // void delete(Student rm);

    Student findById(Integer id);

    List<Student> saveProducts(List<Student> products);

    Student updateUser(Student student);
}
