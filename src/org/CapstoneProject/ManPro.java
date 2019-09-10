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
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class ManPro extends JPanel {
	private JLabel vAdminPro2;
	private JTextField xSearch;

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
   
	private JButton BtSearch, BtReg; 
	private JComboBox<String> CbSearch, Cbctgr1, CbCbctgr2_1, CbCbctgr2_2, CbCbctgr2_3, CbCbctgr2_4, CbCbctgr2_5;
	
	GridBagLayout gbl;
	GridBagConstraints gbc;
	
	public ManPro() {
		gbl = new GridBagLayout();
		gbc = new GridBagConstraints(); 
        
		vAdminPro2 = new JLabel("��ǰ��ȸ");
		vAdminPro2.setPreferredSize(new Dimension(200,28));
		
		CbSearch = new JComboBox<String>(search);
		CbSearch.setPreferredSize(new Dimension(200,28));
		
		xSearch = new JTextField(20);
		xSearch.setPreferredSize(new Dimension(200,28));
		
		tModelInfo = new JTable(model1);
        scrollpane1 = new JScrollPane(tModelInfo);
        scrollpane1.setPreferredSize(new Dimension(1000, 300));

		
		BtSearch = new JButton("�˻�");
		BtSearch.setPreferredSize(new Dimension(100,28));
		BtReg = new JButton("���");
		BtReg.setPreferredSize(new Dimension(100,28));
//		BtCancel = new JButton("�ݱ�");
		ManProView();
	}
	
	private void ManProView() {

		setLayout(gbl);
		
		gridbagAdd(vAdminPro2, 1, 1, 1, 1);
	    
	    gridbagAdd(CbSearch, 1, 2, 1, 1);
	    gridbagAdd(xSearch, 2, 2, 1, 1);

	    
        gbc.anchor = GridBagConstraints.CENTER;
        
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

	
			