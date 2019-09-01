package org.CapstoneProject;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
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

public class Mypage extends JFrame {   
	private JLabel vMypage, vAllPoint, vUsedPoint, vSerPoint, vAllMoney, v1, v2, v3, v4, v5;  
	         
	private JTextField xGrade1, xGrade2, xDiscount, xAllPoint, xUsedPoint, xSerPoint, xAllMoney;
	   
	private String[] col1 = {"부서명", "부서위치"};      
	private String[] col2 = {"부서명", "성명"};      
	private String[] div = {"관리자", "유저"}; // 사원구분 콤보박스의 목록
	         
	private DefaultTableModel model1 = new DefaultTableModel(col1, 0);      
	private DefaultTableModel model2 = new DefaultTableModel(col2, 0);      
	   
       
	private JTable eDept, eSpv;      
	private JScrollPane scrollpane1, scrollpane2;      
	         
	private JButton BtChange, BtOrder, BtPostView;  
	private JComboBox<String> cbSel;      
	         
	GridBagLayout gridbaglayout;      
	GridBagConstraints gridbagconstraints;      // gridbag레이아웃에 컴포넌트의 위치를 잡아주는 역할
	         
	public Mypage() {
		gridbaglayout = new GridBagLayout();
		gridbagconstraints = new GridBagConstraints();       
		
		vMypage = new JLabel("마이 페이지");
		vAllPoint = new JLabel("총 포인트");
		vUsedPoint = new JLabel("사용한 포인트");
		vSerPoint = new JLabel("사용가능 포인트");
		vAllMoney = new JLabel("총 주문금액");
		v1 = new JLabel("고객님은 현재");
		v2 = new JLabel("등급 입니다.");
		v3 = new JLabel("상품 구매시");
		v4 = new JLabel("추가할인혜택을 받으실 수 있습니다");
		v5 = new JLabel("등급 혜택");
		v5.setFont(new Font("", Font.BOLD, 11));
	         
//	    cbSel = new JComboBox<String>(div);
//	    cbSel.setPreferredSize(new Dimension(203, 20));
	    
//		xGrade1 = new JTextField(5);
		xGrade2 = new JTextField(5);
		xDiscount = new JTextField(5);
		xAllPoint = new JTextField(20);
		xUsedPoint = new JTextField(20);
		xSerPoint = new JTextField(20);
		xAllMoney = new JTextField(20);
	    
        
        BtChange = new JButton("내 정보변경");
        BtOrder = new JButton("주문 내역");
        BtPostView = new JButton("내 게시글 보기");
        
//	         getDeptData(EmpData.selectDept());
//	         getSvpData(EmpData.selectSpv());
        
        MypageView();
      }   
	         
	private void MypageView() {
		setTitle("Login 화면");
	         
	    gridbagconstraints.anchor = GridBagConstraints.WEST;
//	    gridbagconstraints.ipadx = 7;
//	    
//	    gridbagconstraints.weightx=1.0;
//      gridbagconstraints.weighty=1.0;
         
        setLayout(gridbaglayout);       
        gridbagconstraints.anchor = GridBagConstraints.CENTER;
	        
        gridbagAdd(vMypage, 3, 0, 1, 1);
        gridbagAdd(BtOrder, 3, 1, 1, 1);
        gridbagAdd(BtPostView, 4, 1, 1, 1);
        gridbagAdd(v5, 0, 2, 1, 2);
        gridbagAdd(xDiscount, 2, 3, 1, 1);
        gridbagAdd(vAllPoint, 0, 4, 1, 1);
        gridbagAdd(xAllPoint, 1, 4, 2, 1);
        gridbagAdd(vUsedPoint, 4, 4, 1, 1);
        gridbagAdd(xUsedPoint, 5, 4, 2, 1);
        gridbagAdd(vSerPoint, 0, 5, 1, 1);
        gridbagAdd(xSerPoint, 1, 5, 2, 1);
        gridbagAdd(vAllMoney, 4, 5, 1, 1);
        gridbagAdd(xAllMoney, 5, 5, 2, 1);       
        gridbagAdd(xGrade2, 2, 2, 1, 1);      

        gridbagconstraints.anchor = GridBagConstraints.EAST;    
        gridbagAdd(BtChange, 2, 1, 1, 1);
        gridbagAdd(v1, 1, 2, 1, 1);
        gridbagAdd(v3, 1, 3, 1, 1);
//        gridbagAdd(v5, 4, 3, 1, 1);
        
        gridbagconstraints.anchor = GridBagConstraints.WEST;   
        gridbagAdd(v2, 3, 2, 2, 1);
        gridbagAdd(v4, 3, 3, 2, 1);

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
		new Mypage();
    	 }   
}
	         

