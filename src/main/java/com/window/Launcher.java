package com.window;

import javax.swing.SwingUtilities;

public class Launcher {

	public static void main(String[] args) {
		//THIS IS IMPORTANT AS THE LAUNCHER CLASS - LAUNCHES THE WINDOW CLASS.
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				//WHAT CLASS/OBJECT YOU PUT IN HERE IS WHAT WILL EXECUTE AS THE VISIABLE WINDOW:
				
				//FlowLayoutDemo frame = new FlowLayoutDemo();
				//BorderPaneDemo frame = new BorderPaneDemo();
				//MainWindow frame = new MainWindow();
				
				MainWindow frame = new MainWindow();
				
			}
		});

	}

}
