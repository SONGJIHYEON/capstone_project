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
   
	private JButton BtBussMan, BtProMan, BtOdMan, BtMbMan, BtEmpMan, BtSearch, BtReg; 
	private JComboBox<String> CbSearch, Cbctgr1, CbCbctgr2_1, CbCbctgr2_2, CbCbctgr2_3, CbCbctgr2_4, CbCbctgr2_5;
	
	GridBagLayout gbl;
	GridBagConstraints gbc;
	
	public ManPro() {
		gbl = new GridBagLayout();
		gbc = new GridBagConstraints(); 
        
		vRegModel = new JLabel("모델등록");
		vRegModel.setPreferredSize(new Dimension(200,28));
		vAdminModel = new JLabel("모델검색");
		vAdminModel.setPreferredSize(new Dimension(200,28));
		vModelCtgr = new JLabel("모델분류");
		vModelCtgr.setPreferredSize(new Dimension(200,28));
		vRegPro = new JLabel("상품등록");
		vRegPro.setPreferredSize(new Dimension(200,28));
		vAdminPro = new JLabel("상품관리");
		vAdminPro.setPreferredSize(new Dimension(200,28));
		vProUp = new JLabel("상품단가변경");
        vProUp.setPreferredSize(new Dimension(200,28));
        
		vAdminPro2 = new JLabel("상품관리");
		vAdminPro2.setPreferredSize(new Dimension(200,28));
		
		CbSearch = new JComboBox<String>(search);
		CbSearch.setPreferredSize(new Dimension(200,28));
		
		xSearch = new JTextField(20);
		xSearch.setPreferredSize(new Dimension(200,28));
		
		tModelInfo = new JTable(model1);
        scrollpane1 = new JScrollPane(tModelInfo);
        scrollpane1.setPreferredSize(new Dimension(1000, 300));


		BtBussMan = new JButton("거래관리");
		BtBussMan.setPreferredSize(new Dimension(200,28));
        
//        regist.addActionListener(this);
		BtProMan = new JButton("모델/상품관리");
		BtProMan.setPreferredSize(new Dimension(200,28));
//        cancel.addActionListener(this);
		BtOdMan = new JButton("주문관리");
		BtOdMan.setPreferredSize(new Dimension(200,28));
		BtMbMan = new JButton("회원관리");
		BtMbMan.setPreferredSize(new Dimension(200,28));
		BtEmpMan = new JButton("직원관리");
		BtEmpMan.setPreferredSize(new Dimension(200,28));
		
		BtSearch = new JButton("검색");
		BtSearch.setPreferredSize(new Dimension(100,28));
		BtReg = new JButton("등록");
		BtReg.setPreferredSize(new Dimension(100,28));
//		BtCancel = new JButton("닫기");

		setExtendedState(MAXIMIZED_BOTH);
		ManProView();
	}
	
	private void ManProView() {


		setTitle("홈페이지 관리자");


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

	
			