import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;


public class Data
{
    private ArrayList<String> carMakes;
    private ArrayList<String> carModels;
    private ArrayList<Integer> years;
    private ArrayList<Double> engineSizes;
    private ArrayList<Integer> horsePowers;
    private ArrayList<Integer> torques;
    private ArrayList<Double> accelerationTimes;
    private ArrayList<Double> prices;

    FunctionsLibrary fl = new FunctionsLibrary();
    Factorial fact = new Factorial();
    SetOperations ops = new SetOperations();
    
    public Data() {
        carMakes = new ArrayList<String>();
        carModels = new ArrayList<String>();
        years = new ArrayList<Integer>();
        engineSizes = new ArrayList<Double>();
        horsePowers = new ArrayList<Integer>();
        torques = new ArrayList<Integer>();
        accelerationTimes = new ArrayList<Double>();
        prices = new ArrayList<Double>();
    }
    
    
    public void readFile()  throws FileNotFoundException { 
        
        String inputFileName = "Sport car price.csv";
        
        File inputFile = new File(inputFileName);
        Scanner in = new Scanner(inputFile);
        
        String categories = in.nextLine();
        while(in.hasNextLine()) {
            String line = in.nextLine();
            line = line.trim();
            
            String[] parts = line.split(",");
            
            String carMake = parts[0].trim();
            String carModel = parts[1].trim();
            int year = Integer.parseInt(parts[2].trim());
            
            String engineSizeField = parts[3].trim();
            double engineSize;
            if (isNumeric(engineSizeField)) {
                engineSize = Double.parseDouble(engineSizeField);
            } else {
                engineSize = -1.0; 
            }

            int horsePower = Integer.parseInt(parts[4].trim().replace("+", ""));
            
            
            String torqueField = parts[5].trim().replace(",", "").replace("-", "").replace("+", "").replace("/","");
            int torque = 0;
            if (isNumeric(torqueField)) {
                torque = Integer.parseInt(torqueField);
            } else {
                torque = -1; 
            }
                        
            double accelerationTime = Double.parseDouble(parts[6].trim().replace("<", "").replace("+", ""));
                                               
            double price = Double.parseDouble(parts[7].trim().replace(",", ""));
            

            
            carMakes.add(carMake);
            carModels.add(carModel);
            years.add(year);
            engineSizes.add(engineSize);
            horsePowers.add(horsePower);
            torques.add(torque);
            accelerationTimes.add(accelerationTime);
            prices.add(price);
            
            
            
        }
    }
    
    public void printList(ArrayList<Integer> array) {
        for(int i = 0; i < array.size(); i++) {
            System.out.println(array.get(i));
        }
    }
    public void printListStrings(ArrayList<String> array) {
        for(int i = 0; i < array.size(); i++) {
            System.out.println(array.get(i));
        }
    }
    
    /*
    isNumeric code is from stackrverflow: https://stackoverflow.com/questions/1102891/how-to-check-if-a-string-is-numeric-in-java
    */
    public boolean isNumeric(String str) { 
        try {  
            Double.parseDouble(str);  
            return true;
        } catch(NumberFormatException e){  
            return false;  
        }  
    }
    
    public double percentLess(ArrayList<Double> array, double condition) {
        double percent = 0;
        double meetsCondition = 0;
        for(int i = 0; i < array.size(); i++) {
            if(array.get(i) < condition ) {
                meetsCondition++;
            }
        }
        percent = meetsCondition / array.size();
        return percent;
    }
    
    public double percentMore(ArrayList<Double> array, double condition) {
        double percent = 0;
        double meetsCondition = 0;
        for(int i = 0; i < array.size(); i++) {
            if(array.get(i) > condition ) {
                meetsCondition++;
            }
        }
        percent = meetsCondition / array.size();
        return percent;
    }
    
    public ArrayList<String> separateLists(ArrayList<String> array, int start, int end) {
        ArrayList<String> smallerList = new ArrayList<String>();
        for(int i = start; i < end; i++) {
            smallerList.add(array.get(i));
        }
        return smallerList;
    }
    
