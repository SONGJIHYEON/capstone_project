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

public class RegPro extends JFrame implements ActionListener, ItemListener {
   
   ArrayList ar = new ArrayList();
   
   private JLabel vRegModel, vRegPro2, vProNm, vSale, vModelCtgr2, vModelNm, vPrice, vAdminModel, 
   vModelCtgr, vRegPro, vAdminPro, vProUp, vProSize, vProDetail, vProColor, vProStock;
   private JTextField xModelNm, xProNm, xSale, xModelCtgr2, xProDetail, xPrice, xProStock, xColor;

   
//   private JTextArea xPrice;

//   private JPasswordField xMemPw1, xMemPw2;
//   private String[] ctgr1 = {"����", "����", "�ƿ���", "����", "�Ź�"};
//   private String[] size = {""};
   private String[] size1 = {"90", "95", "100", "105", "110"};
   private String[] size2 = {"27", "28", "29", "30", "31", "32", "33", "34", "35" };  
   private String[] size3 = {"250", "255", "260", "265", "270", "275", "280", "285"};
   private String[] color = {"BLACK", "BLUE", "CYAN", "DARK_GRAY", "GRAY", "GREEN", "LIGHT_GRAY", "ORANGE", "PINK", "RED", "WHITE", "YELLOW"};
   
   
   private JCheckBox[] chsize1 = new JCheckBox[size1.length];
   private JCheckBox[] chsize2 = new JCheckBox[size2.length];
   private JCheckBox[] chsize3 = new JCheckBox[size3.length];
   private JCheckBox[] chcolor = new JCheckBox[color.length];

   private JTable tBest, tNew;      
   private JScrollPane scrollpane1, scrollpane2;  
   
   private JButton BtBussMan, BtProMan, BtOdMan, BtMbMan, BtEmpMan, BtSearch, BtReg, BtCancel, BtModel, BtPro, BtColor; 
   private JRadioButton RSale, RSoldOut, RBehind;
   private ButtonGroup BtRadio;
   private JPanel PRadio, psize1, psize2, psize3, pcolor;
   private JComboBox<String> CbSize;
   private JTextArea taProNm;
   
   int i;
   
   GridBagLayout gbl;
   GridBagConstraints gbc;
   
   public RegPro(JFrame fr) {
      

      gbl = new GridBagLayout();
      gbc = new GridBagConstraints(); 
        
      vRegModel = new JLabel("�𵨵��");
      vRegModel.setPreferredSize(new Dimension(200,28));
      vRegPro2 = new JLabel("��ǰ���");
      vRegPro2.setPreferredSize(new Dimension(200,28));
      vAdminModel = new JLabel("���K�˻�");
      vAdminModel.setPreferredSize(new Dimension(200,28));
      vModelCtgr = new JLabel("�𵨺з�");
      vModelCtgr.setPreferredSize(new Dimension(200,28));
      vRegPro = new JLabel("��ǰ���");
      vRegPro.setPreferredSize(new Dimension(200,28));
      vAdminPro = new JLabel("��ǰ����");
      vAdminPro.setPreferredSize(new Dimension(200,28));
      vProUp = new JLabel("��ǰ�ܰ�����");
        vProUp.setPreferredSize(new Dimension(200,28));
        
      vProNm = new JLabel("��ǰ��");
      vProColor = new JLabel("��ǰ ����");
//      vProStock = new JLabel("�����");

      xModelNm = new JTextField(20);
      taProNm = new JTextArea();
      xSale = new JTextField(20);
      xProDetail = new JTextField(20);
      xColor = new JTextField(20);
//      xPrice = new JTextField(20);
//      xProStock = new JTextField(20);
      
      vModelNm = new JLabel("�𵨸�");
//      vPrice = new JLabel("��ǰ ����");
      vSale = new JLabel("�ǸŻ���");
//      CbSize = new JComboBox<String>(size);
//      CbSize.setPreferredSize(new Dimension(100,25));
//      vModelCtgr2 = new JLabel("2���з�");
      vProSize = new JLabel("��ǰ ������");
      vProDetail = new JLabel("��ǰ �� ����");
      
      RSale = new JRadioButton("�Ǹ���");
      RSale.setSelected(true);
      RSoldOut = new JRadioButton("ǰ��");
      RBehind = new JRadioButton("����");
      
      BtRadio = new ButtonGroup();
      BtRadio.add(RSale);
      BtRadio.add(RSoldOut);
      BtRadio.add(RBehind);
   
      PRadio = new JPanel(new FlowLayout(FlowLayout.CENTER));
      PRadio.add(RSale);
      PRadio.add(RSoldOut);
      PRadio.add(RBehind);
      
      psize1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
      psize1.setPreferredSize(new Dimension(250,30));
      psize2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
      psize2.setPreferredSize(new Dimension(250,80));
      psize3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
      psize3.setPreferredSize(new Dimension(250,80));
      pcolor = new JPanel(new FlowLayout(FlowLayout.LEFT));
      pcolor.setPreferredSize(new Dimension(250,100));
      
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
         chcolor[i].addItemListener(this);
         pcolor.add(chcolor[i]);
      }
      
      BtBussMan = new JButton("�ŷ�����");
      BtBussMan.setPreferredSize(new Dimension(200,28));
      
