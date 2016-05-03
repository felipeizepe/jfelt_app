package graphics;



import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import threads.ClientServer;
import threads.DriverServer;
import entities.Client;
import entities.Driver;

 public class Coord {

private Client test = new Client("CLIENT TEST 1", "0", "PHONE N1", "PICK UP ADD", "DROP OFF ADD", 1);
private Client test2 = new Client("CLIENT TEST 2", "1", "PHONE N2", "PICK UP ADD", "DROP OFF ADD", 5);
private Driver Dtest = new Driver("DRIVER TEST 1", "13","PHONE N3", "LICENSE NUM", "CAR DESCRIPT");
private Driver Dtest2 = new Driver("DRIVER TEST 2", "13","PHONE N4", "LICENSE NUM2", "CAR DESCRIPT2");
private Driver Dtest3 = new Driver("DRIVER TEST 3", "13","PHONE N4", "LICENSE NUM3", "CAR DESCRIPT3");
public JFrame frame;
private JTable Infotable;
private DefaultTableModel InfoViewModel = new DefaultTableModel();
private DefaultListModel Lmodel = new DefaultListModel(); // new request model
private DefaultListModel<Client> ARModel = new DefaultListModel();// accepted request model
private JTable table_1;
private JTextField textField;
private JTextField textField_1;
private JTextField textField_2;
private ArrayList<Client> clientRequest= new ArrayList<Client>();
private ArrayList<Client> acceptList= new ArrayList<Client>();
private DefaultListModel<Driver> DriverInfoModel= new DefaultListModel();
private ArrayList<Driver> DAvil= new ArrayList<Driver>();
private JTextField textField_3;
private JTextField ClientTextAll;
private JTextField DriverTextAll;
private boolean Server_Status =false;
private JTextField textField_7;
private JTextField textField_8;
private JTable ClientInfoView;
private JTable DriverInfoView;
private DefaultTableModel DriverViewModel = new DefaultTableModel();



private ClientServer clientServer;
private DriverServer driverServer;

/**
 * Create the application.
 */
public Coord() {
    initialize();
}

/**
 * Initialize the contents of the frame.
 */
private void initialize() {

    clientRequest.add(test);
    clientRequest.add(test2);   
    
    DAvil.add(Dtest);
    DAvil.add(Dtest2);
    DAvil.add(Dtest3);
  //
    frame = new JFrame();
    //frame.setExtendedState(Frame.MAXIMIZED_BOTH);   //set to fullscreen default
   frame.setBounds(100, 100, 1369, 752);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(null);

    JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
    tabbedPane.setBounds(0, 0, 1510, 751);
    frame.getContentPane().add(tabbedPane);  
   
        
        
        
       /// End Driver ////////////////////////////////////////////////////////////////////////////////////////////
        //////////////////// server switch panel///////////////////////////////
            
    	JPanel ServerSwitchPanel = new JPanel();
            tabbedPane.addTab("Server Switch", null, ServerSwitchPanel, null);
            ServerSwitchPanel.setLayout(null);
            
            final JLabel OnOffStatus = new JLabel(" OFF ");
            OnOffStatus.setBounds(148, 158, 46, 14);
            ServerSwitchPanel.add(OnOffStatus);
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
                ServerSwitchPanel.add(btnTurnOn);
                
                
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
                ServerSwitchPanel.add(btnTurnOff);
                
                JLabel lblNewLabel_4 = new JLabel("The Server Is Currently");
                lblNewLabel_4.setForeground(Color.BLACK);
                lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 25));
                lblNewLabel_4.setBounds(10, 30, 401, 97);
                ServerSwitchPanel.add(lblNewLabel_4);
                
                ClientTextAll = new JTextField();
                ClientTextAll.setBounds(738, 117, 453, 97);
                ServerSwitchPanel.add(ClientTextAll);
                ClientTextAll.setColumns(10);
                
                DriverTextAll = new JTextField();
                DriverTextAll.setColumns(10);
                DriverTextAll.setBounds(738, 272, 453, 97);
                ServerSwitchPanel.add(DriverTextAll);
                
                JLabel lblClient = new JLabel("Client");
                lblClient.setBounds(735, 99, 46, 14);
                ServerSwitchPanel.add(lblClient);
                
                JLabel lblDriver_1 = new JLabel("Driver");
                lblDriver_1.setBounds(738, 258, 46, 14);
                ServerSwitchPanel.add(lblDriver_1);
                
                JButton btnSent = new JButton("Sent");
                btnSent.addActionListener(new ActionListener() { //code for sending string to all client 
                	public void actionPerformed(ActionEvent e) {
                	}
                });
                btnSent.setBounds(1102, 380, 89, 23);
                ServerSwitchPanel.add(btnSent);
                
                JButton button = new JButton("Sent");
                button.addActionListener(new ActionListener() {// code for sending string to all driver that is currently logged in 
                	public void actionPerformed(ActionEvent e) {
                	}
                });
                button.setBounds(1102, 225, 89, 23);
                ServerSwitchPanel.add(button);
                
                JLabel lblSentNotificationTo = new JLabel("Sent Notification to ALL Client or Driver");
                lblSentNotificationTo.setBounds(735, 39, 453, 49);
                ServerSwitchPanel.add(lblSentNotificationTo);
                
                
                
                

  ////////////end server_switch panel///////////////////////////////
            
             
                             
  ///////////////// Main panel /////////////////                             
                               
    JPanel panel = new JPanel();
    tabbedPane.addTab("Requests", null, panel, null);
    panel.setLayout(null);       
    
    
