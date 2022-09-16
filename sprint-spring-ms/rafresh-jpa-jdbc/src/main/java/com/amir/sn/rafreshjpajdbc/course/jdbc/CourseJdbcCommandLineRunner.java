package com.amir.sn.rafreshjpajdbc.course.jdbc;

import com.amir.sn.rafreshjpajdbc.course.Course;
import com.amir.sn.rafreshjpajdbc.course.CourseJpaRepository;
import com.amir.sn.rafreshjpajdbc.course.CourseSpringDataJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner {

//    @Autowired
//    private CourseJdbcRepository repository;
//    @Autowired
//    private CourseJpaRepository repository;
    @Autowired
    private CourseSpringDataJpaRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.save(new Course(2L, "Lear DevOps", "Boss"));
   //     repository.insert(new Course(1L, "Lear Java", "Amir"));
//        repository.insert(new Course(1L, "Lear Java", "Amir"));
//        repository.insert(new Course(2L, "Lear DevOps", "Boss"));
//        System.out.println(repository.findById(2L));
        // repository.deleteById(1L);
    }
}
