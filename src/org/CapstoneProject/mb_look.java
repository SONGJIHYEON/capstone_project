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

public class mb_look extends JFrame {

   private JLabel  mb_lookup, mb_lookup2, mb_gra;
   
   private JTextField  Tsearch;
   private String[] col1 = {"No", "���̵�", "ȸ����", "�ּ�", "ȸ�����"};  
   private String[] search = {"���̵�", "ȸ����", "ȸ�����"};       
   
   private DefaultTableModel model1 = new DefaultTableModel(col1, 0);
   
   private JTable emp_info;
   private JScrollPane scrollpane1;
         
   private JButton bus_man,pro_man,od_man,mb_man,emp_man,Bregist,Bcancel,Bsearch,Breset; 
   
   private JComboBox<String> cbSearch;      
         
   GridBagLayout gridbaglayout;      
   GridBagConstraints gridbagconstraints;      // gridbag���̾ƿ��� ������Ʈ�� ��ġ�� ����ִ� ����
         
   public mb_look() {      
         
         gridbaglayout = new GridBagLayout();
         gridbagconstraints = new GridBagConstraints();
         
         mb_lookup = new JLabel("ȸ����ȸ");
         mb_lookup.setPreferredSize(new Dimension(200,28));
         mb_lookup2 = new JLabel("ȸ����ȸ");
         mb_lookup2.setPreferredSize(new Dimension(200,28));
         mb_gra = new JLabel("ȸ����޼���");
         mb_lookup2.setPreferredSize(new Dimension(200,28));
         
         Tsearch = new JTextField(18);
         Tsearch.setPreferredSize(new Dimension(100,30));
         
         cbSearch = new JComboBox<String>(search);
         cbSearch.setPreferredSize(new Dimension(200,28));
         
         emp_info = new JTable(model1);
         scrollpane1 = new JScrollPane(emp_info);
         scrollpane1.setPreferredSize(new Dimension(1000, 300));
         
         
         bus_man = new JButton("�ŷ�����");
         bus_man.setPreferredSize(new Dimension(200,28));
//         regist.addActionListener(this);
         pro_man = new JButton("��ǰ����");
         pro_man.setPreferredSize(new Dimension(200,28));
//         cancel.addActionListener(this);
         od_man = new JButton("�ֹ�����");
         od_man.setPreferredSize(new Dimension(200,28));
         mb_man = new JButton("ȸ������");
         mb_man.setPreferredSize(new Dimension(200,28));
         emp_man = new JButton("�������");
         emp_man.setPreferredSize(new Dimension(200,28));
         Bsearch = new JButton("�˻�");
         Bsearch.setPreferredSize(new Dimension(200,28));
         Breset = new JButton("�ʱ�ȭ");
         Breset.setPreferredSize(new Dimension(200,28));
         
//         getDeptData(EmpData.selectDept());
//         getSvpData(EmpData.selectSpv());
//         setExtendedState(MAXIMIZED_BOTH);
         EmpRegisterView();
      }   
         
   private void EmpRegisterView() {      
         
//         setTitle("ȸ����ȸ");
         
         gridbagconstraints.anchor = GridBagConstraints.WEST;
//         gridbagconstraints.ipadx = 7;
//         
//         gridbagconstraints.weightx=1.0;
//         gridbagconstraints.weighty=1.0;
         
         setLayout(gridbaglayout);
         gridbagconstraints.anchor = GridBagConstraints.CENTER;
         
         gridbagAdd(scrollpane1, 1, 3, 5, 5);
         
         gridbagconstraints.anchor = GridBagConstraints.WEST;

         gridbagAdd(Tsearch, 2, 2, 1, 1);
         gridbagAdd(cbSearch, 1, 2, 1, 1);
         gridbagAdd(mb_lookup2, 1, 1, 1, 1);
         gridbagAdd(Bsearch, 3, 2, 1, 1);
         
         gridbagconstraints.anchor = GridBagConstraints.EAST;
         
         gridbagAdd(Breset, 4, 2, 1, 1);

//         setResizable(true);
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
         new mb_look();
      }   
         
}