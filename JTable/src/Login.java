import java.awt.EventQueue;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;

public class Login {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
            	createAndShowGUILogin();
            }
        });    
    }

    static void createAndShowGUILogin() {
        MigLayout layout = new MigLayout();
        JPanel panel = new JPanel(layout);
        
        JLabel UserName = new JLabel("User Name");
        JLabel Password = new JLabel("Password");
        final JTextField UserNameInput = new JTextField();
        JTextField PasswordInput = new JTextField();
        final JButton Login = new JButton("Login");
        
        panel.add(UserName,"pos 150 100 0 0");
        panel.add(UserNameInput,"pos 250 100 0 0,wrap, width 150:250");
        panel.add(Password,"pos 150 130 0 0");
        panel.add(PasswordInput,"pos 250 130 0 0,wrap, width 150:250");
        panel.add(Login,"pos 150 200 0 0,width 150:250");

        
        final JFrame frame = new JFrame("Login");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(500,500));
        frame.setLayout(new BorderLayout());
        frame.add(panel, BorderLayout.CENTER);
        frame.setResizable(false);
        
        Login.addActionListener
    	(new ActionListener() 
    		{
    			@SuppressWarnings("static-access")
				@Override
    			public void actionPerformed(ActionEvent e) 
    			{
    				if (UserNameInput.getText().toString().equals("Shobhit"))
    				{
    					frame.setVisible(false);
    					AdminLanding object = new AdminLanding();
    					object.createAndShowGUIAdminLogin();
    				}
    				else
    				{
    					frame.setVisible(false);
    					MainLanding object = new MainLanding();
    					object.createAndShowGUIMainLanding();
    				}
    			}
    		}
    	); 

        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}