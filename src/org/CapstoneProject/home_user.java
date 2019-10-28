
package org.CapstoneProject;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
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

public class home_user extends JFrame implements MouseListener, ActionListener {

	Dimension d = Toolkit.getDefaultToolkit().getScreenSize();

	Container win = getContentPane();
	JPanel Label = new JPanel();
	JLabel vNotice, vQnA, vNomal, vSpace;

	static JPanel N_U = new Notice_user();
	static JPanel Q_U = new QnA_user();

	static JPanel P_I = new ProImage();
	static JPanel menu_a = new JPanel();
	static JPanel menu_b = new JPanel();
	static JPanel M_M = new Mypage();

	static JMenuBar MenuBar1 = new JMenuBar();
	JMenu Home = new JMenu("홈");
	JMenu Mn_Manage = new JMenu(" 쇼핑몰관리 ");
	JMenu Mn_Post = new JMenu(" 게시판 ");
	JMenu Mn_Basket = new JMenu(" 장바구니 ");
	JMenu Mn_Oder = new JMenu(" 주문하기 ");
	JMenu Mn_Mypage = new JMenu(" 마이페이지 ");
	JMenu Mn_Logout = new JMenu(" 로그아웃 ");

	static JMenuBar MenuBar2 = new JMenuBar();
	// 상의 메뉴
	JMenu Mn_Top = new JMenu("상의 ");
	JMenuItem Top_1 = new JMenuItem("맨투맨");
	JMenuItem Top_2 = new JMenuItem("반팔T");
	JMenuItem Top_3 = new JMenuItem("긴팔T");
	JMenuItem Top_4 = new JMenuItem("후드");
	JMenuItem Top_5 = new JMenuItem("니트 ");
	// 하의 메뉴
	JMenu Mn_Bottom = new JMenu("하의");
	JMenuItem Bot_1 = new JMenuItem("청바지");
	JMenuItem Bot_2 = new JMenuItem("슬랙스");
	JMenuItem Bot_3 = new JMenuItem("면바지");
	JMenuItem Bot_4 = new JMenuItem("운동복");
	JMenuItem Bot_5 = new JMenuItem("반바지");

	// 아우터 메뉴
	JMenu Mn_Outter = new JMenu("아우터");
	JMenuItem Out_1 = new JMenuItem("가디건");
	JMenuItem Out_2 = new JMenuItem("코트");
	JMenuItem Out_3 = new JMenuItem("조끼");
	JMenuItem Out_4 = new JMenuItem("집업");
	JMenuItem Out_5 = new JMenuItem("점퍼");
	JMenuItem Out_6 = new JMenuItem("패딩");
	JMenuItem Out_7 = new JMenuItem("야상");
	JMenuItem Out_8 = new JMenuItem("재킷");
	// 셔츠 메뉴
	JMenu Mn_Shirts = new JMenu("셔츠");
	JMenuItem Sht_1 = new JMenuItem("스트라이프");
	JMenuItem Sht_2 = new JMenuItem("체크");
	JMenuItem Sht_3 = new JMenuItem("긴팔");
	JMenuItem Sht_4 = new JMenuItem("반팔");
	// 신발 메뉴
	JMenu Mn_Shoose = new JMenu("신발");
	JMenuItem Sho_1 = new JMenuItem("스니커즈");
	JMenuItem Sho_2 = new JMenuItem("운동화");
	JMenuItem Sho_3 = new JMenuItem("슬리퍼");
	JMenuItem Sho_4 = new JMenuItem("구두");
	JMenuItem Sho_5 = new JMenuItem("워커");
	JMenuItem Sho_6 = new JMenuItem("부츠");
	JMenuItem Sho_7 = new JMenuItem("샌들");
	JMenuItem Sho_8 = new JMenuItem("로퍼");

	private JScrollPane scroll;

	static String click = "H";
	static String mb_disc_rt;
	String user_id;

