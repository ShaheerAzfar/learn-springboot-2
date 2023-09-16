package com.shaheer.udemy.springbootrestapi.controller;

import com.shaheer.udemy.springbootrestapi.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("students2")
public class StudentController2 {

    //this method is to depict how to send java bean as json
    @GetMapping("/student2")
    public ResponseEntity<Student> getStudent(){

        Student student = new Student(1, "Shaheer", "Azfar");

      //  return new ResponseEntity<>(student, HttpStatus.OK);
      //  return ResponseEntity.ok(student);
          return ResponseEntity.ok()
                  .header("custom-header","Shaheer")
                  .body(student);
    }

    //this method is to depict how to send list as json
    @GetMapping
    public ResponseEntity<List<Student>> getStudents(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(1,"Zaid","Ali"));
        students.add(new Student(2,"Shamaila","Zainab"));
        students.add(new Student(3,"Hassan","Ali"));
        return ResponseEntity.ok(students);
    }

    // Rest API with Path Variable
    @GetMapping("{id}/{first-name/{last-name}")
    public ResponseEntity<Student> studentPathVariable(@PathVariable int id,
                                       @PathVariable("first-name") String firstName,
                                       @PathVariable("last-name") String lastName){
        Student student = new Student(id, firstName, lastName);
        return ResponseEntity.ok(student);
    }

    // Rest API with Request Parameter
    // http:localhost:8080/students/query?id=1&firstName=Shaheer&lastName=Azfar
    @GetMapping("query")
    public ResponseEntity<Student> studentRequestVariable(@RequestParam int id,
                                          @RequestParam String firstName,
                                          @RequestParam String lastName){
        Student student = new Student(id,firstName,lastName);
        return ResponseEntity.ok(student);
    }

    //Rest API that handles POST Request - create new resource
    //@PostMapping and @RequestBody
    @PostMapping("create")
  //@ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    // Rest API that handles PUT Request - updating existing resource
    @PutMapping("{id}/update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student,@PathVariable("id") int studentId){
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return ResponseEntity.ok(student);
    }

    // Rest API that handles Delete Request
    @DeleteMapping("{id}/delete")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") int studentId){
        System.out.println(studentId);
        return ResponseEntity.ok("Student Deleted Successfully");
    }
}
