/*
 * Card.java
 *
 * Computer Science 111, Boston University
 * 
 * A blueprint class for objects that represent a single playing card
 * in the game of Blackjack.
 *
 * YOU SHOULD NOT MODIFY THIS FILE.
 */

public class Card {
    /* class constants for the ranks of the cards */
    public static final int FIRST_RANK = 1;
    public static final int LAST_RANK = 13;
    private static final String[] RANK_STRINGS = {"", "A", "2", "3", "4", "5", 
      "6", "7", "8", "9", "10", "J", "Q", "K"};
    private static final int ACE = 1;
    private static final int JACK = 11;
    private static final int QUEEN = 12;
    private static final int KING = 13;
    
    /* class constants for the suits of the cards */
    public static final int FIRST_SUIT = 0;
    public static final int LAST_SUIT = 3;
    private static final String[] SUIT_STRINGS = {"C", "D", "H", "S"};
    
    /* fields for this card */
    private int rank;   // stored as an int. rankString[rank] gives the string for the rank
    private int suit;   // stored as an int. suitString[suit] gives the string for the suit

    /*
     * Card constructor
     */
    public Card(int rank, int suit) {
        this.rank = rank;
        this.suit = suit;
    }

    /*
     * getValue - returns the value of the card.
     * 
     * Returns a 10 for face cards, and the rank for all other cards.
     * Note that this means that it will return 1 for Aces.
     * Your Player getValue() method will need to account for
     * cases in which the Ace should have a value of 11.
     */
    public int getValue() {
        if (this.isFaceCard()) {
            return 10;
        } else {
            return this.rank;
        }
    }
    
    /*
     * isAce - returns true if this card is an Ace, and false otherwise
     */
    public boolean isAce() {
        return (this.rank == ACE);
    }

    /*
     * isFaceCard - returns true if this card is a face card 
     * (Jack, Queen, or King), and false otherwise
     */
    public boolean isFaceCard() {
        return (this.rank == JACK || this.rank == QUEEN || this.rank == KING);
    }
    
    /*
     * toString - returns a String representation of this card.
     * For example, "2C" for a 2 of clubs, or "KH" for a King of hearts.
     */
    public String toString() {
        return (RANK_STRINGS[this.rank] + SUIT_STRINGS[this.suit]);
    }
}
