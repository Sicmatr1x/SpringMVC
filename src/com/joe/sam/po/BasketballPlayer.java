package com.joe.sam.po;

public class BasketballPlayer {
	private String id;
	private String name;
	private Integer age;
	private String password;
	public BasketballPlayer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public BasketballPlayer(String id, String name, Integer age, String password) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "BasketballPlayer [id=" + id + ", name=" + name + ", age=" + age + ", password=" + password + "]";
	}
	
	
}
