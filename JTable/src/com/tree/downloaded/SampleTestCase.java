package com.tree.downloaded;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import javax.swing.JComboBox;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class SampleTestCase extends JPanel{
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	public SampleTestCase() {
		setLayout(new MigLayout("", "[grow][grow][grow][grow]", "[][]"));

		JLabel lblCommand = new JLabel("Command");
		add(lblCommand, "cell 0 0");

		JLabel lblTarget = new JLabel("Target");
		add(lblTarget, "cell 1 0");

		JLabel lblParameter1 = new JLabel("Parameter1");
		add(lblParameter1, "cell 2 0");
		
		JLabel lblParameter2 = new JLabel("Parameter2");
		add(lblParameter2, "cell 3 0");
		
		JComboBox comboBox = new JComboBox();
		add(comboBox, "cell 0 1,growx");
		
		textField = new JTextField();
		add(textField, "cell 1 1,growx");
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		add(textField_1, "cell 2 1,growx");
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		add(textField_2, "cell 3 1,growx");
		textField_2.setColumns(10);

	}

}
