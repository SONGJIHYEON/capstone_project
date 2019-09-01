package org.CapstoneProject;
import java.awt.Component;
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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Basket extends JFrame {   
	private JLabel vProPrice, vDiscout, vPrice;     
	         
	private JTextField  xProPrice, xDiscout, xPrice;        
	   
	private String[] col1 = {"no", "이미지", "상품정보", "수량", "포인트", "금액", "선택"};
//	private String[] col2 = {"부서명", "성명"};      
	private String[] div = {"관리자", "유저"}; // 사원구분 콤보박스의 목록
	         
	private DefaultTableModel model1 = new DefaultTableModel(col1, 0);      
//	private DefaultTableModel model2 = new DefaultTableModel(col2, 0);      
	
	private JTable tProInfo;      
	private JScrollPane scrollpane1;
	         
	private JButton BtOrder, BtShopping, BtDelBasket;
//	private JComboBox<String> cbSel;      
	         
	GridBagLayout gridbaglayout;      
	GridBagConstraints gridbagconstraints;      // gridbag레이아웃에 컴포넌트의 위치를 잡아주는 역할
	         
	public Basket() {
		
        gridbaglayout = new GridBagLayout();
        gridbagconstraints = new GridBagConstraints();
        
        vProPrice = new JLabel("총 상품가격");
        vDiscout = new JLabel("등급 할인");
        vPrice = new JLabel("총 금액");
        
        xProPrice = new JTextField(10);
        xDiscout = new JTextField(10);
        xPrice = new JTextField(10);
        
        
        tProInfo = new JTable(model1);
        scrollpane1 = new JScrollPane(tProInfo);
        scrollpane1.setPreferredSize(new Dimension(750, 100));
		
        BtOrder = new JButton("주문하기");
//        BtOrder.setPreferredSize(new Dimension(130,28));
        BtShopping = new JButton("쇼핑 계속하기");
        BtShopping.setPreferredSize(new Dimension(130,28));
        BtDelBasket = new JButton("장바구니 비우기");
        BtDelBasket.setPreferredSize(new Dimension(130,28));
//        regist.addActionListener(this);
        
        BasketView();
      }   
	         
	private void BasketView() {
		
        setTitle("사원 등록");
        
//        gridbagconstraints.ipadx = 7;
//        
//        gridbagconstraints.weightx=1.0;
//        gridbagconstraints.weighty=1.0;
        
        setLayout(gridbaglayout);
        
        gridbagconstraints.anchor = GridBagConstraints.CENTER;
        gridbagAdd(scrollpane1, 0, 0, 12, 1);
        gridbagAdd(vProPrice, 0, 12, 1, 1);
        gridbagAdd(vDiscout, 2, 12, 1, 1);
        gridbagAdd(vPrice, 4, 12, 1, 1);
        gridbagAdd(xProPrice, 1, 12, 1, 1);
        gridbagAdd(xDiscout, 3, 12, 1, 1);
        gridbagAdd(xPrice, 5, 12, 1, 1);
        gridbagconstraints.anchor = GridBagConstraints.EAST;
        gridbagAdd(BtDelBasket, 11, 12, 1, 1);
        gridbagAdd(BtShopping, 11, 13, 1, 1);
        gridbagconstraints.anchor = GridBagConstraints.WEST;
        gridbagAdd(BtOrder, 10, 13, 1, 1);
        
        setExtendedState(MAXIMIZED_BOTH);
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
		new Basket();
    	 }   
	
//	public void actionPerformed(ActionEvent e) {
//		// TODO Auto-generated method stub
//		if(e.getSource() == BtRegMb) {
//			RegMember r = new RegMember(new JFrame());
//
//		} else if(e.getSource() == BtFind) {
//			Find f = new Find(new JFrame());
//		} else if(e.getSource() == Btnonmember) {
//			nonmem n = new nonmem(new JFrame());
//		}
//	}
}
	         

