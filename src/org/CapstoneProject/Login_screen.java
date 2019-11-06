package org.CapstoneProject;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Login_screen extends JFrame {

	private static Image originImg, changedImg;
	private static ImageIcon originIcon, Icon_top, Icon_Left, Icon_Right;

	JPanel Login = new Login();
	JLabel img_top, img_left, img_right;
	Dimension d = Toolkit.getDefaultToolkit().getScreenSize();

	public Login_screen() {

		setLayout(null);

		img_top = new JLabel("");
		img_left = new JLabel("");
		img_right = new JLabel("");
		Login.setBounds(d.width / 4, 100, d.width * 2 / 4, d.height - 100);

		originIcon = new ImageIcon("C:\\Users\\ssong\\Desktop\\img\\로그인 상단.jpg");
		originImg = originIcon.getImage();
		changedImg = originImg.getScaledInstance(d.width, 100, Image.SCALE_SMOOTH);
		Icon_top = new ImageIcon(changedImg);
		img_top.setIcon(Icon_top);
		img_top.setBounds(0, 0, d.width, 100);

		originIcon = new ImageIcon("C:\\Users\\ssong\\Desktop\\img\\로그인 좌측.jpg");
		originImg = originIcon.getImage();
		changedImg = originImg.getScaledInstance(d.width / 4, d.height - 100, Image.SCALE_SMOOTH);
		Icon_Left = new ImageIcon(changedImg);
		img_left.setIcon(Icon_Left);
		img_left.setBounds(0, 100, d.width / 4, d.height - 100);

		originIcon = new ImageIcon("C:\\Users\\ssong\\Desktop\\img\\로그인 우측.png");
		originImg = originIcon.getImage();
		changedImg = originImg.getScaledInstance(d.width / 4, d.height - 100, Image.SCALE_SMOOTH);
		Icon_Right = new ImageIcon(changedImg);
		img_right.setIcon(Icon_Right);
		img_right.setBounds(d.width * 3 / 4, 100, d.width / 4, d.height - 100);

		add(Login);
		add(img_top);
		add(img_left);
		add(img_right);

		Login.setBackground(Color.white);
		getContentPane().setBackground(Color.white);
		setSize(d.width, d.height);
		setResizable(false);
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Login_screen();
	}

}