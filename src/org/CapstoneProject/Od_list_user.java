package org.CapstoneProject;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.awt.event.ActionEvent;

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

import org.CapstoneProject.Basket.TableCell2;
import org.w3c.dom.events.MouseEvent;

public class Od_list_user extends JPanel implements ActionListener {

	private JLabel vOd_list;

	private JTextField Tsearch, Temp_no, Temp_nm, Temp_resi_num, Temp_dt, Temp_ph_num, Temp_mail, Temp_addr;

	private String[] col1 = {"주문번호 ", "주문날짜 ","주문금액", "주문상태구분", "상세구매내역"};
	private String[] search = {"상품명", "주문날짜" };
	
	private DefaultTableModel model1 = new DefaultTableModel(col1, 0);

	private JTable od_info;
	private JScrollPane scrollpane1;
	private JButton Bsearch, BtCancel, BtConfirm;
	private JComboBox<String> cbSearch;

	private ArrayList<String> ar = new ArrayList<String>();
	
	String cust_num;
	static String od_num;
	
	int close;
	

	GridBagLayout gridbaglayout;
	GridBagConstraints gridbagconstraints; // gridbag레이아웃에 컴포넌트의 위치를 잡아주는 역할.

	public Od_list_user() {
//		super(fr, "", true);
		cust_num = Login.user_num;
		
		gridbaglayout = new GridBagLayout();
		gridbagconstraints = new GridBagConstraints();
		
		vOd_list = new JLabel("주문내역");
		vOd_list.setFont(new Font("휴먼매직체", Font.BOLD, 20));

		Tsearch = new JTextField(15);
		Tsearch.addActionListener(this);
		Tsearch.setPreferredSize(new Dimension(100, 30));
		
		cbSearch = new JComboBox<String>(search);
		cbSearch.setPreferredSize(new Dimension(80, 30));

		od_info = new JTable(model1);
		scrollpane1 = new JScrollPane(od_info);
		scrollpane1.setPreferredSize(new Dimension(600, 150));
		od_info.getColumnModel().getColumn(4).setCellRenderer(new TableCell2());
		od_info.getColumnModel().getColumn(4).setCellEditor(new TableCell2());

		Bsearch = new JButton("검색");
		Bsearch.addActionListener(this);
		Bsearch.setPreferredSize(new Dimension(80, 30));

//		BtCancel = new JButton("닫기");
//		BtCancel.addActionListener(this);
//		BtConfirm = new JButton("확인");
//		BtConfirm.addActionListener(this);

		getData(OrderData.searchOd_list(cust_num));
//         getSvpData(EmpData.selectSpv());

		addressView();
	}

	private void getData(List<Map<String, Serializable>> OrderListData) {
		
		for (int i = 0; i < OrderListData.size(); i++) {
			ar.add(OrderListData.get(i).get("OD_DATE").toString());
			
//			String oldstring = ex_st_date;
			
			Date date = null;
			try {
				date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").parse(ar.get(i));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				
				e.printStackTrace();
			}
			String new_od_date = new SimpleDateFormat("yyyy-MM-dd").format(date);
			
			model1.addRow(new Object[] {
					
					OrderListData.get(i).get("OD_NUM"),
					new_od_date, 
					OrderListData.get(i).get("OD_PR"),
					OrderListData.get(i).get("OD_COND_TP"),
			});
		}
	}

	private void addressView() {
//		setTitle("주소검색");

		gridbagconstraints.anchor = GridBagConstraints.WEST;
		gridbagAdd(vOd_list, 0, 0, 1, 1);
		
//         gridbagconstraints.ipadx = 7;        
//         gridbagconstraints.weightx=1.0;
//         gridbagconstraints.weighty=1.0;

		setLayout(gridbaglayout);
		gridbagconstraints.anchor = GridBagConstraints.CENTER;
		
		gridbagAdd(cbSearch, 0, 1, 1, 1);
		gridbagAdd(Tsearch, 1, 1, 1, 1);
		gridbagAdd(scrollpane1, 0, 2, 3, 3);

		gridbagconstraints.anchor = GridBagConstraints.WEST;

		gridbagAdd(Bsearch, 2, 1, 1, 1);

		gridbagconstraints.anchor = GridBagConstraints.EAST;

//		pack();
//         setResizable(false);
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
		new Od_list_user();

	}
	
	class TableCell2 extends AbstractCellEditor implements TableCellEditor, TableCellRenderer {

		JButton jb;

		public TableCell2() {
			// TODO Auto-generated constructor stub
			jb = new JButton("상세내역조회");
			jb.setBackground(Color.WHITE);
			jb.setFocusPainted(false);
			jb.addActionListener(e -> {
				int row = od_info.getSelectedRow();
				od_num = "";
				od_num += (String) od_info.getValueAt(row, 0);
//				System.out.println(pur_num);
				Od_brkdwn_user s = new Od_brkdwn_user(new JFrame());
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
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == Bsearch) {
			String search = Tsearch.getText();
			if (cbSearch.getSelectedItem() == "상품명") {
//				model1.setRowCount(0);
//				getData(empData.searchEmp1(search));
			}
//				else if (cbSearch.getSelectedItem() == "휴대폰번호") {
//				model1.setRowCount(0);
//				getData(empData.searchEmp2(search));
//			}
		}if(e.getSource() == BtCancel) {
//			dispose();
		}

	}
}