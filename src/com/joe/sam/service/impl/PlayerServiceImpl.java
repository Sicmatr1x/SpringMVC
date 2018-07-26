package com.joe.sam.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joe.sam.dao.IPlayerDao;
import com.joe.sam.po.BasketballPlayer;
import com.joe.sam.po.Info;
import com.joe.sam.service.IPlayerService;

@Service("playerService")
public class PlayerServiceImpl implements IPlayerService {
	
	@Autowired
	private IPlayerDao playerDao;

	@Override
	public Info addPlayer(BasketballPlayer player) {
		System.out.println("PlayerServiceImpl:addPlayer:player="+player);
		Info info = playerDao.addPlayer(player);
		System.out.println("PlayerServiceImpl:addPlayer:info="+info);
		return info;
	}

	@Override
	public Info updatePlayer(BasketballPlayer player) {
		// TODO Auto-generated method stub
		return playerDao.updatePlayer(player);
	}

	@Override
	public Info deletePlayer(String id) {
		// TODO Auto-generated method stub
		return playerDao.deletePlayer(id);
	}

	@Override
	public Info getPlayer(String id) {
		// TODO Auto-generated method stub
		return playerDao.getPlayer(id);
	}

	@Override
	public Info login(String id, String password) {
		
		
		return playerDao.login(id, password);
	}

}
