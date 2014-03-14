package com.tree.downloaded;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

@SuppressWarnings("serial")
public class TestCaseTreeMenu extends JPanel implements TreeSelectionListener {

	private JTree tree;

	public TestCaseTreeMenu() {
		setLayout(new GridLayout());      

		DefaultMutableTreeNode testCaseTreeMenuRoot = new DefaultMutableTreeNode("Test Cases");
		DefaultMutableTreeNode child1;
		DefaultMutableTreeNode grandChild2;
		child1 = new DefaultMutableTreeNode("Login");
		testCaseTreeMenuRoot.add(child1);



		grandChild2 = new DefaultMutableTreeNode("TC0001");
		child1.add(grandChild2);
		tree = new JTree(testCaseTreeMenuRoot);
		tree.addTreeSelectionListener(this);
		add(new JScrollPane(tree), BorderLayout.CENTER);
		setSize(250, 275);
		setVisible(true);
	}

	@Override
	public void valueChanged(TreeSelectionEvent event) {
		JScrollPane scrollPane = new JScrollPane(new SampleTestCase());
		String tabName = "TC0001";
		if(!TestCaseOpenTabs.map.keySet().contains(tabName)){
			String index = Integer.toString(CreateClosableTestCaseTab.addClosableTab(TestCaseLandingPage.rightTabbedPane, scrollPane, tabName));
			TestCaseOpenTabs.map.put(tabName,index);
		}
	}
}
