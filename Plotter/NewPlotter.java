import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class NewPlotter
{
    private int startPoint;
    private int endPoint;
    private ArrayList<Integer> valueX;
    private ArrayList<Integer> valueY;
    private int m;
    private int b;
    
    
    public NewPlotter() {
        startPoint = 0;
        endPoint = 10;
        valueX = new ArrayList<Integer>();
        valueY = new ArrayList<Integer>();
    }
   
    public NewPlotter(int userStartPoint, int userEndPoint) {
        startPoint = userStartPoint;
        endPoint = userEndPoint;
        valueX = new ArrayList<Integer>();
        valueY = new ArrayList<Integer>();
    }
    
    public void generateData() {
        Random rand = new Random();
        
        //y = mx + b
        int y, x;
        m = rand.nextInt(3) + 1;
        b = rand.nextInt(5) + 1;
        int range = Math.abs(startPoint - endPoint);
        
        
        
        for(int i = 0; i < range+1; i++) {
            x = startPoint;
            y = (m * x) + b;
            valueX.add(x);
            valueY.add(y);
            startPoint++;
        }
        
        
        
    }
    
    public void createOutput() throws FileNotFoundException {

        String outputFile = "output.csv";
        
        PrintWriter out = new PrintWriter(outputFile);
        for(int i = 0; i < valueX.size(); i++) {
            out.println(valueX.get(i) + ", " + valueY.get(i));
        }
        
        out.close();
    }
    
    public void printList(ArrayList<Integer> array) {
        for(int i = 0; i < array.size(); i++) {
            System.out.println(array.get(i));
        }
    }
    
    
    public void run() throws FileNotFoundException{
        generateData();
        System.out.println("X:");
        printList(valueX);
        System.out.println("\nY");
        printList(valueY);
        createOutput();
        System.out.println("m:" + m + " b:" + b);
    }
}
