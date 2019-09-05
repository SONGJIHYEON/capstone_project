
package org.CapstoneProject;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class RegPro extends JFrame implements ActionListener, ItemListener {
   
   ArrayList ar = new ArrayList();
   ArrayList ar1 = new ArrayList();
   ArrayList pro = new ArrayList();
   
   private JLabel vRegModel, vRegPro2, vProNm, vSale, vModelCtgr2, vModelNm, vPrice, vAdminModel, 
   vModelCtgr, vRegPro, vAdminPro, vProUp, vProSize, vProDetail, vProColor, vProStock;
   private JTextField xModelNm, xProNm, xSale, xModelCtgr2, xProDetail, xPrice, xProStock, xColor;

   
//   private JTextArea xPrice;

//   private JPasswordField xMemPw1, xMemPw2;
//   private String[] ctgr1 = {"상의", "하의", "아우터", "셔츠", "신발"};
//   private String[] size = {""};
   private String[] size1 = {"90", "95", "100", "105", "110"};
   private String[] size2 = {"27", "28", "29", "30", "31", "32", "33", "34", "35" };  
   private String[] size3 = {"250", "255", "260", "265", "270", "275", "280", "285"};
   private String[] color = {"BLACK", "BLUE", "CYAN", "DARK_GRAY", "GRAY", "GREEN", "LIGHT_GRAY", "ORANGE", "PINK", "RED", "WHITE", "YELLOW"};
   private String[] col = {"사이즈", "색상"};
   
   private JCheckBox[] chsize1 = new JCheckBox[size1.length];
   private JCheckBox[] chsize2 = new JCheckBox[size2.length];
   private JCheckBox[] chsize3 = new JCheckBox[size3.length];
   private JCheckBox[] chcolor = new JCheckBox[color.length];

   private JTable tpro;     
   private JScrollPane scrollpane1;
   
   private DefaultTableModel model1 = new DefaultTableModel(col, 0);  
   
   private JButton BtBussMan, BtProMan, BtOdMan, BtMbMan, BtEmpMan, BtSearch, BtReg, BtCancel, BtModel, BtPro, BtColor; 
   private JRadioButton RSale, RSoldOut, RBehind;
   private ButtonGroup BtRadio;
   private JPanel PRadio, psize1, psize2, psize3, pcolor;
   private JComboBox<String> CbSize;
   private JTextArea taProNm;
   
   String name;
   
   int o = -1, k = 0;
   int i;
   
   GridBagLayout gbl;
   GridBagConstraints gbc;
   
   public RegPro(JFrame fr) {
      

      gbl = new GridBagLayout();
      gbc = new GridBagConstraints(); 
        
      vRegModel = new JLabel("모델등록");
      vRegModel.setPreferredSize(new Dimension(200,28));
      vRegPro2 = new JLabel("상품등록");
      vRegPro2.setPreferredSize(new Dimension(200,28));
      vAdminModel = new JLabel("모델검색");
      vAdminModel.setPreferredSize(new Dimension(200,28));
      vModelCtgr = new JLabel("모델분류");
      vModelCtgr.setPreferredSize(new Dimension(200,28));
      vRegPro = new JLabel("상품등록");
      vRegPro.setPreferredSize(new Dimension(200,28));
      vAdminPro = new JLabel("상품관리");
      vAdminPro.setPreferredSize(new Dimension(200,28));
      vProUp = new JLabel("상품단가변경");
        vProUp.setPreferredSize(new Dimension(200,28));
        
      vProNm = new JLabel("상품명");
      vProColor = new JLabel("상품 색상");
//      vProStock = new JLabel("재고등록");

      xModelNm = new JTextField(20);
      taProNm = new JTextArea(10, 10);
      xSale = new JTextField(20);
      xProDetail = new JTextField(20);
      xColor = new JTextField(20);
//      xPrice = new JTextField(20);
//      xProStock = new JTextField(20);
      
      vModelNm = new JLabel("모델명");
//      vPrice = new JLabel("상품 가격");
      vSale = new JLabel("판매상태");
//      CbSize = new JComboBox<String>(size);
//      CbSize.setPreferredSize(new Dimension(100,25));
//      vModelCtgr2 = new JLabel("2차분류");
      vProSize = new JLabel("상품 사이즈");
      vProDetail = new JLabel("상품 상세 정보");
      
      RSale = new JRadioButton("판매중");
      RSale.setSelected(true);
      RSoldOut = new JRadioButton("품절");
      RBehind = new JRadioButton("숨김");
      
      BtRadio = new ButtonGroup();
      BtRadio.add(RSale);
      BtRadio.add(RSoldOut);
      BtRadio.add(RBehind);
   
      PRadio = new JPanel(new FlowLayout(FlowLayout.CENTER));
      PRadio.add(RSale);
      PRadio.add(RSoldOut);
      PRadio.add(RBehind);
      
      tpro = new JTable(model1);
      scrollpane1 = new JScrollPane(tpro);
      scrollpane1.setPreferredSize(new Dimension(250,80));
      
      psize1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
      psize1.setPreferredSize(new Dimension(250,30));
      psize2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
      psize2.setPreferredSize(new Dimension(250,80));
      psize3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
      psize3.setPreferredSize(new Dimension(250,80));
      pcolor = new JPanel(new FlowLayout(FlowLayout.LEFT));
      pcolor.setPreferredSize(new Dimension(250,130));
      
      for(int i = 0; i<chsize1.length; i++) {
         chsize1[i] = new JCheckBox(size1[i]);
         psize1.add(chsize1[i]);
      }
      
      for(int i = 0; i<chsize2.length; i++) {
         chsize2[i] = new JCheckBox(size2[i]);
         psize2.add(chsize2[i]);
      }
      
      for(int i = 0; i<chsize3.length; i++) {
         chsize3[i] = new JCheckBox(size3[i]);
         psize3.add(chsize3[i]);
      }
      
      for(int i = 0; i<color.length; i++) {
         chcolor[i] = new JCheckBox(color[i]);
//         chcolor[i].addItemListener(this);
         pcolor.add(chcolor[i]);
      }
      
      BtBussMan = new JButton("거래관리");
      BtBussMan.setPreferredSize(new Dimension(200,28));
      
      BtModel = new JButton("모델 불러오기");
      BtModel.addActionListener(this);
        
//        regist.addActionListener(this);
      BtProMan = new JButton("모델/상품관리");
      BtProMan.setPreferredSize(new Dimension(200,28));
//        cancel.addActionListener(this);
      BtOdMan = new JButton("주문관리");
      BtOdMan.setPreferredSize(new Dimension(200,28));
      BtMbMan = new JButton("회원관리");
      BtMbMan.setPreferredSize(new Dimension(200,28));
      BtEmpMan = new JButton("직원관리");
      BtEmpMan.setPreferredSize(new Dimension(200,28));
//      BtSearch = new JButton("검색");
//      BtSearch.setPreferredSize(new Dimension(100,28));
      
      BtColor = new JButton("색상 가져오기");
      BtColor.addActionListener(this);
      BtPro = new JButton("상품명 생성");
      BtPro.setPreferredSize(new Dimension(109,28));
      BtPro.addActionListener(this);
      BtReg = new JButton("등록");
      BtReg.addActionListener(this);
      BtCancel = new JButton("닫기");

	  psize2.setEnabled(false);
	  psize2.setVisible(false);
	  psize3.setEnabled(false);
	  psize3.setVisible(false);
	  psize1.setEnabled(false);
	  psize1.setVisible(false);
      setExtendedState(MAXIMIZED_BOTH);
      RegProView();
   }
   
   private void RegProView() {

      setTitle("홈페이지 관리자");
      setLayout(gbl);
      
//      gridbagAdd(psize1, 3, 4, 1, 1);
//      gridbagAdd(psize2, 3, 4, 1, 1);
//      gridbagAdd(psize2, 3, 4, 1, 1);

//      gridbagAdd(vRegModel, 0, 1, 1, 1);
      gridbagAdd(vRegPro2, 1, 1, 1, 1);
//      gridbagAdd(vAdminModel,0, 2, 1, 1);
//       gridbagAdd(vModelCtgr, 0, 3, 1, 1);
//       gridbagAdd(vRegPro, 0, 4, 1, 1);
//       gridbagAdd(vAdminPro, 0, 5, 1, 1);
//       gridbagAdd(vProUp, 0, 6, 1, 1);
       gridbagAdd(vProNm, 1, 6, 1, 1);
       gridbagAdd(vModelNm, 1, 2, 1, 1);
//       gridbagAdd(vPrice, 1, 3, 1, 1);
       gridbagAdd(vSale, 1, 3, 1, 1);
       gridbagAdd(vProSize, 1, 4, 1, 1);
       gridbagAdd(vProColor, 1, 5, 1, 1);
//       gridbagAdd(vProStock, 1, 8, 1, 1);
       gridbagAdd(vProDetail, 1, 7, 1, 1);
       
       gridbagAdd(xModelNm, 2, 2, 2, 1);
       gridbagAdd(PRadio, 2, 3, 2, 1);
       gridbagAdd(xProDetail, 2, 7, 2, 1);
       gridbagAdd(pcolor, 2, 5, 2, 1);
       

       gbc.anchor = GridBagConstraints.EAST;
       gridbagAdd(BtModel, 4, 2, 1, 1);
       gridbagAdd(BtReg, 2, 10, 1, 1);
       gridbagAdd(BtCancel, 3, 10, 1, 1);
       gridbagAdd(BtPro, 4, 6, 1, 1);
//       gridbagAdd(BtColor, 4, 5, 1, 1);

       gbc.anchor = GridBagConstraints.CENTER;
       gridbagAdd(scrollpane1, 2, 6, 2, 1);
       gridbagAdd(psize1, 2, 4, 2, 1);
       gridbagAdd(psize2, 2, 4, 2, 1);
       gridbagAdd(psize3, 2, 4, 2, 1);
//       gridbagAdd(scrollpane1, 1, 2, 5, 1);
//       gridbagAdd(scrollpane2, 1, 6, 6, 5);
//       gridbagAdd(regist, 0, 12, 1, 1);
//       gridbagAdd(cancel, 2, 12, 1, 1);
       
      
       setVisible(true);
   }   
            
   private void gridbagAdd(Component c, int x, int y, int w, int h) {   
      
      gbc.gridx = x;
      gbc.gridy = y; 
      //가장 왼쪽 위 gridx, gridy값은 0    
      
      gbc.gridwidth  = w;
      gbc.gridheight = h;
      
      
      gbl.setConstraints(c, gbc); //컴포넌트를 컴포넌트 위치+크기 정보에 따라 GridBagLayout에 배치   
      
      add(c);   
      
   }   
   
   public static void main(String[] args) {   
      new RegPro(new JFrame());
           
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      if(e.getSource() == BtModel) {
         ManModel mM = new ManModel(new JFrame());
         xModelNm.setText(mM.ModelName);
         name = mM.ModelNum;
      if(mM.first_ctgr.equals("상의") ||mM.first_ctgr.equals("아우터") || mM.first_ctgr.equals("셔츠")) {
//    	  gridbagAdd(psize1, 2, 4, 2, 1);
//        gridbagAdd(psize2, 2, 4, 2, 1);
//        gridbagAdd(psize3, 2, 4, 2, 1);
    	  psize2.setEnabled(false);
    	  psize2.setVisible(false);
    	  psize3.setEnabled(false);
    	  psize3.setVisible(false);
    	  psize1.setEnabled(true);
    	  psize1.setVisible(true);
    	  o=1;
    	  k=1;
      }else if(mM.first_ctgr.equals("하의")){
//         gridbagAdd(psize2, 2, 4, 2, 1);
//         setVisible(true);
    	  psize2.setEnabled(true);
    	  psize2.setVisible(true);
    	  psize3.setEnabled(false);
    	  psize3.setVisible(false);
    	  psize1.setEnabled(false);
    	  psize1.setVisible(false);
    	  o=2;
    	  k=1;
      }else if(mM.first_ctgr.equals("신발")) {
//         gridbagAdd(psize3, 2, 4, 2, 1);
//         setVisible(true);
    	  psize2.setEnabled(false);
    	  psize2.setVisible(false);
    	  psize3.setEnabled(true);
    	  psize3.setVisible(true);
    	  psize1.setEnabled(false);
    	  psize1.setVisible(false);
    	  o=3;
      }
   } if(e.getSource() == BtPro) {
	   
	   if(o==-1) {
		   
	   }else if(o==1) {
		   ar1 = new ArrayList();
		   k=1;

		   for(int i= 0; i<chsize1.length; i++) {
			   if ( chsize1[i]. isSelected() == true ) {
				   ar1.add(chsize1[i].getText());
		      } 
		   }for(int i = 0; i<ar1.size(); i++) {
//		   System.out.println(ar1.get(i));   
		   }
	   }else if(o == 2) {
		   ar1 = new ArrayList();
		   k=1;

		   for(int i= 0; i<chsize2.length; i++) {
			   if ( chsize2[i]. isSelected() == true ) {
				   ar1.add(chsize2[i].getText());
		      } 
		   }for(int i = 0; i<ar1.size(); i++) {
//		   System.out.println(ar1.get(i));
		   }
	   }else if(o == 3) {
		   ar1 = new ArrayList();
		   k=1;
		   for(int i= 0; i<chsize3.length; i++) {
			   if ( chsize3[i]. isSelected() == true ) {
				   ar1.add(chsize3[i].getText());
		      } 
		   }for(int i = 0; i<ar1.size(); i++) {
//		   System.out.println(ar1.get(i));
		   }
	   }
	   if(k==1) {
		   ar = new ArrayList();
		   for(int i= 0; i<chcolor.length; i++) {
			   if ( chcolor[i]. isSelected() == true ) {
				   ar.add(chcolor[i].getText());
		      } 
		   }
		   for(int i=0;i<ar1.size();i++) {
			   for(int j=0;j<ar.size();j++) {
				   model1.addRow(new Object[] {
						   ar1.get(i),
						   ar.get(j)
				   });					   
//				   System.out.println("사이즈 : "+ar1.get(i) + " 색상 : " + ar.get(j));
				   pro.add(xModelNm.getText()+"_"+ar1.get(i) +"_"+ ar.get(j));

				   }
		   }
		   System.out.println(pro);
		  }
      }if(e.getSource() == BtReg) {
    	  for(int i=0;i<ar1.size();i++) {
			   for(int j=0;j<ar.size();j++) {
	    		   RegProData.createpro(name,xModelNm.getText()+"_"+ar1.get(i) +"_"+ ar.get(j), ar.get(j).toString(), ar1.get(i).toString(), "" );
				   }
		   }


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

