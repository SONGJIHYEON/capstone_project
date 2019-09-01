package org.CapstoneProject;
import java.awt.Component;
import java.awt.Dimension;
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

public class Basket extends JFrame {   
	private JLabel vProPrice, vDiscout, vPrice;     
	         
	private JTextField  xProPrice, xDiscout, xPrice;        
	   
	private String[] col1 = {"no", "�̹���", "��ǰ����", "����", "����Ʈ", "�ݾ�", "����"};
//	private String[] col2 = {"�μ���", "����"};      
	private String[] div = {"������", "����"}; // ������� �޺��ڽ��� ���
	         
	private DefaultTableModel model1 = new DefaultTableModel(col1, 0);      
//	private DefaultTableModel model2 = new DefaultTableModel(col2, 0);      
	
	private JTable tProInfo;      
	private JScrollPane scrollpane1;
	         
	private JButton BtOrder, BtShopping, BtDelBasket;
//	private JComboBox<String> cbSel;      
	         
	GridBagLayout gridbaglayout;      
	GridBagConstraints gridbagconstraints;      // gridbag���̾ƿ��� ������Ʈ�� ��ġ�� ����ִ� ����
	         
	public Basket() {
		
        gridbaglayout = new GridBagLayout();
        gridbagconstraints = new GridBagConstraints();
        
        vProPrice = new JLabel("�� ��ǰ����");
        vDiscout = new JLabel("��� ����");
        vPrice = new JLabel("�� �ݾ�");
        
        xProPrice = new JTextField(10);
        xDiscout = new JTextField(10);
        xPrice = new JTextField(10);
        
        
        tProInfo = new JTable(model1);
        scrollpane1 = new JScrollPane(tProInfo);
        scrollpane1.setPreferredSize(new Dimension(750, 100));
		
        BtOrder = new JButton("�ֹ��ϱ�");
//        BtOrder.setPreferredSize(new Dimension(130,28));
        BtShopping = new JButton("���� ����ϱ�");
        BtShopping.setPreferredSize(new Dimension(130,28));
        BtDelBasket = new JButton("��ٱ��� ����");
        BtDelBasket.setPreferredSize(new Dimension(130,28));
//        regist.addActionListener(this);
        
        BasketView();
      }   
	         
	private void BasketView() {
		
        setTitle("��� ���");
        
//        gridbagconstraints.ipadx = 7;
//        
//        gridbagconstraints.weightx=1.0;
//        gridbagconstraints.weighty=1.0;
        
        setLayout(gridbaglayout);
        
        gridbagconstraints.anchor = GridBagConstraints.CENTER;
        gridbagAdd(scrollpane1, 0, 0, 12, 1);
        gridbagAdd(vProPrice, 0, 12, 1, 1);
        gridbagAdd(vDiscout, 2, 12, 1, 1);
        gridbagAdd(vPrice, 4, 12, 1, 1);
        gridbagAdd(xProPrice, 1, 12, 1, 1);
        gridbagAdd(xDiscout, 3, 12, 1, 1);
        gridbagAdd(xPrice, 5, 12, 1, 1);
        gridbagconstraints.anchor = GridBagConstraints.EAST;
        gridbagAdd(BtDelBasket, 11, 12, 1, 1);
        gridbagAdd(BtShopping, 11, 13, 1, 1);
        gridbagconstraints.anchor = GridBagConstraints.WEST;
        gridbagAdd(BtOrder, 10, 13, 1, 1);
        
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
		new Basket();
    	 }   
	
//	public void actionPerformed(ActionEvent e) {
//		// TODO Auto-generated method stub
//		if(e.getSource() == BtRegMb) {
//			RegMember r = new RegMember(new JFrame());
//
//		} else if(e.getSource() == BtFind) {
//			Find f = new Find(new JFrame());
//		} else if(e.getSource() == Btnonmember) {
//			nonmem n = new nonmem(new JFrame());
//		}
//	}
}
	         

