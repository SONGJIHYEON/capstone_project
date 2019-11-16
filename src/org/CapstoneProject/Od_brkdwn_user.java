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
import java.util.List;
import java.util.Map;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

import org.CapstoneProject.Od_list_user.TableCell2;

public class Od_brkdwn_user extends Dialog implements ActionListener {

   private static String[] col1 = { "주문번호", "상품명", "수량", "단가", "금액", "후기작성" };

   private static DefaultTableModel model1 = new DefaultTableModel(col1, 0);
   private JButton Btcancel;

   private JTable pur_info;
   private JScrollPane scrollpane1;
   static String od_num, pro_num;
   GridBagLayout gridbaglayout;
   GridBagConstraints gridbagconstraints; // gridbag레이아웃에 컴포넌트의 위치를 잡아주는 역할

   public Od_brkdwn_user(JFrame fr) {
      super(fr, "", true);
      
      gridbaglayout = new GridBagLayout();
      gridbagconstraints = new GridBagConstraints();

      pur_info = new JTable(model1);
      pur_info.getColumnModel().getColumn(5).setCellRenderer(new TableCell2());
      pur_info.getColumnModel().getColumn(5).setCellEditor(new TableCell2());
      scrollpane1 = new JScrollPane(pur_info);
      scrollpane1.setPreferredSize(new Dimension(600, 300));
      
      Btcancel = new JButton("닫기");
      Btcancel.addActionListener(this);

//         getDeptData(EmpData.selectDept());

//         getSvpData(EmpData.selectSpv());
      pack();
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
      gridbagconstraints.anchor = GridBagConstraints.WEST;
      
      gridbagconstraints.anchor = GridBagConstraints.EAST;
      gridbagAdd(Btcancel, 0, 1, 1, 1);

      getData(Od_brkdwn_Data.selectOd_brkdwn_user(Od_list_user.od_num));
      
      pack();
      setVisible(true);
   }

   static void getData(List<Map<String, Serializable>> od_brkdwnListData) {

      model1.setNumRows(0);

      for (int i = 0; i < od_brkdwnListData.size(); i++) {

         model1.addRow(new Object[] {

               od_brkdwnListData.get(i).get("OD_NUM"),
               od_brkdwnListData.get(i).get("PRO_NM"),
               od_brkdwnListData.get(i).get("QUANT"),
               od_brkdwnListData.get(i).get("UP"),
               od_brkdwnListData.get(i).get("PR")

         });
      }

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

   public static void main(String[] args) {
      new Od_brkdwn_user(new JFrame());
   }
   
   class TableCell2 extends AbstractCellEditor implements TableCellEditor, TableCellRenderer {

	      JButton jb;

	      public TableCell2() {
	         // TODO Auto-generated constructor stub
	         jb = new JButton("작성");
	         jb.setBackground(Color.WHITE);
	         jb.setFocusPainted(false);
	         jb.addActionListener(e -> {
	             int row = pur_info.getSelectedRow();
	             od_num = "";
	             od_num += (String) pur_info.getValueAt(row, 0);
	             pro_num = "";
	             pro_num += (String) pur_info.getValueAt(row, 1);
	        	 new Review_write(new JFrame());
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
      if(e.getSource() == Btcancel) {
         dispose();
      }

   }

}