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
import javax.swing.UnsupportedLookAndFeelException;

import net.miginfocom.swing.MigLayout;
import javax.swing.JTree;
import java.awt.SystemColor;

import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

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
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		VTextIcon textIcon = new VTextIcon(panel, "Object Repository",  VTextIcon.ROTATE_LEFT);
		CompositeIcon icon = new CompositeIcon(graphicIcon, textIcon);

		JPanel leftComponent = new JPanel(new MigLayout("", "[grow][][][]", "[][][grow]"));
		JPanel rightComponent = new JPanel(new MigLayout("", "[grow]", "[grow]"));

		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
				leftComponent, rightComponent);
		JButton button = new JButton("Add");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		leftComponent.add(button, "flowx,cell 0 0");
		button.setBorderPainted(false);
		
		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(button, popupMenu);
		
		JLabel lblNewLabel = new JLabel("New label");
		popupMenu.add(lblNewLabel);
		JButton button1 = new JButton("Delete");
		leftComponent.add(button1, "cell 0 0");
		button1.setBorderPainted(false);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setEditable(true);
		leftComponent.add(comboBox, "cell 0 1,growx");
		
		JTree tree = new JTree();
		leftComponent.add(tree, "cell 0 2 2 1,grow");
		
		DefaultTableModel model ;
		String[] columnNames = {"ObjectName","Identifier1","Identifier2","Identifier3", "Identifier4", "Identifier5","Identifier6","Identifier7"};
		Object[][] data = {{"ObjectName","1"}, {"ObjectName","2"}, {"ObjectName","3"}};
        model = new DefaultTableModel(data, columnNames);
        table = new JTable(model);
        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(true);
        JScrollPane scrollPane = new JScrollPane(table);
        
        JPopupMenu popupMenu_1 = new JPopupMenu();
        addPopup(table, popupMenu_1);
        
       
        rightComponent.add(scrollPane ,"cell 0 0,grow");
        
        /* http://stackoverflow.com/questions/3558293/java-swing-jtable-right-click-menu-how-do-i-get-it-to-select-aka-highlight-t */
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                int r = table.rowAtPoint(e.getPoint());
                if (r >= 0 && r < table.getRowCount()) {
                    table.setRowSelectionInterval(r, r);
                } else {
                    table.clearSelection();
                }

                int rowindex = table.getSelectedRow();
                if (rowindex < 0)
                    return;
                if (e.isPopupTrigger() && e.getComponent() instanceof JTable ) {
                    JPopupMenu popup = new JPopupMenu();
                    JMenuItem mntmCopyRow = new JMenuItem("Copy Row");
                    popup.add(mntmCopyRow);
                    popup.show(e.getComponent(), e.getX(), e.getY());
                }
            }
        });
        
		tp.addTab(null, icon, splitPane);
		VTextIcon textIcon2 = new VTextIcon(panel, "Requirements",  VTextIcon.ROTATE_LEFT);
		CompositeIcon icon2 = new CompositeIcon(graphicIcon, textIcon2);
		JPanel p1 = new JPanel();
		p1.setOpaque(false);
		tp.addTab(null, icon2, p1);
		panel.add(tp);
		return panel;
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
