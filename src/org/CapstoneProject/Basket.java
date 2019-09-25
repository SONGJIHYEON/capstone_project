package org.CapstoneProject;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.AbstractCellEditor;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

public class Basket extends JFrame {

	private JLabel vProPrice, vDiscout, vPrice;
	private JTextField xProPrice, xDiscout, xPrice;

	private String[] col1 = { "이미지", "상품정보", "수량", "단가", "금액", "포인트", "삭제" };
//	private String[] col2 = {"부서명", "성명"};      
	private String[] div = { "관리자", "유저" }; // 사원구분 콤보박스의 목록

	private DefaultTableModel model1 = new DefaultTableModel(col1, 0);
//	private DefaultTableModel model2 = new DefaultTableModel(col2, 0);      

	private JTable tProInfo;
	private JScrollPane scrollpane1;

	private JButton BtOrder, BtShopping, BtDelBasket, del;
//	private JComboBox<String> cbSel;      

	int check;
	static double sum2;
	static String pro_price;
	static ArrayList<String> ar = new ArrayList<String>();
	static Double sum[];


	GridBagLayout gridbaglayout;
	GridBagConstraints gridbagconstraints; // gridbag레이아웃에 컴포넌트의 위치를 잡아주는 역할

	private void getData(List<Map<String, Serializable>> BasketListData) {
		for (int i = 0; i < BasketListData.size(); i++) {
			model1.addRow(new Object[] { 
					BasketListData.get(i).get("MODEL_IMG1"),
//					BasketListData.get(i).get("MODEL_NICK"),					
					BasketListData.get(i).get("PRO_NM"), 
					BasketListData.get(i).get("QUANT"),
					BasketListData.get(i).get("UP"),
					BasketListData.get(i).get("PR"),
					BasketListData.get(i).get("POINT"), });
		}
		for (int i = 0; i < tProInfo.getRowCount(); i++) {
			ar.add(tProInfo.getValueAt(i, 4).toString());
		}
		for (int i = 0; i < ar.size(); i++) {
			Double sum[] = new Double[ar.size()];
			sum[i] = Double.valueOf(ar.get(i));
			sum2 = sum2 + sum[i];
		}
		pro_price = String.valueOf(sum2);
		xProPrice.setText(pro_price);
	}

	public Basket() {
		

		gridbaglayout = new GridBagLayout();
		gridbagconstraints = new GridBagConstraints();

		vProPrice = new JLabel("총 상품가격");
		vDiscout = new JLabel("등급 할인");
		vPrice = new JLabel("최종 금액");

		xProPrice = new JTextField(10);
		xDiscout = new JTextField(10);
		xPrice = new JTextField(10);

		tProInfo = new JTable(model1);
		scrollpane1 = new JScrollPane(tProInfo);
		scrollpane1.setPreferredSize(new Dimension(750, 100));

		BtOrder = new JButton("주문하기");
//        BtOrder.setPreferredSize(new Dimension(130,28));
		BtShopping = new JButton("쇼핑 계속하기");
		BtShopping.setPreferredSize(new Dimension(130, 28));
		BtDelBasket = new JButton("장바구니 비우기");
		BtDelBasket.setPreferredSize(new Dimension(130, 28));
//        regist.addActionListener(this);

		tProInfo.getColumnModel().getColumn(6).setCellRenderer(new TableCell2());
		tProInfo.getColumnModel().getColumn(6).setCellEditor(new TableCell2());

		getData(BasketData.selectBasket());
		BasketView();
	}

	private void BasketView() {

		setTitle("장바구니");

//        gridbagconstraints.ipadx = 7;
//        
//        gridbagconstraints.weightx=1.0;
//        gridbagconstraints.weighty=1.0;

		setLayout(gridbaglayout);

		gridbagconstraints.anchor = GridBagConstraints.CENTER;
		gridbagAdd(scrollpane1, 0, 0, 12, 1);
		gridbagAdd(vProPrice, 0, 12, 1, 1);
		gridbagAdd(vDiscout, 2, 12, 1, 1);
		gridbagAdd(vPrice, 4, 12, 1, 1);
		gridbagAdd(xProPrice, 1, 12, 1, 1);
		gridbagAdd(xDiscout, 3, 12, 1, 1);
		gridbagAdd(xPrice, 5, 12, 1, 1);
		gridbagconstraints.anchor = GridBagConstraints.EAST;
		gridbagAdd(BtDelBasket, 11, 12, 1, 1);
		gridbagAdd(BtShopping, 11, 13, 1, 1);
		gridbagconstraints.anchor = GridBagConstraints.WEST;
		gridbagAdd(BtOrder, 10, 13, 1, 1);

		setExtendedState(MAXIMIZED_BOTH);
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

		new Basket();
	}

	class TableCell2 extends AbstractCellEditor implements TableCellEditor, TableCellRenderer {

		JButton del;

		public TableCell2() {
			// TODO Auto-generated constructor stub
			del = new JButton("X");
			del.setHorizontalAlignment(JLabel.CENTER);

			del.addActionListener(e -> {
				String pro_nm = (String) tProInfo.getValueAt(tProInfo.getSelectedRow(), 1);
				System.out.println(pro_nm);
				check = JOptionPane.showConfirmDialog(null, "해당 상품을 장바구니에서 삭제하시겠습니까?", "삭제 확인",
						JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);

				for (int i = 0; i < tProInfo.getRowCount(); i++) {
					if (check == 0 && pro_nm.equals(tProInfo.getValueAt(i, 1))) {
						model1.removeRow(i);
						BasketData.deleteBasket(pro_nm);
					}
				}
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

			return del;
		}

		@Override
		public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
				int column) {
			// TODO Auto-generated method stub
			return del;
		}

	}

//	DefaultTableCellRenderer dcr = new DefaultTableCellRenderer() {
//		public Component getTableCellRendererComponent // 셀렌더러
//		(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
//			JCheckBox check = new JCheckBox();
//			check.setSelected(((Boolean) value).booleanValue());
//			check.setHorizontalAlignment(JLabel.CENTER);
//			return check;
//		}
//	};

}
