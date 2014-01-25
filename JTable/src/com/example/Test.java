package com.example;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import net.miginfocom.swing.MigLayout;
import javax.swing.JTree;
import java.awt.SystemColor;

import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollBar;

public class Test implements SwingConstants {
	private JTable table;
	int height;
	public static void main(String[] args) {
		new Test();
	}

	public Test() {
		JFrame fr = new JFrame("Test");
		fr.getContentPane().add(testComponent());
		fr.setSize(new Dimension(600, 400));
		fr.setVisible(true);
	}

	JComponent testComponent() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0,1));
		JTabbedPane tp = new JTabbedPane(LEFT);
		Icon graphicIcon = UIManager.getIcon("FileView.computerIcon");
		VTextIcon textIcon = new VTextIcon(panel, "Object Repository",  VTextIcon.ROTATE_LEFT);
		CompositeIcon icon = new CompositeIcon(graphicIcon, textIcon);

		JPanel leftComponent = new JPanel(new MigLayout("width 200!", "[grow][][]", "[][grow]"));
		JPanel rightComponent = new JPanel(new MigLayout("", "[grow]", "[grow]"));

		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
				leftComponent, rightComponent);
		JButton button = new JButton("Add");
		leftComponent.add(button, "flowx,cell 0 0");
		button.setBorderPainted(false);
		
		DefaultTableModel model ;
		String[] columnNames = {"ObjectName","Object_Xpath"};
        model = new DefaultTableModel(null, columnNames);
        table = new JTable(model);
        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(true);
        JScrollPane scrollPane = new JScrollPane(table);
        rightComponent.add(scrollPane ,"cell 0 0,grow");
        
		final JTree tree = new JTree();
		leftComponent.add(tree, "cell 0 1, grow");
		tree.setLayout(new MigLayout());
		tree.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("Object Repository") {
				{
					DefaultMutableTreeNode node_1;
					node_1 = new DefaultMutableTreeNode("Repository 1");
						node_1.add(new DefaultMutableTreeNode("Main Page"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("Repository 2");
						node_1.add(new DefaultMutableTreeNode("Second Page"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("Repository 3");
						node_1.add(new DefaultMutableTreeNode("Third Page"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("Repository 4");
					node_1.add(new DefaultMutableTreeNode("Fourth Page"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("Repository 5");
					node_1.add(new DefaultMutableTreeNode("Fifth Page"));
					add(node_1);
					height = tree.getBounds().height;
					System.out.println(height);
				}
			}
		));
		tree.setForeground(SystemColor.inactiveCaptionBorder);
		tree.setBackground(Color.WHITE);
		JButton button1 = new JButton("Delete");
		leftComponent.add(button1, "cell 0 0");
		button1.setBorderPainted(false);



		tp.addTab(null, icon, splitPane);
		VTextIcon textIcon2 = new VTextIcon(panel, "Requirements",  VTextIcon.ROTATE_LEFT);
		CompositeIcon icon2 = new CompositeIcon(graphicIcon, textIcon2);
		JPanel p1 = new JPanel();
		p1.setOpaque(false);
		tp.addTab(null, icon2, p1);
		panel.add(tp);
		return panel;
	}
}
