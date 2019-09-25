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
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
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
	private String[] size3 = { "250", "255", "260", "265", "270", "275", "280", "285" };
	private String[] color = { "BLACK", "BLUE", "CYAN", "DARK_GRAY", "GRAY", "GREEN", "LIGHT_GRAY", "ORANGE", "PINK",
			"RED", "WHITE", "YELLOW" };

	private JComboBox<String> Cbsize, Cbcolor, Cbcolor2;
	private Icon icon;

	private JTable eDept, eSpv;
	private JScrollPane scrollpane1, scrollpane2;

	private JButton Btpurchase, BtBasket, BtPlus, BtMinus;
	private JTabbedPane t;
	private JTextArea ta;
	private JPanel p, p1, p2;

	String option, allprice, img, img2, nickname, ctgr, price, price2, modelname, up_price, user_id, user_num, pro_num;
	private String[] Basic_clr = {"[�ʼ�] ����"};
	static ArrayList arColor = new ArrayList();
	static ArrayList<String> arSize;

	int intprice, intoption, intallprice;

	GridBagLayout gridbaglayout;
	GridBagConstraints gridbagconstraints; // gridbag���̾ƿ��� ������Ʈ�� ��ġ�� ����ִ� ����
	List<Map<String, Serializable>> ImageListData;

	public String getData(List<Map<String, Serializable>> ImageListData) {

		up_price = "";
		up_price += ImageListData.get(0).get("UP").toString();
		System.out.println(up_price);

		return up_price;
	}

	public static ArrayList getData2(List<Map<String, Serializable>> ImageListData) { // ���� �迭�� ���� �߰�
		arColor.add("[�ʼ�] ����");
		arColor.add("----------");
		for (int i = 0; i < ImageListData.size(); i++) {
			arColor.add(ImageListData.get(i).get("CLR").toString());
		}

		return arColor;
	}

	public String getData3(List<Map<String, Serializable>> ImageListData) {

		pro_num = "";
		pro_num += ImageListData.get(0).get("PRO_NUM");
		System.out.println(pro_num);

		return pro_num;
	}

	public ProDetail() {
		gridbaglayout = new GridBagLayout();
		gridbagconstraints = new GridBagConstraints();

		img = ProImage.img;
		img2 = ProImage.img2;
		nickname = ProImage.nickname;
		ctgr = ProImage.ctgr;
		arSize = ProImage.arSize;
//		arColor = ProImage.arColor;
		price = ProImage.price;
		modelname = ProImage.modelname;

//		System.out.println(price);

		icon = new ImageIcon("C:\\Users\\ssong\\Desktop\\img\\" + img + ".jpg");

		vProImg = new JLabel(icon);
		vPrice = new JLabel("�ܰ�");
		vColor = new JLabel("����");
		vSize = new JLabel("������");
		vOption = new JLabel("���� ����");
		vAllPrice = new JLabel("�� ��ǰ����");
		vProNm = new JLabel(nickname);

//	    cbSel = new JComboBox<String>(div);
//	    cbSel.setPreferredSize(new Dimension(203, 20));

		xPrice = new JTextField(20);
		xPrice.setText(price);
		xOption = new JTextField(3);
		xOption.setText("1");
		xOption.setEnabled(false);
		xAllPrice = new JTextField(20);
		xAllPrice.addMouseListener(this);
		xAllPrice.setText(xPrice.getText());

		BtPlus = new JButton("��");
		BtPlus.setPreferredSize(new Dimension(45, 20));
		BtPlus.addActionListener(this);
		BtMinus = new JButton("��");
		BtMinus.setPreferredSize(new Dimension(45, 20));
		BtMinus.addActionListener(this);
		Btpurchase = new JButton("�����ϱ�");
		Btpurchase.addActionListener(this);
		BtBasket = new JButton("��ٱ���");
		BtBasket.addActionListener(this);

		Cbsize = new JComboBox<String>(arSize.toArray(new String[arSize.size()]));
		Cbsize.setPreferredSize(new Dimension(120,20));
		Cbsize.addActionListener(this);
		
		Cbcolor = new JComboBox<String>(Basic_clr);
		Cbcolor.setPreferredSize(new Dimension(120,20));
		Cbcolor.addActionListener(this);
		Cbcolor.addMouseListener(this);

		p1 = new JPanel();
		ta = new JTextArea(22, 30);
		ta.setLineWrap(true);
		scrollpane1 = new JScrollPane(ta);
		scrollpane1.setPreferredSize(new Dimension(430, 400));

		p1.add(scrollpane1);
		p1.setPreferredSize(new Dimension(430, 400));

		p2 = new JPanel();
		p2.setPreferredSize(new Dimension(430, 400));

		t = new JTabbedPane();
		t.add("��ǰ��", p1);
		t.add("��ǰ������", p2);

		p = new JPanel();
		p.add(t);

		ProDetailView();
	}

	private void ProDetailView() {
		setTitle("��ٱ���");

		gridbagconstraints.anchor = GridBagConstraints.WEST;
//	    gridbagconstraints.ipadx = 7;
//	    
//	    gridbagconstraints.weightx=1.0;
//      gridbagconstraints.weighty=1.0;

		setLayout(gridbaglayout);
		gridbagconstraints.anchor = GridBagConstraints.CENTER;

		gridbagAdd(vProImg, 0, 0, 2, 7);
		gridbagAdd(vProNm, 2, 0, 3, 1);
		gridbagAdd(vPrice, 2, 3, 1, 1);
		gridbagAdd(xPrice, 3, 3, 2, 1);
		gridbagAdd(vSize, 2, 1, 1, 1);
		gridbagAdd(vColor, 2, 2, 1, 1);
		gridbagAdd(vOption, 2, 4, 1, 1);
		gridbagAdd(vAllPrice, 2, 5, 1, 1);
		gridbagAdd(xAllPrice, 3, 5, 2, 1);
		gridbagAdd(p, 0, 7, 10, 10);

		gridbagconstraints.anchor = GridBagConstraints.WEST;
		gridbagAdd(Btpurchase, 3, 6, 1, 1);
		gridbagAdd(xOption, 3, 4, 2, 1);
		gridbagAdd(Cbsize, 3, 1, 1, 1);
		gridbagAdd(Cbcolor, 3, 2, 1, 1);
		gridbagAdd(BtPlus, 4, 4, 1, 1);

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
		if (e.getSource() == BtPlus) {
			int p = Integer.parseInt(xOption.getText());
			p++;
			xOption.setText(p + "");

			price2 = xPrice.getText();
			intprice = Integer.parseInt(price2);
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
		if (e.getSource() == Cbsize) {
			String selectSize = Cbsize.getSelectedItem().toString();
			if (!selectSize.equals("-----")) {
				getData2(ImageData.selectColor2(selectSize));
				Cbcolor.setModel(new DefaultComboBoxModel(arColor.toArray()));
				Cbcolor.setPreferredSize(new Dimension(120,20));


			} else {
//				Cbcolor2 = new JComboBox<String>(Basic_clr);
			}
			arColor = new ArrayList();
		}
		if (e.getSource() == Cbcolor) {
			String selectSize = Cbsize.getSelectedItem().toString();
			String selectColor = Cbcolor.getSelectedItem().toString();
			String proName = modelname + "_" + selectSize + "_" + selectColor;
			getData(ImageData.selectPrice(proName));
			getData3(ImageData.selectProNum(proName));
			System.out.println(proName);
			xPrice.setText(up_price);
		} else if (e.getSource() == BtBasket) {
			user_id = Login.user_id;
			user_num = Login.user_num;
			String bk_nickname = vProNm.getText();
			String bk_option = xOption.getText();
			String bk_price = xPrice.getText();
			String bk_allPrice = xAllPrice.getText();
			double bk_point = Integer.parseInt(xAllPrice.getText()) * 0.02;
			BasketData.createBasket(user_num, pro_num, bk_option, bk_price, bk_allPrice, bk_point);
			int check = JOptionPane.showConfirmDialog(null, "��ٱ��Ͽ� ��ϵǾ����ϴ�. ��ٱ��Ϸ� �̵��Ͻðڽ��ϱ�?", "",
					JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
			if (check == 0) {
				new Basket();
			}else
				return;

		} else if (e.getSource() == Btpurchase) {
			new MemOrdPg();

		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {

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
