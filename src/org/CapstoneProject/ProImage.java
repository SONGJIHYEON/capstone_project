package org.CapstoneProject;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Toolkit;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public class ProImage extends JPanel implements MouseListener {

	Dimension d = Toolkit.getDefaultToolkit().getScreenSize();

	private static Image originImg, changedImg;
	private static ImageIcon originIcon, Icon;
	private static JLabel label1;
	private static JLabel[] ImgLabels, NickLabels;
	private File f;
	JPanel Pimg;
	JScrollPane scroll;

	public static String imgData, imgData2, img, img2, nicknameData, nickname, ctgrData, ctgr, priceData, price,
			modelnameData, modelname;
	static ArrayList<String> sizeData, colorData, ModelImgData, ModelNickData;
	static ArrayList<String> arModelImg = new ArrayList<String>();
	static ArrayList<String> arModelNick = new ArrayList<String>();
	static ArrayList<String> arSize = new ArrayList<String>();
	static ArrayList<String> arColor = new ArrayList<String>();
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
		arSize.add("[필수] 선택");
		arSize.add("----------");

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
		price += ImageListData.get(0).get("UP").toString();

		return price;
	}

	public static String getData8(List<Map<String, Serializable>> ImageListData) {

		modelname = "";
		modelname += ImageListData.get(0).get("MODEL_NM");

		return modelname;
	}

	public static void getData9(List<Map<String, Serializable>> ImageListData) {

		for (int i = 0; i < ImageListData.size(); i++) {

			arModelImg.add(ImageListData.get(i).get("MODEL_IMG1").toString());
			arModelNick.add(ImageListData.get(i).get("MODEL_NICK").toString());
		}

//		return 0;
	}

	public ProImage() {

//		setLayout(new FlowLayout(FlowLayout.CENTER, 100, 50));
		getData9(ImageData.registModel());

		String ModelImg2[] = new String[arModelImg.size()];
		ImgLabels = new JLabel[arModelImg.size()];

		String ModelNick2[] = new String[arModelNick.size()];
		NickLabels = new JLabel[arModelImg.size()];

		Pimg = new JPanel();
		Pimg.setSize(d.width, d.height);
		Pimg.setLayout(new ModifiedFlowLayout(ModifiedFlowLayout.CENTER, 100, 50));

		for (int i = 0; i < arModelImg.size(); i++) {
			ModelImg2[i] = arModelImg.get(i);
			ModelNick2[i] = arModelNick.get(i);

			ad = "C:\\Users\\ssong\\Desktop\\img\\" + ModelImg2[i] + ".jpg";
			System.out.println(ad);
			f = new File(ad);
			originIcon = new ImageIcon(ad);
			originImg = originIcon.getImage();
			changedImg = originImg.getScaledInstance(400, 400, Image.SCALE_SMOOTH);
			Icon = new ImageIcon(changedImg);
			ImgLabels[i] = makeLabel(JLabel.BOTTOM, JLabel.CENTER, ModelNick2[i]);
			ImgLabels[i].addMouseListener(this);
			Pimg.add(ImgLabels[i]);
		}

		Pimg.setSize(d.width, d.height - 100);
		scroll = new JScrollPane(Pimg);
		scroll.setPreferredSize(new Dimension(d.width - 200, d.height-200));
		add(scroll);
		setVisible(true);

	}

	public static void main(String[] args) {
		new ProImage();

	}

	protected static JLabel makeLabel(int vert, int horiz, String Text) {
		JLabel l = new JLabel(Text, Icon, SwingConstants.CENTER);
		l.setVerticalTextPosition(vert);
		l.setHorizontalTextPosition(horiz);
		l.setBorder(BorderFactory.createLineBorder(Color.black));
		return l;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == ImgLabels[0]) {
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
			priceData = getData7(ImageData.selectBasicPrice(fileName2));
			modelnameData = getData8(ImageData.selectModelname(fileName2));

			ProDetail prod = new ProDetail();
			JOptionPane.showMessageDialog(null, "사이즈와 색상을 반드시 선택하여주세요. 각 사이즈와 색상별로 가격이 상이합니다.", "",
					JOptionPane.INFORMATION_MESSAGE);

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