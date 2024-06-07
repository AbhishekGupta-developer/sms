package com.myorg.SMS.service;

import com.myorg.SMS.dto.CourseReq;
import com.myorg.SMS.model.Course;

import java.util.List;

public interface CourseService {
    Course addCourse(CourseReq courseReq);
    Course getCourse(Integer courseId);
    List<Course> getAllCourses();
    Course updateCourse(CourseReq courseReq, Integer courseId);
    void removeCourse(Integer courseId);
}
