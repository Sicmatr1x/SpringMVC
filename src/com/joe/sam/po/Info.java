package com.joe.sam.po;

import java.util.HashMap;
import java.util.Map;

public class Info {
	private Map<String, Object> result;
	private String state;
	private String info;
	public Info() {
		super();
		this.result = new HashMap<>();
	}
	public Info(String state, String info) {
		super();
		this.result = new HashMap<>();
		this.state = state;
		this.info = info;
	}
	public Map<String, Object> getResult() {
		return result;
	}
	public void setResult(Map<String, Object> result) {
		this.result = result;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
}
