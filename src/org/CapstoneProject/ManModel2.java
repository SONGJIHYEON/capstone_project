package org.CapstoneProject;

import java.awt.Component;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

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


public class ManModel2 extends JFrame implements MouseListener, ActionListener{
	private JLabel vRegModel, vModelNm, vModelCtgr1, vModelCtgr2, vModelCode, vAdminModel, vAdminModel2,
	vModelCtgr, vRegPro, vAdminPro, vProUp, vModelExp, vModelSize;
	private JTextField xModelNm, xModelCode, xModelCtgr1, xModelCtgr2, xModelExp, xModelSize, xSearch;
	
	private String[] col1 = {"�𵨸�", "�𵨹�ȣ", "1���з�", "����2���з�", "����2���з�", "�ƿ���2���з�","����2���з�", "�Ź�2���з�"};      
	private String[] search = {"�𵨸�", "1���з�"};    
	
//  private String[] div = {"������", "�ӽ���", "�����"};      // ������� �޺��ڽ��� ���
//	private DefaultTableModel model2 = new DefaultTableModel(col2, 0);      

	private JTable tModelInfo;    
	private JScrollPane scrollpane1, scrollpane2;  	
	
	private DefaultTableModel model1 = new DefaultTableModel(col1, 0);  
   
	private JButton BtBussMan, BtProMan, BtOdMan, BtMbMan, BtEmpMan, BtSearch, BtReg; 
	private JComboBox<String> CbSearch;
	
	String ModelName;
	
	GridBagLayout gbl;
	GridBagConstraints gbc;
	
	public ManModel2() {
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
        
		vAdminModel2 = new JLabel("�𵨰˻�");
		vAdminModel2.setPreferredSize(new Dimension(200,28));
		
		CbSearch = new JComboBox<String>(search);
		CbSearch.setPreferredSize(new Dimension(200,28));
		
		xSearch = new JTextField(20);
		xSearch.setPreferredSize(new Dimension(200,28));
		
		tModelInfo = new JTable(model1);
		tModelInfo.addMouseListener(this);
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
		BtSearch.addActionListener(this);
		BtSearch.setPreferredSize(new Dimension(100,28));
		BtReg = new JButton("���");
		BtReg.addActionListener(this);
		BtReg.setPreferredSize(new Dimension(100,28));
//		BtCancel = new JButton("�ݱ�");
		
		
		getData(ModelData.selectModel());
		ManModelView();
	}
	
	private void getData(List<Map<String, Serializable>> ModelListData) {
		
		for(int i=0; i < ModelListData.size(); i++) {
			model1.addRow(new Object[] {
					
					ModelListData.get(i).get("MODEL_NM"),
					ModelListData.get(i).get("MODEL_NUM"),
					ModelListData.get(i).get("FIRST_CTGR"),
					ModelListData.get(i).get("TOP_CLOTH_CTGR"),
					ModelListData.get(i).get("BOT_CLOTH_CTGR"),
					ModelListData.get(i).get("OUTER_CTGR"),
					ModelListData.get(i).get("SHIR_CTGR"),
					ModelListData.get(i).get("SHOOSE_CTGR"),
			});
		}
}
	
	private void ManModelView() {

		setExtendedState(MAXIMIZED_BOTH);

		setTitle("Ȩ������ ������");


		setLayout(gbl);
		
		gridbagAdd(vRegModel, 0, 1, 1, 1);
		gridbagAdd(vAdminModel2, 1, 1, 1, 1);
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
        gridbagAdd(scrollpane1, 1, 3, 10, 5);
	    gbc.anchor = GridBagConstraints.EAST;
	    gridbagAdd(BtReg, 5, 10, 1, 1);


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
		new ManModel2();
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == BtReg) {
			dispose();
		}
		
		if(e.getSource() == BtSearch) {
			String search = xSearch.getText();
			if(CbSearch.getSelectedItem() == "�𵨸�") {
				model1.setRowCount(0);
				getData(ModelData.searchModel(search));
			} else if(CbSearch.getSelectedItem() == "1���з�") {
				model1.setRowCount(0);
				getData(ModelData.searchModel1(search));
			}
		}
		
	}
	
	@Override
	public void mouseClicked(java.awt.event.MouseEvent e) {
		int row;
		if(e.getSource() == tModelInfo) {
		row = tModelInfo.getSelectedRow();
		ModelName = "";
		ModelName += tModelInfo.getValueAt(row, 0);
		System.out.println(ModelName);
//		this.ModelName = ModelName;
		}
	}



	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}   
}	

	
			