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
//	private String[] ctgr1 = {"상의", "하의", "셔츠", "아우터", "신발"};
//	private String[] ctgr2_1 = {"맨투맨", "반팔", "긴팔", "니트", "후드"};
//	private String[] ctgr2_2 = {"청바지", "슬랙스", "면바지", "운동복", "반바지"};
//	private String[] ctgr2_3 = {"반팔셔츠", "체크", "긴팔셔츠", "스트라이프"};
//	private String[] ctgr2_4 = {"코트", "가디건", "조끼", "집업", "패딩", "점퍼", "야상", "재킷"};
//	private String[] ctgr2_5 = {"스티커즈", "운동화", "슬리퍼", "로퍼", "구두", "워커", "부츠", "샌들"};
	
	private String[] col1 = {"No", "이미지", "모델명", "상품명", "가격", "재고", "수정/삭제"};      
	private String[] search = {"모델명", "모델번호"};    
	
//  private String[] div = {"정규직", "임시직", "계약직"};      // 사원구분 콤보박스의 목록
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
        
		vAdminPro2 = new JLabel("상품조회");
		vAdminPro2.setPreferredSize(new Dimension(200,28));
		
		CbSearch = new JComboBox<String>(search);
		CbSearch.setPreferredSize(new Dimension(200,28));
		
		xSearch = new JTextField(20);
		xSearch.setPreferredSize(new Dimension(200,28));
		
		tModelInfo = new JTable(model1);
        scrollpane1 = new JScrollPane(tModelInfo);
        scrollpane1.setPreferredSize(new Dimension(1000, 300));

		
		BtSearch = new JButton("검색");
		BtSearch.setPreferredSize(new Dimension(100,28));
		BtReg = new JButton("등록");
		BtReg.setPreferredSize(new Dimension(100,28));
//		BtCancel = new JButton("닫기");
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
		//가장 왼쪽 위 gridx, gridy값은 0    
		
		gbc.gridwidth  = w;
		gbc.gridheight = h;
		
		
		gbl.setConstraints(c, gbc); //컴포넌트를 컴포넌트 위치+크기 정보에 따라 GridBagLayout에 배치   
		
		add(c);   
		
	}   
	
	public static void main(String[] args) {   
		new ManPro();
	}   
}	

	
			