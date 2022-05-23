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
    public void add(Card card) 
    {
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
    public String toString()
    {
        // Initialised as size 14 as that would be the max length of any valid poker hand
        StringBuilder fiveHand = new StringBuilder(14);
        for (Card card : cards)
        {
            if (cards.size() == 1)
            {
                fiveHand.append(card.toString());
            }
            else
            {
                fiveHand.append(String.format("%s", cards.get(cards.indexOf(card))));
                if (cards.size() - 1 != cards.indexOf(card))
                {
                    fiveHand.append(" ");
                }
                
            }
        }
        return fiveHand.toString();
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
            deck.add(cards.remove(0));
        }
    }  

    public boolean isPair()
    {
        if (cards.size() != 5)
        {
            return false;
        }
        
        int checkPair = 0;
		for(Card card : cards)
		{
            if (cards.indexOf(card) + 1 < cards.size())
            {
                Card cardOne = cards.get(cards.indexOf(card));
                Card cardTwo = cards.get(cards.indexOf(card) + 1);
                if (cardOne.getRank() == cardTwo.getRank())
                {
                    checkPair ++;
                }
            }
        }

        if (checkPair == 1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean isTwoPairs()
    {
       if (cards.size() != 5)
        {
            return false;
        }
        
        int checkTwoPair = 0;
		for(Card card : cards)
		{
            if (cards.indexOf(card) + 1 < cards.size())
            {
                Card cardOne = cards.get(cards.indexOf(card));
                Card cardTwo = cards.get(cards.indexOf(card) + 1);
                if (cardOne.getRank() == cardTwo.getRank())
                {
                    checkTwoPair ++;
                }
            }
        }
        
        if (checkTwoPair == 2)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean isThreeOfAKind()
    {
      if (cards.size() != 5)
        {
            return false;
        }
        
        int checkThreeOfAKind = 0;
		for(Card card : cards)
		{
            if (cards.indexOf(card) + 2 < cards.size())
            {
                Card cardOne = cards.get(cards.indexOf(card));
                Card cardTwo = cards.get(cards.indexOf(card) + 1);
                Card cardThree = cards.get(cards.indexOf(card) + 2);
                if (cardOne.getRank() == cardTwo.getRank() || cardTwo.getRank() == cardThree.getRank())
                {
                    checkThreeOfAKind ++;
                }
            }
        }
        
        if (checkThreeOfAKind == 2)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean isFourOfAKind()
    {
      if (cards.size() != 5)
        {
            return false;
        }
        
        int checkFourOfAKind = 0;
		for(Card card : cards)
		{
            if (cards.indexOf(card) + 3 < cards.size())
            {
                Card cardOne = cards.get(cards.indexOf(card));
                Card cardFour = cards.get(cards.indexOf(card) + 3);
                if (cardOne.getRank() == cardFour.getRank())
                {
                    checkFourOfAKind ++;
                }
            }
        }
        
        if (checkFourOfAKind == 1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean isFullHouse()
    {

      if (cards.size() != 5)
        {
            return false;
        }

        int checkFullHouse = 0;

        Card cardOne = cards.get(0);
        Card cardTwo = cards.get(1);
        Card cardThree = cards.get(2);
        Card cardFour = cards.get(3);
        Card cardFive = cards.get(4);

        if ((cardOne.getRank() == cardTwo.getRank() && cardTwo.getRank() == cardThree.getRank()) ||
        (cardThree.getRank() == cardFour.getRank() && cardFour.getRank() == cardFive.getRank()))
        {
            if ((cardFour.getRank() == cardFive.getRank()) &&
            (cardOne.getRank() == cardTwo.getRank()))
            {
                if (cardFour.getRank() != cardTwo.getRank() && cardFive.getRank() != cardOne.getRank())
                {
                    checkFullHouse = 1;
                }
            }
        }

        if (checkFullHouse == 1)
        {
            return true;
        }
        else
        {
            return false;
        }

    }

    public boolean isFlush()
    {

        if (cards.size() != 5)
        {
            return false;
        }
        
        Card cardOne = cards.get(0);
        Card cardTwo = cards.get(1);
        Card cardThree = cards.get(2);
        Card cardFour = cards.get(3);
        Card cardFive = cards.get(4);

        if (cardOne.getSuit() == cardTwo.getSuit() && cardTwo.getSuit() == cardThree.getSuit() && cardThree.getSuit() == cardFour.getSuit() && cardFour.getSuit() == cardFive.getSuit())
        {
            return true;
        }
        return false;
    }

    public boolean isStraight()
    {
        // Idea is to compare two cards, if their difference is not greater than 1 then it is considered a straight
        if (cards.size() != 5)
        {
            return false;
        }

        int cardOne = Character.getNumericValue(cards.get(0).toString().charAt(0));
        int cardTwo = Character.getNumericValue(cards.get(1).toString().charAt(0));
        int cardThree = Character.getNumericValue(cards.get(2).toString().charAt(0));
        int cardFour = Character.getNumericValue(cards.get(3).toString().charAt(0));
        int cardFive = Character.getNumericValue(cards.get(4).toString().charAt(0));
        
        if (cards.get(0).toString().charAt(0) == 'A')
        {
            cardOne = 1;
        }
        
        if (cardOne - cardTwo == -1)
        {
            if (cardTwo - cardThree == -1)
            {
                if (cardThree - cardFour == -1)
                {
                    if (cardFour - cardFive == -1)
                    {
                        return true;
                    }
                }
            }
        } 

        // Could toString the card to get the character represntation, then convert each one to an int

        return false;
    }

} 