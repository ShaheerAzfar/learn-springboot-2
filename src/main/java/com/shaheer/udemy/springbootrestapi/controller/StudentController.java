package com.shaheer.udemy.springbootrestapi.controller;

import com.shaheer.udemy.springbootrestapi.bean.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
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
    @GetMapping("students/{id}/{first-name/{last-name}")
    public Student studentPathVariable(@PathVariable int id,
                                       @PathVariable("first-name") String firstName,
                                       @PathVariable("last-name") String lastName){
        return new Student(id, firstName, lastName);
    }

    // Rest API with Request Parameter
    // http:localhost:8080/students/query?id=1&firstName=Shaheer&lastName=Azfar
    @GetMapping("students/query")
    public Student studentRequestVariable(@RequestParam int id,
                                          @RequestParam String firstName,
                                          @RequestParam String lastName){
        return new Student(id,firstName,lastName);
    }
}
