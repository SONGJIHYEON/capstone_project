package org.CapstoneProject;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class mb_look extends JPanel implements ActionListener, MouseListener {

	private JLabel mb_lookup, mb_lookup2, mb_gra;

	private JTextField Tsearch;
	private String[] col1 = { "아이디", "회원명", "휴대폰번호", "주소", "회원등급", "보유포인트" };
	private String[] search = { "아이디", "회원명", "회원등급" };

	private DefaultTableModel model1 = new DefaultTableModel(col1, 0);

	private JTable cust_info;
	private JScrollPane scrollpane1;

	private JButton bus_man, pro_man, od_man, mb_man, cust_man, Bregist, Bcancel, Bsearch, Breset;

	private JComboBox<String> cbSearch;

	GridBagLayout gridbaglayout;
	GridBagConstraints gridbagconstraints; // gridbag레이아웃에 컴포넌트의 위치를 잡아주는 역할

	public mb_look() {

		gridbaglayout = new GridBagLayout();
		gridbagconstraints = new GridBagConstraints();

		mb_lookup = new JLabel("회원조회");
//		mb_lookup.setPreferredSize(new Dimension(200, 28));

		cbSearch = new JComboBox<String>(search);
		cbSearch.setPreferredSize(new Dimension(100, 30));
		cbSearch.setBackground(Color.WHITE);
		
		Tsearch = new JTextField(22);
		Tsearch.setPreferredSize(new Dimension(150, 30));

		cust_info = new JTable(model1);
		cust_info.getColumnModel().getColumn(0).setPreferredWidth(60);
		cust_info.getColumnModel().getColumn(1).setPreferredWidth(60);
		cust_info.getColumnModel().getColumn(2).setPreferredWidth(100);
		cust_info.getColumnModel().getColumn(3).setPreferredWidth(400);
		cust_info.getColumnModel().getColumn(4).setPreferredWidth(60);
		cust_info.getColumnModel().getColumn(5).setPreferredWidth(80);
		cust_info.addMouseListener(this);
		scrollpane1 = new JScrollPane(cust_info);
		scrollpane1.setPreferredSize(new Dimension(900, 300));
		
		Bsearch = new JButton("검색");
		Bsearch.addActionListener(this);
		Bsearch.setPreferredSize(new Dimension(80, 30));


		getData(CustData.selectCust());
		custRegisterView();
	}

	private void getData(List<Map<String, Serializable>> custListData) {

		for (int i = 0; i < custListData.size(); i++) {
			model1.addRow(new Object[] { 
					custListData.get(i).get("ID"), 
					custListData.get(i).get("CUST_NM"),
					custListData.get(i).get("PH_NUM"), 
					custListData.get(i).get("ADDR"),
					custListData.get(i).get("GRA_TP"), 
					custListData.get(i).get("POSS_PNT") });
		}
	}

	private void custRegisterView() {

//         setTitle("회원조회");
		setLayout(gridbaglayout);

		gridbagconstraints.anchor = GridBagConstraints.WEST;
		gridbagAdd(mb_lookup, 1, 1, 1, 1);
//         gridbagconstraints.ipadx = 7;
//         
//         gridbagconstraints.weightx=1.0;
//         gridbagconstraints.weighty=1.0;
		gridbagAdd(cbSearch, 1, 2, 1, 1);
		gridbagAdd(scrollpane1, 1, 3, 5, 5);
		gridbagAdd(Tsearch, 2, 2, 1, 1);
		gridbagAdd(Bsearch, 3, 2, 1, 1);

		gridbagconstraints.anchor = GridBagConstraints.CENTER;

		gridbagconstraints.anchor = GridBagConstraints.EAST;


//         setResizable(true);
		setVisible(true);
	}

	private void gridbagAdd(Component c, int x, int y, int w, int h) {

		gridbagconstraints.gridx = x;
		gridbagconstraints.gridy = y;
		// 가장 왼쪽 위 gridx, gridy값은 0

		gridbagconstraints.gridwidth = w;
		gridbagconstraints.gridheight = h;

		gridbaglayout.setConstraints(c, gridbagconstraints); // 컴포넌트를 컴포넌트 위치+크기 정보에 따라 GridBagLayout에 배치

		add(c);

	}

//	public void paintComponent(Graphics g) {
//		g.drawImage(manager_main.img, 0, 0, null);
//		setOpaque(false);// 그림을 표시하게 설정,투명하게 조절
//		super.paintComponent(g);
//	}

	public static void main(String[] args) {
		new mb_look();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == Bsearch) {
			String search = Tsearch.getText();
			if (cbSearch.getSelectedItem() == "아이디") {
				model1.setRowCount(0);
				getData(CustData.searchCust1(search));
			} else if (cbSearch.getSelectedItem() == "회원명") {
				model1.setRowCount(0);
				getData(CustData.searchCust2(search));
			} else if (cbSearch.getSelectedItem() == "회원등급") {
				model1.setRowCount(0);
				getData(CustData.searchCust3(search));
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row;
		if(e.getSource() == cust_info) {
			row = cust_info.getSelectedRow();
			String cust_id = "";
			cust_id += cust_info.getValueAt(row, 0);
			
			new Cust_view_admin(new JFrame());
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