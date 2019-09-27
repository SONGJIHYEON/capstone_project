package org.CapstoneProject;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class mb_look extends JPanel implements ActionListener {

	private JLabel mb_lookup, mb_lookup2, mb_gra;

	private JTextField Tsearch;
	private String[] col1 = { "아이디", "회원명", "휴대폰번호", "주소", "회원등급", "보유포인트" };
	private String[] search = { "아이디", "회원명", "회원등급" };

	private DefaultTableModel model1 = new DefaultTableModel(col1, 0);

	private JTable emp_info;
	private JScrollPane scrollpane1;

	private JButton bus_man, pro_man, od_man, mb_man, emp_man, Bregist, Bcancel, Bsearch, Breset;

	private JComboBox<String> cbSearch;

	GridBagLayout gridbaglayout;
	GridBagConstraints gridbagconstraints; // gridbag레이아웃에 컴포넌트의 위치를 잡아주는 역할

	public mb_look() {

		gridbaglayout = new GridBagLayout();
		gridbagconstraints = new GridBagConstraints();

		mb_lookup = new JLabel("회원조회");
		mb_lookup.setPreferredSize(new Dimension(200, 28));
		mb_lookup2 = new JLabel("회원조회");
		mb_lookup2.setPreferredSize(new Dimension(200, 28));
		mb_gra = new JLabel("회원등급설정");
		mb_lookup2.setPreferredSize(new Dimension(200, 28));

		Tsearch = new JTextField(18);
		Tsearch.setPreferredSize(new Dimension(100, 30));

		cbSearch = new JComboBox<String>(search);
		cbSearch.setPreferredSize(new Dimension(200, 28));

		emp_info = new JTable(model1);
		emp_info.getColumnModel().getColumn(0).setPreferredWidth(20);
		emp_info.getColumnModel().getColumn(1).setPreferredWidth(20);
		emp_info.getColumnModel().getColumn(2).setPreferredWidth(50);
		emp_info.getColumnModel().getColumn(3).setPreferredWidth(300);
		emp_info.getColumnModel().getColumn(4).setPreferredWidth(10);
		emp_info.getColumnModel().getColumn(5).setPreferredWidth(10);
		scrollpane1 = new JScrollPane(emp_info);
		scrollpane1.setPreferredSize(new Dimension(1000, 300));

		bus_man = new JButton("거래관리");
		bus_man.setPreferredSize(new Dimension(200, 28));
//         regist.addActionListener(this);
		pro_man = new JButton("상품관리");
		pro_man.setPreferredSize(new Dimension(200, 28));
//         cancel.addActionListener(this);
		od_man = new JButton("주문관리");
		od_man.setPreferredSize(new Dimension(200, 28));
		mb_man = new JButton("회원관리");
		mb_man.setPreferredSize(new Dimension(200, 28));
		emp_man = new JButton("사원관리");
		emp_man.setPreferredSize(new Dimension(200, 28));
		Bsearch = new JButton("검색");
		Bsearch.addActionListener(this);
		Bsearch.setPreferredSize(new Dimension(200, 28));
		Breset = new JButton("초기화");
		Breset.setPreferredSize(new Dimension(200, 28));

		getData(CustData.selectCust());
		EmpRegisterView();
	}

	private void getData(List<Map<String, Serializable>> custListData) {

		for (int i = 0; i < custListData.size(); i++) {
			model1.addRow(new Object[] {
					custListData.get(i).get("ID"), 
					custListData.get(i).get("CUST_NM"),					
					custListData.get(i).get("PH_NUM"),
					custListData.get(i).get("ADDR"),
					custListData.get(i).get("MB_GRA"),
					custListData.get(i).get("POSS_PNT") });
		}
	}

	private void EmpRegisterView() {

//         setTitle("회원조회");

		gridbagconstraints.anchor = GridBagConstraints.WEST;
//         gridbagconstraints.ipadx = 7;
//         
//         gridbagconstraints.weightx=1.0;
//         gridbagconstraints.weighty=1.0;

		setLayout(gridbaglayout);
		gridbagconstraints.anchor = GridBagConstraints.CENTER;

		gridbagAdd(scrollpane1, 1, 3, 5, 5);

		gridbagconstraints.anchor = GridBagConstraints.WEST;

		gridbagAdd(Tsearch, 2, 2, 1, 1);
		gridbagAdd(cbSearch, 1, 2, 1, 1);
		gridbagAdd(mb_lookup2, 1, 1, 1, 1);
		gridbagAdd(Bsearch, 3, 2, 1, 1);

		gridbagconstraints.anchor = GridBagConstraints.EAST;

		gridbagAdd(Breset, 4, 2, 1, 1);

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
			} else if(cbSearch.getSelectedItem() == "회원등급") {
				model1.setRowCount(0);
				getData(CustData.searchCust3(search));
			}
		}
	}

}