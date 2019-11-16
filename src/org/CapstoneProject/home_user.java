package org.CapstoneProject;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
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

	static public JPanel Panel_Center;
	private JPanel contentPane;
	Dimension d = Toolkit.getDefaultToolkit().getScreenSize();

	JPanel Cust_info = new Cust_info();
	Container win = getContentPane();
	JPanel Label = new JPanel();
	JLabel vNotice, vQnA, vReview, vSpace;

	private static Image originImg, changedImg;
	private static ImageIcon originIcon, Icon;
	JLabel img_top, img_left_b, jean, jean2, shoose;

	static JPanel P_I = new ProImage();
	static JPanel M_M = new JPanel();
	static JPanel Od_list = new Od_list_user();	
	
	JPanel Menu;
	JLabel Lbasket, Lorder, Lmypage, Lpost;

	static BackgroundMenuBar MenuBar2 = new BackgroundMenuBar();
	// 상의 메뉴
	JMenu Mn_Top = new JMenu("            상의   ");
	JMenuItem Top_1 = new JMenuItem("                맨투맨  ");
	JMenuItem Top_2 = new JMenuItem("                반팔T  ");
	JMenuItem Top_3 = new JMenuItem("                긴팔T  ");
	JMenuItem Top_4 = new JMenuItem("                후드  ");
	JMenuItem Top_5 = new JMenuItem("                니트  ");
	// 하의 메뉴
	JMenu Mn_Bottom = new JMenu("            하의  ");
	JMenuItem Bot_1 = new JMenuItem("                청바지   ");
	JMenuItem Bot_2 = new JMenuItem("                슬랙스   ");
	JMenuItem Bot_3 = new JMenuItem("                면바지   ");
	JMenuItem Bot_4 = new JMenuItem("                운동복   ");
	JMenuItem Bot_5 = new JMenuItem("                반바지   ");

	// 아우터 메뉴
	JMenu Mn_Outter = new JMenu("            아우터  ");
	JMenuItem Out_1 = new JMenuItem("                 가디건  ");
	JMenuItem Out_2 = new JMenuItem("                 코트  ");
	JMenuItem Out_3 = new JMenuItem("                 조끼  ");
	JMenuItem Out_4 = new JMenuItem("                 집업  ");
	JMenuItem Out_5 = new JMenuItem("                 점퍼  ");
	JMenuItem Out_6 = new JMenuItem("                 패딩  ");
	JMenuItem Out_7 = new JMenuItem("                 야상  ");
	JMenuItem Out_8 = new JMenuItem("                 재킷  ");
	// 셔츠 메뉴
	JMenu Mn_Shirts = new JMenu("            셔츠 ");
	JMenuItem Sht_1 = new JMenuItem("                스트라이프  ");
	JMenuItem Sht_2 = new JMenuItem("                체크  ");
	JMenuItem Sht_3 = new JMenuItem("                긴팔  ");
	JMenuItem Sht_4 = new JMenuItem("                반팔  ");
	// 신발 메뉴
	JMenu Mn_Shoose = new JMenu("              신발    ");
	JMenuItem Sho_1 = new JMenuItem("                  스니커즈    ");
	JMenuItem Sho_2 = new JMenuItem("                  운동화    ");
	JMenuItem Sho_3 = new JMenuItem("                  슬리퍼    ");
	JMenuItem Sho_4 = new JMenuItem("                  구두    ");
	JMenuItem Sho_5 = new JMenuItem("                  워커    ");
	JMenuItem Sho_6 = new JMenuItem("                  부츠    ");
	JMenuItem Sho_7 = new JMenuItem("                  샌들    ");
	JMenuItem Sho_8 = new JMenuItem("                  로퍼    ");

	private JScrollPane scroll;

	static String click = "H";

	GridBagLayout gbl;
	GridBagConstraints gbc;

	public home_user() {

		vNotice = new JLabel("· 공지사항");
		vNotice.setFont(new Font("휴먼매직체", Font.BOLD, 20));
		vNotice.addMouseListener(this);
		vQnA = new JLabel("· QnA");
		vQnA.setFont(new Font("휴먼매직체", Font.BOLD, 20));
		vQnA.addMouseListener(this);
		vReview = new JLabel("· 후기게시판");
		vReview.setFont(new Font("휴먼매직체", Font.BOLD, 20));
		vReview.addMouseListener(this);
		Label.setLayout(new BoxLayout(Label, BoxLayout.Y_AXIS));
		Label.add(vNotice);
		Label.add(vQnA);
		Label.add(vReview);
//		Label.setBackground(Color.white);
		Label.setBounds(370, 220, 120, 150);

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
		
		Menu = new JPanel();
		Lbasket = new JLabel("장바구니 ");
		Lorder = new JLabel("주문하기 ");
		Lmypage = new JLabel("마이페이지 ");
		Lpost = new JLabel("게시판 ");


		MenuBar2.add(Mn_Top);
		MenuBar2.add(Mn_Bottom);
		MenuBar2.add(Mn_Outter);
		MenuBar2.add(Mn_Shirts);
		MenuBar2.add(Mn_Shoose);

		MenuBar2.setBounds(340, 51, 1025, 50);

		P_I.setBounds(d.width / 4, 100, d.width * 3 / 4, d.height - 100);
		P_I.addMouseListener(this);
		P_I.setBackground(Color.white);

		img_top = new JLabel("");
		originIcon = new ImageIcon("C:\\Users\\ssong\\Desktop\\img\\홈유저 상단.jpg");
		originImg = originIcon.getImage();
		changedImg = originImg.getScaledInstance(d.width / 4, 100, Image.SCALE_SMOOTH);
		Icon = new ImageIcon(changedImg);
		img_top.setIcon(Icon);
		img_top.setBounds(0, 0, d.width / 4, 100);
		img_top.addMouseListener(this);

		Cust_info.setBounds(0, 100, 340, 160);
		Cust_info.setBackground(new Color(200, 200, 255));

		img_left_b = new JLabel("");
		originIcon = new ImageIcon("C:\\Users\\ssong\\Desktop\\img\\홈유저 좌하단.png");
		originImg = originIcon.getImage();
		changedImg = originImg.getScaledInstance(d.width / 4, 175, Image.SCALE_SMOOTH);
		Icon = new ImageIcon(changedImg);
		img_left_b.setIcon(Icon);
		img_left_b.setBounds(0, 530, 340, 175);

		jean = new JLabel("");
		originIcon = new ImageIcon("C:\\Users\\ssong\\Desktop\\img\\청바지.jpg");
		originImg = originIcon.getImage();
		changedImg = originImg.getScaledInstance(d.width / 4, 100, Image.SCALE_SMOOTH);
		Icon = new ImageIcon(changedImg);
		jean.setIcon(Icon);
		jean.setBounds(0, 345, 340, 100);

		jean2 = new JLabel("");
		originIcon = new ImageIcon("C:\\Users\\ssong\\Desktop\\img\\옷.jpg");
		originImg = originIcon.getImage();
		changedImg = originImg.getScaledInstance(d.width / 4, 150, Image.SCALE_SMOOTH);
		Icon = new ImageIcon(changedImg);
		jean2.setIcon(Icon);
		jean2.setBounds(0, 260, 340, 100);

		shoose = new JLabel("");
		originIcon = new ImageIcon("C:\\Users\\ssong\\Desktop\\img\\신발.jpg");
		originImg = originIcon.getImage();
		changedImg = originImg.getScaledInstance(d.width / 4, 150, Image.SCALE_SMOOTH);
		Icon = new ImageIcon(changedImg);
		shoose.setIcon(Icon);
		shoose.setBounds(0, 445, 340, 85);

		if (ProDetail.state != 0) {
//			Basket();
//			OrdPg();
		}
		home_userView();
	}

	public void changePanel(JPanel newPanel) { // 센터패널 교환하기
		if(Label != null) {
			remove(Label);
		}
		remove(Panel_Center);
		newPanel.setSize(d.width * 3 / 4, d.height - 100);
		Panel_Center = newPanel;
		Panel_Center.setBounds(d.width / 4, 100, d.width * 3 / 4, d.height - 100);
		add(Panel_Center);
		revalidate();
		repaint();
	}
	
	public void changePanel2(JPanel newPanel) { // 센터패널 교환하기
		remove(Panel_Center);
		newPanel.setSize(d.width - 500, d.height - 85);
		Panel_Center = newPanel;
		Panel_Center.setBounds(450, 85, d.width - 450, d.height - 85);
		add(Label);
		add(Panel_Center);
		revalidate();
		repaint();
	}

	void home_userView() {

		setTitle("홈페이지 유저");
		setSize(d.width, d.height);
		
		Lbasket.setFont(new Font("맑은 고딕", Font.BOLD, 20));
//		Lbasket.setHorizontalAlignment(JLabel.CENTER);
		Lbasket.addMouseListener(this);
		Lorder.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		Lorder.addMouseListener(this);
		Lpost.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		Lpost.addMouseListener(this);
		Lmypage.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		Lmypage.addMouseListener(this);
		
		Menu.add(Lbasket);
		Menu.add(Lorder);
		Menu.add(Lmypage);
		Menu.add(Lpost);
		Menu.setBackground(Color.white);
		Menu.setBounds(340, 0, 1025, 50);

		Mn_Top.setBorder(new LineBorder(new Color(0, 0, 0)));
		Mn_Top.setPreferredSize(new Dimension(205, Mn_Top.getPreferredSize().height));
		Mn_Top.setFont(new Font("", Font.BOLD, 20));

		Top_1.setBackground(new Color(255, 255, 255));
		Top_1.setPreferredSize(new Dimension(d.width * 3 / 4 * 1 / 5, Top_1.getPreferredSize().height));
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
		Mn_Bottom.setPreferredSize(new Dimension(205, Mn_Bottom.getPreferredSize().height));
		Mn_Bottom.setHorizontalAlignment(SwingConstants.CENTER);
		Mn_Bottom.setFont(new Font(" ", Font.BOLD, 20));

		Bot_1.setBackground(new Color(255, 255, 255));
		Bot_1.setPreferredSize(new Dimension(d.width * 3 / 4 * 1 / 5, Bot_1.getPreferredSize().height));
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
		Mn_Outter.setPreferredSize(new Dimension(205, Mn_Outter.getPreferredSize().height));
		Mn_Outter.setHorizontalAlignment(SwingConstants.CENTER);
		Mn_Outter.setFont(new Font(" ", Font.BOLD, 20));

		Out_1.setBackground(new Color(255, 255, 255));
		Out_1.setPreferredSize(new Dimension(d.width * 3 / 4 * 1 / 5, Out_1.getPreferredSize().height));
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
		Mn_Shirts.setPreferredSize(new Dimension(205, Mn_Shirts.getPreferredSize().height));
		Mn_Shirts.setHorizontalAlignment(SwingConstants.CENTER);
		Mn_Shirts.setFont(new Font(" ", Font.BOLD, 20));

		Sht_1.setBackground(new Color(255, 255, 255));
		Sht_1.setPreferredSize(new Dimension(d.width * 3 / 4 * 1 / 5, Sht_1.getPreferredSize().height));
		Sht_1.setFont(new Font("", Font.BOLD, 15));

		Sht_2.setBackground(new Color(255, 255, 255));
		Sht_2.setFont(new Font("  ", Font.BOLD, 15));

		Sht_3.setBackground(new Color(255, 255, 255));
		Sht_3.setFont(new Font("  ", Font.BOLD, 15));

		Sht_4.setBackground(new Color(255, 255, 255));
		Sht_4.setFont(new Font("  ", Font.BOLD, 15));

		Mn_Shoose.setBorder(new LineBorder(new Color(0, 0, 0)));
		Mn_Shoose.setPreferredSize(new Dimension(205, Mn_Shoose.getPreferredSize().height));
		Mn_Shoose.setHorizontalAlignment(SwingConstants.CENTER);
		Mn_Shoose.setFont(new Font(" ", Font.BOLD, 20));

		Sho_1.setBackground(new Color(255, 255, 255));
		Sho_1.setPreferredSize(new Dimension(205, Sho_1.getPreferredSize().height));
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

		Panel_Center = new JPanel();
		setLayout(null);

		add(Menu);
		add(MenuBar2);
		add(Panel_Center); // 센터 패널 붙이기
		add(img_top);
		add(img_left_b);
		add(Cust_info);
		add(jean);
		add(jean2);
		add(shoose);
		changePanel((JPanel) new ProImage(this));

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

		getContentPane().add(c);

	}

	public static void main(String[] args) {
		new home_user();

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

		if (e.getSource() == Lbasket) {
			changePanel(new Basket());
			repaint();
			revalidate();
		} else if (e.getSource() == Lorder) {
			changePanel(new MemOrdPg());
			repaint();
			revalidate();
		} else if (e.getSource() == Lmypage) {
			changePanel(new Mypage());
			repaint();
			revalidate();
		} else if (e.getSource() == Lpost) {
			changePanel2(new Notice_user());
			repaint();
			revalidate();
		} else if (e.getSource() == vNotice) {
			changePanel2(new Notice_user());
			repaint();
			revalidate();
		} else if (e.getSource() == vQnA) {
			changePanel2(new QnA_user());
			repaint();
			revalidate();
		} else if (e.getSource() == vReview) {
			changePanel2(new Review_user());
			repaint();
			revalidate();
		} else if(e.getSource() == img_top) {
			changePanel((JPanel) new ProImage(this));
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