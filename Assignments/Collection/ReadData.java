import java.util.List;
import java.util.ArrayList;
import java.lang.Math;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class ReadData {

    public static int CollectionSize(Collection c){
        int size = 0;
        while (c.hasNext()) {
            size++;
        }
        return (size+1);
    }

    public static double mean(Collection c){
        double sum = 0;
        double i = 0;
        while (c.hasNext()) {
            sum += (double) c.getNext();
            i++;
        }
        double avg = sum/i;
        return avg;
    }

    public static double variance(Collection c){
        double sum = 0;
        double i = 0;
        while (c.hasNext()) {
            sum += (double) c.getNext();
            i++;
        }
        double avg = sum/i;

        c.resetNext();
        double differences = 0;
        while (c.hasNext()) {
            differences = Math.pow(((double) c.getNext() - avg),2);
        }
        double variance = differences/i;
        
        return variance;
    }

    public static double stddev(Collection c){
        double sum = 0;
        double i = 0;
        while (c.hasNext()) {
            sum += (double) c.getNext();
            i++;
        }
        double avg = sum/i;

        c.resetNext();
        double differences = 0;
        while (c.hasNext()) {
            differences = Math.pow(((double) c.getNext() - avg),2);
        }
        double variance = differences/i;

        return Math.pow(variance, 0.5);
    }


    public static void main(String[] args) throws IOException {
        File file = new File("data.txt");
        Scanner scanner = new Scanner(file);
        Collection<Double> dataCollection = new ArrayCollection<Double>();
        while (scanner.hasNextLine()) {
            double data = Double.parseDouble(scanner.nextLine());
            // System.out.println(data);
            dataCollection.addItem(data);
        }
        scanner.close();

        dataCollection.resetNext();
        System.out.println("Minimum: " + CollectionUtils.minimum(dataCollection));
        dataCollection.resetNext();
        System.out.println("Maximum: " + CollectionUtils.maximum(dataCollection));
        dataCollection.resetNext();
        System.out.println("Size: " + CollectionSize(dataCollection));
        dataCollection.resetNext();
        System.out.println("Mean: " + mean(dataCollection));
        dataCollection.resetNext();
        System.out.println("Variance: " + variance(dataCollection));
        dataCollection.resetNext();
        System.out.println("Standard Deviation: " + stddev(dataCollection));
    }
}