////////////// 2 Jlist&Client information table properties && buttons
    JPanel panel_4 = new JPanel();
    tabbedPane.addTab("Assign Driver ", null, panel_4, null);
    panel_4.setLayout(null);
 
    final JList acceptedList = new JList();
    acceptedList.setBounds(10, 53, 201, 567);
    panel_4.add(acceptedList);
    acceptedList.setCellRenderer(new ClientRenderer());                       
    
	final JButton AcceptButton = new JButton("Accept ");                   //accept button if clicked return nothing happen                                      
	AcceptButton.setEnabled(false);     
	AcceptButton.setBounds(676, 482, 89, 23);
	panel.add(AcceptButton);
                                      
	final JButton DenyButton = new JButton("Deny");                 // deny button if clicked return new InfoViewModel without the selected
	DenyButton.setEnabled(false);                                          
	DenyButton.setBounds(775, 482, 89, 23);
	panel.add(DenyButton);      
	
	JLabel lblclientRequest = new JLabel("Client Request");
	lblclientRequest.setBounds(20, 24, 77, 14);
	panel.add(lblclientRequest);
	final JList<String> ClientRequestList = new JList<String>(Lmodel);
    ClientRequestList.setBounds(20, 36, 161, 578);
    panel.add(ClientRequestList);
    
  
    
    JLabel lblClientsInfo = new JLabel("Client's Info");
    lblClientsInfo.setBounds(367, 24, 497, 14);
    panel.add(lblClientsInfo);
    JScrollPane scrollPane = new JScrollPane();  
    scrollPane.setBounds(367, 36, 497, 435);
    panel.add(scrollPane);      
    Infotable = new JTable();
    scrollPane.setViewportView(Infotable);// client's info
    
    textField_3 = new JTextField();
    textField_3.setBounds(374, 516, 497, 34);
    panel.add(textField_3);
    textField_3.setColumns(10);
    
                               
    ClientInfoView = new JTable();
    ClientInfoView.setBounds(718, 54, 499, 262);
    panel_4.add(ClientInfoView);
 
                                 
    ClientRequestList.addListSelectionListener(new ListSelectionListener() {
    	@Override
    	public void valueChanged(ListSelectionEvent arg0) {
        if (ClientRequestList.getSelectedValue() != null)
        {
        acceptedList.clearSelection();
        if (!arg0.getValueIsAdjusting()) 
        {
        	final DefaultTableModel EmptyTableModel = new DefaultTableModel(); //  to clear inforview table everytime a different item is selected
        	InfoViewModel=                  EmptyTableModel;
            Infotable.setModel(InfoViewModel);//    

            InfoViewModel.addColumn("Client's Attribute");
            InfoViewModel.addColumn("Client's Attribute Value");        
            InfoViewModel.addRow(new Object[]{"Name", clientRequest.get(ClientRequestList.getSelectedIndex()).getName()});
            InfoViewModel.addRow(new Object[]{"Phone Number", clientRequest.get(ClientRequestList.getSelectedIndex()).getPhoneNumber()});
            InfoViewModel.addRow(new Object[]{"A/D",clientRequest.get(ClientRequestList.getSelectedIndex()).getADflag() });   
            InfoViewModel.addRow(new Object[]{"dfafdsa",clientRequest.get(ClientRequestList.getSelectedIndex()).getADflag() }); 
             Infotable.setModel(InfoViewModel);
             if(clientRequest.get(ClientRequestList.getSelectedIndex()).getADflag()=="Not Set")
             {
                 DenyButton.setEnabled(true);      
                 DenyButton.addActionListener(new ActionListener() {
                 public void actionPerformed(ActionEvent  e) {
                 if((!clientRequest.isEmpty())&&(ClientRequestList.getSelectedIndex()>=0))
                                                     	{
                                                     		clientRequest.get(ClientRequestList.getSelectedIndex()).setADflag("false");
                                                         	
                                                         	clientRequest.remove(ClientRequestList.getSelectedIndex());
                                                         	addCRmodel(clientRequest);						// reset Lmodel and add it to Lmodel
                                                         	ClientRequestList.setModel(Lmodel);
                                                     		
                                                     	}
                                                     
                                                   
                                                     }
                                                 });
                                                 AcceptButton.setEnabled(true);
                                                 AcceptButton.addActionListener(new ActionListener() {
                                                     public void actionPerformed(ActionEvent  e) {
                                                    
                                                     	if((!clientRequest.isEmpty())&&(ClientRequestList.getSelectedIndex()>=0))// 2 steps -remove   
                                                     	{
                                                     	clientRequest.get(ClientRequestList.getSelectedIndex()).setADflag("true");
                                                     	System.out.print(clientRequest.get(ClientRequestList.getSelectedIndex()));
                                                     	acceptList.add(clientRequest.get(ClientRequestList.getSelectedIndex()));   
                                                     	clientRequest.remove(ClientRequestList.getSelectedIndex());// 1. remove from arraylist
                                                     	addCRmodel(clientRequest);									// 2. remove it from model
                                                     	addARmodel(acceptList);
                                                     	acceptedList.setModel(ARModel);
                                                     
                                                     	ClientRequestList.setModel(Lmodel);
                                                        
                                                         }
                                                         AcceptButton.setEnabled(false);
                                                         DenyButton.setEnabled(false);
                                                         
                                                     }
                                                 });
                                             }
                                             else{
                                                 AcceptButton.setEnabled(false);
                                                 DenyButton.setEnabled(false);

                                             }
                                           
                                         }
                                     }}
                                 });
    
    
    acceptedList.addListSelectionListener(new ListSelectionListener() {

    	 @Override
         public void valueChanged(ListSelectionEvent arg0) {
             if (acceptedList.getSelectedValue() != null)
             {
            	 ClientRequestList.clearSelection();
            	AcceptButton.setEnabled(false);
               DenyButton.setEnabled(false);

             if (!arg0.getValueIsAdjusting()) 
             {
            	
                 final DefaultTableModel EmptyTableModel = new DefaultTableModel(); //  to clear inforview table everytime a different item is selected
                 InfoViewModel=                  EmptyTableModel;
                 ClientInfoView.setModel(InfoViewModel);//                                         
                 InfoViewModel.addColumn("Client's Attribute");
                 InfoViewModel.addColumn("Client's Attribute Value");        
                 InfoViewModel.addRow(new Object[]{"Name", ((Client) acceptedList.getSelectedValue()).getName()});
                 InfoViewModel.addRow(new Object[]{"Phone Number", ((Client) acceptedList.getSelectedValue()).getPhoneNumber()});
                 InfoViewModel.addRow(new Object[]{"fasdfsdafas",((Client) acceptedList.getSelectedValue()).getADflag() });   
                 ClientInfoView.setModel(InfoViewModel);
             }
             }
    }});
    
   
    AddtoDriverInfoModel(DAvil);
     
 
    addCRmodel(clientRequest);                               //add client request model used for testing
        
       
       
        
        
       
        
        JLabel lblClientForThe = new JLabel("Clients");
        lblClientForThe.setBounds(10, 38, 205, 14);
        panel_4.add(lblClientForThe);
        
        JLabel lblAcceptedClientFor = new JLabel("Driver");
        lblAcceptedClientFor.setBounds(434, 38, 205, 14);
        panel_4.add(lblAcceptedClientFor);
        
        JScrollPane scrollPane_2 = new JScrollPane();
        scrollPane_2.setBounds(434, 53, 203, 569);
        panel_4.add(scrollPane_2);
        
      
        final JList Avil_Driver = new JList();
        scrollPane_2.setViewportView(Avil_Driver);
        Avil_Driver.setModel(DriverInfoModel);
        Avil_Driver.setCellRenderer(new DriverRenderer());
        Avil_Driver.addListSelectionListener(new ListSelectionListener() {

        	 @Override
             public void valueChanged(ListSelectionEvent arg0) {
                 if (Avil_Driver.getSelectedValue() != null)
                 {
                	
                	

                 if (!arg0.getValueIsAdjusting()) 
                 {
                	
                     final DefaultTableModel EmptyTableModel = new DefaultTableModel(); //  to clear inforview table everytime a different item is selected
                     DriverViewModel=                  EmptyTableModel;
                     DriverInfoView.setModel(InfoViewModel);//                                         
                     DriverViewModel.addColumn("Driver Attribute");
                     DriverViewModel.addColumn("Driver Attribute Value");        
                     DriverViewModel.addRow(new Object[]{"Name", DAvil.get(Avil_Driver.getSelectedIndex()).getName()});
                     DriverViewModel.addRow(new Object[]{"Phone Number", DAvil.get(Avil_Driver.getSelectedIndex()).getPhoneNumber()});      
                     DriverViewModel.addRow(new Object[]{"Current Client Assigment", DAvil.get(Avil_Driver.getSelectedIndex()).getClass()});
                     DriverInfoView.setModel(DriverViewModel);
                 }
                 }
        }});
        
        
        
        
        JButton btnAssign = new JButton("Assign");
        btnAssign.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	
        		if((((Driver) Avil_Driver.getSelectedValue()).getClass()==null )&&(((Client) acceptedList.getSelectedValue()).getClass() ==null)){
        		((Driver) Avil_Driver.getSelectedValue()).assignClient(((Client) acceptedList.getSelectedValue()));
        		((Client) acceptedList.getSelectedValue()).assignDriver((((Driver) Avil_Driver.getSelectedValue())));
				DriverInfoView.setModel(DriverViewModel);
        		Avil_Driver.setModel(DriverInfoModel);
        		acceptedList.setModel(ARModel);
        		}else
        			JOptionPane.showMessageDialog(frame, "Error! Either the driver is currently in mission or the client is already been assigned a driver. Please double check.");
        		
        		
        		
        	}
        });
        btnAssign.setBounds(271, 320, 89, 23);
        panel_4.add(btnAssign);
        
   
        
        JLabel lblObjectsInfo = new JLabel("Client's Infomation");
        lblObjectsInfo.setBounds(718, 38, 107, 14);
        panel_4.add(lblObjectsInfo);
        
        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(718, 361, 499, 262);
        panel_4.add(scrollPane_1);
        
        DriverInfoView = new JTable();
        scrollPane_1.setViewportView(DriverInfoView);
        
        JLabel lblDriversInformation = new JLabel("Driver 's Information");
        lblDriversInformation.setBounds(716, 336, 109, 14);
        panel_4.add(lblDriversInformation);
        
        JButton btnRemoveColor = new JButton("remove color"); //// just for testing can delete and will delete
        btnRemoveColor.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		//((Driver) Avil_Driver.getSelectedValue()).AssignClient(null);   // change the color back to normal    
        		if((ARModel.size()>-1)&&(acceptedList.getSelectedIndex()>=0)){
        		acceptList.remove(acceptedList.getSelectedIndex());
        		System.out.println("get it get thru?");
        		ARModel.remove(acceptedList.getSelectedIndex());
        		}else{System.out.print(" no more Client ");}
        	}
        });
        btnRemoveColor.setBounds(271, 379, 118, 23);
        panel_4.add(btnRemoveColor);
        
        JLabel lblGreenColor = new JLabel("Green Color = Client is assigned");
        lblGreenColor.setBounds(434, 622, 205, 14);
        panel_4.add(lblGreenColor);
        
        JLabel lblGreenColor_1 = new JLabel("Green Color = Driver is assigned");
        lblGreenColor_1.setBounds(10, 622, 205, 14);
        panel_4.add(lblGreenColor_1);
        
        
        
        
        JTabbedPane tabbedPane_2 = new JTabbedPane(JTabbedPane.TOP);// i dont think that we need an Ongoing ride since we can use color code to determine if driver are busy or not
        tabbedPane.addTab("Ongoing Ride", null, tabbedPane_2, null);
    
        JPanel panel_1 = new JPanel();
        tabbedPane.addTab("Driver", null, panel_1, null);
        panel_1.setLayout(null);
        
            JButton btnUpdateDriverList = new JButton("Add Driver");
            btnUpdateDriverList.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                }
            });
            btnUpdateDriverList.setBounds(712, 197, 194, 48);
            panel_1.add(btnUpdateDriverList);
        
                JButton btnRemoveDriver = new JButton("Remove Driver ");
                btnRemoveDriver.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                    }
                });
                btnRemoveDriver.setBounds(10, 602, 194, 48);
                panel_1.add(btnRemoveDriver);
                
                    JLabel lblNewLabel = new JLabel("Driver List");
                    lblNewLabel.setBounds(10, 40, 238, 14);
                    panel_1.add(lblNewLabel);
                    
                        JList list = new JList();
                        list.setBounds(10, 53, 238, 535);
                        panel_1.add(list);
                        
                            table_1 = new JTable();
                            table_1.setBounds(275, 54, 427, 535);
                            panel_1.add(table_1);
                            
                                JLabel lblNewLabel_1 = new JLabel("Driver Info");
                                lblNewLabel_1.setBounds(275, 40, 427, 14);
                                panel_1.add(lblNewLabel_1);
                                
                                    JLabel lblNewLabel_2 = new JLabel("Name");
                                    lblNewLabel_2.setBounds(712, 79, 104, 14);
                                    panel_1.add(lblNewLabel_2);
                                    
                                        textField = new JTextField();
                                        textField.setBounds(806, 76, 86, 20);
                                        panel_1.add(textField);
                                        textField.setColumns(10);
                                        
                                            JLabel lblCarLicense = new JLabel("Car license");
                                            lblCarLicense.setBounds(712, 104, 104, 14);
                                            panel_1.add(lblCarLicense);
                                            
                                                textField_1 = new JTextField();
                                                textField_1.setColumns(10);
                                                textField_1.setBounds(806, 104, 86, 20);
                                                panel_1.add(textField_1);
                                                
                                                    JLabel lblStudentId = new JLabel("Student ID");
                                                    lblStudentId.setBounds(712, 54, 104, 14);
                                                    panel_1.add(lblStudentId);
                                                    
                                                        textField_2 = new JTextField();
                                                        textField_2.setColumns(10);
                                                        textField_2.setBounds(806, 51, 86, 20);
                                                        panel_1.add(textField_2);
                                                        
                                                        JLabel lblNewLabel_5 = new JLabel("Gender");
                                                        lblNewLabel_5.setBounds(709, 129, 46, 14);
                                                        panel_1.add(lblNewLabel_5);
                                                        
                                                        JLabel lblNewLabel_6 = new JLabel("Phone Number");
                                                        lblNewLabel_6.setBounds(712, 154, 86, 14);
                                                        panel_1.add(lblNewLabel_6);
                                                        
                                                        textField_7 = new JTextField();
                                                        textField_7.setBounds(806, 129, 86, 20);
                                                        panel_1.add(textField_7);
                                                        textField_7.setColumns(10);
                                                        
                                                        textField_8 = new JTextField();
                                                        textField_8.setBounds(806, 154, 86, 20);
                                                        panel_1.add(textField_8);
                                                        textField_8.setColumns(10);
                                                        
                                                        JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
                                                        tabbedPane.addTab("Canceled Request", null, tabbedPane_1, null);
                                                        
                                                        JTabbedPane tabbedPane_3 = new JTabbedPane(JTabbedPane.TOP);
                                                        tabbedPane.addTab("Manual Add Ride", null, tabbedPane_3, null);
                                                        


                                                        JPanel panel_2 = new JPanel();
                                                        tabbedPane.addTab("Statistic ", null, panel_2, null);
                                                       

}
private void AddtoDriverInfoModel(ArrayList<Driver> Avil_driver) {
	DriverInfoModel.clear();
    for(int i =0; i <Avil_driver.size(); i++ )  
    	DriverInfoModel.addElement(Avil_driver.get(i));
}

@SuppressWarnings("unchecked")
public void addCRmodel(ArrayList<Client> new_client)// add to ClientRequest Model 
{
	Lmodel.clear();
    for(int i =0; i <new_client.size(); i++ )
    Lmodel.addElement(new_client.get(i).getName());
  
  }
public void addARmodel(ArrayList<Client> Accepted_client)// add to Accepted request model
{
	ARModel.clear();
    for(int i =0; i <Accepted_client.size(); i++ )
    ARModel.addElement(Accepted_client.get(i));

  }
public class DriverRenderer extends DefaultListCellRenderer {
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        if (value instanceof Driver) {
            setText(((Driver)value).getName());
            if(((Driver)value).getCurrentClient() != null )
            setBackground(Color.green);
        }
        return this;
    }
}
public class ClientRenderer extends DefaultListCellRenderer {
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        if (value instanceof Client) {
            setText(((Client)value).getName());
            if(((Client)value).getAssignedDriver() != null )
            setBackground(Color.green);
        }
        return this;
        
    }
}
}




