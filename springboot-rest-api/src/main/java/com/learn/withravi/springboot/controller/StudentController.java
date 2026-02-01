package com.learn.withravi.springboot.controller;

import com.learn.withravi.springboot.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/students/v1")
public class StudentController {

//localhost:8080/getStudent
//localhost:8080/getStudents
    @GetMapping("/student")
    public ResponseEntity<Student> getStudent(){
        Student student = new Student(1, "Ravi", "Kumar");
//        return new ResponseEntity<>(student, HttpStatus.OK);
//        return ResponseEntity.ok(student);
        return ResponseEntity.ok().header("custom-header", "ravi-kumar").body(student);
    }



    @GetMapping("/getStudents")
    public ResponseEntity<List<Student>> getStudents(){
        List<Student> listOfStudent =  List.of(
                new Student(1, "Ravi", "Kumar"),
                new Student(2, "Amit", "Sharma"),
                new Student(3, "Neha", "Singh"),
                new Student(4, "Priya", "Verma")
        );

        return ResponseEntity.ok().body(listOfStudent);
    }

    //localhost:8080/students/1
    @GetMapping("/{id}")
    public ResponseEntity<Student> studentPathVariable(@PathVariable("id") int studentId){
        Student student= new  Student(studentId, "Ravi", "Kumar");
        return ResponseEntity.ok().body(student);
    }

    //localhost:8080/students/query?id=1
    @GetMapping("/students")
    public ResponseEntity<Student> studentQueryParam(@RequestParam int id){
//        return new Student(id, "Ravi", "Kumar");
        return ResponseEntity.ok().body(new Student(id, "Ravi", "Kumar"));
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Student> studentPostMethod(@RequestBody Student student){
        return new  ResponseEntity<>(student, HttpStatus.CREATED);
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<Student> updateStudent(@PathVariable("id") int studentId, @RequestBody Student student){
        System.out.println(studentId);
        System.out.println(student);
        student.setId(studentId);
        return ResponseEntity.ok().body(student);
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") int studentId){
        System.out.println("Deleted student with id: " + studentId);
//        return "Deleted student with id: " + studentId;
        return ResponseEntity.ok().body("Deleted student with id: " + studentId);
    }


}
