package org.CapstoneProject;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class home_user extends JFrame implements ActionListener {
	private JLabel vHomeIcon, vViewIcon, vTop, vBottom, vOuter, vShirts, vShoes, v1;
//	private JTextField xMemId, xMemName, xMemBirth, xMemPhone, xMemEmail1, xMemEmail2, xMemAddr1, xMemAddr2, xMemAddr3;
//	private JPasswordField xMemPw1, xMemPw2;
//	private String[] div = {"naver.com", "hanmail.com", "nate.com", "gmail.com", "직접입력"};      
	private String[] col1 = {"best"};      
	private String[] col2 = {"new"};      
	
//  private String[] div = {"정규직", "임시직", "계약직"};    // 사원구분 콤보박스의 목록
	
	private DefaultTableModel model1 = new DefaultTableModel(col1, 0);      
	private DefaultTableModel model2 = new DefaultTableModel(col2, 0);      
	private JTable tBest, tNew;      
	private JScrollPane scrollpane1, scrollpane2;   
	private JButton  vManage, vCenter, vBasket, vMypage, vLogout;
	private JComboBox<String> CbEmail;
	
	GridBagLayout gbl;
	GridBagConstraints gbc;
	
	public home_user() {
		gbl = new GridBagLayout();
		gbc = new GridBagConstraints(); 
		
		vHomeIcon = new JLabel("이미지");
//		vHomeIcon.setPreferredSize(new Dimension(100,28));
		v1 = new JLabel("");
		v1.setPreferredSize(new Dimension(200,28));
		vCenter = new JButton("고객센터");
		vCenter.setPreferredSize(new Dimension(200,28));
		vCenter.addActionListener(this);
		vBasket = new JButton("장바구니");
		vBasket.setPreferredSize(new Dimension(200,28));
		vMypage = new JButton("마이페이지");
		vMypage.setPreferredSize(new Dimension(200,28));
		vLogout = new JButton("로그아웃");
		vLogout.setPreferredSize(new Dimension(200,28));
		
		vViewIcon = new JLabel("이미지");
//		vViewIcon.setPreferredSize(new Dimension(100,28));
		vTop = new JLabel("상의");
		vBottom = new JLabel("하의");
		vOuter = new JLabel("아우터");
		vShirts = new JLabel("셔츠");
		vShoes = new JLabel("신발");

		tBest = new JTable(model1);
		scrollpane1 = new JScrollPane(tBest);
		scrollpane1.setPreferredSize(new Dimension(1000, 100));
		
		tNew = new JTable(model2);
		scrollpane2 = new JScrollPane(tNew);
		scrollpane2.setPreferredSize(new Dimension(1000, 100));
		setExtendedState(MAXIMIZED_BOTH);
		home_userView();

	}
	
	private void home_userView() {

		setTitle("홈페이지 유저");


		setLayout(gbl);
		
		gridbagAdd(vHomeIcon, 0, 0, 1, 1);
		gridbagAdd(v1, 1, 0, 1, 1);
	    gridbagAdd(vCenter, 2, 0, 1, 1);
	    gridbagAdd(vBasket, 3, 0, 1, 1);
	    gridbagAdd(vMypage, 4, 0, 1, 1);
	    gridbagAdd(vLogout, 5, 0, 1, 1);
	    gridbagAdd(vViewIcon, 0, 1, 1, 1);
	    gridbagAdd(vTop, 1, 1, 1, 1);
	    gridbagAdd(vBottom, 2, 1, 1, 1);
	    gridbagAdd(vOuter, 3, 1, 1, 1);
	    gridbagAdd(vShirts, 4, 1, 1, 1);
	    gridbagAdd(vShoes, 5, 1, 1, 1);
	         
//	    gridbagAdd(scrollpane1, 1, 2, 5, 1);
//	    gridbagAdd(scrollpane2, 1, 6, 6, 1);
//	    gridbagAdd(regist, 0, 12, 1, 1);
//	    gridbagAdd(cancel, 2, 12, 1, 1);
		
	    
	   
	    setVisible(true);
	}   
	         
	private void gridbagAdd(Component c, int x, int y, int w, int h) {   
		
		gbc.gridx = x;
		gbc.gridy = y; 
		
		//가장 왼쪽 위 gridx, gridy값은 0    
		
		gbc.gridwidth  = w;
		gbc.gridheight = h;
		
		
		gbl.setConstraints(c, gbc); //컴포넌트를 컴포넌트 위치+크기 정보에 따라 GridBagLayout에 배치   
		
		add(c);   
		
	}   
	
	public static void main(String[] args) {   
		new home_user();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == vCenter) {
			getContentPane().removeAll();
			BackgroundPanel sub = new BackgroundPanel();
	         gridbagAdd(sub, 0, 0, 10, 10);
		}
		
	}   
}	

	
			