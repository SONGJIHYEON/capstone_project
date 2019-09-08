package org.CapstoneProject;

import java.awt.Component;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class pur_brkdwn_regist extends Dialog implements ActionListener{

   private JLabel  Lpur_no, Lpro_no, Lpur_quant
   ,Lpur_up, Lpr; 
   private JTextField  Tpur_no, Tcorr_no, Tpur_dt, Ttot_pr, Tpro_no, Tpur_quant
   ,Tpur_up, Tpr;      
        
   private JButton Bregist,Bcancel; 
   
   private JComboBox<String> cbSearch;      
   
   String bus_num, pur_num, pur_dt;
   int tot_pr;
         
   GridBagLayout gridbaglayout;      
   GridBagConstraints gridbagconstraints;      // gridbag레이아웃에 컴포넌트의 위치를 잡아주는 역할
         
   public pur_brkdwn_regist(JFrame fr) {      
	   super(fr, "", true);
         gridbaglayout = new GridBagLayout();
         gridbagconstraints = new GridBagConstraints();
         
         //구매내역
         Lpur_no = new JLabel("구매번호");
         Lpur_no.setPreferredSize(new Dimension(100,30));
         Lpro_no = new JLabel("상품번호");
         Lpro_no.setPreferredSize(new Dimension(100,30));
         Lpur_quant = new JLabel("구매수량");
         Lpur_quant.setPreferredSize(new Dimension(100,30));
         Lpur_up = new JLabel("구매단가");
         Lpur_up.setPreferredSize(new Dimension(100,30));
         Lpr = new JLabel("금액");
         Lpr.setPreferredSize(new Dimension(100,30));
         
         //구매내역 입력
         Tpur_no = new JTextField(10);
         Tpur_no.setPreferredSize(new Dimension(100,30));
         Tpro_no = new JTextField(10);
         Tpro_no.setPreferredSize(new Dimension(100,30));
         Tpur_quant = new JTextField(10);
         Tpur_quant.setPreferredSize(new Dimension(100,30));
         Tpur_up = new JTextField(10);
         Tpur_up.setPreferredSize(new Dimension(100,30));
         Tpr = new JTextField(10);
         Tpr.setPreferredSize(new Dimension(100,30));
         
         Bregist = new JButton("등록");
         Bregist.addActionListener(this);
         Bcancel = new JButton("취소");
         Bcancel.addActionListener(this);
         
//         getDeptData(EmpData.selectDept());
//         getSvpData(EmpData.selectSpv());
//         setExtendedState(MAXIMIZED_BOTH);
         EmpRegisterView();
      }   
         
   private void EmpRegisterView() {      
         
         setTitle("구매내역등록");
         
         gridbagconstraints.anchor = GridBagConstraints.WEST;
//         gridbagconstraints.ipadx = 7;
//         
//         gridbagconstraints.weightx=1.0;
//         gridbagconstraints.weighty=1.0;
         
         setLayout(gridbaglayout);
         gridbagconstraints.anchor = GridBagConstraints.CENTER;

         gridbagAdd(Bregist, 0, 6, 1, 1);
         gridbagAdd(Bcancel, 1, 6, 1, 1);
         
         gridbagconstraints.anchor = GridBagConstraints.CENTER;
         
         //구매내역
         gridbagAdd(Lpur_no, 0, 1, 1, 1);
         gridbagAdd(Lpro_no, 0, 2, 1, 1);
         gridbagAdd(Lpur_quant, 0, 3, 1, 1);
         gridbagAdd(Lpur_up, 0, 4, 1, 1);
         gridbagAdd(Lpr, 0, 5, 1, 1);
         
         //구매내역
         gridbagAdd(Tpur_no, 1, 1, 1, 1);
         gridbagAdd(Tpro_no, 1, 2, 1, 1);
         gridbagAdd(Tpur_quant, 1, 3, 1, 1);
         gridbagAdd(Tpur_up, 1, 4, 1, 1);
         gridbagAdd(Tpr, 1, 5, 1, 1);
         
         
         
         gridbagconstraints.anchor = GridBagConstraints.EAST;
         
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
         new pur_brkdwn_regist(new JFrame());
      }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == Bcancel) {
	         dispose();
	      }
		else if(e.getSource() == Bregist) {
			
			int result = JOptionPane.showConfirmDialog(null, "해당 구매를 등록하시겠습니까?", "구매 등록 확인", JOptionPane.YES_NO_OPTION,
				    JOptionPane.INFORMATION_MESSAGE);
					if(result == 0) {
						//변수에 콤보박스 값 저장
						pur_num = Tpur_no.getText();
						bus_num = Tcorr_no.getText();
						pur_dt = Tpur_dt.getText();
						tot_pr = Integer.parseInt(Ttot_pr.getText());
						
						purData.initpurData(pur_num,bus_num,pur_dt,tot_pr);
						purData.createpur();
						JOptionPane.showMessageDialog(null, "구매가 등록되었습니다.", "구매 등록",
					               JOptionPane.WARNING_MESSAGE);
						Tpur_no.setText("");
						Tcorr_no.setText("");
						Tpur_dt.setText("");
						Ttot_pr.setText("");
			
		}else if(result ==1) {
			JOptionPane.getRootFrame().dispose(); 
		}
		
	} 
	}
}