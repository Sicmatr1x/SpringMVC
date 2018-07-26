package com.joe.sam.aop;

import org.apache.commons.codec.digest.DigestUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


import com.joe.sam.po.BasketballPlayer;
import com.joe.sam.po.Info;

@Component
@Aspect
public class LoginAspect {
	
	//@Around("execution (public * login (..))")
	@Around("execution (* com.joe.sam.service.impl.PlayerServiceImpl.login (..))")
	public Info loginAround(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("LoginAspect:loginAround");
		Object[] args = pjp.getArgs();
		String pwd = (String) args[1];
		String md5 = DigestUtils.md5Hex(pwd);
		args[1] = md5;
		System.out.println("LoginAspect:loginAround:pwd=" + pwd + ",md5="+md5);
		return (Info) pjp.proceed(args);
	}
}
