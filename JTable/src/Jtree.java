import java.awt.Color;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.Position;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;
import net.miginfocom.swing.MigLayout;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Set;
import java.util.Vector;

public class Jtree   {
	String result = "Test Case";
	JTree tree;
	DefaultTreeModel model;
	DefaultTreeModel treeModel;
	JPanel Tree;
	JTable table;
	JTable table1;
	JScrollPane scrollPane;
	String ObjProparray[][] = new String[200][9];
	StringBuffer sbTableData;
	FileWriter fileWriter = null;
	FileWriter fileWriter1 = null;
	BufferedReader reader;
	int numRows = 1 ;
	JMenuItem mntmCopyRow;
	JMenuItem mntmDelRow;
	DefaultTableModel model1;
	DefaultTableModel model2;
	String data1[]= new String[100];
	String data2[][]= new String[100][9];
	JFrame MainFrame;
	JTextField ObjNameText;

	public static void main(String[] args) {
		new Jtree();
	}

	@SuppressWarnings("static-access")
	public Jtree() {
		MainFrame = new JFrame("Web App Test");
		GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
		MainFrame.setMaximizedBounds(env.getMaximumWindowBounds());
		MainFrame.setExtendedState(MainFrame.getExtendedState() | MainFrame.MAXIMIZED_BOTH);
		MainFrame.getContentPane().add(testComponent());
		MainFrame.setVisible(true);
	}