	GridBagLayout gbl;
	GridBagConstraints gbc;
	
	
	public String getData4(List<Map<String, Serializable>> CustListData) {

		mb_disc_rt = "";
		mb_disc_rt += CustListData.get(0).get("DISC_RT").toString();
		System.out.println(mb_disc_rt);

		return mb_disc_rt;
	}

	public home_user() {

		vNotice = new JLabel("· 공지사항");
		vNotice.setFont(new Font("휴먼매직체", Font.BOLD, 20));
		vNotice.addMouseListener(this);
		vQnA = new JLabel("· QnA");
		vQnA.setFont(new Font("휴먼매직체", Font.BOLD, 20));
		vQnA.addMouseListener(this);
		vNomal = new JLabel("· 일반게시판");
		vNomal.setFont(new Font("휴먼매직체", Font.BOLD, 20));
		vNomal.addMouseListener(this);
		Label.setLayout(new BoxLayout(Label, BoxLayout.Y_AXIS));
		Label.add(vNotice);
		Label.add(vQnA);
		Label.add(vNomal);

		Mn_Top.add(Top_1);
		Mn_Top.add(Top_2);
		Mn_Top.add(Top_3);
		Mn_Top.add(Top_4);
		Mn_Top.add(Top_5);

		Mn_Bottom.add(Bot_1);
		Mn_Bottom.add(Bot_2);
		Mn_Bottom.add(Bot_3);
		Mn_Bottom.add(Bot_4);
		Mn_Bottom.add(Bot_5);

		Mn_Outter.add(Out_1);
		Mn_Outter.add(Out_2);
		Mn_Outter.add(Out_3);
		Mn_Outter.add(Out_4);
		Mn_Outter.add(Out_5);
		Mn_Outter.add(Out_6);
		Mn_Outter.add(Out_7);
		Mn_Outter.add(Out_8);

		Mn_Shirts.add(Sht_1);
		Mn_Shirts.add(Sht_2);
		Mn_Shirts.add(Sht_3);
		Mn_Shirts.add(Sht_4);

		Mn_Shoose.add(Sho_1);
		Mn_Shoose.add(Sho_2);
		Mn_Shoose.add(Sho_3);
		Mn_Shoose.add(Sho_4);
		Mn_Shoose.add(Sho_5);
		Mn_Shoose.add(Sho_6);
		Mn_Shoose.add(Sho_7);
		Mn_Shoose.add(Sho_8);

		MenuBar1.add(Home);
		MenuBar1.add(Mn_Basket);
		MenuBar1.add(Mn_Mypage);
		MenuBar1.add(Mn_Oder);
		MenuBar1.add(Mn_Post);
		MenuBar1.add(Mn_Logout);

		MenuBar2.add(Mn_Top);
		MenuBar2.add(Mn_Bottom);
		MenuBar2.add(Mn_Outter);
		MenuBar2.add(Mn_Shirts);
		MenuBar2.add(Mn_Shoose);

		MenuBar1.setBounds(d.width / 3, 0, d.width * 2 / 3, 50);
		menu_a.add(MenuBar1);
		MenuBar2.setBounds(d.width / 3, 50, d.width * 2 / 3, 50);
		menu_b.add(MenuBar2);

		P_I.setBounds(100, 100, d.width - 200, d.height - 100);
		P_I.addMouseListener(this);

		home_adminView();
	}

