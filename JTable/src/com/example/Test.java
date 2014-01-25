package com.example;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import net.miginfocom.swing.MigLayout;

public class Test implements SwingConstants {
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
		VTextIcon textIcon = new VTextIcon(panel, "Test Management",  VTextIcon.ROTATE_LEFT);
		CompositeIcon icon = new CompositeIcon(graphicIcon, textIcon);

		JPanel leftComponent = new JPanel(new MigLayout("", "[1]", "[0][][][][]"));
		JPanel rightComponent = new JPanel(new MigLayout("", "[grow]", "[]"));

		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
				leftComponent, rightComponent);

		JTextField textField = new JTextField();
		rightComponent.add(textField, "cell 0 0,growx");
		textField.setColumns(10);

		leftComponent.add(new JButton("Button 1"), "cell 0 0");
		JButton button = new JButton("Button 2");
		leftComponent.add(button, "cell 0 1");
		JButton button_1 = new JButton("Button 3");
		leftComponent.add(button_1, "cell 0 2");
		JButton button_2 = new JButton("Button 4");
		leftComponent.add(button_2, "cell 0 3");
		
		JButton btnNewButton = new JButton("New button");
		leftComponent.add(btnNewButton, "cell 0 4");



		JPanel p = new JPanel();

		p.setOpaque(false);
		p.add(new JButton("hiiii"));
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
