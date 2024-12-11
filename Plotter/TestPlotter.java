import java.io.FileNotFoundException;
import java.util.ArrayList;

public class TestPlotter
{
    public static void main(String[] args) throws FileNotFoundException { 

        NewPlotter test1 = new NewPlotter(0, 10);
        
        test1.run();
        
    }
}
