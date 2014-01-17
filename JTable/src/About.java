import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class About extends JPanel 
{
	public void createAndShowGUIAbout() 
	{
		JFrame frame1 = new JFrame("About Product");
        //frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		About newContentPane = new About();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame1.setContentPane(newContentPane);
        Dimension d = new Dimension(300,300);
        frame1.setPreferredSize(d);
        frame1.pack();
        frame1.setLocationRelativeTo(null);
        frame1.setVisible(true);
        frame1.setResizable(false);
        JLabel jlabel = new JLabel("Beta version : Test Release");
        JLabel jlabel1 = new JLabel("Made By : Shobhit, Gulshan");       
        jlabel.setFont(new Font("Verdana",1,10));
        jlabel1.setFont(new Font("Verdana",1,10));
        frame1.add(jlabel);
        frame1.add(jlabel1);
        //JTextArea textArea;
        //JScrollPane jScrollPane1;
        //textArea = new JTextArea("Text already in JTextArea", 20, 20);
        //setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //textArea.setColumns(20);
        //textArea.setLineWrap(true);
        //textArea.setRows(5);
        //textArea.setWrapStyleWord(true);
        //textArea.isEditable();
        //jScrollPane1 = new JScrollPane(textArea);
        //frame1.add(jScrollPane1);
	}
}
