package org.CapstoneProject;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
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

public class Center_admin extends JPanel implements ActionListener, MouseListener {
	
	static JPanel C_A = new JPanel();
	static JPanel N_A = new JPanel();
	static JPanel Q_A = new JPanel();
	
	Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
	
	JMenuBar MenuBar1 = new JMenuBar();
	   
	JMenuBar MenuBar = new JMenuBar();
	JMenu Home = new JMenu(" 홈 ");
	JMenu Mn_Manage = new JMenu(" 쇼핑몰관리 ");
	JMenu Mn_Center = new JMenu(" 고객센터 ");
	JMenu Mn_Basket = new JMenu(" 장바구니 ");
	JMenu Mn_Mypage = new JMenu(" 마이페이지 ");
	JMenu Mn_Logout = new JMenu(" 로그아웃 ");
	   
	private JLabel vCenter, vSpace,vSpace2,vSpace3, vNotice, vQnA, vReview;

	private static String[] col1 = {"제목", "작성자", "작성일"}; 
	private static String[] col2 = {"제목", "작성자", "작성일"};   
	private static String[] col3 = {"제목", "작성자", "작성일"};   
	
	private static DefaultTableModel model1 = new DefaultTableModel(col1, 0){ 
		 public boolean isCellEditable(int row, int column){
			    return false;
			 }
			};      
	private static DefaultTableModel model2 = new DefaultTableModel(col2, 0){ 
		 public boolean isCellEditable(int row, int column){
			    return false;
			 }
			};      
	private static DefaultTableModel model3 = new DefaultTableModel(col3, 0){ 
		 public boolean isCellEditable(int row, int column){
			    return false;
			 }
			};    
		         
	private JTable tNotice, tQnA, tReview;
	private JScrollPane Scroll1, Scroll2, Scroll3; 
	
	static JButton  bN_More;

	private JButton bQ_More;

	private JButton bR_More;
	private JComboBox<String> CbEmail;
	
	GridBagLayout gridbaglayout;
	GridBagConstraints gridbagconstraints;
	
	public Center_admin() {
		
		gridbaglayout = new GridBagLayout();
		gridbagconstraints = new GridBagConstraints(); 
		

        Home.addMouseListener(this);
        Mn_Manage.addMouseListener(this);
        Mn_Center.addMouseListener(this);
        Mn_Basket.addMouseListener(this);
        Mn_Mypage.addMouseListener(this);
        Mn_Logout.addMouseListener(this);
        
//        bN_More.addActionListener(this);
//        bQ_More.addActionListener(this);
//        bR_More.addActionListener(this);
        
        MenuBar.add(Home);
        MenuBar.add(Mn_Manage);
        MenuBar.add(Mn_Center);
        MenuBar.add(Mn_Basket);
        MenuBar.add(Mn_Mypage);
        MenuBar.add(Mn_Logout);
        
        vCenter = new JLabel("고객 센터");
        vCenter.setSize(100, 100);
        vCenter.setFont(new Font("휴먼매직체", Font.BOLD, 30));
        
        vSpace = new JLabel("");
        vSpace.setPreferredSize(new Dimension(50, 50));
        vSpace2 = new JLabel("");
        vSpace2.setPreferredSize(new Dimension(50, 50));
        vSpace3 = new JLabel("");
        vSpace2.setPreferredSize(new Dimension(50, 50));
        
        vNotice = new JLabel("공지사항");
        vNotice.setFont(new Font("휴먼매직체", Font.BOLD, 25));
        vQnA = new JLabel("QnA");
        vQnA.setFont(new Font("휴먼매직체", Font.BOLD, 25));
        vReview = new JLabel("후기게시판");
        vReview.setFont(new Font("휴먼매직체", Font.BOLD, 25));
        
        bN_More = new JButton("더보기");
        bN_More.setFont(new Font("휴먼매직체", Font.PLAIN, 20));
        bN_More.setBorderPainted(false);
        bN_More.setContentAreaFilled(false);
        bN_More.setFocusPainted(false);
        bN_More.addActionListener(this);
        
        bQ_More = new JButton("더보기");
        bQ_More.setFont(new Font("휴먼매직체", Font.PLAIN, 20));
        bQ_More.setBorderPainted(false);
        bQ_More.setContentAreaFilled(false);
        bQ_More.setFocusPainted(false);
        bQ_More.addActionListener(this);
        
        bR_More = new JButton("더보기");
        bR_More.setFont(new Font("휴먼매직체", Font.PLAIN, 20));
        bR_More.setBorderPainted(false);
        bR_More.setContentAreaFilled(false);
        bR_More.setFocusPainted(false);
        bR_More.addActionListener(this);

		tNotice = new JTable(model1);
		Scroll1 = new JScrollPane(tNotice);
		Scroll1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		Scroll1.setPreferredSize(new Dimension(300, 300));
		
		tQnA = new JTable(model2);
		Scroll2 = new JScrollPane(tQnA);
		Scroll2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		Scroll2.setPreferredSize(new Dimension(300, 300));
		
		tReview = new JTable(model3);
		Scroll3 = new JScrollPane(tReview);
		Scroll3.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		Scroll3.setPreferredSize(new Dimension(300, 300));

		manager_mainView();
	}
	
