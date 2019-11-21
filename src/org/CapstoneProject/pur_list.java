package org.CapstoneProject;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.EventObject;
import java.util.List;
import java.util.Map;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.event.CellEditorListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

public class pur_list extends JPanel implements ActionListener, MouseListener {

	private static String[] col1 = { "구매번호", "구매일자", "총금액", "상세내역조회" };

	private static DefaultTableModel model1 = new DefaultTableModel(col1, 0);

	private JTable pur_info;
	private JScrollPane scrollpane1;

	private JButton jb;

	static String pur_num;
	
	static ArrayList<String> ar = new ArrayList<String>();
	int row = 0;

	GridBagLayout gridbaglayout;
	GridBagConstraints gridbagconstraints; // gridbag레이아웃에 컴포넌트의 위치를 잡아주는 역할
	
	static void getData(List<Map<String, Serializable>> purListData) {

		model1.setRowCount(0);

		for (int i = 0; i < purListData.size(); i++) {
			
			ar.add(purListData.get(i).get("PUR_DT").toString());
			
//			String oldstring = ex_st_date;
			
			Date date = null;
			try {
				date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").parse(ar.get(i));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				
				e.printStackTrace();
			}
			String new_pur_date = new SimpleDateFormat("yyyy-MM-dd").format(date);
			
			model1.addRow(new Object[] {
					purListData.get(i).get("PUR_NUM"), 
					new_pur_date,
					purListData.get(i).get("TOT_PR")
			});
		}
	}

	public pur_list() {
		gridbaglayout = new GridBagLayout();
		gridbagconstraints = new GridBagConstraints();

		pur_info = new JTable(model1);
		scrollpane1 = new JScrollPane(pur_info);
		scrollpane1.setPreferredSize(new Dimension(450, 300));
		pur_info.getColumnModel().getColumn(0).setPreferredWidth(100);
		pur_info.getColumnModel().getColumn(1).setPreferredWidth(100);
		pur_info.getColumnModel().getColumn(2).setPreferredWidth(100);
		pur_info.getColumnModel().getColumn(3).setPreferredWidth(150);
		
		DefaultTableCellRenderer tScheduleCellRenderer = new DefaultTableCellRenderer();
		tScheduleCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel tcmSchedule = pur_info.getColumnModel();
		
		for (int i = 0; i < tcmSchedule.getColumnCount(); i++) {
			tcmSchedule.getColumn(i).setCellRenderer(tScheduleCellRenderer);
		}
		
		pur_info.getColumnModel().getColumn(3).setCellRenderer(new TableCell());
		pur_info.getColumnModel().getColumn(3).setCellEditor(new TableCell());
		
		pur_info.setRowHeight(25);
		
		JTableHeader th = pur_info.getTableHeader();		
		th.setPreferredSize(new Dimension(700, 30));
		th.setFont(new Font("맑은 고딕", Font.PLAIN, 17));


		EmpRegisterView();
	}

	private void EmpRegisterView() {

		gridbagconstraints.anchor = GridBagConstraints.WEST;
//         gridbagconstraints.ipadx = 7;
//         
//         gridbagconstraints.weightx=1.0;
//         gridbagconstraints.weighty=1.0;

		setLayout(gridbaglayout);
		gridbagconstraints.anchor = GridBagConstraints.CENTER;

		gridbagAdd(scrollpane1, 0, 0, 1, 1);
		gridbagconstraints.anchor = GridBagConstraints.WEST;
		gridbagconstraints.anchor = GridBagConstraints.EAST;

		System.out.println(corr_look.corr_num+"a");

		getData(purData.selectpur(corr_look.corr_num));

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
		new pur_list();
	}

	class TableCell extends AbstractCellEditor implements TableCellEditor, TableCellRenderer {

		public TableCell() {
			// TODO Auto-generated constructor stub
			jb = new JButton("상세내역조회");
			jb.setBackground(Color.WHITE);
//			jb.setFocusPainted(false);
			
			jb.addActionListener(e -> {
				int row = 0;
				row = pur_info.getSelectedRow();
				pur_num = "";
				pur_num += (String) pur_info.getValueAt(row, 0);
				pur_brkdwn_list s = new pur_brkdwn_list();
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
			// TODO Auto-generated method stub
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
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == pur_info) {
//			row = pur_info.getSelectedRow();
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