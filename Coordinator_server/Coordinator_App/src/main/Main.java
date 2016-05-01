package main;

import graphics.Coord;

import java.awt.EventQueue;

public class Main{

	public static void main(String[] args) {
		
		
		EventQueue.invokeLater(new Runnable() {
	        public void run() {
	            try {
	                Coord window = new Coord();
	                window.frame.setVisible(true);
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	    });

	}

}
