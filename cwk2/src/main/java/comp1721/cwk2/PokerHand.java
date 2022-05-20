package comp1721.cwk2;
import comp1721.cwk2.Card.Rank;
import comp1721.cwk2.Card.Suit;
import java.util.ArrayList;
// import java.utils.random;

// Implement PokerHand class here

public class PokerHand extends CardCollection
{
    protected static final int FULL_SIZE = 5;
    //private ArrayList<String> fiveHand = new ArrayList<>();

    public PokerHand()
    {
        super();
        // fiveHand = 

    }
    
    public PokerHand(String chosenCards) throws CardException
    {
        super();
        String[] fiveHand = chosenCards.split(" ");

        for (String card : fiveHand)
        {
            Card newCard = new Card(card);
            if (cards.contains(newCard) == true)
            {
                throw new CardException("Adding a duplicate card");
            }
            
            if (cards.size() == FULL_SIZE)
            {
                throw new CardException("Adding to a full deck");
            }
            add(newCard);
        }

        // for (int i = 0; i < fiveHand.length; i += 2)
        // {
        //     // System.out.println(fiveHand[i]);
        //     Rank.rank(fiveHand[i]);
        //     Suit.suit(fiveHand[i+1]);
        //     Card card = new Card(rank, suit);
        //     pokerHand.add(card);
        // }
    }

    // // public String toString()
    // // {
    // //     return("NULL");
    // // }

    // // public int size()
    // // {
    // //     return 0;
    // // }

    // public void discard()
    // {
        
    // }

    public void discardTo(Deck deck)
    {
       
    }  

    public boolean isPair()
    {
        return false;
    }

    public boolean isTwoPairs()
    {
        return false;
    }

    public boolean isThreeOfAKind()
    {
        return false;
    }

    public boolean isFourOfAKind()
    {
        return false;
    }

    public boolean isFullHouse()
    {
        return false;
    }

    public boolean isFlush()
    {
        return false;
    }

    public boolean isStraight()
    {
        return false;
    }

} 