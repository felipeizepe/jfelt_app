package entities;

import java.io.Serializable;

public class Driver extends Entity implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private String license;
	private String carDescription;
	private String phoneNumber;
	private boolean hasRide;
	private Client currentClient;


	public Driver(String name, String id,String phoneNumber , String license, String carDecription) {
		super(id, name);
		this.license = license;
		this.carDescription = carDecription;
		this.phoneNumber = phoneNumber;
		this.hasRide = false;
	}


	public String getLicense() {
		return license;
	}

	public String getCarDescription() {
		return carDescription;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public boolean hasRide() {
		return hasRide;
	}


	public void assignClient(Client ct) {
		this.currentClient = ct;
		this.hasRide = true;
	}

	public void freeDriver() {
		this.currentClient = null;
		this.hasRide = false;
	}

	public Client getCurrentClient() {
		return currentClient;
	}


}