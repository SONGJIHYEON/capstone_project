
package org.CapstoneProject;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class MemOrdPg extends JPanel implements ActionListener, MouseListener {
	private JLabel vOrdName, vAddr, vPhone, vOpDeliv, vRecipiant, vRecipAddr, vRecipPhone, vDeliveMsg, vGradeDis,
			vUsedPoint, vProPrice, vAllDiscout, vPrice, vPoint, v1, vDepositNm, vDepositBk;
	private JTextField xOrdName, xAddr, xPhone, xRecipiant, xRecipAddr, xRecipPhone, xDeliveMsg, xGradeDis, xUsedPoint,
			xProPrice, xAllDiscout, xPrice, xDepositNm, xDepositBk;

	private String[] col1 = { "이미지", "상품정보", "수량", "단가", "금액", "포인트" };
	private String[] col2 = { "농협", "국민은행", "우리은행", "수협" };
	private String[] div = { "관리자", "유저" }; // 사원구분 콤보박스의 목록

	private DefaultTableModel model1 = new DefaultTableModel(col1, 0);
//	private DefaultTableModel model2 = new DefaultTableModel(col2, 0);      

	private JRadioButton rSameAddr, rNewAddr, rBank, rCard, rDeposit;
	private ButtonGroup BtRadio, BtRadio2;
	private JTable tProInfo;
	private JScrollPane scrollpane1;
	private JPanel pRadio, pRadio2;

	private JButton BtOrder, BtBack, BtPoint;
	private JComboBox<String> cbBk;
	
	static ArrayList<String> arList = new ArrayList<>();
	
	String cust_nm, cust_addr, cust_phone, pro_price, cust_disc_rt, cust_point, cust_num, od_price, orderNum, used_point, payNum,
			rBankTxt;

	double sum2, cust_price, disc_rt, price;
	String[] array;
	
	GridBagLayout gridbaglayout;
	GridBagConstraints gridbagconstraints;
 
	private ArrayList<String> getData(List<Map<String, Serializable>> BasketListData) {
		model1.setRowCount(0);
//		ar = new String[BasketListData.size()];
		sum2 = 0;
		for (int i = 0; i < BasketListData.size(); i++) {
			BasketListData.get(i).get("pro.pro_num");
			sum2 = sum2 + Double.valueOf(BasketListData.get(i).get("PR").toString());
			model1.addRow(new Object[] { 
					BasketListData.get(i).get("MODEL_IMG1"), 
					BasketListData.get(i).get("PRO_NM"),
					BasketListData.get(i).get("QUANT"),
					BasketListData.get(i).get("UP"),
					BasketListData.get(i).get("PR"),
					BasketListData.get(i).get("POINT"), });
			
			arList.add(BasketListData.get(i).get("pro.pro_num").toString());
			arList.add(BasketListData.get(i).get("QUANT").toString());
			arList.add(BasketListData.get(i).get("UP").toString());
			arList.add(BasketListData.get(i).get("PR").toString());

			String[] array = arList.toArray(new String[arList.size()]);

		}

		pro_price = String.valueOf(sum2);
		xGradeDis.setText(cust_disc_rt + "%");
		disc_rt = Double.valueOf(Login.user_disc_rt) * 0.01;
		xProPrice.setText(pro_price);
		price = sum2 - (sum2 * disc_rt);
		xAllDiscout.setText(String.valueOf(sum2 * disc_rt));
		xPrice.setText(String.valueOf(price));
		
		return arList;
	}

	public MemOrdPg() {


		gridbaglayout = new GridBagLayout();
		gridbagconstraints = new GridBagConstraints();
		
		cust_num = Login.user_num;
		cust_nm = Login.user_nm;
		cust_addr = Login.user_addr;
		cust_phone = Login.user_phone;
		cust_disc_rt = Login.user_disc_rt;
		cust_point = Login.user_point;

		vOrdName = new JLabel("주문자명");
		vAddr = new JLabel("주문자 주소");
		vPhone = new JLabel("휴대번호");
		vOpDeliv = new JLabel("배송지 선택");
		vRecipiant = new JLabel("수령인명");
		vRecipAddr = new JLabel("수령 주소");
		vRecipPhone = new JLabel("수령인 휴대번호");
		vDeliveMsg = new JLabel("배송 메시지");
		vGradeDis = new JLabel("등급 할인");
		vUsedPoint = new JLabel("사용 포인트");
		vPoint = new JLabel("보유 포인트");
		vPoint.addMouseListener(this);
		vPoint.setText("보유 포인트 : " + cust_point + "point");
		vProPrice = new JLabel("총 상품가격");
		vAllDiscout = new JLabel("총 할인금액");
		vPrice = new JLabel("결제 가격");
		vDepositNm = new JLabel("입금자명");
		vDepositBk = new JLabel("입금은행");
		v1 = new JLabel("");
		v1.setPreferredSize(new Dimension(50, 28));

		xOrdName = new JTextField(10);
		xOrdName.setText(cust_nm);
		xAddr = new JTextField(10);
		xAddr.setText(cust_addr);
		xPhone = new JTextField(10);
		xPhone.setText(cust_phone);
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
		rSameAddr.addActionListener(this);
		rNewAddr = new JRadioButton("새로운 배송지");
		rNewAddr.addActionListener(this);
		BtRadio = new ButtonGroup();
		BtRadio.add(rNewAddr);
		BtRadio.add(rSameAddr);
		pRadio = new JPanel(new FlowLayout(FlowLayout.CENTER));
		pRadio.add(rNewAddr);
		pRadio.add(rSameAddr);

		rBank = new JRadioButton("계좌이체");
		rBank.addActionListener(this);
		rCard = new JRadioButton("신용카드");
		rCard.addActionListener(this);
//		rDeposit = new JRadioButton("무통장 입금");
		BtRadio2 = new ButtonGroup();
		BtRadio2.add(rBank);
		BtRadio2.add(rCard);
//		BtRadio2.add(rDeposit);
		pRadio2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		pRadio2.add(rBank);
		pRadio2.add(rCard);
//		pRadio2.add(rDeposit);

		BtPoint = new JButton("사용");
		BtPoint.addActionListener(this);

		cbBk = new JComboBox<String>(col2);
		cbBk.setPreferredSize(new Dimension(100, 28));
		BtOrder = new JButton("주문하기");
		BtOrder.addActionListener(this);
		BtBack = new JButton("이전 페이지");
		BtBack.addActionListener(this);

		getData(BasketData.selectBasket(cust_num));
		MemOrdPgView();
	}
	
	public String getData2(List<Map<String, Serializable>> OrderListData) {
		orderNum = "";
		orderNum += OrderListData.get(0).get("od_num").toString(); 

		return orderNum;
	}
	
	public String getData3(List<Map<String, Serializable>> PayListData) {
		payNum = "";
		payNum += PayListData.get(0).get("pay_num").toString(); 

		return payNum;
	}

	private void MemOrdPgView() {

//		setTitle("사원 등록");

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
		gridbagAdd(vOpDeliv, 0, 16, 1, 1);
		gridbagAdd(vRecipiant, 0, 17, 1, 1);
		gridbagAdd(vRecipAddr, 0, 18, 1, 1);
		gridbagAdd(vRecipPhone, 0, 19, 1, 1);
		gridbagAdd(vDeliveMsg, 0, 20, 1, 1);
		gridbagAdd(xOrdName, 1, 13, 1, 1);
		gridbagAdd(xAddr, 1, 14, 1, 1);
		gridbagAdd(xPhone, 1, 15, 1, 1);
		gridbagAdd(pRadio, 1, 16, 1, 1);
		gridbagAdd(xRecipiant, 1, 17, 1, 1);
		gridbagAdd(xRecipAddr, 1, 18, 1, 1);
		gridbagAdd(xRecipPhone, 1, 19, 1, 1);
		gridbagAdd(xDeliveMsg, 1, 20, 1, 1);

		gridbagconstraints.anchor = GridBagConstraints.CENTER;
		gridbagAdd(v1, 2, 13, 1, 1);
		gridbagAdd(vGradeDis, 3, 13, 1, 1);
		gridbagAdd(vUsedPoint, 3, 14, 1, 1);
		gridbagAdd(vProPrice, 3, 15, 1, 1);
		gridbagAdd(vAllDiscout, 3, 16, 1, 1);
		gridbagAdd(vPrice, 3, 17, 1, 1);
		gridbagAdd(xGradeDis, 4, 13, 1, 1);
		gridbagAdd(xUsedPoint, 4, 14, 1, 1);
		gridbagAdd(xProPrice, 4, 15, 1, 1);
		gridbagAdd(xAllDiscout, 4, 16, 1, 1);
		gridbagAdd(xPrice, 4, 17, 1, 1);
		gridbagAdd(pRadio2, 3, 18, 2, 1);
		gridbagAdd(vDepositNm, 3, 19, 1, 1);
		gridbagAdd(vDepositBk, 3, 20, 1, 1);
		gridbagAdd(xDepositNm, 4, 19, 1, 1);
		gridbagAdd(cbBk, 4, 20, 1, 1);

		gridbagconstraints.anchor = GridBagConstraints.EAST;
		gridbagAdd(BtOrder, 5, 21, 1, 1);

		gridbagconstraints.anchor = GridBagConstraints.WEST;
		gridbagAdd(BtBack, 6, 21, 1, 1);
		gridbagAdd(vPoint, 6, 14, 1, 1);
		gridbagAdd(BtPoint, 5, 14, 1, 1);

//		setExtendedState(MAXIMIZED_BOTH);
		setVisible(true);
	}

	private void gridbagAdd(Component c, int x, int y, int w, int h) {
		gridbagconstraints.gridx = x;
		gridbagconstraints.gridy = y;
		// 가장 왼쪽 위 gridx, gridy값은 0

		gridbagconstraints.gridwidth = w;
		gridbagconstraints.gridheight = h;

		gridbaglayout.setConstraints(c, gridbagconstraints); // 컴포넌트를 컴포넌트 위치+크기 정보에 따라 GridBagLayout에 배치

		add(c);

	}

	public static void main(String[] args) {
		new MemOrdPg();
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == BtBack) {
//			dispose();
		} else if (e.getSource() == rSameAddr) {
			xRecipiant.setText(xOrdName.getText());
			xRecipAddr.setText(xAddr.getText());
			xRecipPhone.setText(xPhone.getText());
		} else if (e.getSource() == rNewAddr) {
			xRecipiant.setText("");
			xRecipAddr.setText("");
			xRecipPhone.setText("");
		} if (e.getSource() == BtPoint) {
			if(xUsedPoint.getText() != null) {
				if(Double.valueOf(xUsedPoint.getText()) > Double.valueOf(cust_point))
					JOptionPane.showMessageDialog(null, "보유된 포인트가 부족합니다", "", JOptionPane.INFORMATION_MESSAGE);
				else {
					double discount = sum2 * disc_rt + Double.valueOf(xUsedPoint.getText());
					xAllDiscout.setText(String.valueOf(discount));
					xPrice.setText(String.valueOf(sum2 - discount));
				}
			}
		} if(rBank.isSelected() == true) {
			if(e.getSource() == BtOrder) {
				rBankTxt = rBank.getText();
				od_price = xPrice.getText();
				OrderData.createOrder1(cust_num, od_price);
				getData2(OrderData.selectOd_Num());
				OrderData.createOrder3(orderNum);
				PayData.createPay(orderNum, String.valueOf(price));
				getData3(PayData.selectPay_Num());
				if(!xUsedPoint.getText().equals("")) {
					used_point = xUsedPoint.getText();
					PayData.createPayBrkdwn1(payNum, Double.valueOf(od_price), Double.valueOf(used_point));
				}else 
					PayData.createPayBrkdwn2(payNum, price);
				}
		} else if(rCard.isSelected() == true) {
			if(e.getSource() == BtOrder) {
				System.out.println(price);
				od_price = xPrice.getText();
				OrderData.createOrder2(cust_num, od_price);
				getData2(OrderData.selectOd_Num());
				PayData.createPay(orderNum, String.valueOf(price));
				getData3(PayData.selectPay_Num());
				if(!xUsedPoint.getText().equals("")) {
					used_point = xUsedPoint.getText();
					PayData.createPayBrkdwn3(payNum, Double.valueOf(od_price), Double.valueOf(used_point));
				}else
					PayData.createPayBrkdwn4(payNum, price);
				}
			}
		} 	

	@Override
	public void mouseClicked(MouseEvent e) {

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
