package com.joe.sam.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.joe.sam.po.BasketballPlayer;
import com.joe.sam.po.Info;
import com.joe.sam.service.IPlayerService;



@Controller
@RequestMapping("/basketball")
//RESTful
//不允许出现动名词短语
//GET localhost:9090/FirstMVC/basketball/{id}
//GET localhost:9090/FirstMVC/basketball/
//POST localhost:9090/FirstMVC/basketball/
//PUT localhost:9090/FirstMVC/basketball/{id}
//DELETE localhost:9090/FirstMVC/basketball/{id}
public class BasketballPlayerController {
	
	@Autowired
	private IPlayerService playerService;
	
	@RequestMapping(value = "/player/{id}",method=RequestMethod.GET)
	@ResponseBody
	public Info get(@PathVariable String id) throws IOException {
		System.out.println("BasketballPlayerController:get:id=" + id);
		Info info = playerService.getPlayer(id);
		System.out.println("BasketballPlayerController:get:player=" + info.getResult().get("player"));
		return info;
	}
	
	@RequestMapping(value = "/player",method=RequestMethod.POST)
	@ResponseBody
	public Info post(BasketballPlayer player) {
		String id = UUID.randomUUID().toString();
		player.setId(id);
		System.out.println("BasketballPlayerController:post:player=" + player);
		Info info = playerService.addPlayer(player);
		
		return info;
	}
	
	@RequestMapping(value = "/player/{id}",method=RequestMethod.PUT)
	@ResponseBody
	public Info put(BasketballPlayer player, @PathVariable String id) {
		System.out.println("BasketballPlayerController:put:player=" + player);
		if(player.getId() == null) {
			player.setId(id);
		}
		Info info = playerService.updatePlayer(player);
		return info;
	}
	
	@RequestMapping(value = "/player/{id}",method=RequestMethod.DELETE)
	@ResponseBody
	public Info delete(@PathVariable String id) {
		Info info = playerService.deletePlayer(id);
		return info;
	}
}
