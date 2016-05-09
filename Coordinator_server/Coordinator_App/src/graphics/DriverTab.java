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

//import entities.Client;

//import entities.Client;
//import graphics.TextAreaRenderer;
//import graphics.Coord.ClientRenderer;

public class DriverTab extends JPanel{

	private JTable TotalDriverInfo;
	private JTextField DriverName;
	private JTextField DriverGender;
	private JTextField DriverPhone;
	private JTextField CarLicense;
	private JTextField StudentID;
	 public DriverTab()
     {
	 	setLayout(null);
	 	
	        
	            JButton btnUpdateDriverList = new JButton("Add Driver");
	            btnUpdateDriverList.addActionListener(new ActionListener() {
	                public void actionPerformed(ActionEvent e) {
	                }
	            });
	            btnUpdateDriverList.setBounds(712, 197, 194, 48);
	            add(btnUpdateDriverList);
	        
	                JButton btnRemoveDriver = new JButton("Remove Driver ");
	                btnRemoveDriver.addActionListener(new ActionListener() {
	                    public void actionPerformed(ActionEvent e) {
	                    }
	                });
	                btnRemoveDriver.setBounds(10, 602, 194, 48);
	               add(btnRemoveDriver);
	                
	                    JLabel lblNewLabel = new JLabel("Driver List");
	                    lblNewLabel.setBounds(10, 40, 238, 14);
	                   add(lblNewLabel);
	                    
	                        JList TotalDriverList = new JList();
	                        TotalDriverList.setBounds(10, 53, 238, 535);
	                        add(TotalDriverList);
	                        
	                            TotalDriverInfo = new JTable();
	                            TotalDriverInfo.setBounds(275, 54, 427, 535);
	                            add(TotalDriverInfo);
	                            
	                                JLabel lblNewLabel_1 = new JLabel("Driver Info");
	                                lblNewLabel_1.setBounds(275, 40, 427, 14);
	                                add(lblNewLabel_1);
	                                
	                                    JLabel lblNewLabel_2 = new JLabel("Name");
	                                    lblNewLabel_2.setBounds(712, 79, 104, 14);
	                                    add(lblNewLabel_2);
	                                    
	                                        DriverName = new JTextField();
	                                        DriverName.setBounds(806, 76, 86, 20);
	                                        add(DriverName);
	                                        DriverName.setColumns(10);
	                                        
	                                            JLabel lblCarLicense = new JLabel("Car license");
	                                            lblCarLicense.setBounds(712, 104, 104, 14);
	                                            add(lblCarLicense);
	                                            
	                                                CarLicense = new JTextField();
	                                                CarLicense.setColumns(10);
	                                                CarLicense.setBounds(806, 104, 86, 20);
	                                                add(CarLicense);
	                                                
	                                                    JLabel lblStudentId = new JLabel("Student ID");
	                                                    lblStudentId.setBounds(712, 54, 104, 14);
	                                                    add(lblStudentId);
	                                                    
	                                                        StudentID = new JTextField();
	                                                        StudentID.setColumns(10);
	                                                        StudentID.setBounds(806, 51, 86, 20);
	                                                        add(StudentID);
	                                                        
	                                                        JLabel lblNewLabel_5 = new JLabel("Gender");
	                                                        lblNewLabel_5.setBounds(709, 129, 46, 14);
	                                                        add(lblNewLabel_5);
	                                                        
	                                                        JLabel lblNewLabel_6 = new JLabel("Phone Number");
	                                                        lblNewLabel_6.setBounds(712, 154, 86, 14);
	                                                        add(lblNewLabel_6);
	                                                        
	                                                        DriverGender = new JTextField();
	                                                        DriverGender.setBounds(806, 129, 86, 20);
	                                                        add(DriverGender);
	                                                        DriverGender.setColumns(10);
	                                                        
	                                                        DriverPhone = new JTextField();
	                                                        DriverPhone.setBounds(806, 154, 86, 20);
	                                                       add(DriverPhone);
	                                                        DriverPhone.setColumns(10);
	 
	                          
	    
		
}
}