package graphics;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import graphics.RequestTab;

import entities.Client;
import entities.Driver;
import entities.Client;
import graphics.TextAreaRenderer;
import managers.Client_Manager;
import managers.Driver_Manager;



public class AssignDriver extends JPanel{

	//private Driver Dtest = new Driver("DRIVER TEST 1", "13","PHONE N3", "LICENSE NUM", "CAR DESCRIPT");
	private JTable ClientInfoView;
	private DefaultTableModel InfoViewModel = new DefaultTableModel();
	private ArrayList<Client> clientRequest= new ArrayList<Client>();
	private ArrayList<Driver> DAvil= new ArrayList<Driver>();
	private DefaultListModel<Driver> DriverInfoModel= new DefaultListModel<Driver>();
	private DefaultTableModel DriverViewModel = new DefaultTableModel();
	private JTable DriverInfoView;
	public JFrame frame;
	  JList<Driver> Avil_Driver = new JList<Driver>();
	public AssignDriver(JList acceptedList)
     {
	 	setLayout(null);

	    
	    
	 	
	  //  DAvil.add(Dtest);
	 
	    
	 RequestTab RequestPanel= new RequestTab();
	 	 add(acceptedList);
	 
	 	ClientInfoView = new JTable();
	    ClientInfoView.setBounds(718, 54, 499, 262);
	    add(ClientInfoView);
	    TableColumnModel cmodel = ClientInfoView.getColumnModel(); 
	    TextAreaRenderer textAreaRenderer = new TextAreaRenderer(); 
	
	    acceptedList.addListSelectionListener(new ListSelectionListener() {

	     	 @Override
	          public void valueChanged(ListSelectionEvent arg0) {
	              if (acceptedList.getSelectedValue() != null)
	              {
	             	 //ClientRequestList.clearSelection();
	             	//AcceptButton.setEnabled(false);
	             //   DenyButton.setEnabled(false);

	              if (!arg0.getValueIsAdjusting()) 
	              {
	             	
	                  final DefaultTableModel EmptyTableModel = new DefaultTableModel(); //  to clear inforview table everytime a different item is selected
	                  InfoViewModel=                  EmptyTableModel;
	                  ClientInfoView.setModel(InfoViewModel);//                                         
	                  InfoViewModel.addColumn("Client's Attribute");
	                  InfoViewModel.addColumn("Client's Attribute Value");        
	                  InfoViewModel.addRow(new Object[]{"Name", ((Client) acceptedList.getSelectedValue()).getName()});
	                  InfoViewModel.addRow(new Object[]{"Phone Number", ((Client) acceptedList.getSelectedValue()).getPhoneNumber()});
	                  InfoViewModel.addRow(new Object[]{"Pick Up Location",((Client) acceptedList.getSelectedValue()).getPickUpAddress() });
	                  InfoViewModel.addRow(new Object[]{"Drop Off Location",((Client) acceptedList.getSelectedValue()).getDropOffAddress() });
	                  InfoViewModel.addRow(new Object[]{"Student ID",((Client) acceptedList.getSelectedValue()).getId() });
	                  InfoViewModel.addRow(new Object[]{"Number of Clients",((Client) acceptedList.getSelectedValue()).getNumberOfClients() });
	                  InfoViewModel.addRow(new Object[]{"Comments to Driver",((Client) acceptedList.getSelectedValue()).getOtherComments() });
	               try{
	                 	  InfoViewModel.addRow(new Object[]{"Assiged Driver",((Client) acceptedList.getSelectedValue()).getAssignedDriver().getName() });
	               }catch (Exception  ex){ 
	               }
	               
	                  ClientInfoView.setModel(InfoViewModel);                 
	                  cmodel.getColumn(1).setCellRenderer(textAreaRenderer);              
	              }
	              }
	     }});
	     
	     	AddtoDriverInfoModel(DAvil);
	     	RequestPanel.addCRmodel(clientRequest);                      
	        JLabel lblClientForThe = new JLabel("Clients");
	        lblClientForThe.setBounds(10, 38, 205, 14);
	        add(lblClientForThe);
	        
	        JLabel lblAcceptedClientFor = new JLabel("Driver");
	        lblAcceptedClientFor.setBounds(434, 38, 205, 14);
	        add(lblAcceptedClientFor);
	        
	        JScrollPane scrollPane_2 = new JScrollPane();
	        scrollPane_2.setBounds(434, 53, 203, 569);
	        add(scrollPane_2);
	        
	      
	       
	        scrollPane_2.setViewportView(Avil_Driver);
	        Avil_Driver.setModel(DriverInfoModel);
	        Avil_Driver.setCellRenderer(new DriverRenderer());
	        Avil_Driver.addListSelectionListener(new ListSelectionListener() {

	        	 @Override
	             public void valueChanged(ListSelectionEvent arg0) {
	                 if (Avil_Driver.getSelectedValue() != null)
	                 {        	
	                 if (!arg0.getValueIsAdjusting()) 
	                 {   final DefaultTableModel EmptyTableModel = new DefaultTableModel(); //  to clear inforview table everytime a different item is selected
	                     DriverViewModel=                  EmptyTableModel;
	                     DriverInfoView.setModel(InfoViewModel);//                                         
	                     DriverViewModel.addColumn("Driver Attribute");
	                     DriverViewModel.addColumn("Driver Attribute Value");        
	                     DriverViewModel.addRow(new Object[]{"Name", DAvil.get(Avil_Driver.getSelectedIndex()).getName()});
	                     DriverViewModel.addRow(new Object[]{"Phone Number", DAvil.get(Avil_Driver.getSelectedIndex()).getPhoneNumber()});   
	                     DriverViewModel.addRow(new Object[]{"Student ID", DAvil.get(Avil_Driver.getSelectedIndex()).getId()}); 
	                     DriverViewModel.addRow(new Object[]{"Car License", DAvil.get(Avil_Driver.getSelectedIndex()).getLicense()}); 
	                     try{
	                     DriverViewModel.addRow(new Object[]{"Current Client Assigment", DAvil.get(Avil_Driver.getSelectedIndex()).getCurrentClient().getName()});
	                     }catch (Exception  ex){ 
	                 }
	                 
	                     DriverInfoView.setModel(DriverViewModel);
	                 }
	                 }
	        }});
	        
	        JButton btnAssign = new JButton("Assign");
	    	//btnAssign.setEnabled(false);
	        btnAssign.addActionListener(new ActionListener() {
	        	@SuppressWarnings("unchecked")
				public void actionPerformed(ActionEvent e) {
	        		try{
	        			
	        			/// index error because Driver_Manager has no size
	        			Client client = Client_Manager.getInstance().getClientAt(acceptedList.getSelectedIndex());
	        			Driver driver = Driver_Manager.getInstance().getDriverAt(Avil_Driver.getSelectedIndex());
	        			if((client.hasDriver()==false)&&(driver.hasRide()==false))
	        			{
	        				 Driver_Manager.getInstance().assignClientToDriver(Avil_Driver.getSelectedIndex(), client);
	        				 Client_Manager.getInstance().assignDriverToClient(acceptedList.getSelectedIndex(), driver);
	        				 acceptedList.remove(acceptedList.getSelectedIndex());
	        		
	        		}else
	        			JOptionPane.showMessageDialog(frame, "Error! The driver is currently in mission. Please double check.");
	        		
	        	}catch(Exception ex){
	        			JOptionPane.showMessageDialog(frame, "Error! Please Select Your Client And Driver. Thank You." +ex);
	        		}
	        }});
	        btnAssign.setBounds(271, 320, 118, 23);
	        add(btnAssign);
	        
	   
	        
	        JLabel lblObjectsInfo = new JLabel("Client's Infomation");
	        lblObjectsInfo.setBounds(718, 38, 107, 14);
	        add(lblObjectsInfo);
	        
	        JScrollPane scrollPane_1 = new JScrollPane();
	        scrollPane_1.setBounds(718, 361, 499, 262);
	        add(scrollPane_1);
	       
	        DriverInfoView = new JTable();
	        scrollPane_1.setViewportView(DriverInfoView);
	        
	        JLabel lblDriversInformation = new JLabel("Driver 's Information");
	        lblDriversInformation.setBounds(716, 336, 109, 14);
	        add(lblDriversInformation);
	        /*////////////////////////********************* code for removing the client **************************************
	        JButton btnRemoveColor = new JButton("remove color"); //// just for testing can delete and will delete
	        btnRemoveColor.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		//((Driver) Avil_Driver.getSelectedValue()).AssignClient(null);   // this line of code change the color back to normal    
	        		if((RequestPanel.ARModel.size()>-1)&&(acceptedList.getSelectedIndex()>=0)){
	        			RequestPanel.acceptList.remove(acceptedList.getSelectedIndex());
	        			RequestPanel.ARModel.remove(acceptedList.getSelectedIndex());
	        		}else{System.out.print(" There is no more client ");}
	        	}
	        });
	        btnRemoveColor.setBounds(271, 379, 118, 23);
	       add(btnRemoveColor);
	        */
	       JLabel lblGreenColor = new JLabel("Green Color = Client is assigned");
	        lblGreenColor.setBounds(434, 622, 205, 14);
	       add(lblGreenColor);
	        /*
	        JLabel lblGreenColor_1 = new JLabel("Green Color = Driver is assigned");
	        lblGreenColor_1.setBounds(10, 622, 205, 14);
	       add(lblGreenColor_1);*/
	       
	       JLabel lblGreyColor = new JLabel("Grey Color = Selected");
	       lblGreyColor.setBounds(271, 442, 118, 14);
	       add(lblGreyColor);
	        
	        
		
}
	 private void AddtoDriverInfoModel(ArrayList<Driver> Avil_driver) {
			DriverInfoModel.clear();
		    for(int i =0; i <Avil_driver.size(); i++ )  
		    	DriverInfoModel.addElement(Avil_driver.get(i));
		}

	 @Override
	public void paint(Graphics g) {
		super.paint(g);
		 int select = Avil_Driver.getSelectedIndex();
		 ArrayList<Driver> DriverList = Driver_Manager.getInstance().getDriverList();
		
		 for(Driver ct : DriverList)
		 {
			 if(!DAvil.contains(ct))
			 {
				 DAvil.add(ct);
			 }
		 }
		 
		 AddtoDriverInfoModel(DriverList);
		 
		
		 Avil_Driver.repaint();
		 
		 Avil_Driver.setSelectedIndex(select);
		 
		 repaint(2000);
		 
	}
}