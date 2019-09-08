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

public class od_list_detail extends JFrame {
         
   private String[] col1 = {"�ֹ���ȣ","�ֹ��Ͻ�","�ֹ�����"};
   private String[] col2 = {"�� �ֹ��ݾ�","�� ���αݾ�","��� ������","�� ���� �ݾ�","���� ����"};
   private String[] col3 = {"�̹���","��ǰ ����","����","�ݾ�","�ֹ�����"};
   private String[] col4 = {"������ȣ","������","����ó","�ּ�"};
   
   private JLabel Lod_info, Lpay_info, Lod_pro_info, Ldel_info;
   
   private JTextField  Tsearch;
         
   private DefaultTableModel model1 = new DefaultTableModel(col1, 0);  
   private DefaultTableModel model2 = new DefaultTableModel(col2, 0);  
   private DefaultTableModel model3 = new DefaultTableModel(col3, 0);  
   private DefaultTableModel model4 = new DefaultTableModel(col4, 0);  
         
   private JTable od_info, pay_info, od_pro_info, del_info;;      
   private JScrollPane scrollpane1, scrollpane2, scrollpane3, scrollpane4;      
         
   private JButton close;      
         
   GridBagLayout gridbaglayout;      
   GridBagConstraints gridbagconstraints;      // gridbag���̾ƿ��� ������Ʈ�� ��ġ�� ����ִ� ����
         
   public od_list_detail() {      
         
         gridbaglayout = new GridBagLayout();
         gridbagconstraints = new GridBagConstraints();
         
         Lod_info = new JLabel("�ֹ�����");
         Lod_info.setPreferredSize(new Dimension(200,28));
         Lpay_info = new JLabel("��������");
         Lpay_info.setPreferredSize(new Dimension(200,28));
         Lod_pro_info = new JLabel("�ֹ���ǰ����");
         Lod_pro_info.setPreferredSize(new Dimension(200,28));
         Ldel_info = new JLabel("�������");
         Ldel_info.setPreferredSize(new Dimension(200,28));
       
         od_info = new JTable(model1);
         scrollpane1 = new JScrollPane(od_info);
         scrollpane1.setPreferredSize(new Dimension(1000, 50));
         
         pay_info = new JTable(model2);
         scrollpane2 = new JScrollPane(pay_info);
         scrollpane2.setPreferredSize(new Dimension(1000, 50));
         
         od_pro_info = new JTable(model3);
         scrollpane3 = new JScrollPane(od_pro_info);
         scrollpane3.setPreferredSize(new Dimension(1000, 300));
         
         del_info = new JTable(model4);
         scrollpane4 = new JScrollPane(del_info);
         scrollpane4.setPreferredSize(new Dimension(1000, 50));
         
         
         Tsearch = new JTextField();
         Tsearch.setPreferredSize(new Dimension(200,28));
         
         close = new JButton("�ݱ�");
         close.setPreferredSize(new Dimension(100,28));
         
//         getDeptData(EmpData.selectDept());
//         getSvpData(EmpData.selectSpv());
         setExtendedState(MAXIMIZED_BOTH);
         EmpRegisterView();
      }   
         
   private void EmpRegisterView() {      
         
         setTitle("�ֹ�������");
         
         gridbagconstraints.anchor = GridBagConstraints.EAST;

         
         setLayout(gridbaglayout);
         gridbagconstraints.anchor = GridBagConstraints.CENTER;
         
         gridbagAdd(Lod_info, 0, 0, 1, 1);
         gridbagAdd(scrollpane1, 0, 1, 5, 1);
         
         gridbagAdd(Lpay_info, 0, 2, 1, 1);
         gridbagAdd(scrollpane2, 0, 3, 5, 1);

         gridbagAdd(Lod_pro_info, 0, 4, 1, 1);
         gridbagAdd(scrollpane3, 0, 5, 5, 3);

         gridbagAdd(Ldel_info, 0, 8, 1, 1);
         gridbagAdd(scrollpane4, 0, 9, 5, 1);

         gridbagAdd(close, 0, 10, 5, 1);


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
         new od_list_detail();
      }   
         
}