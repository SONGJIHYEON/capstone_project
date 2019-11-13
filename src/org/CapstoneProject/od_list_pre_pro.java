
package org.CapstoneProject;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

public class Od_list_pre_pro extends JPanel implements ActionListener, MouseListener {

	private JLabel no_deposit;
	private JTextField Tsearch;

	private String[] col1 = {"주문자명", "주문번호 ", "주문금액", "수령인명", "수령인주소", "수령인번호", "주문상태구분", "상세구매내역", "배송등록" };
	private String[] search = { "주문번호", "주문자명", "주문일시" };

	private DefaultTableModel model1 = new DefaultTableModel(col1, 0);

	private JTable od_info;
	private JScrollPane scrollpane1;

	private JButton bus_man, pro_man, od_man, mb_man, emp_man, Bsearch, reset;
	private JComboBox<String> cbSearch;

	private ArrayList<String> ar = new ArrayList<String>();

	static String od_num;
	int row;

	GridBagLayout gridbaglayout;
	GridBagConstraints gridbagconstraints; // gridbag레이아웃에 컴포넌트의 위치를 잡아주는 역할

	private void getData(List<Map<String, Serializable>> OrderListData) {

		for (int i = 0; i < OrderListData.size(); i++) {
//			ar.add(OrderListData.get(i).get("OD_DATE").toString());

//			String oldstring = ex_st_date;

//			Date date = null;
//			try {
//				date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").parse(ar.get(i));
//			} catch (ParseException e) {
//				// TODO Auto-generated catch block
//
//				e.printStackTrace();
//			}
//			String new_od_date = new SimpleDateFormat("yyyy-MM-dd").format(date);

			model1.addRow(new Object[] {

					OrderListData.get(i).get("cust_nm"),
					OrderListData.get(i).get("od_num"), 
					OrderListData.get(i).get("OD_PR"), 
					OrderListData.get(i).get("RECPT"),
					OrderListData.get(i).get("RECPT_ADDR"),
					OrderListData.get(i).get("RECPT_TEL"),
					OrderListData.get(i).get("OD_COND_TP"), 
				});
		}
	}

	public Od_list_pre_pro() {

		gridbaglayout = new GridBagLayout();
		gridbagconstraints = new GridBagConstraints();

		no_deposit = new JLabel("주문관리(상품준비중)");
		no_deposit.setPreferredSize(new Dimension(200, 28));

		cbSearch = new JComboBox<String>(search);
		cbSearch.setPreferredSize(new Dimension(200, 28));

		Tsearch = new JTextField();
		Tsearch.setPreferredSize(new Dimension(200, 28));

		od_info = new JTable(model1);
		scrollpane1 = new JScrollPane(od_info);
		scrollpane1.setPreferredSize(new Dimension(1000, 300));
		od_info.getColumnModel().getColumn(7).setCellRenderer(new TableCell2());
		od_info.getColumnModel().getColumn(7).setCellEditor(new TableCell2());
		od_info.getColumnModel().getColumn(8).setCellRenderer(new TableCell());
		od_info.getColumnModel().getColumn(8).setCellEditor(new TableCell());

		Bsearch = new JButton("검색");
		Bsearch.setPreferredSize(new Dimension(100, 28));
		reset = new JButton("초기화");
		reset.setPreferredSize(new Dimension(100, 28));

//         getDeptData(EmpData.selectDept());
//         getSvpData(EmpData.selectSpv());
//         setExtendedState(MAXIMIZED_BOTH);
		getData(OrderData.searchOd_list_pre_pro());
		EmpRegisterView();
	}

	private void EmpRegisterView() {

//         setTitle("주문관리(통장미입금)");

		gridbagconstraints.anchor = GridBagConstraints.WEST;
//         gridbagconstraints.ipadx = 7;
//         
//         gridbagconstraints.weightx=1.0;
//         gridbagconstraints.weighty=1.0;

		setLayout(gridbaglayout);
		gridbagconstraints.anchor = GridBagConstraints.CENTER;

		gridbagconstraints.anchor = GridBagConstraints.WEST;
		gridbagAdd(no_deposit, 1, 1, 1, 1);
		gridbagAdd(cbSearch, 1, 2, 1, 1);
		gridbagAdd(Tsearch, 2, 2, 1, 1);
		gridbagAdd(Bsearch, 3, 2, 1, 1);
		gridbagconstraints.anchor = GridBagConstraints.EAST;
		gridbagAdd(reset, 3, 2, 1, 1);

		gridbagAdd(scrollpane1, 1, 3, 5, 5);

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
		new Od_list_pre_pro();
	}

	class TableCell2 extends AbstractCellEditor implements TableCellEditor, TableCellRenderer {

		JButton jb2;

		public TableCell2() {
			// TODO Auto-generated constructor stub
			jb2 = new JButton("상세내역조회");
			jb2.setBackground(Color.WHITE);
			jb2.setFocusPainted(false);
			jb2.addActionListener(e -> {
				int row = od_info.getSelectedRow();
				od_num = "";
				od_num += (String) od_info.getValueAt(row, 1);
				System.out.println(od_num);
				Od_brkdwn_no_deposit s = new Od_brkdwn_no_deposit(new JFrame());
			});
		}

		@Override
		public Object getCellEditorValue() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {

			return jb2;
		}

		@Override
		public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
				int column) {
			// TODO Auto-generated method stub
			return jb2;
		}

	}

	class TableCell extends AbstractCellEditor implements TableCellEditor, TableCellRenderer {

		JButton jb;

		public TableCell() {
			// TODO Auto-generated constructor stub
			jb = new JButton("배송등록");
			jb.setHorizontalAlignment(JLabel.CENTER);

			jb.addActionListener(e -> {
				new RegDeliv(new JFrame());
				
//				model1.removeRow(row);
//				String pro_nm = (String) tProInfo.getValueAt(tProInfo.getSelectedRow(), 1);
//
//				BasketData.deleteBasket(tProInfo.getValueAt(row, 1).toString());
//				getData(BasketData.selectBasket(cust_num));

			});
		}

		@Override
		public Object getCellEditorValue() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {

			return jb;
		}

		@Override
		public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
				int column) {
			// TODO Auto-generated method stub
			return jb;
		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == od_info) {
			row = od_info.getSelectedRow();
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
