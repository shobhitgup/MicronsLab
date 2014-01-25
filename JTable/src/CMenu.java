import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

/**
 *
 * @author korbel
 */
public class CMenu extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTabbedPane tabbedPane;

    public CMenu() {
    	
        tabbedPane = new JTabbedPane();
        tabbedPane.setPreferredSize(new Dimension(300, 200));
        getContentPane().add(tabbedPane);
        JPanel panel = new JPanel();
        tabbedPane.add(panel, "null");
        JTextField one = new JTextField("one");
        tabbedPane.add(one, "one");
        JTextField two = new JTextField("two");
        tabbedPane.add(two, "<html> T<br>i<br>t<br>t<br>l<br>e <br> 1 </html>");
        tabbedPane.setEnabledAt(2, false);
        tabbedPane.setTitleAt(2, "<html><font color="
                + (tabbedPane.isEnabledAt(2) ? "black" : "red") + ">"
                + tabbedPane.getTitleAt(2) + "</font></html>");
        tabbedPane.setTabPlacement(JTabbedPane.LEFT);
    }

    public static void main(String args[]) {
        CMenu frame = new CMenu();
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}