package com.tree.downloaded;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneLayout;

@SuppressWarnings("serial")
public class TestCaseLandingPage extends JFrame{

	JSplitPane topBottomSplitPane, rightLeftSplitPane;
	JScrollPane consolePane; 
	JPanel leftPanel, rightPanel;
	public static JTextArea console;
	public static JTabbedPane rightTabbedPane;

	public TestCaseLandingPage() {

		//left panel
		TestCaseTreeMenu testCaseTreeMenu = new TestCaseTreeMenu();
		leftPanel = new JPanel();
		leftPanel.setLayout(new GridLayout());
		leftPanel.add(testCaseTreeMenu);

		//right panel
		rightTabbedPane = new JTabbedPane();
		TestCaseWelcomeArea wPanel = new TestCaseWelcomeArea();        
		rightTabbedPane.add("Welcome", wPanel);
		rightPanel = new JPanel();
		rightPanel.setLayout(new GridLayout());
		rightPanel.add(rightTabbedPane, BorderLayout.EAST);

		//console panel
		console = new JTextArea();    	
		consolePane = new JScrollPane();
		console.setText("....");
		consolePane.setBackground(Color.decode("#90EE90"));
		consolePane.add(console);
		consolePane.setLayout(new ScrollPaneLayout());

		//split pane - top        
		rightLeftSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,leftPanel, rightPanel);
		rightLeftSplitPane.setOneTouchExpandable(true);
		rightLeftSplitPane.setResizeWeight(0.15);

		//split pane - bottom
		topBottomSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT,rightLeftSplitPane, consolePane);
		topBottomSplitPane.setOneTouchExpandable(true);
		topBottomSplitPane.setResizeWeight(0.95);
		getContentPane().add(topBottomSplitPane, BorderLayout.CENTER);
		
		setSize(800, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new TestCaseLandingPage();
	}
}
