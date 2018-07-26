package com.joe.sam.aop;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.joe.sam.po.BasketballPlayer;
import com.joe.sam.service.impl.PlayerServiceImpl;

public class LoginAspectTest {

	@Test
	public void test() {
		ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext("beans.xml");
		assertNotNull(factory);
		System.out.println(factory);
		PlayerServiceImpl playerService = (PlayerServiceImpl) factory.getBean("playerService");
//		customerService.register("test", "qwer");
		assertNotNull(playerService);
		playerService.login("c8abea7b-4a43-435f-ba23-b8f110ba035a", "qwert");
	}

}
