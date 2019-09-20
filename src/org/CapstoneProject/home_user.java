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
   
   Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
   
   static JPanel menu_a = new JPanel();
   static JPanel menu_b = new JPanel();
   
   JMenuBar MenuBar1 = new JMenuBar();
   JMenu Home = new JMenu(" Ȩ ");
   JMenu Mn_Center = new JMenu(" ������ ");
   JMenu Mn_Basket = new JMenu(" ��ٱ��� ");
   JMenu Mn_Mypage = new JMenu(" ���������� ");
   JMenu Mn_Logout = new JMenu(" �α׾ƿ� ");
      
   JMenuBar MenuBar2 = new JMenuBar();
   //���� �޴�
   JMenu Mn_Top = new JMenu("    ����    ");
   JMenuItem Top_1 = new JMenuItem("������        ");
   JMenuItem Top_2 = new JMenuItem("����T");
   JMenuItem Top_3 = new JMenuItem("����T");
   JMenuItem Top_4 = new JMenuItem("�ĵ�");
   JMenuItem Top_5 = new JMenuItem("��Ʈ ");
   //���� �޴�
   JMenu Mn_Bottom = new JMenu("    ����    ");
   JMenuItem Bot_1 = new JMenuItem("û����        ");
   JMenuItem Bot_2 = new JMenuItem("������  ");
   JMenuItem Bot_3 = new JMenuItem("�����  ");
   JMenuItem Bot_4 = new JMenuItem("���  ");
   JMenuItem Bot_5 = new JMenuItem("�ݹ���  ");
   
   //�ƿ��� �޴�
   JMenu Mn_Outter = new JMenu("    �ƿ���    ");
   JMenuItem Out_1 = new JMenuItem("�����            ");
   JMenuItem Out_2 = new JMenuItem("��Ʈ  ");
   JMenuItem Out_3 = new JMenuItem("����  ");
   JMenuItem Out_4 = new JMenuItem("����  ");
   JMenuItem Out_5 = new JMenuItem("����  ");
   JMenuItem Out_6 = new JMenuItem("�е�  ");
   JMenuItem Out_7 = new JMenuItem("�߻�  ");
   JMenuItem Out_8 = new JMenuItem("��Ŷ  ");
   //���� �޴�
   JMenu Mn_Shirts = new JMenu("    ����    ");
   JMenuItem Sht_1 = new JMenuItem("��Ʈ������");
   JMenuItem Sht_2 = new JMenuItem("üũ  ");
   JMenuItem Sht_3 = new JMenuItem("����  ");
   JMenuItem Sht_4 = new JMenuItem("����  ");
   //�Ź� �޴�
   JMenu Mn_Shoose = new JMenu("    �Ź�    ");
   JMenuItem Sho_1 = new JMenuItem("����Ŀ��    ");
   JMenuItem Sho_2 = new JMenuItem("�ȭ");
   JMenuItem Sho_3 = new JMenuItem("������");
   JMenuItem Sho_4 = new JMenuItem("����");
   JMenuItem Sho_5 = new JMenuItem("��Ŀ");
   JMenuItem Sho_6 = new JMenuItem("����");
   JMenuItem Sho_7 = new JMenuItem("����");
   JMenuItem Sho_8 = new JMenuItem("����");
   
   private JLabel vHomeIcon, vViewIcon, vTop, vBottom, vOuter, vShirts, vShoes, v1;
//   private JTextField xMemId, xMemName, xMemBirth, xMemPhone, xMemEmail1, xMemEmail2, xMemAddr1, xMemAddr2, xMemAddr3;
//   private JPasswordField xMemPw1, xMemPw2;
//   private String[] div = {"naver.com", "hanmail.com", "nate.com", "gmail.com", "�����Է�"};      
   private String[] col1 = {"best"};      
   private String[] col2 = {"new"};      
   
