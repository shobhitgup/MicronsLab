import java.awt.Dimension;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import java.awt.GridLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTree;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.Position;
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
	TreePath leadPath;
	TreePath oldPath;
	TreePath currPath;
	JTree tree;
	DefaultTreeModel model;
	int height;
	JFrame fr;
	JScrollPane scrollPane;
	int i =0;
	String ObjProparray[][] = new String[20][3];
	//String data[][] = new String[20][4];
	JComboBox comboBox;
	int j2 =0;
	public static void main(String[] args) {
		new CMenu();
	}

	public CMenu() {
		fr = new JFrame("Test");
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
		
		DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode("Object Repository");
		final DefaultTreeModel treeModel = new DefaultTreeModel(rootNode);
		
		tree = new JTree(treeModel);
		tree.getSelectionModel().setSelectionMode
		        (TreeSelectionModel.SINGLE_TREE_SELECTION);
		tree.setShowsRootHandles(true);
		tree.setEditable(true);
		leftComponent.add(new JScrollPane(tree), "cell 0 2 2 1,grow");
		
		/*tree.addTreeSelectionListener(new TreeSelectionListener(){
		    public void valueChanged(TreeSelectionEvent e){ 
		    	 leadPath = e.getNewLeadSelectionPath();
		    	 oldPath = e.getOldLeadSelectionPath();
		    }
		});*/
			    
		tree.addMouseListener(new MouseAdapter()  {
            @Override
            public void mouseClicked(MouseEvent e) {
                	final DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
                	try {

         			   if(!selectedNode.isRoot() && selectedNode.isLeaf()){
         				   if (e.getClickCount() == 2){
         					  tree.addTreeSelectionListener(new TreeSelectionListener(){
         						    public void valueChanged(TreeSelectionEvent e){ 
         						    	 leadPath = e.getNewLeadSelectionPath();
         						    	 oldPath = e.getOldLeadSelectionPath();
         						    }
         						});
         					  
         					  System.out.println(leadPath);
         					  System.out.println(oldPath);
         					  DefaultTableModel model;
         					  String[] columnNames = {"ObjectName","Identifier1","Identifier2","Identifier3", "Identifier4", "Identifier5","Identifier6","Identifier7"};
         				 	
         				 	int j = ObjProparray.length;
         				 	String data[][] = new String[20][4];
         				 	for(int l = 0; l < j; l++)
         				 	{
         				 		if (ObjProparray[l][2].toString().equals(selectedNode.toString())){
         				 			data [0][0] = (ObjProparray[l][0]);
         				 			data [0][1] = (ObjProparray[l][1]);
/*         				 			data [l+1][0] = (ObjProparray[l+1][0]);
         				 			data [l+1][1] = (ObjProparray[l+1][1]);
*/         				 			break;
         				 		}
         				 	}
         				 	
         				 	model = new DefaultTableModel(data, columnNames);
         				 	table = new JTable(model);
         				 	table.setPreferredScrollableViewportSize(new Dimension(500, 70));
         				 	table.setFillsViewportHeight(true);
         				 	scrollPane = new JScrollPane(table);
         				 	rightComponent.add(scrollPane ,"cell 0 0,grow");
         				  	rightComponent.setVisible(true);
         			        rightComponent.revalidate();
         			        rightComponent.repaint();
         			        
         			       table.getModel().addTableModelListener(new TableModelListener() {

         				      public void tableChanged(TableModelEvent e) {
         				    	 int row = table.getSelectedRow();
         				    	 int col = table.getSelectedColumn();

         				        int j = ObjProparray.length;
         				       
             				 	for(int l = 0; l < j; l++)
             				 	{ /*if (row > 0){
             				 		if (ObjProparray[l][2].toString().equals(selectedNode.toString())){
             				 			if (col == 0){ObjProparray[l+1][0] = table.getValueAt(row, col).toString();
             				 			System.out.println(ObjProparray[l+1][0]);
             				 			System.out.println(ObjProparray[l][0]);}
             				 			else
             				 			{ObjProparray[l+1][1] = table.getValueAt(row, col).toString();
             				 			System.out.println(ObjProparray[l+1][1]);
             				 			System.out.println(ObjProparray[l][1]);}
             				 			break;
             				 		}
             				 	} else*/
             				 	{
             				 		if (ObjProparray[l][2].toString().equals(selectedNode.toString())){
             				 			if (col == 0){ObjProparray[l][0] = table.getValueAt(row, col).toString();}
             				 			else
             				 			{ObjProparray[l][1] = table.getValueAt(row, col).toString();}
             				 			break;
             				 	}
         				      }
         				      }}
         				    });
         				
         			        
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
         				  
         				  }}else
         				  {
         	        			rightComponent.removeAll();
         	        			rightComponent.revalidate();
         	        			rightComponent.repaint();
         				  }
         			   } catch (NullPointerException f)
         			   {} 
            }
        });
		
		tree.addMouseListener(new MouseAdapter()  {
            @Override
            public void mouseClicked(MouseEvent e) {
            	if (e.getClickCount() == 1){
            	rightComponent.removeAll();
     			rightComponent.revalidate();
     			rightComponent.repaint();}
            }
        });
			
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
				leftComponent, rightComponent);
		ImageIcon water = new ImageIcon("../JTable/lib/download.jpg");
	    JButton addButton = new JButton(water);
	    
	    addButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
				final DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent(); 
				if (node == null) {
				      JOptionPane.showMessageDialog(tree, "Select a parent.", "Error",
				          JOptionPane.ERROR_MESSAGE);
				      return;}
