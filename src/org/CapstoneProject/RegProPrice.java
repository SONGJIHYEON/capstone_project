
  
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
import java.text.SimpleDateFormat;
import java.util.Date;
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


public class RegProPrice extends JPanel implements ActionListener {
	
	private static final int MAXIMIZED_BOTH = 0;
	private JLabel vRegModel, vProPrice, vProNm, vModelCtgr1, vModelCtgr2, vProPrice2, vProSell, vProSellPrice, vModelSize, 
					vexPrice, vexStDate, vexEndDate, vModPrice, vModStDate, vModEndDate;
	private JTextField xProNm, xProPrice, xProSellPrice, xProSell, xexPrice, xexStDate, xexEndDate, xModPrice, xModStDate, xModEndDate;
//	private JTextArea xProSell;

	private String[] ctgr1 = {"상의", "하의", "아우터", "셔츠", "신발"};
	private String[] ctgr2_1 = {"맨투맨", "반팔T", "긴팔T", "후드", "니트"};
	private String[] ctgr2_2 = {"청바지", "슬랙스", "면바지", "운동복", "반바지"}; 
	private String[] ctgr2_3 = {"코트", "가디건", "조끼", "집업", "점퍼", "패딩", "야상", "재킷"};
	private String[] ctgr2_4 = {"스트라이프", "체크", "긴팔셔츠", "반팔셔츠"};
	private String[] ctgr2_5 = {"스니커즈", "운동화", "로퍼", "구두", "워커", "부츠", "샌들", "슬리퍼"};     // 사원구분 콤보박스의 목록
//	         
//	private DefaultTableModel model1 = new DefaultTableModel(col1, 0);  
//	private DefaultTableModel model2 = new DefaultTableModel(col2, 0);      

	private JTable tBest, tNew;      
	private JScrollPane scrollpane1, scrollpane2;  
   
	private JButton Btsell, BtReg, BtCancel, BtPro; 

	String pro_num, proname, proname2, modprice, modstdate, modendate, date, ex_price, ex_st_date, ex_end_date;
	
	GridBagLayout gbl;
	GridBagConstraints gbc;
	
	
	public void getData(List<Map<String, Serializable>> ProPriceListData) {
		
		ex_price = "";
		ex_price += ProPriceListData.get(0).get("UP"); 
		
		ex_st_date = "";
		ex_st_date += ProPriceListData.get(0).get("APP_ST_DT");
		
		ex_end_date = "";
		ex_end_date += ProPriceListData.get(0).get("APP_END_DT");		
		
		xexPrice.setText(ex_price);
		xexStDate.setText(ex_st_date);
		xexEndDate.setText(ex_end_date);
		
	}
	
	
	public RegProPrice() {
		
		Date dt = new Date();
		SimpleDateFormat spdate = new SimpleDateFormat("yyyy-MM-dd");
		
		date = spdate.format(dt);
		
		gbl = new GridBagLayout();
		gbc = new GridBagConstraints(); 

		vProPrice = new JLabel("상품단가변경");
		vProPrice.setPreferredSize(new Dimension(200,28));
        

		xProNm = new JTextField(20);
//		xProPrice = new JTextField(20);
//		xProPrice.setEnabled(false);
//		xProSellPrice = new JTextField(20);
//		xProSellPrice.setEnabled(false);
		xexPrice = new JTextField(20);
		xexPrice.setEnabled(false);
		xexStDate = new JTextField(20);
		xexStDate.setEnabled(false);
		xexEndDate = new JTextField(20);
		xexEndDate.setEnabled(false);
		xModPrice = new JTextField(20);
		xModStDate = new JTextField(20);
		xModStDate.setText(date);
		xModEndDate = new JTextField(20);
		xModEndDate.setText("9999-12-31");
		
		vProNm = new JLabel("상품명");
		vProPrice2 = new JLabel("상품단가");
		vProSell = new JLabel("상품판매량");
		vProSellPrice = new JLabel("상품 매출액");
		vexPrice = new JLabel("적용단가");
		vexStDate = new JLabel("적용시작일");
		vexEndDate = new JLabel("적용종료일");
		vModPrice = new JLabel("변경단가");
		vModStDate = new JLabel("변경시작일");
		vModEndDate = new JLabel("변경종료일");

		
		BtPro = new JButton("상품명 가져오기");
		BtPro.addActionListener(this);
		BtReg = new JButton("등록");
		BtReg.addActionListener(this);
		BtCancel = new JButton("닫기");

//		setExtendedState(MAXIMIZED_BOTH);
		RegProPriceView();
	}
	
	private void RegProPriceView() {


//		setTitle("홈페이지 관리자");


		setLayout(gbl);
		

		gridbagAdd(vProPrice, 1, 1, 1, 1);

	    gridbagAdd(vProNm, 1, 2, 1, 1);
	    gridbagAdd(vexPrice, 1, 3, 1, 1);
	    gridbagAdd(vexStDate, 1, 4, 1, 1);
	    gridbagAdd(vexEndDate, 1, 5, 1, 1);
//	    gridbagAdd(vProSellPrice, 1, 6, 1, 1);
//	    gridbagAdd(vProSell, 1, 7, 1, 1);
	    gridbagAdd(vModPrice, 1, 8, 1, 1);
	    gridbagAdd(vModStDate, 1, 9, 1, 1);
	    gridbagAdd(vModEndDate, 1, 10, 1, 1);
	    
	    gridbagAdd(xProNm, 2, 2, 2, 1);
	    gridbagAdd(xexPrice, 2, 3, 2, 1);
	    gridbagAdd(xexStDate, 2, 4, 2, 1);
	    gridbagAdd(xexEndDate, 2, 5, 2, 1);
//	    gridbagAdd(xProPrice, 2, 6, 2, 1);
//	    gridbagAdd(xProSellPrice, 2, 7, 2, 1);
	    gridbagAdd(xModPrice, 2, 8, 2, 1);
	    gridbagAdd(xModStDate, 2, 9, 2, 1);
	    gridbagAdd(xModEndDate, 2, 10, 2, 1);

        gbc.anchor = GridBagConstraints.WEST;
        gridbagAdd(BtPro, 4, 2, 1, 1);
        gridbagAdd(BtReg, 2, 11, 1, 1);
        gbc.anchor = GridBagConstraints.EAST;
        gridbagAdd(BtCancel, 3, 11, 1, 1);

	   
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
		JFrame jf = new JFrame();
		jf.add(new RegProPrice());
//		new RegModel();
		jf.pack();
		jf.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == BtPro) {
			ProSearch p = new ProSearch(new JFrame());
			pro_num = p.PRO_NUM;
			proname = p.PRO_NM;
			xProNm.setText(proname);
			getData(ProPriceData.ProPrice(proname));

			
		}if(e.getSource() == BtReg) {
			proname2 = xProNm.getText();
			modprice = xModPrice.getText();
			modstdate = xModStDate.getText();
			modendate = xModEndDate.getText();
			ProPriceData.createProPrice(pro_num, modstdate, modendate, modprice, proname2);
			
			xProNm.setText("");
			xexPrice.setText("");
			xexStDate.setText("");
			xexEndDate.setText("");
			xModPrice.setText("");
		}

	}
}

