package com.SpringDemo.REST_CURD.rest;

import com.SpringDemo.REST_CURD.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private List<Student> studentList;

    @PostConstruct
    public void buildData() {
        studentList = new ArrayList<>();
        studentList.add(new Student("Viswa","Sai"));
        studentList.add(new Student("Vamsi","Krishna"));
        studentList.add(new Student("Rachitha","Bapathu"));
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return studentList;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudentWithId(@PathVariable int studentId){

        //Checking the Student
        if((studentId >= studentList.size()) || (studentId < 0))
            throw new StudentNotFoundException("No Student found with Id: "+studentId);

        return studentList.get(studentId);
    }

}
