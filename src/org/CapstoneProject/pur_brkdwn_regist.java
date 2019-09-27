
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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class pur_brkdwn_regist extends Dialog implements ActionListener, MouseListener{

   private JLabel  Lpur_no, Lpro_nm, Lpur_quant, Lpur_up, Lpr; 
   private JTextField  Tpur_no, Tpur_dt, Ttot_pr, Tpro_nm, Tpur_quant, Tpur_up, Tpr;      
        
   private JButton Bregist,Bcancel,Bprosearch; 
   
   private JComboBox<String> cbSearch;      
   
   String pro_num;
   static String pur_num;
   int pur_quant, pur_up, tot_pr;
         
   GridBagLayout gridbaglayout;      
   GridBagConstraints gridbagconstraints;      // gridbag레이아웃에 컴포넌트의 위치를 잡아주는 역할
         
   public pur_brkdwn_regist(JFrame fr) {      
	   super(fr, "", true);
         gridbaglayout = new GridBagLayout();
         gridbagconstraints = new GridBagConstraints();
         
         //구매내역
         Lpur_no = new JLabel("구매번호");
         Lpur_no.setPreferredSize(new Dimension(100,30));
         Lpro_nm = new JLabel("상품명");
         Lpro_nm.setPreferredSize(new Dimension(100,30));
         Lpur_quant = new JLabel("구매수량");
         Lpur_quant.setPreferredSize(new Dimension(100,30));
         Lpur_up = new JLabel("구매단가");
         Lpur_up.setPreferredSize(new Dimension(100,30));
         Lpr = new JLabel("금액");
         Lpr.setPreferredSize(new Dimension(100,30));
         
         //구매내역 입력
         Tpur_no = new JTextField(10);
         Tpur_no.setEnabled(false);
         Tpur_no.setPreferredSize(new Dimension(100,30));
         Tpro_nm = new JTextField(10);
         Tpro_nm.setEnabled(false);
         Tpro_nm.setPreferredSize(new Dimension(100,30));
         Tpur_quant = new JTextField(10);
         Tpur_quant.setPreferredSize(new Dimension(100,30));
         Tpur_up = new JTextField(10);
         Tpur_up.setPreferredSize(new Dimension(100,30));
         Tpr = new JTextField(10);
         Tpr.addMouseListener(this);
         Tpr.setPreferredSize(new Dimension(100,30));
         
         Bregist = new JButton("등록");
         Bregist.addActionListener(this);
         Bregist.setFont(new Font("휴먼매직체", Font.PLAIN , 20));
         Bregist.setBackground(Color.WHITE);
         
         Bcancel = new JButton("취소");
         Bcancel.setFont(new Font("휴먼매직체", Font.PLAIN , 20));
         Bcancel.setBackground(Color.WHITE);
         Bcancel.addActionListener(this);
         
         Bprosearch = new JButton("상품검색");
         Bprosearch.addActionListener(this);
         Bprosearch.setFont(new Font("휴먼매직체", Font.PLAIN , 20));
         Bprosearch.setFocusPainted(false);
         Bprosearch.setBackground(Color.WHITE);
         
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
         gridbagAdd(Lpro_nm, 0, 2, 1, 1);
         gridbagAdd(Lpur_quant, 0, 3, 1, 1);
         gridbagAdd(Lpur_up, 0, 4, 1, 1);
         gridbagAdd(Lpr, 0, 5, 1, 1);
         
         //구매내역
         gridbagAdd(Tpur_no, 1, 1, 1, 1);
         Tpur_no.setText(pur_list.pur_num);
         gridbagAdd(Tpro_nm, 1, 2, 1, 1);
         gridbagAdd(Tpur_quant, 1, 3, 1, 1);
         gridbagAdd(Tpur_up, 1, 4, 1, 1);
         gridbagAdd(Tpr, 1, 5, 1, 1);
         
         gridbagAdd(Bprosearch, 2, 2, 1, 1);
         
         
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
	      }else if(e.getSource() == Bregist) {
			
			int result = JOptionPane.showConfirmDialog(null, "해당 구매내역를 등록하시겠습니까?", "구매내역 등록 확인", JOptionPane.YES_NO_OPTION,
				    JOptionPane.INFORMATION_MESSAGE);
					if(result == 0) {
						//변수에 콤보박스 값 저장
						pur_num = Tpur_no.getText();
						pur_quant = Integer.parseInt(Tpur_quant.getText());
						pur_up = Integer.parseInt(Tpur_up.getText());
						tot_pr = Integer.parseInt(Tpr.getText());
						
						if (pur_num.equals("") || pur_quant == 0 || pur_up == 0 || tot_pr == 0) {
							JOptionPane.showMessageDialog(null, "입력되지 않은 항목이 있습니다.", "오류", JOptionPane.ERROR_MESSAGE);
						} else {
						
							pur_brkdwn_Data.initpur_brkdwn_Data(pur_num,pro_num,pur_quant,pur_up,tot_pr);
							pur_brkdwn_Data.createpur_brkdwn_Data();
							JOptionPane.showMessageDialog(null, "구매내역이 등록되었습니다.", "구매내역 등록",
						               JOptionPane.INFORMATION_MESSAGE);
							Tpur_no.setText("");
							Tpro_nm.setText("");
							Tpur_quant.setText("");
							Tpur_up.setText("");
							Tpr.setText("");
							
							pur_brkdwn_list.getData(pur_brkdwn_Data.selectpur_brkdwn_Data(pur_num));
							dispose();
						} 
					}else if(result ==1) {
						JOptionPane.getRootFrame().dispose(); 
					}
		}else if(e.getSource() == Bprosearch) {
			ProSearch p = new ProSearch(new JFrame());
			pro_num = "";
			pro_num += p.PRO_NUM;
			Tpro_nm.setText(p.PRO_NM);
		} 
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == Tpr) {
			int quant, pro_up;
			quant = Integer.parseInt(Tpur_quant.getText());
			pro_up = Integer.parseInt(Tpur_up.getText());
			Tpr.setText(Integer.toString(quant * pro_up));
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

