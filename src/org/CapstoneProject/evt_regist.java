package org.CapstoneProject;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;


public class evt_regist extends JPanel implements ActionListener{

   private JLabel evt_regist, Levt_no, Levt_tp, Levt_st_dt, Levt_fn_dt, Levt_gift, Levt_point, Levt_sale;      
         
   private JTextField  Tevt_no, Tevt_st_dt, Tevt_fn_dt, Tevt_gift, Tevt_point, Tevt_sale;      
   
   private String[] Sevt_tp = {"1+1�̺�Ʈ", "�����̺�Ʈ", "����Ʈ�̺�Ʈ"};   
         
   private JButton Bregist,Bcancel; 
   
   private JComboBox<String> CBevt_tp, CBreg_tp;   
   
   String evt_NO,  evt_tp,  evt_st_dt,  evt_fn_dt;
         
   GridBagLayout gridbaglayout;      
   GridBagConstraints gridbagconstraints;      // gridbag���̾ƿ��� ������Ʈ�� ��ġ�� ����ִ� ����
         
   public evt_regist() {      
         
         gridbaglayout = new GridBagLayout();
         gridbagconstraints = new GridBagConstraints();
         
         evt_regist = new JLabel("�̺�Ʈ���");
         evt_regist.setPreferredSize(new Dimension(200,28));
         
         Levt_no = new JLabel("�̺�Ʈ ��ȣ");
         Levt_no.setPreferredSize(new Dimension(100,30));
         Levt_tp = new JLabel("�̺�Ʈ ����");
         Levt_tp.setPreferredSize(new Dimension(100,30));
         Levt_st_dt = new JLabel("�̺�Ʈ ��������");
         Levt_st_dt.setPreferredSize(new Dimension(100,30));
         Levt_fn_dt = new JLabel("�̺�Ʈ ��������");
         Levt_fn_dt.setPreferredSize(new Dimension(100,30));
         Levt_gift = new JLabel("���� ��");
         Levt_gift.setPreferredSize(new Dimension(100,30));
         Levt_point = new JLabel("���� ����Ʈ");
         Levt_point.setPreferredSize(new Dimension(100,30));
         Levt_sale = new JLabel("������");
         Levt_sale.setPreferredSize(new Dimension(100,30));
         
         CBevt_tp = new JComboBox<String>(Sevt_tp);
         CBevt_tp.setPreferredSize(new Dimension(100,30));
         CBevt_tp.addActionListener(this);
         
         Tevt_no = new JTextField(20);
         Tevt_no.setPreferredSize(new Dimension(100,30));
         Tevt_st_dt = new JTextField(20);
         Tevt_st_dt.setPreferredSize(new Dimension(100,30));
         Tevt_fn_dt = new JTextField(20);
         Tevt_fn_dt.setPreferredSize(new Dimension(100,30));
         Tevt_gift = new JTextField(20);
         Tevt_gift.setPreferredSize(new Dimension(100,30));
         Tevt_point = new JTextField(20);
         Tevt_point.setPreferredSize(new Dimension(100,30));
         Tevt_sale = new JTextField(20);
         Tevt_sale.setPreferredSize(new Dimension(100,30));
         
         
         Bregist = new JButton("���");
         Bregist.setPreferredSize(new Dimension(100,28));
         Bregist.addActionListener(this);
         
         evtRegisterView();
         
      }   
         
