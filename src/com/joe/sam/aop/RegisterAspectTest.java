package com.joe.sam.aop;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.joe.sam.po.BasketballPlayer;
import com.joe.sam.service.impl.PlayerServiceImpl;

public class RegisterAspectTest {

	@Test
	public void test() {
		ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext("beans.xml");
		assertNotNull(factory);
		System.out.println(factory);
		PlayerServiceImpl playerService = (PlayerServiceImpl) factory.getBean("playerService");
//		customerService.register("test", "qwer");
		assertNotNull(playerService);
		playerService.addPlayer(new BasketballPlayer("01", "Kobe", 56, "qwert"));
	}

}
