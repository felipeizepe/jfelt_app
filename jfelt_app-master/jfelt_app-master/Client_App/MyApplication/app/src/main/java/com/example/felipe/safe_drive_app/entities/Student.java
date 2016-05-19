package com.example.felipe.safe_drive_app.entities;

import java.io.Serializable;

public class Student implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String ID;


	public Student(String name, String ID) {
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
