package org.CapstoneProject;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Mypage extends JFrame {   
	private JLabel vMypage, vAllPoint, vUsedPoint, vSerPoint, vAllMoney, v1, v2, v3, v4, v5;  
	         
	private JTextField xGrade1, xGrade2, xDiscount, xAllPoint, xUsedPoint, xSerPoint, xAllMoney;
	   
	private String[] col1 = {"�μ���", "�μ���ġ"};      
	private String[] col2 = {"�μ���", "����"};      
	private String[] div = {"������", "����"}; // ������� �޺��ڽ��� ���
	         
	private DefaultTableModel model1 = new DefaultTableModel(col1, 0);      
	private DefaultTableModel model2 = new DefaultTableModel(col2, 0);      
	   
       
	private JTable eDept, eSpv;      
	private JScrollPane scrollpane1, scrollpane2;      
	         
	private JButton BtChange, BtOrder, BtPostView;  
	private JComboBox<String> cbSel;      
	         
	GridBagLayout gridbaglayout;      
	GridBagConstraints gridbagconstraints;      // gridbag���̾ƿ��� ������Ʈ�� ��ġ�� ����ִ� ����
	         
	public Mypage() {
		gridbaglayout = new GridBagLayout();
		gridbagconstraints = new GridBagConstraints();       
		
		vMypage = new JLabel("���� ������");
		vAllPoint = new JLabel("�� ����Ʈ");
		vUsedPoint = new JLabel("����� ����Ʈ");
		vSerPoint = new JLabel("��밡�� ����Ʈ");
		vAllMoney = new JLabel("�� �ֹ��ݾ�");
		v1 = new JLabel("������ ����");
		v2 = new JLabel("��� �Դϴ�.");
		v3 = new JLabel("��ǰ ���Ž�");
		v4 = new JLabel("�߰����������� ������ �� �ֽ��ϴ�");
		v5 = new JLabel("��� ����");
		v5.setFont(new Font("", Font.BOLD, 11));
	         
//	    cbSel = new JComboBox<String>(div);
//	    cbSel.setPreferredSize(new Dimension(203, 20));
	    
//		xGrade1 = new JTextField(5);
		xGrade2 = new JTextField(5);
		xDiscount = new JTextField(5);
		xAllPoint = new JTextField(20);
		xUsedPoint = new JTextField(20);
		xSerPoint = new JTextField(20);
		xAllMoney = new JTextField(20);
	    
        
        BtChange = new JButton("�� ��������");
        BtOrder = new JButton("�ֹ� ����");
        BtPostView = new JButton("�� �Խñ� ����");
        
//	         getDeptData(EmpData.selectDept());
//	         getSvpData(EmpData.selectSpv());
        
        MypageView();
      }   
	         
	private void MypageView() {
		setTitle("Login ȭ��");
	         
	    gridbagconstraints.anchor = GridBagConstraints.WEST;
//	    gridbagconstraints.ipadx = 7;
//	    
//	    gridbagconstraints.weightx=1.0;
//      gridbagconstraints.weighty=1.0;
         
        setLayout(gridbaglayout);       
        gridbagconstraints.anchor = GridBagConstraints.CENTER;
	        
        gridbagAdd(vMypage, 3, 0, 1, 1);
        gridbagAdd(BtOrder, 3, 1, 1, 1);
        gridbagAdd(BtPostView, 4, 1, 1, 1);
        gridbagAdd(v5, 0, 2, 1, 2);
        gridbagAdd(xDiscount, 2, 3, 1, 1);
        gridbagAdd(vAllPoint, 0, 4, 1, 1);
        gridbagAdd(xAllPoint, 1, 4, 2, 1);
        gridbagAdd(vUsedPoint, 4, 4, 1, 1);
        gridbagAdd(xUsedPoint, 5, 4, 2, 1);
        gridbagAdd(vSerPoint, 0, 5, 1, 1);
        gridbagAdd(xSerPoint, 1, 5, 2, 1);
        gridbagAdd(vAllMoney, 4, 5, 1, 1);
        gridbagAdd(xAllMoney, 5, 5, 2, 1);       
        gridbagAdd(xGrade2, 2, 2, 1, 1);      

        gridbagconstraints.anchor = GridBagConstraints.EAST;    
        gridbagAdd(BtChange, 2, 1, 1, 1);
        gridbagAdd(v1, 1, 2, 1, 1);
        gridbagAdd(v3, 1, 3, 1, 1);
//        gridbagAdd(v5, 4, 3, 1, 1);
        
        gridbagconstraints.anchor = GridBagConstraints.WEST;   
        gridbagAdd(v2, 3, 2, 2, 1);
        gridbagAdd(v4, 3, 3, 2, 1);

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
		new Mypage();
    	 }   
}
	         

