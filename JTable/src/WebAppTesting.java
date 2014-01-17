public class WebAppTesting 
{
    public static void main(String[] args) 
    {
        javax.swing.SwingUtilities.invokeLater
        (new Runnable() 
        	{
            	public void run() 
            	{
            		MainLanding obj = new MainLanding();
            		obj.createAndShowGUIMainLanding();
            	}
        	}
        );
    }
}