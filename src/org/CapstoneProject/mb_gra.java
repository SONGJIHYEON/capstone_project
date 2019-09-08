package org.CapstoneProject;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class mb_gra extends JPanel {

   private JLabel  mb_lookup, mb_lookup2, mb_gra, gra_s, gra_v, gra_f ;
   
   private JTextField  Tsearch, Tgra_s, Tgra_v, Tgra_f;
   
   private JButton Bmodify,Bcancel,Breset; 
   
   private JComboBox<String> cbSearch;      
         
   GridBagLayout gridbaglayout;      
   GridBagConstraints gridbagconstraints;      // gridbag���̾ƿ��� ������Ʈ�� ��ġ�� ����ִ� ����
         
   public mb_gra() {      
         
         gridbaglayout = new GridBagLayout();
         gridbagconstraints = new GridBagConstraints();
         
         mb_gra = new JLabel("��ް���");
         mb_gra.setPreferredSize(new Dimension(200,28));
         gra_s = new JLabel("S���");
         gra_s.setPreferredSize(new Dimension(200,28));
         gra_v = new JLabel("V���");
         gra_v.setPreferredSize(new Dimension(200,28));
         gra_f = new JLabel("F���");
         gra_f.setPreferredSize(new Dimension(200,28));
         
         Tsearch = new JTextField(18);
         Tsearch.setPreferredSize(new Dimension(100,30));
         Tgra_s = new JTextField(18);
         Tgra_s.setPreferredSize(new Dimension(100,30));
         Tgra_v = new JTextField(18);
         Tgra_v.setPreferredSize(new Dimension(100,30));
         Tgra_f = new JTextField(18);
         Tgra_f.setPreferredSize(new Dimension(100,30));
         
        
         Bmodify = new JButton("����");
         Bmodify.setPreferredSize(new Dimension(200,28));
         
         EmpRegisterView();
      }   
         
   private void EmpRegisterView() {      
         
         
         gridbagconstraints.anchor = GridBagConstraints.WEST;
//         gridbagconstraints.ipadx = 7;
//         
//         gridbagconstraints.weightx=1.0;
//         gridbagconstraints.weighty=1.0;
         
         gridbagconstraints.anchor = GridBagConstraints.CENTER;
         
         gridbagAdd(mb_gra, 1, 1, 1, 1);
         
         gridbagAdd(gra_s, 1, 2, 1, 1);
         gridbagAdd(gra_v, 1, 3, 1, 1);
         gridbagAdd(gra_f, 1, 4, 1, 1);
         
         gridbagAdd(Tgra_s, 2, 2, 1, 1);
         gridbagAdd(Tgra_v, 2, 3, 1, 1);
         gridbagAdd(Tgra_f, 2, 4, 1, 1);
         
         gridbagAdd(Bmodify, 1, 5, 1, 1);
         
         gridbagconstraints.anchor = GridBagConstraints.WEST;
         
         gridbagconstraints.anchor = GridBagConstraints.EAST;

         setVisible(true);
      }   
         
      private void gridbagAdd(Component c, int x, int y, int w, int h) {   
         
         gridbagconstraints.gridx = x;
         gridbagconstraints.gridy = y; 
            //���� ���� �� gridx, gridy���� 0    
         
         gridbagconstraints.gridwidth  = w;
         gridbagconstraints.gridheight = h;
              
               
          gridbaglayout.setConstraints(c, gridbagconstraints); //������Ʈ�� ������Ʈ ��ġ+ũ�� ������ ���� GridBagLayout�� ��ġ   
         
         add(c);   
         
         }   
         
      public static void main(String[] args) {   
         new mb_gra();
      }   
         
}