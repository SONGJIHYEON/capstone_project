package org.CapstoneProject;

import java.awt.Component;
import java.awt.Dimension;
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


public class ManPro extends JFrame {
	private JLabel vRegModel, vModelNm, vModelCtgr1, vModelCtgr2, vModelCode, vAdminModel, vAdminPro2,
	vModelCtgr, vRegPro, vAdminPro, vProUp, vModelExp, vModelSize;
	private JTextField xModelNm, xModelCode, xModelCtgr1, xModelCtgr2, xModelExp, xModelSize, xSearch;

//	private JPasswordField xMemPw1, xMemPw2;
//	private String[] ctgr1 = {"����", "����", "����", "�ƿ���", "�Ź�"};
//	private String[] ctgr2_1 = {"������", "����", "����", "��Ʈ", "�ĵ�"};
//	private String[] ctgr2_2 = {"û����", "������", "�����", "���", "�ݹ���"};
//	private String[] ctgr2_3 = {"���ȼ���", "üũ", "���ȼ���", "��Ʈ������"};
//	private String[] ctgr2_4 = {"��Ʈ", "�����", "����", "����", "�е�", "����", "�߻�", "��Ŷ"};
//	private String[] ctgr2_5 = {"��ƼĿ��", "�ȭ", "������", "����", "����", "��Ŀ", "����", "����"};
	
	private String[] col1 = {"No", "�̹���", "�𵨸�", "��ǰ��", "����", "���", "����/����"};      
	private String[] search = {"�𵨸�", "�𵨹�ȣ"};    
	
//  private String[] div = {"������", "�ӽ���", "�����"};      // ������� �޺��ڽ��� ���
//	private DefaultTableModel model2 = new DefaultTableModel(col2, 0);      

	private JTable tModelInfo;    
	private JScrollPane scrollpane1, scrollpane2;  	
	
	private DefaultTableModel model1 = new DefaultTableModel(col1, 0);  
   
	private JButton BtBussMan, BtProMan, BtOdMan, BtMbMan, BtEmpMan, BtSearch, BtReg; 
	private JComboBox<String> CbSearch, Cbctgr1, CbCbctgr2_1, CbCbctgr2_2, CbCbctgr2_3, CbCbctgr2_4, CbCbctgr2_5;
	
	GridBagLayout gbl;
	GridBagConstraints gbc;
	
	public ManPro() {
		gbl = new GridBagLayout();
		gbc = new GridBagConstraints(); 
        
		vRegModel = new JLabel("�𵨵��");
		vRegModel.setPreferredSize(new Dimension(200,28));
		vAdminModel = new JLabel("�𵨰˻�");
		vAdminModel.setPreferredSize(new Dimension(200,28));
		vModelCtgr = new JLabel("�𵨺з�");
		vModelCtgr.setPreferredSize(new Dimension(200,28));
		vRegPro = new JLabel("��ǰ���");
		vRegPro.setPreferredSize(new Dimension(200,28));
		vAdminPro = new JLabel("��ǰ����");
		vAdminPro.setPreferredSize(new Dimension(200,28));
		vProUp = new JLabel("��ǰ�ܰ�����");
        vProUp.setPreferredSize(new Dimension(200,28));
        
		vAdminPro2 = new JLabel("��ǰ����");
		vAdminPro2.setPreferredSize(new Dimension(200,28));
		
		CbSearch = new JComboBox<String>(search);
		CbSearch.setPreferredSize(new Dimension(200,28));
		
		xSearch = new JTextField(20);
		xSearch.setPreferredSize(new Dimension(200,28));
		
		tModelInfo = new JTable(model1);
        scrollpane1 = new JScrollPane(tModelInfo);
        scrollpane1.setPreferredSize(new Dimension(1000, 300));


		BtBussMan = new JButton("�ŷ�����");
		BtBussMan.setPreferredSize(new Dimension(200,28));
        
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
		
		BtSearch = new JButton("�˻�");
		BtSearch.setPreferredSize(new Dimension(100,28));
		BtReg = new JButton("���");
		BtReg.setPreferredSize(new Dimension(100,28));
//		BtCancel = new JButton("�ݱ�");

		setExtendedState(MAXIMIZED_BOTH);
		ManProView();
	}
	
	private void ManProView() {


		setTitle("Ȩ������ ������");


		setLayout(gbl);
		
		gridbagAdd(vRegModel, 0, 1, 1, 1);
		gridbagAdd(vAdminPro2, 1, 1, 1, 1);
		gridbagAdd(vAdminModel,0, 2, 1, 1);
	    gridbagAdd(vModelCtgr, 0, 3, 1, 1);
	    gridbagAdd(vRegPro, 0, 4, 1, 1);
	    gridbagAdd(vAdminPro, 0, 5, 1, 1);
	    gridbagAdd(vProUp, 0, 6, 1, 1);
	    
	    gridbagAdd(CbSearch, 1, 2, 1, 1);
	    gridbagAdd(xSearch, 2, 2, 1, 1);

	    
        gbc.anchor = GridBagConstraints.CENTER;
        gridbagAdd(BtBussMan, 1, 0, 1, 1);
        gridbagAdd(BtProMan, 2, 0, 1, 1);
        gridbagAdd(BtOdMan, 3, 0, 1, 1);
        gridbagAdd(BtMbMan, 4, 0, 1, 1);
        gridbagAdd(BtEmpMan, 5, 0, 1, 1);
        
	    gbc.anchor = GridBagConstraints.WEST;
	    gridbagAdd(BtSearch, 3, 2, 1, 1);
	    gridbagAdd(scrollpane1, 1, 3, 5, 5);

	    
	   
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
		new ManPro();
	}   
}	

	
			