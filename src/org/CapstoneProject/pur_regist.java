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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class pur_regist extends Dialog implements ActionListener{

   private JLabel pur_regist, Lcorr_nm, Lpur_dt, Ltot_pr; 
   private JTextField  Tcorr_nm, Tpur_dt, Ttot_pr;      
   private static String[] col1 = {"��������ȣ"};
   private static DefaultTableModel model1 = new DefaultTableModel(col1, 0);
   private JTable pur_info;
        
   private JButton Bregist,Bcancel; 
   
   String corr_num, corr_nm, pur_num, pur_dt;
   int tot_pr;
         
   GridBagLayout gridbaglayout;      
   GridBagConstraints gridbagconstraints;      // gridbag���̾ƿ��� ������Ʈ�� ��ġ�� ����ִ� ����
         
   public pur_regist(JFrame fr) {      
	   super(fr, "", true);
         gridbaglayout = new GridBagLayout();
         gridbagconstraints = new GridBagConstraints();
         
         pur_info = new JTable(model1);
         
         pur_regist = new JLabel("���ŵ��");
         pur_regist.setPreferredSize(new Dimension(100,30));
         Lcorr_nm = new JLabel("�ŷ�ó��");
         Lcorr_nm.setPreferredSize(new Dimension(100,30));
         Lpur_dt = new JLabel("��������");
         Lpur_dt.setPreferredSize(new Dimension(100,30));
         Ltot_pr = new JLabel("�ѱݾ�");
         Ltot_pr.setPreferredSize(new Dimension(100,30));

         Tcorr_nm = new JTextField(18);
         Tcorr_nm.setText(corr_look.corr_nm);
         Tcorr_nm.setEnabled(false);
         Tcorr_nm.setPreferredSize(new Dimension(100,30));
         Tpur_dt = new JTextField(18);
         Tpur_dt.setPreferredSize(new Dimension(100,30));
         Ttot_pr = new JTextField(18);
         Ttot_pr.setPreferredSize(new Dimension(100,30));
         
         Bregist = new JButton("���");
         Bregist.addActionListener(this);
         Bregist.setFont(new Font("�޸ո���ü", Font.PLAIN , 15));
         Bregist.setBackground(Color.WHITE);
         
         Bcancel = new JButton("���");
         Bcancel.addActionListener(this);
         Bcancel.setFont(new Font("�޸ո���ü", Font.PLAIN , 15));
         Bcancel.setBackground(Color.WHITE);
         
//         getDeptData(EmpData.selectDept());
//         getSvpData(EmpData.selectSpv());
//         setExtendedState(MAXIMIZED_BOTH);
         EmpRegisterView();
      }   
         
   private void EmpRegisterView() {      
         
         setTitle("���ŵ��");
         
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
         gridbagAdd(Bregist, 0, 5, 1, 1);
         gridbagAdd(Bcancel, 1, 5, 1, 1);
         gridbagAdd(pur_regist, 0, 0, 2, 1);
         
         gridbagconstraints.anchor = GridBagConstraints.WEST;
//       gridbagAdd(pur_regist, 0, 2, 1, 1);
//       gridbagAdd(pur_lookup, 0, 1, 1, 1);
         
         gridbagAdd(Lcorr_nm, 0, 1, 1, 1);
         gridbagAdd(Lpur_dt, 0, 3, 1, 1);
         gridbagAdd(Ltot_pr, 0, 4, 1, 1);
         
         gridbagAdd(Tcorr_nm, 1, 1, 1, 1);
         gridbagAdd(Tpur_dt, 1, 3, 1, 1);
         gridbagAdd(Ttot_pr, 1, 4, 1, 1);
         
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
         new pur_regist(new JFrame());
      }
      
	static void getData(List<Map<String, Serializable>> purListData) {
	    	  
	    	  model1.setNumRows(0);
	
		      for(int i=0; i < purListData.size(); i++) {
		    	  model1.addRow(new Object[] {
		               
		    			  purListData.get(i).get("LAST_NUMBER")
	
		         });
		      }
	
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == Bcancel) {
	         dispose();
	      }
		else if(e.getSource() == Bregist) {
			
			int result = JOptionPane.showConfirmDialog(null, "�ش� ���Ÿ� ����Ͻðڽ��ϱ�?", "���� ��� Ȯ��", JOptionPane.YES_NO_OPTION,
				    JOptionPane.INFORMATION_MESSAGE);
					if(result == 0) {
						//������ �޺��ڽ� �� ����
						corr_num = corr_look.corr_num;
						corr_nm = Tcorr_nm.getText();
						pur_dt = Tpur_dt.getText();
						tot_pr = Integer.parseInt(Ttot_pr.getText());
						
						if (pur_dt.equals("") || tot_pr == 0 ) {
							JOptionPane.showMessageDialog(null, "�Էµ��� ���� �׸��� �ֽ��ϴ�.", "����", JOptionPane.ERROR_MESSAGE);
						} else {
						
							purData.initpurData(pur_num,corr_num,pur_dt,tot_pr);
							purData.createpur();
							
					        getData(purData.searchSEQ());
					        pur_num = "";
					       	pur_num += (String) pur_info.getValueAt(0, 0);
							
							JOptionPane.showMessageDialog(null, "���Ű� ��ϵǾ����ϴ�.", "���� ���",
						               JOptionPane.INFORMATION_MESSAGE);
							Tpur_dt.setText("");
							Ttot_pr.setText("");
							pur_list.getData(purData.selectpur(corr_look.corr_num));
							dispose();
						} 
		}else if(result ==1) {
			JOptionPane.getRootFrame().dispose(); 
		}
		
	} 
	}
}