package org.CapstoneProject;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
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

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

public class corr_look extends JPanel implements ActionListener, MouseListener {

	public static String corr_num, corr_nm;
	private JLabel corr_lookup2, pur_regist, Lcorr_no, Lcorr_nm, Lcorr_prnm, Lcorr_ph, Lcorr_addr;
	private JTextField Tsearch;

	private String[] col1 = { "거래처번호", "거래처명", "대표명", "연락처", "주소", "구매조회" };
	private String[] search = { "거래처번호", "거래처명", "대표명" };

	private DefaultTableModel model1 = new DefaultTableModel(col1, 0);
	List<Map<String, Serializable>> corrListData;
	private int nowPage;
	private int nowPanel;
	private int postPerPage = 5;
	private int pagePerPanel = 3;
	private int panelNum;
	private int pageNum;
	private JButton[] bPage;
	private JPanel[] pPage;

	private JTable corr_info;
	private JScrollPane scrollpane1;

	private JButton Bsearch, jb, pre, next;

	private JComboBox<String> cbSearch;

	GridBagLayout gridbaglayout;
	GridBagConstraints gridbagconstraints; // gridbag레이아웃에 컴포넌트의 위치를 잡아주는 역할

	public corr_look() {

		gridbaglayout = new GridBagLayout();
		gridbagconstraints = new GridBagConstraints();

		pre = new JButton("<");
		pre.setContentAreaFilled(false);
		pre.setBorderPainted(false);
		pre.addMouseListener(this);
		next = new JButton(">");
		next.setContentAreaFilled(false);
		next.setBorderPainted(false);
		next.addMouseListener(this);

		corr_lookup2 = new JLabel("거래처조회");
		corr_lookup2.setFont(new Font("휴먼매직체", Font.BOLD, 40));
		corr_lookup2.setPreferredSize(new Dimension(200, 50));

		Tsearch = new JTextField(22);
		Tsearch.setOpaque(false);
		Tsearch.setPreferredSize(new Dimension(150, 40));

		cbSearch = new JComboBox<String>(search);
		cbSearch.setFont(new Font("휴먼매직체", Font.PLAIN, 22));
		cbSearch.setPreferredSize(new Dimension(200, 40));
		cbSearch.setBackground(Color.WHITE);

		corr_info = new JTable(model1);
		corr_info.addMouseListener(this);
		corr_info.setOpaque(false);
		scrollpane1 = new JScrollPane(corr_info);
		scrollpane1.setPreferredSize(new Dimension(1000, 300));

		Bsearch = new JButton("검색");
		Bsearch.setFont(new Font("휴먼매직체", Font.PLAIN, 20));
		Bsearch.setPreferredSize(new Dimension(100, 40));
		Bsearch.setBackground(Color.WHITE);
		Bsearch.addActionListener(this);

		corr_info.getColumnModel().getColumn(5).setCellRenderer(new TableCell());
		corr_info.getColumnModel().getColumn(5).setCellEditor(new TableCell());

		corrListData = corrData.selectcorr(); // 공지사항글 정보 받아오기
		createPanel();// 버튼을 올려놓을 패널 생성, nowPage와 nowPanel값 초기화
		getData();// 테이블에 데이터 불러오기
		EmpRegisterView();
	}

	void getData() {
		for (int i = nowPage * postPerPage; i < nowPage * postPerPage + postPerPage; i++) {
			if (i > corrListData.size() - 1) {
				break;
			}
			model1.addRow(new Object[] { 
					corrListData.get(i).get("BUS_NUM"),
					corrListData.get(i).get("BUS_NM"),
					corrListData.get(i).get("REP_NM"), 
					corrListData.get(i).get("BUS_TEL"),
					corrListData.get(i).get("ADDR") });
		}
	}

	private void EmpRegisterView() {

//         setTitle("거래처조회");

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
		gridbagAdd(corr_lookup2, 1, 1, 1, 1);
		gridbagAdd(Bsearch, 3, 2, 1, 1);

		gridbagconstraints.anchor = GridBagConstraints.EAST;
		gridbagAdd(pre, 2, 8, 1, 1);
		gridbagconstraints.anchor = GridBagConstraints.CENTER;
		gridbagAdd(pPage[0], 3, 8, 1, 1);
		gridbagconstraints.anchor = GridBagConstraints.WEST;
		gridbagAdd(next, 4, 8, 1, 1);

//         setResizable(true);
		setOpaque(false);
		setVisible(true);
	}

