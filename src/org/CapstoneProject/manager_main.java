package org.CapstoneProject;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.Action;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import org.CapstoneProject.RegPro;

public class manager_main extends JFrame implements ActionListener, MouseListener {

	static JPanel menu_b = new JPanel();

	Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
	Container win = getContentPane();

	static JPanel N_A = new Notice_admin();
	static JPanel Q_A = new QnA_admin();
	
	static String click = "H";
	static String gra_s, gra_v, gra_f;
	
	JPanel Label = new JPanel();
	
	JLabel vNotice, vQnA, vNomal, vSpace;

	JMenuBar MenuBar = new JMenuBar();
	// 거래처 메뉴
	JMenu Mn_corr = new JMenu("    거래처    ");
	JMenuItem corr_look = new JMenuItem("   거래처조회  ");
	JMenuItem corr_regist = new JMenuItem("   거래처등록  ");
	// 상품 메뉴
	JMenu Mn_pro = new JMenu("     상품     ");
	JMenuItem model_look = new JMenuItem(" 모델조회  ");
	JMenuItem model_regist = new JMenuItem(" 모델등록  ");
	JMenuItem pro_look = new JMenuItem(" 상품조회  ");
	JMenuItem pro_regist = new JMenuItem(" 상품등록  ");
	JMenuItem pro_up_rec = new JMenuItem(" 상품단가관리");

	// 주문 메뉴
	JMenu Mn_Od = new JMenu("     주문     ");
	JMenuItem Od_list = new JMenuItem("    주문목록    ");
	JMenuItem Od_deli = new JMenuItem("    배송목록    ");
	JMenuItem Od_change = new JMenuItem("    교환    ");
	JMenuItem Od_refund = new JMenuItem("    환불    ");
	// 사원 메뉴
	JMenu Mn_Emp = new JMenu("     사원     ");
	JMenuItem Emp_look = new JMenuItem("    사원조회   ");
	JMenuItem Emp_regist = new JMenuItem("    사원등록   ");
	JMenuItem Emp_modify = new JMenuItem("    사원수정   ");
	// 회원 메뉴
	JMenu Mn_Mb = new JMenu("     회원     ");
	JMenuItem Mb_look = new JMenuItem("  회원조회   ");
	JMenuItem Mb_grade = new JMenuItem("   등급기본정보 ");
	// 이벤트

	JMenu Mn_EVT = new JMenu("    이벤트    ");
	JMenuItem EVT_look = new JMenuItem("   이벤트조회  ");
	JMenuItem EVT_regist = new JMenuItem("   이벤트등록  ");

	JMenu Mn_Post = new JMenu("  게시판   ");
	JMenuItem Post_Notice = new JMenuItem("   공지사항   ");
	JMenuItem Post_QnA = new JMenuItem("   QnA   ");
	JMenuItem Post_Nomal = new JMenuItem("   일반게시판   ");

	JMenu Close = new JMenu(" 로그아웃 ");

	BufferedImage img = null;

//   JButton Close;

	GridBagLayout gridbaglayout;
	GridBagConstraints gridbagconstraints; // gridbag레이아웃에 컴포넌트의 위치를 잡아주는 역할

	public String getData1(List<Map<String, Serializable>> MbgraListData) {

		gra_s = "";
		gra_s += MbgraListData.get(0).get("DISC_RT");

		return gra_s;

	}

	public String getData2(List<Map<String, Serializable>> MbgraListData) {

		gra_v = "";
		gra_v += MbgraListData.get(0).get("DISC_RT");

		return gra_v;

	}

	public String getData3(List<Map<String, Serializable>> MbgraListData) {

		gra_f = "";
		gra_f += MbgraListData.get(0).get("DISC_RT");

		return gra_f;

	}

