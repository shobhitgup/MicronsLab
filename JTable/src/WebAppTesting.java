public class WebAppTesting 
{
    public static void main(String[] args) 
    {
        javax.swing.SwingUtilities.invokeLater
        (new Runnable() 
        	{
            	@SuppressWarnings("static-access")
				public void run() 
            	{
            		Login obj = new Login();
            		obj.createAndShowGUILogin();
            	}
        	}
        );
    }
}