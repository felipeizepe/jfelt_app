package graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import threads.ClientServer;
import threads.DriverServer;

public class ServerSwitchTab extends JPanel{


	private boolean Server_Status =false;
	private JTextField ClientTextAll;
	private JTextField DriverTextAll;
	
	private ClientServer clientServer;
	private DriverServer driverServer;
	
	 public ServerSwitchTab()
     {
	 	setLayout(null);
	 	
	 	 final JLabel OnOffStatus = new JLabel(" OFF ");
         OnOffStatus.setBounds(148, 158, 46, 14);
         add(OnOffStatus);
         OnOffStatus.setForeground(Color.red);
         final JButton btnTurnOff = new JButton("Turn Off");
         final JButton btnTurnOn = new JButton("Turn On");
         btnTurnOn.addActionListener(new ActionListener() {
                 public void actionPerformed(ActionEvent arg0) {
                 	Server_Status= true;
                 	OnOffStatus.setText(" Live ");
                 	OnOffStatus.setForeground(Color.green);
                 	if(Server_Status ==true){
                 			btnTurnOn.setEnabled(false);
                 			btnTurnOff.setEnabled(true);
                 			
                 			clientServer = new ClientServer();
               			 driverServer = new DriverServer();

               			clientServer.start();
               			driverServer.start();
                 		
                 			
                 	}
                 	
                 }
             });
             btnTurnOn.setBounds(0, 211, 172, 37);
             add(btnTurnOn);
             
             
             //btnTurnOff.setEnabled(false);
             btnTurnOff.addActionListener(new ActionListener() {
             	public void actionPerformed(ActionEvent e) {
             		Server_Status= false;
                 	OnOffStatus.setText(" Off ");
                 	OnOffStatus.setForeground(Color.red);
                 	if(Server_Status ==false){
                 			btnTurnOff.setEnabled(false);
                 			btnTurnOn.setEnabled(true);
                 			
                 			clientServer.stopServer();
                			driverServer.stopServer();
                 	}
             	}
             });
             btnTurnOff.setBounds(193, 211, 147, 37);
             add(btnTurnOff);
             
             JLabel lblNewLabel_4 = new JLabel("The Server Is Currently");
             lblNewLabel_4.setForeground(Color.BLACK);
             lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 25));
             lblNewLabel_4.setBounds(10, 30, 401, 97);
             add(lblNewLabel_4);
             
             ClientTextAll = new JTextField();
             ClientTextAll.setBounds(738, 117, 453, 97);
             add(ClientTextAll);
             ClientTextAll.setColumns(10);
             
             DriverTextAll = new JTextField();
             DriverTextAll.setColumns(10);
             DriverTextAll.setBounds(738, 272, 453, 97);
             add(DriverTextAll);
             
             JLabel lblClient = new JLabel("Client");
             lblClient.setBounds(735, 99, 46, 14);
             add(lblClient);
             
             JLabel lblDriver_1 = new JLabel("Driver");
             lblDriver_1.setBounds(738, 258, 46, 14);
             add(lblDriver_1);
             
             JButton btnSent = new JButton("Sent");
             btnSent.addActionListener(new ActionListener() { //code for sending string to all client 
             	public void actionPerformed(ActionEvent e) {
             	}
             });
             btnSent.setBounds(1102, 380, 89, 23);
             add(btnSent);
             
             JButton button = new JButton("Sent");
             button.addActionListener(new ActionListener() {// code for sending string to all driver that is currently logged in 
             	public void actionPerformed(ActionEvent e) {
             	}
             });
             button.setBounds(1102, 225, 89, 23);
             add(button);
             
             JLabel lblSentNotificationTo = new JLabel("Sent Notification to ALL Client or Driver");
             lblSentNotificationTo.setBounds(735, 39, 453, 49);
             add(lblSentNotificationTo);         
       
     }
}