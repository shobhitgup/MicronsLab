import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
 
public class MainLanding {
    final static boolean shouldFill = true;
    final static boolean shouldWeightX = true;
    final static boolean RIGHT_TO_LEFT = false;
     static JFrame frame;
 
    public static void addComponentsToPane(Container pane) {
        if (RIGHT_TO_LEFT) {
            pane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        }
 
    pane.setLayout(new GridBagLayout());
    GridBagConstraints c = new GridBagConstraints();
    
    c.ipadx = 0;
    c.weighty = 0;
    c.weightx = 0;
    c.ipadx=0;
    c.gridx = 0;
    c.gridy = 0;
    
    if (shouldFill) {
    //natural height, maximum width
    c.fill = GridBagConstraints.HORIZONTAL;
    }
 
    JButton button = new JButton("Web Application");
    c.fill = GridBagConstraints.VERTICAL;
    c.ipadx = 40;
    c.weighty = 0;
    c.weightx = 0.5;
    c.ipadx=120;
    c.gridx = 1;
    c.gridy = 1;
    c.insets = new Insets(50,10,10,10);  //top padding
    pane.add(button, c);
 
    JButton button1 = new JButton("Desktop Application");
    c.fill = GridBagConstraints.VERTICAL;
    c.ipadx = 40;
    c.weighty = 0;
    c.ipadx=120;
    c.weightx = 0.5;
    c.gridx = 3;
    c.gridy = 1;
    c.insets = new Insets(50,10,10,10);  //top padding
    pane.add(button1, c);
    
    JButton button2 = new JButton("Mobile Application");
    c.fill = GridBagConstraints.VERTICAL;
    c.ipadx = 40;
    c.weighty = 0;
    c.weightx = 0.5;
    c.ipadx=120;
    c.gridx = 1;
    c.gridy = 2;
    c.insets = new Insets(10,10,10,10);  //top padding
    pane.add(button2, c);
    
    JButton button3 = new JButton("Webservice");
    c.fill = GridBagConstraints.VERTICAL;
    c.weighty = 0;
    c.weightx = 0.5;
    c.gridx = 3;
    c.ipadx=120;
    c.gridy = 2;
    c.insets = new Insets(10,10,10,10);  //top padding
    pane.add(button3, c);
    
    JButton button4 = new JButton("Security");
    c.fill = GridBagConstraints.VERTICAL;
    c.weighty = 0;
    c.ipadx=120;
    c.weightx = 0.5;
    c.gridx = 1;
    c.gridy = 3;
    c.insets = new Insets(10,10,10,10);  //top padding
    pane.add(button4, c);
    
    JButton button5 = new JButton("Load");
    c.fill = GridBagConstraints.VERTICAL;
    c.weighty = 0;
    c.ipadx=120;
    c.weightx = 0.5;
    c.gridwidth = 10;
    c.gridx = 3;
    c.gridy = 3;
    c.insets = new Insets(10,10,10,10);  //top padding
    pane.add(button5, c);
 
    JButton button6 = new JButton("Exit");
    c.fill = GridBagConstraints.HORIZONTAL;
    c.ipady = 0;       //reset to default
    c.weighty = 1.0;   //request any extra vertical space
    c.anchor = GridBagConstraints.PAGE_END; //bottom of space
    c.insets = new Insets(10,10,10,10);  //top padding
    c.gridx = 3;       //aligned with button 2
    c.gridwidth = 2;   //2 columns wide
    c.gridy = 5;       //third row
    pane.add(button6, c);
    
	button.addActionListener
	(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				frame.dispose();
				frame.setVisible(false);

				
				WebAppTest object = new WebAppTest();
				object.createAndShowGUIWebAppTest();
			}
		}
	);      
	
	button6.addActionListener
	(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				System.exit(0);			
			}
		}
	); 
    }
 
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    static void createAndShowGUIMainLanding() {
        //Create and set up the window.
    	frame = new JFrame("Web2Go");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension d = new Dimension(400,400);
		frame.setPreferredSize(d);
        //Set up the content pane.
        addComponentsToPane(frame.getContentPane());
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("About");
		JMenuItem menuItem = new JMenuItem("About Product");
		menu.add(menuItem);
		menuBar.add(menu);
		menuBar.setBackground(Color.GRAY);
		menu.setForeground(Color.WHITE);
		frame.setJMenuBar(menuBar);
		
	    menuItem.addActionListener
		(new ActionListener() 
			{
				@Override
				public void actionPerformed(ActionEvent e) 
				{
					About object = new About();
					object.createAndShowGUIAbout();
				}
			}
		); 
 
        //Display the window.
	    frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		
    }
 
    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {

            	createAndShowGUIMainLanding();
            }
        });
    }
}