//                    JPopupMenu popup = new JPopupMenu();
//                    JMenuItem addObj = new JMenuItem("Add Object");
//                    popup.add(addObj);
//                    popup.show(e.getComponent(), e.getX(), e.getY());
//                    
//                    addObj.addActionListener(new ActionListener() {
//                    	@Override
//            			public void actionPerformed(ActionEvent f)  {
                    		final JFrame f1 = new JFrame();
                    		f1.getContentPane().setLayout(new MigLayout());
                    		//fr.setVisible(false);
                    		JLabel ObjName = new JLabel("Object Name");
                    		JLabel ObjProp = new JLabel("Object Property"); 
                    		final JTextField ObjNameText = new JTextField(); 
                    		final JTextField ObjPropText = new JTextField(); 
                    		JButton add = new JButton("Add Property");
                    		f1.getContentPane().add(ObjName,"Pos 10 10 0 0,width 70!, height 20!");
                    		f1.getContentPane().add(ObjNameText,"Pos 100 10 0 0,width 70!, height 20!");
                    		f1.getContentPane().add(ObjProp,"Pos 10 40 0 0,width 100!, height 20!");
                    		f1.getContentPane().add(ObjPropText,"Pos 100 40 0 0,width 70!, height 20!");
                    		f1.getContentPane().add(add,"Pos 100 80 0 0,width 100!, height 20!");
                    		
                    		add.addActionListener
                        	(new ActionListener() 
                        		{
                        			@Override
                        			public void actionPerformed(ActionEvent e) 
                        			{
                        				treeModel.insertNodeInto(new DefaultMutableTreeNode(ObjNameText.getText().toString()), node, node.getChildCount());
                        				
                        				for (int i = 0; i < tree.getRowCount(); i++) {
                        				    tree.expandRow(i);
                        				}
                        				
                        				TreePath path = tree.getNextMatch(ObjNameText.getText().toString(), 0, Position.Bias.Forward);                        				
                        				tree.scrollPathToVisible(path);
                        				tree.setSelectionPath(path);
                        				tree.setExpandsSelectedPaths(true);
                        				tree.expandPath(path);
                        				final DefaultMutableTreeNode node1 = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent(); 
                        				ObjProparray[i][0] = ObjNameText.getText().toString();
                        				ObjProparray[i][1] = ObjPropText.getText().toString();
                        				ObjProparray[i][2] = node1.toString();
                        				i++;
                        				
                     			        rightComponent.revalidate();
                     			        rightComponent.repaint();
                     			        comboBox.addItem(ObjNameText.getText().toString() + "- " + ObjPropText.getText().toString());
                     			        comboBox.setSelectedIndex(-1);
                     			        f1.dispose();
                     			        
/*                     			       TreeCellRenderer cr = tree.getCellRenderer();
                     			      if (cr instanceof DefaultTreeCellRenderer) {
                     			    	  if (node1.isLeaf()){
                     			        DefaultTreeCellRenderer dtcr =
                     			                     (DefaultTreeCellRenderer)cr; 

                     			        // Set the various colors
                     			        //dtcr.setIcon(icon);
                     			        dtcr.setBackgroundSelectionColor(Color.black);
                     			        //dtcr.getIcon(node);
                     			        //dtcr.setTextSelectionColor(Color.white); 
                     			        //dtcr.setTextNonSelectionColor(Color.green); 

                     			        // Finally, set the tree's background color 
                     			        //node1.setBackground(Color.black); 
                     			      } }*/
                        		}}
                        	); 
                    		
                    		f1.setSize(new Dimension(400, 400));
                    		f1.setVisible(true);
//                        }
//                        });

                    
                    //addObj.addActionListener
                	//(new ActionListener() 
                		//{
            				//@Override
                			//public void actionPerformed(ActionEvent e) 
                			//{
                				//treeModel.insertNodeInto(new DefaultMutableTreeNode("New"), node, node.getChildCount());
                			//}
                		//}
                	//); 
                    
                
            }});
	    
	    //addButton.addActionListener(new ActionListener() {
	    	//public void actionPerformed(ActionEvent e) {
				//final DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
			    //if (node == null) {
			      //JOptionPane.showMessageDialog(tree, "Select a parent.", "Error",
			          //JOptionPane.ERROR_MESSAGE);
			      //return;
			    //}
			    
			    //JPopupMenu popup = new JPopupMenu();
                //JMenuItem mntmCopyRow2 = new JMenuItem("Delete Row");
                //popup.add(mntmCopyRow2);
                //popup.setVisible(true);
                //mntmCopyRow2.addActionListener
            	//(new ActionListener() 
            		//{
            			//@SuppressWarnings("static-access")
        				//@Override
            			//public void actionPerformed(ActionEvent e) 
            			//{
            				//treeModel.insertNodeInto(new DefaultMutableTreeNode("New"), node, node.getChildCount());
            			//}
            		//}
            	//); 
			    
	    	//}});
	    		
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
	    	    	i--;
	    	    	 comboBox.removeItem(selectedNode.toString());
	    	}});
	    
		comboBox = new JComboBox();
		comboBox.setEditable(true);
		leftComponent.add(comboBox, "cell 0 1,growx");
		
		delButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
			rightComponent.removeAll();
			rightComponent.revalidate();
			rightComponent.repaint();
            }});

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