//  private String[] div = {"������", "�ӽ���", "�����"};    // ������� �޺��ڽ��� ���
   
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
      
      MenuBar2.add(Mn_Top);
      MenuBar2.add(Mn_Bottom);
      MenuBar2.add(Mn_Outter);
      MenuBar2.add(Mn_Shirts);
      MenuBar2.add(Mn_Shoose);
      
      MenuBar1.add(Home);
        MenuBar1.add(Mn_Center);
        MenuBar1.add(Mn_Basket);
        MenuBar1.add(Mn_Mypage);
        MenuBar1.add(Mn_Logout);
        
        menu_a.add(MenuBar1);
      
      menu_b.add(MenuBar2);
      
      gbl = new GridBagLayout();
      gbc = new GridBagConstraints(); 
      
      vHomeIcon = new JLabel("�̹���");
//      vHomeIcon.setPreferredSize(new Dimension(100,28));
      v1 = new JLabel("");
      v1.setPreferredSize(new Dimension(200,28));
      vCenter = new JButton("������");
      vCenter.setPreferredSize(new Dimension(200,28));
      vBasket = new JButton("��ٱ���");
      vBasket.setPreferredSize(new Dimension(200,28));
      vMypage = new JButton("����������");
      vMypage.setPreferredSize(new Dimension(200,28));
      vLogout = new JButton("�α׾ƿ�");
      vLogout.setPreferredSize(new Dimension(200,28));
      
      vViewIcon = new JLabel("�̹���");
//      vViewIcon.setPreferredSize(new Dimension(100,28));
      vTop = new JLabel("����");
      vBottom = new JLabel("����");
      vOuter = new JLabel("�ƿ���");
      vShirts = new JLabel("����");
      vShoes = new JLabel("�Ź�");

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

      setTitle("Ȩ������ ����");
      
      Home.setBorder(new LineBorder(new Color(0, 0, 0)));
      Home.setHorizontalAlignment(SwingConstants.CENTER);
      Home.setFont(new Font("�޸ո���ü", Font.BOLD, 25));
      Mn_Center.setBorder(new LineBorder(new Color(0, 0, 0)));
      Mn_Center.setHorizontalAlignment(SwingConstants.CENTER);
      Mn_Center.setFont(new Font("�޸ո���ü", Font.BOLD, 25));
      Mn_Basket.setBorder(new LineBorder(new Color(0, 0, 0)));
      Mn_Basket.setHorizontalAlignment(SwingConstants.CENTER);
      Mn_Basket.setFont(new Font("�޸ո���ü", Font.BOLD, 25));
      Mn_Mypage.setBorder(new LineBorder(new Color(0, 0, 0)));
      Mn_Mypage.setHorizontalAlignment(SwingConstants.CENTER);
      Mn_Mypage.setFont(new Font("�޸ո���ü", Font.BOLD, 25));
      Mn_Logout.setBorder(new LineBorder(new Color(0, 0, 0)));
      Mn_Logout.setHorizontalAlignment(SwingConstants.CENTER);
      Mn_Logout.setFont(new Font("�޸ո���ü", Font.BOLD, 25));
      
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
      
      gbc.anchor = GridBagConstraints.EAST;
      
      gridbagAdd(menu_a, 0, 0, 5, 1);

      gbc.anchor = GridBagConstraints.CENTER;
      
       gridbagAdd(menu_b, 1, 1, 5, 1);
//       gridbagAdd(scrollpane1, 0, 2, 5, 1);
//       gridbagAdd(scrollpane2, 0, 6, 6, 5);
       
       setVisible(true);
   }   
            
   private void gridbagAdd(Component c, int x, int y, int w, int h) {   
      
      gbc.gridx = x;
      gbc.gridy = y; 
      //���� ���� �� gridx, gridy���� 0    
      
      gbc.gridwidth  = w;
      gbc.gridheight = h;
      
      
      gbl.setConstraints(c, gbc); //������Ʈ�� ������Ʈ ��ġ+ũ�� ������ ���� GridBagLayout�� ��ġ   
      
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

   
         