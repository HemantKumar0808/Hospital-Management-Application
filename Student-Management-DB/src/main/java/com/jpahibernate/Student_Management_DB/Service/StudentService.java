package com.jpahibernate.Student_Management_DB.Service;

import com.jpahibernate.Student_Management_DB.Model.Student;
import com.jpahibernate.Student_Management_DB.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public String addStudent(Student student){
        studentRepository.save(student);
        return "Student saved successfully";
    }

    public Student getStudentById(int id){
       Optional<Student> studentOptional = studentRepository.findById(id);
       if(studentOptional.isPresent()){
           return studentOptional.get();
       }else{
           return null;
       }
    }

    public List<Student> getAllStudent(){
        List<Student> studentList = studentRepository.findAll();
        return studentList;
    }

    public String deleteById(int id){
        studentRepository.deleteById(id);
        return "Student deleted Successfully";
    }

    public String countStudents(){
        long totalCount = studentRepository.count();
        return "Total students paresent are : " + totalCount;
    }

    public String updateStudentUsingPut(int id, Student newStudentRequest){
        // find student with id
        // if student is present, update it
        // else we cannot update

        Student existingStudent = getStudentById(id);
        if(existingStudent != null){
            //proceed to update
            studentRepository.save(newStudentRequest);
            return "Student updated Successfully";
        }else{
            //cannot update
            return "Student not found, hence cannot update";
        }
    }

    public String updateStudentEmailUsingPatch(int id, String newEmail){
        // find student with id
        // if student is present, update it
        // else we cannot update

        Student exisitingStudent = getStudentById(id);
        if(exisitingStudent!=null){
            // proceed to update
            exisitingStudent.setEmail(newEmail);
            studentRepository.save(exisitingStudent);
            return "Student updated successfully!";
        }else{
            // cannot update
            return "Student not found, hence cannot update!";
        }
    }


}
