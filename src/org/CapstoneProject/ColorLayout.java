package org.CapstoneProject;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.ColorModel;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ColorLayout extends JFrame implements ActionListener{
	
	static String[] color = {"BLACK", "BlUE", "CYAN", "DARK_GRAY", "GRAY", "GREEN", "LIGHT_GRAY", "ORANGE", "PINK", "RED", "WHITE", "YELLOW"};
	static JButton[] btn = new JButton[color.length];
	
	JButton vBlack, vBlue, vCyan, vDark_gray, vGray, vGreen, vLight_gray, vOrange, vMagenta, vPink, vRed, vWhite, vYellow;
	
	public ColorLayout() {
		Frame frame = new Frame();
		frame.setLayout(new GridLayout(3, 4, 0, 0));
		
		vBlack = new JButton("BLACK");
		vBlack.setBackground(Color.BLACK);
		vBlack.addActionListener(this);
		vBlue = new JButton("BLUE");
		vBlue.setBackground(Color.BLUE);
		vBlue.addActionListener(this);
		vCyan = new JButton("CYAN");
		vCyan.setBackground(Color.CYAN);
		vCyan.addActionListener(this);
		vDark_gray = new JButton("DARK_GRAY");
		vDark_gray.setBackground(Color.DARK_GRAY);
		vDark_gray.addActionListener(this);
		vGray = new JButton("GRAY");
		vGray.setBackground(Color.GRAY);
		vGray.addActionListener(this);
		vGreen = new JButton("GREEN");
		vGreen.setBackground(Color.GREEN);
		vGreen.addActionListener(this);
		vLight_gray = new JButton("LIGHT_GRAY");
		vLight_gray.setBackground(Color.LIGHT_GRAY);
		vLight_gray.addActionListener(this);
		vOrange = new JButton("ORANGE");
		vOrange.setBackground(Color.ORANGE);
		vOrange.addActionListener(this);
//		vMagenta = new JButton("MAGENTA");
//		vMagenta.setBackground(Color.MAGENTA);
		vPink = new JButton("PINK");
		vPink.setBackground(Color.PINK);
		vPink.addActionListener(this);
		vRed = new JButton("RED");
		vRed.setBackground(Color.RED);
		vRed.addActionListener(this);
		vWhite = new JButton("WHITE");
		vWhite.setBackground(Color.WHITE);
		vWhite.addActionListener(this);
		vYellow = new JButton("YELLOW");
		vYellow.setBackground(Color.YELLOW);
		vYellow.addActionListener(this);
		
		for(int i = 0; i<color.length; i++) {
			btn[i] = new JButton(color[i]);
		}
		
		frame.add(vBlack);
		frame.add(vBlue);
		frame.add(vCyan);
		frame.add(vDark_gray);
		frame.add(vGray);
		frame.add(vGreen);
		frame.add(vLight_gray);
//		frame.add(vMagenta);
		frame.add(vPink);
		frame.add(vRed);
		frame.add(vWhite);
		frame.add(vYellow);
		frame.add(vOrange);
		frame.setSize(500,300);
		frame.setVisible(true);
		
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				frame.dispose();
			}
	});
}

	public static void main(String[] args) {
		ColorLayout a = new ColorLayout();
		System.out.println(color[0]);
//		dispose();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == vBlack) {
			System.out.println(vBlack.getText());
		}else if(e.getSource() == vBlue) {
			System.out.println(vBlue.getText());
		}
	}
}

