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
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.CellEditorListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

public class test2 extends JFrame implements ActionListener {

	JPanel pur_list = new pur_list();
	JPanel pur_brkdwn_list = new pur_brkdwn_list();

	JButton BtClose;

	Dimension d = Toolkit.getDefaultToolkit().getScreenSize();

	public test2() {
//		pur_list.setSize(d.width / 3, d.height / 2);
		pur_list.setBounds(0, 0, 440, 380);
//		pur_brkdwn_list.setSize(d.width / 3, d.height / 2);
		pur_brkdwn_list.setBounds(440, 0, 630, 380);

		BtClose = new JButton("닫기");
		BtClose.setBounds(985, 385, 70, 30);
		BtClose.addActionListener(this);

		getContentPane().add(BtClose);
		getContentPane().add(pur_list);
		getContentPane().add(pur_brkdwn_list);

		getContentPane().setLayout(null);
		setSize(1090, 470);
//		setResizable(false);
		setVisible(true);
	}

	public static void main(String[] args) {
		new test2();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == BtClose) {
			dispose();
		}
	}
}