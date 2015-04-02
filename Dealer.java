import java.util.*;

public class Dealer extends Player {
    private boolean revealCard;
    
    /* 
     * constructor - calls constructor from Player with boolean that should
     * not be revealed at start of given round
     */
    public Dealer() {
        super ("dealer");
        this.revealCard = false; 
    }
    
    /*
     * revealFirstCard - changes the value of the called object's boolean field 
     * to indicate that the dealer's first card should now be revealed
     */
    public void revealFirstCard() {
        this.revealCard = true;
    }
    
    /* 
     * printHand - overrides inherited method and prints out XX in place of the
     * dealer's first hand while the rest are printed out.
     */
    public void printHand () {
        if( revealCard == false) { 
            System.out.print("XX");
            for(int i=1; i < super.getNumCards(); i++) {
                System.out.print("  "+super.getCard(i));  
            }
            System.out.println();
       } else {
            super.printHand();
        }
    }
    
    /* wantsHit - overrides inherited method and determine if the dealer 
     * should give herself another hit
     */
    public boolean wantsHit(Scanner console, Player user) {
        return (getHandValue() <21 && user.getHandValue() < 21 && getHandValue() > 17 
                    && user.getHandValue() > 17 && getHandValue() < user.getHandValue()
               || getHandValue() <17 
               && user.getHandValue() > getHandValue());
    }
        

    /* discardCards - overrides inherited method and reset the called object's 
     * boolean field to its original value
     */
    public void discardCards() {
        this.revealCard = false;
        super.discardCards();
    }
}

