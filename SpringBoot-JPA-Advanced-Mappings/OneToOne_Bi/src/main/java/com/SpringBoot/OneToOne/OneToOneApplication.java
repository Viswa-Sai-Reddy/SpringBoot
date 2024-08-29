package com.SpringBoot.OneToOne;

import com.SpringBoot.OneToOne.dao.AppDAO;
import com.SpringBoot.OneToOne.entity.Instructor;
import com.SpringBoot.OneToOne.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OneToOneApplication {

	public static void main(String[] args) {
		SpringApplication.run(OneToOneApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner -> {
//			createInstructor(appDAO);
//			findInstructor(appDAO);
//			deleteInstructor(appDAO);
//			findInstructorDetailById(appDAO);
			deleteInstructorDetailById(appDAO);
		};
	}

	private void deleteInstructorDetailById(AppDAO appDAO) {
		int id = 2;

		System.out.println("deleting InstructorDetail by id:"+id);
		appDAO.deleteInstructorDetailById(id);
		System.out.println("Done...!");
	}

	private void findInstructorDetailById(AppDAO appDAO) {
		int id = 2;
		InstructorDetail instructorDetail = appDAO.findInstructorDetailById(id);

		System.out.println("InstructorDetail with id:"+id);
		System.out.println(instructorDetail);
		System.out.println("Instructor:"+instructorDetail.getInstructor());
	}

	private void deleteInstructor(AppDAO appDAO){
		int id=2;
		appDAO.deleteInstructor(id);
		System.out.println("successfully deleted instructor with id:"+id);
	}

	private void findInstructor(AppDAO appDAO) {
		int id = 2;
		Instructor tempinstructor = appDAO.findInstructorById(id);

		System.out.println("Finding Instructor By ID: "+id);
		System.out.println(tempinstructor);
		System.out.println("Getting Instructor Details:"+tempinstructor.getInstructorDetail());
	}

	private void createInstructor(AppDAO appDAO) {
//		//Create Instructor
//		Instructor instructor = new Instructor("Viswa","sai","viswa@gmail.com");
//
//		//Create InstructorDetail
//		InstructorDetail instructorDetail = new InstructorDetail("https://youtube/viswa","Playing Video Games");

		Instructor instructor = new Instructor("Rachitha","Bapathu","rachitha@gmail.com");

		//Create InstructorDetail
		InstructorDetail instructorDetail = new InstructorDetail("https://youtube/Bapathu","Cooking");


		//associate the objects
		instructor.setInstructorDetail(instructorDetail);

		//save the instructor
		System.out.println("Saving instructor"+instructor);
		appDAO.save(instructor);
	}

}
