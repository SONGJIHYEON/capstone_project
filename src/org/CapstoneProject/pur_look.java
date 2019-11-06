package org.CapstoneProject;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.EventObject;
import java.util.List;
import java.util.Map;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.CellEditorListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

public class pur_look extends JFrame {

   JPanel pur_list = new pur_list();
   JPanel pur_brkdwn_list = new pur_brkdwn_list();

   Dimension d = Toolkit.getDefaultToolkit().getScreenSize();

   public pur_look() {
      pur_list.setSize(d.width /2, d.height);
      pur_brkdwn_list.setSize(d.width /2, d.height);
      pur_list.setBounds(0, 0, d.width /2, d.height);
      pur_brkdwn_list.setBounds(d.width /2, 0, d.width /2,  d.height);
      add(pur_list);
      add(pur_brkdwn_list);
      
        setLayout(null);
        setSize(d.width,  d.height);
        setResizable(false);
        setVisible(true);
   }

   public static void main(String[] args) {
      new pur_look();
   }

}