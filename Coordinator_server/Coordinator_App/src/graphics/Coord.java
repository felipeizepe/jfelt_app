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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import threads.ClientServer;
import threads.DriverServer;
import entities.Client;
import entities.Driver;

 public class Coord {



public JFrame frame;



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

   
  //
    frame = new JFrame("SafeRide");
    //frame.setExtendedState(Frame.MAXIMIZED_BOTH);   //set to fullscreen default
   frame.setBounds(100, 100, 1369, 752);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(null);

    JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
    tabbedPane.setBounds(0, 0, 1510, 751);
    frame.getContentPane().add(tabbedPane);  
   
        
        
        
        //////////////////// server switch panel///////////////////////////////
    ServerSwitchTab ServerSwitchPanel = new ServerSwitchTab();
    tabbedPane.addTab("Server Switch", null, ServerSwitchPanel, null); 

                           
  ///////////////// Request panel /////////////////
    
    RequestTab RequestPanel = new RequestTab();
    tabbedPane.addTab("Request", null, RequestPanel, null);

//////////////Assign Driver
 AssignDriver AssignDriverPanel= new AssignDriver(RequestPanel.acceptedList);
 tabbedPane.addTab("Assign Driver", null, AssignDriverPanel, null);
   ////////////////// Driver Tab     
 
 DriverTab DriverPanel=new DriverTab(); 
 tabbedPane.addTab("Driver ", null, DriverPanel, null);
        
       
    
       
  /*                                                      
 JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP); //// iam wait till we finish priority tab first   
 tabbedPane.addTab("Canceled Request", null, tabbedPane_1, null);
                                                        
 JTabbedPane tabbedPane_3 = new JTabbedPane(JTabbedPane.TOP);//// iam wait till we finish priority tab first 
 tabbedPane.addTab("Manual Add Ride", null, tabbedPane_3, null);
 */
                                                        
/////////Statistic
 StatisticTab StatisticPanel = new StatisticTab();
 tabbedPane.addTab("Request", null, StatisticPanel, null);
                                                       

}



}




