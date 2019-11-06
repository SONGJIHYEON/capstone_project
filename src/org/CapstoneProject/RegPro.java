
package org.CapstoneProject;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class RegPro extends Dialog implements ActionListener, ItemListener {

	ArrayList ar = new ArrayList();
	ArrayList ar1 = new ArrayList();
	ArrayList pro = new ArrayList();

	private JLabel vRegModel, vRegPro2, vProNm, vSale, vModelCtgr2, vModelNm, vPrice, vAdminModel, vModelCtgr, vRegPro,
			vAdminPro, vProUp, vProSize, vProDetail, vProColor, vProStock, vModelImage;
	private JTextField xModelNm, xProNm, xSale, xModelCtgr2, xProDetail, xPrice, xProStock, xColor, xModelImage;

//   private JTextArea xPrice;

//   private JPasswordField xMemPw1, xMemPw2;
//   private String[] ctgr1 = {"상의", "하의", "아우터", "셔츠", "신발"};
//   private String[] size = {""};
	private String[] size1 = { "90", "95", "100", "105", "110" };
	private String[] size2 = { "27", "28", "29", "30", "31", "32", "33", "34", "35" };
	private String[] size3 = { "250", "255", "260", "265", "270", "275", "280", "285" };
	private String[] color = { "BLACK", "BLUE", "CYAN", "DARK_GRAY", "GRAY", "GREEN", "LIGHT_GRAY", "ORANGE", "PINK",
			"RED", "WHITE", "YELLOW" };
	private String[] col = { "사이즈", "색상", "상품명" };

	private JCheckBox[] chsize1 = new JCheckBox[size1.length];
	private JCheckBox[] chsize2 = new JCheckBox[size2.length];
	private JCheckBox[] chsize3 = new JCheckBox[size3.length];
	private JCheckBox[] chcolor = new JCheckBox[color.length];

	private JTable tpro;
	private JScrollPane scrollpane1;

	private DefaultTableModel model1 = new DefaultTableModel(col, 0);

	private JButton BtBussMan, BtProMan, BtOdMan, BtMbMan, BtEmpMan, BtSearch, BtReg, BtCancel, BtModel, BtPro, BtColor,
			BtImg;
	private JRadioButton RSale, RSoldOut, RBehind;
	private ButtonGroup BtRadio;
	private JPanel PRadio, psize1, psize2, psize3, pcolor;
	private JComboBox<String> CbSize;
	private JTextArea taProNm;

	String name, PRO_IMG;

	int o = -1, k = 0;
	int i, row;

	GridBagLayout gbl;
	GridBagConstraints gbc;

	public RegPro(JFrame fr) {
		super(fr, "", true);

		gbl = new GridBagLayout();
		gbc = new GridBagConstraints();

		vProNm = new JLabel("상품명");
		vProNm.setFont(new Font("휴먼매직체", Font.PLAIN, 20));
		vProSize = new JLabel("상품 사이즈");
		vProSize.setFont(new Font("휴먼매직체", Font.PLAIN, 20));
		vProColor = new JLabel("상품 색상");
		vProColor.setFont(new Font("휴먼매직체", Font.PLAIN, 20));
//      vProStock = new JLabel("재고등록");

		xModelNm = new JTextField(20);
		xModelNm.setPreferredSize(new Dimension(250, 28));
		taProNm = new JTextArea(10, 10);

		vModelNm = new JLabel("모델명");
		vModelNm.setFont(new Font("휴먼매직체", Font.PLAIN, 20));
		vSale = new JLabel("판매상태");
		vSale.setFont(new Font("휴먼매직체", Font.PLAIN, 20));

//      CbSize = new JComboBox<String>(size);
//      CbSize.setPreferredSize(new Dimension(100,25));
//      vModelCtgr2 = new JLabel("2차분류");
		vProDetail = new JLabel("상품 상세 정보");
		vProDetail.setFont(new Font("휴먼매직체", Font.PLAIN, 20));

		RSale = new JRadioButton("판매중");
		RSale.setSelected(true);
		RSoldOut = new JRadioButton("품절");
		RBehind = new JRadioButton("숨김");

		BtRadio = new ButtonGroup();
		BtRadio.add(RSale);
		BtRadio.add(RSoldOut);
		BtRadio.add(RBehind);

		PRadio = new JPanel(new FlowLayout(FlowLayout.CENTER));
		PRadio.setPreferredSize(new Dimension(250, 30));
		PRadio.add(RSale);
		PRadio.add(RSoldOut);
		PRadio.add(RBehind);

		tpro = new JTable(model1);
		tpro.getColumnModel().getColumn(0).setPreferredWidth(15);
		tpro.getColumnModel().getColumn(1).setPreferredWidth(15);
		tpro.getColumnModel().getColumn(2).setPreferredWidth(60);
		scrollpane1 = new JScrollPane(tpro);
		scrollpane1.setPreferredSize(new Dimension(250, 130));

		psize1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		psize1.setPreferredSize(new Dimension(250, 30));
		psize2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		psize2.setPreferredSize(new Dimension(250, 80));
		psize3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		psize3.setPreferredSize(new Dimension(250, 80));
		pcolor = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pcolor.setPreferredSize(new Dimension(250, 130));

		for (int i = 0; i < chsize1.length; i++) {
			chsize1[i] = new JCheckBox(size1[i]);
			psize1.add(chsize1[i]);
		}

		for (int i = 0; i < chsize2.length; i++) {
			chsize2[i] = new JCheckBox(size2[i]);
			psize2.add(chsize2[i]);
		}

		for (int i = 0; i < chsize3.length; i++) {
			chsize3[i] = new JCheckBox(size3[i]);
			psize3.add(chsize3[i]);
		}

		for (int i = 0; i < color.length; i++) {
			chcolor[i] = new JCheckBox(color[i]);
//         chcolor[i].addItemListener(this);
			pcolor.add(chcolor[i]);
		}

		BtBussMan = new JButton("거래관리");
		BtBussMan.setPreferredSize(new Dimension(200, 28));

		BtModel = new JButton("모델 불러오기");
		BtModel.addActionListener(this);
		BtModel.setPreferredSize(new Dimension(120, 28));
		BtModel.setBackground(Color.white);
		BtModel.setFont(new Font("휴먼매직체", Font.PLAIN, 17));

		BtColor = new JButton("색상 가져오기");
		BtColor.addActionListener(this);
		BtPro = new JButton("상품명 생성");
		BtPro.setPreferredSize(new Dimension(120, 28));
		BtPro.setBackground(Color.white);
		BtPro.setFont(new Font("휴먼매직체", Font.PLAIN, 17));

		BtImg = new JButton("첨부하기");
		BtPro.addActionListener(this);

		BtReg = new JButton("등록");
		BtReg.addActionListener(this);
		BtReg.setFocusPainted(false);
		BtReg.setBackground(Color.white);
		BtReg.setFont(new Font("휴먼매직체", Font.PLAIN, 17));
		BtReg.setPreferredSize(new Dimension(65, 25));

		BtCancel = new JButton("닫기");
		BtCancel.addActionListener(this);
		BtCancel.setFocusPainted(false);
		BtCancel.setBackground(Color.white);
		BtCancel.setPreferredSize(new Dimension(65, 25));
		BtCancel.setFont(new Font("휴먼매직체", Font.PLAIN, 17));

		psize2.setEnabled(false);
		psize2.setVisible(false);
		psize3.setEnabled(false);
		psize3.setVisible(false);
		psize1.setEnabled(false);
		psize1.setVisible(false);
//      setExtendedState(MAXIMIZED_BOTH);

		RegProView();
	}

	private void RegProView() {

		setTitle("상품등록");
		setLayout(gbl);

		gridbagAdd(vProNm, 1, 6, 1, 1);
		gridbagAdd(vModelNm, 1, 2, 1, 1);
		gridbagAdd(vProSize, 1, 4, 1, 1);
		gridbagAdd(vProColor, 1, 5, 1, 1);
		gridbagAdd(xModelNm, 2, 2, 2, 1);

		gridbagAdd(pcolor, 2, 5, 2, 1);

		gbc.anchor = GridBagConstraints.EAST;
		gridbagAdd(BtModel, 4, 2, 1, 1);
		gridbagAdd(BtReg, 2, 10, 1, 1);
		gridbagAdd(BtCancel, 3, 10, 1, 1);
		gridbagAdd(BtPro, 4, 6, 1, 1);

		gbc.anchor = GridBagConstraints.CENTER;
		gridbagAdd(scrollpane1, 2, 6, 2, 1);
		gridbagAdd(psize1, 2, 4, 2, 1);
		gridbagAdd(psize2, 2, 4, 2, 1);
		gridbagAdd(psize3, 2, 4, 2, 1);

		pack();
		setVisible(true);
	}

	private void gridbagAdd(Component c, int x, int y, int w, int h) {

		gbc.gridx = x;
		gbc.gridy = y;
		// 가장 왼쪽 위 gridx, gridy값은 0

		gbc.gridwidth = w;
		gbc.gridheight = h;

		gbl.setConstraints(c, gbc); // 컴포넌트를 컴포넌트 위치+크기 정보에 따라 GridBagLayout에 배치

		add(c);

	}

//	public void paintComponent(Graphics g) {
//		g.drawImage(manager_main.img, 0, 0, null);
//		setOpaque(false);// 그림을 표시하게 설정,투명하게 조절
//		super.paintComponent(g);
//	}

	public static void main(String[] args) {
		new RegPro(new JFrame());

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == BtModel) {
			ModelSearch mM = new ModelSearch(new JFrame());
			xModelNm.setText(mM.ModelName);
			name = mM.ModelNum;
			if (mM.first_ctgr.equals("상의") || mM.first_ctgr.equals("아우터") || mM.first_ctgr.equals("셔츠")) {
				psize2.setEnabled(false);
				psize2.setVisible(false);
				psize3.setEnabled(false);
				psize3.setVisible(false);
				psize1.setEnabled(true);
				psize1.setVisible(true);
				o = 1;
				k = 1;
				pack();
			} else if (mM.first_ctgr.equals("하의")) {
//         gridbagAdd(psize2, 2, 4, 2, 1);
//         setVisible(true);
				psize2.setEnabled(true);
				psize2.setVisible(true);
				psize3.setEnabled(false);
				psize3.setVisible(false);
				psize1.setEnabled(false);
				psize1.setVisible(false);
				o = 2;
				k = 1;
				pack();
			} else if (mM.first_ctgr.equals("신발")) {
//         gridbagAdd(psize3, 2, 4, 2, 1);
//         setVisible(true);
				psize2.setEnabled(false);
				psize2.setVisible(false);
				psize3.setEnabled(true);
				psize3.setVisible(true);
				psize1.setEnabled(false);
				psize1.setVisible(false);
				o = 3;
				pack();
			}
		}
		if (e.getSource() == BtPro) {
			if (o == -1) {
			} else if (o == 1) {
				ar1 = new ArrayList();
				k = 1;

				for (int i = 0; i < chsize1.length; i++) {
					if (chsize1[i].isSelected() == true) {
						ar1.add(chsize1[i].getText());
					}
				}
			} else if (o == 2) {
				ar1 = new ArrayList();
				k = 1;

				for (int i = 0; i < chsize2.length; i++) {
					if (chsize2[i].isSelected() == true) {
						ar1.add(chsize2[i].getText());
					}
				}
			} else if (o == 3) {
				ar1 = new ArrayList();
				k = 1;
				for (int i = 0; i < chsize3.length; i++) {
					if (chsize3[i].isSelected() == true) {
						ar1.add(chsize3[i].getText());
					}
				}

			}
			if (k == 1) {
				ar = new ArrayList();
				for (int i = 0; i < chcolor.length; i++) {
					if (chcolor[i].isSelected() == true) {
						ar.add(chcolor[i].getText());
					}
				}
				for (int i = 0; i < ar1.size(); i++) {
					for (int j = 0; j < ar.size(); j++) {
						model1.addRow(new Object[] { ar1.get(i), ar.get(j),
								xModelNm.getText() + "_" + ar1.get(i) + "_" + ar.get(j), });
					}
				}
			}
		}
		if (e.getSource() == BtReg) {
			int check = JOptionPane.showConfirmDialog(null, "상품을 등록하시겠습니까?", "등록 확인", JOptionPane.YES_NO_OPTION,
					JOptionPane.INFORMATION_MESSAGE);
			if (check == 0) {
				for (int i = 0; i < ar1.size(); i++) {
					for (int j = 0; j < ar.size(); j++) {
						RegProData.createpro(name, xModelNm.getText() + "_" + ar1.get(i) + "_" + ar.get(j),
								ar.get(j).toString(), ar1.get(i).toString());
					}
				}
				JOptionPane.showMessageDialog(null, "상품이 등록되었습니다", "", JOptionPane.INFORMATION_MESSAGE);
				xModelNm.setText("");
				model1.setRowCount(0);
				
				for (int i = 0; i < chsize1.length; i++) {
					chsize1[i].setSelected(false);
				}
				for (int i = 0; i < chsize2.length; i++) {
					chsize2[i].setSelected(false);
				}
				for (int i = 0; i < chsize3.length; i++) {
					chsize3[i].setSelected(false);
				}
				for (int i = 0; i < chcolor.length; i++) {
					chcolor[i].setSelected(false);
				}


			} else
				return;
		} else if (e.getSource() == BtCancel) {
			dispose();
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
//	   Object source = e.getItemSelectable();
//	   if(source == chcolor[i])
//		   if(e.getStateChange() == ItemEvent.SELECTED) {
//			   System.out.println(1);    	  
//      }else
//    	  System.out.println(2);
	}
}
