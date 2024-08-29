package com.SpringBoot.OneToOne.dao;

import com.SpringBoot.OneToOne.entity.Instructor;
import com.SpringBoot.OneToOne.entity.InstructorDetail;

public interface AppDAO {

    void save(Instructor theInstructor);

    Instructor findInstructorById(int id);

    void deleteInstructor(int id);

    InstructorDetail findInstructorDetailById(int id);

    void deleteInstructorDetailById(int id);
}
