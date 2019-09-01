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
//	private String[] ctgr1 = {"상의", "하의", "셔츠", "아우터", "신발"};
	private String[] size1 = {"90", "95", "100", "105", "110"};
	private String[] size2 = {"27", "28", "29", "30", "31", "32", "33", "34", "35" }; 
//	private String[] ctgr2_1 = {"맨투맨", "반팔", "긴팔", "니트", "후드"};
//	private String[] ctgr2_2 = {"청바지", "슬랙스", "면바지", "운동복", "반바지"};
//	private String[] ctgr2_3 = {"반팔셔츠", "체크", "긴팔셔츠", "스트라이프"};
//	private String[] ctgr2_4 = {"코트", "가디건", "조끼", "집업", "패딩", "점퍼", "야상", "재킷"};
//	private String[] ctgr2_5 = {"스티커즈", "운동화", "슬리퍼", "로퍼", "구두", "워커", "부츠", "샌들"};
//	private String[] col1 = {"best"};      
//	private String[] col2 = {"new"};      
//  private String[] div = {"정규직", "임시직", "계약직"};      // 사원구분 콤보박스의 목록
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
        
		vRegModel = new JLabel("모델등록");
		vRegModel.setPreferredSize(new Dimension(200,28));
		vAdminModel = new JLabel("모덷검색");
		vAdminModel.setPreferredSize(new Dimension(200,28));
		vModelCtgr = new JLabel("모델분류");
		vModelCtgr.setPreferredSize(new Dimension(200,28));
		vRegPro = new JLabel("상품등록");
		vRegPro.setPreferredSize(new Dimension(200,28));
		vAdminPro = new JLabel("상품관리");
		vAdminPro.setPreferredSize(new Dimension(200,28));
		vProUp = new JLabel("상품단가변경");
        vProUp.setPreferredSize(new Dimension(200,28));
		
        vModiPro = new JLabel("상품수정");
		vModiPro.setPreferredSize(new Dimension(200,28));
        
		vProNm = new JLabel("상품명");
		vProColor = new JLabel("상품 색상");
		vProStock = new JLabel("재고등록");

		xModelNm = new JTextField(20);
		xModelCode = new JTextField(20);
		xSale = new JTextField(20);
		xProDetail = new JTextField(20);
		xPrice = new JTextField(20);
		xProStock = new JTextField(20);
		
		vModelNm = new JLabel("모델명");
		vPrice = new JLabel("상품 가격");
		vSale = new JLabel("판매상태");
		CbSize1 = new JComboBox<String>(size1);
//		Cbctgr1.setPreferredSize(new Dimension(200,28));
//		vModelCtgr2 = new JLabel("2차분류");
		vProSize = new JLabel("상품 사이즈");
		vProDetail = new JLabel("상품 상세 정보");
		
		RSale = new JRadioButton("판매중");
		RSale.setSelected(true);
		RSoldOut = new JRadioButton("품절");
		RBehind = new JRadioButton("숨김");
		
		BtRadio = new ButtonGroup();
		BtRadio.add(RSale);
		BtRadio.add(RSoldOut);
		BtRadio.add(RBehind);
	
		PRadio = new JPanel(new FlowLayout(FlowLayout.CENTER));
		PRadio.add(RSale);
		PRadio.add(RSoldOut);
		PRadio.add(RBehind);


		BtBussMan = new JButton("거래관리");
		BtBussMan.setPreferredSize(new Dimension(200,28));
		
//		BtModel = new JButton("모델 불러오기");
        
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
//		BtSearch = new JButton("검색");
//		BtSearch.setPreferredSize(new Dimension(100,28));
		BtModify = new JButton("수정");
		BtDelete = new JButton("삭제");

		setExtendedState(MAXIMIZED_BOTH);
		ModiProView();
	}
	
	private void ModiProView() {


		setTitle("홈페이지 관리자");


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
		//가장 왼쪽 위 gridx, gridy값은 0    
		
		gbc.gridwidth  = w;
		gbc.gridheight = h;
		
		
		gbl.setConstraints(c, gbc); //컴포넌트를 컴포넌트 위치+크기 정보에 따라 GridBagLayout에 배치   
		
		add(c);   
		
	}   
	
	public static void main(String[] args) {   
		new ModiPro();
	}   
}	

	
			