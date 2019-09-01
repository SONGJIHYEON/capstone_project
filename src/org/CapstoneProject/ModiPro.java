package org.CapstoneProject;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class ModiPro extends JFrame {
	private JLabel vRegModel, vModiPro, vProNm, vSale, vModelCtgr2, vModelNm, vPrice, vAdminModel, vModelCtgr, vRegPro, 
	vAdminPro, vProUp, vProSize, vProDetail, vProColor, vProStock;
	private JTextField xModelNm, xModelCode, xSale, xModelCtgr2, xProDetail, xPrice, xProStock;
	
//	private JTextArea xPrice;

//	private JPasswordField xMemPw1, xMemPw2;
//	private String[] ctgr1 = {"����", "����", "����", "�ƿ���", "�Ź�"};
	private String[] size1 = {"90", "95", "100", "105", "110"};
	private String[] size2 = {"27", "28", "29", "30", "31", "32", "33", "34", "35" }; 
//	private String[] ctgr2_1 = {"������", "����", "����", "��Ʈ", "�ĵ�"};
//	private String[] ctgr2_2 = {"û����", "������", "�����", "���", "�ݹ���"};
//	private String[] ctgr2_3 = {"���ȼ���", "üũ", "���ȼ���", "��Ʈ������"};
//	private String[] ctgr2_4 = {"��Ʈ", "�����", "����", "����", "�е�", "����", "�߻�", "��Ŷ"};
//	private String[] ctgr2_5 = {"��ƼĿ��", "�ȭ", "������", "����", "����", "��Ŀ", "����", "����"};
//	private String[] col1 = {"best"};      
//	private String[] col2 = {"new"};      
//  private String[] div = {"������", "�ӽ���", "�����"};      // ������� �޺��ڽ��� ���
//	         
//	private DefaultTableModel model1 = new DefaultTableModel(col1, 0);  
//	private DefaultTableModel model2 = new DefaultTableModel(col2, 0);      

	private JTable tBest, tNew;      
	private JScrollPane scrollpane1, scrollpane2;  
   
	private JButton BtBussMan, BtProMan, BtOdMan, BtMbMan, BtEmpMan, BtSearch, BtModify, BtDelete, BtModel;
	private JRadioButton RSale, RSoldOut, RBehind;
	private ButtonGroup BtRadio;
	private JPanel PRadio;
	private JComboBox<String> CbSize1, CbSize2;
	
	GridBagLayout gbl;
	GridBagConstraints gbc;
	
	public ModiPro() {
		gbl = new GridBagLayout();
		gbc = new GridBagConstraints(); 
        
		vRegModel = new JLabel("�𵨵��");
		vRegModel.setPreferredSize(new Dimension(200,28));
		vAdminModel = new JLabel("���K�˻�");
		vAdminModel.setPreferredSize(new Dimension(200,28));
		vModelCtgr = new JLabel("�𵨺з�");
		vModelCtgr.setPreferredSize(new Dimension(200,28));
		vRegPro = new JLabel("��ǰ���");
		vRegPro.setPreferredSize(new Dimension(200,28));
		vAdminPro = new JLabel("��ǰ����");
		vAdminPro.setPreferredSize(new Dimension(200,28));
		vProUp = new JLabel("��ǰ�ܰ�����");
        vProUp.setPreferredSize(new Dimension(200,28));
		
        vModiPro = new JLabel("��ǰ����");
		vModiPro.setPreferredSize(new Dimension(200,28));
        
		vProNm = new JLabel("��ǰ��");
		vProColor = new JLabel("��ǰ ����");
		vProStock = new JLabel("�����");

		xModelNm = new JTextField(20);
		xModelCode = new JTextField(20);
		xSale = new JTextField(20);
		xProDetail = new JTextField(20);
		xPrice = new JTextField(20);
		xProStock = new JTextField(20);
		
		vModelNm = new JLabel("�𵨸�");
		vPrice = new JLabel("��ǰ ����");
		vSale = new JLabel("�ǸŻ���");
		CbSize1 = new JComboBox<String>(size1);
//		Cbctgr1.setPreferredSize(new Dimension(200,28));
//		vModelCtgr2 = new JLabel("2���з�");
		vProSize = new JLabel("��ǰ ������");
		vProDetail = new JLabel("��ǰ �� ����");
		
		RSale = new JRadioButton("�Ǹ���");
		RSale.setSelected(true);
		RSoldOut = new JRadioButton("ǰ��");
		RBehind = new JRadioButton("����");
		
		BtRadio = new ButtonGroup();
		BtRadio.add(RSale);
		BtRadio.add(RSoldOut);
		BtRadio.add(RBehind);
	
		PRadio = new JPanel(new FlowLayout(FlowLayout.CENTER));
		PRadio.add(RSale);
		PRadio.add(RSoldOut);
		PRadio.add(RBehind);


		BtBussMan = new JButton("�ŷ�����");
		BtBussMan.setPreferredSize(new Dimension(200,28));
		
//		BtModel = new JButton("�� �ҷ�����");
        
//        regist.addActionListener(this);
		BtProMan = new JButton("��/��ǰ����");
		BtProMan.setPreferredSize(new Dimension(200,28));
//        cancel.addActionListener(this);
		BtOdMan = new JButton("�ֹ�����");
		BtOdMan.setPreferredSize(new Dimension(200,28));
		BtMbMan = new JButton("ȸ������");
		BtMbMan.setPreferredSize(new Dimension(200,28));
		BtEmpMan = new JButton("��������");
		BtEmpMan.setPreferredSize(new Dimension(200,28));
//		BtSearch = new JButton("�˻�");
//		BtSearch.setPreferredSize(new Dimension(100,28));
		BtModify = new JButton("����");
		BtDelete = new JButton("����");

		setExtendedState(MAXIMIZED_BOTH);
		ModiProView();
	}
	
	private void ModiProView() {


		setTitle("Ȩ������ ������");


		setLayout(gbl);
		
		gridbagAdd(vRegModel, 0, 1, 1, 1);
		gridbagAdd(vModiPro, 1, 1, 1, 1);
		gridbagAdd(vAdminModel,0, 2, 1, 1);
	    gridbagAdd(vModelCtgr, 0, 3, 1, 1);
	    gridbagAdd(vRegPro, 0, 4, 1, 1);
	    gridbagAdd(vAdminPro, 0, 5, 1, 1);
	    gridbagAdd(vProUp, 0, 6, 1, 1);
	    gridbagAdd(vProNm, 1, 2, 1, 1);
	    gridbagAdd(vModelNm, 1, 3, 1, 1);
	    gridbagAdd(vPrice, 1, 4, 1, 1);
	    gridbagAdd(vSale, 1, 5, 1, 1);
	    gridbagAdd(vProSize, 1, 6, 1, 1);
	    gridbagAdd(vProColor, 1, 7, 1, 1);
	    gridbagAdd(vProStock, 1, 8, 1, 1);
	    gridbagAdd(vProDetail, 1, 9, 1, 1);
	    
	    gridbagAdd(xModelNm, 2, 2, 2, 1);
	    gridbagAdd(xModelCode, 2, 3, 2, 1);
	    gridbagAdd(xPrice, 2, 4, 2, 1);
	    gridbagAdd(PRadio, 2, 5, 2, 1);
	    gridbagAdd(xProStock, 2, 8, 2, 1);
	    gridbagAdd(xProDetail, 2, 9, 2, 1);
	    gridbagAdd(CbSize1, 2, 6, 2, 1);

//	    gridbagAdd(vTop, 1, 1, 1, 1);
//	    gridbagAdd(vBottom, 2, 1, 1, 1);
//	    gridbagAdd(vOuter, 3, 1, 1, 1);
//	    gridbagAdd(vShirts, 4, 1, 1, 1);
	    
        gbc.anchor = GridBagConstraints.CENTER;
        gridbagAdd(BtBussMan, 1, 0, 1, 1);
        gridbagAdd(BtProMan, 2, 0, 2, 1);
        gridbagAdd(BtOdMan, 4, 0, 1, 1);
        gridbagAdd(BtMbMan, 5, 0, 1, 1);
        gridbagAdd(BtEmpMan, 6, 0, 1, 1);
        gbc.anchor = GridBagConstraints.WEST;
//        gridbagAdd(BtModel, 4, 3, 1, 1);
        gridbagAdd(BtModify, 2, 10, 1, 1);
        gbc.anchor = GridBagConstraints.EAST;
        gridbagAdd(BtDelete, 3, 10, 1, 1);
        
//	    gridbagAdd(scrollpane1, 1, 2, 5, 1);
//	    gridbagAdd(scrollpane2, 1, 6, 6, 5);
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
		new ModiPro();
	}   
}	

	
			