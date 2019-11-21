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

public class evt_look extends JPanel implements ActionListener {

	private JLabel evt_lookup;

	private JTextField Tsearch;

	private String[] col1 = { "이벤트구분", "시작일자", "종료일자", "해당모델명", "할인율", "포인트" };
	private String[] search = { "이벤트구분", "이벤트대상 모델명" };

	private DefaultTableModel model1 = new DefaultTableModel(col1, 0);

	private JTable evt_info;
	private JScrollPane scrollpane1;

	private JButton Bsearch, Breset, jb;

	private JComboBox<String> cbSearch;

	ArrayList<String> ar = new ArrayList<String>();
	ArrayList<String> ar2 = new ArrayList<String>();

	String model_nm;

	GridBagLayout gridbaglayout;
	GridBagConstraints gridbagconstraints; // gridbag레이아웃에 컴포넌트의 위치를 잡아주는 역할

	public evt_look() {

		gridbaglayout = new GridBagLayout();
		gridbagconstraints = new GridBagConstraints();

		evt_lookup = new JLabel("이벤트 조회");
		evt_lookup.setFont(new Font("맑은 고딕", Font.BOLD, 20));

		cbSearch = new JComboBox<String>(search);
		cbSearch.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		cbSearch.setPreferredSize(new Dimension(150, 40));
		cbSearch.setBackground(Color.WHITE);

		Tsearch = new JTextField(15);
		Tsearch.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		Tsearch.setPreferredSize(new Dimension(150, 40));

		evt_info = new JTable(model1);
		scrollpane1 = new JScrollPane(evt_info);
		scrollpane1.setPreferredSize(new Dimension(700, 300));
		
		DefaultTableCellRenderer tScheduleCellRenderer = new DefaultTableCellRenderer();

		tScheduleCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel tcmSchedule = evt_info.getColumnModel();
		for (int i = 0; i < tcmSchedule.getColumnCount(); i++) {
			tcmSchedule.getColumn(i).setCellRenderer(tScheduleCellRenderer);
		}
		
		evt_info.setRowHeight(25);
		
		JTableHeader th = evt_info.getTableHeader();		
		th.setPreferredSize(new Dimension(700, 30));
		th.setFont(new Font("맑은 고딕", Font.PLAIN, 15));

		Bsearch = new JButton("검색");
		Bsearch.setFocusPainted(false);
		Bsearch.setBackground(Color.white);
		Bsearch.setPreferredSize(new Dimension(80, 40));
		Bsearch.setFont(new Font("휴먼매직체", Font.BOLD, 22));
//         Breset = new JButton("초기화");
//         Breset.setPreferredSize(new Dimension(200,28));

//         evt_info.getColumnModel().getColumns(4).setCellRenderer(new TableCell());
//         evt_info.getColumnModel().getColumn(4).setCellEditor(new TableCell());
		getData(evtData.selectEvt());
		evtRegisterView();
	}

	private void getData(List<Map<String, Serializable>> evtListData) {

		for (int i = 0; i < evtListData.size(); i++) {

			ar.add(evtListData.get(i).get("EVT_ST_DT").toString());
			ar2.add(evtListData.get(i).get("EVT_END_DT").toString());

//			String oldstring = ex_st_date;

			Date date = null;
			Date date2 = null;

			try {
				date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").parse(ar.get(i));
				date2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").parse(ar2.get(i));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String new_EVT_ST_DT = new SimpleDateFormat("yyyy-MM-dd").format(date);
			String new_EVT_END_DT = new SimpleDateFormat("yyyy-MM-dd").format(date2);

			model1.addRow(new Object[] {

					evtListData.get(i).get("EVT_TP"), new_EVT_ST_DT, new_EVT_END_DT, evtListData.get(i).get("model_nm"),
					evtListData.get(i).get("DISC_RT"), evtListData.get(i).get("ADD_PNT")

			});
		}

	}

	private void evtRegisterView() {

		gridbagconstraints.anchor = GridBagConstraints.WEST;

		setLayout(gridbaglayout);
		gridbagconstraints.anchor = GridBagConstraints.CENTER;

		gridbagAdd(scrollpane1, 1, 3, 5, 5);
		gridbagconstraints.anchor = GridBagConstraints.WEST;
		gridbagAdd(Tsearch, 2, 2, 1, 1);
		gridbagAdd(cbSearch, 1, 2, 1, 1);
		gridbagAdd(evt_lookup, 1, 1, 1, 1);
		gridbagAdd(Bsearch, 3, 2, 1, 1);

		gridbagconstraints.anchor = GridBagConstraints.EAST;
//         gridbagAdd(Breset, 4, 2, 1, 1);

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
		new evt_look();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == Bsearch) {
			String search = Tsearch.getText();
			if (cbSearch.getSelectedItem() == "이벤트구분") {
				model1.setRowCount(0);
				getData(evtData.selectEvt1(search));
			} else if (cbSearch.getSelectedItem() == "이벤트대상모델명") {
				model1.setRowCount(0);
				getData(evtData.selectEvt2(search));
			}
		}

	}

}