      BtModel = new JButton("�� �ҷ�����");
      BtModel.addActionListener(this);
        
//        regist.addActionListener(this);
      BtProMan = new JButton("��/��ǰ����");
      BtProMan.setPreferredSize(new Dimension(200,28));
//        cancel.addActionListener(this);
      BtOdMan = new JButton("�ֹ�����");
      BtOdMan.setPreferredSize(new Dimension(200,28));
      BtMbMan = new JButton("ȸ������");
      BtMbMan.setPreferredSize(new Dimension(200,28));
      BtEmpMan = new JButton("��������");
      BtEmpMan.setPreferredSize(new Dimension(200,28));
//      BtSearch = new JButton("�˻�");
//      BtSearch.setPreferredSize(new Dimension(100,28));
      
      BtColor = new JButton("���� ��������");
      BtColor.addActionListener(this);
      BtPro = new JButton("��ǰ�� ����");
      BtPro.setPreferredSize(new Dimension(109,28));
      BtPro.addActionListener(this);
      BtReg = new JButton("���");
      BtCancel = new JButton("�ݱ�");


      setExtendedState(MAXIMIZED_BOTH);
      RegProView();
   }
   
   private void RegProView() {

      setTitle("Ȩ������ ������");
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
       gridbagAdd(taProNm, 2, 6, 2, 1);
//       gridbagAdd(xPrice, 2, 3, 2, 1);
       gridbagAdd(PRadio, 2, 3, 2, 1);
       gridbagAdd(xProDetail, 2, 7, 2, 1);
//       gridbagAdd(CbSize, 2, 4, 2, 1);
       gridbagAdd(pcolor, 2, 5, 2, 1);

//       gridbagAdd(vTop, 1, 1, 1, 1);
//       gridbagAdd(vBottom, 2, 1, 1, 1);
//       gridbagAdd(vOuter, 3, 1, 1, 1);
//       gridbagAdd(vShirts, 4, 1, 1, 1);
       
        gbc.anchor = GridBagConstraints.CENTER;
//        gridbagAdd(BtBussMan, 1, 0, 1, 1);
//        gridbagAdd(BtProMan, 2, 0, 2, 1);
//        gridbagAdd(BtOdMan, 4, 0, 1, 1);
//        gridbagAdd(BtMbMan, 5, 0, 1, 1);
//        gridbagAdd(BtEmpMan, 6, 0, 1, 1);
        gbc.anchor = GridBagConstraints.WEST;
        gridbagAdd(BtModel, 4, 2, 1, 1);
        gridbagAdd(BtReg, 2, 10, 1, 1);
        gridbagAdd(BtPro, 4, 6, 1, 1);
        gridbagAdd(BtColor, 4, 5, 1, 1);
        gbc.anchor = GridBagConstraints.EAST;
        gridbagAdd(BtCancel, 3, 10, 1, 1);
        
//       gridbagAdd(scrollpane1, 1, 2, 5, 1);
//       gridbagAdd(scrollpane2, 1, 6, 6, 5);
//       gridbagAdd(regist, 0, 12, 1, 1);
//       gridbagAdd(cancel, 2, 12, 1, 1);
       
      
       setVisible(true);
   }   
            
   private void gridbagAdd(Component c, int x, int y, int w, int h) {   
      
      gbc.gridx = x;
      gbc.gridy = y; 
      //���� ���� �� gridx, gridy���� 0    
      
      gbc.gridwidth  = w;
      gbc.gridheight = h;
      
      
      gbl.setConstraints(c, gbc); //������Ʈ�� ������Ʈ ��ġ+ũ�� ������ ���� GridBagLayout�� ��ġ   
      
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
      if(mM.first_ctgr.equals("����") ||mM.first_ctgr.equals("�ƿ���") || mM.first_ctgr.equals("����")) {
         gridbagAdd(psize1, 2, 4, 2, 1);
         setVisible(true);
         
      }else if(mM.first_ctgr.equals("����")){
         gridbagAdd(psize2, 2, 4, 2, 1);
         setVisible(true);
      }else if(mM.first_ctgr.equals("�Ź�")) {
         gridbagAdd(psize3, 2, 4, 2, 1);
         setVisible(true);
      }
   } if(e.getSource() == BtPro) {
      xProNm.setText(xModelNm.getText() + "-" + CbSize.getSelectedItem());   
      } 
   if(e.getSource() == BtColor) {
	   for(int i= 0; i<color.length; i++) {
//	   System.out.println(color[i]);
                
                final int value = i;
               chcolor[i].addItemListener(new ItemListener() {
                   public void itemStateChanged(ItemEvent e) {
                      Object source = e.getItemSelectable();
                      if(source == chcolor[value]) {
                      if(e.getStateChange() == ItemEvent.DESELECTED ) {    
                         System.out.println(1);
                         }else
                            System.out.println(chcolor[value].getText());
                       }
                   }
               });
         }
      }
  
   }
   @Override
   public void itemStateChanged(ItemEvent e) {
      if(e.getSource() ==BtColor) {
      if(e.getStateChange() == ItemEvent.SELECTED) {
//            System.out.println(1);
         }
      }
   } 
}



   
         