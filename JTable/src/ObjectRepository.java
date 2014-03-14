import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeSelectionModel;
import net.miginfocom.swing.MigLayout;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Set;

public class ObjectRepository   {
	String result = "Test Case";
	JTree tree;
	DefaultTreeModel model;
	DefaultTreeModel treeModel;
	JPanel Tree;
	JTable table;
	JScrollPane scrollPane;
	String ObjProparray[][] = new String[200][9];
	StringBuffer sbTableData;
	FileWriter fileWriter = null;
	BufferedReader reader;
	int numRows = 1 ;
	JMenuItem mntmCopyRow;
	JMenuItem mntmDelRow;
	DefaultTableModel model1;
	String data1[]= new String[100];
	String data2[][]= new String[100][9];
	JFrame MainFrame;

	public static void main(String[] args) {
		new ObjectRepository();
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
									if(table.getValueAt(row, 0).toString().equals(parent.toString()) && table.getValueAt(row, 1).toString().equals(selectedNode.toString())){
										table.setRowSelectionInterval(row, row);
										break;
									}
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
 										// TODO Auto-generated catch block
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
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
             				    	try {
										fileWriter.flush();
									} catch (IOException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
             				    	try {
										fileWriter.close();
									} catch (IOException e1) {
										// TODO Auto-generated catch block
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
             												if(table.getValueAt(row, 0).toString().equals(parent.toString()) && table.getValueAt(row, 1).toString().equals(selectedNode.toString())){
             													table.setRowSelectionInterval(row, row);
             													break;
             												}
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

		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,leftComponent, rightComponent);
		splitPane.setDividerSize(1);
		splitPane.setDividerLocation(190);
		splitPane.repaint();
		splitPane.revalidate();
		return splitPane;
	}
}