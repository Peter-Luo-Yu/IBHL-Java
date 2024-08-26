import java.util.Arrays;

public class AscendDescend {
    public static void main(String[] args) {

        String[] ss = {"Bill", "Mary", "Lee", "Agnes", "Alfred", "Thomas", "Alvin", "Bernard", "Ezra", "Herman"};
        Arrays.sort(ss);
        
        System.out.println("Ascend    Descend");
        System.out.println();
        for (int i = 0; i < ss.length; i++)
        {
            String line = ss[i];
            int length = 10 - ss[i].length();
            
            for (int j = 0; j < length; j++) {
                line += " ";
            }

            System.out.println(line + ss[ss.length - i - 1]);
        }

    }

}
