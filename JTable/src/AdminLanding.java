import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import net.miginfocom.swing.MigLayout;


public class AdminLanding {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
            	createAndShowGUIAdminLogin();
            }
        });    
    }

    static void createAndShowGUIAdminLogin() {
        MigLayout layout = new MigLayout();
        JPanel panel = new JPanel(layout);
        
        JLabel UserList = new JLabel("Existing Users");
        JLabel ProjectList = new JLabel("Existing Projects");
        panel.add(UserList,"pos 150 50 0 0");
        panel.add(ProjectList,"pos 250 50 0 0");
        
        DefaultListModel listModel = new DefaultListModel();
        listModel.addElement("Jane Doe");
        listModel.addElement("John Smith");
        listModel.addElement("Kathy Green");
        listModel.addElement("Shobhit");
        JList list = new JList(listModel);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setSelectedIndex(0);
        list.setVisibleRowCount(5);
        panel.add(list,"pos 150 80 0 0");

        DefaultListModel listModel1 = new DefaultListModel();
        listModel1.addElement("Jane Doe");
        listModel1.addElement("John Smith");
        listModel1.addElement("Kathy Green");
        JList list1 = new JList(listModel1);
        list1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list1.setSelectedIndex(0);
        list1.setVisibleRowCount(5);
        panel.add(list1,"pos 250 80 0 0");
        
        JFrame frame = new JFrame("Admin Login");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(500,500));
        frame.setLayout(new BorderLayout());
        frame.add(panel, BorderLayout.CENTER);
        frame.setResizable(false);

        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}