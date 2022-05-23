package comp1721.cwk2;

// Implement PokerHand class here

public class PokerHand extends CardCollection
{
    protected static final int FULL_SIZE = 5;

    public PokerHand()
    {
        // Super to initialise the deck in card collection 
        super();
    }
    
    public PokerHand(String chosenCards) throws CardException
    {
        // Super to initialise the deck in card collection 
        super();
        // Assign a string array that consists of the user input cards
        String[] fiveHand = chosenCards.split(" ");

        // For every card in a hand, parse it as a new card
        for (String card : fiveHand)
        {
            Card newCard = new Card(card);
            add(newCard);   
        }
    }

    @Override
    public void add(Card card) 
    {
        // If a card being added already exists, throw exception
        if (cards.contains(card))
        {
            throw new CardException("Adding a duplicate card");
        }
        // If your hand is full, throw exception
        else if (cards.size() == FULL_SIZE)
        {
            throw new CardException("Adding to a full deck");
        }
        // Add a new card to your hand
        else{
            super.add(card);   
        }
    }

    @Override
    public String toString()
    {
        // Initialised as size 14 as that would be the max length of any valid poker hand
        StringBuilder fiveHand = new StringBuilder(14);
        // Loop through every card to convert it to a string
        for (Card card : cards)
        {
            // If the size of the hand is only 1 then append it to a stringBuilder and do nothing
            if (cards.size() == 1)
            {
                fiveHand.append(card.toString());
            }
            // If the size of hand is > 1 format it to include spaces after each card
            else
            {
                fiveHand.append(String.format("%s", cards.get(cards.indexOf(card))));
                // If the final card is reached, do not append a whitespace 
                if (cards.size() - 1 != cards.indexOf(card))
                {
                    fiveHand.append(" ");
                }
                
            }
        }
        // Return the string of a hand
        return fiveHand.toString();
    }

    @Override
    public void discard() throws CardException
    {
        // If the hand is empty, throw an exception
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
        // If the hand is empty, throw an exception
        if (cards.size() == 0)
        {
            throw new CardException("Discarding an empty deck");
        }
        // Loop through every card in your hand and add it to a deck
        else
        {
            for (Card card : cards)
            {
                deck.add(cards.remove(0));
            }
            // Remove the final card and add to the deck
            deck.add(cards.remove(0));
        }
    }  

    public boolean isPair()
    {
        // If the hand is not full, throw an exception
        if (cards.size() != 5)
        {
            return false;
        }
        
        // For every card in the hand check if two card ranks are equal
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

        // Check that there is only a single pair found 
        if (checkPair == 1)
        {
            return true;
        }
        return false;
    }

    public boolean isTwoPairs()
    {
        // If the hand is not full, throw an exception
        if (cards.size() != 5)
        {
            return false;
        }
        
        // For every card in the hand check if two card ranks are equal
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
        
        // Check that there is two pairs exactly
        if (checkTwoPair == 2)
        {
            return true;
        }
        return false;
    }

    public boolean isThreeOfAKind()
    {
        // If the hand is not full, throw an exception
        if (cards.size() != 5)
        {
            return false;
        }
        
        // For every card in the hand check if three card ranks are equal
        int checkThreeOfAKind = 0;
        for(Card card : cards)
        {
            if (cards.indexOf(card) + 2 < cards.size())
            {
                Card cardOne = cards.get(cards.indexOf(card));
                Card cardTwo = cards.get(cards.indexOf(card) + 1);
                Card cardThree = cards.get(cards.indexOf(card) + 2);
                // If the first two cards, or the last two cards have the same rank then increment count 
                if (cardOne.getRank() == cardTwo.getRank() ||
                cardTwo.getRank() == cardThree.getRank())
                {
                    checkThreeOfAKind ++;
                }
            }
        }
        
        // An ordered three pair would have a count of 2 exactly
        if (checkThreeOfAKind == 2)
        {
            return true;
        }
        return false;
    }

    public boolean isFourOfAKind()
    {
        // If the hand is not full, throw an exception
        if (cards.size() != 5)
        {
            return false;
        }
        
        // For every card in the hand check if the 1st card and 4th card are equal rank
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
        
        // If there is a four of a kind found return true
        if (checkFourOfAKind == 1)
        {
            return true;
        }
        return false;
    }

    public boolean isFullHouse()
    {
        // If the hand is not full, throw an exception
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
                if (cardFour.getRank() != cardTwo.getRank() &&
                cardFive.getRank() != cardOne.getRank())
                {
                    checkFullHouse = 1;
                }
            }
        }

        if (checkFullHouse == 1)
        {
            return true;
        }
        return false;
    }

    public boolean isFlush()
    {
        // If the hand is not full, throw an exception
        if (cards.size() != 5)
        {
            return false;
        }
        
        Card cardOne = cards.get(0);
        Card cardTwo = cards.get(1);
        Card cardThree = cards.get(2);
        Card cardFour = cards.get(3);
        Card cardFive = cards.get(4);

        if (cardOne.getSuit() == cardTwo.getSuit() && cardTwo.getSuit() == cardThree.getSuit() &&
        cardThree.getSuit() == cardFour.getSuit() && cardFour.getSuit() == cardFive.getSuit())
        {
            return true;
        }
        return false;
    }

    public boolean isStraight()
    {
        // If the hand is not full, throw an exception
        if (cards.size() != 5)
        {
            return false;
        }

        int cardOne = cards.get(0).getRank().ordinal();
        int cardTwo = cards.get(1).getRank().ordinal();
        int cardThree = cards.get(2).getRank().ordinal();
        int cardFour = cards.get(3).getRank().ordinal();
        int cardFive = cards.get(4).getRank().ordinal();
     
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
                    if (cardFour == 12 && cardFive == 0)
                    {
                        return true;
                    }
                }
            }
        } 
        return false;
    }

} 