package com.j2d.utils;

import java.awt.Dimension;

import javax.swing.JFrame;

import com.j2d.view.MainFrame;

public class WindowManager {

	public static void open(JFrame frame){
		centralizaTela(frame);
		frame.setVisible(true);
	}
	
	public static void centralizaTela(JFrame frame){
		if(frame instanceof MainFrame){
			Dimension paneSize = frame.getSize();
	         Dimension screenSize = frame.getToolkit().getScreenSize();
	         frame.setLocation( (screenSize.width - paneSize.width) / 2, (screenSize.height - paneSize.height) / 2);
		}else{
			Dimension paneSize = frame.getSize();
	        MainFrame current=MainFrame.getCurrent(); 
			Dimension screenSize = current.getSize();
	         frame.setLocation( current.getLocation().x+(screenSize.width - paneSize.width) / 2, current.getLocation().y+(screenSize.height - paneSize.height) / 2);
		}
		
	}
}
