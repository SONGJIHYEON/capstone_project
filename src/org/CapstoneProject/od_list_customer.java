package org.CapstoneProject;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class od_list_customer extends JFrame {
         
   private String[] col1 = {"�ֹ�����","�ֹ���ȣ","�̹���","��ǰ��","����","�ݾ�","�ֹ�����"}; 
   private String[] search = {"�ֹ���ȣ","��ǰ��","�ֹ�����"};
   
   private JTextField  Tsearch;
   
   private JComboBox<String> cbSearch;      
         
   private DefaultTableModel model1 = new DefaultTableModel(col1, 0);  
         
   private JTable od_info;      
   private JScrollPane scrollpane1;      
         
   private JButton close, Bsearch, Bprevious;      
         
   GridBagLayout gridbaglayout;      
   GridBagConstraints gridbagconstraints;      // gridbag���̾ƿ��� ������Ʈ�� ��ġ�� ����ִ� ����
         
   public od_list_customer() {      
         
         gridbaglayout = new GridBagLayout();
         gridbagconstraints = new GridBagConstraints();
       
         od_info = new JTable(model1);
//         eDept.addMouseListener(new JTableMouseListener());
         scrollpane1 = new JScrollPane(od_info);
         scrollpane1.setPreferredSize(new Dimension(1000, 300));
         
         cbSearch = new JComboBox<String>(search);
         cbSearch.setPreferredSize(new Dimension(200,28));
         
         Tsearch = new JTextField();
         Tsearch.setPreferredSize(new Dimension(200,28));
         
         Bsearch = new JButton("�˻�");
         Bsearch.setPreferredSize(new Dimension(70,28));
         
         Bprevious = new JButton("����");
         Bprevious.setPreferredSize(new Dimension(100,28));
         
         close = new JButton("�ݱ�");
         close.setPreferredSize(new Dimension(100,28));
         
//         getDeptData(EmpData.selectDept());
//         getSvpData(EmpData.selectSpv());
         setExtendedState(MAXIMIZED_BOTH);
         EmpRegisterView();
      }   
         
   private void EmpRegisterView() {      
         
         setTitle("�ֹ�����(��)");
         
         gridbagconstraints.anchor = GridBagConstraints.WEST;

         gridbagAdd(Bsearch, 3, 0, 1, 1);
         
         setLayout(gridbaglayout);
         gridbagconstraints.anchor = GridBagConstraints.CENTER;
         gridbagAdd(cbSearch, 1, 0, 1, 1);
         gridbagAdd(scrollpane1, 1, 1, 5, 5);
         gridbagAdd(Tsearch, 2, 0, 1, 1);
         gridbagAdd(Bprevious, 3, 6, 1, 1);


         setResizable(true);
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
         new od_list_customer();
      }   
         
}