	public manager_main() {

		gridbaglayout = new GridBagLayout();
		gridbagconstraints = new GridBagConstraints();

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
		
		corr_look.addActionListener(this);
		corr_regist.addActionListener(this);
		model_look.addActionListener(this);
		model_regist.addActionListener(this);
		pro_look.addActionListener(this);
		pro_regist.addActionListener(this);
		pro_up_rec.addActionListener(this);
		Od_list.addActionListener(this);
		Od_deli.addActionListener(this);
		Od_change.addActionListener(this);
		Od_refund.addActionListener(this);
		Emp_look.addActionListener(this);
		Emp_regist.addActionListener(this);
		Emp_modify.addActionListener(this);
		Mb_look.addActionListener(this);
		Mb_grade.addActionListener(this);
		EVT_look.addActionListener(this);
		EVT_regist.addActionListener(this);
		Close.addMouseListener(this);
		Mn_Post.addMouseListener(this);
//		Post_Notice.addMouseListener(this);
//		Post_QnA.addMouseListener(this);
//		Post_Nomal.addMouseListener(this);

		Mn_corr.add(corr_look);
		Mn_corr.add(corr_regist);

		Mn_pro.add(model_look);
		Mn_pro.add(model_regist);
		Mn_pro.add(pro_look);
		Mn_pro.add(pro_regist);
		Mn_pro.add(pro_up_rec);

		Mn_Od.add(Od_list);
		Mn_Od.add(Od_deli);
		Mn_Od.add(Od_change);
		Mn_Od.add(Od_refund);

		Mn_Emp.add(Emp_look);
		Mn_Emp.add(Emp_regist);
		Mn_Emp.add(Emp_modify);

		Mn_Mb.add(Mb_look);
		Mn_Mb.add(Mb_grade);

		Mn_EVT.add(EVT_look);
		Mn_EVT.add(EVT_regist);

//		Mn_Post.add(Post_Notice);
//		Mn_Post.add(Post_QnA);
//		Mn_Post.add(Post_Nomal);

		MenuBar.add(Mn_corr);
		MenuBar.add(Mn_pro);
		MenuBar.add(Mn_Od);
		MenuBar.add(Mn_Emp);
		MenuBar.add(Mn_Mb);
		MenuBar.add(Mn_EVT);
		MenuBar.add(Mn_Post);
		MenuBar.add(Close);

		MenuBar.setBounds(0, 0, 1377, 40);

		menu_b.add(MenuBar);

//         Close = new JButton("닫기");

//         getDeptData(EmpData.selectDept());
//         getSvpData(EmpData.selectSpv());
		setExtendedState(MAXIMIZED_BOTH);
		EmpRegisterView();
	}

