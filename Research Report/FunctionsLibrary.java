
import java.util.ArrayList;


public class FunctionsLibrary
{
    private double n;
    private double r;
    private double y;
    private double bigN;
    private double p;
    private double q;
    private double lambda;
    private double k;
    private double a,b,c,d; //Mainly for Uniform Distribution
    
    Factorial fact = new Factorial();
    
    public FunctionsLibrary() {
        
    }
    
    public double getN() {
        return n;
    }
    public double getR() {
        return r;
    }
    public double getY() {
        return y;
    }
    public double getBigN() {
        return bigN;
    }
    public double getP() {
        return p;
    }
    public double getQ() {
        return q;
    }
    
    public void setN(double inputN) {
        n = inputN;
    }
    public void setR(double inputR) {
        r = inputR;
    }
    public void setY(double inputY) {
        y = inputY;
    }
    public void setBigN(double inputBigN) {
        bigN = inputBigN;
    }
    public void setP(double inputP) {
        p = inputP;
    }
    public void setQ(double inputQ) {
        q = inputQ;
    }
    
    //Mean Method
    public double findMean(ArrayList<Double> userInputNumbers){
        double sum = 0;
        
        for(double singleElement : userInputNumbers) {
            sum = sum + singleElement;
        }
        
        //Storing a value for clarity
        double result = sum / userInputNumbers.size();
        
        return result;
    }
    
    //Median Method
    public double findMedian(ArrayList<Double> userInputNumbers) {
        int middleOdd;
        double middleEven;
        if(userInputNumbers.size() % 2 != 0) {
            middleOdd =  userInputNumbers.size()/2;
            return userInputNumbers.get(middleOdd);
        }
        else {
            middleEven = ((userInputNumbers.size()/2) + ((userInputNumbers.size()/2) +1)) / 2.0; 
            return middleEven;
        }
    }
    
    //Mode method
    public double findMode(ArrayList<Double> userInputNumbers) {
        double value = 0;
        int count;
        int maxCount = 0;
        for(int i = 0; i < userInputNumbers.size(); i++) {
            for(int j = 0; i < userInputNumbers.size(); j++) {
                
            }
        }
        return value;
    }
    
    //Standard Deviation method
    public double findStandardDeviation(ArrayList<Double> userInputNumbers) {
        double std = 0;
        double sum = 0;
        ArrayList<Double> newList = new ArrayList<Double>();
        double mean = findMean(userInputNumbers);
        
        for(int i =0; i < userInputNumbers.size(); i++) {
            double difference = Math.abs(userInputNumbers.get(i) - mean);
            newList.add(Math.pow(difference,2));
        }
        
        for(int i = 0; i < newList.size(); i++) {
            sum = sum + newList.get(i);
        }
        
        std = Math.sqrt(sum / (userInputNumbers.size() - 1));
        
        return std;
    }
    
    public double permutation(double n, double r) {
        double result = fact.factorial(n) / fact.factorial(n-r);
        return result;
    }
    
    public double combination(double n, double r) {
        double result = fact.factorial(n) / (fact.factorial(r) * fact.factorial(n-r));
        return result;
    }
    
    public double binomial(double n, double y, double p, double q) {
        double bDistribution;
        bDistribution = combination(n,y) * Math.pow(p,y) * Math.pow(q, n-y);
        return bDistribution;
    }
    
    public double geometric(double y, double q, double p) {
        double gDistribution;
        gDistribution = Math.pow(q,y-1) * p;
        
        return gDistribution;
    }
    public double hypergeometric(double bigN, double n, double r, double y){
        double hgDistribution;
        hgDistribution = (combination(r,y) * combination (bigN-r, n - y)) / combination(bigN,n);
        return hgDistribution;
    }
    
    public double negativeBinomialP(double y, double r, double p, double q) {
        double nbDistribution;

        nbDistribution = combination(y-1, r-1) * Math.pow(p,r) * Math.pow(q,y-r);
        return nbDistribution;
    }
    
