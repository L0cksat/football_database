package com.window;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainWindow {

	private JFrame frame;
	private JPanel panel;
	private JButton button;
	private JLabel label;
	
	public MainWindow() {
		initialize();
		show();
	}
	
	public void initialize() {
		frame = new JFrame();
		frame.setTitle("Football Database V1.0 - Created by Stephen Nicholas Jones De Giorgi 2025");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(800, 500);
		frame.setLayout(new BorderLayout(10, 10));
		frame.setLocationRelativeTo(null);
		ImageIcon panelIcon = new ImageIcon("images/soccer-player.png");
		frame.setIconImage(panelIcon.getImage());
		
		panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		panel.setBackground(Color.GRAY);
		frame.add(panel, BorderLayout.NORTH);
		
		label = new JLabel("Football Database");
		panel.add(label);
		
		//YOU CAN CHANGE THE COLOR OF THE TEXT AND THE FONT.
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Sans-serif", Font.BOLD, 36));
		
		//HERE YOU CAN ADD A GRAPHIC/IMAGE TO THE LABEL.
		ImageIcon labelIcon = new ImageIcon("images/football_big.png");
		label.setIcon(labelIcon);
		
		//ADDS A GAP BETWEEN THE GRAPHIC AND THE TEXT
		label.setIconTextGap(10);
		
		//THIS CHANGES THE PLACEMENT OF THE TEXT AND THE GRAPHIC.
		//label.setVerticalTextPosition(SwingConstants.BOTTOM);
		//label.setHorizontalTextPosition(SwingConstants.CENTER);
		
		button = new JButton("Create");
		
		button.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				label.setText("<html>Football Database<br>Coming Soon!</html>");
			}
			
		});
		
		frame.add(button, BorderLayout.SOUTH);
	}
	
	public void show() {
		this.frame.setVisible(true);
	}
}