	private void EmpRegisterView() {

		setTitle("관리자 메인화면");
//		setSize(d.width, d.height);
		// 크기설정
		// 거래처 메뉴
		MenuBar.setBounds(0, 0, d.width, 50);
		Mn_corr.setBorder(new LineBorder(new Color(0, 0, 0)));
		Mn_corr.setPreferredSize(new Dimension(d.width * 1 / 8, Mn_corr.getPreferredSize().height));
		Mn_corr.setHorizontalAlignment(SwingConstants.CENTER);
		Mn_corr.setFont(new Font("휴먼매직체", Font.BOLD, 25));
		Mn_corr.addMouseListener(this);

		corr_look.setBackground(new Color(255, 255, 255));
		corr_look.setHorizontalAlignment(SwingConstants.TRAILING);
		corr_look.setFont(new Font("맑은 고딕", Font.BOLD, 20));

		corr_regist.setBackground(new Color(255, 255, 255));
		corr_regist.setHorizontalAlignment(SwingConstants.TRAILING);
		corr_regist.setFont(new Font("맑은 고딕", Font.BOLD, 20));

		// 상품메뉴
		Mn_pro.setBorder(new LineBorder(new Color(0, 0, 0)));
		Mn_pro.setPreferredSize(new Dimension(d.width * 1 / 8, Mn_corr.getPreferredSize().height));
		Mn_pro.setHorizontalAlignment(SwingConstants.CENTER);
		Mn_pro.setFont(new Font("휴먼매직체", Font.BOLD, 25));
		Mn_pro.addMouseListener(this);

		model_look.setBackground(new Color(255, 255, 255));
		model_look.setHorizontalAlignment(SwingConstants.TRAILING);
		model_look.setFont(new Font("맑은 고딕", Font.BOLD, 20));

		model_regist.setBackground(new Color(255, 255, 255));
		model_regist.setHorizontalAlignment(SwingConstants.TRAILING);
		model_regist.setFont(new Font("맑은 고딕", Font.BOLD, 20));

		pro_look.setBackground(new Color(255, 255, 255));
		pro_look.setHorizontalAlignment(SwingConstants.TRAILING);
		pro_look.setFont(new Font("맑은 고딕", Font.BOLD, 20));

		pro_regist.setBackground(new Color(255, 255, 255));
		pro_regist.setHorizontalAlignment(SwingConstants.TRAILING);
		pro_regist.setFont(new Font("맑은 고딕", Font.BOLD, 20));

		pro_up_rec.setBackground(new Color(255, 255, 255));
		pro_up_rec.setHorizontalAlignment(SwingConstants.TRAILING);
		pro_up_rec.setFont(new Font("맑은 고딕", Font.BOLD, 20));

		// 주문 메뉴
		Mn_Od.setBorder(new LineBorder(new Color(0, 0, 0)));
		Mn_Od.setPreferredSize(new Dimension(d.width * 1 / 8, Mn_corr.getPreferredSize().height));
		Mn_Od.setHorizontalAlignment(SwingConstants.CENTER);
		Mn_Od.setFont(new Font("휴먼매직체", Font.BOLD, 25));
		Mn_Od.addMouseListener(this);

		Od_list.setBackground(new Color(255, 255, 255));
		Od_list.setHorizontalAlignment(SwingConstants.TRAILING);
		Od_list.setFont(new Font("맑은 고딕", Font.BOLD, 20));

		Od_deli.setBackground(new Color(255, 255, 255));
		Od_deli.setHorizontalAlignment(SwingConstants.TRAILING);
		Od_deli.setFont(new Font("맑은 고딕", Font.BOLD, 20));

		Od_change.setBackground(new Color(255, 255, 255));
		Od_change.setHorizontalAlignment(SwingConstants.TRAILING);
		Od_change.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		Od_change.setHorizontalAlignment(JLabel.CENTER);

		Od_refund.setBackground(new Color(255, 255, 255));
		Od_refund.setHorizontalAlignment(SwingConstants.TRAILING);
		Od_refund.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		Od_refund.setHorizontalAlignment(JLabel.CENTER);

		// 사원메뉴
		Mn_Emp.setBorder(new LineBorder(new Color(0, 0, 0)));
		Mn_Emp.setPreferredSize(new Dimension(d.width * 1 / 8, Mn_corr.getPreferredSize().height));
		Mn_Emp.setHorizontalAlignment(SwingConstants.CENTER);
		Mn_Emp.setFont(new Font("휴먼매직체", Font.BOLD, 25));
		Mn_Emp.addMouseListener(this);

		Emp_look.setBackground(new Color(255, 255, 255));
		Emp_look.setHorizontalAlignment(SwingConstants.TRAILING);
		Emp_look.setFont(new Font("맑은 고딕", Font.BOLD, 20));

		Emp_regist.setBackground(new Color(255, 255, 255));
		Emp_regist.setHorizontalAlignment(SwingConstants.TRAILING);
		Emp_regist.setFont(new Font("맑은 고딕", Font.BOLD, 20));

		Emp_modify.setBackground(new Color(255, 255, 255));
		Emp_modify.setHorizontalAlignment(SwingConstants.TRAILING);
		Emp_modify.setFont(new Font("맑은 고딕", Font.BOLD, 20));

		// 회원메뉴
		Mn_Mb.setBorder(new LineBorder(new Color(0, 0, 0)));
		Mn_Mb.setPreferredSize(new Dimension(d.width * 1 / 8, Mn_corr.getPreferredSize().height));
		Mn_Mb.setHorizontalAlignment(SwingConstants.CENTER);
		Mn_Mb.setFont(new Font("휴먼매직체", Font.BOLD, 25));
		Mn_Mb.addMouseListener(this);

		Mb_look.setBackground(new Color(255, 255, 255));
		Mb_look.setHorizontalAlignment(SwingConstants.TRAILING);
		Mb_look.setFont(new Font("맑은 고딕", Font.BOLD, 20));

		Mb_grade.setBackground(new Color(255, 255, 255));
		Mb_grade.setHorizontalAlignment(SwingConstants.TRAILING);
		Mb_grade.setFont(new Font("맑은 고딕", Font.BOLD, 20));

		// 이벤트메뉴
		Mn_EVT.setBorder(new LineBorder(new Color(0, 0, 0)));
		Mn_EVT.setPreferredSize(new Dimension(d.width * 1 / 8, Mn_corr.getPreferredSize().height));
		Mn_EVT.setHorizontalAlignment(SwingConstants.CENTER);
		Mn_EVT.setFont(new Font("휴먼매직체", Font.BOLD, 25));
		Mn_EVT.addMouseListener(this);

		EVT_look.setBackground(new Color(255, 255, 255));
		EVT_look.setHorizontalAlignment(SwingConstants.TRAILING);
		EVT_look.setFont(new Font("맑은 고딕", Font.BOLD, 20));

		EVT_regist.setBackground(new Color(255, 255, 255));
		EVT_regist.setHorizontalAlignment(SwingConstants.TRAILING);
		EVT_regist.setFont(new Font("맑은 고딕", Font.BOLD, 20));

		Mn_Post.setBorder(new LineBorder(new Color(0, 0, 0)));
		Mn_Post.setPreferredSize(new Dimension(d.width * 1 / 8, Mn_Post.getPreferredSize().height));
		Mn_Post.setHorizontalAlignment(SwingConstants.CENTER);
		Mn_Post.setFont(new Font("휴먼매직체", Font.BOLD, 25));
		Mn_Post.addMouseListener(this);

		Post_Notice.setBackground(new Color(255, 255, 255));
		Post_Notice.setHorizontalAlignment(SwingConstants.TRAILING);
		Post_Notice.setFont(new Font("맑은 고딕", Font.BOLD, 20));

		Post_QnA.setBackground(new Color(255, 255, 255));
		Post_QnA.setHorizontalAlignment(SwingConstants.TRAILING);
		Post_QnA.setFont(new Font("맑은 고딕", Font.BOLD, 20));

		Post_Nomal.setBackground(new Color(255, 255, 255));
		Post_Nomal.setHorizontalAlignment(SwingConstants.TRAILING);
		Post_Nomal.setFont(new Font("맑은 고딕", Font.BOLD, 20));

		Close.setBorder(new LineBorder(new Color(0, 0, 0)));
		Close.setPreferredSize(new Dimension(d.width * 1 / 8, Mn_Post.getPreferredSize().height));
		Close.setHorizontalAlignment(SwingConstants.CENTER);
		Close.setFont(new Font("휴먼매직체", Font.BOLD, 25));
		Close.addMouseListener(this);

//         try {
//            img = ImageIO.read(new File("C:\\Users\\kibum\\Desktop\\메인 배경.png"));
//         } catch (IOException e) {
//            JOptionPane.showMessageDialog(null, "이미지 불러오기 실패");
//            System.exit(0);
//         }

		BackgroundPanel sub = new BackgroundPanel();
		sub.setSize(d.width, d.height - 40);
		add(sub);
		setLayout(null);

		add(MenuBar);
//         add(Close);

		setResizable(false);
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

	class BackgroundPanel extends JPanel {
		public void paint(Graphics g) {
			g.drawImage(img, 0, 40, d.width, d.height, null);
			setOpaque(true);
		}
	}

	public static void main(String[] args) {

		JFrame win = new manager_main();

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == corr_look) {
			getContentPane().removeAll();
			JPanel Pcorr_look = new corr_look();
			add(MenuBar);
			Dimension d = getSize();
			Pcorr_look.setBounds(0, 40, d.width, d.height);
			add(Pcorr_look);
			repaint();
			revalidate();
		} else if (e.getSource() == corr_regist) {
			getContentPane().removeAll();
			JPanel Pcorr_regist = new corr_regist();
			add(MenuBar);
			Dimension d = getSize();
			Pcorr_regist.setBounds(0, 40, d.width, d.height);
			add(Pcorr_regist);
			repaint();
			revalidate();
		}
		//
		else if (e.getSource() == model_look) {
			getContentPane().removeAll();
			JPanel Pmodel_look = new ManModel();
			add(MenuBar);
			Dimension d = getSize();
			Pmodel_look.setBounds(0, 40, d.width, d.height);
			add(Pmodel_look);
			repaint();
			revalidate();
		} else if (e.getSource() == model_regist) {
			getContentPane().removeAll();
			JPanel Pmodel_regist = new RegModel();
			add(MenuBar);
			Dimension d = getSize();
			Pmodel_regist.setBounds(0, 40, d.width, d.height);
			add(Pmodel_regist);
			repaint();
			revalidate();
		} else if (e.getSource() == pro_look) {
			getContentPane().removeAll();
			JPanel Ppro_look = new ManPro();
			add(MenuBar);
			Dimension d = getSize();
			Ppro_look.setBounds(0, 40, d.width, d.height);
			add(Ppro_look);
			repaint();
			revalidate();
		} else if (e.getSource() == pro_regist) {
			getContentPane().removeAll();
//              JPanel Ppro_regist = new RegPro();
			add(MenuBar);
			Dimension d = getSize();
//              Ppro_regist.setBounds(0, 40, d.width, d.height);
//              add(Ppro_regist);
			repaint();
			revalidate();
		} else if (e.getSource() == pro_up_rec) {
			getContentPane().removeAll();
			JPanel Ppro_up_rec = new RegProPrice();
			add(MenuBar);
			Dimension d = getSize();
			Ppro_up_rec.setBounds(0, 40, d.width, d.height);
			add(Ppro_up_rec);
			repaint();
			revalidate();
		} else if (e.getSource() == Od_list) {
			getContentPane().removeAll();
			JPanel POd_deposit = new od_list_no_deposit();
			add(MenuBar);
			Dimension d = getSize();
			POd_deposit.setBounds(0, 40, d.width, d.height);
			add(POd_deposit);
			repaint();
			revalidate();
		} else if (e.getSource() == Od_deli) {
			getContentPane().removeAll();
			JPanel POd_pre = new od_list_pre_pro();
			add(MenuBar);
			Dimension d = getSize();
			POd_pre.setBounds(0, 40, d.width, d.height);
			add(POd_pre);
			repaint();
			revalidate();
		} else if (e.getSource() == Od_change) {
			getContentPane().removeAll();
			JPanel POd_change = new od_list_change();
			add(MenuBar);
			Dimension d = getSize();
			POd_change.setBounds(0, 40, d.width, d.height);
			add(POd_change);
			repaint();
			revalidate();
		} else if (e.getSource() == Od_refund) {
			getContentPane().removeAll();
			JPanel POd_refund = new od_list_od_refund();
			add(MenuBar);
			Dimension d = getSize();
			POd_refund.setBounds(0, 40, d.width, d.height);
			add(POd_refund);
			repaint();
			revalidate();
		} else if (e.getSource() == Emp_look) {
			getContentPane().removeAll();
			JPanel PEmp_look = new emp_look();
			add(MenuBar);
			Dimension d = getSize();
			PEmp_look.setBounds(0, 40, d.width, d.height);
			add(PEmp_look);
			repaint();
			revalidate();
		} else if (e.getSource() == Emp_regist) {
			getContentPane().removeAll();
			JPanel PEmp_regist = new emp_re();
			add(MenuBar);
			Dimension d = getSize();
			PEmp_regist.setBounds(0, 40, d.width, d.height);
			add(PEmp_regist);
			repaint();
			revalidate();
		} else if (e.getSource() == Emp_modify) {
			getContentPane().removeAll();
			JPanel PEmp_regist = new emp_modify();
			add(MenuBar);
			Dimension d = getSize();
			PEmp_regist.setBounds(0, 40, d.width, d.height);
			add(PEmp_regist);
			repaint();
			revalidate();
		} else if (e.getSource() == Mb_look) {
			getContentPane().removeAll();
			JPanel PMb_look = new mb_look();
			add(MenuBar);
			Dimension d = getSize();
			PMb_look.setBounds(0, 40, d.width, d.height);
			add(PMb_look);
			repaint();
			revalidate();
		} else if (e.getSource() == Mb_grade) {
			getContentPane().removeAll();
			getData1(MbgraData.MbgraS());
			getData2(MbgraData.MbgraV());
			getData3(MbgraData.MbgraF());
			JPanel PMb_gra = new mb_gra();
			add(MenuBar);
			Dimension d = getSize();
			PMb_gra.setBounds(0, 40, d.width, d.height);
			add(PMb_gra);
			repaint();
			revalidate();
		} else if (e.getSource() == EVT_look) {
			getContentPane().removeAll();
			JPanel PEvt_look = new evt_look();
			add(MenuBar);
			Dimension d = getSize();
			PEvt_look.setBounds(0, 40, d.width, d.height);
			add(PEvt_look);
			repaint();
			revalidate();
		} else if (e.getSource() == EVT_regist) {
			getContentPane().removeAll();
			JPanel PEvt_regist = new evt_regist();
			add(MenuBar);
			Dimension d = getSize();
			PEvt_regist.setBounds(0, 40, d.width, d.height);
			add(PEvt_regist);
			repaint();
			revalidate();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == Close) {
			dispose();
			JFrame win = new Login();
		} else if (e.getSource() == Mn_Post) {
			getContentPane().removeAll();
			add(MenuBar);
			Dimension d = getSize();
			Label.setBounds(100, 400, 100, d.height - 500);
			N_A.setBounds(0, 40, d.width, d.height - 100);
			add(Label);
        	add(N_A);
        	repaint();
        	revalidate();
		}else if(e.getSource() == vNotice) {
			getContentPane().removeAll();
			add(MenuBar);
			Dimension d = getSize();
			Label.setBounds(100, 400, 100, d.height - 500);
			N_A.setBounds(0, 40, d.width, d.height - 100);
			add(Label);
        	add(N_A);
        	repaint();
        	revalidate();
		} else if(e.getSource() == vQnA) {
			getContentPane().removeAll();
			System.out.println("123");
			add(MenuBar);
			Dimension d = getSize();
			Label.setBounds(100, 400, 100, d.height - 500);
			Q_A.setBounds(0, 40, d.width, d.height - 100);
			add(Label);
        	add(Q_A);
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

}