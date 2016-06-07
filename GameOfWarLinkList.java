
import java.util.LinkedList;

/**
 * Created by ronjohnson1 on 6/6/16.
 */

class CardLL
{
    int value;
    String suit;
    String name;

    public String toString()
    {
        return name + " of " + suit;
    }
}

public class GameOfWarLinkList
{
    public static void main( String[] args)
    {

        LinkedList<CardLL> deck = buildDeck();
        shuffleDeck(deck);
        //System.out.println("Shuffled");
        //displayDeck(deck);

        LinkedList<CardLL> handA = dealHand(deck, 0);
        LinkedList<CardLL> handB = dealHand(deck, 1);

//game play begins here...

        while (handA.size() > 0 & handB.size() > 0) {

            System.out.println("Hand A:  "+handA.size() + "  Hand B: "+handB.size() )  ;

            LinkedList<CardLL> trick = new LinkedList<>();

            CardLL CardA = handA.getFirst();
            handA.removeFirst();
            trick.add(CardA);

            CardLL CardB = handB.getFirst();
            handB.removeFirst();
            trick.add(CardB);

           while (CardA.value == CardB.value) {

               System.out.println("Tie");
               for (int x1 = 0; x1 < 4; x1++ ) {
                   if (handA.size() > 0) {
                       CardA = handA.getFirst();
                       handA.removeFirst();
                       trick.add(CardA);
                   }
                   if (handB.size() > 0) {
                       CardB = handB.getFirst();
                       handB.removeFirst();
                       trick.add(CardB);
                   }
               }
               //loop again if CardA = CardB
           }


           for (CardLL c: trick)
              if (CardA.value > CardB.value)
                    handA.addLast(c);
                    else
                    handB.addLast(c);


        }
        System.out.println("Winner");
        System.out.println("A "+handA.size());
        System.out.println("B "+handB.size());

    }


    private static LinkedList<CardLL> buildDeck()
    {
        String[] suits = {"H", "D", "C", "S"};
        String[] names = {"0", "1", "two", "three", "four", "five", "six", "seven", "eight",
                "nine", "ten", "jack", "queen", "king", "ace"};

        int i = 0;
        LinkedList<CardLL> deck = new LinkedList<>();

        for (String s : suits)
            for (int v = 2; v <= 14; v++)
            {
                CardLL c = new CardLL();
                c.suit = s;
                c.name = names[v];
                c.value = v;

                deck.add(c);
                i++;
            }
        return deck;
    }

    private static void displayDeck(LinkedList<CardLL> deck)
    {
        for (CardLL c : deck)
            System.out.println(c.value + "\t" +c);
    }

    private static void shuffleDeck(LinkedList<CardLL> deck)
    {
        for (int x = 0 ; x< 1000; x++) {
            int i = (int) (Math.random() * deck.size());
            int j = (int) (Math.random() * deck.size());

            CardLL temp1 = deck.get(i);
            CardLL temp2 = deck.get(j);

            deck.set(i, temp2);
            deck.set(j, temp1);
     //       System.out.println("swapping " + i + "for " + j);

        }

    }

    private static LinkedList<CardLL> dealHand(LinkedList<CardLL> deck, int a)
    {
        LinkedList<CardLL> hand = new LinkedList<>();

        for (int i = 0 ; i < deck.size() ; i++)
        {
            if ((i%2) == a)
            {
                hand.add(deck.get(i));
                i++;
            }
        }
        return hand;
    }

}