   private void evtRegisterView() {      
         
         
         gridbagconstraints.anchor = GridBagConstraints.WEST;
//         gridbagconstraints.ipadx = 7;
//         
//         gridbagconstraints.weightx=1.0;
//         gridbagconstraints.weighty=1.0;
         
         setLayout(gridbaglayout);
         gridbagconstraints.anchor = GridBagConstraints.CENTER;
         

         gridbagAdd(Bregist, 1, 9, 2, 1);

         gridbagconstraints.anchor = GridBagConstraints.WEST;
         
         gridbagAdd(evt_regist, 1, 1, 1, 1);

         gridbagAdd(Levt_no, 1, 2, 1, 1);
         gridbagAdd(Levt_tp, 1, 3, 1, 1);
         gridbagAdd(Levt_gift, 1, 4, 1, 1);
         gridbagAdd(Levt_point, 1, 5, 1, 1);
         gridbagAdd(Levt_sale, 1, 6, 1, 1);
         
         gridbagAdd(Levt_st_dt, 1, 7, 1, 1);
         gridbagAdd(Levt_fn_dt, 1, 8, 1, 1);
         
         gridbagAdd(Tevt_no, 2, 2, 1, 1);
         
         gridbagAdd(CBevt_tp, 2, 3, 1, 1);
         if(CBevt_tp.getSelectedItem() == "1+1�̺�Ʈ") {
				Levt_gift.setVisible(true);
				Levt_point.setVisible(false);
				Levt_sale.setVisible(false);
				Tevt_gift.setVisible(true);
				Tevt_point.setVisible(false);
				Tevt_sale.setVisible(false);
			}
         
         gridbagAdd(Tevt_gift, 2, 4, 1, 1);
         gridbagAdd(Tevt_point, 2, 5, 1, 1);
         gridbagAdd(Tevt_sale, 2, 6, 1, 1);
         
         gridbagAdd(Tevt_st_dt, 2, 7, 1, 1);
         gridbagAdd(Tevt_fn_dt, 2, 8, 1, 1);
         
         gridbagconstraints.anchor = GridBagConstraints.EAST;
         

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
    	  new evt_regist();
      }

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == CBevt_tp ) {
			if(CBevt_tp.getSelectedItem() == "1+1�̺�Ʈ") {
				Levt_gift.setVisible(true);
				Levt_point.setVisible(false);
				Levt_sale.setVisible(false);
				Tevt_gift.setVisible(true);
				Tevt_point.setVisible(false);
				Tevt_sale.setVisible(false);
			}else if(CBevt_tp.getSelectedItem() == "�����̺�Ʈ") {
				Levt_gift.setVisible(false);
				Levt_point.setVisible(false);
				Levt_sale.setVisible(true);
				Tevt_gift.setVisible(false);
				Tevt_point.setVisible(false);
				Tevt_sale.setVisible(true);
			}else if(CBevt_tp.getSelectedItem() == "����Ʈ�̺�Ʈ") {
				Levt_gift.setVisible(false);
				Levt_point.setVisible(true);
				Levt_sale.setVisible(false);
				Tevt_gift.setVisible(false);
				Tevt_point.setVisible(true);
				Tevt_sale.setVisible(false);
			}
		}
		
//		if(e.getSource() == Bregist) {
//			
//			int result = JOptionPane.showConfirmDialog(null, "�ش� �̺�Ʈ�� ����Ͻðڽ��ϱ�?", "�̺�Ʈ ��� Ȯ��", JOptionPane.YES_NO_OPTION,
//				    JOptionPane.INFORMATION_MESSAGE);
//					if(result == 0) {
//						//������ �޺��ڽ� �� ����
//						
//						evt_NO = Tevt_no.getText();
//						evt_tp = (String) CBevt_tp.getSelectedItem();
//						evt_st_dt = Tevt_st_dt.getText();
//						evt_fn_dt = Tevt_fn_dt.getText();
//						
//						evtData.initevtData(evt_NO,  evt_NM,  evt_DT,  evt_PH_NUM,  evt_TP,  evt_ADDR,  REG_TP,  REG_ID,  REG_PW);
//						evtData.createevt();
//						JOptionPane.showMessageDialog(null, "�̺�Ʈ�� ��ϵǾ����ϴ�.", "�̺�Ʈ ���",
//					               JOptionPane.WARNING_MESSAGE);
//						Tevt_no.setText("");
//						Tevt_st_dt.setText("");
//						Tevt_fn_dt.setText("");
//			
//		}else if(result ==1) {
//			JOptionPane.getRootFrame().dispose(); 
//		 }
//		}else if(e.getSource() == Bcancel) {
		
//   	 }
	}
}