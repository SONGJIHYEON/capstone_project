package org.CapstoneProject;

import java.awt.*;
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
import javax.swing.Action;
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
   
   JMenuBar MenuBar = new JMenuBar();
   //°Å·¡Ã³ ¸Þ´º
   JMenu Mn_corr = new JMenu("    °Å·¡Ã³    ");
   JMenuItem corr_look = new JMenuItem("   °Å·¡Ã³Á¶È¸  ");
   JMenuItem corr_regist = new JMenuItem("   °Å·¡Ã³µî·Ï  ");
   //»óÇ° ¸Þ´º
   JMenu Mn_pro = new JMenu("     »óÇ°     ");
   JMenuItem model_look = new JMenuItem(" ¸ðµ¨Á¶È¸  ");
   JMenuItem model_regist = new JMenuItem(" ¸ðµ¨µî·Ï  ");
   JMenuItem pro_look = new JMenuItem(" »óÇ°Á¶È¸  ");
   JMenuItem pro_regist = new JMenuItem(" »óÇ°µî·Ï  ");
   JMenuItem pro_up_rec = new JMenuItem(" »óÇ°´Ü°¡°ü¸®");
   
   //ÁÖ¹® ¸Þ´º 
   JMenu Mn_Od = new JMenu("     ÁÖ¹®     ");
   JMenuItem Od_deposit = new JMenuItem("   ÅëÀå¹ÌÀÔ±Ý ");
   JMenuItem Od_pre = new JMenuItem("   »óÇ°ÁØºñÁß ");
   JMenuItem Od_change = new JMenuItem(" ±³È¯");
   JMenuItem Od_refund = new JMenuItem(" È¯ºÒ");
   JMenuItem Od_cancel = new JMenuItem(" Ãë¼Ò");
   //»ç¿ø ¸Þ´º
   JMenu Mn_Emp = new JMenu("     »ç¿ø     ");
   JMenuItem Emp_look = new JMenuItem("    »ç¿øÁ¶È¸   ");
   JMenuItem Emp_regist = new JMenuItem("    »ç¿øµî·Ï   ");
   JMenuItem Emp_modify = new JMenuItem("    »ç¿ø¼öÁ¤   ");
   //È¸¿ø ¸Þ´º
   JMenu Mn_Mb = new JMenu("     È¸¿ø     ");
   JMenuItem Mb_look = new JMenuItem("    È¸¿øÁ¶È¸   ");
   JMenuItem Mb_grade = new JMenuItem("    µî±Þ°ü¸®   ");
   //ÀÌº¥Æ®
   
   JMenu Mn_EVT = new JMenu("    ÀÌº¥Æ®    ");
   JMenuItem EVT_look = new JMenuItem("   ÀÌº¥Æ®Á¶È¸  ");
   JMenuItem EVT_regist = new JMenuItem("   ÀÌº¥Æ®µî·Ï  ");
   
   JMenu Close = new JMenu(" ´Ý±â ");
   JMenu Home = new JMenu(" È¨ ");
   
   BufferedImage img = null;
   
