
package org.CapstoneProject;

import java.awt.Color;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

public class DelivView extends Dialog implements ActionListener {

//	private static final int MAXIMIZED_BOTH = 0;
	private JLabel vOd_num, vDeliv_comp, vDeliv_num, vDeliv_date, vDeliv_cond, vDeliv_type;
	private JTextField xOd_num, xDeliv_comp, xDeliv_num, xDeliv_date, xDeliv_cond, xDeliv_type;
//	private JTextArea xModelImage;

//	private DefaultTableModel model1 = new DefaultTableModel(col1, 0);  
//	private DefaultTableModel model2 = new DefaultTableModel(col2, 0);      

	private JButton BtReg, BtCancel, BtCode;
	private JComboBox<String> Cbctgr1, Cbctgr2;

	String Od_num, sOD_NUM, sDELIV_COMPANY, sINV_NUM, sDELIV_DATE, sDELIV_COND_TP, sDELIV_TP, sDate;

	GridBagLayout gbl;
	GridBagConstraints gbc;



	public DelivView(JFrame fr) {
		super(fr, "", true);

		getData(DelivData.selectDelivView(Od_list_Deliv.od_num));
		
		gbl = new GridBagLayout();
		gbc = new GridBagConstraints();

//		vRegModel2 = new JLabel("모델등록");
		vOd_num = new JLabel("주문번호");
		vOd_num.setPreferredSize(new Dimension(120, 28));
		vOd_num.setHorizontalAlignment(JLabel.CENTER);
		vOd_num.setFont(new Font("돋움", Font.PLAIN, 18));

		vDeliv_comp = new JLabel("배송업체");
		vDeliv_comp.setPreferredSize(new Dimension(120, 28));
		vDeliv_comp.setHorizontalAlignment(JLabel.CENTER);
		vDeliv_comp.setFont(new Font("돋움", Font.PLAIN, 18));

		vDeliv_num = new JLabel("운송장번호");
		vDeliv_num.setPreferredSize(new Dimension(120, 28));
		vDeliv_num.setHorizontalAlignment(JLabel.CENTER);
		vDeliv_num.setFont(new Font("돋움", Font.PLAIN, 18));

		vDeliv_date = new JLabel("배송일시");
		vDeliv_date.setPreferredSize(new Dimension(120, 28));
		vDeliv_date.setHorizontalAlignment(JLabel.CENTER);
		vDeliv_date.setFont(new Font("돋움", Font.PLAIN, 18));

		vDeliv_cond = new JLabel("배송상태");
		vDeliv_cond.setPreferredSize(new Dimension(120, 28));
		vDeliv_cond.setHorizontalAlignment(JLabel.CENTER);
		vDeliv_cond.setFont(new Font("돋움", Font.PLAIN, 18));

		vDeliv_type = new JLabel("배송구분");
		vOd_num.setPreferredSize(new Dimension(120, 28));
		vOd_num.setHorizontalAlignment(JLabel.CENTER);
		vDeliv_type.setFont(new Font("돋움", Font.PLAIN, 18));
		
		xOd_num = new JTextField(20);
		xOd_num.setText(sOD_NUM);
		xOd_num.setEnabled(false);
		xOd_num.setPreferredSize(new Dimension(120, 28));

		xDeliv_comp = new JTextField(20);
		xDeliv_comp.setText(sDELIV_COMPANY);
		xDeliv_comp.setEnabled(false);
		xDeliv_comp.setPreferredSize(new Dimension(120, 28));

		xDeliv_num = new JTextField(20);
		xDeliv_num.setText(sINV_NUM);
		xDeliv_num.setEnabled(false);
		xDeliv_num.setPreferredSize(new Dimension(120, 28));

		xDeliv_date = new JTextField(20);
		xDeliv_date.setText(sDate);
		xDeliv_date.setEnabled(false);
		xDeliv_date.setPreferredSize(new Dimension(120, 28));

		xDeliv_cond = new JTextField(20);
		xDeliv_cond.setText(sDELIV_COND_TP);
		xDeliv_cond.setEnabled(false);
		xDeliv_cond.setPreferredSize(new Dimension(120, 28));

		xDeliv_type = new JTextField(20);
		xDeliv_type.setText(sDELIV_TP);
		xDeliv_type.setEnabled(false);
		xDeliv_type.setPreferredSize(new Dimension(120, 28));
		
		BtCancel = new JButton("닫기");
		BtCancel.setBackground(Color.white);
		BtCancel.addActionListener(this);
		
		RegModelView();
	}

	private void RegModelView() {

		setTitle("배송등록");

		setLayout(gbl);

		gbc.anchor = GridBagConstraints.CENTER;
//		gridbagAdd(vRegModel2, 1, 1, 1, 1);

		gridbagAdd(vOd_num, 1, 2, 1, 1);
		gridbagAdd(vDeliv_comp, 1, 3, 1, 1);
		gridbagAdd(vDeliv_num, 1, 4, 1, 1);
		gridbagAdd(vDeliv_date, 1, 5, 1, 1);
		gridbagAdd(vDeliv_cond, 1, 6, 1, 1);
		gridbagAdd(vDeliv_type, 1, 7, 1, 1);

		gridbagAdd(xOd_num, 2, 2, 1, 1);
		gridbagAdd(xDeliv_comp, 2, 3, 1, 1);
		gridbagAdd(xDeliv_num, 2, 4, 1, 1);
		gridbagAdd(xDeliv_date, 2, 5, 1, 1);
		gridbagAdd(xDeliv_cond, 2, 6, 1, 1);
		gridbagAdd(xDeliv_type, 2, 7, 1, 1);
		
		gbc.anchor = GridBagConstraints.EAST;
		gridbagAdd(BtCancel, 2, 8, 1, 1);

//	    gridbagAdd(vTop, 1, 1, 1, 1);
//	    gridbagAdd(vBottom, 2, 1, 1, 1);
//	    gridbagAdd(vOuter, 3, 1, 1, 1);
//	    gridbagAdd(vShirts, 4, 1, 1, 1);
//	    gridbagAdd(vShoes, 5, 1, 1, 1);

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
	
	private void getData(List<Map<String, Serializable>> delivListData) {
		
		Date Date = null;
		
		sOD_NUM = (String) delivListData.get(0).get("OD_NUM");
		sDELIV_COMPANY = (String) delivListData.get(0).get("DELIV_COMPANY");
		sINV_NUM = (String) delivListData.get(0).get("INV_NUM");
		sDELIV_DATE = (String) delivListData.get(0).get("DELIV_DATE");
		sDELIV_COND_TP = (String) delivListData.get(0).get("DELIV_COND_TP");
		sDELIV_TP = (String) delivListData.get(0).get("DELIV_TP");
		
		try {
			Date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").parse(sDELIV_DATE);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sDate = new SimpleDateFormat("yyyy-MM-dd").format(Date);
		


	}

	public static void main(String[] args) {

		new DelivView(new JFrame());

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == BtCancel) {
			dispose();
		}
		
	}

}
