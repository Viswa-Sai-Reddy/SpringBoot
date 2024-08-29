package com.SpringBoot.JPADemo.Dao;

import com.SpringBoot.JPADemo.entity.Student;
import java.util.*;

public interface StudentDao {

    void save(Student theStudent);

    Student findById(Integer id);

    List<Student> getAllStudents();

    List<Student> findByLastName(String lastName);

    void update(Student student);

    void delete(Integer id);

    int deleteAll();
}
