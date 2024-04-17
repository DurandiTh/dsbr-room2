package com.dailycodework.dsbrroom2.service;

import com.dailycodework.dsbrroom2.exception.DTO;
import com.dailycodework.dsbrroom2.exception.StudentAlreadyExistException;
import com.dailycodework.dsbrroom2.exception.StudentNotFountException;
import com.dailycodework.dsbrroom2.model.Student;
import com.dailycodework.dsbrroom2.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class StudentService implements IStudentService{
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<StudentAlreadyExistException> getAllStudents(){
        List<Student>userList=studentRepository.findAll();
        return modelMapper.map(userList,new TypeToken<List<StudentAlreadyExistException>>(){}.getType());
    }


    @Override
    public Student addStudent(Student student) throws StudentAlreadyExistException {
        if(studentAlreadyExists(student.getEmail())){
            throw new StudentAlreadyExistException(student.getEmail()+" already exists!");
        }

        return studentRepository.save(student);
    }

    private boolean studentAlreadyExists(String email) {
        return studentRepository.findByEmail(email).isPresent();
    }

    @Override
    public List<Student> getStudents() {

        List<Student>userList=studentRepository.findAll();
        return modelMapper.map(userList,new TypeToken<List<DTO>>(){}.getType());
    }

    @Override
    public Student updateStudent(Student student) {
        return null;
    }

//31strat
//    public Student updateStudent(Student student) {
//        return null;
//    }
    //31end

//    @Override
//    public Student updateStudent(Student student, Long id) {
//        return null;
//    }
public List<Student> saveProducts(List<Student> students) {
    return studentRepository.saveAll(students);
}

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).
                orElseThrow(()-> new StudentNotFountException("sorry, no student found with the Id:" +id));
    }





    //now
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Student findById(Integer id) {
        return null;
    }

//31start
//    public Student updateStudent(Long id, Student updatedStudent) throws StudentNotFoundException {
//        Student existingStudent = studentRepository.findById(id)
//                .orElseThrow(() -> new StudentNotFoundException("Student not found with id: " + id));
//
//        existingStudent.setFirstName(updatedStudent.getFirstName());
//        existingStudent.setLastName(updatedStudent.getLastName());
//
//        existingStudent.setEmail(updatedStudent.getEmail());
//        existingStudent.setDepartment(updatedStudent.getDepartment());
//
//        return studentRepository.save(existingStudent);
//    }
    //31end

    public Student updateUser(Student student){
        studentRepository.save(modelMapper.map(student,Student.class));
        return student;
    }

    }
