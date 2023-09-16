package com.shaheer.udemy.springbootrestapi.controller;

import com.shaheer.udemy.springbootrestapi.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    //Rest API that handles POST Request - create new resource
    //@PostMapping and @RequestBody
    @PostMapping("students/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student){
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;
    }

    // Rest API that handles PUT Request - updating existing resource
    @PutMapping("students/{id}/update")
    public Student updateStudent(@RequestBody Student student,@PathVariable("id") int studentId){
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;
    }

    // Rest API that handles Delete Request
    @DeleteMapping("students/{id}/delete")
    public String deleteStudent(@PathVariable("id") int studentId){
        System.out.println(studentId);
        return "Student Deleted Successfully";
    }
}
