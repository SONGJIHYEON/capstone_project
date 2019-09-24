package org.CapstoneProject;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class ProImage implements MouseListener {
	private static Icon icon;
	private static JLabel label1;
	private static JLabel[] labels;
	private File f;

	public static String imgData, imgData2, img, img2, nicknameData, nickname, ctgrData, ctgr, priceData, price;
	static ArrayList sizeData, colorData;
	static ArrayList arSize = new ArrayList();
	static ArrayList arColor = new ArrayList();
	String ad;

	public static String getData(List<Map<String, Serializable>> ImageListData) {

		img = "";
		img += ImageListData.get(0).get("MODEL_IMG1");

		return img;
	}

	public static String getData2(List<Map<String, Serializable>> ImageListData) {

		img2 = "";
		img2 += ImageListData.get(0).get("MODEL_IMG2");

		return img2;
	}

	public static String getData3(List<Map<String, Serializable>> ImageListData) {

		nickname = "";
		nickname += ImageListData.get(0).get("MODEL_NICK");

		return nickname;
	}

	public static String getData4(List<Map<String, Serializable>> ImageListData) {

		ctgr = "";
		ctgr += ImageListData.get(0).get("FIRST_CTGR");

		return ctgr;
	}

	public static ArrayList getData5(List<Map<String, Serializable>> ImageListData) {

		for (int i = 0; i < ImageListData.size(); i++) {
			arSize.add(ImageListData.get(i).get("SIZ").toString());
			}

		return arSize;
	}

	public static ArrayList getData6(List<Map<String, Serializable>> ImageListData) {

		for (int i = 0; i < ImageListData.size(); i++) {
			arColor.add(ImageListData.get(i).get("CLR").toString());
			}

		return arColor;
	}
	
	public static String getData7(List<Map<String, Serializable>> ImageListData) {

		price = "";
		price += ImageListData.get(0).get("UP");

		return price;
	}

	public ProImage() {
		ad = "C:\\Users\\ssong\\Desktop\\img\\REP_Da1.jpg";
		f = new File(ad);
		icon = new ImageIcon(ad);

		labels = new JLabel[9];

		label1 = new JLabel("гоюл");
		label1.addMouseListener(this);

		labels[0] = makeLabel(JLabel.TOP, JLabel.LEFT, "1");
		labels[0].addMouseListener(this);
		labels[1] = makeLabel(JLabel.TOP, JLabel.CENTER, "2");
		labels[2] = makeLabel(JLabel.TOP, JLabel.RIGHT, "3");
		labels[3] = makeLabel(JLabel.CENTER, JLabel.LEFT, "4");
		labels[4] = makeLabel(JLabel.CENTER, JLabel.CENTER, "1");
		labels[5] = makeLabel(JLabel.CENTER, JLabel.RIGHT, "1");
		labels[6] = makeLabel(JLabel.BOTTOM, JLabel.LEFT, "1");
		labels[7] = makeLabel(JLabel.BOTTOM, JLabel.CENTER, "aa");
		labels[8] = makeLabel(JLabel.BOTTOM, JLabel.RIGHT, "bb");

		// labels[0].setEnabled(false);
		//
		// labels[1].setDisabledIcon(new ImageIcon("2.gif"));
		// labels[1].setEnabled(false);
		//
		// labels[2].setIconTextGap(15);
		// labels[3].setIconTextGap(0);

		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = frame.getContentPane();
		c.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 50));
		for (int i = 0; i < 9; i++)
			c.add(labels[i]);
		// c.add(labels[8]);
		c.add(label1);
		frame.setSize(350, 150);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		new ProImage();

	}

	protected static JLabel makeLabel(int vert, int horiz, String Text) {
		JLabel l = new JLabel(Text, icon, SwingConstants.CENTER);
		l.setVerticalTextPosition(vert);
		l.setHorizontalTextPosition(horiz);
		l.setBorder(BorderFactory.createLineBorder(Color.black));
		return l;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == labels[0]) {
			String fileName = f.getName();
			int pos = fileName.lastIndexOf(".");
			String fileName2 = fileName.substring(0, pos);
			System.out.println(fileName2);

			imgData = getData(ImageData.selectImage(fileName2));
			imgData2 = getData2(ImageData.selectImage(fileName2));
			nicknameData = getData3(ImageData.selectNickname(fileName2));
			ctgrData = getData4(ImageData.selectCtgr(fileName2));
			sizeData = getData5(ImageData.selectSize(fileName2));
			colorData = getData6(ImageData.selectColor(fileName2));
			priceData = getData7(ImageData.selectPrice(fileName2));

			ProDetail prod = new ProDetail();

		}
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
}