import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MainLanding extends JPanel 
{
	public void createAndShowGUIMainLanding() 
	{
		JMenuBar menuBar;
		JMenu menu = null;
		JMenuItem menuItem;
		final JFrame frame = new JFrame("Web2Go");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension d = new Dimension(400,400);
		frame.setPreferredSize(d);
		MainLanding newContentPane = new MainLanding();
		newContentPane.setOpaque(true);
		frame.setContentPane(newContentPane);

		//Display the window.
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setLayout(null);
    
		menuBar = new JMenuBar();
		menu = new JMenu("About");
		menuItem = new JMenuItem("About Product");
		menu.add(menuItem);
		menuBar.add(menu);
		menuBar.setBackground(Color.GRAY);
		menu.setForeground(Color.WHITE);
		frame.setJMenuBar(menuBar);
    
		JButton web = new JButton("Web Application");
		JButton desktop = new JButton("Desktop Application");
		JButton mobile = new JButton("Mobile Application");
		JButton ws = new JButton("Webservice");
		JButton security = new JButton("Security");
		JButton load = new JButton("Load");
		JButton exit = new JButton("Exit");

        //ImageIcon img = new ImageIcon("C:\\Users\\shobhit.gupta\\Desktop\\images.jpg");
        //web.setIcon(img);
		web.setBounds(30, 40, 150, 30);
		desktop.setBounds(210, 40, 150, 30);
		mobile.setBounds(30, 100, 150, 30);
		ws.setBounds(210, 100, 150, 30);
		security.setBounds(30, 160, 150, 30);
		load.setBounds(210, 160, 150, 30);
		exit.setBounds(280, 300, 100, 30);
		
		frame.add(web);
		frame.add(desktop);
		frame.add(mobile);
		frame.add(ws);
		frame.add(security);
		frame.add(load);
		frame.add(exit);
		
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
    
    
		web.addActionListener
		(new ActionListener() 
			{
				@Override
				public void actionPerformed(ActionEvent e) 
				{
					frame.setVisible(false);
					WebAppTest object = new WebAppTest();
					object.createAndShowGUIWebAppTest();
				}
			}
		);      
		
		exit.addActionListener
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
}
