import java.util.List;
import java.util.ArrayList;
import java.lang.Math;

public class Shuffle
{
    public static void shuffle(List<String> elements)
    {
        String temp;
        // int[] chosen = new int[elements.size()];

        for (int i = 0; i < elements.size(); i++){
            int x = (int) (Math.random() * (elements.size()));
            int y = (int) (Math.random() * (elements.size()));
            // System.out.println(x);
            temp = elements.get(x);
            elements.set(x, elements.get(y));
            elements.set(y, temp);

            temp = null;
        }

    }
    
    public static void main(String[] args)
    {
        String[] suits = {"Clubs", "Spades", "Hearts", "Diamonds"};
        String[] ranks = new String[13];
        ranks[0] = "Ace";
        for (int i=2; i<=10; i++)
        {  ranks[i-1] = ""+i;  }
        ranks[10] = "Jack";
        ranks[11] = "Queen";
        ranks[12] = "King";
        
        List<String> deck = new ArrayList<>(); //note I am using the shortcut where I do not have to retype String in the constuctor <>
        
        //Write code to add all 52 cards to the deck
        for (int i = 0; i < suits.length; i++) {
            for (int j = 0; j < ranks.length; j++) {
                String card = suits[i] + " " + ranks[j];
                deck.add(card);
            }
        }

        shuffle(deck);
        
        //Write code to display the shuffled deck, one card per line
        for (String card : deck){
            System.out.println(card);
        }
        
    }   
}
