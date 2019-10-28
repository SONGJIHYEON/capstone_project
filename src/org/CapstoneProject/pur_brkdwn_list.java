package org.CapstoneProject;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class pur_brkdwn_list extends JPanel implements ActionListener {
         
   private static String[] col1 = {"내역번호","상품명","구매수량","구매단가","금액"};
   
   private static DefaultTableModel model1 = new DefaultTableModel(col1, 0);
   
   private JTable pur_info;
   private JScrollPane scrollpane1;
         
   private JButton Bpur_brkdwn_regist;   
         
   GridBagLayout gridbaglayout;      
   GridBagConstraints gridbagconstraints;      // gridbag레이아웃에 컴포넌트의 위치를 잡아주는 역할
         
   public pur_brkdwn_list() {
         gridbaglayout = new GridBagLayout();
         gridbagconstraints = new GridBagConstraints();
         
         pur_info = new JTable(model1);
         scrollpane1 = new JScrollPane(pur_info);
         scrollpane1.setPreferredSize(new Dimension(600, 300));
         
         Bpur_brkdwn_regist = new JButton("구매내역등록");
         Bpur_brkdwn_regist.addActionListener(this);
         Bpur_brkdwn_regist.setFont(new Font("휴먼매직체", Font.PLAIN , 20));
         Bpur_brkdwn_regist.setPreferredSize(new Dimension(150,40));
         Bpur_brkdwn_regist.setBackground(Color.WHITE);
         
         
//         getDeptData(EmpData.selectDept());
//         getSvpData(EmpData.selectSpv());
         EmpRegisterView();
      }   
         
   private void EmpRegisterView() {      
         
         gridbagconstraints.anchor = GridBagConstraints.WEST;
//         gridbagconstraints.ipadx = 7;
//         
//         gridbagconstraints.weightx=1.0;
//         gridbagconstraints.weighty=1.0;
         
         setLayout(gridbaglayout);
         gridbagconstraints.anchor = GridBagConstraints.CENTER;
         
         gridbagAdd(scrollpane1, 0, 0, 1, 1);
         gridbagconstraints.anchor = GridBagConstraints.WEST;
         gridbagconstraints.anchor = GridBagConstraints.EAST;
         gridbagAdd(Bpur_brkdwn_regist,0,1,1,1);

         getData(pur_brkdwn_Data.selectpur_brkdwn_Data(pur_list.pur_num));
         setVisible(true);
      }
      static void getData(List<Map<String, Serializable>> pur_brkdwnListData) {
         
         model1.setNumRows(0);
   
            for(int i=0; i < pur_brkdwnListData.size(); i++) {
               
               model1.addRow(new Object[] {
                     
                     pur_brkdwnListData.get(i).get("BRKDWN_NUM"),
                     pur_brkdwnListData.get(i).get("PRO_NM"),
                     pur_brkdwnListData.get(i).get("PUR_QUANT"),
                     pur_brkdwnListData.get(i).get("PUR_UP"),
                     pur_brkdwnListData.get(i).get("PR")
   
               });
            }
   
   
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
         
      public static void main(String[] args) {   
         new pur_brkdwn_list();
      }

   @Override
   public void actionPerformed(ActionEvent e) {
      // TODO Auto-generated method stub
      if(e.getSource() == Bpur_brkdwn_regist) {
         pur_brkdwn_regist s = new pur_brkdwn_regist(new JFrame());
      }
      
   }   
         
}