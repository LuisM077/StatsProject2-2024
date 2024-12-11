
import org.jfree.ui.RefineryUtilities;


public class JFreeChartTutorial
{

    public static void main(String[] args)
    {
        Jars chart = new Jars();
        chart.pack( );          
        RefineryUtilities.centerFrameOnScreen( chart );          
        chart.setVisible( true ); 
        chart.run();
    }
    
}
