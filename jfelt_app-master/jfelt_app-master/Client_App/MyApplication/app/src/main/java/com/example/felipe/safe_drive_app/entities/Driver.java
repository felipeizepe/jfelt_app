package com.example.felipe.safe_drive_app.entities;

public class Driver {

	private String name;
	private String ID;
	
	public Driver(String name, String ID) {
		this.name = name;
		this.ID = ID;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getID() {
		return ID;
	}
	
}
