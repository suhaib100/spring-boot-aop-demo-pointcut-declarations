package com.luv2code.aopdemo;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;
import com.luv2code.aopdemo.service.TrafficFortuneService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO, TrafficFortuneService theTrafficFortuneService){
		return runner ->{

		//	demoTheBeforeAdvice(theAccountDAO,theMembershipDAO);

		//	demoTheAfterReturningAdvice(theAccountDAO);

		//	demoTheAfterThrowingAdvice(theAccountDAO);

		//	demoTheAfterAdvice(theAccountDAO);

		//	demoTheAroundAdvice(theTrafficFortuneService);

		//	demoTheAroundAdviceHandleException(theTrafficFortuneService);

			demoTheAroundAdviceRethrowException(theTrafficFortuneService);

		};
	}

	private void demoTheAroundAdviceRethrowException(TrafficFortuneService theTrafficFortuneService) {

		System.out.println("\n main program : demoTheAroundAdviceRethrowException");
		System.out.println("calling getFortune()");
		boolean tripWire = true;
		String data = theTrafficFortuneService.getFortune(tripWire);


		System.out.println("\n my fortune is : "+data);
		System.out.println("finished");

	}

	private void demoTheAroundAdviceHandleException(TrafficFortuneService theTrafficFortuneService) {

		System.out.println("\n main program : demoTheAroundAdviceHandleException");
		System.out.println("calling getFortune()");
		boolean tripWire = true;
		String data = theTrafficFortuneService.getFortune(tripWire);


		System.out.println("\n my fortune is : "+data);
		System.out.println("finished");



	}

	private void demoTheAroundAdvice(TrafficFortuneService theTrafficFortuneService) {
		System.out.println("\n main program : demoTheAroundAdvice");
		System.out.println("calling getFortune()");
		String data = theTrafficFortuneService.getFortune();
		System.out.println("\n my fortune is : "+data);
		System.out.println("finished");


	}

	private void demoTheAfterAdvice(AccountDAO theAccountDAO) {
		List<Account> theAccounts =null;

		try{
			boolean tripWire = false;
			theAccounts = theAccountDAO.findAccounts(tripWire);

		}catch (Exception e){
			System.out.println("\n\n main program .. caught exceptions : "+e);

		}

		System.out.println("----");
		System.out.println(theAccounts);
		System.out.println("\n");

	}

	private void demoTheAfterThrowingAdvice(AccountDAO theAccountDAO) {
		List<Account> theAccounts =null;

		try{
			boolean tripWire = true;
        theAccounts = theAccountDAO.findAccounts(tripWire);

		}catch (Exception e){
			System.out.println("\n\n main program .. caught exceptions : "+e);

		}

		System.out.println("----");
		System.out.println(theAccounts);
		System.out.println("\n");

	}

	private void demoTheAfterReturningAdvice(AccountDAO theAccountDAO) {

		 List<Account> theAccounts =theAccountDAO.findAccounts();
		System.out.println("\n\n main program : demoTheAfterReturningAdvice");
		System.out.println("----");
		System.out.println(theAccounts);
		System.out.println("\n");


	}

	private void demoTheBeforeAdvice(AccountDAO theAccountDAO,MembershipDAO theMembershipDAO) {
		Account account = new Account();
		account.setName("madhu");
		account.setLevel("platinum");
		theAccountDAO.addAccount(account,true);
		theAccountDAO.doWork();
		theAccountDAO.setName("foobar");
		theAccountDAO.setServiceCode("silver");

		String name = theAccountDAO.getName();
		String code = theAccountDAO.getServiceCode();

		theMembershipDAO.addSillyMethod();
		theMembershipDAO.goToSleep();
		}

}
