package com.SpringBoot.JPADemo.Dao;

import com.SpringBoot.JPADemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDao{
    //Define Entity Manager
    private EntityManager entityManager;

    //Inject Entity Manager using Constructor injection
    @Autowired
    public StudentDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class,id);
    }

    @Override
    public List<Student> getAllStudents() {
        TypedQuery<Student> query = entityManager.createQuery("From Student order by firstName",Student.class);
        return query.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        //create query
        TypedQuery<Student> query = entityManager.createQuery("From Student where lastName = :parameter",Student.class);
        //Set the parameter
        query.setParameter("parameter",lastName);
        //return the student list
        return query.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Student student = entityManager.find(Student.class,id);
        entityManager.remove(student);
    }

    @Override
    @Transactional
    public int deleteAll() {
        int deletedRows = entityManager.createQuery("DELETE FROM Student").executeUpdate();
        return deletedRows;
    }


}
