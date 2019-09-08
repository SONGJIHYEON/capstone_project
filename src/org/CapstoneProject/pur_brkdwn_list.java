package org.CapstoneProject;

import java.awt.Component;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class pur_brkdwn_list extends Dialog implements ActionListener {
         
   private String[] col1 = {"구매번호","내역번호","상품번호","구매수량","구매단가"};
   
   private DefaultTableModel model1 = new DefaultTableModel(col1, 0);
   
   private JTable pur_info;
   private JScrollPane scrollpane1;
         
   private JButton Bpur_brkdwn_regist, Bclose;   
         
   GridBagLayout gridbaglayout;      
   GridBagConstraints gridbagconstraints;      // gridbag레이아웃에 컴포넌트의 위치를 잡아주는 역할
         
   public pur_brkdwn_list(JFrame fr) {      
	   super(fr, "", true);
         gridbaglayout = new GridBagLayout();
         gridbagconstraints = new GridBagConstraints();
         
         pur_info = new JTable(model1);
         scrollpane1 = new JScrollPane(pur_info);
         scrollpane1.setPreferredSize(new Dimension(1000, 300));
         
         Bpur_brkdwn_regist = new JButton("구매내역등록");
         Bpur_brkdwn_regist.addActionListener(this);
         
         Bclose = new JButton("닫기");
         Bclose.addActionListener(this);
         
         
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
         gridbagAdd(Bclose,0,1,1,1);
         gridbagconstraints.anchor = GridBagConstraints.WEST;
         gridbagconstraints.anchor = GridBagConstraints.EAST;
         gridbagAdd(Bpur_brkdwn_regist,0,1,1,1);

         pack();
         setResizable(true);
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
         
      public static void main(String[] args) {   
         new pur_brkdwn_list(new JFrame());
      }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == Bclose) {
			dispose();
		}else if(e.getSource() == Bpur_brkdwn_regist) {
			pur_brkdwn_regist s = new pur_brkdwn_regist(new JFrame());
		}
		
	}   
         
}