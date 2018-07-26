package com.joe.sam.service;

import com.joe.sam.po.BasketballPlayer;
import com.joe.sam.po.Info;

public interface IPlayerService {
	public Info addPlayer(BasketballPlayer player);
	public Info updatePlayer(BasketballPlayer player);
	public Info deletePlayer(String id);
	public Info getPlayer(String id);
}
