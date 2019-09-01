package org.CapstoneProject;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ProDetail extends JFrame implements ActionListener {   
	private JLabel vProImg, vProNm, vPrice, vColor, vSize, vOption, vAllPrice;
	         
	private JTextField xPrice, xOption, xAllPrice;
	
	private String[] size1 = {"90", "95", "100", "105", "110"};
	private String[] size2 = {"27", "28", "29", "30", "31", "32", "33", "34", "35" }; 
	   
//	private String[] col1 = {"", "�μ���ġ"};      
//	private String[] col2 = {"�μ���", "����"};      
//	private String[] div = {"������", "����"}; // ������� �޺��ڽ��� ���
	         
//	private DefaultTableModel model1 = new DefaultTableModel(col1, 0);      
//	private DefaultTableModel model2 = new DefaultTableModel(col2, 0);      
	   
       
	private JTable eDept, eSpv;      
	private JScrollPane scrollpane1, scrollpane2;      
	         
	private JButton BtPurchae, BtBasket, BtPlus, BtMinus;  
	private JComboBox<String> CbSize1, CbSize2; 
	private JTabbedPane t;
	private JPanel p;
	         
	GridBagLayout gridbaglayout;      
	GridBagConstraints gridbagconstraints;      // gridbag���̾ƿ��� ������Ʈ�� ��ġ�� ����ִ� ����
	         
	public ProDetail() {
		gridbaglayout = new GridBagLayout();
		gridbagconstraints = new GridBagConstraints();      
		
		vProImg = new JLabel();
		vPrice = new JLabel("����");
		vColor = new JLabel("����");
		vSize = new JLabel("������");
		vOption = new JLabel("���� ����");
		vAllPrice = new JLabel("�� ��ǰ����");
		vProNm = new JLabel("DB���� ��ǰ�̸�");

//	    cbSel = new JComboBox<String>(div);
//	    cbSel.setPreferredSize(new Dimension(203, 20));
	    
		xPrice = new JTextField(20);
		xOption = new JTextField(3);
		xOption.setText("1");
		xAllPrice = new JTextField(20);

		BtPlus = new JButton("��");
		BtPlus.setPreferredSize(new Dimension(45,20));
		BtPlus.addActionListener(this);
		BtMinus = new JButton("��");
		BtMinus.setPreferredSize(new Dimension(45,20));
		BtMinus.addActionListener(this);
		BtPurchae = new JButton("�����ϱ�");
		BtBasket = new JButton("��ٱ���");
		


		t = new JTabbedPane(JTabbedPane.NORTH);
		t.add("��ǰ��", new JTextArea());
		t.add("��ǰ������", new JTextArea());
		
		p = new JPanel();
		t.addTab("��ǰ��", p);
		
		p = new JPanel();
		t.addTab("��ǰ������", p);
		

		
		
//	         getDeptData(EmpData.selectDept());
//	         getSvpData(EmpData.selectSpv());
        
        ProDetailView();
      }   
	         
	private void ProDetailView() {
		setTitle("Login ȭ��");
	         
	    gridbagconstraints.anchor = GridBagConstraints.WEST;
//	    gridbagconstraints.ipadx = 7;
//	    
//	    gridbagconstraints.weightx=1.0;
//      gridbagconstraints.weighty=1.0;
         
        setLayout(gridbaglayout);       
        gridbagconstraints.anchor = GridBagConstraints.CENTER;

    	
        gridbagAdd(vProImg, 0, 0, 2, 7);
        gridbagAdd(vProNm, 2, 0, 1, 1);
        gridbagAdd(vPrice,2, 1, 1, 1);
        gridbagAdd(xPrice, 3, 1, 2, 1);
        gridbagAdd(vColor, 2, 2, 1, 1);
//        gridbagAdd(vAllPoint, 0, 4, 1, 1);
        gridbagAdd(vSize, 2, 3, 1, 1);
        gridbagAdd(vOption, 2, 4, 1, 1);
        gridbagAdd(vAllPrice, 2, 5, 1, 1);
        gridbagAdd(xAllPrice, 3, 5, 2, 1);
        gridbagAdd(BtPlus, 4, 4, 1, 1);
        
        gridbagconstraints.anchor = GridBagConstraints.WEST;
        gridbagAdd(BtPurchae, 3, 6, 1, 1);
        gridbagAdd(xOption, 3, 4, 2, 1);
        gridbagAdd(t, 0, 7, 10, 10);
        
        gridbagconstraints.anchor = GridBagConstraints.EAST;
        gridbagAdd(BtBasket, 4, 6, 1, 1);       
        gridbagAdd(BtMinus, 4, 4, 1, 1);

        pack();
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
		new ProDetail();
    	 }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == BtPlus) {
			int p = Integer.parseInt(xOption.getText());
			p++;
			xOption.setText(p + "");
		}else if(e.getSource() == BtMinus) { if(Integer.parseInt(xOption.getText()) > 1) {
			int m = Integer.parseInt(xOption.getText());
			m--;
			xOption.setText(m + "");}
		}
		
	}   
}
	         

