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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import org.CapstoneProject.RegPro;

public class manager_main extends JFrame implements ActionListener {
   
   static JPanel menu_b = new JPanel();
   
   JMenuBar MenuBar = new JMenuBar();
   //거래처 메뉴
   JMenu Mn_corr = new JMenu("  거래처  ");
   JMenuItem corr_look = new JMenuItem("거래처조회");
   JMenuItem corr_regist = new JMenuItem("거래처등록");
   //상품 메뉴
   JMenu Mn_pro = new JMenu("  상품  ");
   //주문 메뉴
   JMenu Mn_Od = new JMenu("  주문  ");
   JMenuItem Od_deposit = new JMenuItem("통장미입금");
   JMenuItem Od_pre = new JMenuItem("상품준비중");
   JMenuItem Od_change = new JMenuItem("교환    ");
   JMenuItem Od_refund = new JMenuItem("환불    ");
   JMenuItem Od_cancel = new JMenuItem("취소    ");
   //사원 메뉴
   JMenu Mn_Emp = new JMenu("  사원  ");
   JMenuItem Emp_look = new JMenuItem("사원조회");
   JMenuItem Emp_regist = new JMenuItem("사원등록");
   //회원 메뉴
   JMenu Mn_Mb = new JMenu("  회원  ");
   JMenuItem Mb_look = new JMenuItem("회원조회");
   JMenuItem Mb_grade = new JMenuItem("등급관리");
   //이벤트
   JMenu Mn_EVT = new JMenu("  이벤트  ");
   JMenuItem EVT_look = new JMenuItem("이벤트조회");
   JMenuItem EVT_regist = new JMenuItem("이벤트등록");
   
   BufferedImage img = null;
   
   
   GridBagLayout gridbaglayout;      
   GridBagConstraints gridbagconstraints;      // gridbag레이아웃에 컴포넌트의 위치를 잡아주는 역할
         
   public manager_main() {      
	   
         gridbaglayout = new GridBagLayout();
         gridbagconstraints = new GridBagConstraints();
         

         corr_look.addActionListener(this);
         corr_regist.addActionListener(this);
         Od_deposit.addActionListener(this);
         Od_pre.addActionListener(this);
         Od_change.addActionListener(this);
         Od_refund.addActionListener(this);
         Od_cancel.addActionListener(this);
         Emp_look.addActionListener(this);
         Emp_regist.addActionListener(this);
         Mb_look.addActionListener(this);
         Mb_grade.addActionListener(this);
         EVT_look.addActionListener(this);
         EVT_regist.addActionListener(this);

         Mn_corr.add(corr_look);
         Mn_corr.add(corr_regist);

         Mn_Od.add(Od_deposit);
         Mn_Od.add(Od_pre);
         Mn_Od.add(Od_change);
         Mn_Od.add(Od_refund);
         Mn_Od.add(Od_cancel);
         
         Mn_Emp.add(Emp_look);
         Mn_Emp.add(Emp_regist);
         
         Mn_Mb.add(Mb_look);
         Mn_Mb.add(Mb_grade);
         
         Mn_EVT.add(EVT_look);
         Mn_EVT.add(EVT_regist);
         
         MenuBar.add(Mn_corr);
         MenuBar.add(Mn_pro);
         MenuBar.add(Mn_Od);
         MenuBar.add(Mn_Emp);
         MenuBar.add(Mn_Mb);
         MenuBar.add(Mn_EVT);
         
         menu_b.add(MenuBar);
         
         
         
//         getDeptData(EmpData.selectDept());
//         getSvpData(EmpData.selectSpv());
         setExtendedState(MAXIMIZED_BOTH);
         EmpRegisterView();
      }   
         
