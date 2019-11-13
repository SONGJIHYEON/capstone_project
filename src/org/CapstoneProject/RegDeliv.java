
package org.CapstoneProject;

import java.awt.Component;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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

public class RegDeliv extends Dialog implements ActionListener, MouseListener {

//	private static final int MAXIMIZED_BOTH = 0;
	private JLabel vOd_num, vDeliv_num, vDeliv_date, vDeliv_cond, vDeliv_type;
	private JTextField xOd_num, xDeliv_num, xDeliv_date, xDeliv_cond, xDeliv_type;
//	private JTextArea xModelImage;

	private String[] ctgr1 = { "상의", "하의", "아우터", "셔츠", "신발" };
	private String[] ctgr2_1 = { "맨투맨", "반팔T", "긴팔T", "후드", "니트" };
	private String[] ctgr2_2 = { "청바지", "슬랙스", "면바지", "운동복", "반바지" };
	private String[] ctgr2_3 = { "코트", "가디건", "조끼", "집업", "점퍼", "패딩", "야상", "재킷" };
	private String[] ctgr2_4 = { "스트라이프", "체크", "긴팔셔츠", "반팔셔츠" };
	private String[] ctgr2_5 = { "스니커즈", "운동화", "로퍼", "구두", "워커", "부츠", "샌들", "슬리퍼" }; // 사원구분 콤보박스의 목록
//	         
//	private DefaultTableModel model1 = new DefaultTableModel(col1, 0);  
//	private DefaultTableModel model2 = new DefaultTableModel(col2, 0);      

	private JButton BtReg, BtCancel, BtCode;
	private JComboBox<String> Cbctgr1, Cbctgr2;

	String Od_num ;

	GridBagLayout gbl;
	GridBagConstraints gbc;

	
//	public void getData(List<Map<String, Serializable>> ModelListData) {
//		fModel = "";
//		fModel += ModelListData.get(0).get("MODEL_CTGR_NUM").toString();
//
//		MODEL_NUM = xModelCode.getText();
//		MODEL_CTGR_NUM = fModel;
//		MODEL_NM = xModelNm.getText();
//		MODEL_NICK = xModelNick.getText();
//		MODEL_EXP = xModelExp.getText();
//		REP_MODEL_IMG = "REP_" + xModelNm.getText();
//		DET_MODEL_IMG = "DET_" + xModelNm.getText();
//
//		ModelData.initModelData(MODEL_NUM, MODEL_CTGR_NUM, MODEL_NM, MODEL_EXP, MODEL_NICK, REP_MODEL_IMG,
//				DET_MODEL_IMG);
//		ModelData.createModel();
//	}

	public RegDeliv(JFrame fr) {
        super(fr, "", true);
        
        Od_num = Od_list_pre_pro.od_num;

		gbl = new GridBagLayout();
		gbc = new GridBagConstraints();
		

//		vRegModel2 = new JLabel("모델등록");
		vOd_num = new JLabel("주문번호");
		vOd_num.setFont(new Font("휴먼매직체", Font.PLAIN, 20));

		vDeliv_num = new JLabel("운송장번호");
		vDeliv_num.setFont(new Font("휴먼매직체", Font.PLAIN, 20));
		
		vDeliv_date = new JLabel("배송일시");
		vDeliv_date.setFont(new Font("휴먼매직체", Font.PLAIN, 20));
		
		vDeliv_cond = new JLabel("배송상태");
		vDeliv_cond.setFont(new Font("휴먼매직체", Font.PLAIN, 20));

		vDeliv_type = new JLabel("배송구분");
		vDeliv_type.setFont(new Font("휴먼매직체", Font.PLAIN, 20));

		xOd_num = new JTextField(20);
		xOd_num.setText(Od_num);
		xOd_num.setEnabled(false);
		xOd_num.setPreferredSize(new Dimension(120, 28));
		
		xDeliv_num = new JTextField(20);
		xDeliv_num.setPreferredSize(new Dimension(120, 28));
		
		xDeliv_date = new JTextField(20);
		xDeliv_date.setText("YYYYMMDD");
		xDeliv_date.addMouseListener(this);
		xDeliv_date.setPreferredSize(new Dimension(120, 28));
		
		xDeliv_cond = new JTextField(20);
		xDeliv_cond.setText("배송중");
		xDeliv_cond.setEnabled(false);
		xDeliv_cond.setPreferredSize(new Dimension(120, 28));
		
		xDeliv_type = new JTextField(20);
		xDeliv_type.setText("원배송");
		xDeliv_type.setEnabled(false);
		xDeliv_type.setPreferredSize(new Dimension(120, 28));

		BtReg = new JButton("등록");
		BtReg.addActionListener(this);
		BtCancel = new JButton("닫기");
		BtCancel.addActionListener(this);

		RegModelView();
	}

	private void RegModelView() {

		setTitle("모델등록");

		setLayout(gbl);

		gbc.anchor = GridBagConstraints.CENTER;
//		gridbagAdd(vRegModel2, 1, 1, 1, 1);
		

		gridbagAdd(vOd_num, 1, 2, 1, 1);
		gridbagAdd(vDeliv_num, 1, 3, 1, 1);
		gridbagAdd(vDeliv_date, 1, 4, 1, 1);
		gridbagAdd(vDeliv_cond, 1, 5, 1, 1);
		gridbagAdd(vDeliv_type, 1, 6, 1, 1);

		gridbagAdd(xOd_num, 2, 2, 1, 1);
		gridbagAdd(xDeliv_num, 2, 3, 1, 1);
		gridbagAdd(xDeliv_date, 2, 4, 1, 1);
		gridbagAdd(xDeliv_cond, 2, 5, 1, 1);
		gridbagAdd(xDeliv_type, 2, 6, 1, 1);

//	    gridbagAdd(vTop, 1, 1, 1, 1);
//	    gridbagAdd(vBottom, 2, 1, 1, 1);
//	    gridbagAdd(vOuter, 3, 1, 1, 1);
//	    gridbagAdd(vShirts, 4, 1, 1, 1);
//	    gridbagAdd(vShoes, 5, 1, 1, 1);


		gbc.anchor = GridBagConstraints.WEST;
		gridbagAdd(BtReg, 2, 7, 1, 1);
		
		gbc.anchor = GridBagConstraints.EAST;
		gridbagAdd(BtCancel, 2, 7, 1, 1);

		pack();
		setVisible(true);
	}

	private void gridbagAdd(Component c, int x, int y, int w, int h) {

		gbc.gridx = x;
		gbc.gridy = y;
		// 가장 왼쪽 위 gridx, gridy값은 0

		gbc.gridwidth = w;
		gbc.gridheight = h;

		gbl.setConstraints(c, gbc); // 컴포넌트를 컴포넌트 위치+크기 정보에 따라 GridBagLayout에 배치

		add(c);

	}

	public static void main(String[] args) {

		new RegDeliv(new JFrame());

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == BtCancel) {
			dispose();
		}else if(e.getSource() == BtReg) {
			String sOdnum = xOd_num.getText();
			String sDeliv_num = xDeliv_num.getText();
			String sDeliv_date = xDeliv_date.getText();
			String sDeliv_cond = xDeliv_cond.getText();
			String sDeliv_type = xDeliv_type.getText();
			DelivData.createDeliv(sDeliv_num, sOdnum, sDeliv_date, sDeliv_cond, sDeliv_type);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == xDeliv_date) {
			xDeliv_date.setText("");
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
