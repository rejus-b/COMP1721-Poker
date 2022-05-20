package comp1721.cwk2;
import comp1721.cwk2.Card.Rank;
import comp1721.cwk2.Card.Suit;
import java.util.Collections;

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

    public Card deal() throws CardException
    {
        if (cards.size() == 0) 
        {
            throw new CardException("No cards in deck");
        }
        else{
            return cards.remove(0);
        }
    }

    public void shuffle()
    {
        Collections.shuffle(cards);
    }

}
