package org.CapstoneProject;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
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

public class MainProImg extends JPanel {   
	private JLabel Main;

//	private JComboBox<String> cbSel;      
	         
	GridBagLayout gridbaglayout;      
	GridBagConstraints gridbagconstraints;      // gridbag���̾ƿ��� ������Ʈ�� ��ġ�� ����ִ� ����
	         
	public MainProImg() {
		
        gridbaglayout = new GridBagLayout();
        gridbagconstraints = new GridBagConstraints();
        
        
        MainProImgView();
      }   
	         
	private void MainProImgView() {
		
//        setTitle("��� ���");
        
//        gridbagconstraints.ipadx = 7;
//        
//        gridbagconstraints.weightx=1.0;
//        gridbagconstraints.weighty=1.0;
        
        setLayout(gridbaglayout);
       
         BackgroundPanel sub = new BackgroundPanel();
         sub.setSize(1377, 768);
         add(sub);
         setLayout(null);
        
         
        gridbagconstraints.anchor = GridBagConstraints.CENTER;
        gridbagconstraints.anchor = GridBagConstraints.EAST;
        gridbagconstraints.anchor = GridBagConstraints.WEST;
        
//        setExtendedState(MAXIMIZED_BOTH);
	    setVisible(true);
	}
	
	private void gridbagAdd(Component c, int x, int y, int w, int h) {   
		gridbagconstraints.gridx = x;
        gridbagconstraints.gridy = y; 
	            //���� ���� �� gridx, gridy���� 0    
	         
        gridbagconstraints.gridwidth  = w;
        gridbagconstraints.gridheight = h;
	               
        gridbaglayout.setConstraints(c, gridbagconstraints); //������Ʈ�� ������Ʈ ��ġ+ũ�� ������ ���� GridBagLayout�� ��ġ   
	         
        add(c);   
	         
     }   
	public static void main(String[] args) {   
		new MainProImg();
    	 }
}
	         

