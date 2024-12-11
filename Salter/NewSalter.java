
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class NewSalter
{
    ArrayList<Integer> xInput;
    ArrayList<Integer> yInput;
    
    public NewSalter() {
        xInput = new ArrayList<Integer>();
        yInput = new ArrayList<Integer>();
    }
    
    public NewSalter(ArrayList<Integer> userXInput, ArrayList<Integer> userYInput) {
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
    
    public ArrayList<Integer> saltData(ArrayList<Integer> array, int saltValues) {
        Random generator = new Random();
        
        for(int i = 0; i < array.size(); i++) {
            int randValue = generator.nextInt(saltValues) + 1;
            int choice = generator.nextInt(2);
            int newData;
            
            if(choice == 0) {
                newData = array.get(i) + randValue;
                array.remove(i);
                array.add(i, newData);
            }
            else {
                newData = array.get(i) - randValue;
                array.remove(i);
                array.add(i, newData);
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
    
    public void run() throws FileNotFoundException {
        readFile();
        System.out.println("x:");
        printArray(xInput);
        System.out.println("\n y:");
        printArray(yInput);
        
        saltData(yInput, 10);
        System.out.println("\n Salted Data:");
        printArray(yInput);
        
        createOutput();
    }
}
