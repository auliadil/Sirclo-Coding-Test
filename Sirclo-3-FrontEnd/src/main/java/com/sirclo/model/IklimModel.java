package com.sirclo.model;

import java.util.LinkedList;

public class IklimModel {
	
	private LinkedList<Long> dt;
		
	private LinkedList<Long> temp;
	
	private LinkedList<Long> temp_min;
	
	private LinkedList<Long> temp_max;
	
	private long id;
	
	private String name;
	
	public IklimModel() {
		dt = new LinkedList<Long>();
		temp = new LinkedList<Long>();
		temp_min = new LinkedList<Long>();
		temp_max = new LinkedList<Long>();
		id = 0;
		name = "tes";
	}
	
	public LinkedList<Long> getDt() {
		return dt;
	}

	public void setDt(LinkedList<Long> dt) {
		this.dt = dt;
	}

	public LinkedList<Long> getTemp() {
		return temp;
	}

	public void setTemp(LinkedList<Long> temp) {
		this.temp = temp;
	}

	public LinkedList<Long> getTemp_min() {
		return temp_min;
	}

	public void setTemp_min(LinkedList<Long> temp_min) {
		this.temp_min = temp_min;
	}

	public LinkedList<Long> getTemp_max() {
		return temp_max;
	}

	public void setTemp_max(LinkedList<Long> temp_max) {
		this.temp_max = temp_max;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}