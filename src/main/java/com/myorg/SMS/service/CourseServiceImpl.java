package com.myorg.SMS.service;

import com.myorg.SMS.dto.CourseReq;
import com.myorg.SMS.model.Course;
import com.myorg.SMS.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@Component
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseRepository courseRepository;

    @Override
    public Course addCourse(CourseReq courseReq) {
        Course course = new Course();
        course.setName(courseReq.getName());

        return courseRepository.save(course);
    }

    @Override
    public Course getCourse(Integer courseId) {
        return courseRepository.findById(courseId).orElse(null);
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course updateCourse(CourseReq courseReq, Integer courseId) {
        Course course = new Course();
        course.setId(courseId);
        course.setName(courseReq.getName());

        return courseRepository.save(course);
    }

    @Override
    public void removeCourse(Integer courseId) {
        courseRepository.deleteById(courseId);
    }

    @Scheduled(fixedRate = 1000*60*5)
    public void runEveryFiveMin() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");

        Course course = new Course();
        course.setName("ABC" + dateFormat.format(new Date()));

        courseRepository.save(course);
    }
}