    public double findSomething(ArrayList<String> array, String userWants) {
        ArrayList<String> newArray = new ArrayList<String>();
        double count = 0;
        for(int i = 0; i < array.size(); i++) {
            if(array.get(i).equals(userWants)) {
                newArray.add(array.get(i));
                count++;
            }
        }
        return count;
    }
    
    public void run() throws FileNotFoundException{
        readFile();
        
//        for(int i = 0; i < carMakes.size(); i++) {
//            System.out.printf("%-15s %-30s %-7d %-7.2f %-7d %-7d %-7.2f %-7.0f \n", carMakes.get(i), carModels.get(i), years.get(i), engineSizes.get(i), horsePowers.get(i), torques.get(i), accelerationTimes.get(i), prices.get(i));
//        }
        
        System.out.println("Chapter 1:");
        
        System.out.println("Finding the mean, median and standard deviation of supercar prices:");
        double pricesMean = fl.findMean(prices);
        double pricesMedian = fl.findMedian(prices);
        double pricesStdv = fl.findStandardDeviation(prices);
        System.out.printf("Mean: %.4f Meadian: %.4f Standard Deviation: %.4f \n", pricesMean, pricesMedian, pricesStdv);
        
        System.out.println("Section 1.2: Percentages");
        double higherThanMean = percentMore(prices, pricesMean);
        System.out.printf("What percentage of supercars have a price higher than the mean? %.2f\n", higherThanMean);
        
        System.out.println("Section 1.3: Mean, Meadian, Mode, Standard Deviation");
        System.out.printf("Find the mean of prices: %.2f\n",pricesMean);
        
        System.out.println("Chapter 2:");
        
        System.out.println("Section 2.3: Union and Intersect");
        ArrayList<String> listA = new ArrayList<String>();
        ArrayList<String> listB = new ArrayList<String>();
        ArrayList<String> unionList = new ArrayList<String>();
        listA = separateLists(carMakes, 0, 20);
        listB = separateLists(carMakes, 20,40);
        unionList = ops.union(listA, listB);
        
        System.out.println("For the sake of this project, two subsets have been created from the car model list.");
        System.out.printf("What is the union between ListA and ListB?\n");
        printListStrings(unionList);
        
        System.out.println("Section 2.4: Sample Space");
        
        
        System.out.println("Section 2.5: Sample Point Method");
        
        
        System.out.println("Section 2.6: Permutations and Combinations");
        ArrayList<String> perm = new ArrayList<String>();
        //double numOfPorsche = findSomething(listA, "Porsche");
        System.out.printf("What are the of ways of selecting two card models from listA? %.2f \n", fl.combination(listA.size(), 2));
        
        System.out.println("Section 2.7: Conditional Probability");
        
        System.out.println("Section 2.8: Two Laws of Probability");
        
        System.out.println("Section 2.9: Calculating Probability");
        
        System.out.println("Section 2.10: Baye's Theorem");


        System.out.println("Chapter 3");
        //11 Sections
        
        System.out.println("Section 3.2: Probability Distribution ");
        
        System.out.println("Section 3.3: Expected Values");
        
        System.out.println("Section 3.4: Binomial Distribution");
        /* n y p q
        n = trials
        y = num of succes
        p = prob of success
        q = prob of failure
        */
        
        
        
        
        
        System.out.println("Section 3.5: Geometric Distribution");
        
        System.out.println("Section 3.6: Negative Binomial Distribution");
        
        System.out.println("Section 3.7: Hypergeometric Distribution");
        
        System.out.println("Section 3.8: Poisson Distribution");
        
        System.out.println("Section 3.11: Tchebysheff's Theorem");
        
        System.out.println("Chapter 4:");
        
        System.out.println("Section 4.2: Probability Distribution");
        
        System.out.println("Section 4.2: Expcted Values");

        System.out.println("Section 4.4: Uniform Distribution");


        
        
    }
}
