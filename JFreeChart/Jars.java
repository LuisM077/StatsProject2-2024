
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;


public class Jars extends ApplicationFrame
{
    private int startPoint;
    private int endPoint;
    private ArrayList<Integer> valueX;
    private ArrayList<Integer> valueY;
    private int m;
    private int b;
    
    ArrayList<Integer> saltedValueX;
    ArrayList<Integer> saltedValueY;
    
    ArrayList<Integer> smoothedValueX;
    ArrayList<Integer> smoothedValueY;

    public Jars()
    {
        super("JFreeChart Project");
        
        valueX = new ArrayList<Integer>();
        valueY = new ArrayList<Integer>();
        startPoint = 0;
        endPoint = 10;
        saltedValueX = new ArrayList<Integer>();
        saltedValueY = new ArrayList<Integer>();
        smoothedValueX = new ArrayList<Integer>();
        smoothedValueY = new ArrayList<Integer>();
    }
    
//    public Jars(){
//        startPoint = 0;
//        endPoint = 10;
//        valueX = new ArrayList<Integer>();
//        valueY = new ArrayList<Integer>();
//        xInput = new ArrayList<Integer>();
//        yInput = new ArrayList<Integer>();
//    }
    
    /*
    Generate the plot points for function y = mx + b
    */
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
    
    /*
    Salt the y-plot point
    */
    public ArrayList<Integer> saltData(ArrayList<Integer> array, int saltValues) {
        Random generator = new Random();
        
        ArrayList<Integer> a = new ArrayList<Integer>();
        
        for(int i = 0; i < array.size(); i++) {
            int randValue = generator.nextInt(saltValues) + 1;
            int choice = generator.nextInt(2);
            int newData;
            
            if(choice == 0) {
                newData = array.get(i) + randValue;
                //array.remove(i);
                a.add(i, newData);
            }
            else {
                newData = array.get(i) - randValue;
                //array.remove(i);
                a.add(i, newData);
            }
        }
        return a;
    }
    
    /*
    Smooth the y-plot points
    */
    public ArrayList<Integer> smoothData(ArrayList<Integer> array, int windowValue) {
        int average;
        
        ArrayList<Integer> b = new ArrayList<Integer>();
        
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
                //array.remove(i);
                b.add(i, average);
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
                //array.remove(i);
                b.add(i, average);
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
                //array.remove(i);
                b.add(i, average);
            }
        }
        return b;
    }
    
    public void createDataset(ArrayList<Integer> valueX, ArrayList<Integer> valueY, ArrayList<Integer> saltedValueY, ArrayList<Integer> smoothedValueY) {
        XYSeriesCollection dataset = new XYSeriesCollection();
        
        XYSeries originalData = new XYSeries("Original Data");
        XYSeries saltedData = new XYSeries("Salted Data");
        XYSeries smoothedData = new XYSeries("Smoothed Data");
        
        for(int i = 0; i < valueX.size(); i++) {
            originalData.add(valueX.get(i), valueY.get(i));
            saltedData.add(valueX.get(i), saltedValueY.get(i));
            smoothedData.add(valueX.get(i), smoothedValueY.get(i));   
        }
 
        dataset.addSeries(originalData);
        dataset.addSeries(saltedData);
        dataset.addSeries(smoothedData);
       

        //The following is provided by tutorialsPoint at: https://www.tutorialspoint.com/jfreechart/jfreechart_xy_chart.htm
        JFreeChart xylineChart = ChartFactory.createXYLineChart(
        "Generated Data" ,
        "X" ,
        "Y" ,
        dataset,
        PlotOrientation.VERTICAL ,
        true , true , false);
        
        
        ChartPanel chartPanel = new ChartPanel(xylineChart);
        chartPanel.setPreferredSize(new java.awt.Dimension(560, 367));
        XYPlot plot = xylineChart.getXYPlot();

        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesPaint(0, Color.RED);
        renderer.setSeriesPaint(1, Color.GREEN);
        renderer.setSeriesPaint(2, Color.YELLOW);
        renderer.setSeriesStroke(0, new BasicStroke(4.0f));
        renderer.setSeriesStroke(1, new BasicStroke(3.0f));
        renderer.setSeriesStroke(2, new BasicStroke(2.0f));
        plot.setRenderer(renderer);
        setContentPane(chartPanel);

        chartPanel.repaint();

    }

    public void printList(ArrayList<Integer> array) {
        for(int i = 0; i < array.size(); i++) {
            System.out.println(array.get(i));
        }
    }
    
    public void run(){
        generateData(); 
        System.out.println("X:");
        printList(valueX);
        System.out.println("\nY:");
        printList(valueY);
        
        saltedValueY = saltData(valueY, 10);
        System.out.println("\nSalt:");
        printList(saltedValueY);
        
        smoothedValueY = smoothData(saltedValueY, 3);
        System.out.println("\nSmooth:");
        printList(smoothedValueY);
        
        createDataset(valueX, valueY, saltedValueY, smoothedValueY);
        
    }
    
}
