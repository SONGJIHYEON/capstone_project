package org.CapstoneProject;

import java.awt.Component;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class corr_pur extends Dialog implements ActionListener {
         
   private String[] col1 = {"���Ź�ȣ","������ȣ","��ǰ��ȣ","���ż���","���Ŵܰ�","�ѱݾ�","��������"}; 
       
         
   private DefaultTableModel model1 = new DefaultTableModel(col1, 0);  
         
   private JTable od_info;      
   private JScrollPane scrollpane1;      
         
   private JButton close;      
         
   GridBagLayout gridbaglayout;      
   GridBagConstraints gridbagconstraints;      // gridbag���̾ƿ��� ������Ʈ�� ��ġ�� ����ִ� ����
         
   public corr_pur(JFrame fr) {      
	   super(fr, "", true);
         gridbaglayout = new GridBagLayout();
         gridbagconstraints = new GridBagConstraints();
       
         od_info = new JTable(model1);
//         eDept.addMouseListener(new JTableMouseListener());
         scrollpane1 = new JScrollPane(od_info);
         scrollpane1.setPreferredSize(new Dimension(1000, 300));
         
         close = new JButton("�ݱ�");
         close.addActionListener(this);
         close.setPreferredSize(new Dimension(100,28));
         
//         getDeptData(EmpData.selectDept());
//         getSvpData(EmpData.selectSpv());
//         setExtendedState(MAXIMIZED_BOTH);
         EmpRegisterView();
      }   
         
   private void EmpRegisterView() {      
         
         setTitle("�ŷ�ó ���ų���");
         
         gridbagconstraints.anchor = GridBagConstraints.WEST;
         
         setLayout(gridbaglayout);
         gridbagconstraints.anchor = GridBagConstraints.CENTER;
         gridbagAdd(scrollpane1, 1, 1, 5, 5);
         gridbagAdd(close, 1, 6, 5, 1);

         pack();
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
         new corr_pur(new JFrame());
      }   
      
      public void actionPerformed(ActionEvent e) {
          // TODO Auto-generated method stub
          if(e.getSource() == close) {
             dispose();
          }
       }
         
}