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
import javax.swing.JPanel;
import javax.swing.JTextField;

public class corr_regist extends JPanel implements ActionListener{

   private JLabel corr_regist, corr_lookup, corr_regist2, Lcorr_no, Lcorr_nm, Lcorr_prnm, Lcorr_ph, Lcorr_addr; 
   private JTextField  Tsearch, Tcorr_no, Tcorr_nm, Tcorr_prnm, Tcorr_ph, Tcorr_addr;      
        
   private JButton bus_man,pro_man,od_man,emp_man,mb_man,Bregist,Bcancel; 
   
   private JComboBox<String> cbSearch;      
   
   String bus_num, bus_nm, rep_nm, bus_tel, addr;
         
   GridBagLayout gridbaglayout;      
   GridBagConstraints gridbagconstraints;      // gridbag레이아웃에 컴포넌트의 위치를 잡아주는 역할
         
   public corr_regist() {      
         gridbaglayout = new GridBagLayout();
         gridbagconstraints = new GridBagConstraints();
         
         corr_regist = new JLabel("거래처등록");
         corr_regist.setPreferredSize(new Dimension(200,28));
         corr_lookup = new JLabel("거래처조회");
         corr_lookup.setPreferredSize(new Dimension(200,28));
         corr_regist2 = new JLabel("거래처등록");
         corr_regist2.setPreferredSize(new Dimension(200,28));
         
         Lcorr_no = new JLabel("업체번호");
         Lcorr_no.setPreferredSize(new Dimension(100,30));
         Lcorr_nm = new JLabel("업체명");
         Lcorr_nm.setPreferredSize(new Dimension(100,30));
         Lcorr_prnm = new JLabel("대표명");
         Lcorr_prnm.setPreferredSize(new Dimension(100,30));
         Lcorr_ph = new JLabel("연락처");
         Lcorr_ph.setPreferredSize(new Dimension(100,30));
         Lcorr_addr = new JLabel("주소");
         Lcorr_addr.setPreferredSize(new Dimension(100,30));
         
         Tsearch = new JTextField(18);
         Tsearch.setPreferredSize(new Dimension(100,30));
         Tcorr_no = new JTextField(18);
         Tcorr_no.setPreferredSize(new Dimension(100,30));
         Tcorr_nm = new JTextField(18);
         Tcorr_nm.setPreferredSize(new Dimension(100,30));
         Tcorr_prnm = new JTextField(18);
         Tcorr_prnm.setPreferredSize(new Dimension(100,30));
         Tcorr_ph = new JTextField(18);
         Tcorr_ph.setPreferredSize(new Dimension(100,30));
         Tcorr_addr = new JTextField(18);
         Tcorr_addr.setPreferredSize(new Dimension(100,30));
         
         bus_man = new JButton("거래관리");
         bus_man.setPreferredSize(new Dimension(200,28));
         pro_man = new JButton("상품관리");
         pro_man.setPreferredSize(new Dimension(200,28));
         od_man = new JButton("주문관리");
         od_man.setPreferredSize(new Dimension(200,28));
         mb_man = new JButton("회원관리");
         mb_man.setPreferredSize(new Dimension(200,28));
         emp_man = new JButton("사원관리");
         emp_man.setPreferredSize(new Dimension(200,28));
         
         Bregist = new JButton("등록");
         Bregist.addActionListener(this);
         Bcancel = new JButton("취소");
         Bcancel.addActionListener(this);
         
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

         gridbagAdd(Bregist, 1, 7, 1, 1);
         gridbagAdd(Bcancel, 2, 7, 1, 1);
         gridbagAdd(corr_regist2, 1, 1, 1, 1);
         
         gridbagconstraints.anchor = GridBagConstraints.WEST;

         
         gridbagAdd(Lcorr_no, 1, 2, 1, 1);
         gridbagAdd(Lcorr_nm, 1, 3, 1, 1);
         gridbagAdd(Lcorr_prnm, 1, 4, 1, 1);
         gridbagAdd(Lcorr_ph, 1, 5, 1, 1);
         gridbagAdd(Lcorr_addr, 1, 6, 1, 1);
         
         gridbagAdd(Tcorr_no, 2, 2, 1, 1);
         gridbagAdd(Tcorr_nm, 2, 3, 1, 1);
         gridbagAdd(Tcorr_prnm, 2, 4, 1, 1);
         gridbagAdd(Tcorr_ph, 2, 5, 1, 1);
         gridbagAdd(Tcorr_addr, 2, 6, 1, 1);
         
         gridbagconstraints.anchor = GridBagConstraints.EAST;
         
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
         new corr_regist();
      }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == Bcancel) {
	         
	      }
		else if(e.getSource() == Bregist) {
			
			int result = JOptionPane.showConfirmDialog(null, "해당 거래처를 등록하시겠습니까?", "거래처 등록 확인", JOptionPane.YES_NO_OPTION,
				    JOptionPane.INFORMATION_MESSAGE);
					if(result == 0) {
						//변수에 콤보박스 값 저장
						bus_num = Tcorr_no.getText();
						bus_nm = Tcorr_nm.getText();
						rep_nm = Tcorr_prnm.getText();
						bus_tel = Tcorr_ph.getText();
						addr = Tcorr_addr.getText();
						
						corrData.initcorrData(bus_num,bus_nm,rep_nm,bus_tel, addr);
						corrData.createcorr();
						JOptionPane.showMessageDialog(null, "거래처가 등록되었습니다.", "거래처 등록",
					               JOptionPane.WARNING_MESSAGE);
						Tcorr_no.setText("");
						Tcorr_nm.setText("");
						Tcorr_prnm.setText("");
						Tcorr_ph.setText("");
						Tcorr_addr.setText("");
			
		}else if(result ==1) {
			JOptionPane.getRootFrame().dispose(); 
		}
		
	} 
	}
}