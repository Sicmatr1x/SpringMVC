package com.joe.sam.dao;

import com.joe.sam.po.BasketballPlayer;
import com.joe.sam.po.Info;

public interface IPlayerDao {
	public Info addPlayer(BasketballPlayer player);
	public Info updatePlayer(BasketballPlayer player);
	public Info deletePlayer(String id);
	public Info getPlayer(String id);
}
