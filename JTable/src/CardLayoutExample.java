import java.awt.BorderLayout;
import java.util.Hashtable;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class CardLayoutExample {
  public static void main(String args[]) {
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    DefaultMutableTreeNode root = new DefaultMutableTreeNode("Root");
    Hashtable<String, Object> hashtable = new Hashtable<String, Object>();
    hashtable.put ("Two", new String[]{"A", "B", "C"});
    
    Hashtable<Object, Object> innerHashtable = new Hashtable<Object, Object>();

    innerHashtable.put ("Two", new String[]{"A", "B", "C"});
    
    hashtable.put ("Three", innerHashtable);
    JTree.DynamicUtilTreeNode.createChildren(root, hashtable);
    JTree tree = new JTree(root);
    
    JScrollPane scrollPane = new JScrollPane(tree);
    frame.add(scrollPane, BorderLayout.CENTER);
    frame.setSize(300, 150);
    frame.setVisible(true);

  }
}