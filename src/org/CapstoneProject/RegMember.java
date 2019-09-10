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
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.swing.ButtonGroup;
import javax.swing.ComboBoxEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class RegMember extends JFrame implements ActionListener {
	private JLabel vMemId, vMemPw1, vMemPw2, vMemName, vMemBirth, vMemPhone, vMemEmail, vMemAddr1, vMemAddr2, vMemAddr3, vGol;
	private JTextField xMemId, xMemName, xMemBirth, xMemPhone, xMemEmail1, xMemEmail2, xMemAddr1, xMemAddr2, xMemAddr3;
	private JPasswordField xMemPw1, xMemPw2;
	private String[] div = {"naver.com", "hanmail.com", "nate.com", "gmail.com", "�����Է�"};      
//	   private String[] col1 = {"�μ���", "�μ���ġ"};      
//	   private String[] col2 = {"�μ���", "����"};      
//	   private String[] div = {"������", "�ӽ���", "�����"};      // ������� �޺��ڽ��� ���
	         
//	   private DefaultTableModel model1 = new DefaultTableModel(col1, 0);      
//	   private DefaultTableModel model2 = new DefaultTableModel(col2, 0);      
		         
//	   private JTable eDept, eSpv;      
//	   private JScrollPane scrollpane1, scrollpane2;      
	
	private JButton BtCheckId, BtSearchAddr, BtRegist, BtCancel;
	private JComboBox CbEmail;
	
	String sid, sid2, ID, CUST_NM, PH_NUM, ADDR, BD, PWD, STdate;
//	static String STdate;
	int intid= 0;
	int check;
	GridBagLayout gbl;
	GridBagConstraints gbc;
	
	private void getData1(List<Map<String, Serializable>> idListData) {

		sid2 = "";
		sid2 += idListData.get(0).get("ID").toString(); 
		
		intid = Integer.parseInt(sid2);		
		
		if(intid == 0 ) {
			JOptionPane.showMessageDialog(null, "��밡���� ���̵� �Դϴ�","", JOptionPane.INFORMATION_MESSAGE);
			return;	
		}else 
			JOptionPane.showMessageDialog(null, "�ߺ��� ���̵� �Դϴ�","", JOptionPane.INFORMATION_MESSAGE);
			return;
	}
	
	public void getData2(List<Map<String, Serializable>> MbgraListData) {
		
		SimpleDateFormat spdate = new SimpleDateFormat("yyyy-MM-dd");
		
		STdate = "";
		STdate += MbgraListData.get(0).get("DISC_APP_ST_DT");
		
		String oldstring = STdate;
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").parse(oldstring);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String newstring = new SimpleDateFormat("yyyy-MM-dd").format(date);
		System.out.println(newstring);
		
		CustData.initCustData(ID, PWD, CUST_NM, BD, PH_NUM, ADDR, newstring );
		CustData.createCust();
	}
	
	public RegMember(JFrame fr) {

		gbl = new GridBagLayout();
		gbc = new GridBagConstraints(); 
		
		vMemId = new JLabel("���̵�");
		xMemId = new JTextField(22);
		
		BtCheckId = new JButton("�ߺ�Ȯ��");
		BtCheckId.addActionListener(this);
		
		vMemPw1 = new JLabel("��й�ȣ");
		xMemPw1 = new JPasswordField(22);
		
		vMemPw2 = new JLabel("��й�ȣ Ȯ��");
		xMemPw2 = new JPasswordField(22);
		
		vMemName = new JLabel("�̸�");
		xMemName = new JTextField(22);
		
		vMemBirth = new JLabel("�������");
		xMemBirth = new JTextField(22);

		
		vMemPhone = new JLabel("�޴��� ��ȣ");
		xMemPhone = new JTextField(22);
		
		vMemEmail = new JLabel("�̸���");
		vGol = new JLabel("@");
		xMemEmail1 = new JTextField(10);
		xMemEmail2 = new JTextField(10);
		CbEmail = new JComboBox<String>(div);
		CbEmail.addActionListener(this);
//		CbEmail = new JComboBox(div);
		
			
		vMemAddr1 = new JLabel("�ּ�");
		xMemAddr1 = new JTextField(22);
		BtSearchAddr = new JButton("�����ȣ �˻�");
		BtSearchAddr.addActionListener(this);
		vMemAddr2 = new JLabel("�⺻�ּ�");
		vMemAddr2.setFont(new Font("serif", Font.PLAIN, 12));
		vMemAddr3 = new JLabel("���ּ�");
		vMemAddr3.setFont(new Font("serif", Font.PLAIN, 12));
		
		xMemAddr2 = new JTextField(22);
		xMemAddr3 = new JTextField(22);
        
		BtRegist = new JButton("Ȯ��");
		BtRegist.addActionListener(this);
		BtCancel = new JButton("���");

		
		RegMemberView();
	}
	
	private void RegMemberView() {
		setExtendedState(MAXIMIZED_BOTH);
		setTitle("ȸ������");


		setLayout(gbl);
		
	    gbc.anchor = GridBagConstraints.CENTER;
		gridbagAdd(vMemId, 0, 0, 1, 1);
		gridbagAdd(xMemId, 1, 0, 3, 1);
		gridbagAdd(BtCheckId, 4, 0, 1, 1);  
		gridbagAdd(vMemPw1, 0, 1, 1, 1);
	    gridbagAdd(xMemPw1, 1, 1, 3, 1);
	    gridbagAdd(vMemPw2, 0, 2, 1, 1);
	    gridbagAdd(xMemPw2, 1, 2, 3, 1);
	    gridbagAdd(vMemName, 0, 3, 1, 1);
	    gridbagAdd(xMemName, 1, 3, 3, 1);
	    gridbagAdd(vMemBirth, 0, 4, 1, 1);
	    gridbagAdd(xMemBirth, 1, 4, 3, 1);
	    gridbagAdd(vMemPhone, 0, 5, 1, 1);
//	    gridbagAdd(vMemEmail, 0, 6, 1, 1);
	    gridbagAdd(xMemPhone, 1, 5, 3, 1);
//	    gridbagAdd(CbEmail, 4, 6, 1, 1);
	    gridbagAdd(vMemAddr1, 0, 6, 1, 1);
	    gridbagAdd(xMemAddr1, 1, 6, 3, 1);
	    gridbagAdd(BtSearchAddr, 4, 6, 1, 1);
	    gridbagAdd(vMemAddr2, 4, 7, 1, 1);
	    gridbagAdd(vMemAddr3, 4, 8, 1, 1);
	    gridbagAdd(xMemAddr2, 1, 7, 3, 1);
	    gridbagAdd(xMemAddr3, 1, 8, 3, 1);
//	    gridbagAdd(vGol, 2, 6, 1, 1);
	    

	    gbc.anchor = GridBagConstraints.WEST;
//	    gridbagAdd(xMemEmail1, 1, 6, 1, 1);
	    gridbagAdd(BtRegist, 1, 9, 1, 1);
	    gbc.anchor = GridBagConstraints.EAST;
	    gridbagAdd(BtCancel, 3, 9, 1, 1);
//	    gridbagAdd(xMemEmail2, 3, 6, 1, 1);
	    
	    gbc.anchor = GridBagConstraints.CENTER;

	         
//	    gridbagAdd(scrollpane1, 0, 11, 2, 1);
//	    gridbagAdd(scrollpane2, 2, 11, 2, 1);
//	    gridbagAdd(regist, 0, 12, 1, 1);
//	    gridbagAdd(cancel, 2, 12, 1, 1);
	    
	   
	    setVisible(true);
	}   
	         
	private void gridbagAdd(Component c, int x, int y, int w, int h) {   
		
		gbc.gridx = x;
		gbc.gridy = y; 
		//���� ���� �� gridx, gridy���� 0    
		
		gbc.gridwidth  = w;
		gbc.gridheight = h;
		
		
		gbl.setConstraints(c, gbc); //������Ʈ�� ������Ʈ ��ġ+ũ�� ������ ���� GridBagLayout�� ��ġ   
		
		add(c);   
		
	}   
	
	public static void main(String[] args) {   
		new RegMember(new JFrame());
		
	}   	
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == BtCheckId) {
			sid = "";
			sid += xMemId.getText();
			if(sid == " ") {
				System.out.println("���̵� ������");
			} else
			CheckId.initCustData(sid);
			getData1(CheckId.selectid());

		}
		
		String pw1 = new String(xMemPw1.getPassword());
		String pw2 = new String(xMemPw2.getPassword());
		System.out.println(xMemAddr2.getText() + " " + xMemAddr3.getText());
		if(e.getSource() == BtRegist) {
			if(!(pw1.equals(pw2))) {
				JOptionPane.showMessageDialog(null, "��й�ȣ�� ��ġ���� �ʽ��ϴ�","����", JOptionPane.ERROR_MESSAGE);
				return;
			}else				
				check = JOptionPane.showConfirmDialog(null, "ȸ������ �Ͻðڽ��ϱ�?", "��� Ȯ��", JOptionPane.YES_NO_OPTION,
						JOptionPane.INFORMATION_MESSAGE);			
			if(check == JOptionPane.YES_OPTION) {
				ID = xMemId.getText();
				PWD = new String(xMemPw1.getPassword());
				CUST_NM = xMemName.getText();
				BD = xMemBirth.getText();
				PH_NUM = xMemPhone.getText();
				ADDR = xMemAddr2.getText() + " " + xMemAddr3.getText();
				getData2(MbgraData.Mbgra());
				JOptionPane.showMessageDialog(null, "ȸ������ ���ԵǾ����ϴ�", "", JOptionPane.INFORMATION_MESSAGE);
				dispose();
			} else
				return;
		} else if(e.getSource() == BtSearchAddr) {
			Address s = new Address(new JFrame());
			xMemAddr1.setText(s.zipcode);
			xMemAddr2.setText(s.addr);
		}
		
	}
}
		