	void home_adminView() {

		setTitle("홈페이지 유저");
		setSize(d.width, d.height);

		Home.setBorder(new LineBorder(new Color(0, 0, 0)));
		Home.setPreferredSize(new Dimension(d.width * 2 / 3 * 1 / 10, Home.getPreferredSize().height));
		Home.setHorizontalAlignment(SwingConstants.CENTER);
		Home.setFont(new Font("휴먼매직체", Font.BOLD, 25));
		Home.addMouseListener(this);

		Mn_Post.setBorder(new LineBorder(new Color(0, 0, 0)));
		Mn_Post.setPreferredSize(new Dimension(d.width * 2 / 3 * 9 / 50, Mn_Post.getPreferredSize().height));
		Mn_Post.setHorizontalAlignment(SwingConstants.CENTER);
		Mn_Post.setFont(new Font("휴먼매직체", Font.BOLD, 25));
		Mn_Post.addMouseListener(this);

		Mn_Basket.setBorder(new LineBorder(new Color(0, 0, 0)));
		Mn_Basket.setPreferredSize(new Dimension(d.width * 2 / 3 * 9 / 50, Mn_Basket.getPreferredSize().height));
		Mn_Basket.setHorizontalAlignment(SwingConstants.CENTER);
		Mn_Basket.setFont(new Font("휴먼매직체", Font.BOLD, 25));
		Mn_Basket.addMouseListener(this);

		Mn_Mypage.setBorder(new LineBorder(new Color(0, 0, 0)));
		Mn_Mypage.setPreferredSize(new Dimension(d.width * 2 / 3 * 9 / 50, Mn_Mypage.getPreferredSize().height));
		Mn_Mypage.setHorizontalAlignment(SwingConstants.CENTER);
		Mn_Mypage.setFont(new Font("휴먼매직체", Font.BOLD, 25));
		Mn_Mypage.addMouseListener(this);

		Mn_Logout.setBorder(new LineBorder(new Color(0, 0, 0)));
		Mn_Logout.setPreferredSize(new Dimension(d.width * 2 / 3 * 9 / 50, Mn_Logout.getPreferredSize().height));
		Mn_Logout.setHorizontalAlignment(SwingConstants.CENTER);
		Mn_Logout.setFont(new Font("휴먼매직체", Font.BOLD, 25));
		Mn_Logout.addMouseListener(this);

		Mn_Oder.setBorder(new LineBorder(new Color(0, 0, 0)));
		Mn_Oder.setPreferredSize(new Dimension(d.width * 2 / 3 * 9 / 50, Mn_Logout.getPreferredSize().height));
		Mn_Oder.setHorizontalAlignment(SwingConstants.CENTER);
		Mn_Oder.setFont(new Font("휴먼매직체", Font.BOLD, 25));
		Mn_Oder.addMouseListener(this);

		Mn_Top.setBorder(new LineBorder(new Color(0, 0, 0)));
		Mn_Top.setPreferredSize(new Dimension(d.width * 2 / 3 * 1 / 5, Mn_Top.getPreferredSize().height));
		Mn_Top.setFont(new Font("", Font.BOLD, 15));

		Top_1.setBackground(new Color(255, 255, 255));
		Top_1.setPreferredSize(new Dimension(d.width * 2 / 3 * 1 / 5, Top_1.getPreferredSize().height));
		Top_1.setFont(new Font("", Font.BOLD, 15));

		Top_2.setBackground(new Color(255, 255, 255));
		Top_2.setFont(new Font("  ", Font.BOLD, 15));

		Top_3.setBackground(new Color(255, 255, 255));
		Top_3.setFont(new Font("  ", Font.BOLD, 15));

		Top_4.setBackground(new Color(255, 255, 255));
		Top_4.setFont(new Font("  ", Font.BOLD, 15));

		Top_5.setBackground(new Color(255, 255, 255));
		Top_5.setFont(new Font("  ", Font.BOLD, 15));

		Mn_Bottom.setBorder(new LineBorder(new Color(0, 0, 0)));
		Mn_Bottom.setPreferredSize(new Dimension(d.width * 2 / 3 * 1 / 5, Mn_Bottom.getPreferredSize().height));
		Mn_Bottom.setHorizontalAlignment(SwingConstants.CENTER);
		Mn_Bottom.setFont(new Font(" ", Font.BOLD, 15));

		Bot_1.setBackground(new Color(255, 255, 255));
		Bot_1.setPreferredSize(new Dimension(d.width * 2 / 3 * 1 / 5, Bot_1.getPreferredSize().height));
		Bot_1.setFont(new Font("", Font.BOLD, 15));

		Bot_2.setBackground(new Color(255, 255, 255));
		Bot_2.setFont(new Font("  ", Font.BOLD, 15));

		Bot_3.setBackground(new Color(255, 255, 255));
		Bot_3.setFont(new Font("  ", Font.BOLD, 15));

		Bot_4.setBackground(new Color(255, 255, 255));
		Bot_4.setFont(new Font("  ", Font.BOLD, 15));

		Bot_5.setBackground(new Color(255, 255, 255));
		Bot_5.setFont(new Font("  ", Font.BOLD, 15));

		Mn_Outter.setBorder(new LineBorder(new Color(0, 0, 0)));
		Mn_Outter.setPreferredSize(new Dimension(d.width * 2 / 3 * 1 / 5, Mn_Outter.getPreferredSize().height));
		Mn_Outter.setHorizontalAlignment(SwingConstants.CENTER);
		Mn_Outter.setFont(new Font(" ", Font.BOLD, 15));

		Out_1.setBackground(new Color(255, 255, 255));
		Out_1.setPreferredSize(new Dimension(d.width * 2 / 3 * 1 / 5, Out_1.getPreferredSize().height));
		Out_1.setFont(new Font("", Font.BOLD, 15));

		Out_2.setBackground(new Color(255, 255, 255));
		Out_2.setFont(new Font("  ", Font.BOLD, 15));

		Out_3.setBackground(new Color(255, 255, 255));
		Out_3.setFont(new Font("  ", Font.BOLD, 15));

		Out_4.setBackground(new Color(255, 255, 255));
		Out_4.setFont(new Font("  ", Font.BOLD, 15));

		Out_5.setBackground(new Color(255, 255, 255));
		Out_5.setFont(new Font("  ", Font.BOLD, 15));

		Out_6.setBackground(new Color(255, 255, 255));
		Out_6.setFont(new Font("", Font.BOLD, 15));

		Out_7.setBackground(new Color(255, 255, 255));
		Out_7.setFont(new Font("  ", Font.BOLD, 15));

		Out_8.setBackground(new Color(255, 255, 255));
		Out_8.setFont(new Font("  ", Font.BOLD, 15));

		Mn_Shirts.setBorder(new LineBorder(new Color(0, 0, 0)));
		Mn_Shirts.setPreferredSize(new Dimension(d.width * 2 / 3 * 1 / 5, Mn_Shirts.getPreferredSize().height));
		Mn_Shirts.setHorizontalAlignment(SwingConstants.CENTER);
		Mn_Shirts.setFont(new Font(" ", Font.BOLD, 15));

		Sht_1.setBackground(new Color(255, 255, 255));
		Sht_1.setPreferredSize(new Dimension(d.width * 2 / 3 * 1 / 5, Sht_1.getPreferredSize().height));
		Sht_1.setFont(new Font("", Font.BOLD, 15));

		Sht_2.setBackground(new Color(255, 255, 255));
		Sht_2.setFont(new Font("  ", Font.BOLD, 15));

		Sht_3.setBackground(new Color(255, 255, 255));
		Sht_3.setFont(new Font("  ", Font.BOLD, 15));

		Sht_4.setBackground(new Color(255, 255, 255));
		Sht_4.setFont(new Font("  ", Font.BOLD, 15));

		Mn_Shoose.setBorder(new LineBorder(new Color(0, 0, 0)));
		Mn_Shoose.setPreferredSize(new Dimension(d.width * 2 / 3 * 1 / 5, Mn_Shoose.getPreferredSize().height));
		Mn_Shoose.setHorizontalAlignment(SwingConstants.CENTER);
		Mn_Shoose.setFont(new Font(" ", Font.BOLD, 15));

		Sho_1.setBackground(new Color(255, 255, 255));
		Sho_1.setPreferredSize(new Dimension(d.width * 2 / 3 * 1 / 5, Sho_1.getPreferredSize().height));
		Sho_1.setFont(new Font("", Font.BOLD, 15));

		Sho_2.setBackground(new Color(255, 255, 255));
		Sho_2.setFont(new Font("  ", Font.BOLD, 15));

		Sho_3.setBackground(new Color(255, 255, 255));
		Sho_3.setFont(new Font("  ", Font.BOLD, 15));

		Sho_4.setBackground(new Color(255, 255, 255));
		Sho_4.setFont(new Font("  ", Font.BOLD, 15));

		Sho_5.setBackground(new Color(255, 255, 255));
		Sho_5.setFont(new Font("  ", Font.BOLD, 15));

		Sho_6.setBackground(new Color(255, 255, 255));
		Sho_6.setFont(new Font("", Font.BOLD, 15));

		Sho_7.setBackground(new Color(255, 255, 255));
		Sho_7.setFont(new Font("  ", Font.BOLD, 15));

		Sho_8.setBackground(new Color(255, 255, 255));
		Sho_8.setFont(new Font("  ", Font.BOLD, 15));

		setLayout(null);

		win.add(MenuBar1);
		win.add(MenuBar2);
		win.add(P_I);

//      setLayout(gbl);
//      gbc.anchor = GridBagConstraints.EAST;

		setExtendedState(MAXIMIZED_BOTH);
		setVisible(true);
	}

