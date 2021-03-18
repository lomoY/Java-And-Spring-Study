package com.lomoy.javaandspring.exceptionhandler;

import org.springframework.stereotype.Service;

@Service
public class StudentService {

    public Student getStudentById(String id){
        Student student = new Student();
        student.setName("demo student name");
        student.setAge("foo student age");
        student.setId("foo student id");
//        throw new StudentServiceException("foo exception");
        return student;
    }
}