    public double poissonDistribution(double lambda, double y) {
        double pDistribution;
        pDistribution = (Math.pow(lambda, y) / fact.factorial(y)) * Math.exp(-lambda); ;
        return pDistribution;
    }
    
    public double tchebysheffsTheorem(double k) {
        double tchebysheff;
        tchebysheff = 1 - (1 / Math.pow(k, 2));
        return tchebysheff;
    }
    
    public double uniformDistribution(double a, double b, double c, double d) {
        double uDistribution;
        uDistribution = (d - c) / (b - a);
        return uDistribution;
    }
    
//    public double percentage(double amount, double total) {
//        double percent;
//        percent = amount % total;
//        return percent;
//    }
    
    public void runFunctions() {
        ArrayList<Double> testNumbers = new ArrayList<Double>();
        testNumbers.add(1.0);
        testNumbers.add(2.0);
        testNumbers.add(3.0);
        testNumbers.add(4.0);
        testNumbers.add(5.0);
        testNumbers.add(6.0);
        testNumbers.add(7.0);
        //testNumbers.add(8.0);
        //testNumbers.add(9.0);
        //testNumbers.add(10.0);
        //testNumbers.add(11.0);
        testNumbers.add(7.0);
        
        double testerResults = findMean(testNumbers);
        
        System.out.println("This is the average of testNumbers: " + testerResults);
        
        double testMedium = findMedian(testNumbers);
        System.out.println("The medium is: " + testMedium);
        System.out.println();
        
//        double testMode = test.findMode(testNumbers);
//        System.out.println("The mode is: " + testMode);
//        System.out.println();
        
        double testSTD = findStandardDeviation(testNumbers);
        System.out.printf("The standard deviation is: %.4f\n",testSTD);
        System.out.println();
        
        //n,r,yN,p,q
        System.out.println("Permutations");
        n = 30;
        r = 3;
        System.out.println(n + " P " + r + " = " + permutation(n, r));
        
        System.out.println("Combinations");
        n = 5;
        r = 1;
        System.out.println(n + " C " + r + " = " + combination(n, r));
        System.out.println();
        
        System.out.println("Binomial Probability Distribution");
        n = 10;
        y = 9;
        p = .3;
        q = .7;
        System.out.printf("Binomial distribution is: %.6f \n\n", binomial(n, y, p, q));
        
        System.out.println("------------------------------------------------------------");
        System.out.println("\nStats Library Part 2!!! \n");
        
        System.out.println("Geometric Probability Distribution");
        y = 6;
        q = .96;
        p = .04;
        System.out.printf("Geometric distribution is: %.6f \n\n", geometric(y, q, p));
        
        System.out.println("Hypergeometric Probability Distribution");
        n = 10;
        r = 5;
        y = 5;
        bigN = 20;
        System.out.printf("Hypergeometric distribution is: %.5f \n\n", hypergeometric(bigN, n, r, y));
        
        System.out.println("Negative Binomial Probability Distribution");
        y = 5;
        r = 3;
        p = .2;
        q = .8;
        System.out.printf("Negative Binomial Probability Distribution is: %.5f \n\n", negativeBinomialP(y, r, p, q));
        
        System.out.println("Poisson Probability Distribution");
        lambda = 3;
        y = 5;
        System.out.printf("Poisson Distribution is: %.5f \n\n", poissonDistribution(lambda,y));
        
        System.out.println("Tchebyshedd's Theorem");
        k = 2;
        System.out.printf("Tchebysheff's Theorem is: %.5f \n\n", tchebysheffsTheorem(k));
        
        System.out.println("Uniform Distribution");
        a = 0;
        b = 40;
        c = 0;
        d = 15;
        System.out.printf("Uniform Distribution is: %.5f \n\n", uniformDistribution(a,b,c,d));
        
    }
}

