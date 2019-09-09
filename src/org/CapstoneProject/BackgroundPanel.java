package org.CapstoneProject;


import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

class BackgroundPanel extends JPanel{
		
		String Simg;
		
		BufferedImage img;
		
		public void imgread() {
			
			Simg = "aa";
			
			try {
		        img = ImageIO.read(new File("C:\\Users\\ssong\\Desktop\\img\\"+Simg+".jpg"));
		     } catch (IOException e) {
		        JOptionPane.showMessageDialog(null, "이미지 불러오기 실패");
		        System.exit(0);
		     }

		}
	
        public void paint(Graphics g) {
            
        	for(int i = 0 ; i < 4 ; i++) {
        		for(int j = 0 ; j < 3 ; j++) {
	        		imgread();
	        		Dimension d = getSize();
	        		g.drawImage(img, i*(d.width/4 + 10), j*d.height/3, d.width/4, d.height/3, null);
	        		setOpaque(true);
	                
	                System.out.println(6);
        		}
        	}
		}

	}