	private void manager_mainView() {

		
		setLayout(gridbaglayout);

        

		Home.setBorder(new LineBorder(new Color(0, 0, 0)));
		Home.setHorizontalAlignment(SwingConstants.CENTER);
		Home.setFont(new Font("휴먼매직체", Font.BOLD, 25));
		Mn_Manage.setBorder(new LineBorder(new Color(0, 0, 0)));
		Mn_Manage.setHorizontalAlignment(SwingConstants.CENTER);
		Mn_Manage.setFont(new Font("휴먼매직체", Font.BOLD, 25));
		Mn_Center.setBorder(new LineBorder(new Color(0, 0, 0)));
		Mn_Center.setHorizontalAlignment(SwingConstants.CENTER);
		Mn_Center.setFont(new Font("휴먼매직체", Font.BOLD, 25));
		Mn_Basket.setBorder(new LineBorder(new Color(0, 0, 0)));
		Mn_Basket.setHorizontalAlignment(SwingConstants.CENTER);
		Mn_Basket.setFont(new Font("휴먼매직체", Font.BOLD, 25));
		Mn_Mypage.setBorder(new LineBorder(new Color(0, 0, 0)));
		Mn_Mypage.setHorizontalAlignment(SwingConstants.CENTER);
		Mn_Mypage.setFont(new Font("휴먼매직체", Font.BOLD, 25));
		Mn_Logout.setBorder(new LineBorder(new Color(0, 0, 0)));
		Mn_Logout.setHorizontalAlignment(SwingConstants.CENTER);
		Mn_Logout.setFont(new Font("휴먼매직체", Font.BOLD, 25));
		

		gridbagconstraints.anchor = GridBagConstraints.WEST;
//		gridbagAdd(MenuBar, 0, 0, 7, 1);
		
		gridbagAdd(vCenter, 0, 0, 1, 1);
		gridbagAdd(vSpace3, 0, 1, 1, 1);
		gridbagAdd(vNotice, 0, 2, 1, 1);
		gridbagAdd(vQnA, 2, 2, 1, 1);
		gridbagAdd(vReview, 4, 2, 1, 1);
		
	    gridbagAdd(Scroll1, 0, 3, 1, 1);
	    
		gridbagconstraints.anchor = GridBagConstraints.CENTER;
		gridbagAdd(vSpace, 1, 2, 1, 1);
	    gridbagAdd(Scroll2, 2, 3, 1, 1);
		gridbagAdd(vSpace2, 3, 2, 1, 1);
	    

		gridbagconstraints.anchor = GridBagConstraints.EAST;
		gridbagAdd(bN_More, 0, 2, 1, 1);
		gridbagAdd(bQ_More, 2, 2, 1, 1);
		gridbagAdd(bR_More, 4, 2, 1, 1);
		
	    gridbagAdd(Scroll3, 4, 3, 1, 1);
	    
	    
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
		new Center_admin(); 
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
		if (e.getSource() == bN_More) {
			 switch (manager_main.click) {
	            case "H":	manager_main.C_A.removeAll();
	            			N_A = new Notice_admin();
	            			N_A.setBounds(0, 100, d.width, d.height - 100);
	        				add(N_A);
	        				repaint();
			        		revalidate();
			        		break;
	            case "N":	Notice_admin.C_A.removeAll();
			    			N_A = new Notice_admin();
			    			N_A.setBounds(0, 100, d.width, d.height - 100);
							add(N_A);
							repaint();
			        		revalidate();
			        		break;
	            case "Q":	QnA_admin.C_A.removeAll();
			    			N_A = new Notice_admin();
			    			N_A.setBounds(0, 100, d.width, d.height - 100);
							add(N_A);
							repaint();
			        		revalidate();
			        		break;
	            default: 
               			break;
			 }
       	
		} else 	if (e.getSource() == bQ_More) {
			
			 switch (manager_main.click) {
	            case "H":	manager_main.C_A.removeAll();
			    			Q_A = new QnA_admin();
			    			Q_A.setBounds(0, 100, d.width, d.height - 100);
							add(Q_A);
							repaint();
			        		revalidate();
			        		break;
			    case "N":	Notice_admin.C_A.removeAll();
			    			Q_A = new QnA_admin();
			    			Q_A.setBounds(0, 100, d.width, d.height - 100);
							add(Q_A);
							repaint();
			        		revalidate();
			        		break;
			    case "Q":	QnA_admin.C_A.removeAll();
			    			Q_A = new QnA_admin();
			    			Q_A.setBounds(0, 100, d.width, d.height - 100);
							add(Q_A);
							repaint();
			        		revalidate();
			        		break;
	            default: 
            			break;
			 }
       	
		}
	}
}