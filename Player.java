import java.util.*;

public class Player {
    /*fields for the player*/
    
    private String name;
    private Card[]cards;
    private int cardCount;
    
    //Player constructor - initializes fields and array for storing the cards

    public Player(String name) {
        this.name = name;
        this.cards = new Card[Blackjack.MAX_CARDS_PER_PLAYER];
        this.cardCount = 0;
    }
    
    //getName - accessor method returns player's name

    public String getName() {
        return this.name;
    }
    
    // getNumCards - accessor method returns number of cards in player's hand
    public int getNumCards() {
        return this.cardCount;
    }
    
    // addCard - adds specified card to player's hand
    
    public void addCard(Card c) {
        if (c == null || cardCount == Blackjack.MAX_CARDS_PER_PLAYER) {
            throw new IllegalArgumentException();
        }
        this.cards[this.cardCount] = c;
        this.cardCount++;
    }
    
    // getCard - returns the Card at the specifified position in the player's hand
    
    public Card getCard(int p) {
        if (this.cards[p] == null) {
            throw new IllegalArgumentException(); 
        }
         return this.cards[p];
    }
   
    // getHandValue - computes and returns the total value of the player's current hand

    public int getHandValue() {
        int total = 0;
        boolean hasAce = false;
        for (int i = 0; i < this.cardCount; i++) {
            if (this.cards[i].isAce()) {
                hasAce = true;
            } else {
                total += cards[i].getValue();
            }
        }
        
        if (hasAce) {
            if ( total < 11 ) {
                total += 11;
            } else {
                total += 1;
            }
        } 
        
        return total;
    }
        
    /* printHand - prints the current contents of the player's hand, followed by the 
     * value of the player's hand
     */
    public void printHand() {
        for (int i = 0; i< this.cardCount; i++) {
            
        System.out.print(this.cards[i]+"  ");
        }
        System.out.println("(value = "+getHandValue()+")");
    }
    
    // hasBlackjack - returns true if player has Blackjack
    
    public boolean hasBlackjack() {
        return (getHandValue()== 21);
    }
    
    // wantsHit - returns true if player wants another hit
    
    public boolean wantsHit(Scanner console, Player opponent) {
        System.out.println("Want another hit, " +this.name +" (y/n)?");
        String choice = console.nextLine();
        return (choice.equals("y") || choice.equals("Y"));
    }
    
    // discardCards - resets game
    
    public void discardCards() {
         for (int i = 0; i < this.getNumCards(); i++ ) {
            this.cards[i] = null;
        }
        this.cardCount = 0; 
    }
    
}