	JComponent testComponent() {
		final JPanel leftComponent = new JPanel(new MigLayout("insets 0 0 0 0",
                "[fill, grow]",
                "0[]0"));
		final JPanel rightComponent = new JPanel(new MigLayout("insets 0 0 0 0",
                "[fill, grow]",
                "0[]0"));
		JLabel Head = new JLabel("Project Explorer");
		Head.setBorder(BorderFactory.createLineBorder(Color.black));
		leftComponent.add(Head, "wrap, height 30");
		
		final JPanel leftComponent1 = new JPanel(new MigLayout("insets 0 0 0 0",
                "[fill, grow]",
                "[fill, grow]0[]0"));
		
		final JLabel HeadOR = new JLabel(result.toString());
		HeadOR.setBorder(BorderFactory.createLineBorder(Color.black));
		leftComponent1.add(HeadOR,"wrap, height 30");
		
		Tree = new JPanel();
		Tree.setBackground(Color.WHITE);
		leftComponent1.add(Tree,"wrap, height 370");
		
		final JButton TC = new JButton("Test Cases");
		final JButton OR = new JButton("Page Object Repository");
		final JButton DR = new JButton("Data Repository");
		final JButton FL = new JButton("Funcional Library");
		final JButton Suite = new JButton("Suite");
		final JButton ER = new JButton("Execution Result");
		leftComponent1.add(TC,"wrap, height 45");
		leftComponent1.add(OR,"wrap, height 45");
		leftComponent1.add(DR,"wrap, height 45");
		leftComponent1.add(FL, "wrap, height 45");
		leftComponent1.add(Suite, "wrap, height 45");
		leftComponent1.add(ER, "height 45");
 
		final JScrollPane scroll = new JScrollPane();
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroll.getViewport().add(leftComponent1); 
		
		leftComponent.add(scroll,"growy, span, wrap");
		final String[] columnNames = {"Page Name","Object Name","Identifier1","Identifier2","Identifier3", "Identifier4", "Identifier5","Identifier6","Identifier7"};
		OR.addActionListener 
    	(new ActionListener()  
    	{
    		@Override
			public void actionPerformed(ActionEvent e) {
    			Tree.removeAll(); 
    			rightComponent.removeAll();
		        rightComponent.revalidate();
		        rightComponent.repaint();
		        
    			result = "Page Object Repository";
    			HeadOR.setText(result);
    			
		        DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode("Page Object Repository");
    			final DefaultTreeModel treeModel = new DefaultTreeModel(rootNode);
    			tree = new JTree(treeModel);
    			tree.setShowsRootHandles(true);
    			tree.getSelectionModel().setSelectionMode
		        (TreeSelectionModel.SINGLE_TREE_SELECTION);
    			Tree.add(tree);
    			leftComponent1.revalidate();
    			leftComponent1.repaint();
    			
    			model1 = new DefaultTableModel(columnNames,0) ;
		        FileInputStream fis = null;
				try {
					fis = new FileInputStream("..\\JTable\\Resources\\data.txt");
				} catch (FileNotFoundException e3) {
					e3.printStackTrace();
				}
		        BufferedReader br1 = new BufferedReader(new InputStreamReader(fis));
		        String line;
		    try {
				while ((line = br1.readLine()) != null) 
				      {String[] data = line.split("-");
				      model1.addRow(data); 
				 }
			} catch (IOException e3) {
				e3.printStackTrace();
			}
		    try {
				br1.close();
			} catch (IOException e3) {
				e3.printStackTrace();
			}
		    
		    table = new JTable(model1);                             
		    table.setPreferredScrollableViewportSize(new Dimension(500, 700));
		 	table.setFillsViewportHeight(true);
		 	table.setEnabled(true);
		 	table.setGridColor(Color.BLACK);
		 	table.setAutoCreateRowSorter(true);
		 	
		 	scrollPane = new JScrollPane(table);
		 	rightComponent.add(scrollPane);
	        rightComponent.revalidate();
	        rightComponent.repaint();
	        
	        int rows = table.getRowCount();
	        DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getModel().getRoot();
		      
	        for (int i = 0 ; i < rows ; i++)
	        {
	        	try{
	        	data1[i] = table.getValueAt(i, 0).toString();
	        	if(!data1[i].equals("")){
	        	treeModel.insertNodeInto(new DefaultMutableTreeNode(data1[i]), node, node.getChildCount());}
	        	}
	        		catch(NullPointerException f){
        		}
	        }
	        
	        final Hashtable<String,ArrayList<String>> hash = new Hashtable<String,ArrayList<String>>();
	        String key=null;
	        String value = null;
	        ArrayList<String> list = null;
	        for (int i2 = 0 ; i2 < table.getRowCount() ; i2++)
	        {		
	        	try{
	        		if (!table.getValueAt(i2, 1).equals("") && !table.getValueAt(i2, 0).equals("")){
	        	list = new ArrayList<String>();
	        	value = table.getValueAt(i2, 1).toString();
	        	key = table.getValueAt(i2, 0).toString();
	        	list =  hash.get(key);
	        	if(list != null){
	        		list.add(value);
	        	}else{
	        		list = new ArrayList<String>();
	        		list.add(value);
	        		hash.put(key, list);
	        	}}} catch(NullPointerException f){}
	        }
	        
	        Set<String> abc = hash.keySet();
	        Hashtable<String, Object[]> hashArray = new Hashtable<String, Object[]>();
	        for (String str: abc){
	        	ArrayList<String> list1 = hash.get(str);
	        	hashArray.put(str, list1.toArray());
	        }
	        
	        Tree.removeAll(); 
	        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Page Object Repository");
	        JTree.DynamicUtilTreeNode.createChildren(root, hashArray);
	        tree = new JTree(root);
	        tree.setVisible(true);
	        tree.setEditable(false);
	        Tree.add(tree);
			leftComponent1.revalidate();
			leftComponent1.repaint();
			
			tree.addMouseListener(new MouseListener() {
                 @Override
                 public void mouseReleased(MouseEvent e) {
                 }

				@Override
				public void mouseClicked(MouseEvent e) {
					if (e.getClickCount() == 2){
						
							final DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
							if (selectedNode.isLeaf()){
								String parent = selectedNode.getParent().toString();
								for (int row = 0; row < table.getRowCount() ; row++){
									try{
									if(table.getValueAt(row, 0).toString().equals(parent.toString()) && table.getValueAt(row, 1).toString().equals(selectedNode.toString())){
										table.setRowSelectionInterval(row, row);
										table.scrollRectToVisible(table.getCellRect(row, 0, true));
										break;
									}} catch(NullPointerException f){}
								}
							} 
				}}

				@Override
				public void mousePressed(MouseEvent e) {
				}

				@Override
				public void mouseEntered(MouseEvent e) {
				}

				@Override
				public void mouseExited(MouseEvent e) {
				}});
			
			        table.addMouseListener(new MouseListener() {
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
                                mntmCopyRow = new JMenuItem("Add Row");
                                popup.add(mntmCopyRow);
                                mntmDelRow = new JMenuItem("Delete Row");
                                popup.add(mntmDelRow);
                                popup.show(e.getComponent(), e.getX(), e.getY());
                            }
                            
                            try{
                            mntmCopyRow.addActionListener
	                          (new ActionListener() 
	                     		{
	                     			public void actionPerformed(ActionEvent e) 
	                     			{
	                     				DefaultTableModel model = (DefaultTableModel) table.getModel();
	                     				model.addRow(new String[columnNames.length]);
	                     				table.revalidate();
	                     				table.repaint();
	                     				OR.doClick();
	                     			}
	                     		}
	                     	);  }
                            catch(NullPointerException f){
                        }
                            
                            try{
                                mntmDelRow.addActionListener
    	                          (new ActionListener() 
    	                     		{
    	                     			public void actionPerformed(ActionEvent e) 
    	                     			{
    	                     				DefaultTableModel model = (DefaultTableModel) table.getModel();
    	                     				if(table.getRowCount() == 1){
    	                     					for (int i = 0; i < table.getRowCount(); i++) {
	    	                     				        for (int j = 0; j < table.getColumnCount(); j++) {
	    	                     				            table.setValueAt("", i, j);
	    	                     				            table.revalidate();
	    	                     				            table.repaint();
	    	                     				        }
	    	                     				    }
    	                     					return;
    	                     				} else
    	                     				{
    	                     				int[] rows = table.getSelectedRows();
    	                     				for(int i=0;i<rows.length;i++){
    	                     					model.removeRow(rows[i]);}
    	                     			}
    	                     				table.revalidate();
    	                     				table.repaint();
    	                     				OR.doClick();
    	                     				}
    	                     		}
    	                     	);  }
                                catch(NullPointerException f){
                            }
						}

						@Override
						public void mouseClicked(MouseEvent e1) {
						}

						@Override
						public void mousePressed(MouseEvent e) {
						}

						@Override
						public void mouseEntered(MouseEvent e) {
						}

						@Override
						public void mouseExited(MouseEvent e) {
						}
			        }); 
                            
                            table.getModel().addTableModelListener(new TableModelListener() {
             				      public void tableChanged(TableModelEvent e) {
             				    	 try {
 										fileWriter = new FileWriter(new File("..\\JTable\\Resources\\data.txt"), false);
 									} catch (IOException e2) {
 										e2.printStackTrace();
 									}
             				    	 
             				    	sbTableData = new StringBuffer();
             				    	for(int row1 = 0; row1 < table.getRowCount(); row1 ++){
             				    	    for(int column = 0; column < table.getColumnCount(); column ++){
             				    	    	if (table.getValueAt(row1, column) == null ){
             				    	    		sbTableData.append("").append("-");
             				    	    	}
             				    	    	else
             				    	        sbTableData.append(table.getValueAt(row1, column)).append("-");
             				    	    }
             				    	    sbTableData.append("\n");
             				    	}
									
             				    	try {
										fileWriter.write(sbTableData.toString());
									} catch (IOException e1) {
										e1.printStackTrace();
									}
             				    	try {
										fileWriter.flush();
									} catch (IOException e1) {
										e1.printStackTrace();
									}
             				    	try {
										fileWriter.close();
									} catch (IOException e1) {
										e1.printStackTrace();
									}
             				    	
             				    	final Hashtable<String,ArrayList<String>> hash1 = new Hashtable<String,ArrayList<String>>();
             				        String key1=null;
             				        String value1 = null;
             				        ArrayList<String> list2 = null;
             				        for (int i2 = 0 ; i2 < table.getRowCount() ; i2++)
             				        {		
             				        	try{
             				        		if (!table.getValueAt(i2, 1).equals("") && !table.getValueAt(i2, 0).equals("")){	
             				        	list2 = new ArrayList<String>();
             				        	value1 = table.getValueAt(i2, 1).toString();
             				        	key1 = table.getValueAt(i2, 0).toString();
             				        	list2 =  hash1.get(key1);
             				        	if(list2 != null){
             				        		list2.add(value1);
             				        	}else{
             				        		list2 = new ArrayList<String>();
             				        		list2.add(value1);
             				        		hash1.put(key1, list2);
             				        	}}}
             				        	catch(NullPointerException f){}
             				        }
             				        
             				        Set<String> abc1 = hash1.keySet();
             				        Hashtable<String, Object[]> hashArray1 = new Hashtable<String, Object[]>();
             				        for (String str1: abc1){
             				        	ArrayList<String> list3 = hash1.get(str1);
             				        	hashArray1.put(str1, list3.toArray());
             				        }
          				     
             				        Tree.removeAll(); 
             				        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Page Object Repository");
             				        JTree.DynamicUtilTreeNode.createChildren(root, hashArray1);
             				        tree = new JTree(root);
             				        tree.setVisible(true);
             				        tree.setEditable(false);
             				        Tree.add(tree);
             						leftComponent1.revalidate();
             						leftComponent1.repaint();
             						
             						tree.addMouseListener(new MouseListener() {
             			                 @Override
             			                 public void mouseReleased(MouseEvent e) {
             			                 }

             							@Override
             							public void mouseClicked(MouseEvent e) {
             								if (e.getClickCount() == 2){
             									
             										final DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
             										if (selectedNode.isLeaf()){
             											String parent = selectedNode.getParent().toString();
             											for (int row = 0; row < table.getRowCount() ; row++){
             												try{
             												if(table.getValueAt(row, 0).toString().equals(parent.toString()) && table.getValueAt(row, 1).toString().equals(selectedNode.toString())){
             													table.setRowSelectionInterval(row, row);
             													table.scrollRectToVisible(table.getCellRect(row, 0, true));
             													break;
             												}} catch(NullPointerException f){}
             											}
             										} 
             							}}

             							@Override
             							public void mousePressed(MouseEvent e) {
             							}

             							@Override
             							public void mouseEntered(MouseEvent e) {
             							}

             							@Override
             							public void mouseExited(MouseEvent e) {
             							}});
             						
             						table.addMouseListener(new MouseListener() {
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
             	                                mntmCopyRow = new JMenuItem("Add Row");
             	                                popup.add(mntmCopyRow);
             	                                mntmDelRow = new JMenuItem("Delete Row");
            	                                popup.add(mntmDelRow);
             	                                popup.show(e.getComponent(), e.getX(), e.getY());
             	                            }
             	                            
             	                            try{
             	                            mntmCopyRow.addActionListener
             		                          (new ActionListener() 
             		                     		{
             		                     			public void actionPerformed(ActionEvent e) 
             		                     			{
             		                     				DefaultTableModel model = (DefaultTableModel) table.getModel();
             		                     				model.addRow(new String[columnNames.length]);
             		                     				table.revalidate();
             		                     				table.repaint();
             		                     				OR.doClick();
             		                     			}
             		                     		}
             		                     	);  }
             	                            catch(NullPointerException f){
             	                        }

             	                           try{
             	                                mntmDelRow.addActionListener
             	    	                          (new ActionListener() 
             	    	                     		{
             	    	                     			public void actionPerformed(ActionEvent e) 
             	    	                     			{
             	    	                     				DefaultTableModel model = (DefaultTableModel) table.getModel();
             	    	                     				if(table.getRowCount() == 1){
             	    	                     					for (int i = 0; i < table.getRowCount(); i++) {
             	    	                     				        for (int j = 0; j < table.getColumnCount(); j++) {
             	    	                     				            table.setValueAt("", i, j);
             	    	                     				            table.revalidate();
             	    	                     				            table.repaint();
             	    	                     				        }
             	    	                     				    }
             	    	                     					
             	    	                     				} else
             	    	                     				{
             	    	                     				int[] rows = table.getSelectedRows();
             	    	                     				for(int i=0;i<rows.length;i++){
             	    	                     					model.removeRow(rows[i]);}
             	    	                     			}
             	    	                     				table.revalidate();
             	    	                     				table.repaint();
             	    	                     				OR.doClick();
             	    	                     				}
             	    	                     		}
             	    	                     	);  }
             	                                catch(NullPointerException f){
             	                            }
             							}

             							@Override
             							public void mouseClicked(MouseEvent e) {
             							}

             							@Override
             							public void mousePressed(MouseEvent e) {
             							}

             							@Override
             							public void mouseEntered(MouseEvent e) {
             							}

             							@Override
             							public void mouseExited(MouseEvent e) {
             							}}); 
             				      }});
                        }
						});
		
		TC.addActionListener 
    	(new ActionListener()  
    	{
    		@Override
			public void actionPerformed(ActionEvent e) {
    			Tree.removeAll(); 
    			rightComponent.removeAll();
		        rightComponent.revalidate();
		        rightComponent.repaint();
    			result = "Test Case";
    			HeadOR.setText(result);
    			DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode("Test Case");
    			final DefaultTreeModel treeModel = new DefaultTreeModel(rootNode);
    			tree = new JTree(treeModel);
    			Tree.add(tree);
    			leftComponent1.revalidate();
    			leftComponent1.repaint();
    		}});
		
		DR.addActionListener 
    	(new ActionListener()  
    	{
    		@Override
			public void actionPerformed(ActionEvent e) {
    			Tree.removeAll();
    			rightComponent.removeAll();
		        rightComponent.revalidate();
		        rightComponent.repaint();
    			result = "Data Repository";
    			HeadOR.setText(result);
    			DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode("DR");
    			final DefaultTreeModel treeModel = new DefaultTreeModel(rootNode);
    			tree = new JTree(treeModel);
    			Tree.add(tree);
    			leftComponent1.revalidate();
    			leftComponent1.repaint();
    		}});
		
		FL.addActionListener 
    	(new ActionListener()  
    	{
    		@Override
			public void actionPerformed(ActionEvent e) {
    			Tree.removeAll(); 
    			rightComponent.removeAll();
		        rightComponent.revalidate();
		        rightComponent.repaint();

    			result = "Funcional Library";
    			HeadOR.setText(result);
    			DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode("FL");
    			final DefaultTreeModel treeModel = new DefaultTreeModel(rootNode);
    			tree = new JTree(treeModel);
    			Tree.add(tree);
    			leftComponent1.revalidate();
    			leftComponent1.repaint();
    		}});
		
		Suite.addActionListener 
    	(new ActionListener()  
    	{
    		@Override
			public void actionPerformed(ActionEvent e) {
    			Tree.removeAll(); 
    			rightComponent.removeAll();
		        rightComponent.revalidate();
		        rightComponent.repaint();
    			result = "Suite";
    			HeadOR.setText(result);
    			DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode("Suite");
    			final DefaultTreeModel treeModel = new DefaultTreeModel(rootNode);
    			tree = new JTree(treeModel);
    			Tree.add(tree);
    			
    			FileInputStream fis1 = null;
				try {
					fis1 = new FileInputStream("..\\JTable\\Resources\\data1.txt");
				} catch (FileNotFoundException e3) {
					e3.printStackTrace();
				}
					BufferedReader br2 = new BufferedReader(new InputStreamReader(fis1));
					String line1;
				try {
				while ((line1 = br2.readLine()) != null) 
				      {
							DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getModel().getRoot();
							treeModel.insertNodeInto(new DefaultMutableTreeNode(line1.toString()), node, node.getChildCount());
				      }
					} 
				catch (IOException e3) 
				{
						e3.printStackTrace();
				}
				try {
					br2.close();
					} catch (IOException e3) 
					{
						e3.printStackTrace();
					}
    			
		    for (int i = 0; i < tree.getRowCount(); i++) {
			    tree.expandRow(i);
			}
    			leftComponent1.revalidate();
    			leftComponent1.repaint();
    			
    			final JPopupMenu popup;
    		    JMenuItem addsuite;
    		    JMenuItem delsuite;
    		    
    			popup = new JPopupMenu();
    			addsuite = new JMenuItem("Add Suite");
    	        popup.add(addsuite);
    	        delsuite = new JMenuItem("Remove Suite");
    	        popup.add(delsuite);
    	        popup.setOpaque(true);
    	        popup.setLightWeightPopupEnabled(true);
    	        
    	        tree.addMouseListener(new MouseListener() {
                    @Override
                    public void mouseReleased(MouseEvent e) {
                    	final DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
						try{
                    	if (selectedNode.isRoot() || !selectedNode.isLeaf()){
                    	if ( e.isPopupTrigger()) {
                            popup.show( (JComponent)e.getSource(), e.getX(), e.getY() );
                        }
                    }
						} catch(NullPointerException f){}
                    	}

					@Override
					public void mouseClicked(MouseEvent e) {
						final DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
						try{
						if (!selectedNode.isRoot() || selectedNode.isLeaf()){
						if (e.getClickCount() == 1){
							rightComponent.removeAll();
							rightComponent.revalidate();
							rightComponent.repaint();
							JPanel panel1 = new JPanel(new MigLayout("insets 20 20 20 20",
					                "[fill, grow]",
					                ""));
							JPanel panel2 = new JPanel(new MigLayout("insets 20 20 20 20",
					                "[fill, grow]",
					                ""));

							panel1.setBackground(Color.WHITE);
					        panel2.setBackground(Color.WHITE);
					        String[] columnNames1 = {"Select","Test Case"};
					        Object[][] data = {
					                {null, null}};
					        
					        model2 = new DefaultTableModel(null,columnNames1) ;
					        
					        FileInputStream fis = null;
							try {
								fis = new FileInputStream("..\\JTable\\Resources\\"+selectedNode+".txt");
							} catch (FileNotFoundException e3) {
								e3.printStackTrace();
							}
					        BufferedReader br1 = new BufferedReader(new InputStreamReader(fis));
					        String line;
					    try {
							while ((line = br1.readLine()) != null) 
							      {String[] data1 = line.split("-");
							      model2.addRow(data1); 
							 }
						} catch (IOException e3) {
							e3.printStackTrace();
						}
					    try {
							br1.close();
						} catch (IOException e3) {
							e3.printStackTrace();
						}
					        
					        table = new JTable(model2);                             
						    table.setPreferredScrollableViewportSize(new Dimension(500, 700));
						 	table.setFillsViewportHeight(true);
						 	table.setEnabled(true);
						 	table.setGridColor(Color.BLACK);
						 	table.setAutoCreateRowSorter(true);
						 	
					        rightComponent.add(panel1,"height 700, width 800");
					        rightComponent.add(panel2,"height 700");
					        rightComponent.revalidate();
					        rightComponent.repaint();
						 	
						 	table.getModel().addTableModelListener(new TableModelListener() {
           				      public void tableChanged(TableModelEvent e) {
           				    	 try {
										fileWriter = new FileWriter(new File("..\\JTable\\Resources\\"+selectedNode+".txt"), false);
									} catch (IOException e2) {
										e2.printStackTrace();
									}
           				    	 
           				    	sbTableData = new StringBuffer();
           				    	for(int row1 = 0; row1 < table.getRowCount(); row1 ++){
           				    	    for(int column = 0; column < table.getColumnCount(); column ++){
           				    	    	if (table.getValueAt(row1, column) == null ){
           				    	    		sbTableData.append("").append("-");
           				    	    	}
           				    	    	else
           				    	        sbTableData.append(table.getValueAt(row1, column)).append("-");
           				    	    }
           				    	    sbTableData.append("\n");
           				    	}
									
           				    	try {
										fileWriter.write(sbTableData.toString());
									} catch (IOException e1) {
										e1.printStackTrace();
									}
           				    	try {
										fileWriter.flush();
									} catch (IOException e1) {
										e1.printStackTrace();
									}
           				    	try {
										fileWriter.close();
									} catch (IOException e1) {
										e1.printStackTrace();
									}
						 	
           				      }});
						 	
						 	scrollPane = new JScrollPane(table);
						 	panel1.add(scrollPane);
						 	panel1.revalidate();
						 	panel1.repaint();
						 	
						 	table.addMouseListener(new MouseListener() {
     	                        @Override
     	                        public void mouseReleased(MouseEvent e) {
     	                            int r = table.rowAtPoint(e.getPoint());
     	                            int rowindex = table.getSelectedRow();
     	                            if (rowindex < 0)
     	                                return;
     	                            if (e.isPopupTrigger() && e.getComponent() instanceof JTable ) {
     	                                JPopupMenu popup = new JPopupMenu();
     	                                mntmDelRow = new JMenuItem("Remove Test Case");
    	                                popup.add(mntmDelRow);
     	                                popup.show(e.getComponent(), e.getX(), e.getY());
     	                            }
     	                            

     	                           try{
     	                                mntmDelRow.addActionListener
     	    	                          (new ActionListener() 
     	    	                     		{
     	    	                     			public void actionPerformed(ActionEvent e) 
     	    	                     			{
     	    	                     				DefaultTableModel model = (DefaultTableModel) table.getModel();

     	    	                     				
     	    	                     				int[] rows = table.getSelectedRows();
     	    	                     				for(int i=0;i<rows.length;i++){
     	    	                     					model.removeRow(rows[i]);}
     	    	                     					table.revalidate();
     	    	                     					table.repaint();
     	    	                     				}
     	    	                     		}
     	    	                     	);  }
     	                                catch(NullPointerException f){
     	                            }
     							}

								@Override
								public void mouseClicked(MouseEvent e) {
								}

								@Override
								public void mousePressed(MouseEvent e) {
								}

								@Override
								public void mouseEntered(MouseEvent e) {
								}

								@Override
								public void mouseExited(MouseEvent e) {
								}});
						 	
						 	String	listData[] =
								{
									"Item 1",
									"Item 2",
									"Item 3",
									"Item 4"
								};

								// Create a new listbox control
						 	final JList listbox = new JList( listData );
						 	JLabel label = new JLabel("Available Test Cases");
						 	panel2.add(label,"wrap");
						 	panel2.add(listbox);
						 	panel2.revalidate();
						 	panel2.repaint();
						 	
						 	listbox.addMouseListener(new MouseListener() {
					            @Override
						 	
					            public void mouseClicked(MouseEvent e) {
					            	if (e.getClickCount() == 2){
					                System.out.println(":MOUSE_CLICK_EVENT:");
					                
					                Object data = listbox.getSelectedValue().toString();
					                model2.addRow(new Object[]{"Y", data});
					                
					                try {
 										fileWriter = new FileWriter(new File("..\\JTable\\Resources\\"+selectedNode+".txt"), false);
 									} catch (IOException e2) {
 										e2.printStackTrace();
 									}
             				    	 
             				    	sbTableData = new StringBuffer();
             				    	for(int row1 = 0; row1 < table.getRowCount(); row1 ++){
             				    	    for(int column = 0; column < table.getColumnCount(); column ++){
             				    	    	if (table.getValueAt(row1, column) == null ){
             				    	    		sbTableData.append("").append("-");
             				    	    	}
             				    	    	else
             				    	        sbTableData.append(table.getValueAt(row1, column)).append("-");
             				    	    }
             				    	    sbTableData.append("\n");
             				    	}
									
             				    	try {
										fileWriter.write(sbTableData.toString());
									} catch (IOException e1) {
										e1.printStackTrace();
									}
             				    	try {
										fileWriter.flush();
									} catch (IOException e1) {
										e1.printStackTrace();
									}
             				    	try {
										fileWriter.close();
									} catch (IOException e1) {
										e1.printStackTrace();
									}
					            	}
					            }

								@Override
								public void mousePressed(MouseEvent e) {
								}

								@Override
								public void mouseReleased(MouseEvent e) {
								}

								@Override
								public void mouseEntered(MouseEvent e) {
								}

								@Override
								public void mouseExited(MouseEvent e) {
								}
						 	});
						}
						}
						else
						{
							if (selectedNode.isRoot() ){
								if (e.getClickCount() == 1){
									rightComponent.removeAll();
									rightComponent.revalidate();
									rightComponent.repaint();
								}}
						}
						}
						catch(NullPointerException f1){}
					}

					@Override
					public void mousePressed(MouseEvent e) {
					}

					@Override
					public void mouseEntered(MouseEvent e) {
					}

					@Override
					public void mouseExited(MouseEvent e) {
					}});
    	        
    	        addsuite.addActionListener
                (new ActionListener() 
           		{
           			public void actionPerformed(ActionEvent e) 
           			{
           				final JFrame addsuiteframe = new JFrame();
           				JPanel addsuitepanel = new JPanel(new MigLayout());
           				JLabel ObjName = new JLabel("Suite Name");
                		ObjNameText = new JTextField(); 
                		JButton add = new JButton("Add Suite");
                		addsuitepanel.add(ObjName,"Pos 10 10 0 0,width 70!, height 20!");
                		addsuitepanel.add(ObjNameText,"Pos 100 10 0 0,width 70!, height 20!");
                		addsuitepanel.add(add,"Pos 10 60 0 0,width 100!, height 20!");
                		
                		addsuiteframe.add(addsuitepanel);
                		addsuiteframe.setSize(250, 200);
                		addsuiteframe.setLocationRelativeTo(null);
                		addsuiteframe.setVisible(true);
                		
                		add.addActionListener(new ActionListener() {
                        	@Override
                			public void actionPerformed(ActionEvent f)  {
                        		DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getModel().getRoot();
                        		if (ObjNameText.getText().toString().equals("")){return;} else
                        			
                        		{treeModel.insertNodeInto(new DefaultMutableTreeNode(ObjNameText.getText().toString()), node, node.getChildCount());
                        		
                        		try {
        							fileWriter = new FileWriter(new File("..\\JTable\\Resources\\" + ObjNameText.getText() + ".txt"), false);
        						} catch (IOException e2) {
        							e2.printStackTrace();
        						}
                    		
                    		try {
        						fileWriter.close();
        					} catch (IOException e1) {
        						e1.printStackTrace();
        					}

                    		try {
									fileWriter1 = new FileWriter(new File("..\\JTable\\Resources\\data1.txt"), true);
								} catch (IOException e2) {
									e2.printStackTrace();
								}
     				    	 
     				    	sbTableData = new StringBuffer();
			    	        sbTableData.append(ObjNameText.getText());
     				    	sbTableData.append("\n");
							
     				    	try {
								fileWriter1.write(sbTableData.toString());
							} catch (IOException e1) {
								e1.printStackTrace();
							}
     				    	try {
								fileWriter1.flush();
							} catch (IOException e1) {
								e1.printStackTrace();
							}
     				    	try {
								fileWriter1.close();
							} catch (IOException e1) {
								e1.printStackTrace();
							}
                        		}
                				
                				for (int i = 0; i < tree.getRowCount(); i++) {
                				    tree.expandRow(i);
                				}
                        		addsuiteframe.dispose();
                        	}});
           			}
           		});
    	        
    	        delsuite.addActionListener
                (new ActionListener() 
           		{
           			public void actionPerformed(ActionEvent e) 
           			{
           				final JFrame delsuiteframe = new JFrame();
           				JPanel delsuitepanel = new JPanel(new MigLayout());
           				JLabel ObjName = new JLabel("Suite Name");
                		final JTextField ObjNameText = new JTextField(); 
                		JButton del = new JButton("Delete Suite");
                		delsuitepanel.add(ObjName,"Pos 10 10 0 0,width 70!, height 20!");
                		delsuitepanel.add(ObjNameText,"Pos 100 10 0 0,width 70!, height 20!");
                		delsuitepanel.add(del,"Pos 10 60 0 0,width 100!, height 20!");
                		
                		delsuiteframe.add(delsuitepanel);
                		delsuiteframe.setSize(250, 200);
                		delsuiteframe.setLocationRelativeTo(null);
                		delsuiteframe.setVisible(true);
                		
                		del.addActionListener(new ActionListener() {
                        	@Override
                			public void actionPerformed(ActionEvent f)  {
                        		TreePath path;
                        		MutableTreeNode mNode;
                        		String nodeName = ObjNameText.getText().toString();
                        		path = tree.getNextMatch(nodeName, 0, Position.Bias.Forward);
                        		
                        		try{
                        		mNode = (MutableTreeNode)path.getLastPathComponent();}
                        		catch(NullPointerException f1){return;}
                        		
                        		try{
                        		treeModel.removeNodeFromParent(mNode);}
                        		catch(IllegalArgumentException e){return;}
                        		
                        			 File f1 = null;
                        	         f1 = new File("..\\JTable\\Resources\\"+ObjNameText.getText()+".txt");
                        	         f1.delete();
                        	         
                        	         FileReader reader = null;
     								try {
     									reader = new FileReader(new File("..\\JTable\\Resources\\data1.txt"));
     								} catch (final FileNotFoundException e) {
     									e.printStackTrace();
     								}
     	            				final BufferedReader bf=new BufferedReader(reader);
     	            				String str=null;
     	            				BufferedWriter writer = null;
     								try {
     									writer = new BufferedWriter(new FileWriter(new File("..\\JTable\\Resources\\data2.txt"), false));
     								} catch (final IOException e) {
     									e.printStackTrace();
     								}
     	            				try {
     									while((str=bf.readLine())!=null){
     										
     										String trimmedLine = str.trim();
     									    if(!trimmedLine.startsWith(ObjNameText.getText())) 
     									    {
     									        writer.write(str + "\n"); 
     									    }
     										writer.flush();
     									}
     								} catch (final IOException e) {
     									e.printStackTrace();
     								}
     	            				try {
     									writer.close();
     									reader.close();
     								} catch (final IOException e) {
     									e.printStackTrace();
     								}
     	            				
     	            				FileReader reader1 = null;
     								try {
     									reader1 = new FileReader(new File("..\\JTable\\Resources\\data2.txt"));
     								} catch (final FileNotFoundException e) {
     									e.printStackTrace();
     								}
     	            				final BufferedReader bf1=new BufferedReader(reader1);
     	            				String str1=null;
     	            				BufferedWriter writer1 = null;
     								try {
     									writer1 = new BufferedWriter(new FileWriter(new File("..\\JTable\\Resources\\data1.txt"), false));
     								} catch (final IOException e) {
     									e.printStackTrace();
     								}
     	            				try {
     									while((str1=bf1.readLine())!=null){
   									        writer1.write(str1 + "\n"); 
     									    writer1.flush();
     									}
     								} catch (final IOException e) {
     									e.printStackTrace();
     								}
     	            				try {
     									writer1.close();
     									reader1.close();
     								} catch (final IOException e) {
     									e.printStackTrace();
     								}
                        		delsuiteframe.dispose();
                        	}});
           			}
           		});
    		}});
		
		ER.addActionListener 
    	(new ActionListener()  
    	{
    		@Override
			public void actionPerformed(ActionEvent e) {
    			Tree.removeAll(); 
    			rightComponent.removeAll();
		        rightComponent.revalidate();
		        rightComponent.repaint();
    			result = "Execution Result";
    			HeadOR.setText(result);
    			DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode("ER");
    			final DefaultTreeModel treeModel = new DefaultTreeModel(rootNode);
    			tree = new JTree(treeModel);
    			Tree.add(tree);
    			leftComponent1.revalidate();
    			leftComponent1.repaint();
    		}});
		
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,leftComponent, rightComponent);
		splitPane.setDividerSize(1);
		splitPane.setDividerLocation(190);
		splitPane.repaint();
		splitPane.revalidate();
		return splitPane;
	}
}
