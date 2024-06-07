package com.myorg.SMS.service;

import com.myorg.SMS.dto.StudentReq;
import com.myorg.SMS.model.Student;
import com.myorg.SMS.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    StudentRepository studentRepository;

    @Override
    public Student addStudent(StudentReq studentReq) {
        Student student = new Student();
        student.setName(studentReq.getName());

        return studentRepository.save(student);
    }

    @Override
    public Student getStudent(Integer studentId) {
        return studentRepository.findById(studentId).orElse(null);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student updateStudent(StudentReq studentReq, Integer studentId) {
        Student student = new Student();
        student.setName(studentReq.getName());

        return studentRepository.save(student);
    }

    @Override
    public Student addStudentCourse(Integer studentId, Integer courseId) {
        Student student = studentRepository.findById(studentId).orElse(null);
        student.setCourseId(courseId);

        return studentRepository.save(student);
    }

    @Override
    public void removeStudent(Integer studentId) {
        studentRepository.deleteById(studentId);
    }
}
