package comp1721.cwk2;
import comp1721.cwk2.Card.Rank;
import comp1721.cwk2.Card.Suit;
import java.util.ArrayList;
// import java.utils.random;

// Implement PokerHand class here

public class PokerHand extends CardCollection
{
    protected static final int FULL_SIZE = 5;
    // private ArrayList<Card> pokerHand = new ArrayList<>();

    public PokerHand()
    {

        super();
        // ArrayList<Card> pokerHand = new ArrayList<>();
        // cards.add()
    }
    
    public PokerHand(String chosenCards)
    {
        // super();
        // private char rank = chosenCards.substring(0,1);
        // private char suit = chosenCards.substring(1); 
        // Card card = new Card(rank, suit);
        // pokerHand.add(card);
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