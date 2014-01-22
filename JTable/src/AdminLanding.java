import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;
import net.miginfocom.swing.MigLayout;
 
@SuppressWarnings("serial")
public class AdminLanding extends JPanel 
                               implements ListSelectionListener {
    private JList listUser, listProject;
    private DefaultListModel listModelUser, listModelProject;
    private static final String addString = "Add";
    private static final String deleteString = "Delete";
    private JButton addButton,addButton1, deleteButton, deleteButton1, deleteButton2;
    private JTextField nameFieldUser, nameFieldProject;
    JComboBox c = new JComboBox();
    JComboBox c1 = new JComboBox();
    JLabel User, Project, UPM, SP, SU;
    String[] columnNames = {"Project","User"};
    Object[][] data = {{"Dummy Project", "Dummy User"}};
    JTable table;
    DefaultTableModel model ;
    JPanel buttonPane;
    JScrollPane scrollPane;
    String selected, selected1 = null;
    
    public AdminLanding() {
        super(new  MigLayout());
 
        //Create and populate the user list model.
        listModelUser = new DefaultListModel();
        listModelUser.addElement("Dummy User");
 
        //Create the user list and put it in a scroll pane.
        listUser = new JList(listModelUser);
        listUser.setSelectionMode(
            ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        listUser.setSelectedIndex(0);
        listUser.setVisibleRowCount(5);
        listUser.addListSelectionListener(this);
        listUser.setLayoutOrientation(JList.VERTICAL);
        listUser.setBorder(BorderFactory.createLoweredBevelBorder());
        JScrollPane listScrollPaneUser = new JScrollPane(listUser);
        listScrollPaneUser.setMinimumSize(new Dimension(100, 50));
        
        //Create and populate the project list model.
        listModelProject = new DefaultListModel();
        listModelProject.addElement("Dummy Project");
        //test
        //Create the project list and put it in a scroll pane.
        listProject = new JList(listModelProject);
        listProject.setSelectionMode(
            ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        listProject.setSelectedIndex(0);
        listProject.setVisibleRowCount(5);
        listProject.addListSelectionListener(this);
        listProject.setLayoutOrientation(JList.VERTICAL);
        listProject.setBorder(BorderFactory.createLoweredBevelBorder());
        JScrollPane listScrollPanelProject = new JScrollPane(listProject);
        listScrollPanelProject.setMinimumSize(new Dimension(100, 50));

 
        //Create the list-modifying buttons.
        addButton = new JButton(addString);
        addButton.setActionCommand(addString);
        addButton.addActionListener(new AddButtonListener());
        
        addButton1 = new JButton(addString);
        addButton1.setActionCommand(addString);
        addButton1.addActionListener(new AddButtonListener1());
 
        deleteButton = new JButton(deleteString);
        deleteButton.setActionCommand(deleteString);
        deleteButton.addActionListener(new DeleteButtonListener());

        deleteButton1 = new JButton(deleteString);
        deleteButton1.setActionCommand(deleteString);
        deleteButton1.addActionListener(new DeleteButtonListener1());
        
        deleteButton2 = new JButton(deleteString);
        deleteButton2.setActionCommand(deleteString);
        deleteButton2.addActionListener(new DeleteButtonListener2());
        
        JButton b = new JButton("Add User To Project");
        b.setActionCommand(addString);
        b.addActionListener(new AddButtonListener2());

        
        //Create the text field for entering new user names.
        nameFieldUser = new JTextField(15);
        nameFieldUser.addActionListener(new AddButtonListener());
        String nameUser = listModelUser.getElementAt(listUser.getSelectedIndex())
                               .toString();
        nameFieldUser.setText(nameUser);
        
        //Create the text field for entering new user project.
        nameFieldProject = new JTextField(15);
        nameFieldProject.addActionListener(new AddButtonListener1());
        String nameProject = listModelProject.getElementAt(listProject.getSelectedIndex())
                               .toString();
        nameFieldProject.setText(nameProject);
 
        //Create a control panel, using the default FlowLayout.
        
        MigLayout layout = new MigLayout();
        buttonPane = new JPanel(layout);

		buttonPane.add(User = new JLabel("User, Password"),"Pos 100 20 0 0");
		buttonPane.add(Project = new JLabel("Project"),"Pos 300 20 0 0");
        buttonPane.add(listScrollPaneUser,"Pos 100 40 0 0, width 150!, height 90!");
        buttonPane.add(listScrollPanelProject,"Pos 300 40 0 0, width 150!, height 90!");
        buttonPane.add(addButton,"Pos 100 160 0 0, width 70!, height 20!");
        buttonPane.add(addButton1,"Pos 300 160 0 0, width 70!, height 20!");
        buttonPane.add(nameFieldUser,"Pos 100 140 0 0, width 150!");
        buttonPane.add(nameFieldProject,"Pos 300 140 0 0, width 150!");
        buttonPane.add(deleteButton,"Pos 180 160 0 0, width 70!, height 20!");
        buttonPane.add(deleteButton1,"Pos 380 160 0 0, width 70!, height 20!");
        buttonPane.add(UPM = new JLabel("User Project Mapping"),"Pos 70 220 0 0");
        buttonPane.add(SU = new JLabel("Select Project"),"Pos 100 250 0 0");
        buttonPane.add(SP = new JLabel("Select User"),"Pos 300 250 0 0");
        buttonPane.add(deleteButton2 ,"Pos 380 222 0, width 100!, height 15!");
        buttonPane.add(c ,"Pos 100 267 0 0, width 150!");
        c.addItem("Dummy Project");
        c.addItem("Rabo");
        c.setSelectedIndex(-1);
        buttonPane.add(c1 ,"Pos 300 267 0 0, width 150!");
        c1.addItem("Dummy User");
        c1.addItem("Shobhit");
        c1.setSelectedIndex(-1);
        buttonPane.add(b ,"Pos 210 222 0 0, width 150!, height 15!");
        
        model = new DefaultTableModel(null, columnNames);
        table = new JTable(model);
        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(true);
        scrollPane = new JScrollPane(table);
        buttonPane.add(scrollPane ,"Pos 150 300 0, width 250!, height 70!");
        
        add(buttonPane);
    }
 
    class DeleteButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent a) {
            ListSelectionModel lsm = listUser.getSelectionModel();
            int firstSelected = lsm.getMinSelectionIndex();
            int lastSelected = lsm.getMaxSelectionIndex();
            listModelUser.removeRange(firstSelected, lastSelected);
 
            int size = listModelUser.size();
 
            if (size == 0) {
                deleteButton.setEnabled(false);
            } else {
                if (firstSelected == listModelUser.getSize()) {
                    firstSelected--;
                }
                listUser.setSelectedIndex(firstSelected);
            }
        }
    }

    class DeleteButtonListener1 implements ActionListener {
        public void actionPerformed(ActionEvent b) {
            ListSelectionModel lsm1 = listProject.getSelectionModel();
            int firstSelected1 = lsm1.getMinSelectionIndex();
            int lastSelected1 = lsm1.getMaxSelectionIndex();
            listModelProject.removeRange(firstSelected1, lastSelected1);
            int size1 = listModelProject.size();
            if (size1 == 0) {
                deleteButton1.setEnabled(false);
            } else {
                if (firstSelected1 == listModelProject.getSize()) {
                    firstSelected1--;
                }
                listProject.setSelectedIndex(firstSelected1);
            }
        }
    }

    class DeleteButtonListener2 implements ActionListener {
        public void actionPerformed(ActionEvent b) {
        	int selRow = table.getSelectedRow();
        	try {
        	model.removeRow(selRow);
        	} 
        	catch (ArrayIndexOutOfBoundsException e ) {
            	Toolkit.getDefaultToolkit().beep();
                return;
            }
        	if (table.getRowCount() == 0)
        	{
        		deleteButton2.setEnabled(false);
        	} else
        	{
        		deleteButton2.setEnabled(true);
        	}
        		
        }
    }

    
    /** A listener shared by the text field and add button. */
    class AddButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent c) {
            if (nameFieldUser.getText().equals("")) {
            //User didn't type in a name...
                Toolkit.getDefaultToolkit().beep();
                return;
            }
            
            int index2 = listUser.getSelectedIndex();
            int size2 = listModelUser.getSize();

            //If no selection or if item in last position is selected,
            //add the new one to end of list, and select new one.
            if (listModelUser.indexOf(nameFieldUser.getText()) == -1){
            if (index2 == -1 || (index2+1 == size2)) {
            		System.out.println(listModelUser.indexOf(nameFieldUser.getText()));
            	listModelUser.addElement(nameFieldUser.getText());
                listUser.setSelectedIndex(size2);} else {
            	listModelUser.insertElementAt(nameFieldUser.getText(), index2+1);
                listUser.setSelectedIndex(index2+1);

        }} else {Toolkit.getDefaultToolkit().beep();
        return;}
    }}
 
    class AddButtonListener1 implements ActionListener {
        public void actionPerformed(ActionEvent d) {
            
            if (nameFieldProject.getText().equals("")) {
            //User didn't type in a name...
                Toolkit.getDefaultToolkit().beep();
                return;
            }
 
            int index3 = listProject.getSelectedIndex();
            int size3 = listModelProject.getSize();
 
            //If no selection or if item in last position is selected,
            //add the new one to end of list, and select new one.
            if (listModelProject.indexOf(nameFieldProject.getText()) == -1){
            if (index3 == -1 || (index3+1 == size3)) {
            	listModelProject.addElement(nameFieldProject.getText());
                listProject.setSelectedIndex(size3);} else {
                listModelProject.insertElementAt(nameFieldProject.getText(), index3+1);
                listProject.setSelectedIndex(index3+1);
            }} else {Toolkit.getDefaultToolkit().beep();
            return;}
        } 
    }
    
    class AddButtonListener2 implements ActionListener {
        public void actionPerformed(ActionEvent d) {
            try {selected = c.getSelectedItem().toString();
            selected1 = c1.getSelectedItem().toString();}
            catch (NullPointerException e ) {
            	Toolkit.getDefaultToolkit().beep();
                return;
            }
            
            ArrayList<String> data = new ArrayList<String>();

                for (int i = model.getRowCount() - 1; i >= 0; --i) {
                    for (int j = model.getColumnCount() - 1; j >= 0; --j) {
                        System.out.println(model.getValueAt(i, j).toString() + model.getValueAt(i, j-1).toString());	
                    	//data.add(model.getValueAt(i, j).toString());
                    }
                }
                
                for (int i = 0; i < model.getRowCount() - 1; i++) {
                    for (int j = 0; j < model.getColumnCount() - 1; j++) {
                        System.out.println(model.getValueAt(i, j).toString() + model.getValueAt(i, j-1).toString());	
                    	//data.add(model.getValueAt(i, j).toString());
                    }
                }
             

            
            model.insertRow(table.getRowCount(), new Object[]{selected.toString(),selected1.toString()});
            if (table.getRowCount() != 0)
            {
            	deleteButton2.setEnabled(true);
            }
            c1.setSelectedIndex(-1);
            c.setSelectedIndex(-1);
        }
    }
 
    //Listener method for list selection changes.
    public void valueChanged(ListSelectionEvent e) {
        if (e.getValueIsAdjusting() == false) {
 
            if (listUser.getSelectedIndex() == -1 ) {
            //No selection: disable delete, up, and down buttons.
                deleteButton.setEnabled(false);
                nameFieldUser.setText("");
 
            } else if (listUser.getSelectedIndices().length > 1) {
            //Multiple selection: disable up and down buttons.
                deleteButton.setEnabled(true);
 
            } else {
            //Single selection: permit all operations.
                deleteButton.setEnabled(true);
                nameFieldUser.setText(listUser.getSelectedValue().toString());
            }
        }
        
        if (listProject.getSelectedIndex() == -1) {
            //No selection: disable delete, up, and down buttons.
                deleteButton1.setEnabled(false);
                nameFieldProject.setText("");
 
            } else if (listProject.getSelectedIndices().length > 1) {
            //Multiple selection: disable up and down buttons.
                deleteButton1.setEnabled(true);
 
            } else {
            //Single selection: permit all operations.
                deleteButton1.setEnabled(true);
                nameFieldProject.setText(listProject.getSelectedValue().toString());
            }
    }
 
    /** 
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    static void createAndShowGUIAdminLogin() {
        //Create and set up the window.
        JFrame frame = new JFrame("Admin Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(600,500));
        //Create and set up the content pane.
        JComponent newContentPane = new AdminLanding();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);
         
        //Don't let the content pane get too small.
        //(Works if the Java look and feel provides
        //the window decorations.)
        newContentPane.setMinimumSize(
                new Dimension(
                        newContentPane.getPreferredSize().width,
                        100));
 
        //Display the window.
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
 
    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	createAndShowGUIAdminLogin();
            }
        });
    }
}