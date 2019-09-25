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

	private String[] col1 = { "�̹���", "��ǰ����", "����", "�ܰ�", "�ݾ�", "����Ʈ", "����" };
//	private String[] col2 = {"�μ���", "����"};      
	private String[] div = { "������", "����" }; // ������� �޺��ڽ��� ���

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
	GridBagConstraints gridbagconstraints; // gridbag���̾ƿ��� ������Ʈ�� ��ġ�� ����ִ� ����

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

		vProPrice = new JLabel("�� ��ǰ����");
		vDiscout = new JLabel("��� ����");
		vPrice = new JLabel("���� �ݾ�");

		xProPrice = new JTextField(10);
		xDiscout = new JTextField(10);
		xPrice = new JTextField(10);

		tProInfo = new JTable(model1);
		scrollpane1 = new JScrollPane(tProInfo);
		scrollpane1.setPreferredSize(new Dimension(750, 100));

		BtOrder = new JButton("�ֹ��ϱ�");
//        BtOrder.setPreferredSize(new Dimension(130,28));
		BtShopping = new JButton("���� ����ϱ�");
		BtShopping.setPreferredSize(new Dimension(130, 28));
		BtDelBasket = new JButton("��ٱ��� ����");
		BtDelBasket.setPreferredSize(new Dimension(130, 28));
//        regist.addActionListener(this);

		tProInfo.getColumnModel().getColumn(6).setCellRenderer(new TableCell2());
		tProInfo.getColumnModel().getColumn(6).setCellEditor(new TableCell2());

		getData(BasketData.selectBasket());
		BasketView();
	}

	private void BasketView() {

		setTitle("��ٱ���");

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
		// ���� ���� �� gridx, gridy���� 0

		gridbagconstraints.gridwidth = w;
		gridbagconstraints.gridheight = h;

		gridbaglayout.setConstraints(c, gridbagconstraints); // ������Ʈ�� ������Ʈ ��ġ+ũ�� ������ ���� GridBagLayout�� ��ġ

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
				check = JOptionPane.showConfirmDialog(null, "�ش� ��ǰ�� ��ٱ��Ͽ��� �����Ͻðڽ��ϱ�?", "���� Ȯ��",
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
//		public Component getTableCellRendererComponent // ��������
//		(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
//			JCheckBox check = new JCheckBox();
//			check.setSelected(((Boolean) value).booleanValue());
//			check.setHorizontalAlignment(JLabel.CENTER);
//			return check;
//		}
//	};

}
