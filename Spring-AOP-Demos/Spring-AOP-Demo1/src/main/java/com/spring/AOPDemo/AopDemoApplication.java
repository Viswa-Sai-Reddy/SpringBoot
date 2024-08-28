package com.spring.AOPDemo;

import com.spring.AOPDemo.dao.AccountDAO;
import com.spring.AOPDemo.dao.AccountDAOImpl;
import com.spring.AOPDemo.dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDao, MembershipDAO theMembershipDao){
		return runner -> {
			addingAccountBeforeAdvise(theAccountDao,theMembershipDao);
		};
	}

	private void addingAccountBeforeAdvise(AccountDAO theAccountDao, MembershipDAO theMembershipDao) {
		theAccountDao.addAccount(true);
		theMembershipDao.addMembershipAccount();
	}

}
