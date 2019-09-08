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
import javax.swing.JTextField;

public class corr_re extends Dialog implements ActionListener{

   private JLabel corr_regist, corr_lookup, corr_regist2, Lcorr_no, Lcorr_nm, Lcorr_prnm, Lcorr_ph, Lcorr_addr; 
   private JTextField  Tsearch, Tcorr_no, Tcorr_nm, Tcorr_prnm, Tcorr_ph, Tcorr_addr;      
        
   private JButton bus_man,pro_man,od_man,emp_man,mb_man,Bre,Bcancel; 
   
   private JComboBox<String> cbSearch;      
         
   GridBagLayout gridbaglayout;      
   GridBagConstraints gridbagconstraints;      // gridbag���̾ƿ��� ������Ʈ�� ��ġ�� ����ִ� ����
         
   public corr_re(JFrame fr) {      
	   super(fr, "", true);
         gridbaglayout = new GridBagLayout();
         gridbagconstraints = new GridBagConstraints();
         
         corr_regist = new JLabel("�ŷ�ó���");
         corr_regist.setPreferredSize(new Dimension(200,28));
         corr_lookup = new JLabel("�ŷ�ó��ȸ");
         corr_lookup.setPreferredSize(new Dimension(200,28));
         corr_regist2 = new JLabel("�ŷ�ó����");
         
         Lcorr_no = new JLabel("��ü��ȣ");
         Lcorr_no.setPreferredSize(new Dimension(100,30));
         Lcorr_nm = new JLabel("��ü��");
         Lcorr_nm.setPreferredSize(new Dimension(100,30));
         Lcorr_prnm = new JLabel("��ǥ��");
         Lcorr_prnm.setPreferredSize(new Dimension(100,30));
         Lcorr_ph = new JLabel("����ó");
         Lcorr_ph.setPreferredSize(new Dimension(100,30));
         Lcorr_addr = new JLabel("�ּ�");
         Lcorr_addr.setPreferredSize(new Dimension(100,30));
         
         Tsearch = new JTextField(11);
         Tsearch.setPreferredSize(new Dimension(100,30));
         Tcorr_no = new JTextField(11);
         Tcorr_no.setPreferredSize(new Dimension(100,30));
         Tcorr_nm = new JTextField(11);
         Tcorr_nm.setPreferredSize(new Dimension(100,30));
         Tcorr_prnm = new JTextField(11);
         Tcorr_prnm.setPreferredSize(new Dimension(100,30));
         Tcorr_ph = new JTextField(11);
         Tcorr_ph.setPreferredSize(new Dimension(100,30));
         Tcorr_addr = new JTextField(11);
         Tcorr_addr.setPreferredSize(new Dimension(100,30));
         
         bus_man = new JButton("�ŷ�����");
         bus_man.setPreferredSize(new Dimension(200,28));
         pro_man = new JButton("��ǰ����");
         pro_man.setPreferredSize(new Dimension(200,28));
         od_man = new JButton("�ֹ�����");
         od_man.setPreferredSize(new Dimension(200,28));
         mb_man = new JButton("ȸ������");
         mb_man.setPreferredSize(new Dimension(200,28));
         emp_man = new JButton("�������");
         emp_man.setPreferredSize(new Dimension(200,28));
         
         Bre = new JButton("����");
         Bcancel = new JButton("���");
         Bcancel.addActionListener(this);
         
//         getDeptData(EmpData.selectDept());
//         getSvpData(EmpData.selectSpv());
//         setExtendedState(MAXIMIZED_BOTH);
         EmpRegisterView();
      }   
         
   private void EmpRegisterView() {      
         
         setTitle("�ŷ�ó����");
         
         gridbagconstraints.anchor = GridBagConstraints.WEST;
//         gridbagconstraints.ipadx = 7;
//         
//         gridbagconstraints.weightx=1.0;
//         gridbagconstraints.weighty=1.0;
         
         setLayout(gridbaglayout);
         gridbagconstraints.anchor = GridBagConstraints.CENTER;
//         gridbagAdd(bus_man, 1, 0, 1, 1);
//         gridbagAdd(pro_man, 2, 0, 1, 1);
//         gridbagAdd(od_man, 3, 0, 1, 1);
//         gridbagAdd(mb_man, 4, 0, 1, 1);
//         gridbagAdd(emp_man, 5, 0, 1, 1);
         gridbagAdd(Bre, 1, 7, 1, 1);
         gridbagAdd(Bcancel, 2, 7, 1, 1);
         gridbagAdd(corr_regist2, 1, 1, 2, 1);
         
         gridbagconstraints.anchor = GridBagConstraints.WEST;
//       gridbagAdd(corr_regist, 0, 2, 1, 1);
//       gridbagAdd(corr_lookup, 0, 1, 1, 1);
         
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
         new corr_re(new JFrame());
      }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == Bcancel) {
	         dispose();
	      }
		
	}   
         
}