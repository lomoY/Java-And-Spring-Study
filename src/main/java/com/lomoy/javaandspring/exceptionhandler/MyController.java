package com.lomoy.javaandspring.exceptionhandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    private StudentService studentService;
    @Autowired
    public MyController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping(path = "/{student}")
    public void getStudentId(){
        studentService.getStudentById("123");
        System.out.println("---------------------");
    }
}
