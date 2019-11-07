
  
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


public class ProSearch extends Dialog implements MouseListener, ActionListener{
	private JLabel vModelNm, vModelCtgr1, vModelCtgr2, vModelCode, vModelExp, vModelSize;
	private JTextField xModelNm, xModelCode, xModelCtgr1, xModelCtgr2, xModelExp, xModelSize, xSearch;
	
	private String[] col1 = {"상품번호", "상품명", "사이즈", "색상"};      
	private String[] search = {"상품명", "사이즈", "색상"};    
	
//  private String[] div = {"정규직", "임시직", "계약직"};      // 사원구분 콤보박스의 목록
//	private DefaultTableModel model2 = new DefaultTableModel(col2, 0);      

	private JTable tModelInfo;    
	private JScrollPane scrollpane1, scrollpane2;  	
	
	private DefaultTableModel model1 = new DefaultTableModel(col1, 0);  
   
	private JButton BtSearch, BtReg, BtCancel; 
	private JComboBox<String> CbSearch;
	
	String PRO_NM, PRO_NUM;
	
	GridBagLayout gbl;
	GridBagConstraints gbc;
	
	public ProSearch(JFrame fr) {
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
		
		getData(ProData.selectPro());
		ManModelView();
	}
	
	private void getData(List<Map<String, Serializable>> ProListData) {
		
		for(int i=0; i < ProListData.size(); i++) {
			model1.addRow(new Object[] {
					
					ProListData.get(i).get("Pro_NM"),
					ProListData.get(i).get("Pro_NUM"),
					ProListData.get(i).get("SIZ"),
					ProListData.get(i).get("CLR"),

			});
		}
}
	
	private void ManModelView() {

//		setExtendedState(MAXIMIZED_BOTH);

		setTitle("홈페이지 관리자");


		setLayout(gbl);

//	    gridbagAdd(vProUp, 0, 6, 1, 1);
	    
	    gridbagAdd(CbSearch, 1, 2, 1, 1);
	    gridbagAdd(xSearch, 2, 2, 1, 1);

	    
        gbc.anchor = GridBagConstraints.CENTER;
//        gridbagAdd(BtBussMan, 1, 0, 1, 1);
//        gridbagAdd(BtProMan, 2, 0, 1, 1);
//        gridbagAdd(BtOdMan, 3, 0, 1, 1);
//        gridbagAdd(BtMbMan, 4, 0, 1, 1);
//        gridbagAdd(BtEmpMan, 5, 0, 1, 1);
        
	    gbc.anchor = GridBagConstraints.WEST;
	    gridbagAdd(BtSearch, 3, 2, 1, 1);
        gridbagAdd(scrollpane1, 1, 3, 5, 5);
	    gbc.anchor = GridBagConstraints.EAST;
	    gridbagAdd(BtReg, 3, 8, 1, 1);	  
	    gridbagAdd(BtCancel, 5, 8, 1, 1);
	    

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
		new ProSearch(new JFrame());
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == BtReg) {
			dispose();
		}
		if(e.getSource() == BtSearch) {
			String search = xSearch.getText();
			if(CbSearch.getSelectedItem() == "상품명") {
				model1.setRowCount(0);
				getData(ProData.searchPro1(search));
			} else if(CbSearch.getSelectedItem() == "사이즈") {
				model1.setRowCount(0);
				getData(ProData.searchPro2(search));
			} else if(CbSearch.getSelectedItem() == "색상") {
				model1.setRowCount(0);
				getData(ProData.searchPro3(search));
			}
		}
		
	}
	
	@Override
	public void mouseClicked(java.awt.event.MouseEvent e) {
		int row;
		if(e.getSource() == tModelInfo) {
		row = tModelInfo.getSelectedRow();
		PRO_NM = "";
		PRO_NM += tModelInfo.getValueAt(row, 1);
		PRO_NUM = "";
		PRO_NUM += tModelInfo.getValueAt(row, 0);
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

