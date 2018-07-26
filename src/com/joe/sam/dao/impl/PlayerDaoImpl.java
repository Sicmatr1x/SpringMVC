package com.joe.sam.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.joe.sam.dao.IPlayerDao;
import com.joe.sam.po.BasketballPlayer;
import com.joe.sam.po.Info;

@Repository("playerDao")
public class PlayerDaoImpl implements IPlayerDao {
	
	private Map<String, BasketballPlayer> playerMap = new HashMap<>();

	@Override
	public Info addPlayer(BasketballPlayer player) {
		playerMap.put(player.getId(), player);
		Info info = new Info();
		if(playerMap.containsKey(player.getId())) {
			info.setState("success");
		}else {
			info.setState("fail");
			info.setInfo("add fail:" + player.getId() + "");
		}
		return info;
	}

	@Override
	public Info updatePlayer(BasketballPlayer player) {
		Info info = new Info();
		String id = player.getId();
		
		if(id == null || "".equals(id)) {
			info.setState("fail");
			info.setInfo("put fail: illegal id:" + id + "");
			return info;
		}
		if(!playerMap.containsKey(id)) {
			info.setState("fail");
			info.setInfo("put fail:can not find " + id + " in databases");
			return info;
		}
		player.setId(id);
		playerMap.put(id, player);
		info.setState("success");
		return info;
	}

	@Override
	public Info deletePlayer(String id) {
		Info info = new Info();
		
		if(playerMap.containsKey(id)) {
			playerMap.remove(id);
			System.out.println("BasketballPlayerController:delete success:id=" + id);
			if(playerMap.containsKey(id)) {
				//fail
				info.setInfo("delete fail " + id + " still exist");
			}else {
				info.setState("success");
			}
		}else {
			System.out.println("BasketballPlayerController:delete fail:id=" + id);
			info.setInfo("delete fail:can not find " + id + " in databases");
		}
		if(info.getState() == null) {
			info.setState("fail");
		}
		return info;
	}

	@Override
	public Info getPlayer(String id) {
		BasketballPlayer player = playerMap.get(id);
		Info info = new Info();
		if(player == null) {
			info.setState("fail");
			info.setInfo("can not find " + id + " in databases");
		}else {
			info.setState("success");
		}
		info.getResult().put("player", player);
		return info;
	}

}
