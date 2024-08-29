package com.SpringBoot.JPADemo;

import com.SpringBoot.JPADemo.Dao.StudentDao;
import com.SpringBoot.JPADemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.*;

@SpringBootApplication
public class JpaDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDao studentDao) {
        return runner -> {

//            createStudent(studentDao);
            createMultipleStudents(studentDao);
//            readStudent(studentDao);
            readAllStudents(studentDao);
//            findStudentByLastName(studentDao);
//            updateStudent(studentDao);
//            deleteStudent(studentDao);
//            deleteAllStudents(studentDao);
        };
    }

    private void deleteAllStudents(StudentDao studentDao) {
        int rowsDeleted = studentDao.deleteAll();
        System.out.println("No of Rows Deleted: "+rowsDeleted);
    }

    private void deleteStudent(StudentDao studentDao) {
        int id  = 7;
        System.out.println("Student Deleting: "+studentDao.findById(id));
        studentDao.delete(id);
    }

    private void updateStudent(StudentDao studentDao) {
        int id = 7;
        System.out.println("The student with id: "+id);
        Student student = studentDao.findById(id);
        System.out.println(student);

        System.out.println("Updating the Student FirstName to Sweety");
        student.setFirstName("Sweety");
        studentDao.update(student);

        System.out.println("Updated Student............");
        System.out.println(studentDao.findById(id));
    }

    private void findStudentByLastName(StudentDao studentDao) {
        List<Student> studentList = studentDao.findByLastName("Sai");
        studentList.forEach(System.out::println);
    }

    private void readAllStudents(StudentDao studentDao) {
        List<Student> studentList = studentDao.getAllStudents();
        studentList.forEach(System.out::println);
    }

    private void readStudent(StudentDao studentDao) {
        System.out.println("Creating 3 new Student .....");
        Student student1 = new Student("Harika","Sai","viswa@reddy.com");

        System.out.println("Saving the created student......");
        studentDao.save(student1);

        System.out.println("Saved Student ID: " +student1.getId());

        System.out.println("Retrieving the student with id: "+student1.getId());

        Student student = studentDao.findById(student1.getId());

        System.out.println("Student Founded: "+student);
    }

    private void createMultipleStudents(StudentDao studentDao) {
        //create student
        System.out.println("Creating 3 new Student .....");
        Student student1 = new Student("Viswa","Sai","viswa@reddy.com");
        Student student2 = new Student("Vamsi","Krishna","vamsi@reddy.com");
        Student student3 = new Student("Gowtham","Sagar","gowtham@reddy.com");

        System.out.println("Saving the created student......");
        studentDao.save(student1);
        studentDao.save(student2);
        studentDao.save(student3);

    }

    private void createStudent(StudentDao studentDao) {
        //create student
        System.out.println("Creating new Student .....");
		Student student = new Student("Viswa","Sai","viswa@sai.com");

        //save student
        System.out.println("Saving the created student......");
		studentDao.save(student);

        //get the saved student ID
        System.out.println("Saved Student ID: " +student.getId());
    }
}
