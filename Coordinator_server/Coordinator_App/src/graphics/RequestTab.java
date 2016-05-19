package graphics;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import managers.Client_Manager;
import entities.Client;
import graphics.TextAreaRenderer;

public class RequestTab extends JPanel{


	
	private DefaultListModel<Client> Lmodel = new DefaultListModel<Client>();
	private JTable Infotable= new JTable();
	private JTextField textField_3;
	private DefaultTableModel InfoViewModel = new DefaultTableModel();
	private ArrayList<Client> clientRequest= new ArrayList<Client>();	
	
	public DefaultListModel<Client> ARModel = new DefaultListModel<Client>();// accepted request model
	public ArrayList<Client> acceptList= new ArrayList<Client>();
	final JList<Client> acceptedList = new JList<Client>();

		JList<Client> ClientRequestList;
	    TableColumnModel cmodel = Infotable.getColumnModel(); 
	    TextAreaRenderer textAreaRenderer = new TextAreaRenderer();  
	public RequestTab()
     {	setLayout(null);
	 	
	    acceptedList.setBounds(10, 53, 201, 567);	
	    acceptedList.setCellRenderer(new ClientRenderer());   
	                          
	    
		final JButton AcceptButton = new JButton("Accept ");                   //accept button if clicked return nothing happen                                      
		AcceptButton.setEnabled(false);     
		AcceptButton.setBounds(676, 482, 89, 23);
		add(AcceptButton);
	                                      
		final JButton DenyButton = new JButton("Deny");                 // deny button if clicked return new InfoViewModel without the selected
		DenyButton.setEnabled(false);                                          
		DenyButton.setBounds(775, 482, 89, 23);
		add(DenyButton);      
		
		JLabel lblclientRequest = new JLabel("Client Request");
		lblclientRequest.setBounds(20, 24, 161, 14);
		add(lblclientRequest);
		ClientRequestList = new JList<Client>(Lmodel);
	    ClientRequestList.setBounds(20, 36, 161, 578);
	    add(ClientRequestList);
	    ClientRequestList.setCellRenderer(new ClientRenderer());	  
	    
	    JLabel lblClientsInfo = new JLabel("Client's Info");
	    lblClientsInfo.setBounds(367, 24, 497, 14);
	    add(lblClientsInfo);
	    JScrollPane scrollPane = new JScrollPane();  
	    scrollPane.setBounds(367, 36, 497, 435);
	    add(scrollPane);      
	   

	    scrollPane.setViewportView(Infotable);// client's info
	    
	    textField_3 = new JTextField();
	    textField_3.setBounds(374, 516, 497, 34);
	    add(textField_3);
	    textField_3.setColumns(10);

	    Infotable.getIgnoreRepaint();
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
	            InfoViewModel.addRow(new Object[]{"Name", ((Client) ClientRequestList.getSelectedValue()).getName()});
	            InfoViewModel.addRow(new Object[]{"Phone Number", ((Client) ClientRequestList.getSelectedValue()).getPhoneNumber()});
	            InfoViewModel.addRow(new Object[]{"Pick up Location",((Client) ClientRequestList.getSelectedValue()).getPickUpAddress()}); 
	            InfoViewModel.addRow(new Object[]{"Drop Off Location",((Client) ClientRequestList.getSelectedValue()).getDropOffAddress()});   
	            InfoViewModel.addRow(new Object[]{"Student ID",((Client) ClientRequestList.getSelectedValue()).getId()}); 
	            InfoViewModel.addRow(new Object[]{"Number of Clients",((Client) ClientRequestList.getSelectedValue()).getNumberOfClients() }); 
	            InfoViewModel.addRow(new Object[]{"Comments to Driver",((Client) ClientRequestList.getSelectedValue()).getOtherComments()}); 
	            
	             Infotable.setModel(InfoViewModel);
	          // cmodel.getColumn(1).setCellRenderer(textAreaRenderer);   /// need this for wrap around however repaint is disrupting for somereason
	             
	           
	                 DenyButton.setEnabled(true);      
	                 DenyButton.addActionListener(new ActionListener() {
	                 public void actionPerformed(ActionEvent  e) {
	                 if((!clientRequest.isEmpty())&&(ClientRequestList.getSelectedIndex()>=0))
	                  	 Client_Manager.getInstance().removeClient(ClientRequestList.getSelectedIndex());
	                 	ClientRequestList.clearSelection();  
	             
	                                                     
	                    }
	                   });
	                                                 AcceptButton.setEnabled(true);
	                                                 AcceptButton.addActionListener(new ActionListener() {
	                                                     public void actionPerformed(ActionEvent  e) {
	                                                    
	                  if((!clientRequest.isEmpty())&&(ClientRequestList.getSelectedIndex()>=0))   
	                 {
	                                                     	
	                	  acceptList.add(ClientRequestList.getSelectedValue());  
	                	  clientRequest.remove(ClientRequestList.getSelectedValue());
	                	  //acceptList.add(Client_Manager.getInstance().getClientAt(ClientRequestList.getSelectedIndex()));                                                    	 
	                      addARmodel(acceptList);
	                      acceptedList.setModel(ARModel);	                                                     	
	                      ClientRequestList.clearSelection();                               	
	                                                   
	                                                         }
	                                                         AcceptButton.setEnabled(false);
	                                                         DenyButton.setEnabled(false);
	                                                         
	                                                     }
	                                                 });
	                                           
	                                           
	                                         }
	                                     }}
	                                 });
	    
       
     }
	public JList<Client> getAcceptedList(){
		return this.acceptedList;
	}
	 @SuppressWarnings("unchecked")
	 public void addCRmodel(ArrayList<Client> new_client)// add to ClientRequest Model 
	 {
	 	Lmodel.clear();
	     for(int i =0; i <new_client.size(); i++ ){
	     Lmodel.addElement(new_client.get(i));
	    
	  }
	   }
	 public void addARmodel(ArrayList<Client> Accepted_client)// add to Accepted request model
	 {
	 	ARModel.clear();
	     for(int i =0; i <Accepted_client.size(); i++ ){
	     ARModel.addElement(Accepted_client.get(i));

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
	 
	 @Override
	public void paint(Graphics g) {
		super.paint(g);
		 int select = ClientRequestList.getSelectedIndex();
		 ArrayList<Client> clientList = Client_Manager.getInstance().getClientList();
		
		 for(Client ct : clientList)
		 {
			 if(!clientRequest.contains(ct) && !acceptList.contains(ct))
			 {
				 clientRequest.add(ct);
			 }
		 }
		 
		 addCRmodel(clientList);
		 
		
		 ClientRequestList.repaint();
		 if(Infotable != null)
			 Infotable.repaint();
		 ClientRequestList.setSelectedIndex(select);
		 
		 repaint(2000);
		 
	}
	 
}