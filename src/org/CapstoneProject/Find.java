package org.CapstoneProject;

import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.TextField;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class Find extends JFrame {
	private JLabel vFindId, vNm, vEmailAddr;
	private JTextField xNm, xEmailAddr;
//	private JPasswordField xMemPw1, xMemPw2;
//	private String[] div = {"naver.com", "hanmail.com", "nate.com", "gmail.com", "직접입력"};      
//	   private String[] col1 = {"부서명", "부서위치"};      
//	   private String[] col2 = {"부서명", "성명"};      
//	   private String[] div = {"정규직", "임시직", "계약직"};      // 사원구분 콤보박스의 목록
	         
//	   private DefaultTableModel model1 = new DefaultTableModel(col1, 0);      
//	   private DefaultTableModel model2 = new DefaultTableModel(col2, 0);      
		         
//	   private JTable eDept, eSpv;      
//	   private JScrollPane scrollpane1, scrollpane2;      
	
	private JButton BtCheck;
//	private JComboBox<String> CbEmail;
	
	GridBagLayout gbl;
	GridBagConstraints gbc;
	
	public Find(JFrame fr) {
		gbl = new GridBagLayout();
		gbc = new GridBagConstraints(); 
		
		vFindId = new JLabel("ID/PW 찾기");
				
		vNm= new JLabel("이름");
		xNm = new JTextField(15);
				
		vEmailAddr = new JLabel("휴대폰번호");
		xEmailAddr = new JTextField(15);
		
		BtCheck = new JButton("확인");
				
		FindView();
	}
	
	private void FindView() {
		setExtendedState(MAXIMIZED_BOTH);
		setTitle("ID 찾기");


		setLayout(gbl);
		

		gridbagAdd(vFindId, 1, 0, 2, 1);
		gridbagAdd(vNm, 0, 1, 1, 1);
		gridbagAdd(xNm, 1, 1, 1, 1);  
		gridbagAdd(vEmailAddr, 0, 2, 1, 1);
	    gridbagAdd(xEmailAddr, 1, 2, 1, 1);
	    
	    gridbagAdd(BtCheck, 1, 3, 2, 1);
//	    gridbagAdd(xMemPw2, 1, 2, 1, 1);
//	    gridbagAdd(vMemName, 0, 3, 1, 1);
//	    gridbagAdd(xMemName, 1, 3, 1, 1);
//	    gridbagAdd(vMemBirth, 0, 4, 1, 1);
//	    gridbagAdd(xMemBirth, 1, 4, 1, 1);
//	    gridbagAdd(vMemPhone, 0, 5, 1, 1);
//	    gridbagAdd(xMemPhone, 1, 5, 1, 1);
//	    gridbagAdd(vMemEmail, 0, 6, 1, 1);
//	    gridbagAdd(xMemEmail1, 1, 6, 1, 1);
//		gridbagAdd(xMemEmail2, 0, 6, 1, 1);
//	    gridbagAdd(CbEmail, 2, 6, 1, 1);
//	    gridbagAdd(vMemAddr1, 0, 7, 1, 1);
//	    gridbagAdd(xMemAddr1, 1, 7, 1, 1);
//	    gridbagAdd(BtSearchAddr, 2, 7, 1, 1);
//	    gridbagAdd(xMemAddr2, 1, 8, 1, 1);
//	    gridbagAdd(vMemAddr2, 2, 8, 1, 1);
//	    gridbagAdd(xMemAddr3, 1, 9, 1, 1);
//	    gridbagAdd(vMemAddr3, 2, 9, 1, 1);
//	    
//
//	    gridbagAdd(BtRegist, 1, 10, 1, 1);
//	    gridbagAdd(BtCancel, 1, 10, 3, 1);
//	    

	         
//	    gridbagAdd(scrollpane1, 0, 11, 2, 1);
//	    gridbagAdd(scrollpane2, 2, 11, 2, 1);
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
		new Find(new JFrame());
	}   
}	

	
			