package org.CapstoneProject;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ProDetail extends JFrame implements ActionListener, MouseListener {
	private JLabel vProImg, vProNm, vPrice, vColor, vSize, vOption, vAllPrice;

	private JTextField xPrice, xOption, xAllPrice;

	private String[] size1 = { "90", "95", "100", "105", "110" };
	private String[] size2 = { "27", "28", "29", "30", "31", "32", "33", "34", "35" };

//	private String[] col1 = {"", "�μ���ġ"};      
//	private String[] col2 = {"�μ���", "����"};      
//	private String[] div = {"������", "����"}; // ������� �޺��ڽ��� ���

//	private DefaultTableModel model1 = new DefaultTableModel(col1, 0);      
//	private DefaultTableModel model2 = new DefaultTableModel(col2, 0);      

	private JTable eDept, eSpv;
	private JScrollPane scrollpane1, scrollpane2;

	private JButton BtPurchae, BtBasket, BtPlus, BtMinus;
	private JComboBox<String> CbSize1, CbSize2;
	private JTabbedPane t;
	JTextArea ta = new JTextArea(22, 30);
	static JPanel p = new JPanel();

	String price, option, allprice;

	int intprice, intoption, intallprice;

	GridBagLayout gridbaglayout;
	GridBagConstraints gridbagconstraints; // gridbag���̾ƿ��� ������Ʈ�� ��ġ�� ����ִ� ����

	public ProDetail() {
		gridbaglayout = new GridBagLayout();
		gridbagconstraints = new GridBagConstraints();

		vProImg = new JLabel();
		vPrice = new JLabel("����");
		vColor = new JLabel("����");
		vSize = new JLabel("������");
		vOption = new JLabel("���� ����");
		vAllPrice = new JLabel("�� ��ǰ����");
		vProNm = new JLabel("DB���� ��ǰ�̸�");

//	    cbSel = new JComboBox<String>(div);
//	    cbSel.setPreferredSize(new Dimension(203, 20));

		xPrice = new JTextField(20);
		xPrice.setText("10000");
		xOption = new JTextField(3);
		xOption.setText("1");
		xAllPrice = new JTextField(20);
		xAllPrice.addMouseListener(this);
		xAllPrice.setText(xPrice.getText());

		BtPlus = new JButton("��");
		BtPlus.setPreferredSize(new Dimension(45, 20));
		BtPlus.addActionListener(this);
		BtMinus = new JButton("��");
		BtMinus.setPreferredSize(new Dimension(45, 20));
		BtMinus.addActionListener(this);
		BtPurchae = new JButton("�����ϱ�");
		BtBasket = new JButton("��ٱ���");

		JPanel p1 = new JPanel();
		ta.setLineWrap(true);
		scrollpane1 = new JScrollPane(ta);
		scrollpane1.setPreferredSize(new Dimension(300, 400));
		p1.add(scrollpane1);
		p1.setPreferredSize(new Dimension(300, 400));

		JPanel p2 = new JPanel();
		p2.setPreferredSize(new Dimension(300, 400));

		JTabbedPane t = new JTabbedPane();

		t.add("��ǰ��", p1);
		t.add("��ǰ������", p2);

		p.add(t);

//		price = xPrice.getText();
//		intprice = Integer.parseInt(price);
//		option = xOption.getText();
//		intoption = Integer.parseInt(option);
//		
//		intallprice = intprice * intoption;
//		
//		allprice = Integer.toString(intallprice);
//
//		xAllPrice.setText(allprice);

//	         getDeptData(EmpData.selectDept());
//	         getSvpData(EmpData.selectSpv());

		ProDetailView();
	}

	private void ProDetailView() {
		setTitle("Login ȭ��");

		gridbagconstraints.anchor = GridBagConstraints.WEST;
//	    gridbagconstraints.ipadx = 7;
//	    
//	    gridbagconstraints.weightx=1.0;
//      gridbagconstraints.weighty=1.0;

		setLayout(gridbaglayout);
		gridbagconstraints.anchor = GridBagConstraints.CENTER;

		gridbagAdd(vProImg, 0, 0, 2, 7);
		gridbagAdd(vProNm, 2, 0, 1, 1);
		gridbagAdd(vPrice, 2, 1, 1, 1);
		gridbagAdd(xPrice, 3, 1, 2, 1);
		gridbagAdd(vColor, 2, 2, 1, 1);
//        gridbagAdd(vAllPoint, 0, 4, 1, 1);
		gridbagAdd(vSize, 2, 3, 1, 1);
		gridbagAdd(vOption, 2, 4, 1, 1);
		gridbagAdd(vAllPrice, 2, 5, 1, 1);
		gridbagAdd(xAllPrice, 3, 5, 2, 1);
		gridbagAdd(BtPlus, 4, 4, 1, 1);

		gridbagconstraints.anchor = GridBagConstraints.WEST;
		gridbagAdd(BtPurchae, 3, 6, 1, 1);
		gridbagAdd(xOption, 3, 4, 2, 1);
		gridbagAdd(p, 0, 7, 7, 10);

		gridbagconstraints.anchor = GridBagConstraints.EAST;
		gridbagAdd(BtBasket, 4, 6, 1, 1);
		gridbagAdd(BtMinus, 4, 4, 1, 1);

		setExtendedState(MAXIMIZED_BOTH);

		setVisible(true);
	}

	private void gridbagAdd(Component c, int x, int y, int w, int h) {
		gridbagconstraints.gridx = x;
		gridbagconstraints.gridy = y;
		// ���� ���� �� gridx, gridy���� 0

		gridbagconstraints.gridwidth = w;
		gridbagconstraints.gridheight = h;

		gridbaglayout.setConstraints(c, gridbagconstraints); // ������Ʈ�� ������Ʈ ��ġ+ũ�� ������ ���� GridBagLayout�� ��ġ

		add(c);

	}

	public static void main(String[] args) {
		ProDetail win = new ProDetail();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == BtPlus) {
			int p = Integer.parseInt(xOption.getText());
			p++;
			xOption.setText(p + "");
			
			price = xPrice.getText();
			intprice = Integer.parseInt(price);
			option = xOption.getText();
			intoption = Integer.parseInt(option);

			intallprice = intprice * intoption;

			allprice = Integer.toString(intallprice);

			xAllPrice.setText(allprice);
			
		} else if (e.getSource() == BtMinus) {
			if (Integer.parseInt(xOption.getText()) > 1) {
				int m = Integer.parseInt(xOption.getText());
				m--;
				xOption.setText(m + "");
				
				price = xPrice.getText();
				intprice = Integer.parseInt(price);
				option = xOption.getText();
				intoption = Integer.parseInt(option);

				intallprice = intprice * intoption;

				allprice = Integer.toString(intallprice);

				xAllPrice.setText(allprice);
			}
		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
//		if (e.getSource() == xAllPrice) {
//			price = xPrice.getText();
//			intprice = Integer.parseInt(price);
//			option = xOption.getText();
//			intoption = Integer.parseInt(option);
//
//			intallprice = intprice * intoption;
//
//			allprice = Integer.toString(intallprice);
//
//			xAllPrice.setText(allprice);
//		}

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
