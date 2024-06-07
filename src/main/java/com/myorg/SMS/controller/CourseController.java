package com.myorg.SMS.controller;

import com.myorg.SMS.dto.CourseReq;
import com.myorg.SMS.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    CourseService courseService;

    @PostMapping
    public ResponseEntity<?> addCourse(@RequestBody CourseReq courseReq) {
        return new ResponseEntity<>(courseService.addCourse(courseReq), HttpStatusCode.valueOf(201));
    }

    @GetMapping
    public ResponseEntity<?> getAllCourses() {
        return new ResponseEntity<>(courseService.getAllCourses(), HttpStatusCode.valueOf(200));
    }

    @GetMapping("/{courseId}")
    public ResponseEntity<?> getCourse(@PathVariable Integer courseId) {
        return new ResponseEntity<>(courseService.getCourse(courseId), HttpStatusCode.valueOf(200));
    }

    @PutMapping("/{courseId}")
    public ResponseEntity<?> updateCourse(@PathVariable Integer courseId, @RequestBody CourseReq courseReq) {
        return new ResponseEntity<>(courseService.updateCourse(courseReq, courseId), HttpStatusCode.valueOf(200));
    }

    @DeleteMapping("/{courseId}")
    public ResponseEntity<?> removeCourse(@PathVariable Integer courseId) {
        courseService.removeCourse(courseId);
        return new ResponseEntity<>(HttpStatusCode.valueOf(200));
    }
}