//   JButton Close;
   
   
   GridBagLayout gridbaglayout;      
   GridBagConstraints gridbagconstraints;      // gridbag·¹ÀÌ¾Æ¿ô¿¡ ÄÄÆ÷³ÍÆ®ÀÇ À§Ä¡¸¦ Àâ¾ÆÁÖ´Â ¿ªÇÒ
         
   public manager_main() {      
      
         gridbaglayout = new GridBagLayout();
         gridbagconstraints = new GridBagConstraints();
         

         corr_look.addActionListener(this);
         corr_regist.addActionListener(this);
         model_look.addActionListener(this);
         model_regist.addActionListener(this);
         pro_look.addActionListener(this);
         pro_regist.addActionListener(this);
         pro_up_rec.addActionListener(this);
         Od_deposit.addActionListener(this);
         Od_pre.addActionListener(this);
         Od_change.addActionListener(this);
         Od_refund.addActionListener(this);
         Od_cancel.addActionListener(this);
         Emp_look.addActionListener(this);
         Emp_regist.addActionListener(this);
         Emp_modify.addActionListener(this);
         Mb_look.addActionListener(this);
         Mb_grade.addActionListener(this);
         EVT_look.addActionListener(this);
         EVT_regist.addActionListener(this);
         Close.addMouseListener(this);
         Home.addMouseListener(this);
         
         Mn_corr.add(corr_look);
         Mn_corr.add(corr_regist);
         
         Mn_pro.add(model_look);
         Mn_pro.add(model_regist);
         Mn_pro.add(pro_look);
         Mn_pro.add(pro_regist);
         Mn_pro.add(pro_up_rec);

         Mn_Od.add(Od_deposit);
         Mn_Od.add(Od_pre);
         Mn_Od.add(Od_change);
         Mn_Od.add(Od_refund);
         Mn_Od.add(Od_cancel);
         
         Mn_Emp.add(Emp_look);
         Mn_Emp.add(Emp_regist);
         Mn_Emp.add(Emp_modify);
         
         Mn_Mb.add(Mb_look);
         Mn_Mb.add(Mb_grade);
         
         Mn_EVT.add(EVT_look);
         Mn_EVT.add(EVT_regist);

         MenuBar.add(Home);
         MenuBar.add(Mn_corr);
         MenuBar.add(Mn_pro);
         MenuBar.add(Mn_Od);
         MenuBar.add(Mn_Emp);
         MenuBar.add(Mn_Mb);
         MenuBar.add(Mn_EVT);
         MenuBar.add(Close);
         

         MenuBar.setBounds(0, 0, 1377, 40);
         
         menu_b.add(MenuBar);
         
//         Close = new JButton("´Ý±â");
         
         
         
//         getDeptData(EmpData.selectDept());
//         getSvpData(EmpData.selectSpv());
//         setExtendedState(MAXIMIZED_BOTH);
         EmpRegisterView();
      }   
         
   private void EmpRegisterView() {      
         
         setTitle("°ü¸®ÀÚ ¸ÞÀÎÈ­¸é");
         setSize(d.width, d.height);
         //Å©±â¼³Á¤
         //°Å·¡Ã³ ¸Þ´º
         MenuBar.setBounds(0, 0, 1050, 40);
         Mn_corr.setBorder(new LineBorder(new Color(0, 0, 0)));
         Mn_corr.setHorizontalAlignment(SwingConstants.CENTER);
         Mn_corr.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 25));

         corr_look.setBackground(new Color(255, 255, 255));
         corr_look.setHorizontalAlignment(SwingConstants.TRAILING);
         corr_look.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));

         corr_regist.setBackground(new Color(255, 255, 255));
         corr_regist.setHorizontalAlignment(SwingConstants.TRAILING);
         corr_regist.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
         
         //»óÇ°¸Þ´º
         Mn_pro.setBorder(new LineBorder(new Color(0, 0, 0)));
         Mn_pro.setHorizontalAlignment(SwingConstants.CENTER);
         Mn_pro.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 25));
         
         model_look.setBackground(new Color(255, 255, 255));
         model_look.setHorizontalAlignment(SwingConstants.TRAILING);
         model_look.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
         
         model_regist.setBackground(new Color(255, 255, 255));
         model_regist.setHorizontalAlignment(SwingConstants.TRAILING);
         model_regist.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));

         pro_look.setBackground(new Color(255, 255, 255));
         pro_look.setHorizontalAlignment(SwingConstants.TRAILING);
         pro_look.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
         
         pro_regist.setBackground(new Color(255, 255, 255));
         pro_regist.setHorizontalAlignment(SwingConstants.TRAILING);
         pro_regist.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
         
         pro_up_rec.setBackground(new Color(255, 255, 255));
         pro_up_rec.setHorizontalAlignment(SwingConstants.TRAILING);
         pro_up_rec.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
         
         //ÁÖ¹® ¸Þ´º
         Mn_Od.setBorder(new LineBorder(new Color(0, 0, 0)));
         Mn_Od.setHorizontalAlignment(SwingConstants.CENTER);
         Mn_Od.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 25));

         Od_deposit.setBackground(new Color(255, 255, 255));
         Od_deposit.setHorizontalAlignment(SwingConstants.TRAILING);
         Od_deposit.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));

         Od_pre.setBackground(new Color(255, 255, 255));
         Od_pre.setHorizontalAlignment(SwingConstants.TRAILING);
         Od_pre.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));

         Od_change.setBackground(new Color(255, 255, 255));
         Od_change.setHorizontalAlignment(SwingConstants.TRAILING);
         Od_change.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
         Od_change.setHorizontalAlignment(JLabel.CENTER);
 
         Od_refund.setBackground(new Color(255, 255, 255));
         Od_refund.setHorizontalAlignment(SwingConstants.TRAILING);
         Od_refund.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
         Od_refund.setHorizontalAlignment(JLabel.CENTER);

         Od_cancel.setBackground(new Color(255, 255, 255));
         Od_cancel.setHorizontalAlignment(SwingConstants.TRAILING);
         Od_cancel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
         Od_cancel.setHorizontalAlignment(JLabel.CENTER);
         
         //»ç¿ø¸Þ´º
         Mn_Emp.setBorder(new LineBorder(new Color(0, 0, 0)));
         Mn_Emp.setHorizontalAlignment(SwingConstants.CENTER);
         Mn_Emp.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 25));

         Emp_look.setBackground(new Color(255, 255, 255)); 
         Emp_look.setHorizontalAlignment(SwingConstants.TRAILING);
         Emp_look.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));

         Emp_regist.setBackground(new Color(255, 255, 255));
         Emp_regist.setHorizontalAlignment(SwingConstants.TRAILING);
         Emp_regist.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
         
         Emp_modify.setBackground(new Color(255, 255, 255));
         Emp_modify.setHorizontalAlignment(SwingConstants.TRAILING);
         Emp_modify.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
         
         //È¸¿ø¸Þ´º
         Mn_Mb.setBorder(new LineBorder(new Color(0, 0, 0)));
         Mn_Mb.setHorizontalAlignment(SwingConstants.CENTER);
         Mn_Mb.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 25));

         Mb_look.setBackground(new Color(255, 255, 255));
         Mb_look.setHorizontalAlignment(SwingConstants.TRAILING);
         Mb_look.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));

         Mb_grade.setBackground(new Color(255, 255, 255));
         Mb_grade.setHorizontalAlignment(SwingConstants.TRAILING);
         Mb_grade.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
         
         //ÀÌº¥Æ®¸Þ´º
         Mn_EVT.setBorder(new LineBorder(new Color(0, 0, 0)));
         Mn_EVT.setHorizontalAlignment(SwingConstants.CENTER);
         Mn_EVT.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 25));

         EVT_look.setBackground(new Color(255, 255, 255));
         EVT_look.setHorizontalAlignment(SwingConstants.TRAILING);
         EVT_look.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));

         EVT_regist.setBackground(new Color(255, 255, 255));
         EVT_regist.setHorizontalAlignment(SwingConstants.TRAILING);
         EVT_regist.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
         
         Home.setBorder(new LineBorder(new Color(0, 0, 0)));
         Home.setHorizontalAlignment(SwingConstants.CENTER);
         Home.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 25));
         
         Close.setBorder(new LineBorder(new Color(0, 0, 0)));
         Close.setHorizontalAlignment(SwingConstants.CENTER);
         Close.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 25));
         
