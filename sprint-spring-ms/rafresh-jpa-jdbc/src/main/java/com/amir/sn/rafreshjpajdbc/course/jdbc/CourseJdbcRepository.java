package com.amir.sn.rafreshjpajdbc.course.jdbc;

import com.amir.sn.rafreshjpajdbc.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJdbcRepository {
    @Autowired
    private JdbcTemplate springJdbcTemplate;
    private static String INSERT_QUERY =
            """
                insert into course(id, name, author)
                values (?, ?, ?);
            """;

    public static String DELETE_QUERY =
            """
                DELETE FROM course WHERE id = ?;
            """;

    public static String SELECT_QUERY =
            """
                SELECT * FROM course WHERE id = ?;
            """;

    public void insert(Course course){
        springJdbcTemplate.update(INSERT_QUERY, course.getId(), course.getName(), course.getAuthor());
    }

    public void deleteById(Long id){
        springJdbcTemplate.update(DELETE_QUERY, id);
    }

    public Course findById(Long id){
        return springJdbcTemplate.queryForObject(SELECT_QUERY,
                new BeanPropertyRowMapper<>(Course.class), id);
    }


}
