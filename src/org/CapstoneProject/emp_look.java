package org.CapstoneProject;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

public class emp_look extends JPanel implements ActionListener {

	private JLabel emp_lookup, Lemp_no, Lemp_nm, Lemp_dt, Lemp_ph_num, Lemp_tp, Lemp_addr;

	private JTextField Tsearch;

	private String[] col1 = { "사원번호", "사원명", "휴대폰번호", "입사일", "사원구분", "담당업무" };
	private String[] search = { "사원명", "휴대폰번호" };

	private DefaultTableModel model1 = new DefaultTableModel(col1, 0);
	private JTable emp_info;
	private JScrollPane scrollpane1;
	private JButton jb, Bsearch, Breset;
	private JComboBox<String> cbSearch;

	ArrayList<String> ar = new ArrayList<String>();

	GridBagLayout gridbaglayout;
	GridBagConstraints gridbagconstraints; // gridbag레이아웃에 컴포넌트의 위치를 잡아주는 역할

	public emp_look() {

		gridbaglayout = new GridBagLayout();
		gridbagconstraints = new GridBagConstraints();

		emp_lookup = new JLabel("사원조회");
		emp_lookup.setFont(new Font("맑은 고딕", Font.BOLD, 20));

		Tsearch = new JTextField(15);
		Tsearch.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		Tsearch.setPreferredSize(new Dimension(150, 40));

		cbSearch = new JComboBox<String>(search);
		cbSearch.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		cbSearch.setPreferredSize(new Dimension(150, 40));
		cbSearch.setBackground(Color.WHITE);

		emp_info = new JTable(model1);
		scrollpane1 = new JScrollPane(emp_info);
		scrollpane1.setPreferredSize(new Dimension(900, 300));

		DefaultTableCellRenderer tScheduleCellRenderer = new DefaultTableCellRenderer();

		tScheduleCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel tcmSchedule = emp_info.getColumnModel();
		for (int i = 0; i < tcmSchedule.getColumnCount(); i++) {
			tcmSchedule.getColumn(i).setCellRenderer(tScheduleCellRenderer);
		}

		emp_info.setRowHeight(25);

		JTableHeader th = emp_info.getTableHeader();
		th.setPreferredSize(new Dimension(900, 30));
		th.setFont(new Font("맑은 고딕", Font.PLAIN, 17));

		Bsearch = new JButton("검색");
		Bsearch.setFocusPainted(false);
		Bsearch.setBackground(Color.white);
		Bsearch.setPreferredSize(new Dimension(80, 40));
		Bsearch.setFont(new Font("휴먼매직체", Font.BOLD, 22));

		getData(empData.selectEmp());
		EmpRegisterView();
	}

	private void getData(List<Map<String, Serializable>> empListData) {

		for (int i = 0; i < empListData.size(); i++) {
			ar.add(empListData.get(i).get("APPC_DT").toString());

//			String oldstring = ex_st_date;

			Date date = null;
			try {
				date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").parse(ar.get(i));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String new_appc_date = new SimpleDateFormat("yyyy-MM-dd").format(date);

			model1.addRow(new Object[] { 
					empListData.get(i).get("EMP_NUM"), 
					empListData.get(i).get("EMP_NM"),
					empListData.get(i).get("PH_NUM"), 
					new_appc_date, 
					empListData.get(i).get("EMP_TP"),
					empListData.get(i).get("REG_WRKR_TP") });
		}
	}

	private void EmpRegisterView() {

//         setTitle("사원조회");

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
		gridbagAdd(emp_lookup, 1, 1, 1, 1);
		gridbagAdd(Bsearch, 3, 2, 1, 1);

		gridbagconstraints.anchor = GridBagConstraints.EAST;
//		gridbagAdd(Breset, 4, 2, 1, 1);

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

	public void paintComponent(Graphics g) {
		g.drawImage(manager_main.img, 0, 0, null);
		setOpaque(false);// 그림을 표시하게 설정,투명하게 조절
		super.paintComponent(g);
	}

	public static void main(String[] args) {
		new emp_look();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == Bsearch) {
			String search = Tsearch.getText();
			if (cbSearch.getSelectedItem() == "사원명") {
				model1.setRowCount(0);
				getData(empData.searchEmp1(search));
			} else if (cbSearch.getSelectedItem() == "휴대폰번호") {
				model1.setRowCount(0);
				getData(empData.searchEmp2(search));
			}
		}

	}

}