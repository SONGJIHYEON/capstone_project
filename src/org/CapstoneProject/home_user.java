package org.CapstoneProject;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.TextField;

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


public class home_user extends JFrame {
    static JPanel menu_b = new JPanel();
      
      JMenuBar MenuBar = new JMenuBar();
      //상의 메뉴
      JMenu Mn_Top = new JMenu("    상의    ");
      JMenuItem Top_1 = new JMenuItem("맨투맨        ");
      JMenuItem Top_2 = new JMenuItem("반팔T");
      JMenuItem Top_3 = new JMenuItem("긴팔T");
      JMenuItem Top_4 = new JMenuItem("후드");
      JMenuItem Top_5 = new JMenuItem("니트 ");
      //하의 메뉴
      JMenu Mn_Bottom = new JMenu("    하의    ");
      JMenuItem Bot_1 = new JMenuItem("청바지        ");
      JMenuItem Bot_2 = new JMenuItem("슬랙스  ");
      JMenuItem Bot_3 = new JMenuItem("면바지  ");
      JMenuItem Bot_4 = new JMenuItem("운동복  ");
      JMenuItem Bot_5 = new JMenuItem("반바지  ");
      
      //아우터 메뉴
      JMenu Mn_Outter = new JMenu("    아우터    ");
      JMenuItem Out_1 = new JMenuItem("가디건            ");
      JMenuItem Out_2 = new JMenuItem("코트  ");
      JMenuItem Out_3 = new JMenuItem("조끼  ");
      JMenuItem Out_4 = new JMenuItem("집업  ");
      JMenuItem Out_5 = new JMenuItem("점퍼  ");
      JMenuItem Out_6 = new JMenuItem("패딩  ");
      JMenuItem Out_7 = new JMenuItem("야상  ");
      JMenuItem Out_8 = new JMenuItem("재킷  ");
      //셔츠 메뉴
      JMenu Mn_Shirts = new JMenu("    셔츠    ");
      JMenuItem Sht_1 = new JMenuItem("스트라이프");
      JMenuItem Sht_2 = new JMenuItem("체크  ");
      JMenuItem Sht_3 = new JMenuItem("긴팔  ");
      JMenuItem Sht_4 = new JMenuItem("반팔  ");
      //신발 메뉴
      JMenu Mn_Shoose = new JMenu("    신발    ");
      JMenuItem Sho_1 = new JMenuItem("스니커즈    ");
      JMenuItem Sho_2 = new JMenuItem("운동화");
      JMenuItem Sho_3 = new JMenuItem("슬리퍼");
      JMenuItem Sho_4 = new JMenuItem("구두");
      JMenuItem Sho_5 = new JMenuItem("워커");
      JMenuItem Sho_6 = new JMenuItem("부츠");
      JMenuItem Sho_7 = new JMenuItem("샌들");
      JMenuItem Sho_8 = new JMenuItem("로퍼");
   
   private JLabel vHomeIcon, vViewIcon, vTop, vBottom, vOuter, vShirts, vShoes, v1;
//   private JTextField xMemId, xMemName, xMemBirth, xMemPhone, xMemEmail1, xMemEmail2, xMemAddr1, xMemAddr2, xMemAddr3;
//   private JPasswordField xMemPw1, xMemPw2;
//   private String[] div = {"naver.com", "hanmail.com", "nate.com", "gmail.com", "직접입력"};      
   private String[] col1 = {"best"};      
   private String[] col2 = {"new"};      
   
//  private String[] div = {"정규직", "임시직", "계약직"};    // 사원구분 콤보박스의 목록
   
   private DefaultTableModel model1 = new DefaultTableModel(col1, 0);      
   private DefaultTableModel model2 = new DefaultTableModel(col2, 0);      
   private JTable tBest, tNew;      
   private JScrollPane scrollpane1, scrollpane2;   
   private JButton  vManage, vCenter, vBasket, vMypage, vLogout;
   private JComboBox<String> CbEmail;
   
   GridBagLayout gbl;
   GridBagConstraints gbc;
   
   public home_user() {
      
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
      
      MenuBar.add(Mn_Top);
      MenuBar.add(Mn_Bottom);
      MenuBar.add(Mn_Outter);
      MenuBar.add(Mn_Shirts);
      MenuBar.add(Mn_Shoose);
      
      menu_b.add(MenuBar);
      
      gbl = new GridBagLayout();
      gbc = new GridBagConstraints(); 
      
      vHomeIcon = new JLabel("이미지");
//      vHomeIcon.setPreferredSize(new Dimension(100,28));
      v1 = new JLabel("");
      v1.setPreferredSize(new Dimension(200,28));
      vCenter = new JButton("고객센터");
      vCenter.setPreferredSize(new Dimension(200,28));
      vBasket = new JButton("장바구니");
      vBasket.setPreferredSize(new Dimension(200,28));
      vMypage = new JButton("마이페이지");
      vMypage.setPreferredSize(new Dimension(200,28));
      vLogout = new JButton("로그아웃");
      vLogout.setPreferredSize(new Dimension(200,28));
      
      vViewIcon = new JLabel("이미지");
//      vViewIcon.setPreferredSize(new Dimension(100,28));
      vTop = new JLabel("상의");
      vBottom = new JLabel("하의");
      vOuter = new JLabel("아우터");
      vShirts = new JLabel("셔츠");
      vShoes = new JLabel("신발");

      tBest = new JTable(model1);
      scrollpane1 = new JScrollPane(tBest);
      scrollpane1.setPreferredSize(new Dimension(1000, 100));
      
      tNew = new JTable(model2);
      scrollpane2 = new JScrollPane(tNew);
      scrollpane2.setPreferredSize(new Dimension(1000, 100));
      setExtendedState(MAXIMIZED_BOTH);
      home_userView();

   }
   