//         try {
//            img = ImageIO.read(new File("C:\\Users\\kibum\\Desktop\\¸ÞÀÎ ¹è°æ.png"));
//         } catch (IOException e) {
//            JOptionPane.showMessageDialog(null, "ÀÌ¹ÌÁö ºÒ·¯¿À±â ½ÇÆÐ");
//            System.exit(0);
//         }
         
         BackgroundPanel sub = new BackgroundPanel();
         sub.setSize(d.width, d.height-40);
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
            //°¡Àå ¿ÞÂÊ À§ gridx, gridy°ªÀº 0    
         
         gridbagconstraints.gridwidth  = w;
         gridbagconstraints.gridheight = h;
              
               
          gridbaglayout.setConstraints(c, gridbagconstraints); //ÄÄÆ÷³ÍÆ®¸¦ ÄÄÆ÷³ÍÆ® À§Ä¡+Å©±â Á¤º¸¿¡ µû¶ó GridBagLayout¿¡ ¹èÄ¡   
         
         add(c);   
         
         }
      class BackgroundPanel extends JPanel{
         public void paint(Graphics g) {
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
              add(MenuBar);
              Dimension d = getSize();
              Pcorr_regist.setBounds(0, 40, d.width, d.height);
              add(Pcorr_regist);
              repaint();
              revalidate();
           }
         //
         else if(e.getSource() == model_look){
              getContentPane().removeAll();
              JPanel Pmodel_look = new ManModel();
              add(MenuBar);
              Dimension d = getSize();
              Pmodel_look.setBounds(0, 40, d.width, d.height);
              add(Pmodel_look);
              repaint();
              revalidate();
           }
         else if(e.getSource() == model_regist){
              getContentPane().removeAll();
              JPanel Pmodel_regist = new RegModel();
              add(MenuBar);
              Dimension d = getSize();
              Pmodel_regist.setBounds(0, 40, d.width, d.height);
              add(Pmodel_regist);
              repaint();
              revalidate();
           }
         else if(e.getSource() == pro_look){
              getContentPane().removeAll();
              JPanel Ppro_look = new ManPro();
              add(MenuBar);
              Dimension d = getSize();
              Ppro_look.setBounds(0, 40, d.width, d.height);
              add(Ppro_look);
              repaint();
              revalidate();
           }
         else if(e.getSource() == pro_regist){
              getContentPane().removeAll();
//              JPanel Ppro_regist = new RegPro();
              add(MenuBar);
              Dimension d = getSize();
//              Ppro_regist.setBounds(0, 40, d.width, d.height);
//              add(Ppro_regist);
              repaint();
              revalidate();
           }
         else if(e.getSource() == pro_up_rec){
              getContentPane().removeAll();
              JPanel Ppro_up_rec = new RegProPrice();
              add(MenuBar);
              Dimension d = getSize();
              Ppro_up_rec.setBounds(0, 40, d.width, d.height);
              add(Ppro_up_rec);
              repaint();
              revalidate();
           }
         else if(e.getSource() == Od_deposit){
            getContentPane().removeAll();
              JPanel POd_deposit = new od_list_no_deposit();
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
              add(MenuBar);
              Dimension d = getSize();
              PEmp_look.setBounds(0, 40, d.width, d.height);
              add(PEmp_look);
              repaint();
              revalidate();
           }
         else if(e.getSource() == Emp_regist){
            getContentPane().removeAll();
              JPanel PEmp_regist = new emp_re();
              add(MenuBar);
              Dimension d = getSize();
              PEmp_regist.setBounds(0, 40, d.width, d.height);
              add(PEmp_regist);
              repaint();
              revalidate();
           }
         else if(e.getSource() == Emp_modify){
             getContentPane().removeAll();
               JPanel PEmp_regist = new emp_modify();
               add(MenuBar);
               Dimension d = getSize();
               PEmp_regist.setBounds(0, 40, d.width, d.height);
               add(PEmp_regist);
               repaint();
               revalidate();
            }
         else if(e.getSource() == Mb_look){
            getContentPane().removeAll();
              JPanel PMb_look = new mb_look();
              add(MenuBar);
              Dimension d = getSize();
              PMb_look.setBounds(0, 40, d.width, d.height);
              add(PMb_look);
              repaint();
              revalidate();
           }
         else if(e.getSource() == Mb_grade){
            getContentPane().removeAll();
//              JPanel PMb_gra = new mb_gra();
              add(MenuBar);
              Dimension d = getSize();
//              PMb_gra.setBounds(0, 40, d.width, d.height);
//              add(PMb_gra);
              repaint();
              revalidate();
           }
         else if(e.getSource() == EVT_look){
            getContentPane().removeAll();
              JPanel PEvt_look = new evt_look();
              add(MenuBar);
              Dimension d = getSize();
              PEvt_look.setBounds(0, 40, d.width, d.height);
              add(PEvt_look);
              repaint();
              revalidate();
           }
         else if(e.getSource() == EVT_regist){
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
      if(e.getSource() == Close){
         dispose();
        } else if(e.getSource() == Home){
           getContentPane().removeAll();
           BackgroundPanel sub = new BackgroundPanel();
            sub.setSize(d.width, d.height-40);
            add(sub);
            add(MenuBar);
            setResizable(false);
            setVisible(true);
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