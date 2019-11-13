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
import javax.swing.JButton;
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
	static public String fileName;
	public home_user home;

	public static String imgData, imgData2, img, img2, nicknameData, nickname, ctgrData, ctgr, priceData, price,
			modelnameData, modelname;
	static ArrayList<String> sizeData, colorData, ModelImgData, ModelNickData;
	static ArrayList<String> arModelImg = new ArrayList<String>();
	static ArrayList<String> arModelNick = new ArrayList<String>();
	static ArrayList<String> arSize = new ArrayList<String>();
	static ArrayList<String> arColor = new ArrayList<String>();

	List<Map<String, Serializable>> ImageListData;
	private int nowPage;
	private int nowPanel;
	private int postPerPage = 6;
	private int pagePerPanel = 3;
	private int panelNum;
	private int pageNum;
	private JButton[] bPage;
	private JPanel[] pPage;
	private JButton pre, next;

	String ad;

	GridBagLayout gridbaglayout;
	GridBagConstraints gridbagconstraints;

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
		arSize = new ArrayList<String>();

		arSize.add("[필수] 선택");
		arSize.add("----------");

		System.out.println(arSize);

		for (int i = 0; i < ImageListData.size(); i++) {

			arSize.add(ImageListData.get(i).get("SIZ").toString());
		}

		return arSize;
	}

	public static ArrayList<String> getData6(List<Map<String, Serializable>> ImageListData) {

		for (int i = 0; i < ImageListData.size(); i++) {
			arColor.add(ImageListData.get(i).get("CLR").toString());
		}

		return arColor;
	}

	public static String getData7(List<Map<String, Serializable>> ImageListData) {

		price = "";
		price += ImageListData.get(0).get("UP").toString();

		System.out.println(price);

		return price;
	}

	public static String getData8(List<Map<String, Serializable>> ImageListData) {

		modelname = "";
		modelname += ImageListData.get(0).get("MODEL_NM");

		System.out.println(modelname);

		return modelname;
	}

	public static void getData9(List<Map<String, Serializable>> ImageListData) {

		for (int i = 0; i < ImageListData.size(); i++) {

			arModelImg.add(ImageListData.get(i).get("MODEL_IMG1").toString());
			arModelNick.add(ImageListData.get(i).get("MODEL_NICK").toString());
		}
	}

	public static void getData10(List<Map<String, Serializable>> ImageListData) {

		System.out.println(ImageListData.get(0).get("up").toString());

		if (ImageListData.get(0).get("up").toString().equals("0")) {
			JOptionPane.showMessageDialog(null, "준비중인 상품입니다.", "", JOptionPane.ERROR_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "사이즈와 색상을 반드시 선택하여주세요. 각 사이즈와 색상별로 가격이 상이합니다.", "",
					JOptionPane.INFORMATION_MESSAGE);
//			priceData = getData7(ImageData.selectBasicPrice(fileName));
//			ProDetail prod = new ProDetail(new JFrame());
		}
		return;
	}

	public ProImage(home_user home) {
		this();
		this.home = home;
		ProImageview();
	}

	public ProImage() {
//	      setLayout(new FlowLayout(FlowLayout.CENTER, 100, 50));      
		pre = new JButton("<");
		pre.setContentAreaFilled(false);
		pre.setBorderPainted(false);
		pre.addMouseListener(this);
		next = new JButton(">");
		next.setContentAreaFilled(false);
		next.setBorderPainted(false);
		next.addMouseListener(this);

		ImageListData = ImageData.registModel();
		createPanel();// 버튼을 올려놓을 패널 생성, nowPage와 nowPanel값 초기화
		getData();

	}

	private void ProImageview() {
		Pimg.setSize(d.width, d.height - 170);
		Pimg.add(pre);
		Pimg.add(pPage[0]);
		Pimg.add(next);
		scroll = new JScrollPane(Pimg);
		scroll.getViewport().getView().setBackground(Color.WHITE);
		scroll.setPreferredSize(new Dimension(d.width * 3 / 4, d.height - 170));
		add(scroll);
		setVisible(true);
	}

	void getData() {
//      setLayout(new FlowLayout(FlowLayout.CENTER, 100, 50));

		getData9(ImageData.registModel());

		String ModelImg2[] = new String[arModelImg.size()];
		ImgLabels = new JLabel[arModelImg.size()];

		String ModelNick2[] = new String[arModelNick.size()];
		NickLabels = new JLabel[arModelImg.size()];

		Pimg = new JPanel();
		Pimg.setSize(d.width, d.height);
		Pimg.setLayout(new ModifiedFlowLayout(ModifiedFlowLayout.CENTER, 100, 50));

		for (int i = nowPage * postPerPage; i < nowPage * postPerPage + postPerPage; i++) {
			if (i > ImageListData.size() - 1) {
				break;
			}
			ModelImg2[i] = arModelImg.get(i);
			ModelNick2[i] = arModelNick.get(i);

			ad = "C:\\Users\\ssong\\Desktop\\img\\" + ModelImg2[i] + ".jpg";
			f = new File(ad);

			originIcon = new ImageIcon(ad);
			originImg = originIcon.getImage();
			changedImg = originImg.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
			Icon = new ImageIcon(changedImg);
			ImgLabels[i] = makeLabel(JLabel.BOTTOM, JLabel.CENTER, ModelNick2[i]);
			ImgLabels[i].addMouseListener(this);
			Pimg.add(ImgLabels[i]);
		}
//		Pimg.setSize(d.width, d.height - 170);
//		scroll = new JScrollPane(Pimg);
//		scroll.getViewport().getView().setBackground(Color.WHITE);
//		scroll.setPreferredSize(new Dimension(d.width * 3 / 4, d.height - 170));
//		add(scroll);
//		setVisible(true);

	}

	private void createPanel() {
		if (ImageListData.size() != 0 && (ImageListData.size() % postPerPage) == 0) { // 페이지 수 구하기
			pageNum = ImageListData.size() / postPerPage;
		} else {
			pageNum = ImageListData.size() / postPerPage + 1;
		}

		bPage = new JButton[pageNum];// 페이지수만큼의 원소를 지닌 버튼배열 선언

		if ((pageNum % pagePerPanel) == 0) { // 패널 수 구하기
			panelNum = pageNum / pagePerPanel;
		} else {
			panelNum = pageNum / pagePerPanel + 1;
		}

		System.out.println(panelNum);
		pPage = new JPanel[panelNum]; // 구한 panelNum만큼의 원소를 지닌 패널배열 선언(버튼을 올려놓을 곳)

		int indexButton = 0;

		for (int i = 0; i < panelNum; i++) {
			pPage[i] = new JPanel(new FlowLayout(FlowLayout.LEFT)); // 패널생성
			for (int j = 0; j < pagePerPanel; j++) {
				if (indexButton >= pageNum) {
					break;
				}
				bPage[indexButton] = new JButton("" + (indexButton + 1)); // 버튼생성
				bPage[indexButton].setContentAreaFilled(false);
				bPage[indexButton].setBorderPainted(false);
				bPage[indexButton].addMouseListener(this);

				pPage[i].add(bPage[indexButton]); // 패널위에 버튼올리기
				indexButton++;
			}
		}
		nowPage = 0; // 현재페이지와 패널 초기화
		nowPanel = 0;
	}

	public static void main(String[] args) {
		new ProImage();

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

	protected static JLabel makeLabel(int vert, int horiz, String Text) {
		JLabel l = new JLabel(Text, Icon, SwingConstants.CENTER);
		l.setVerticalTextPosition(vert);
		l.setHorizontalTextPosition(horiz);
		l.setBorder(BorderFactory.createLineBorder(Color.black));
		return l;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		for (int i = 0; i < pageNum; i++) {
			if (e.getSource() == bPage[i]) {
				nowPage = i;
				System.out.println(i);
				removeAll();
				getData();
				ProImageview();
				revalidate();
				repaint();
			}
		}

		for (int i = 0; i < arModelImg.size(); i++) {
			if (e.getSource() == ImgLabels[i]) {
				String fileName = arModelImg.get(i).toString();
//            int pos = fileName.lastIndexOf(".");
//            String fileName2 = fileName.substring(0, pos);
				System.out.println(fileName);

				imgData = getData(ImageData.selectImage(fileName));
				imgData2 = getData2(ImageData.selectImage(fileName));
				nicknameData = getData3(ImageData.selectNickname(fileName));
				ctgrData = getData4(ImageData.selectCtgr(fileName));
				sizeData = getData5(ImageData.selectSize(fileName));
				colorData = getData6(ImageData.selectColor(fileName));
				priceData = getData7(ImageData.selectBasicPrice(fileName));
				modelnameData = getData8(ImageData.selectModelname(fileName));
				getData10(ImageData.countBasicPrice(fileName));

				home.changePanel((JPanel) new ProDetail(this));
				repaint();
				revalidate();
			}

		}
		if (e.getSource() == pre) {
			if (nowPanel > 0) {
				remove(pPage[nowPanel]);
				nowPanel--;
				System.out.println("nowPanel = " + nowPanel);
				Pimg.add(pre);
				Pimg.add(pPage[0]);
				Pimg.add(next);
				revalidate();
			}
		} else if (e.getSource() == next) {
			if (nowPanel < panelNum - 1) {
				remove(pPage[nowPanel]);
				nowPanel++;
				Pimg.add(pre);
				Pimg.add(pPage[0]);
				Pimg.add(next);
				revalidate();
			}
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