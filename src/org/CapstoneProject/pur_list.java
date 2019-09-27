
  
package org.CapstoneProject;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.EventObject;
import java.util.List;
import java.util.Map;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.CellEditorListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

public class pur_list extends Dialog implements ActionListener {
         
   private static String[] col1 = {"구매번호","구매일자","총금액",""};
   
   private static DefaultTableModel model1 = new DefaultTableModel(col1, 0);
   
   private JTable pur_info;
   private JScrollPane scrollpane1;
         
   private JButton Bpur_regist, Bclose, jb;
   
   static String pur_num, pur_num2;
         
   GridBagLayout gridbaglayout;      
   GridBagConstraints gridbagconstraints;      // gridbag레이아웃에 컴포넌트의 위치를 잡아주는 역할
         
   public pur_list(JFrame fr) {      
	   super(fr, "", true);
         gridbaglayout = new GridBagLayout();
         gridbagconstraints = new GridBagConstraints();
         
         pur_info = new JTable(model1);
         scrollpane1 = new JScrollPane(pur_info);
         scrollpane1.setPreferredSize(new Dimension(1000, 300));
         
         Bpur_regist = new JButton("구매등록");
         Bpur_regist.addActionListener(this);
         Bpur_regist.setFont(new Font("휴먼매직체", Font.PLAIN , 20));
         Bpur_regist.setPreferredSize(new Dimension(100,40));
         Bpur_regist.setBackground(Color.WHITE);
         
         Bclose = new JButton("닫기");
         Bclose.addActionListener(this);
         Bclose.setFont(new Font("휴먼매직체", Font.PLAIN , 20));
         Bclose.setPreferredSize(new Dimension(100,40));
         Bclose.setBackground(Color.WHITE);
         
         
//         getDeptData(EmpData.selectDept());
//         getSvpData(EmpData.selectSpv());
         
  	   pur_info.getColumnModel().getColumn(3).setCellRenderer(new TableCell());
  	   pur_info.getColumnModel().getColumn(3).setCellEditor(new TableCell());
         
         EmpRegisterView();
      }   
         
   private void EmpRegisterView() {      
         
         gridbagconstraints.anchor = GridBagConstraints.WEST;
//         gridbagconstraints.ipadx = 7;
//         
//         gridbagconstraints.weightx=1.0;
//         gridbagconstraints.weighty=1.0;
         
         setLayout(gridbaglayout);
         gridbagconstraints.anchor = GridBagConstraints.CENTER;
         
         gridbagAdd(scrollpane1, 0, 0, 1, 1);
         gridbagAdd(Bclose,0,1,1,1);
         gridbagconstraints.anchor = GridBagConstraints.WEST;
         gridbagconstraints.anchor = GridBagConstraints.EAST;
         gridbagAdd(Bpur_regist,0,1,1,1);


     	 System.out.println(corr_look.corr_num);

         getData(purData.selectpur(corr_look.corr_num));

         pack();
         setResizable(true);
         setVisible(true);
      }   
         
      private void gridbagAdd(Component c, int x, int y, int w, int h) {   
         
         gridbagconstraints.gridx = x;
         gridbagconstraints.gridy = y; 
            //가장 왼쪽 위 gridx, gridy값은 0    
         
         gridbagconstraints.gridwidth  = w;
         gridbagconstraints.gridheight = h;
              
               
          gridbaglayout.setConstraints(c, gridbagconstraints); //컴포넌트를 컴포넌트 위치+크기 정보에 따라 GridBagLayout에 배치   
         
         add(c);   
         
         }
      
      static void getData(List<Map<String, Serializable>> purListData) {
    	  
    	  model1.setNumRows(0);

	      for(int i=0; i < purListData.size(); i++) {
	    	  model1.addRow(new Object[] {
	               
	    			  purListData.get(i).get("PUR_NUM"),
	    			  purListData.get(i).get("PUR_DT"),
	    			  purListData.get(i).get("TOT_PR")

	         });
	      }


	   }
         
      public static void main(String[] args) {  
         new pur_list(new JFrame());
      } 
      
      
      class TableCell extends AbstractCellEditor implements TableCellEditor, TableCellRenderer{
           
          public TableCell() {
              // TODO Auto-generated constructor stub
              jb = new JButton("상세내역조회");
              jb.setBackground(Color.WHITE);
              jb.setFocusPainted(false);
              jb.addActionListener(e -> {
            	int row = pur_info.getSelectedRow();
              	pur_num = "";
              	pur_num += (String) pur_info.getValueAt(row, 0);
              	System.out.println(pur_num);
      			pur_brkdwn_list s = new pur_brkdwn_list(new JFrame());
              });
           
          }
           
          @Override
          public Object getCellEditorValue() {
              // TODO Auto-generated method stub
              return null;
          }
          @Override
          public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
                  int row, int column) {
              // TODO Auto-generated method stub
              return jb;
          }
          @Override
          public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
                  int column) {
              // TODO Auto-generated method stub
              return jb;
          }
           
      }


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == Bclose) {
			dispose();
		}else if (e.getSource() == Bpur_regist) {
			pur_regist s = new pur_regist(new JFrame());
		}
		
	}
         
}