	private void createPanel() {
		if (corrListData.size() != 0 && (corrListData.size() % postPerPage) == 0) { // 페이지 수 구하기
			pageNum = corrListData.size() / postPerPage;
		} else {
			pageNum = corrListData.size() / postPerPage + 1;
		}

		bPage = new JButton[pageNum];// 페이지수만큼의 원소를 지닌 버튼배열 선언

		if ((pageNum % pagePerPanel) == 0) { // 패널 수 구하기
			panelNum = pageNum / pagePerPanel;
		} else {
			panelNum = pageNum / pagePerPanel + 1;
		}

		System.out.println(panelNum);
		pPage = new JPanel[panelNum]; // 구한 panelNum만큼의 원소를 지닌 패널배열 선언(버튼을 올려놓을 곳)

		int indexButton = 0;

		for (int i = 0; i < panelNum; i++) {
			pPage[i] = new JPanel(new FlowLayout(FlowLayout.LEFT)); // 패널생성
			for (int j = 0; j < pagePerPanel; j++) {
				if (indexButton >= pageNum) {
					break;
				}
				bPage[indexButton] = new JButton("" + (indexButton + 1)); // 버튼생성
				bPage[indexButton].setContentAreaFilled(false);
				bPage[indexButton].setBorderPainted(false);
				bPage[indexButton].addMouseListener(this);

				pPage[i].add(bPage[indexButton]); // 패널위에 버튼올리기
				indexButton++;
			}
		}
		nowPage = 0; // 현재페이지와 패널 초기화
		nowPanel = 0;
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
		new corr_look();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		for (int i = 0; i < pageNum; i++) {
			if (e.getSource() == bPage[i]) {
				nowPage = i;
				model1.setRowCount(0);
				getData();
			}
		}

		if (e.getSource() == pre) {
			if (nowPanel > 0) {
				remove(pPage[nowPanel]);
				nowPanel--;
				System.out.println("nowPanel = " + nowPanel);
				gridbagconstraints.anchor = GridBagConstraints.CENTER;
				gridbagAdd(pPage[nowPanel], 3, 8, 1, 1);
				revalidate();
			}
		} else if (e.getSource() == next) {
			if (nowPanel < panelNum - 1) {
				remove(pPage[nowPanel]);
				nowPanel++;
				gridbagconstraints.anchor = GridBagConstraints.CENTER;
				gridbagAdd(pPage[nowPanel], 3, 8, 1, 1);
				revalidate();
			}
		}

	}

	class TableCell extends AbstractCellEditor implements TableCellEditor, TableCellRenderer {

		public TableCell() {
			// TODO Auto-generated constructor stub
			jb = new JButton("구매조회");
			jb.setFocusPainted(false);
			jb.setBackground(Color.WHITE);

			jb.addActionListener(e -> {
				int row = corr_info.getSelectedRow();
				corr_num = "";
				corr_num += (String) corr_info.getValueAt(row, 0);
				corr_nm = "";
				corr_nm += (String) corr_info.getValueAt(row, 1);
				new pur_look();
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
		if (e.getSource() == Bsearch) {
			String search = Tsearch.getText();
			if (cbSearch.getSelectedItem() == "거래처번호") {
				corrListData = corrData.searchCorr1(search);
				remove(pPage[nowPanel]);
				createPanel();
				model1.setRowCount(0);
				getData();

				gridbagconstraints.anchor = GridBagConstraints.CENTER;
				gridbagAdd(pPage[nowPanel], 2, 8, 1, 1);
				revalidate();
			} else if (cbSearch.getSelectedItem() == "거래처명") {
				corrListData = corrData.searchCorr2(search);
				remove(pPage[nowPanel]);
				createPanel();
				model1.setRowCount(0);
				getData();

				gridbagconstraints.anchor = GridBagConstraints.CENTER;
				gridbagAdd(pPage[nowPanel], 2, 8, 1, 1);
				revalidate();
			} else if (cbSearch.getSelectedItem() == "대표명") {
				model1.setRowCount(0);
				corrListData = corrData.searchCorr3(search);
				remove(pPage[nowPanel]);
				createPanel();
				model1.setRowCount(0);
				getData();

				gridbagconstraints.anchor = GridBagConstraints.CENTER;
				gridbagAdd(pPage[nowPanel], 2, 8, 1, 1);
				revalidate();
			}

		}

	}

}