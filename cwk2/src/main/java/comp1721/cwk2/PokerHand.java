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
    }
    
    public PokerHand(String chosenCards) throws CardException
    {
        super();
        String[] fiveHand = chosenCards.split(" ");

        for (String card : fiveHand)
        {
            Card newCard = new Card(card);
                add(newCard);   
        }
    }

    @Override
    public void add(Card card) {
        if (cards.contains(card) == true)
        {
            throw new CardException("Adding a duplicate card");
        }
        else if (cards.size() == FULL_SIZE)
        {
            throw new CardException("Adding to a full deck");
        }
        else{
            super.add(card);   
        }
    }

    @Override
    public void discard() throws CardException
    {
        if (cards.size() == 0)
        {
            throw new CardException("Discarding an empty deck");
        }
        else
        {
            cards.clear();
        }
    }

    public void discardTo(Deck deck) throws CardException
    {
        if (cards.size() == 0)
        {
            throw new CardException("Discarding an empty deck");
        }
        else
        {
            for (Card card : cards)
            {
                deck.add(cards.remove(0));
            }
        }
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