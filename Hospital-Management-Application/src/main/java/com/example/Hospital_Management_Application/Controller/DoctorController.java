package com.example.Hospital_Management_Application.Controller;

import com.example.Hospital_Management_Application.Model.Doctor;

import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import java.util.*;

//@Controller --> it is a controller class.it contains the APIs. it is the starting or entry point where our request comes to.
//@ResponseBody --> sends response back to the user.
@RestController
@RequestMapping("/doctor/apis") // --> it maps the frontend request coming to the corresponding controller class based on URLs.
public class DoctorController {

    Map<Integer,Doctor> doctorMapDb = new HashMap<>();
//    1-->{1,Ajay,Cardiologist,Male,ajay123@gmail.com}
//    2-->{2,Vijay,Cardiologist,Male,vijay123@gmail.com}
//    3-->{3,Sanjay,Cardiologist,Male,sanjay123@gmail.com}

    @PostMapping("/save")
    public String setDoctor(@RequestBody Doctor doctor){
        doctorMapDb.put(doctor.getId(),doctor);
        System.out.println(doctor);
        return "Doctor saved successfully!!!";
    }

    @GetMapping("/getDoctors")
    public Map<Integer,Doctor> allDoctor(){
        return doctorMapDb;
    }

    //@PathVariable - it takes the input in the url path and endpoint
    @GetMapping("/find/{id}")
    public Doctor getId(@PathVariable int id){
        Doctor doctor = doctorMapDb.get(id);
        return doctor;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteDoctorByID(@PathVariable int id){
        doctorMapDb.remove(id);
        return "Doctor removed successfully!!!";
    }


}
