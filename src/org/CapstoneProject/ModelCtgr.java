package org.CapstoneProject;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class ModelCtgr extends JFrame implements MouseListener, ActionListener {
	private JLabel vRegModel, vRegModel2, vModelNm, vModelCtgr1, vModelCtgr2, vModelCode, vModelImage, vAdminModel, 
	vModelCtgr, vRegPro, vAdminPro, vProUp, vModelExp, vModelSize;
	private JTextField xModelNm, xModelCode, xModelCtgr1, xModelCtgr2, xModelExp, xModelSize, xModelImage;
	
	
//	private JTextArea xModelImage;

//	private JPasswordField xMemPw1, xMemPw2;

//  private String[] div = {"������", "�ӽ���", "�����"};      // ������� �޺��ڽ��� ���
	private String[] col1 = {"1�� �з�"};     
	private Object[][] col1_1 ={
			{"����"}, {"����"}, {"����"}, {"�ƿ���"}, {"�Ź�"}   
	};
	private String[] col2 = {"2�� �з�"};  
	private Object[][] col2_1 ={
			{"������"}, {"����"}, {"����"}, {"��Ʈ"}, {"�ĵ�"}   
	};
	private Object[][] col2_2 ={
			{"û����"}, {"������"}, {"�����"}, {"���"}, {"�ݹ���"}   
	};
	private Object[][] col2_3 ={
			{"��Ʈ"}, {"�����"}, {"����"}, {"����"}, {"�е�"}, {"����"}, {"�߻�"}, {"��Ŷ"}  
	};
	private Object[][] col2_4 ={
			{"���ȼ���"}, {"üũ"}, {"���ȼ���"}, {"��Ʈ������"}
	};
	private Object[][] col2_5 ={
			{"��ƼĿ��"}, {"�ȭ"}, {"������"}, {"����"}, {"����"}, {"��Ŀ"}, {"����"}, {"����"}     
	};

	private DefaultTableModel model1 = new DefaultTableModel(col1_1, col1);  
	private DefaultTableModel model2 = new DefaultTableModel(col2_1, col2); 
	private DefaultTableModel model3 = new DefaultTableModel(col2_2, col2); 
	private DefaultTableModel model4 = new DefaultTableModel(col2_3, col2); 
	private DefaultTableModel model5 = new DefaultTableModel(col2_4, col2); 
	private DefaultTableModel model6 = new DefaultTableModel(col2_5, col2);

	private JTable tCtgr1, tCtgr2;      
	private JScrollPane scrollpane1, scrollpane2;  
   
	private JButton BtBussMan, BtProMan, BtOdMan, BtMbMan, BtEmpMan, BtSearch, BtImg, BtReg, BtCancel; 
	private JComboBox<String> Cbctgr1, Cbctgr2;
	
	int rowNum, rowNum2, ModelCtgrNum;
//	int rowNum = tCtgr1.getSelectedRow();
//	int rowNum2 = tCtgr2.getSelectedRow();
	

	static int[][] arr = {
			{1, 2, 3, 4, 5},
			{6, 7, 8, 9, 10},
			{11, 12, 13, 14},
			{15, 16, 17, 18, 19, 20, 21, 22},
			{23, 24, 25, 26, 27, 28, 29, 30},

	};
	
	String FIRST_CTGR, TOP_CLOTH_CTGR, BOT_CLOTH_CTGR, OUTER_CTGR, SHIR_CTGR, SHOOSE_CTGR;
	
	String first[] = {"A", "B", "C", "D", "E"};
	String second[] = {"a", "b", "c", "d", "e", "f", "g", "h"}; 
	
	
	GridBagLayout gbl;
	GridBagConstraints gbc;
	
	public ModelCtgr() {
		gbl = new GridBagLayout();
		gbc = new GridBagConstraints(); 
		
		vRegModel = new JLabel("�𵨵��");
		vRegModel.setPreferredSize(new Dimension(200,28));
		vAdminModel = new JLabel("�𵨰˻�");
		vAdminModel.setPreferredSize(new Dimension(200,28));
		vModelCtgr = new JLabel("�𵨺з�");
		vModelCtgr.setPreferredSize(new Dimension(200,28));
		vRegModel2 = new JLabel("�𵨺з�");
		vRegModel2.setPreferredSize(new Dimension(200,28));
		vRegPro = new JLabel("��ǰ���");
		vRegPro.setPreferredSize(new Dimension(200,28));
		vAdminPro = new JLabel("��ǰ����");
		vAdminPro.setPreferredSize(new Dimension(200,28));
		vProUp = new JLabel("��ǰ�ܰ�����");
        vProUp.setPreferredSize(new Dimension(200,28));
        

		BtBussMan = new JButton("�ŷ�����");
		BtBussMan.setPreferredSize(new Dimension(200,28));
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
//		
		tCtgr1 = new JTable(model1);
		tCtgr1.addMouseListener(this);
//		tCtgr1.setAutoCreateRowSorter(true);
        scrollpane1 = new JScrollPane(tCtgr1);
        scrollpane1.setPreferredSize(new Dimension(200,200));
        
        tCtgr2 = new JTable(model2);
        tCtgr2.addMouseListener(this);
        
        scrollpane2 = new JScrollPane(tCtgr2);
        scrollpane2.setPreferredSize(new Dimension(200,200));

		setExtendedState(MAXIMIZED_BOTH);
		ModelCtgrView();
	}
	
	private void ModelCtgrView() {


		setTitle("Ȩ������ ������");


		setLayout(gbl);
		
		gridbagAdd(vRegModel, 0, 1, 1, 1);
		gridbagAdd(vRegModel2, 1, 1, 1, 1);
		gridbagAdd(vAdminModel,0, 2, 1, 1);
	    gridbagAdd(vModelCtgr, 0, 3, 1, 1);
	    gridbagAdd(vRegPro, 0, 4, 1, 1);
	    gridbagAdd(vAdminPro, 0, 5, 1, 1);
	    gridbagAdd(vProUp, 0, 6, 1, 1);
	    gbc.anchor = GridBagConstraints.WEST;
	    gridbagAdd(scrollpane1, 1, 2, 3, 6);
	    gridbagAdd(scrollpane2, 2, 2, 3, 6);
	    

	    
        gbc.anchor = GridBagConstraints.CENTER;
        gridbagAdd(BtBussMan, 1, 0, 1, 1);
        gridbagAdd(BtProMan, 2, 0, 2, 1);
        gridbagAdd(BtOdMan, 4, 0, 1, 1);
        
        gridbagAdd(BtMbMan, 5, 0, 1, 1);
        gridbagAdd(BtEmpMan, 6, 0, 1, 1);
        gbc.anchor = GridBagConstraints.WEST;
        gridbagAdd(BtReg, 3, 9, 1, 1);
        gbc.anchor = GridBagConstraints.EAST;
        gridbagAdd(BtCancel, 3, 9, 1, 1);
        

	    
	   
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
		new ModelCtgr();

	}

	@Override
	public void mouseClicked(java.awt.event.MouseEvent e) {
		if(e.getSource() == tCtgr1) {
			rowNum = tCtgr1.getSelectedRow();
			if (rowNum == 0) {
				tCtgr2.setModel(model2);
				System.out.println(first[0]);
			} else if(rowNum == 1) {
				tCtgr2.setModel(model3);
				System.out.println(first[1]);
			} else if(rowNum == 2) {
				tCtgr2.setModel(model4);
				System.out.println(first[2]);
			} else if(rowNum == 3) {
				tCtgr2.setModel(model5);
				System.out.println(first[3]);
			} else if(rowNum == 4) {
				tCtgr2.setModel(model6);
				System.out.println(first[4]);
			}
		} else if(e.getSource() == tCtgr2) {
			rowNum2 = tCtgr2.getSelectedRow();
			if(rowNum2 == 0) {
				System.out.println(second[0]);
			} else if(rowNum2 == 1) {
				System.out.println(second[1]);
			} else if(rowNum2 == 2) {
				System.out.println(second[2]);
			} else if(rowNum2 == 3) {
				System.out.println(second[3]);
			} else if(rowNum2 == 4) {
				System.out.println(second[4]);
			} else if(rowNum2 == 5) {
				System.out.println(second[5]);
			} else if(rowNum2 == 6) {
				System.out.println(second[6]);
			} else if(rowNum2 == 7) {
				System.out.println(second[7]);
			} else if(rowNum2 == 8) {
				System.out.println(second[8]);
			}
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
//	 FIRST_CTGR, TOP_CLOTH_CTGR, BOT_CLOTH_CTGR, OUTER_CTGR, SHIR_CTGR, SHOOSE_CTGR;
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == BtReg) {
			System.out.println(rowNum + " " + rowNum2);
		if(rowNum == 0 && rowNum2 == 0) {
				ModelCtgrNum = arr[0][0];
				FIRST_CTGR = first[0];
				TOP_CLOTH_CTGR = second[0];
				BOT_CLOTH_CTGR = null;
				OUTER_CTGR = null;
				SHIR_CTGR = null;
				SHOOSE_CTGR = null;
				ModelCtgrData.initModelCtgrData(ModelCtgrNum, FIRST_CTGR, TOP_CLOTH_CTGR, BOT_CLOTH_CTGR, OUTER_CTGR, SHIR_CTGR, SHOOSE_CTGR);
				ModelCtgrData.createModelCtgr();
				BtReg = null;
			}
			
		}else if(rowNum == 0 && rowNum2 == 1) {
				ModelCtgrNum = arr[0][1];
				FIRST_CTGR = first[0];
				TOP_CLOTH_CTGR = second[1];
				BOT_CLOTH_CTGR = null;
				OUTER_CTGR = null;
				SHIR_CTGR = null;
				SHOOSE_CTGR = null;
				System.out.println(ModelCtgrNum);
				ModelCtgrData.initModelCtgrData(ModelCtgrNum, FIRST_CTGR, TOP_CLOTH_CTGR, BOT_CLOTH_CTGR, OUTER_CTGR, SHIR_CTGR, SHOOSE_CTGR);
				ModelCtgrData.createModelCtgr();
				
			}
		}
}
