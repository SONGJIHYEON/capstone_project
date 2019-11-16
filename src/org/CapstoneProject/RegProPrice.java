package org.CapstoneProject;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.nio.Buffer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class RegProPrice extends Dialog implements ActionListener {

   private static final int MAXIMIZED_BOTH = 0;
   private JLabel vRegModel, vProPrice, vProNm, vModelCtgr1, vModelCtgr2, vProPrice2, vProSell, vProSellPrice,
         vModelSize, vexPrice, vexStDate, vexEndDate, vModPrice, vModStDate, vModEndDate;
   private JTextField xProNm, xProPrice, xProSellPrice, xProSell, xexPrice, xexStDate, xexEndDate, xModPrice,
         xModStDate, xModEndDate;
//   private JTextArea xProSell;

   private String[] ctgr1 = { "상의", "하의", "아우터", "셔츠", "신발" };
   private String[] ctgr2_1 = { "맨투맨", "반팔T", "긴팔T", "후드", "니트" };
   private String[] ctgr2_2 = { "청바지", "슬랙스", "면바지", "운동복", "반바지" };
   private String[] ctgr2_3 = { "코트", "가디건", "조끼", "집업", "점퍼", "패딩", "야상", "재킷" };
   private String[] ctgr2_4 = { "스트라이프", "체크", "긴팔셔츠", "반팔셔츠" };
   private String[] ctgr2_5 = { "스니커즈", "운동화", "로퍼", "구두", "워커", "부츠", "샌들", "슬리퍼" }; // 사원구분 콤보박스의 목록
//            
//   private DefaultTableModel model1 = new DefaultTableModel(col1, 0);  
//   private DefaultTableModel model2 = new DefaultTableModel(col2, 0);      

   private JTable tBest, tNew;
   private JScrollPane scrollpane1, scrollpane2;

   private JButton Btsell, BtReg, BtCancel, BtPro;

   String pro_num, proname, proname2, modprice, modstdate, modendate, date, ex_price, ex_st_date, ex_end_date;

   GridBagLayout gbl;
   GridBagConstraints gbc;

   public void getData(List<Map<String, Serializable>> ProPriceListData) {

      ex_price = "";
      ex_price += ProPriceListData.get(0).get("UP");
      System.out.println(ex_price + 1);

      ex_st_date = "";
      ex_st_date += ProPriceListData.get(0).get("APP_ST_DT");
      System.out.println(ex_st_date +2);

      ex_end_date = "";
      ex_end_date += ProPriceListData.get(0).get("APP_END_DT");
      System.out.println(ex_end_date +3);

      if(ex_price.equals("null")) {
         System.out.println(123);
         xexPrice.setText("0");
      }else {
         xexPrice.setText(ex_price);               
      }
      
      if(ex_st_date.equals("null")) {
         xexStDate.setText("YYYY-MM-DD");
      }else {
         String oldstring = ex_st_date;
         Date date = null;
         try {
            date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").parse(oldstring);
         } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
         String new_ex_st_date = new SimpleDateFormat("yyyy-MM-dd").format(date);
         xexStDate.setText(new_ex_st_date);
      }

      if(ex_end_date.equals("null")) {
         xexEndDate.setText("YYYY-MM-DD");
      }else {
         String oldstring = ex_end_date;
         Date date = null;
         try {
            date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").parse(oldstring);
         } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
         String new_ex_end_date = new SimpleDateFormat("yyyy-MM-dd").format(date);
         xexEndDate.setText(new_ex_end_date);
      }
   }

   public RegProPrice(JFrame fr) {
      super(fr, "상품단가변경", true);

      Date dt = new Date();
      SimpleDateFormat spdate = new SimpleDateFormat("yyyy-MM-dd");

      date = spdate.format(dt);

      gbl = new GridBagLayout();
      gbc = new GridBagConstraints();



      xProNm = new JTextField(22);
      xProNm .setPreferredSize(new Dimension(120, 30));
      
//      xProPrice = new JTextField(20);
//      xProPrice.setEnabled(false);
//      xProSellPrice = new JTextField(20);
//      xProSellPrice.setEnabled(false);
      xexPrice = new JTextField(22);
      xexPrice.setEnabled(false);
      xexPrice.setPreferredSize(new Dimension(120, 30));
      
      xexStDate = new JTextField(22);
      xexStDate.setEnabled(false);
      xexStDate .setPreferredSize(new Dimension(120, 30));
      
      xexEndDate = new JTextField(22);
      xexEndDate.setEnabled(false);
      xexEndDate .setPreferredSize(new Dimension(120, 30));
   
      xModPrice = new JTextField(22);
      xModPrice .setPreferredSize(new Dimension(120, 30));
      
      xModStDate = new JTextField(22);
      xModStDate.setText(date);
      xModStDate .setPreferredSize(new Dimension(120, 30));
      
      xModEndDate = new JTextField(22);
      xModEndDate.setText("9999-12-31");
      xModEndDate .setPreferredSize(new Dimension(120, 30));

      vProNm = new JLabel("상품명");
      vProNm.setPreferredSize(new Dimension(120, 40));
      vProNm.setHorizontalAlignment(JLabel.CENTER);
      vProNm.setFont(new Font("돋음", Font.BOLD, 15));
//      
//      vProPrice2 = new JLabel("상품단가");
//      vProPrice2.setPreferredSize(new Dimension(120, 40));
//      vProPrice2.setHorizontalAlignment(JLabel.CENTER);
//      vProPrice2.setFont(new Font("돋음", Font.BOLD, 15));
//      vProSell = new JLabel("상품판매량");
//      vProSell.setPreferredSize(new Dimension(120, 40));
//      vProSell.setHorizontalAlignment(JLabel.CENTER);
//      vProSell.setFont(new Font("돋음", Font.BOLD, 15));   
//      vProSellPrice = new JLabel("상품 매출액");
      
      vexPrice = new JLabel("적용단가");
      vexPrice.setPreferredSize(new Dimension(120, 40));
      vexPrice.setHorizontalAlignment(JLabel.CENTER);
      vexPrice.setFont(new Font("돋음", Font.BOLD, 15));
      
      vexStDate = new JLabel("적용시작일");
      vexStDate.setPreferredSize(new Dimension(120, 40));
      vexStDate.setHorizontalAlignment(JLabel.CENTER);
      vexStDate.setFont(new Font("돋음", Font.BOLD, 15));
      
      vexEndDate = new JLabel("적용종료일");
      vexEndDate.setPreferredSize(new Dimension(120, 40));
      vexEndDate.setHorizontalAlignment(JLabel.CENTER);
      vexEndDate.setFont(new Font("돋음", Font.BOLD, 15));
   
      vModPrice = new JLabel("변경단가");
      vModPrice.setPreferredSize(new Dimension(120, 40));
      vModPrice.setHorizontalAlignment(JLabel.CENTER);
      vModPrice.setFont(new Font("돋음", Font.BOLD, 15));
      
      vModStDate = new JLabel("변경시작일");
      vModStDate.setPreferredSize(new Dimension(120, 40));
      vModStDate.setHorizontalAlignment(JLabel.CENTER);
      vModStDate.setFont(new Font("돋음", Font.BOLD, 15));
      
      vModEndDate = new JLabel("변경종료일");
      vModEndDate.setPreferredSize(new Dimension(120, 40));
      vModEndDate.setHorizontalAlignment(JLabel.CENTER);
      vModEndDate.setFont(new Font("돋음", Font.BOLD, 15));

      BtPro = new JButton("상품명 검색");
      BtPro.addActionListener(this);
      BtPro.setPreferredSize(new Dimension(120, 30));
      BtPro.setFocusPainted(false);
      BtPro.setBackground(Color.white);
      BtPro.setFont(new Font("돋음", Font.BOLD, 15));

      
      BtReg = new JButton("등록");
      BtReg.addActionListener(this);
      BtReg.setPreferredSize(new Dimension(80, 30));
      BtReg.setFocusPainted(false);
      BtReg.setBackground(Color.white);
      BtReg.setFont(new Font("돋음", Font.BOLD, 15));
      
      BtCancel = new JButton("닫기");
      BtCancel.addActionListener(this);
      BtCancel.setPreferredSize(new Dimension(80, 30));
      BtCancel.setFocusPainted(false);
      BtCancel.setBackground(Color.white);
      BtCancel.setFont(new Font("돋음", Font.BOLD, 15));

//      setExtendedState(MAXIMIZED_BOTH);
      RegProPriceView();
   }

   private void RegProPriceView() {

//      setTitle("홈페이지 관리자");

      setLayout(gbl);

   

      gridbagAdd(vProNm, 1, 2, 1, 1);
      gridbagAdd(vexPrice, 1, 3, 1, 1);
      gridbagAdd(vexStDate, 1, 4, 1, 1);
      gridbagAdd(vexEndDate, 1, 5, 1, 1);
//       gridbagAdd(vProSellPrice, 1, 6, 1, 1);
//       gridbagAdd(vProSell, 1, 7, 1, 1);
      gridbagAdd(vModPrice, 1, 8, 1, 1);
      gridbagAdd(vModStDate, 1, 9, 1, 1);
      gridbagAdd(vModEndDate, 1, 10, 1, 1);

      gridbagAdd(xProNm, 2, 2, 2, 1);
      gridbagAdd(xexPrice, 2, 3, 2, 1);
      gridbagAdd(xexStDate, 2, 4, 2, 1);
      gridbagAdd(xexEndDate, 2, 5, 2, 1);
//       gridbagAdd(xProPrice, 2, 6, 2, 1);
//       gridbagAdd(xProSellPrice, 2, 7, 2, 1);
      gridbagAdd(xModPrice, 2, 8, 2, 1);
      gridbagAdd(xModStDate, 2, 9, 2, 1);
      gridbagAdd(xModEndDate, 2, 10, 2, 1);

      gbc.anchor = GridBagConstraints.WEST;
      gridbagAdd(BtPro, 4, 2, 1, 1);
      gridbagAdd(BtReg, 2, 11, 1, 1);
      gbc.anchor = GridBagConstraints.EAST;
      gridbagAdd(BtCancel, 3, 11, 1, 1);

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

//   public void paintComponent(Graphics g) {
//      g.drawImage(manager_main.img, 0, 0, null);
//      setOpaque(false);// 그림을 표시하게 설정,투명하게 조절
//      super.paintComponent(g);
//   }

   public static void main(String[] args) {
      new RegProPrice(new JFrame());
//      jf.add(new RegProPrice());
//      new RegModel();
//      jf.pack();
//      jf.setVisible(true);
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      if (e.getSource() == BtPro) {
         ProSearch p = new ProSearch(new JFrame());
         pro_num = p.PRO_NUM;
         proname = p.PRO_NM;
         xProNm.setText(proname);
         getData(ProPriceData.ProPrice(proname));
      } 
      if (e.getSource() == BtReg) {
         proname2 = xProNm.getText();
         modprice = xModPrice.getText();
         modstdate = xModStDate.getText();
         modendate = xModEndDate.getText();
         if(modprice.equals("")){
              JOptionPane.showMessageDialog(null, "단가를 입력하여주세요.", "", JOptionPane.ERROR_MESSAGE);
         }else {
         int check = JOptionPane.showConfirmDialog(null, "상품 단가를 등록하시겠습니까?", "등록 확인", JOptionPane.YES_NO_OPTION,
               JOptionPane.INFORMATION_MESSAGE);
         if(check == 0) {
            JOptionPane.showMessageDialog(null, "단가가 등록되었습니다", "", JOptionPane.INFORMATION_MESSAGE);
            ProPriceData.createProPrice(pro_num, modstdate, modendate, modprice, proname2);            
         }else
            return;

         xProNm.setText("");
         xexPrice.setText("");
         xexStDate.setText("");
         xexEndDate.setText("");
         xModPrice.setText("");
         }
      }else if(e.getSource() == BtCancel) {
         dispose();
      }
   }
}