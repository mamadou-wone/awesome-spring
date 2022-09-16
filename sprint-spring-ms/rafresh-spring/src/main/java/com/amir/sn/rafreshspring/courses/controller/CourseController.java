package com.amir.sn.rafreshspring.courses.controller;

import com.amir.sn.rafreshspring.courses.been.Course;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class CourseController {

    // http:localhost:8080/courses
    @GetMapping("/courses")
    public List<Course> getAllCourses(){
    //    return Arrays.asList(new Course(1, "Lear Microservices", "Amir Boss"));
        ArrayList<Course> courseList = new ArrayList<>();
        courseList.add(new Course(8, "Lear Microservices", "Amir Boss"));
        courseList.add(new Course(4, "Lear Microservices", "Amir Boss"));
        return courseList;
    }

    // http:localhost:8080/courses/1
    @GetMapping("/course/1")
    public Course getCourse(){
        return new Course(3, "Lear Microservices", "Amir");
    }

}
