package messages;


import java.io.Serializable;

import entities.Client;

public class StudentMessage implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Operation MessageOperation;
	private enum Operation{None, Message_To_Server, Message_To_Driver, 
		Cancel_Request, Make_Request, Report_Error};
		
		private Client owner;
		private String message;

	/**
	 * Constructor of the {@link StudentMessage} class
	 *
	 * @author Felipe Izepe
	 * @version 2.0
	 * @since 2016-04-30
	 * @param  owner of the message
	 * @param  message that will be sent and read
	 */
	public StudentMessage(Client owner, String message) {
		this.owner = owner;
		this.message = message;
		this.MessageOperation = Operation.None;
	}
	
	/**
	 * Gets the owner of the message, null if sent by the server
	 *
	 * @author Felipe Izepe
	 * @version 1.0
	 * @since 2016-04-25
	 */
	public Client getOwner() {
		return owner;
	}
	
	/**
	 * Sets the type of operation that the message will perform
	 *
	 *@param type - <b>0</b> send a message to the coordinator | <b>1</b> send a message to driver |
 	 * <b>2</b> make a ride request | <b>3</b> cancel a ride | <b>4</b> report that an error occurred
	 *
	 * @author Felipe Izepe
	 * @version 1.0
	 * @since 2016-04-30
	 */
	public void setType(int type)
	{
		switch(type){
		case 0:
			this.MessageOperation = Operation.Message_To_Server;
			break;
		case 1:
			this.MessageOperation = Operation.Message_To_Driver;
			break;
		case 2: 
			this.MessageOperation = Operation.Make_Request;
			break;
		case 3:
			this.MessageOperation = Operation.Cancel_Request;
			break;
		default:
			return;
		}
	}
	
	/**
	 * Checks if the message is to be sent to the coordinator
	 *
	 * @author Felipe Izepe
	 * @version 1.0
	 * @since 2016-04-30
	 */
	public boolean isMessageToServer()
	{
		if(MessageOperation == Operation.Message_To_Server)
			return true;
		return false;
	}
	
	/**
	 * Checks if the message is to be sent to the Driver
	 *
	 * @author Felipe Izepe
	 * @version 1.0
	 * @since 2016-04-30
	 */
	public boolean isMessageToDriver()
	{
		if(MessageOperation == Operation.Message_To_Driver)
			return true;
		return false;
	}
	
	/**
	 * Checks if the message is to be sent to the coordinator as a request for a ride
	 *
	 * @author Felipe Izepe
	 * @version 1.0
	 * @since 2016-04-30
	 */
	public boolean isMakeRequest()
	{
		if(MessageOperation == Operation.Make_Request)
			return true;
		return false;
	}
	
	/**
	 * Checks if the message is to be sent to the coordinator to cancel a request
	 *
	 * @author Felipe Izepe
	 * @version 1.0
	 * @since 2016-04-30
	 */
	public boolean isCancelRequest()
	{
		if(MessageOperation == Operation.Cancel_Request)
			return true;
		return false;
	}
	
	/**
	 * Checks if the message is to be sent to the coordinator to report an error
	 *
	 * @author Felipe Izepe
	 * @version 1.0
	 * @since 2016-04-30
	 */
	public boolean isError()
	{
		if(MessageOperation == Operation.Report_Error)
			return true;
		return false;
	}
	
	/**
	 * Returns The message given to the class
	 *
	 * @author Felipe Izepe
	 * @version 1.0
	 * @since 2016-04-30
	 */
	public String getMessage() {
		return message;
	}
	
	
}