	private void gridbagAdd(Component c, int x, int y, int w, int h) {

		gbc.gridx = x;
		gbc.gridy = y;
		// 가장 왼쪽 위 gridx, gridy값은 0

		gbc.gridwidth = w;
		gbc.gridheight = h;

		gbl.setConstraints(c, gbc); // 컴포넌트를 컴포넌트 위치+크기 정보에 따라 GridBagLayout에 배치

		add(c);

	}

	public static void main(String[] args) {
		new home_user();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

		if (e.getSource() == Mn_Logout) {
			new Login();
			dispose();
		} else if (e.getSource() == Mn_Mypage) {
			win.removeAll();
			win.add(MenuBar1);
			win.add(MenuBar2);
			M_M.setBounds(0, 100, d.width, d.height - 100);
			win.add(M_M);
			repaint();
			revalidate();
		} else if (e.getSource() == Home) {
			win.removeAll();
			win.add(MenuBar1);
			win.add(MenuBar2);
//	          P_I.setBounds(100, 100, d.width -200, d.height - 100);
			win.add(P_I);
			repaint();
			revalidate();
		} else if (e.getSource() == Mn_Basket) {
			user_id = Login.user_id;
			getData4(CustData.selectCustGra(user_id));
			new Basket();
		} else if (e.getSource() == Mn_Oder) {
			new MemOrdPg();
		} else if (e.getSource() == Mn_Logout) {
			new Login();
			dispose();
		} else if (e.getSource() == Mn_Post) {
			getContentPane().removeAll();
			add(MenuBar1);
			add(MenuBar2);
			Dimension d = getSize();
			Label.setBounds(100, 400, 100, d.height - 500);
			N_U.setBounds(0, 100, d.width, d.height - 100);
			add(Label);
			add(N_U);
			repaint();
			revalidate();
		} else if (e.getSource() == vNotice) {
			getContentPane().removeAll();
			add(MenuBar1);
			add(MenuBar2);
			Dimension d = getSize();
			Label.setBounds(100, 400, 100, d.height - 500);
			N_U.setBounds(0, 100, d.width, d.height - 100);
			add(Label);
			add(N_U);
			repaint();
			revalidate();
		} else if (e.getSource() == vQnA) {
			getContentPane().removeAll();
			add(MenuBar1);
			add(MenuBar2);
			Dimension d = getSize();
			Label.setBounds(100, 400, 100, d.height - 500);
			Q_U.setBounds(0, 100, d.width, d.height - 100);
			add(Label);
			add(Q_U);
			repaint();
			revalidate();
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
