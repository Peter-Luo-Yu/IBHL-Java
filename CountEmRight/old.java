
/*
 * Write a description of class Tester here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;

public class old
{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String response = "continue";

        while (!((response).equalsIgnoreCase("exit"))) {
            System.out.println("Type in a sentence and press ENTER:");
            response = input.nextLine();

            response = response.toLowerCase();
            String sp[] = response.split("s");
            int count = 0;
            int[] c = {1, 2, 3, 4};
            String ss = ">>>";
            int len = ss.length( );
            for (int j = 0; j < len; j++)
                ss+= c[j];
            System.out.println(ss);

            for (int i = 1; i < sp.length; i++) {
                //System.out.println(sp[i]);
                if (sp[i].startsWith("a")){
                    count++;
                } else if (sp[i].startsWith(" ")) {
                    while (sp[i].startsWith(" ")) {
                        sp[i] = sp[i].substring(1);
                    }
                    if (sp[i].startsWith("a")){
                        count++;
                    }
                }
            }
            if (!((response).equalsIgnoreCase("exit"))) {
                System.out.println("There are " + count + " occurrences.");
            }

        }
        System.out.print("exited!");
    }
}