   private void EmpRegisterView() {      
         
         setTitle("관리자 메인화면");
         //크기설정
         //거래처 메뉴
         MenuBar.setBounds(0, 0, 1920, 40);
         Mn_corr.setBorder(new LineBorder(new Color(0, 0, 0)));
         Mn_corr.setHorizontalAlignment(SwingConstants.CENTER);
         Mn_corr.setFont(new Font("맑은 고딕", Font.BOLD, 25));

         corr_look.setBackground(new Color(255, 255, 255));
         corr_look.setHorizontalAlignment(SwingConstants.TRAILING);
         corr_look.setFont(new Font("맑은 고딕", Font.BOLD, 20));

         corr_regist.setBackground(new Color(255, 255, 255));
         corr_regist.setHorizontalAlignment(SwingConstants.TRAILING);
         corr_regist.setFont(new Font("맑은 고딕", Font.BOLD, 20));
         
         //상품메뉴
         Mn_pro.setBorder(new LineBorder(new Color(0, 0, 0)));
         Mn_pro.setHorizontalAlignment(SwingConstants.CENTER);
         Mn_pro.setFont(new Font("맑은 고딕", Font.BOLD, 25));
         
         //주문 메뉴
         Mn_Od.setBorder(new LineBorder(new Color(0, 0, 0)));
         Mn_Od.setHorizontalAlignment(SwingConstants.CENTER);
         Mn_Od.setFont(new Font("맑은 고딕", Font.BOLD, 25));

         Od_deposit.setBackground(new Color(255, 255, 255));
         Od_deposit.setHorizontalAlignment(SwingConstants.TRAILING);
         Od_deposit.setFont(new Font("맑은 고딕", Font.BOLD, 20));

         Od_pre.setBackground(new Color(255, 255, 255));
         Od_pre.setHorizontalAlignment(SwingConstants.TRAILING);
         Od_pre.setFont(new Font("맑은 고딕", Font.BOLD, 20));

         Od_change.setBackground(new Color(255, 255, 255));
         Od_change.setHorizontalAlignment(SwingConstants.TRAILING);
         Od_change.setFont(new Font("맑은 고딕", Font.BOLD, 20));

         Od_refund.setBackground(new Color(255, 255, 255));
         Od_refund.setHorizontalAlignment(SwingConstants.TRAILING);
         Od_refund.setFont(new Font("맑은 고딕", Font.BOLD, 20));

         Od_cancel.setBackground(new Color(255, 255, 255));
         Od_cancel.setHorizontalAlignment(SwingConstants.TRAILING);
         Od_cancel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
         
         //사원메뉴
         Mn_Emp.setBorder(new LineBorder(new Color(0, 0, 0)));
         Mn_Emp.setHorizontalAlignment(SwingConstants.CENTER);
         Mn_Emp.setFont(new Font("맑은 고딕", Font.BOLD, 25));

         Emp_look.setBackground(new Color(255, 255, 255)); 
         Emp_look.setHorizontalAlignment(SwingConstants.TRAILING);
         Emp_look.setFont(new Font("맑은 고딕", Font.BOLD, 20));

         Emp_regist.setBackground(new Color(255, 255, 255));
         Emp_regist.setHorizontalAlignment(SwingConstants.TRAILING);
         Emp_regist.setFont(new Font("맑은 고딕", Font.BOLD, 20));
         
         //회원메뉴
         Mn_Mb.setBorder(new LineBorder(new Color(0, 0, 0)));
         Mn_Mb.setHorizontalAlignment(SwingConstants.CENTER);
         Mn_Mb.setFont(new Font("맑은 고딕", Font.BOLD, 25));

         Mb_look.setBackground(new Color(255, 255, 255));
         Mb_look.setHorizontalAlignment(SwingConstants.TRAILING);
         Mb_look.setFont(new Font("맑은 고딕", Font.BOLD, 20));

         Mb_grade.setBackground(new Color(255, 255, 255));
         Mb_grade.setHorizontalAlignment(SwingConstants.TRAILING);
         Mb_grade.setFont(new Font("맑은 고딕", Font.BOLD, 20));
         
         //이벤트메뉴
         Mn_EVT.setBorder(new LineBorder(new Color(0, 0, 0)));
         Mn_EVT.setHorizontalAlignment(SwingConstants.CENTER);
         Mn_EVT.setFont(new Font("맑은 고딕", Font.BOLD, 25));

         EVT_look.setBackground(new Color(255, 255, 255));
         EVT_look.setHorizontalAlignment(SwingConstants.TRAILING);
         EVT_look.setFont(new Font("맑은 고딕", Font.BOLD, 20));

         EVT_regist.setBackground(new Color(255, 255, 255));
         EVT_regist.setHorizontalAlignment(SwingConstants.TRAILING);
         EVT_regist.setFont(new Font("맑은 고딕", Font.BOLD, 20));
         
//         try {
//        	 img = ImageIO.read(new File("C:\\Users\\kimkibum\\Desktop\\관리자 메인.jpg"));
//         } catch (IOException e) {
//        	 JOptionPane.showMessageDialog(null, "이미지 불러오기 실패");
//        	 System.exit(0);
//         }
         BackgroundPanel sub = new BackgroundPanel();
         sub.setSize(1377, 840);
         add(sub);
         setLayout(null);
         
         add(MenuBar);
        
         setResizable(false);
         setVisible(true);
      }   
         
