package org.CapstoneProject;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class NonOrdPg extends JFrame {   
	private JLabel vOrdName, vAddr, vPhone, vOpDeliv, vRecipiant, vRecipAddr, vRecipPhone, vDeliveMsg,
	vGradeDis, vUsedPoint, vProPrice, vAllDiscout, vPrice, vPoint, v1, vDepositNm, vDepositBk, vOrderPw, vOrderPw2;   
	private JTextField  xOrdName, xAddr, xPhone, xRecipiant, xRecipAddr, xRecipPhone, xDeliveMsg, xGradeDis, xUsedPoint,
	xProPrice, xAllDiscout, xPrice, xDepositNm, xDepositBk, xOrderPw, xOrderPw2;;         
	   
	private String[] col1 = {"no", "이미지", "상품정보", "수량", "배송비", "금액", "선택"};
	private String[] col2 = {"농협", "국민은행", "우리은행", "수협"};      
	private String[] div = {"관리자", "유저"}; // 사원구분 콤보박스의 목록
	         
	private DefaultTableModel model1 = new DefaultTableModel(col1, 0);      
//	private DefaultTableModel model2 = new DefaultTableModel(col2, 0);      
	
	private JRadioButton rSameAddr, rNewAddr, rBank, rCard, rDeposit;
	private ButtonGroup BtRadio, BtRadio2;
	private JTable tProInfo;      
	private JScrollPane scrollpane1;
	private JPanel pRadio, pRadio2;
	         
	private JButton BtOrder, BtBack;
	private JComboBox<String> cbBk;      
	         
	GridBagLayout gridbaglayout;      
	GridBagConstraints gridbagconstraints;      // gridbag레이아웃에 컴포넌트의 위치를 잡아주는 역할
	         
	public NonOrdPg() {
		
        gridbaglayout = new GridBagLayout();
        gridbagconstraints = new GridBagConstraints();
        
        vOrdName = new JLabel("주문자명");
        vAddr = new JLabel("주문자 주소");
        vPhone = new JLabel("휴대번호");
        vOrderPw = new JLabel("주문조회 비밀번호");
        vOrderPw2 = new JLabel("주문조회 비밀번호 확인");
        vOpDeliv = new JLabel("배송지 선택");
        vRecipiant = new JLabel("수령인명");
        vRecipAddr = new JLabel("수령 주소");
        vRecipPhone = new JLabel("수령인 휴대번호");
        vDeliveMsg = new JLabel("배송 메시지");
        vGradeDis = new JLabel("등급 할인");
        vUsedPoint = new JLabel("사용 포인트");
        vPoint = new JLabel("보유 포인트");
        vProPrice = new JLabel("총 상품가격");
        vAllDiscout = new JLabel("총 할인금액");
        vPrice = new JLabel("결제 가격");
        vDepositNm = new JLabel("입금자명");
        vDepositBk = new JLabel("입금은행");
        v1 = new JLabel("");
        v1.setPreferredSize(new Dimension(50, 28));

        xOrdName = new JTextField(10);
        xAddr = new JTextField(10);
        xPhone = new JTextField(10);
        xOrderPw = new JPasswordField(10);
        xOrderPw2 = new JPasswordField(10);
        xRecipiant = new JTextField(10); 
        xRecipAddr = new JTextField(10);
        xRecipPhone = new JTextField(10);
        xDeliveMsg = new JTextField(10);
        xGradeDis = new JTextField(10);
        xUsedPoint = new JTextField(10);
        xProPrice = new JTextField(10);
        xAllDiscout = new JTextField(10);
        xPrice = new JTextField(10);
        xDepositNm = new JTextField(10);
        
        tProInfo = new JTable(model1);
        scrollpane1 = new JScrollPane(tProInfo);
//        scrollpane1.setRowHeaderView(tProInfo);
        scrollpane1.setPreferredSize(new Dimension(750, 100));
        
        rSameAddr = new JRadioButton("주문자와 동일");
        rNewAddr = new JRadioButton("새로운 배송지");
        BtRadio = new ButtonGroup();
        BtRadio.add(rNewAddr);
        BtRadio.add(rSameAddr);
        pRadio = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pRadio.add(rNewAddr);
        pRadio.add(rSameAddr);
        
        rBank = new JRadioButton("계좌이체");
        rCard = new JRadioButton("신용카드");
        rDeposit = new JRadioButton("무통장 입금");
        BtRadio2 = new ButtonGroup();
        BtRadio2.add(rBank);
        BtRadio2.add(rCard);
        BtRadio2.add(rDeposit);
        pRadio2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pRadio2.add(rBank);
        pRadio2.add(rCard);
        pRadio2.add(rDeposit);
        
        cbBk = new JComboBox<String>(col2);
        cbBk.setPreferredSize(new Dimension(100, 28));
        BtOrder = new JButton("주문하기");
//        BtOrder.setPreferredSize(new Dimension(130,28));
        BtBack = new JButton("이전 페이지");

//        regist.addActionListener(this);
        
        NonOrdPgView();
      }   
	         
	private void NonOrdPgView() {
		
        setTitle("사원 등록");
        
//        gridbagconstraints.ipadx = 7;
//        
//        gridbagconstraints.weightx=1.0;
//        gridbagconstraints.weighty=1.0;
        

        setLayout(gridbaglayout);
        
//        gridbagconstraints.anchor = GridBagConstraints.WEST;
        gridbagconstraints.anchor = GridBagConstraints.CENTER;
        gridbagAdd(scrollpane1, 0, 0, 12, 1);
        gridbagAdd(vOrdName, 0, 13, 1, 1);
        gridbagAdd(vAddr, 0, 14, 1, 1);
        gridbagAdd(vPhone, 0, 15, 1, 1);
        gridbagAdd(vOrderPw, 0, 16, 1, 1);
        gridbagAdd(vOrderPw2, 0, 17, 1, 1);
        gridbagAdd(vOpDeliv, 0, 18, 1, 1);
        gridbagAdd(vRecipiant, 0, 19, 1, 1);
        gridbagAdd(vRecipAddr, 0, 20, 1, 1);
        gridbagAdd(vRecipPhone, 0, 21, 1, 1);
        gridbagAdd(vDeliveMsg, 0, 22, 1, 1);

        gridbagAdd(xOrdName, 1, 13, 1, 1);
        gridbagAdd(xAddr, 1, 14, 1, 1);
        gridbagAdd(xPhone, 1, 15, 1, 1);
        gridbagAdd(xOrderPw, 1, 16, 1, 1);
        gridbagAdd(xOrderPw2, 1, 17, 1, 1);
        gridbagAdd(pRadio, 1, 18, 1, 1);
        gridbagAdd(xRecipiant, 1, 19, 1, 1);
        gridbagAdd(xRecipAddr, 1, 20, 1, 1);
        gridbagAdd(xRecipPhone, 1, 21, 1, 1);
        gridbagAdd(xDeliveMsg, 1, 22, 1, 1);
        

        gridbagconstraints.anchor = GridBagConstraints.CENTER;
        gridbagAdd(v1, 2, 13, 1, 1);
//        gridbagAdd(vGradeDis, 3, 13, 1, 1);
//        gridbagAdd(vUsedPoint, 3, 14, 1, 1);
        gridbagAdd(vProPrice, 3, 13, 1, 1);
//        gridbagAdd(vAllDiscout, 3, 16, 1, 1);
        gridbagAdd(vPrice, 3, 14, 1, 1);
//        gridbagAdd(xGradeDis, 4, 13, 1, 1);
//        gridbagAdd(xUsedPoint, 4, 14, 1, 1);
        gridbagAdd(xProPrice, 4, 13, 1, 1);
//        gridbagAdd(xAllDiscout, 4, 16, 1, 1);
        gridbagAdd(xPrice, 4, 14, 1, 1);
        gridbagAdd(pRadio2, 3, 19, 2, 1);
        gridbagAdd(vDepositNm, 3, 20, 1, 1);
        gridbagAdd(vDepositBk, 3, 21, 1, 1);
        gridbagAdd(xDepositNm, 4, 20, 1, 1);
        gridbagAdd(cbBk, 4, 21, 1, 1);

        gridbagconstraints.anchor = GridBagConstraints.EAST;
        gridbagAdd(BtOrder, 5, 22, 1, 1);
        
        gridbagconstraints.anchor = GridBagConstraints.WEST;
        gridbagAdd(BtBack, 6, 22, 1, 1);
//        gridbagAdd(vPoint, 5, 14, 1, 1);
        
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
		new NonOrdPg();
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
	         

