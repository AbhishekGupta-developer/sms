package com.myorg.SMS.service;

import com.myorg.SMS.dto.StudentReq;
import com.myorg.SMS.model.Student;

import java.util.List;

public interface StudentService {
    Student addStudent(StudentReq studentReq);
    Student getStudent(Integer studentId);
    List<Student> getAllStudents();
    Student updateStudent(StudentReq studentReq, Integer studentId);
    Student addStudentCourse(Integer studentId, Integer courseId);
    void removeStudent(Integer studentId);
}
