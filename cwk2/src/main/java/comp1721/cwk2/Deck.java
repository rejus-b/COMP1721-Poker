package comp1721.cwk2;
import comp1721.cwk2.Card.Rank;
import comp1721.cwk2.Card.Suit;
import java.util.Collections;

// Implement Deck class here

public class Deck extends CardCollection
{
    public Deck() 
    {
        // Super to initialise the deck in card collection 
        super();
        
        // Loop through every suit and rank to populate the deck
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
        // If there are no cards to deal, throw exception
        if (cards.size() == 0) 
        {
            throw new CardException("No cards in deck");
        }
        // Remove and return the first card from the deck
        else{
            return cards.remove(0);
        }
    }

    public void shuffle()
    {
        // Shuffle the deck
        Collections.shuffle(cards);
    }
    
}
