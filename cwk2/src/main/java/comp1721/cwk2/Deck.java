package comp1721.cwk2;
import comp1721.cwk2.Card.Rank;
import comp1721.cwk2.Card.Suit;

// Implement Deck class here

public class Deck extends CardCollection
{
    public Deck() 
    {

        super();
        
        for (Suit suit : Suit.values())
        {
            for (Rank rank : Rank.values())
            {
                Card card = new Card(rank, suit);
                add(card);
            }
        }
    }

    public int size()
    {
        return 0;
    }
    
    public boolean isEmpty()
    {
        return false;
    }

    public boolean contains()
    {
        return false;
    }

    public void discard()
    {
        
    }

    public Card deal()
    {
        return cards.get(0);
    }

    public void shuffle()
    {

    }

}
