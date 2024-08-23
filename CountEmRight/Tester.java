/*
 * Tests the number of occurances of "sa" given an user input.
 *
 * @author Peter Yu
 * @version 2 - Aug 20, 2024
 */

import java.util.Scanner;

public class Tester {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String response = "continue";
        
        while (!(response.equals("EXIT~"))) {
            System.out.println("Type in a sentence and press ENTER:");
            response = input.nextLine();

            response = response.replaceAll("\\s","");
            response = response.toUpperCase();
            
            response += "~";
            
            String sp[] = response.split("SA");

            System.out.println("There are " + Integer.toString(sp.length-1) + " occurences.");
        }
    }
}
