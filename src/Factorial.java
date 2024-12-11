
public class Factorial
{
    private double n;
    
    public Factorial() {
        
    }
    public Factorial(double userN) {
        n = userN;
    }
    
    public double getFactorialN() {
        return n;
    }
    public void setFactorialN(double userN){
        n = userN;
    }
    
    //Factorial method code from "Big Java Early Objects" by Cay Horstmann
    public double factorial(double n) {
        if (n <= 1) { 
            return 1; 
        }
        else {
            return n * factorial(n - 1);
        }
    }
}
