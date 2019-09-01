package org.CapstoneProject;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Login extends JFrame implements ActionListener {   
	private JLabel vLabel1, vLabel2, vLabel3, vLabel4, vLabel5, vId, vPwd;      
	         
	private JTextField xEmpName, xEmpPhone, xEmpRegist, xEmpHireDate, xDeptName, xEmpSal, xSpvName, xEmpAnin, xEmpComm, xId, xPwd;      
	   
	private String[] col1 = {"�μ���", "�μ���ġ"};      
	private String[] col2 = {"�μ���", "����"};      
	private String[] div = {"������", "����"}; // ������� �޺��ڽ��� ���
	         
	private DefaultTableModel model1 = new DefaultTableModel(col1, 0);      
	private DefaultTableModel model2 = new DefaultTableModel(col2, 0);      
	   
       
	private JTable eDept, eSpv;      
	private JScrollPane scrollpane1, scrollpane2;      
	         
	private JButton BtLogin, BtRegMb, BtFind, Btnonmember;      
	private JComboBox<String> cbSel;    
	
	String sid, sid2, pwd, pwd2;
	         
	GridBagLayout gridbaglayout;      
	GridBagConstraints gridbagconstraints;      // gridbag���̾ƿ��� ������Ʈ�� ��ġ�� ����ִ� ����
	
	private void getData(List<Map<String, Serializable>> idListData) {
		
		if(pwd.equals(pwd2)) {
			System.out.println("��ġ");
		}else
			System.out.println("����ġ");

}
	         
	public Login() {
		gridbaglayout = new GridBagLayout();
		gridbagconstraints = new GridBagConstraints();       
	         
	    vLabel1 = new JLabel("Login");     
	    vLabel2 = new JLabel("ȸ������ �Ͻø� �پ��� ������ �������� �� �ֽ��ϴ�.");
	         
	    cbSel = new JComboBox<String>(div);
	    cbSel.setPreferredSize(new Dimension(203, 20));

        xId = new JTextField(20);
        xPwd = new JTextField(20);
       	                  
        vLabel3 = new JLabel("���� ȸ���� �ƴϽŰ���?");
        vLabel4 = new JLabel("���̵�/��й�ȣ�� �����̳���?");
        vLabel5= new JLabel("��ȸ������ �̿��ϰڽ��ϱ�?");
	         
	         
        BtLogin = new JButton("�α���");
        BtLogin.setPreferredSize(new Dimension(100, 30));
        BtLogin.addActionListener(this);
        BtRegMb = new JButton("ȸ������");
        BtRegMb.setPreferredSize(new Dimension(100, 30));
        BtRegMb.addActionListener(this);
        BtFind = new JButton("ID/PW ã��");
        BtFind.setPreferredSize(new Dimension(100, 30));
        BtFind.addActionListener(this);
        Btnonmember = new JButton("��ȸ�� ����");
        Btnonmember.setPreferredSize(new Dimension(100, 30));
        Btnonmember.addActionListener(this);
//	         getDeptData(EmpData.selectDept());
//	         getSvpData(EmpData.selectSpv());
        
        LoginView();
      }   
	         
	private void LoginView() {
		setTitle("Login ȭ��");
	         
	    gridbagconstraints.anchor = GridBagConstraints.WEST;
//	    gridbagconstraints.ipadx = 7;
//	    
//	    gridbagconstraints.weightx=1.0;
//      gridbagconstraints.weighty=1.0;
         
        setLayout(gridbaglayout);       
        gridbagconstraints.anchor = GridBagConstraints.CENTER;
	        
        gridbagAdd(vLabel1, 0, 0, 2, 1);
        gridbagAdd(vLabel2, 0, 1, 2, 1);
        
        gridbagAdd(cbSel, 0, 2, 3, 1);
        gridbagAdd(xId, 0, 3, 2, 1);
        gridbagAdd(xPwd, 0, 4, 2, 1);
        gridbagAdd(BtLogin, 3, 3, 2, 2);      
        gridbagAdd(vLabel3, 0, 5, 2, 1);
        gridbagAdd(vLabel4, 0, 6, 2, 1);
        gridbagAdd(vLabel5, 0, 7, 2, 1);
       
       

        gridbagconstraints.anchor = GridBagConstraints.CENTER;    
        gridbagAdd(BtRegMb, 3, 5, 1, 1);
        gridbagAdd(BtFind, 3, 6, 1, 1);
        gridbagAdd(Btnonmember, 3, 7, 1, 1);
        
        setExtendedState(MAXIMIZED_BOTH);
	    setVisible(true);
	}
	private void gridbagAdd(Component c, int x, int y, int w, int h) {   
		gridbagconstraints.gridx = x;
        gridbagconstraints.gridy = y; 
	            //���� ���� �� gridx, gridy���� 0    
	         
        gridbagconstraints.gridwidth  = w;
        gridbagconstraints.gridheight = h;
	               
        gridbaglayout.setConstraints(c, gridbagconstraints); //������Ʈ�� ������Ʈ ��ġ+ũ�� ������ ���� GridBagLayout�� ��ġ   
	         
        add(c);   
	         
     }   
	public static void main(String[] args) {   
		new Login();
    	 }   
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == BtRegMb) {
			RegMember r = new RegMember(new JFrame());

		} else if(e.getSource() == BtFind) {
			Find f = new Find(new JFrame());
		} else if(e.getSource() == Btnonmember) {
			Nonmember n = new Nonmember(new JFrame());
		}if(e.getSource() == BtLogin) {
			sid = "";
			pwd = "";
			sid = xId.getText();
			pwd = xPwd.getText();
			getData(CheckId.selectlogin(sid, pwd));
		}
	}
}
	         

