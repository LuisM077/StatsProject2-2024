
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class NewSmoother
{
    
    ArrayList<Integer> xInput;
    ArrayList<Integer> yInput;
    
    public NewSmoother() {
        xInput = new ArrayList<Integer>();
        yInput = new ArrayList<Integer>();
    }
    
    public NewSmoother(ArrayList<Integer> userXInput, ArrayList<Integer> userYInput) {
        xInput = userXInput;
        yInput = userYInput;
    }
    
    public void readFile()  throws FileNotFoundException { 
        
        String inputFileName = "input.csv";
        
        File inputFile = new File(inputFileName);
        Scanner in = new Scanner(inputFile);
        
        
        while(in.hasNextLine()) {
            String line = in.nextLine();
            line = line.trim();
            
            String[] parts = line.split(",");
            
            int x = Integer.parseInt(parts[0].trim());
            int y = Integer.parseInt(parts[1].trim());
            
            xInput.add(x);
            yInput.add(y);
        }
    }
    
    public ArrayList<Integer> smoothData(ArrayList<Integer> array, int windowValue) {
        int average;
        for(int i = 0; i < array.size(); i++) {
            int total = 0;
            int amount = 0;
            if(i < windowValue) {
                int j = 0;
                // i = 0 { 0 1 2 3
                // i = 2 { 0 1 2 3 4 5
                while(j <= i + windowValue) {
                    total = total + array.get(j); 
                    j++;
                    amount++;
                }
                average = total / amount;
                array.remove(i);
                array.add(i, average);
            }
            // i = 4
            // size = 10; 10 - 3 = 7 
            else if(i >= windowValue && i < array.size() - windowValue) {
                int j = i - windowValue;
                //i = 4 { 1 2 3 4 5 6 7
                while(j < i + windowValue + 1) {
                    total = total + array.get(j);
                    j++;
                    amount++;
                }
                average = total / amount;
                array.remove(i);
                array.add(i, average);
            }
            // 10 - 3 = 7
            //i = 7
            else {
                int j = i - windowValue;
                //i = 8 { 5 6 7 8 9 
                while(j < array.size()) {
                    total = total + array.get(j);
                    j++;
                    amount++;
                }
                average = total / amount;
                array.remove(i);
                array.add(i, average);
            }
        }
        return array;
    }
    
    public void printArray(ArrayList<Integer> array){
        for(int i = 0; i < array.size(); i++) {
            System.out.println(array.get(i));
        }
    }
    
    public void createOutput() throws FileNotFoundException {

        String outputFile = "output.csv";
        
        PrintWriter out = new PrintWriter(outputFile);
        for(int i = 0; i < xInput.size(); i++) {
            out.println(xInput.get(i) + ", " + yInput.get(i));
        }
        
        out.close();
    }
    
    public void runSmoother() throws FileNotFoundException {
        readFile();
        System.out.println("x:");
        printArray(xInput);
        System.out.println("\n y:");
        printArray(yInput);
        
        yInput = smoothData(yInput, 3);
        System.out.println("\n Smoother Data:");
        printArray(yInput);
        
        yInput = smoothData(yInput, 3);
        System.out.println("\n Smoother Data 2nd time:");
        printArray(yInput);
        
        //smoothData(yInput, 3);
        //System.out.println("\n Smoother Data 3rd time:");
        //printArray(yInput);
        
        createOutput();
    }
}
