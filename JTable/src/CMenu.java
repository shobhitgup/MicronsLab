import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPopupMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.JMenuItem;
import com.example.CompositeIcon;
import com.example.VTextIcon;

public class CMenu implements SwingConstants {
	private JTable table;
	JTree tree;
	DefaultTreeModel model;
	int height;
	JScrollPane scrollPane;
	public static void main(String[] args) {
		new CMenu();
	}

	public CMenu() {
		JFrame fr = new JFrame("Test");
		fr.getContentPane().add(testComponent());
		fr.setSize(new Dimension(600, 400));
		fr.setVisible(true);
	}

	JComponent testComponent() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0,1));
		JTabbedPane tp = new JTabbedPane(LEFT);
		Icon graphicIcon = UIManager.getIcon("FileView.computerIcon");
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		VTextIcon textIcon = new VTextIcon(panel, "Object Repository",  VTextIcon.ROTATE_LEFT);
		CompositeIcon icon = new CompositeIcon(graphicIcon, textIcon);

		JPanel leftComponent = new JPanel(new MigLayout("", "[grow][][][]", "[][][grow]"));
		final JPanel rightComponent = new JPanel(new MigLayout("", "[grow]", "[grow]"));
		//final JPanel rightComponent = new JPanel(new CardLayout());

		DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode("Object Repository");
		final DefaultTreeModel treeModel = new DefaultTreeModel(rootNode);
		
		tree = new JTree(treeModel);
		tree.getSelectionModel().setSelectionMode
		        (TreeSelectionModel.SINGLE_TREE_SELECTION);
		tree.setShowsRootHandles(true);
		tree.setEditable(true);
		leftComponent.add(new JScrollPane(tree), "cell 0 2 2 1,grow");
		
	
		tree.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                	final DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
                	try {
         			   if(!selectedNode.isRoot() && selectedNode.isLeaf()){
         				  if (e.getClickCount() == 2){
         					 
         					 DefaultTableModel model ;
                   			String[] columnNames = {"ObjectName","Identifier1","Identifier2","Identifier3", "Identifier4", "Identifier5","Identifier6","Identifier7"};
                   			Object[][] data = {{"ObjectName","1"}, {"ObjectName","2"}, {"ObjectName","3"}};
                   			
                   	        model = new DefaultTableModel(data, columnNames);
                   	        table = new JTable(model);
                   	        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
                   	        table.setFillsViewportHeight(true);
                   	        scrollPane = new JScrollPane(table);
                   	        rightComponent.add(scrollPane ,"cell 0 0,grow");
                   	        rightComponent.revalidate();
                   	        
                   	        table.addMouseListener(new MouseAdapter() {
                               @Override
                               public void mouseReleased(MouseEvent e) {
                                   int r = table.rowAtPoint(e.getPoint());
                                   if (r >= 0 && r < table.getRowCount()) {
                                       table.setRowSelectionInterval(r, r);
                                   } else {
                                       table.clearSelection();
                                   }

                                   int rowindex = table.getSelectedRow();
                                   if (rowindex < 0)
                                       return;
                                   if (e.isPopupTrigger() && e.getComponent() instanceof JTable ) {
                                       JPopupMenu popup = new JPopupMenu();
                                       JMenuItem mntmCopyRow = new JMenuItem("Copy Row");
                                       JMenuItem mntmCopyRow1 = new JMenuItem("Delete Row");
                                       popup.add(mntmCopyRow);
                                       popup.add(mntmCopyRow1);
                                       popup.show(e.getComponent(), e.getX(), e.getY());
                                   }
                               }});
         				  } 
         				  }else
         				  {
         	        			scrollPane.setVisible(false);
         	        			rightComponent.remove(scrollPane);
         	        			rightComponent.revalidate();
         				  }
         			   } catch (NullPointerException f)
         			   {}
                
            }
        });
		
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
				leftComponent, rightComponent);
		ImageIcon water = new ImageIcon("../JTable/lib/download.jpg");
	    JButton addButton = new JButton(water);
	    addButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
				DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
			    if (node == null) {
			      JOptionPane.showMessageDialog(tree, "Select a parent.", "Error",
			          JOptionPane.ERROR_MESSAGE);
			      return;
			    }
			    treeModel.insertNodeInto(new DefaultMutableTreeNode("New"), node, node.getChildCount());
	    	}});
	    		
		leftComponent.add(addButton, "flowx,cell 0 0, width 60!");
		addButton.setBorderPainted(false);
		
		ImageIcon water1 = new ImageIcon("../JTable/lib/delete.jpg");
	    JButton delButton = new JButton(water1);
		leftComponent.add(delButton, "cell 0 0, width 60!");
		delButton.setBorderPainted(false);
		
		delButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
	    	    if (selectedNode != null)
	    	      treeModel.removeNodeFromParent(selectedNode);
	    	}});
	    
		JComboBox comboBox = new JComboBox();
		comboBox.setEditable(true);
		leftComponent.add(comboBox, "cell 0 1,growx");

		/* http://stackoverflow.com/questions/3558293/java-swing-jtable-right-click-menu-how-do-i-get-it-to-select-aka-highlight-t */
        
		tp.addTab(null, icon, splitPane);
		VTextIcon textIcon2 = new VTextIcon(panel, "Requirements",  VTextIcon.ROTATE_LEFT);
		CompositeIcon icon2 = new CompositeIcon(graphicIcon, textIcon2);
		JPanel p1 = new JPanel();
		p1.setOpaque(false);
		tp.addTab(null, icon2, p1);
		panel.add(tp);
		return panel;
	}
}