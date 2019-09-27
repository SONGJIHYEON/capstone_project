
  
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
import java.util.Random;

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
import javax.swing.JOptionPane;



public class Nonmember extends JFrame implements ActionListener {
	private JLabel vNonmem1, vNonmem2, vNonmem3, vNonmemNm, vNonmemPh;
	private JTextField xNonmemId, xNonmemNm, xNonmemPh;
//	private JPasswordField xNonmemPwd;
	private String[] div = {"naver.com", "hanmail.com", "nate.com", "gmail.com", "직접입력"};      
//	   private String[] col1 = {"부서명", "부서위치"};      
//	   private String[] col2 = {"부서명", "성명"};      
//	   private String[] div = {"정규직", "임시직", "계약직"};      // 사원구분 콤보박스의 목록
	         
//	   private DefaultTableModel model1 = new DefaultTableModel(col1, 0);      
//	   private DefaultTableModel model2 = new DefaultTableModel(col2, 0);      
		         
//	   private JTable eDept, eSpv;      
//	   private JScrollPane scrollpane1, scrollpane2;      
	
	private JButton BtTempId, BtNonConnect;
	private JComboBox<String> CbEmail;
	
	String NONNM, NONPH;
	
	GridBagLayout gbl;
	GridBagConstraints gbc;
	
	public Nonmember(JFrame fr) {
		gbl = new GridBagLayout();
		gbc = new GridBagConstraints(); 
		
		vNonmem1 = new JLabel("비회원 접속");
		vNonmem2 = new JLabel("임시 ID를 발급 받으시고 ID를 입력하세요");
		vNonmem3 = new JLabel("고객의 이름과 휴대폰 번호를 입력하세요");
		vNonmemNm = new JLabel("고객명");
		vNonmemPh = new JLabel("휴대폰 번호");
		
		xNonmemId = new JTextField(20);
		xNonmemNm = new JTextField(20);
		xNonmemPh = new JTextField(20);

		BtTempId = new JButton("임시ID발급");
		BtTempId.setPreferredSize(new Dimension(100, 28));
		BtTempId.addActionListener(this);
		BtNonConnect = new JButton("비회원 접속");
		BtNonConnect.addActionListener(this);
		BtNonConnect.setPreferredSize(new Dimension(100, 28));
		
		NonmemberView();
	}
	
	private void NonmemberView() {
		setExtendedState(MAXIMIZED_BOTH);
		setTitle("회원가입");


		setLayout(gbl);
		
		gridbagAdd(vNonmemNm, 0, 4, 1, 1);
		gridbagAdd(vNonmemPh, 0, 5, 1, 1);
		gridbagAdd(vNonmem1, 1, 0, 1, 1);
		gridbagAdd(vNonmem2, 1, 1, 1, 1);
		gridbagAdd(vNonmem3, 1, 2, 1, 1);  
//		gridbagAdd(vNonmem4, 0, 3, 1, 1);
	    gridbagAdd(xNonmemId, 1, 3, 1, 1);
	    gridbagAdd(xNonmemNm, 1, 4, 1, 1);
	    gridbagAdd(xNonmemPh, 1, 5, 1, 1);
	    gridbagAdd(BtTempId, 2, 3, 1, 1);
	    gridbagAdd(BtNonConnect, 2, 5, 1, 1);
//	    gridbagAdd(xMemName, 1, 3, 1, 1);
//	    gridbagAdd(vMemBirth, 0, 4, 1, 1);
//	    gridbagAdd(xMemBirth, 1, 4, 1, 1);
//	    gridbagAdd(vMemPhone, 0, 5, 1, 1);
//	    gridbagAdd(xMemPhone, 1, 5, 1, 1);
//	    gridbagAdd(vMemEmail, 0, 6, 1, 1);
//	    gridbagAdd(xMemEmail1, 1, 6, 1, 1);
//	    gridbagAdd(xMemEmail2, 0, 6, 1, 1);
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
	
	public class RandomId {
		Random r = new Random();
		int x = (r.nextInt(900000)+100000);
	}
	
	public static void main(String[] args) {   
		new Nonmember(new JFrame());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == BtTempId) {
			RandomId rid = new RandomId();
			JOptionPane.showMessageDialog(null, "임시 아이디는 " + rid.x + " 입니다");
			String x = Integer.toString(rid.x);
			xNonmemId.setText(x);
		}
		
		if(e.getSource() == BtNonConnect) {
			NONNM = xNonmemNm.getText();
			NONPH = xNonmemPh.getText();
			CustData.initCustData2(NONNM, NONPH);
			CustData.createCust2();
		}
		
	}   
}	

