package org.CapstoneProject;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.TextField;
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
import java.util.List;
import java.util.Map;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class Review_user extends JPanel implements ActionListener, MouseListener {

	static JPanel C_U = new JPanel();

	Dimension d = Toolkit.getDefaultToolkit().getScreenSize();

	private JLabel vReview;
	private JTextField Tsearch;

	static JLabel vNotice, vReview2, vNomal, vSpace;
	JPanel Label = new JPanel();

	private static String[] col1 = { "No", "제목", "작성자", "작성일" };
	private String[] search = { "제목", "작성일" };

	private static DefaultTableModel model1 = new DefaultTableModel(col1, 0) {
		public boolean isCellEditable(int row, int column) {
			return false;
		}
	};
	static ArrayList<String> ar = new ArrayList<String>();

	private JTable tReview;
	List<Map<String, Serializable>> ReviewListData;
	private int nowPage;
	private int nowPanel;
	private int postPerPage = 5;
	private int pagePerPanel = 3;
	private int panelNum;
	private int pageNum;
	private JButton[] bPage;
	private JPanel[] pPage;
	private JButton Bsearch, jb, pre, next;
	private JScrollPane Scroll;

	private JButton bSearch;
	private JComboBox<String> cbSearch;

	GridBagLayout gridbaglayout;
	GridBagConstraints gridbagconstraints;

	static String POST_NUM;

	public Review_user() {

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

		vReview = new JLabel("후기게시판");
		vReview.setFont(new Font("휴먼매직체", Font.BOLD, 25));

		bSearch = new JButton("검색");
		bSearch.setFocusPainted(false);
		bSearch.setBackground(Color.white);
		bSearch.setPreferredSize(new Dimension(80, 40));
		bSearch.setFont(new Font("휴먼매직체", Font.BOLD, 22));

		cbSearch = new JComboBox<String>(search);
		cbSearch.setFont(new Font("휴먼매직체", Font.PLAIN, 22));
		cbSearch.setPreferredSize(new Dimension(100, 40));
		cbSearch.setBackground(Color.WHITE);

		Tsearch = new JTextField(15);
		Tsearch.setFont(new Font("휴먼매직체", Font.PLAIN, 20));
		Tsearch.setPreferredSize(new Dimension(150, 41));

		tReview = new JTable(model1);
		tReview.getColumnModel().getColumn(0).setPreferredWidth(70);
		tReview.getColumnModel().getColumn(1).setPreferredWidth(450);
		tReview.getColumnModel().getColumn(2).setPreferredWidth(70);
		tReview.getColumnModel().getColumn(3).setPreferredWidth(70);
		tReview.addMouseListener(this);
		Scroll = new JScrollPane(tReview);
		Scroll.setPreferredSize(new Dimension(700, 300));

		vNotice = new JLabel("· 공지사항");
		vNotice.setFont(new Font("휴먼매직체", Font.BOLD, 20));
		vNotice.addMouseListener(this);
		vReview2 = new JLabel("· Review");
		vReview2.setFont(new Font("휴먼매직체", Font.BOLD, 20));
		vReview2.addMouseListener(this);
		vNomal = new JLabel("· 일반게시판");
		vNomal.setFont(new Font("휴먼매직체", Font.BOLD, 20));
		vNomal.addMouseListener(this);
		vSpace = new JLabel("");
		vSpace.setPreferredSize(new Dimension(50, 10));
		Label.setLayout(new BoxLayout(Label, BoxLayout.Y_AXIS));
		Label.add(vNotice);
		Label.add(vReview2);
		Label.add(vNomal);

		ReviewListData = ReviewData.selectReview(); // 공지사항글 정보 받아오기
		createPanel();// 버튼을 올려놓을 패널 생성, nowPage와 nowPanel값 초기화
		getData();// 테이블에 데이터 불러오기

		home_adminView();
	}

	private void home_adminView() {

		setLayout(gridbaglayout);

		gridbagconstraints.anchor = GridBagConstraints.WEST;

		gridbagAdd(vSpace, 1, 1, 1, 1);
		gridbagAdd(vReview, 2, 0, 1, 1);
		gridbagAdd(cbSearch, 2, 1, 1, 1);
		gridbagAdd(Tsearch, 3, 1, 1, 1);
		gridbagAdd(bSearch, 4, 1, 1, 1);

		gridbagAdd(Scroll, 2, 2, 3, 1);

		gridbagconstraints.anchor = GridBagConstraints.CENTER;

		gridbagconstraints.anchor = GridBagConstraints.EAST;
		gridbagAdd(pre, 2, 3, 1, 1);
		gridbagconstraints.anchor = GridBagConstraints.CENTER;
		gridbagAdd(pPage[0], 3, 3, 1, 1);
		gridbagconstraints.anchor = GridBagConstraints.WEST;
		gridbagAdd(next, 4, 3, 1, 1);

		gridbagconstraints.anchor = GridBagConstraints.EAST;
		setVisible(true);
	}

	void getData() {
		model1.setRowCount(0);

		for (int i = nowPage * postPerPage; i < nowPage * postPerPage + postPerPage; i++) {
			if (i > ReviewListData.size() - 1) {
				break;
			}
			ar.add(ReviewListData.get(i).get("WRT_DATE").toString());

//			String oldstring = ex_st_date;

			Date date = null;
			try {
				date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").parse(ar.get(i));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String new_appc_date = new SimpleDateFormat("yyyy-MM-dd").format(date);
			model1.addRow(
					new Object[] { ReviewListData.get(i).get("POST_MSG_NUM"),
							ReviewListData.get(i).get("POST_MSG_TIT"),							
							ReviewListData.get(i).get("WRITER_NM"), 
							new_appc_date });
		}
	}

	private void createPanel() {
		if (ReviewListData.size() != 0 && (ReviewListData.size() % postPerPage) == 0) { // 페이지 수 구하기
			pageNum = ReviewListData.size() / postPerPage;
		} else {
			pageNum = ReviewListData.size() / postPerPage + 1;
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

	public static void main(String[] args) {
		new Review_user();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		for (int i = 0; i < pageNum; i++) {
			if (e.getSource() == bPage[i]) {
				nowPage = i;
				model1.setRowCount(0);
				getData();
			}
		}

		int row;
		if (e.getSource() == tReview) {
			row = tReview.getSelectedRow();
			POST_NUM = "";
			POST_NUM += tReview.getValueAt(row, 0);
			new Review_view(new JFrame());
		} else if (e.getSource() == pre) {
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

//		new Review_view_user(new JFrame());

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

	}
}
