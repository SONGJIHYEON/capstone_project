package org.CapstoneProject;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class RegModel extends JFrame implements ActionListener {
	
//	private static final int MAXIMIZED_BOTH = 0;
	private JLabel vRegModel, vRegModel2, vModelNm, vModelCtgr1, vModelCtgr2, vModelCode, vModelImage, vAdminModel, 
	vModelCtgr, vRegPro, vAdminPro, vProUp, vModelExp, vModelSize;
	private JTextField xModelNm, xModelCode, xModelCtgr1, xModelCtgr2, xModelExp, xModelSize, xModelImage;
//	private JTextArea xModelImage;

	private String[] ctgr1 = {"����", "����", "�ƿ���", "����", "�Ź�"};
	private String[] ctgr2_1 = {"������", "����T", "����T", "�ĵ�", "��Ʈ"};
	private String[] ctgr2_2 = {"û����", "������", "�����", "���", "�ݹ���"}; 
	private String[] ctgr2_3 = {"��Ʈ", "�����", "����", "����", "����", "�е�", "�߻�", "��Ŷ"};
	private String[] ctgr2_4 = {"��Ʈ������", "üũ", "���ȼ���", "���ȼ���"};
	private String[] ctgr2_5 = {"����Ŀ��", "�ȭ", "����", "����", "��Ŀ", "����", "����", "������"};     // ������� �޺��ڽ��� ���
//	         
//	private DefaultTableModel model1 = new DefaultTableModel(col1, 0);  
//	private DefaultTableModel model2 = new DefaultTableModel(col2, 0);      

	private JTable tBest, tNew;      
	private JScrollPane scrollpane1, scrollpane2;  
   
	private JButton BtBussMan, BtProMan, BtOdMan, BtMbMan, BtEmpMan, BtSearch, BtImg, BtReg, BtCancel, BtCode; 
	private JComboBox<String> Cbctgr1, Cbctgr2;
	

	String fModel, MODEL_NUM, MODEL_CTGR_NUM, MODEL_NM, MODEL_EXP;
	
	GridBagLayout gbl;
	GridBagConstraints gbc;
	
	public void getData(List<Map<String, Serializable>> ModelListData) {
		fModel = "";
		fModel += ModelListData.get(0).get("MODEL_CTGR_NUM").toString(); 
		
		MODEL_NUM = xModelCode.getText();
		MODEL_CTGR_NUM = fModel;
		MODEL_NM = xModelNm.getText();
		MODEL_EXP = xModelExp.getText();
		ModelData.initModelData(MODEL_NUM, MODEL_CTGR_NUM, MODEL_NM, MODEL_EXP);
		ModelData.createModel();
	}
	
	public RegModel() {
		
		gbl = new GridBagLayout();
		gbc = new GridBagConstraints(); 
		        
		vRegModel = new JLabel("�𵨵��");
		vRegModel.setPreferredSize(new Dimension(200,28));
		vRegModel2 = new JLabel("�𵨵��");
		vRegModel2.setPreferredSize(new Dimension(200,28));
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
        
		vModelNm = new JLabel("�𵨸�");

		xModelNm = new JTextField(20);
		xModelCode = new JTextField(20);
		xModelCtgr1 = new JTextField(20);
		xModelCtgr2 = new JTextField(20);
		xModelExp = new JTextField(20);
//		xModelSize = new JTextField(20);
		xModelImage = new JTextField(20);
		
		vModelCode = new JLabel("���ڵ�");
		vModelImage = new JLabel("�𵨴�ǥ�̹���");
		vModelCtgr1 = new JLabel("1���з�");
		Cbctgr1 = new JComboBox<String>(ctgr1);
		Cbctgr1.setPreferredSize(new Dimension(200,28));
		Cbctgr1.addActionListener(this);
		Cbctgr2 = new JComboBox<String>(ctgr2_1);
		Cbctgr2.setPreferredSize(new Dimension(200,28));
		Cbctgr2.addActionListener(this);
		vModelCtgr2 = new JLabel("2���з�");
		vModelExp = new JLabel("�𵨼���");
//		vModelSize = new JLabel("�� �󼼻�����");

		BtCode = new JButton("�ڵ����");
		BtCode.addActionListener(this);
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
		BtImg = new JButton("÷���ϱ�");
//		BtSearch = new JButton("�˻�");
//		BtSearch.setPreferredSize(new Dimension(100,28));
		BtReg = new JButton("���");
		BtReg.addActionListener(this);
		BtCancel = new JButton("�ݱ�");


		RegModelView();
	}
	
	private void RegModelView() {

//		setTitle("Ȩ������ ������");


		setLayout(gbl);
		
		gridbagAdd(vRegModel, 0, 1, 1, 1);
		gridbagAdd(vRegModel2, 1, 1, 1, 1);
		gridbagAdd(vAdminModel,0, 2, 1, 1);
	    gridbagAdd(vModelCtgr, 0, 3, 1, 1);
	    gridbagAdd(vRegPro, 0, 4, 1, 1);
	    gridbagAdd(vAdminPro, 0, 5, 1, 1);
	    gridbagAdd(vProUp, 0, 6, 1, 1);
	    gridbagAdd(vModelNm, 1, 2, 1, 1);
	    gridbagAdd(vModelCode, 1, 3, 1, 1);
	    gridbagAdd(vModelImage, 1, 4, 1, 1);
	    gridbagAdd(vModelCtgr1, 1, 5, 1, 1);
	    gridbagAdd(vModelCtgr2, 1, 6, 1, 1);
	    gridbagAdd(vModelExp, 1, 7, 1, 1);
//	    gridbagAdd(vModelSize, 1, 8, 1, 1);
	    gridbagAdd(xModelNm, 2, 2, 2, 1);
	    gridbagAdd(xModelCode, 2, 3, 2, 1);
	    gridbagAdd(xModelImage, 2, 4, 2, 1);
	    gridbagAdd(Cbctgr1, 2, 5, 2, 1);
	    gridbagAdd(Cbctgr2, 2, 6, 2, 1);
	    gridbagAdd(xModelExp, 2, 7, 2, 1);
//	    gridbagAdd(xModelSize, 2, 8, 2, 1);
	    
//	    gridbagAdd(vTop, 1, 1, 1, 1);
//	    gridbagAdd(vBottom, 2, 1, 1, 1);
//	    gridbagAdd(vOuter, 3, 1, 1, 1);
//	    gridbagAdd(vShirts, 4, 1, 1, 1);
//	    gridbagAdd(vShoes, 5, 1, 1, 1);
	    
        gbc.anchor = GridBagConstraints.CENTER;
        gridbagAdd(BtBussMan, 1, 0, 1, 1);
        gridbagAdd(BtProMan, 2, 0, 2, 1);
        gridbagAdd(BtOdMan, 4, 0, 1, 1);
        
        gridbagAdd(BtMbMan, 5, 0, 1, 1);
        gridbagAdd(BtEmpMan, 6, 0, 1, 1);
        gbc.anchor = GridBagConstraints.WEST;
        gridbagAdd(BtImg, 4, 4, 1, 1);
        gridbagAdd(BtCode, 4, 3, 1, 1);
        gridbagAdd(BtReg, 2, 9, 1, 1);
        gbc.anchor = GridBagConstraints.EAST;
        gridbagAdd(BtCancel, 3, 9, 1, 1);
        
//	    gridbagAdd(scrollpane1, 1, 2, 5, 1);
//	    gridbagAdd(scrollpane2, 1, 6, 6, 5);
//	    gridbagAdd(regist, 0, 12, 1, 1);
//	    gridbagAdd(cancel, 2, 12, 1, 1);
	    
		setExtendedState(MAXIMIZED_BOTH);
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
	
 static class random2 {
		Random rnd =new Random();
		StringBuffer buf =new StringBuffer();
	}
	
	
	public static void main(String[] args) {   
//		JFrame jf = new JFrame();
//		jf.add(new RegModel());
		new RegModel();
//		jf.pack();
//		jf.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == Cbctgr1) {
//			getData(ModelData.selectModel());
			if(Cbctgr1.getSelectedItem().toString() == "����") {
				DefaultComboBoxModel model = new DefaultComboBoxModel(ctgr2_1);
				Cbctgr2.setModel( model );
			}else if(Cbctgr1.getSelectedItem().toString() == "����") {
				DefaultComboBoxModel model = new DefaultComboBoxModel(ctgr2_2);
				Cbctgr2.setModel( model );
			}else if(Cbctgr1.getSelectedItem().toString() == "�ƿ���") {
				DefaultComboBoxModel model = new DefaultComboBoxModel(ctgr2_3);
				Cbctgr2.setModel( model );
			}else if(Cbctgr1.getSelectedItem().toString() == "����") {
				DefaultComboBoxModel model = new DefaultComboBoxModel(ctgr2_4);
				Cbctgr2.setModel( model );
			}else if(Cbctgr1.getSelectedItem().toString() == "�Ź�") {
				DefaultComboBoxModel model = new DefaultComboBoxModel(ctgr2_5);
				Cbctgr2.setModel( model );
			}
		}
		String a = Cbctgr1.getSelectedItem().toString();
		String b = Cbctgr2.getSelectedItem().toString();
		if(e.getSource() == BtCode) {
			random2 r1 = new random2();
			
			for(int i=0;i<8;i++){
			    if(r1.rnd.nextBoolean()){
			        r1.buf.append((char)((int)(r1.rnd.nextInt(26))+97));
			    }else{
			        r1.buf.append((r1.rnd.nextInt(10))); 
			    }
			}
			String s = r1.buf.toString();
			System.out.println(s);
			xModelCode.setText(s);
		} 
		
		if(e.getSource() == BtReg) {
			if(a == "����") {
				getData(ModelData.selectModelNum1(a, b));
			}else if(a == "����") {
				getData(ModelData.selectModelNum2(a, b));
			}else if(a == "�ƿ���") {
				getData(ModelData.selectModelNum3(a, b));
			}else if(a == "����") {
				getData(ModelData.selectModelNum4(a, b));
			}else if(a == "�Ź�") {
				getData(ModelData.selectModelNum5(a, b));
			}
		}			
	}
}