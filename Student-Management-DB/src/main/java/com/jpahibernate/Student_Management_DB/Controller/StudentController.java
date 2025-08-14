package com.jpahibernate.Student_Management_DB.Controller;

import com.jpahibernate.Student_Management_DB.Model.Student;
import com.jpahibernate.Student_Management_DB.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Controller
//@ResponseBody

@RestController
@RequestMapping("/student/apis")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/save")
    public String saveStudent(@RequestBody Student student){
        String response = studentService.addStudent(student);
        return response;
    }

    @GetMapping("/find/{id}")
    public Student findStudentById(@PathVariable int id){
        Student student = studentService.getStudentById(id);
        return student;
    }

    @GetMapping("/findAll")
    public List<Student> findAllStudent(){
        return studentService.getAllStudent();
    }

    @DeleteMapping("/delete/{id}")
    public String deleteStudentById(@PathVariable int id){
        String response = studentService.deleteById(id);
        return response;
    }

    @GetMapping("/count")
    public String countTotalStudents(){
        String response = studentService.countStudents();
        return response;
    }

    @PutMapping("/updatePut/{id}")
    public String updateStudentUsingPut(@PathVariable int id,@RequestBody Student newStudentRequest){
        String response = studentService.updateStudentUsingPut(id,newStudentRequest);
        return response;
    }

    @PatchMapping("/updatePatch/{id}")
    public String updateStudentEmailUsingPatch(@PathVariable int id,@RequestParam String newEmail){
        String response = studentService.updateStudentEmailUsingPatch(id,newEmail);
        return response;
    }
}
