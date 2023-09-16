package com.shaheer.udemy.springbootrestapi.controller;

import com.shaheer.udemy.springbootrestapi.bean.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
public class StudentController {

    //this method is to depict how to send java bean as json
    @GetMapping("/student")
    public Student getStudent(){
        return new Student(
                1,
                "Shaheer",
                "Azfar"
        );
    }

    //this method is to depict how to send list as json
    @GetMapping("students")
    public List<Student> getStudents(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(1,"Zaid","Ali"));
        students.add(new Student(2,"Shamaila","Zainab"));
        students.add(new Student(3,"Hassan","Ali"));
        return students;
    }

    // Rest API with Path Variable
    @GetMapping("students/{id}")
    public Student studentPathVariable(@PathVariable int id){
        return new Student(id, "Shaheer","Azfar");
    }
}
