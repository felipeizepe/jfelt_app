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

public class StatisticTab extends JPanel{



	
	 public StatisticTab()
     {
	 	setLayout(null);
	 	
	 	JLabel lblTotalRequestOf = new JLabel("Total Request of the Day");
	 	lblTotalRequestOf.setBounds(10, 78, 183, 14);
	 	add(lblTotalRequestOf);
	 	
	 	JLabel lblTotalRequestOf_1 = new JLabel("Total Request of the Week");
	 	lblTotalRequestOf_1.setBounds(10, 123, 183, 14);
	 	add(lblTotalRequestOf_1);
	 	
	 	JLabel lblTotalRequestOf_2 = new JLabel("Total Request of the Month");
	 	lblTotalRequestOf_2.setBounds(10, 159, 183, 14);
	 	add(lblTotalRequestOf_2);
	 	
	 	JLabel lblNewLabel = new JLabel("New label");
	 	lblNewLabel.setBounds(203, 78, 168, 14);
	 	add(lblNewLabel);
	 	
	 	JLabel label = new JLabel("New label");
	 	label.setBounds(203, 123, 168, 14);
	 	add(label);
	 	
	 	JLabel label_1 = new JLabel("New label");
	 	label_1.setBounds(203, 159, 168, 14);
	 	add(label_1);
	 	
	 	JLabel lblNewLabel_1 = new JLabel("New label");
	 	lblNewLabel_1.setBounds(10, 197, 183, 14);
	 	add(lblNewLabel_1);
	 	
	 	JLabel label_2 = new JLabel("New label");
	 	label_2.setBounds(203, 197, 168, 14);
	 	add(label_2);
	 	
	 	JLabel lblPleaseFillWhat = new JLabel("Please fill what ever statistic you can think of thank you");
	 	lblPleaseFillWhat.setBounds(10, 652, 415, 14);
	 	add(lblPleaseFillWhat);
	 	
	 	JLabel lblNewLabel_2 = new JLabel("New label");
	 	lblNewLabel_2.setBounds(10, 234, 183, 14);
	 	add(lblNewLabel_2);
	 	
	 	JLabel label_3 = new JLabel("New label");
	 	label_3.setBounds(203, 234, 168, 14);
	 	add(label_3);
	 	
	 /// nothing at the moment
	                          
	    
		
     }
}