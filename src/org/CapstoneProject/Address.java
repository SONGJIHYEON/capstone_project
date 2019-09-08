package org.CapstoneProject;

import java.awt.Component;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.w3c.dom.events.MouseEvent;

public class Address extends Dialog implements ActionListener, MouseListener{

   private JLabel mb_regist, mb_lookup, mb_lookup2, Lemp_no, Lemp_nm, Lemp_resi_num, Lemp_dt, Lemp_ph_num, Lemp_mail, Lemp_addr;      
         
   private JTextField  Tsearch, Temp_no, Temp_nm, Temp_resi_num, Temp_dt, Temp_ph_num, Temp_mail, Temp_addr;      
         
   private String[] col1 = {"우편번호", "일련번호", "시도", "시군구", "읍면동", "리", "번지", "아파트/건물명", "주소"};        
   
   private DefaultTableModel model1 = new DefaultTableModel(col1, 0);
   
   private JTable emp_info;
   private JScrollPane scrollpane1;
         
   private JButton bus_man,pro_man,od_man,mb_man,emp_man,Bregist,Bcancel,Bsearch, BtCancel, BtConfirm; 
   
   private JComboBox<String> cbSearch;      
   
   String addr, zipcode;   
   int close;
         
   GridBagLayout gridbaglayout;      
   GridBagConstraints gridbagconstraints;      // gridbag레이아웃에 컴포넌트의 위치를 잡아주는 역할
         
   public Address(JFrame fr) {      
         super(fr, "", true);
         gridbaglayout = new GridBagLayout();
         gridbagconstraints = new GridBagConstraints();
         
         Tsearch = new JTextField(30);
         Tsearch.addActionListener(this);
         Tsearch.setPreferredSize(new Dimension(100,30));
         
         emp_info = new JTable(model1);
         emp_info.addMouseListener(this);
         scrollpane1 = new JScrollPane(emp_info);
         scrollpane1.setPreferredSize(new Dimension(1000, 300));
         
         
         Bsearch = new JButton("검색");
         Bsearch.addActionListener(this);
         Bsearch.setPreferredSize(new Dimension(200,28));
         
         BtCancel = new JButton("닫기");
         BtCancel.addActionListener(this);
         BtConfirm = new JButton("확인");
         BtConfirm.addActionListener(this);
         
         getData(AddrData.selectAddr());
//         getSvpData(EmpData.selectSpv());
        
         addressView();
      }   
   
	private void getData(List<Map<String, Serializable>> addrListData) {
		
		for(int i=0; i < addrListData.size(); i++) {
			model1.addRow(new Object[] {
					
					addrListData.get(i).get("ZIPCODE"),
					addrListData.get(i).get("SEQ"),
					addrListData.get(i).get("SIDO"),
					addrListData.get(i).get("GUGUN"),
					addrListData.get(i).get("DONG"),
					addrListData.get(i).get("RI"),
					addrListData.get(i).get("BUNJI"),
					addrListData.get(i).get("BLDG"),
					addrListData.get(i).get("ADDR")

			});
		}
}
         
   private void addressView() {      
         setTitle("주소검색");
         
         gridbagconstraints.anchor = GridBagConstraints.WEST;
//         gridbagconstraints.ipadx = 7;
//         
//         gridbagconstraints.weightx=1.0;
//         gridbagconstraints.weighty=1.0;
         
         setLayout(gridbaglayout);
         gridbagconstraints.anchor = GridBagConstraints.CENTER;
         gridbagAdd(Tsearch, 1, 1, 1, 1);
         gridbagAdd(scrollpane1, 1, 2, 10, 5);
         gridbagAdd(BtConfirm, 2, 10, 2, 5);
         gridbagAdd(BtCancel, 3, 10, 2, 5);
         gridbagconstraints.anchor = GridBagConstraints.WEST;
         
         gridbagAdd(Bsearch, 2, 1, 1, 1);

         gridbagconstraints.anchor = GridBagConstraints.EAST;
         
         pack();
//         setResizable(false);
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
         new Address(new JFrame());
       
      }

	@Override
	public void mouseClicked(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		int row;
		if(e.getSource() == emp_info) {
			row = emp_info.getSelectedRow();
			addr = "";
			addr += emp_info.getValueAt(row, 8);
			zipcode = "";
			zipcode += emp_info.getValueAt(row, 0);
			System.out.println(addr);
		} 
	}

	@Override
	public void mousePressed(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == BtConfirm) {
			dispose();
		}else if(e.getSource() == BtCancel) {
			zipcode = "";
			addr = "";
			dispose();
		}
		if(e.getSource() == Bsearch) {
			model1.setRowCount(0);
			getData(AddrData.SearchAddr(Tsearch.getText()));
			
		}
	}   
      
//      public void actionPerformed(ActionEvent e) {
//		// TODO Auto-generated method stub
//		if(e.getSource() == Bsearch) {
//			JOptionPane.showConfirmDialog(null, "고객으로 등록하시겠습니까?", "등록 확인", JOptionPane.YES_NO_OPTION,
//		               JOptionPane.INFORMATION_MESSAGE);
//
//			if(close == 0) {
//				dispose();
//			}
//		}
//	}
         
}