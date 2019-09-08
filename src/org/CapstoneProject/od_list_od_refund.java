package org.CapstoneProject;

import java.awt.Component;
import java.awt.Dimension;
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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class od_list_od_refund extends JPanel implements ActionListener, MouseListener  {

   private JLabel od_refund;      
         
   private JTextField  Tsearch;      
         
   private String[] col1 = {"No", "주문번호", "상품번호", "수량","사유", "환불계좌정보"};  
   private String[] search = {"주문번호", "상품번호"};      
         
   private DefaultTableModel model1 = new DefaultTableModel(col1, 0);  
         
   private JTable od_info;      
   private JScrollPane scrollpane1;      
         
   private JButton Bsearch,reset;      
   private JComboBox<String> cbSearch;      
         
   GridBagLayout gridbaglayout;      
   GridBagConstraints gridbagconstraints;      // gridbag레이아웃에 컴포넌트의 위치를 잡아주는 역할
         
   public od_list_od_refund() {      
         
         gridbaglayout = new GridBagLayout();
         gridbagconstraints = new GridBagConstraints();
         
         od_refund = new JLabel("주문관리(환불신청)");
         od_refund.setPreferredSize(new Dimension(200,28));
        
         cbSearch = new JComboBox<String>(search);
         cbSearch.setPreferredSize(new Dimension(200,28));
         
         Tsearch = new JTextField();
         Tsearch.setPreferredSize(new Dimension(200,28));
         od_info = new JTable(model1);
//         eDept.addMouseListener(new JTableMouseListener());
         scrollpane1 = new JScrollPane(od_info);
         
         scrollpane1.setPreferredSize(new Dimension(1000, 300));
         
         
         Bsearch = new JButton("검색");
         Bsearch.setPreferredSize(new Dimension(100,28));
         reset = new JButton("초기화");
         reset.setPreferredSize(new Dimension(100,28));
         
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

         gridbagconstraints.anchor = GridBagConstraints.WEST;
         
         gridbagAdd(od_refund, 1, 1, 1, 1);
         gridbagAdd(cbSearch, 1, 2, 1, 1);
         gridbagAdd(Tsearch, 2, 2, 1, 1);
         gridbagAdd(Bsearch, 3, 2, 1, 1);
         gridbagconstraints.anchor = GridBagConstraints.EAST;
         gridbagAdd(reset, 3, 2, 1, 1);
     
         gridbagAdd(scrollpane1, 1, 3, 5, 5);

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
         new od_list_od_refund();
      }

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}   
         
}