      private void gridbagAdd(Component c, int x, int y, int w, int h) {   
         
         gridbagconstraints.gridx = x;
         gridbagconstraints.gridy = y; 
            //가장 왼쪽 위 gridx, gridy값은 0    
         
         gridbagconstraints.gridwidth  = w;
         gridbagconstraints.gridheight = h;
              
               
          gridbaglayout.setConstraints(c, gridbagconstraints); //컴포넌트를 컴포넌트 위치+크기 정보에 따라 GridBagLayout에 배치   
         
         add(c);   
         
         }
      class BackgroundPanel extends JPanel{
	      public void paint(Graphics g) {
	    	  Dimension d = getSize();
	    	  g.drawImage(img, 0, 40, d.width, d.height, null);
	    	  setOpaque(true);
	      }
      }
      public static void main(String[] args) {
        	  
    	  JFrame win = new manager_main();
    	  
      }
      

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == corr_look){
        	getContentPane().removeAll();
        	JPanel Pcorr_look = new corr_look();
        	MenuBar.setBounds(0, 0, 1920, 40);
        	add(MenuBar);
        	Dimension d = getSize();
        	Pcorr_look.setBounds(0, 40, d.width, d.height);
        	add(Pcorr_look);
        	repaint();
        	revalidate();
        }
		else if(e.getSource() == corr_regist){
        	getContentPane().removeAll();
        	JPanel Pcorr_regist = new corr_regist();
        	MenuBar.setBounds(0, 0, 1920, 40);
        	add(MenuBar);
        	Dimension d = getSize();
        	Pcorr_regist.setBounds(0, 40, d.width, d.height);
        	add(Pcorr_regist);
        	repaint();
        	revalidate();
        }
		else if(e.getSource() == Od_deposit){
			getContentPane().removeAll();
        	JPanel POd_deposit = new od_list_no_deposit();
        	MenuBar.setBounds(0, 0, 1920, 40);
        	add(MenuBar);
        	Dimension d = getSize();
        	POd_deposit.setBounds(0, 40, d.width, d.height);
        	add(POd_deposit);
        	repaint();
        	revalidate();
        } 
		else if(e.getSource() == Od_pre){
			getContentPane().removeAll();
        	JPanel POd_pre = new od_list_pre_pro();
        	MenuBar.setBounds(0, 0, 1920, 40);
        	add(MenuBar);
        	Dimension d = getSize();
        	POd_pre.setBounds(0, 40, d.width, d.height);
        	add(POd_pre);
        	repaint();
        	revalidate();
        }
		else if(e.getSource() == Od_change){
			getContentPane().removeAll();
        	JPanel POd_change = new od_list_change();
        	MenuBar.setBounds(0, 0, 1920, 40);
        	add(MenuBar);
        	Dimension d = getSize();
        	POd_change.setBounds(0, 40, d.width, d.height);
        	add(POd_change);
        	repaint();
        	revalidate();
        }
		else if(e.getSource() == Od_refund){
			getContentPane().removeAll();
        	JPanel POd_refund = new od_list_od_refund();
        	MenuBar.setBounds(0, 0, 1920, 40);
        	add(MenuBar);
        	Dimension d = getSize();
        	POd_refund.setBounds(0, 40, d.width, d.height);
        	add(POd_refund);
        	repaint();
        	revalidate();
        }
		else if(e.getSource() == Od_cancel){
			getContentPane().removeAll();
        	JPanel POd_cancel = new od_list_od_cancel();
        	MenuBar.setBounds(0, 0, 1920, 40);
        	add(MenuBar);
        	Dimension d = getSize();
        	POd_cancel.setBounds(0, 40, d.width, d.height);
        	add(POd_cancel);
        	repaint();
        	revalidate();
        }
		else if(e.getSource() == Emp_look){
			getContentPane().removeAll();
        	JPanel PEmp_look = new emp_look();
        	MenuBar.setBounds(0, 0, 1920, 40);
        	add(MenuBar);
        	Dimension d = getSize();
        	PEmp_look.setBounds(0, 40, d.width, d.height);
        	add(PEmp_look);
        	repaint();
        	revalidate();
        }
		else if(e.getSource() == Emp_regist){
			getContentPane().removeAll();
        	JPanel PEmp_regist = new emp_regist();
        	MenuBar.setBounds(0, 0, 1920, 40);
        	add(MenuBar);
        	Dimension d = getSize();
        	PEmp_regist.setBounds(0, 40, d.width, d.height);
        	add(PEmp_regist);
        	repaint();
        	revalidate();
        }else if(e.getSource() == Mb_look){
			getContentPane().removeAll();
        	JPanel PMb_look = new mb_look();
        	MenuBar.setBounds(0, 0, 1920, 40);
        	add(MenuBar);
        	Dimension d = getSize();
        	PMb_look.setBounds(0, 40, d.width, d.height);
        	add(PMb_look);
        	repaint();
        	revalidate();
        }else if(e.getSource() == Mb_grade){
			getContentPane().removeAll();
        	JPanel PMb_gra = new mb_gra();
        	MenuBar.setBounds(0, 0, 1920, 40);
        	add(MenuBar);
        	Dimension d = getSize();
        	PMb_gra.setBounds(0, 40, d.width, d.height);
        	add(PMb_gra);
        	repaint();
        	revalidate();
        }else if(e.getSource() == EVT_look){
			getContentPane().removeAll();
        	JPanel PEvt_look = new evt_look();
        	MenuBar.setBounds(0, 0, 1920, 40);
        	add(MenuBar);
        	Dimension d = getSize();
        	PEvt_look.setBounds(0, 40, d.width, d.height);
        	add(PEvt_look);
        	repaint();
        	revalidate();
        }else if(e.getSource() == EVT_regist){
			getContentPane().removeAll();
        	JPanel PEvt_regist = new evt_regist();
        	MenuBar.setBounds(0, 0, 1920, 40);
        	add(MenuBar);
        	Dimension d = getSize();
        	PEvt_regist.setBounds(0, 40, d.width, d.height);
        	add(PEvt_regist);
        	repaint();
        	revalidate();
        }
	}
         
}