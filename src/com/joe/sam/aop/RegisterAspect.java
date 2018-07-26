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
public class RegisterAspect {
	
	//@Around("execution (public * addPlayer (..))")
	@Around("execution (* com.joe.sam.service.impl.PlayerServiceImpl.addPlayer (..))")
	public Info registerAround(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("RegisterAspect:registerAround");
		Object[] args = pjp.getArgs();
		BasketballPlayer player = (BasketballPlayer) args[0];
		String pwd = player.getPassword();
		String md5 = DigestUtils.md5Hex(pwd);
		player.setPassword(md5);
		args[0] = player;
		System.out.println("RegisterAspect:registerAround:player=" + args[0]);
		
		return (Info) pjp.proceed(args);
	}
}
