
package org.CapstoneProject;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
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

public class Mypage extends JPanel implements ActionListener {
	private JLabel vMypage, vAllPoint, vUsedPoint, vSerPoint, vAllMoney, v1, v2, v3, v4, v5, v6, vGrade, vDiscount;

	private JTextField xGrade1, xGrade2, xDiscount, xAllPoint, xUsedPoint, xSerPoint, xAllMoney;

	private String[] col1 = { "부서명", "부서위치" };
	private String[] col2 = { "부서명", "성명" };
	private String[] div = { "관리자", "유저" }; // 사원구분 콤보박스의 목록

	private DefaultTableModel model1 = new DefaultTableModel(col1, 0);
	private DefaultTableModel model2 = new DefaultTableModel(col2, 0);

	private JTable eDept, eSpv;
	private JScrollPane scrollpane1, scrollpane2;

	String user_id, user_grade, user_disc_rt, user_point;

	private JButton BtChange, BtOrder, BtPostView;
	private JComboBox<String> cbSel;

	GridBagLayout gridbaglayout;
	GridBagConstraints gridbagconstraints; // gridbag레이아웃에 컴포넌트의 위치를 잡아주는 역할
	JPanel Od_list = new Od_list_user();

	public Mypage() {
		user_grade = Login.user_grade;
		user_disc_rt = Login.user_disc_rt;
		user_point = Login.user_point;

		gridbaglayout = new GridBagLayout();
		gridbagconstraints = new GridBagConstraints();

		vMypage = new JLabel("마이 페이지");
		vMypage.setFont(new Font("휴먼매직체", Font.PLAIN, 30));
		vMypage.setPreferredSize(new Dimension(140, 35));

		vAllPoint = new JLabel("총 포인트");
		vAllPoint.setFont(new Font("휴먼매직체", Font.PLAIN, 17));
		vUsedPoint = new JLabel("사용한 포인트");
		vUsedPoint.setFont(new Font("휴먼매직체", Font.PLAIN, 17));
		vSerPoint = new JLabel("사용가능 포인트");
		vSerPoint.setFont(new Font("휴먼매직체", Font.PLAIN, 17));
		vAllMoney = new JLabel("총 주문금액");
		vAllMoney.setFont(new Font("휴먼매직체", Font.PLAIN, 17));

		v1 = new JLabel("고객님은 현재");
		v1.setFont(new Font("휴먼매직체", Font.PLAIN, 17));
		v2 = new JLabel("등급 입니다");
		v2.setFont(new Font("휴먼매직체", Font.PLAIN, 17));
		v3 = new JLabel("상품 구매시");
		v3.setFont(new Font("휴먼매직체", Font.PLAIN, 17));
		v4 = new JLabel("추가할인혜택");
		v4.setFont(new Font("휴먼매직체", Font.PLAIN, 17));
		v5 = new JLabel("  ");
		v5.setFont(new Font("휴먼매직체", Font.PLAIN, 30));
		v6 = new JLabel("  ");
		v6.setFont(new Font("휴먼매직체", Font.PLAIN, 30));

//	    cbSel = new JComboBox<String>(div);
//	    cbSel.setPreferredSize(new Dimension(203, 20));

//		xGrade1 = new JTextField(5);
		vGrade = new JLabel(user_grade);
		vGrade.setFont(new Font("휴먼매직체", Font.BOLD, 17));
		vDiscount = new JLabel(user_disc_rt + "%");
		vDiscount.setFont(new Font("휴먼매직체", Font.BOLD, 17));

		xAllPoint = new JTextField(10);
		xUsedPoint = new JTextField(10);
		xSerPoint = new JTextField(10);
		xAllMoney = new JTextField(10);

		BtChange = new JButton("내 정보변경");
		BtChange.addActionListener(this);
		BtChange.setPreferredSize(new Dimension(120, 30));
		BtChange.setFocusPainted(false);
		BtChange.setBackground(Color.white);
		BtChange.setFont(new Font("휴먼매직체", Font.PLAIN, 17));

		BtOrder = new JButton("주문 내역");
		BtOrder.setPreferredSize(new Dimension(120, 30));
		BtOrder.setFocusPainted(false);
		BtOrder.setBackground(Color.white);
		BtOrder.setFont(new Font("휴먼매직체", Font.PLAIN, 17));

		BtPostView = new JButton("게시글 보기");
		BtPostView.setPreferredSize(new Dimension(120, 30));
		BtPostView.setFocusPainted(false);
		BtPostView.setBackground(Color.white);
		BtPostView.setFont(new Font("휴먼매직체", Font.PLAIN, 17));

		Od_list = new Od_list_user();
		Od_list.setSize(400, 200);

//	         getDeptData(EmpData.selectDept());
//	         getSvpData(EmpData.selectSpv());

		MypageView();
	}

	private void MypageView() {
//		setTitle("Login 화면");
		setLayout(gridbaglayout);

		gridbagconstraints.anchor = GridBagConstraints.WEST;
//	    gridbagconstraints.ipadx = 7;
//	    
//	    gridbagconstraints.weightx=1.0;
//      gridbagconstraints.weighty=1.0;

		gridbagconstraints.anchor = GridBagConstraints.CENTER;

		gridbagAdd(v5, 0, 0, 3, 2);
		gridbagAdd(vMypage, 0, 2, 3, 1);
		gridbagAdd(BtChange, 0, 3, 3, 1);
		gridbagAdd(v1, 0, 4, 1, 1);
		gridbagAdd(vGrade, 1, 4, 1, 1);
		gridbagAdd(v2, 2, 4, 1, 1);

		gridbagAdd(v3, 0, 5, 1, 1);
		gridbagAdd(vDiscount, 1, 5, 1, 1);
		gridbagAdd(v4, 2, 5, 1, 1);

		gridbagAdd(v6, 0, 6, 1, 1);

		gridbagAdd(vAllPoint, 0, 7, 2, 1);
		gridbagAdd(xAllPoint, 2, 7, 1, 1);
		gridbagAdd(vUsedPoint, 0, 8, 2, 1);
		gridbagAdd(xUsedPoint, 2, 8, 1, 1);
		gridbagAdd(vSerPoint, 0, 9, 2, 1);
		gridbagAdd(xSerPoint, 2, 9, 1, 1);
		gridbagAdd(vAllMoney, 0, 10, 2, 1);
		gridbagAdd(xAllMoney, 2, 10, 1, 1);

		gridbagconstraints.anchor = GridBagConstraints.EAST;
		gridbagAdd(Od_list, 3, 0, 2, 6);
//		gridbagAdd(MyPost, 3, 3, 2, 3);

		gridbagconstraints.anchor = GridBagConstraints.WEST;

//        setExtendedState(MAXIMIZED_BOTH);
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
		new Mypage();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == BtChange) {
			new ModiMember(new JFrame());
		}

	}
}