   private void home_userView() {

      setTitle("홈페이지 유저");
      
      Mn_Top.setBorder(new LineBorder(new Color(0, 0, 0)));
      Mn_Top.setHorizontalAlignment(SwingConstants.CENTER);
      Mn_Top.setFont(new Font("", Font.BOLD, 20));
      
      Top_1.setBackground(new Color(255, 255, 255));
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
      Mn_Bottom.setHorizontalAlignment(SwingConstants.CENTER);
      Mn_Bottom.setFont(new Font(" ", Font.BOLD, 20));
      
      Bot_1.setBackground(new Color(255, 255, 255));
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
      Mn_Outter.setHorizontalAlignment(SwingConstants.CENTER);
      Mn_Outter.setFont(new Font(" ", Font.BOLD, 20));
      
      Out_1.setBackground(new Color(255, 255, 255));
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
      Mn_Shirts.setHorizontalAlignment(SwingConstants.CENTER);
      Mn_Shirts.setFont(new Font(" ", Font.BOLD, 20));
      
      Sht_1.setBackground(new Color(255, 255, 255));
      Sht_1.setFont(new Font("", Font.BOLD, 15));

      Sht_2.setBackground(new Color(255, 255, 255));
      Sht_2.setFont(new Font("  ", Font.BOLD, 15));
      
      Sht_3.setBackground(new Color(255, 255, 255));
      Sht_3.setFont(new Font("  ", Font.BOLD, 15));
      
      Sht_4.setBackground(new Color(255, 255, 255));
      Sht_4.setFont(new Font("  ", Font.BOLD, 15));
      
      Mn_Shoose.setBorder(new LineBorder(new Color(0, 0, 0)));
      Mn_Shoose.setHorizontalAlignment(SwingConstants.CENTER);
      Mn_Shoose.setFont(new Font(" ", Font.BOLD, 20));
      
      Sho_1.setBackground(new Color(255, 255, 255));
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

      setLayout(gbl);
      
      gridbagAdd(vHomeIcon, 0, 0, 1, 1);
      gridbagAdd(v1, 1, 0, 1, 1);
       gridbagAdd(vCenter, 2, 0, 1, 1);
       gridbagAdd(vBasket, 3, 0, 1, 1);
       gridbagAdd(vMypage, 4, 0, 1, 1);
       gridbagAdd(vLogout, 5, 0, 1, 1);
       gridbagAdd(vViewIcon, 0, 1, 1, 1);
       
//       add(MenuBar);
       gridbagAdd(menu_b, 1, 1, 5, 1);
       
//       gridbagAdd(vTop, 1, 1, 1, 1);
//       gridbagAdd(vBottom, 2, 1, 1, 1);
//       gridbagAdd(vOuter, 3, 1, 1, 1);
//       gridbagAdd(vShirts, 4, 1, 1, 1);
//       gridbagAdd(vShoes, 5, 1, 1, 1);
            
//       gridbagAdd(scrollpane1, 1, 2, 5, 1);
//       gridbagAdd(scrollpane2, 1, 6, 6, 1);
//       gridbagAdd(regist, 0, 12, 1, 1);
//       gridbagAdd(cancel, 2, 12, 1, 1);
       
//        setLayout(null);
       setVisible(true);
   }   
            
   private void gridbagAdd(Component c, int x, int y, int w, int h) {   
      
      gbc.gridx = x;
      gbc.gridy = y; 
      //가장 왼쪽 위 gridx, gridy값은 0    
      
      gbc.gridwidth  = w;
      gbc.gridheight = h;
      
      
      gbl.setConstraints(c, gbc); //컴포넌트를 컴포넌트 위치+크기 정보에 따라 GridBagLayout에 배치   
      
      add(c);   
      
   }   
   
   public static void main(String[] args) {   
      new home_user();
//      JPanel mainimg = new MainProImg();
//        mainimg.setBounds(0, 0, 1920, 40);
//        add(mainimg);
//        Dimension d = getSize();
//        mainimg.setBounds(0, 40, d.width, d.height);
//        add(mainimg);
//        repaint();
//        revalidate();

   }   
}   

   
         