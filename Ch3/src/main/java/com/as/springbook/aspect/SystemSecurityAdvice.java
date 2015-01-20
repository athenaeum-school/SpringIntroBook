/**
 * All Rigths Reserved by Athenaeum Society
 * 2015-
 * Written by Masaki Komatsu
 */
package com.as.springbook.aspect;

import java.util.concurrent.atomic.AtomicInteger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.IllegalTransactionStateException;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.as.springbook.domain.Book;
import com.as.springbook.domain.SecurityFilter;
import com.as.springbook.dto.UserDTO;

/**
 * @author komatsu
 *
 */
@Component
@Aspect
public class SystemSecurityAdvice {

	private static final Logger logger = LoggerFactory.getLogger(SystemSecurityAdvice.class);
	
	public SystemSecurityAdvice(){
		super();
	}
	
	@Autowired
    private SecurityFilter securityFilter;

    public SystemSecurityAdvice(SecurityFilter securityFilter) {
        this.securityFilter = securityFilter;
    }
	
	private static final int MAX_RETRIES = 2; 
	private int numRetries = MAX_RETRIES;

	public void setNumRetries(int numRetries) { 
		this.numRetries = numRetries;
	}
	
	//@Pointcut("execution(* *(..))")
	//public void doAOPDemo() {		
	//}
	//
	//@Before("doAOPDemo()")
	
	//@Before("execution(* com.as.springbook.domain..*(..))")
	//public void AOPAdvice(JoinPoint joinPoint) {
	//	logger.info("Aspect applied to " + joinPoint.getSignature().getName());
	//}
		
	@Before("@annotation(com.as.springbook.annotation.PermissionRequired)")
	public void securityBeforeAdvice(JoinPoint joinPoint) {
		
		// It is not wise to bypass Spring Security
		// but not hard to check against the user database. 
		// Filtering this way is easier to implement the access control
		securityFilter.permissionCheck("test", "test");
        UserDTO user = securityFilter.getLocalThreadUserInformation();

        if (user == null) {
            throw new SecurityException("No permission for anonymous user");
        } else {
            System.out.println("Local thread user is " + user.getUserName());
        }
        
	}
	
	@Around("@annotation(com.as.springbook.annotation.RetryLock)")	
	public Object doOptimisticLockingOperation(ProceedingJoinPoint pjp) throws Throwable {
		
		int numAttempts = 0;
		OptimisticLockingFailureException optimisticLockingFailureException = null;
		
		while(numAttempts++ < this.numRetries) {
			System.out.println("Number of attempts is " + numAttempts);
			try { 
				Object retval = pjp.proceed(); 
				return retval; 
			}
			catch(OptimisticLockingFailureException olex) {
				optimisticLockingFailureException = olex;
				System.out.println("OptimisticLockingFailureException: " + olex);
			} catch (RuntimeException ex) {
				System.out.println("RuntimeException " + ex);
			}
			
		}
		throw optimisticLockingFailureException;
	}
}
