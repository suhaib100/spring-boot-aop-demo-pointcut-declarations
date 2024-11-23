package com.luv2code.aopdemo.aspect;

import com.luv2code.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

  // @Before("execution(public void com.luv2code.aopdemo.dao.AccountDAO.addAccount())")

  //@Before("execution(public void add*())")

  @Around("execution(* com.luv2code.aopdemo.service.*.getFortune(..))")
  public Object aroundGetFortune(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable{

    String method = theProceedingJoinPoint.getSignature().toShortString();
    System.out.println("\n===>>> Executing @Around on method :  "+method);

    Long begin = System.currentTimeMillis();
    Object result =null;
    try{
     result= theProceedingJoinPoint.proceed();
    }catch (Exception e){
      System.out.println(e.getMessage());
      throw e;
    }


    Long end = System.currentTimeMillis();

    Long duration = end-begin;
    System.out.println("\n===>>> Duration : "+ duration/1000.0 + " seconds");


    return result;
  }


  @After("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))")
  public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint){
    String method = theJoinPoint.getSignature().toShortString();
    System.out.println("\n===>>> Executing @After (finally) on method :  "+method);

  }



  @AfterThrowing(
          pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
          throwing = "theExc"
  )
  public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint, Throwable theExc){
    String method = theJoinPoint.getSignature().toShortString();
    System.out.println("\n===>>> Executing @AfterThrowing on method :  "+method);

    System.out.println("\n===>>> The Exception is : "+theExc);

  }



  @AfterReturning(
          pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
          returning = "result"
  )
  public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result){
    String method = theJoinPoint.getSignature().toShortString();
    System.out.println("\n===>>> Executing @AfterReturning on method :  "+method);
    System.out.println("\n===>>> Result is :  "+result);

    convertAccountNamesToUpperCase(result);
    System.out.println("\n===>>> Result is :  "+result);



  }

  private void convertAccountNamesToUpperCase(List<Account> result) {
    for (Account tempAccount : result){
      String theUpperName = tempAccount.getName().toUpperCase();
      tempAccount.setName(theUpperName);

    }
  }


  @Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
//@Before("execution(public void updateAccount() )")
  public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
    System.out.println("\n====>>> Executing @before advice on method");
    MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
    System.out.println("Method : "+ methodSignature);


    Object[] args = theJoinPoint.getArgs();
    for (Object tempArgs : args){
      System.out.println(tempArgs);
      if (tempArgs instanceof Account){
        Account theAccount = (Account) tempArgs;
        System.out.println("account name : "+ theAccount.getName());
        System.out.println("account level : "+ theAccount.getLevel());
      }
    }


  }






}
