package entities;

import java.io.Serializable;

public class Client extends Entity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String phoneNumber;
	private String pickUpAddress;
	private String dropOffAddress;
	private int numberOfClients;
	private boolean hasDriver;
	private Driver assignedDriver;
	//REMOVE LATER
	private String ADflag; // using it to test the button to press once 
	
	public Client(String name, String id, String phoneNumber ,String pickUpAddress, String dropOffAddress,int numberOfClients) {
		super(id, name);
		this.phoneNumber = phoneNumber;
		this.pickUpAddress = pickUpAddress;
		this.dropOffAddress = dropOffAddress;
		this.numberOfClients = numberOfClients;
		this.hasDriver = false;
	}
	
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public String getDropOffAddress() {
		return dropOffAddress;
	}
	
	public String getPickUpAddress() {
		return pickUpAddress;
	}
	
	public int getNumberOfClients() {
		return numberOfClients;
	}
	
	public String getADflag() {
		return ADflag;
	}
	
	public void setADflag(String aDflag) {
		ADflag = aDflag;
	}


	public void assignDriver(Driver driver) {
		this.assignedDriver = driver;
		this.hasDriver = true;
		
	}
	
	public Driver getAssignedDriver() {
		return assignedDriver;
	}
	
	public boolean hasDriver() {
		return hasDriver;
	}
}
