package com.myorg.SMS.controller;

import com.myorg.SMS.dto.StudentReq;
import com.myorg.SMS.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping
    public ResponseEntity<?> addStudent(@RequestBody StudentReq studentReq) {
        return new ResponseEntity<>(studentService.addStudent(studentReq), HttpStatusCode.valueOf(201));
    }

    @GetMapping
    public ResponseEntity<?> getAllStudents() {
        return new ResponseEntity<>(studentService.getAllStudents(), HttpStatusCode.valueOf(200));
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<?> getStudent(@PathVariable Integer studentId) {
        return new ResponseEntity<>(studentService.getStudent(studentId), HttpStatusCode.valueOf(200));
    }

    @PutMapping("/{studentId}")
    public ResponseEntity<?> updateStudent(@PathVariable Integer studentId, @RequestBody StudentReq studentReq) {
        return new ResponseEntity<>(studentService.updateStudent(studentReq, studentId), HttpStatusCode.valueOf(200));
    }

    @PutMapping("/joincourse/{studentId}")
    public ResponseEntity<?> updateStudent(@PathVariable Integer studentId, @RequestParam Integer courseId) {
        return new ResponseEntity<>(studentService.addStudentCourse(studentId, courseId), HttpStatusCode.valueOf(200));
    }

    @DeleteMapping("/{studentId}")
    public ResponseEntity<?> removeStudent(@PathVariable Integer studentId) {
        studentService.removeStudent(studentId);
        return new ResponseEntity<>(HttpStatusCode.valueOf(200));
    }
}
