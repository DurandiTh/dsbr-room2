package com.dailycodework.dsbrroom2.controller;

import com.dailycodework.dsbrroom2.exception.DTO;
import com.dailycodework.dsbrroom2.model.Student;
import com.dailycodework.dsbrroom2.service.IStudentService;
import com.dailycodework.dsbrroom2.service.StudentNotFoundException;
import com.dailycodework.dsbrroom2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="api/v1/student")
@CrossOrigin("http://localhost:3000")

public class StudentController {
    @Autowired
    private IStudentService studentService;


    @GetMapping("/getUser")
    public List<Student> getStudents() {

        return studentService.getStudents();
    }



    @PostMapping("/saveUser")
    public Student addStudent(@RequestBody Student student){

        return studentService.addStudent(student);
    }




//    @PutMapping("/update/{id}")
//    public Student updateStudent(@RequestBody Student student, @PathVariable Long id){
//        return studentService.updateStudent(student, id);
//    }

//    @PutMapping("/update/{id}")
//    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student updatedStudent) {
//        Student student = studentService.updateStudent(id, updatedStudent);
//        return ResponseEntity.ok(student);
//    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) throws StudentNotFoundException {
        studentService.deleteStudent(id);
        return ResponseEntity.ok("Student with ID " + id + " has been deleted successfully.");
    }

   //31start
//    @PutMapping("/update/{id}")
//    public String updateStudent(@PathVariable Long id, @RequestBody Student student) {
//        // Logic to update the resource with given ID in the database
//
//       // return "Resource with ID " + id + " updated successfully";
//        return String.valueOf(studentService.updateStudent(student));
//    }
    //31 end

    @PutMapping("/updateUser/{id}")
    public Student updateUser(@RequestBody Student student){
        return studentService.updateUser(student);
    }



    @GetMapping("/getUser/{id}")
    public Student getStudentById(@PathVariable Long id){
        return studentService.getStudentById(id);
    }


}