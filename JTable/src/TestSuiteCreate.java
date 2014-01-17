import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TestSuiteCreate {

	public void createAndShowGUITestSuiteCreate() 
	{
		JFrame frame = new JFrame("Test Suite");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		String[] columnNames = {"Run_Settings",
                "Test_Script_Name",
                "Test_Case"};

		Object[][] data = {
							{"Kathy", "Smith","Snowboarding"},
							{"John", "Doe","Rowing"},
						    {"Sue", "Black","Knitting"},
						    {"Jane", "White","Speed reading"},
						    {"Joe", "Brown","Pool"}
						   };

		final JTable table = new JTable(data, columnNames);
		table.setPreferredScrollableViewportSize(new Dimension(500, 70));
		table.setFillsViewportHeight(true);
		JScrollPane scrollPane = new JScrollPane(table);
		Dimension d = new Dimension(500,400);
		frame.setPreferredSize(d);
		frame.setLayout(null);
		scrollPane.setBounds(50, 70, 400, 100);
		frame.add(scrollPane);
		frame.pack();
		frame.setVisible(true);
	}
}
