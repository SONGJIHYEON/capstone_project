package org.CapstoneProject;

import java.awt.Component;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.Rectangle;
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


public class corr_search extends Dialog implements MouseListener, ActionListener{
	private JTextField xSearch;
	
	private String[] col1 = { "거래처번호", "거래처명", "대표명", "연락처", "주소", "" };
	private String[] search = { "거래처번호", "거래처명", "대표명" };    

	private JTable tModelInfo;    
	private JScrollPane scrollpane1;  	
	
	private DefaultTableModel model1 = new DefaultTableModel(col1, 0);  
   
	private JButton BtSearch, BtReg; 
	private JComboBox<String> CbSearch;
	
	String CORR_NM, CORR_NUM;
	
	GridBagLayout gbl;
	GridBagConstraints gbc;
	
	public corr_search(JFrame fr) {
		super(fr, "", true);
		gbl = new GridBagLayout();
		gbc = new GridBagConstraints(); 
        		
		CbSearch = new JComboBox<String>(search);
		CbSearch.setPreferredSize(new Dimension(200,28));
		
		xSearch = new JTextField(20);
		xSearch.setPreferredSize(new Dimension(200,28));
		
		tModelInfo = new JTable(model1);
		tModelInfo.addMouseListener(this);
        scrollpane1 = new JScrollPane(tModelInfo);
        scrollpane1.setPreferredSize(new Dimension(700, 300));
		
		BtSearch = new JButton("검색");
		BtSearch.addActionListener(this);
		BtSearch.setPreferredSize(new Dimension(100,28));
		BtReg = new JButton("등록");
		BtReg.addActionListener(this);
		BtReg.setPreferredSize(new Dimension(100,28));
//		BtCancel = new JButton("닫기");
		
		
		getData(corrData.selectcorr());
		ManModelView();
	}
	
	private void getData(List<Map<String, Serializable>> corrListData) {
		
		for(int i=0; i < corrListData.size(); i++) {
			model1.addRow(new Object[] {
					
					corrListData.get(i).get("BUS_NUM"), 
					corrListData.get(i).get("BUS_NM"),
					corrListData.get(i).get("REP_NM"), 
					corrListData.get(i).get("BUS_TEL"),
					corrListData.get(i).get("ADDR")

			});
		}
}
	
	private void ManModelView() {

//		setExtendedState(MAXIMIZED_BOTH);

		setTitle("홈페이지 관리자");


		setLayout(gbl);

//	    gridbagAdd(vCORRUp, 0, 6, 1, 1);
	    
	    gridbagAdd(CbSearch, 1, 2, 1, 1);
	    gridbagAdd(xSearch, 2, 2, 1, 1);

	    
        gbc.anchor = GridBagConstraints.CENTER;
//        gridbagAdd(BtBussMan, 1, 0, 1, 1);
//        gridbagAdd(BtCORRMan, 2, 0, 1, 1);
//        gridbagAdd(BtOdMan, 3, 0, 1, 1);
//        gridbagAdd(BtMbMan, 4, 0, 1, 1);
//        gridbagAdd(BtEmpMan, 5, 0, 1, 1);
        
	    gbc.anchor = GridBagConstraints.WEST;
	    gridbagAdd(BtSearch, 3, 2, 1, 1);
        gridbagAdd(scrollpane1, 1, 3, 5, 5);
	    gbc.anchor = GridBagConstraints.EAST;
	    gridbagAdd(BtReg, 5, 8, 1, 1);
	    

	    pack();
	    setResizable(true);
        setVisible(true);
	}   
	         
	private void gridbagAdd(Component c, int x, int y, int w, int h) {   
		
		gbc.gridx = x;
		gbc.gridy = y; 
		//가장 왼쪽 위 gridx, gridy값은 0    
		
		gbc.gridwidth  = w;
		gbc.gridheight = h;
		
		
		gbl.setConstraints(c, gbc); //컴포넌트를 컴포넌트 위치+크기 정보에 따라 GridBagLayout에 배치   
		
		add(c);   
		
	}   
	
	public static void main(String[] args) {   
		new corr_search(new JFrame());
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == BtReg) {
			dispose();
		}
		
		if(e.getSource() == BtSearch) {
			String search = xSearch.getText();
			if(CbSearch.getSelectedItem() == "거래처번호") {
				model1.setRowCount(0);
				getData(corrData.searchCorr1(search));
			} else if(CbSearch.getSelectedItem() == "거래처명") {
				model1.setRowCount(0);
				getData(corrData.searchCorr2(search));
			} else if(CbSearch.getSelectedItem() == "대표명") {
				model1.setRowCount(0);
				getData(corrData.searchCorr3(search));
			}
		}
		
	}
	
	@Override
	public void mouseClicked(java.awt.event.MouseEvent e) {
		int row;
		if(e.getSource() == tModelInfo) {
		row = tModelInfo.getSelectedRow();
		CORR_NM = "";
		CORR_NM += tModelInfo.getValueAt(row, 1);
		CORR_NUM = "";
		CORR_NUM += tModelInfo.getValueAt(row, 0);
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