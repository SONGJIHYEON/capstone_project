package org.CapstoneProject;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class NonOrdPg extends JFrame {   
	private JLabel vOrdName, vAddr, vPhone, vOpDeliv, vRecipiant, vRecipAddr, vRecipPhone, vDeliveMsg,
	vGradeDis, vUsedPoint, vProPrice, vAllDiscout, vPrice, vPoint, v1, vDepositNm, vDepositBk, vOrderPw, vOrderPw2;   
	private JTextField  xOrdName, xAddr, xPhone, xRecipiant, xRecipAddr, xRecipPhone, xDeliveMsg, xGradeDis, xUsedPoint,
	xProPrice, xAllDiscout, xPrice, xDepositNm, xDepositBk, xOrderPw, xOrderPw2;;         
	   
	private String[] col1 = {"no", "�̹���", "��ǰ����", "����", "��ۺ�", "�ݾ�", "����"};
	private String[] col2 = {"����", "��������", "�츮����", "����"};      
	private String[] div = {"������", "����"}; // ������� �޺��ڽ��� ���
	         
	private DefaultTableModel model1 = new DefaultTableModel(col1, 0);      
//	private DefaultTableModel model2 = new DefaultTableModel(col2, 0);      
	
	private JRadioButton rSameAddr, rNewAddr, rBank, rCard, rDeposit;
	private ButtonGroup BtRadio, BtRadio2;
	private JTable tProInfo;      
	private JScrollPane scrollpane1;
	private JPanel pRadio, pRadio2;
	         
	private JButton BtOrder, BtBack;
	private JComboBox<String> cbBk;      
	         
	GridBagLayout gridbaglayout;      
	GridBagConstraints gridbagconstraints;      // gridbag���̾ƿ��� ������Ʈ�� ��ġ�� ����ִ� ����
	         
	public NonOrdPg() {
		
        gridbaglayout = new GridBagLayout();
        gridbagconstraints = new GridBagConstraints();
        
        vOrdName = new JLabel("�ֹ��ڸ�");
        vAddr = new JLabel("�ֹ��� �ּ�");
        vPhone = new JLabel("�޴��ȣ");
        vOrderPw = new JLabel("�ֹ���ȸ ��й�ȣ");
        vOrderPw2 = new JLabel("�ֹ���ȸ ��й�ȣ Ȯ��");
        vOpDeliv = new JLabel("����� ����");
        vRecipiant = new JLabel("�����θ�");
        vRecipAddr = new JLabel("���� �ּ�");
        vRecipPhone = new JLabel("������ �޴��ȣ");
        vDeliveMsg = new JLabel("��� �޽���");
        vGradeDis = new JLabel("��� ����");
        vUsedPoint = new JLabel("��� ����Ʈ");
        vPoint = new JLabel("���� ����Ʈ");
        vProPrice = new JLabel("�� ��ǰ����");
        vAllDiscout = new JLabel("�� ���αݾ�");
        vPrice = new JLabel("���� ����");
        vDepositNm = new JLabel("�Ա��ڸ�");
        vDepositBk = new JLabel("�Ա�����");
        v1 = new JLabel("");
        v1.setPreferredSize(new Dimension(50, 28));

        xOrdName = new JTextField(10);
        xAddr = new JTextField(10);
        xPhone = new JTextField(10);
        xOrderPw = new JPasswordField(10);
        xOrderPw2 = new JPasswordField(10);
        xRecipiant = new JTextField(10); 
        xRecipAddr = new JTextField(10);
        xRecipPhone = new JTextField(10);
        xDeliveMsg = new JTextField(10);
        xGradeDis = new JTextField(10);
        xUsedPoint = new JTextField(10);
        xProPrice = new JTextField(10);
        xAllDiscout = new JTextField(10);
        xPrice = new JTextField(10);
        xDepositNm = new JTextField(10);
        
        tProInfo = new JTable(model1);
        scrollpane1 = new JScrollPane(tProInfo);
//        scrollpane1.setRowHeaderView(tProInfo);
        scrollpane1.setPreferredSize(new Dimension(750, 100));
        
        rSameAddr = new JRadioButton("�ֹ��ڿ� ����");
        rNewAddr = new JRadioButton("���ο� �����");
        BtRadio = new ButtonGroup();
        BtRadio.add(rNewAddr);
        BtRadio.add(rSameAddr);
        pRadio = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pRadio.add(rNewAddr);
        pRadio.add(rSameAddr);
        
        rBank = new JRadioButton("������ü");
        rCard = new JRadioButton("�ſ�ī��");
        rDeposit = new JRadioButton("������ �Ա�");
        BtRadio2 = new ButtonGroup();
        BtRadio2.add(rBank);
        BtRadio2.add(rCard);
        BtRadio2.add(rDeposit);
        pRadio2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pRadio2.add(rBank);
        pRadio2.add(rCard);
        pRadio2.add(rDeposit);
        
        cbBk = new JComboBox<String>(col2);
        cbBk.setPreferredSize(new Dimension(100, 28));
        BtOrder = new JButton("�ֹ��ϱ�");
//        BtOrder.setPreferredSize(new Dimension(130,28));
        BtBack = new JButton("���� ������");

//        regist.addActionListener(this);
        
        NonOrdPgView();
      }   
	         
	private void NonOrdPgView() {
		
        setTitle("��� ���");
        
//        gridbagconstraints.ipadx = 7;
//        
//        gridbagconstraints.weightx=1.0;
//        gridbagconstraints.weighty=1.0;
        

        setLayout(gridbaglayout);
        
//        gridbagconstraints.anchor = GridBagConstraints.WEST;
        gridbagconstraints.anchor = GridBagConstraints.CENTER;
        gridbagAdd(scrollpane1, 0, 0, 12, 1);
        gridbagAdd(vOrdName, 0, 13, 1, 1);
        gridbagAdd(vAddr, 0, 14, 1, 1);
        gridbagAdd(vPhone, 0, 15, 1, 1);
        gridbagAdd(vOrderPw, 0, 16, 1, 1);
        gridbagAdd(vOrderPw2, 0, 17, 1, 1);
        gridbagAdd(vOpDeliv, 0, 18, 1, 1);
        gridbagAdd(vRecipiant, 0, 19, 1, 1);
        gridbagAdd(vRecipAddr, 0, 20, 1, 1);
        gridbagAdd(vRecipPhone, 0, 21, 1, 1);
        gridbagAdd(vDeliveMsg, 0, 22, 1, 1);

        gridbagAdd(xOrdName, 1, 13, 1, 1);
        gridbagAdd(xAddr, 1, 14, 1, 1);
        gridbagAdd(xPhone, 1, 15, 1, 1);
        gridbagAdd(xOrderPw, 1, 16, 1, 1);
        gridbagAdd(xOrderPw2, 1, 17, 1, 1);
        gridbagAdd(pRadio, 1, 18, 1, 1);
        gridbagAdd(xRecipiant, 1, 19, 1, 1);
        gridbagAdd(xRecipAddr, 1, 20, 1, 1);
        gridbagAdd(xRecipPhone, 1, 21, 1, 1);
        gridbagAdd(xDeliveMsg, 1, 22, 1, 1);
        

        gridbagconstraints.anchor = GridBagConstraints.CENTER;
        gridbagAdd(v1, 2, 13, 1, 1);
//        gridbagAdd(vGradeDis, 3, 13, 1, 1);
//        gridbagAdd(vUsedPoint, 3, 14, 1, 1);
        gridbagAdd(vProPrice, 3, 13, 1, 1);
//        gridbagAdd(vAllDiscout, 3, 16, 1, 1);
        gridbagAdd(vPrice, 3, 14, 1, 1);
//        gridbagAdd(xGradeDis, 4, 13, 1, 1);
//        gridbagAdd(xUsedPoint, 4, 14, 1, 1);
        gridbagAdd(xProPrice, 4, 13, 1, 1);
//        gridbagAdd(xAllDiscout, 4, 16, 1, 1);
        gridbagAdd(xPrice, 4, 14, 1, 1);
        gridbagAdd(pRadio2, 3, 19, 2, 1);
        gridbagAdd(vDepositNm, 3, 20, 1, 1);
        gridbagAdd(vDepositBk, 3, 21, 1, 1);
        gridbagAdd(xDepositNm, 4, 20, 1, 1);
        gridbagAdd(cbBk, 4, 21, 1, 1);

        gridbagconstraints.anchor = GridBagConstraints.EAST;
        gridbagAdd(BtOrder, 5, 22, 1, 1);
        
        gridbagconstraints.anchor = GridBagConstraints.WEST;
        gridbagAdd(BtBack, 6, 22, 1, 1);
//        gridbagAdd(vPoint, 5, 14, 1, 1);
        
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
		new NonOrdPg();
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
	         

