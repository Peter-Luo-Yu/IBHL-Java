import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;
/*
 * Runner class to read matrix sizes from a file,
 * create spiral matrices of those sizes
 * and display the spiral matrices in the terminal (System.out)
*/
public class SpiralMatrixRunner
{
    public static void main( String args[] ) throws IOException
    {
        File file = new File("data.txt");
        Scanner scanner = new Scanner(file);
        while(scanner.hasNextLine()) {
            int data = Integer.parseInt(scanner.nextLine());
            SpiralMatrix matrix = new SpiralMatrix(data);
            matrix.createSpiral();
            System.out.println("Spiral Matrix of Value " + data + ":");
            System.out.println(matrix.toString());
            System.out.println("\n\n\n");
        }
        scanner.close();
    }
}

