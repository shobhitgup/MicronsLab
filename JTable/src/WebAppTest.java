import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

@SuppressWarnings("serial")
public class WebAppTest extends JPanel
{
	
	public void createAndShowGUIWebAppTest() 
	{
		
		JMenuBar menuBar;
		JMenu menu, menu1, menu2, menu3, menu4, menu5 = null;
		JMenuItem menuItem1,menuItem2,menuItem3,menuItem4;
		
		final JFrame frame1 = new JFrame("Web Application");
        //frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Create and set up the content pane.
		WebAppTest newContentPane = new WebAppTest();
		newContentPane.setOpaque(true); //content panes must be opaque
		frame1.setContentPane(newContentPane);
		Dimension d = new Dimension(550,300);
		frame1.setPreferredSize(d);

		//Display the window.
		frame1.pack();
		frame1.setLocationRelativeTo(null);
		frame1.setVisible(true);
		frame1.setResizable(false);
		//frame1.setLayout(null);
		
		JLabel jlabel = new JLabel("Common Configuration");
		jlabel.setBounds(50, 0, 100, 100);
		frame1.add(jlabel);
		final String[] col = { "Project Name", "Environment", "URL", "DataBase IP"};
		  //Object[][] data1 = { {"Test", "Test", "www.gmail.com","10.1.16.93"}};
		  final DefaultTableModel model = new DefaultTableModel(null, col);
		  JTable table1 = new JTable(model);
		  table1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		  table1.setPreferredScrollableViewportSize(new Dimension(500, 70));
		  table1.setFillsViewportHeight(true);
		  
		  JScrollPane ScrollPane = new JScrollPane(table1);
		  ScrollPane.setBounds(50, 70, 400, 71);
		  frame1.getContentPane().add(ScrollPane);
		  
		
		menuBar = new JMenuBar();
		menu = new JMenu("Test Suite");
		menu1 = new JMenu("Test Case");
		menu2 = new JMenu("Test Steps");
		menu3 = new JMenu("Object Repository");
		menu4 = new JMenu("Reports");
		menu5 = new JMenu("Reuseable Functions");
		
		menuItem1 = new JMenuItem("Create");
		menuItem2 = new JMenuItem("Update");
		//menuItem3 = new JMenuItem("Delete");
		menuItem4 = new JMenuItem("View");
		
		JMenuItem menuItem5 = new JMenuItem("Create");
		JMenuItem menuItem6 = new JMenuItem("Update");
		//JMenuItem menuItem7 = new JMenuItem("Delete");
		JMenuItem menuItem8 = new JMenuItem("View");
		
		JMenuItem menuItem9 = new JMenuItem("Create");
		JMenuItem menuItem10 = new JMenuItem("Update");
		//JMenuItem menuItem11 = new JMenuItem("Delete");
		JMenuItem menuItem12 = new JMenuItem("View");
		
		JMenuItem menuItem13 = new JMenuItem("Create");
		JMenuItem menuItem14 = new JMenuItem("Update");
		//JMenuItem menuItem15 = new JMenuItem("Delete");
		JMenuItem menuItem16 = new JMenuItem("View");
		
		JMenuItem menuItem17 = new JMenuItem("Create");
		JMenuItem menuItem18 = new JMenuItem("Update");
		//JMenuItem menuItem19 = new JMenuItem("Delete");
		JMenuItem menuItem20 = new JMenuItem("View");
		
		menu.add(menuItem1);
		menu.addSeparator();
		menu.add(menuItem2);
		menu.addSeparator();
		//menu.add(menuItem3);
		//menu.addSeparator();
		menu.add(menuItem4);
		
		menu1.add(menuItem5);
		menu1.addSeparator();
		menu1.add(menuItem6);
		menu1.addSeparator();
		//menu1.add(menuItem7);
		//menu1.addSeparator();
		menu1.add(menuItem8);
		
		menu2.add(menuItem9);
		menu2.addSeparator();
		menu2.add(menuItem10);
		menu2.addSeparator();
		//menu2.add(menuItem11);
		//menu2.addSeparator();
		menu2.add(menuItem12);
		
		menu3.add(menuItem13);
		menu3.addSeparator();
		menu3.add(menuItem14);
		menu3.addSeparator();
		//menu3.add(menuItem15);
		//menu3.addSeparator();
		menu3.add(menuItem16);
		
		menu5.add(menuItem17);
		menu5.addSeparator();
		menu5.add(menuItem18);
		menu5.addSeparator();
		//menu5.add(menuItem19);
		//menu5.addSeparator();
		menu5.add(menuItem20);
		
		menuBar.add(menu);
		//JSeparator sep1 = new JSeparator(JSeparator.VERTICAL);
		//menuBar.add(sep1, "growy");
		menuBar.add(menu1);
		//JSeparator sep2 = new JSeparator(JSeparator.VERTICAL);
		//menuBar.add(sep2, "growy");
		menuBar.add(menu2);
		//JSeparator sep3 = new JSeparator(JSeparator.VERTICAL);
		//menuBar.add(sep3, "growy");
		//menu3.setHorizontalTextPosition(SwingConstants.CENTER);
		menuBar.add(menu3);
		//JSeparator sep4 = new JSeparator(JSeparator.VERTICAL);
		//menuBar.add(sep4, "growy");
		menuBar.add(menu4);
		//JSeparator sep5 = new JSeparator(JSeparator.VERTICAL);
		//menuBar.add(sep5, "growy");
		menuBar.add(menu5);
		menuBar.setBackground(Color.GRAY);
		menu.setForeground(Color.WHITE);
		menu1.setForeground(Color.WHITE);
		menu2.setForeground(Color.WHITE);
		menu3.setForeground(Color.WHITE);
		menu4.setForeground(Color.WHITE);
		menu5.setForeground(Color.WHITE);
		frame1.setJMenuBar(menuBar);
		

		JButton addrow = new JButton("Add Row");
		//addrow.setBounds(100, 100, 70, 70);
		frame1.add(addrow);
		
		JButton save = new JButton("Save");
		//save.setBounds(100, 100, 70, 70);
		frame1.add(save);
		
		JButton back = new JButton("Back");
		//back.setBounds(300, 200, 70, 70);
		frame1.add(back);
		
		
		
		back.addActionListener
		(new ActionListener() 
			{
				@Override
				public void actionPerformed(ActionEvent e) 
				{
					
					MainLanding object = new MainLanding();
					object.createAndShowGUIMainLanding();
					frame1.setVisible(false);
				}
			}
		);  
		
		addrow.addActionListener
		(new ActionListener() 
			{
				@Override
				public void actionPerformed(ActionEvent e) 
				{
					
					  model.addRow(new String[col.length]);
				}
			}
		);  
		
		menuItem1.addActionListener
		(new ActionListener() 
			{
				@Override
				public void actionPerformed(ActionEvent e) 
				{
					frame1.setVisible(false);
					TestSuiteCreate object = new TestSuiteCreate();
					object.createAndShowGUITestSuiteCreate();
					
				}
			}
		);  
	}
}
