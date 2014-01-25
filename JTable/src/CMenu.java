import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class CMenu extends JFrame 
{
	public class VerticalTextIcon implements Icon, SwingConstants{ 
	    private Font font = UIManager.getFont("Label.font"); 
	    private FontMetrics fm = Toolkit.getDefaultToolkit().getFontMetrics(font); 
	 
	    private String text; 
	    private int width, height; 
	    private boolean clockwize; 
	 
	    public VerticalTextIcon(String text, boolean clockwize){ 
	        this.text = text; 
	        width = SwingUtilities.computeStringWidth(fm, text); 
	        height = fm.getHeight(); 
	        this.clockwize = clockwize; 
	    } 
	 
	    public void paintIcon(Component c, Graphics g, int x, int y){ 
	        Graphics2D g2 = (Graphics2D)g; 
	        Font oldFont = g.getFont(); 
	        Color oldColor = g.getColor(); 
	        AffineTransform oldTransform = g2.getTransform(); 
	 
	        g.setFont(font); 
	        g.setColor(Color.black); 
	        if(clockwize){ 
	            g2.translate(x+getIconWidth(), y); 
	            g2.rotate(Math.PI/2); 
	        }else{ 
	            g2.translate(x, y+getIconHeight()); 
	            g2.rotate(-Math.PI/2); 
	        } 
	        g.drawString(text, 0, fm.getLeading()+fm.getAscent()); 
	 
	        g.setFont(oldFont); 
	        g.setColor(oldColor); 
	        g2.setTransform(oldTransform); 
	    } 
	 
	    public int getIconWidth(){ 
	        return height; 
	    } 
	 
	    public int getIconHeight(){ 
	        return width; 
	    } 
	    
	    public void addTab(JTabbedPane tabPane, String text, Component comp){ 
	        int tabPlacement = tabPane.getTabPlacement(); 
	        switch(tabPlacement){ 
	            case JTabbedPane.LEFT: 
	            case JTabbedPane.RIGHT: 
	                tabPane.addTab(null, new VerticalTextIcon(text, tabPlacement==JTabbedPane.RIGHT), comp); 
	                return; 
	            default: 
	                tabPane.addTab(text, null, comp); 
	        } 
	    } 
	    
	    public JTabbedPane createTabbedPane(int tabPlacement){ 
	        switch(tabPlacement){ 
	            case JTabbedPane.LEFT: 
	            case JTabbedPane.RIGHT: 
	                Object textIconGap = UIManager.get("TabbedPane.textIconGap"); 
	                Insets tabInsets = UIManager.getInsets("TabbedPane.tabInsets"); 
	                UIManager.put("TabbedPane.textIconGap", new Integer(1)); 
	                UIManager.put("TabbedPane.tabInsets", new Insets(tabInsets.left, tabInsets.top, tabInsets.right, tabInsets.bottom)); 
	                JTabbedPane tabPane = new JTabbedPane(tabPlacement); 
	                UIManager.put("TabbedPane.textIconGap", textIconGap); 
	                UIManager.put("TabbedPane.tabInsets", tabInsets); 
	                return tabPane; 
	            default: 
	                return new JTabbedPane(tabPlacement); 
	        } 
	    } 
	}
	
	public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	CMenu obj1 = new CMenu();
            	
            	
            	
            }
        });
    }
	
	
}