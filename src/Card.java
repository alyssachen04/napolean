import java.awt.Graphics;
import java.awt.event.ActionEvent;
//test test testttt
/** represents a playing card that can draw itself. */
public class Card implements Drawable, Updateable, Comparable<Card> {
    // need some instance variables
      private int suit;
      private int value;
    
     /** Must have this constructor.  You can add others*/
        public Card(int suit, int value){
        this.suit = suit;
        this.value = value;
        }
        
      // add getters
      public String getSuit() {
        switch (suit) {
          case 1: return "Diamonds";
          case 2: return "Hearts"; 
          case 3: return "Spades";
          case 4: return "Clubs";
          default: return "Joker";
        }
      }
      // could also use an array and use index to get a suit
    
      public int getValue() {
        return this.value;
      }
    
    
        @Override
        /** This method satisfies the Comparable interface which determines
         * if this Object is smaller than, greater than or equal to the 
         * specified Card c
         * Formally, if this Card is smaller than c, a negative int is returned
         *           if this Card is larger than c, a positive int is returned
         *           if this Card is equal to c, zero is returned	*/
        public int compareTo(Card c){
        int answer = 0;
        if (value > c.getValue()) {
          answer = 1;
        }
        else if (value < c.getValue()) {
          answer = -1;
        }
        return answer;
        }
        
        // represents this Card in the following manner
        // if the card is the Ace of Spades, then 
        // it returns "Ace of Spades". 2 - 10 can be represented
        // as "2 of Hearts" or "Two of Hearts".  Your choice.
        @Override
        public String toString(){
            String s = "";
        if (value < 11) {
          s += value;
        }
        else if (value == 11) {
          s += "Jack";
        }
        else if (value == 12) {
          s += "Queen";
        }
        else if (value == 13) {
          s += "King";
        }
        else if (value == 14) {
          s += "Ace";
        }
        s += " of ";
        s += this.getSuit();
            return s;
        }

        @Override
        public void update(ActionEvent a) {
            // TODO Auto-generated method stub
            
        }

        @Override
        public void draw(Graphics g) {
            // TODO Auto-generated method stub
            
        }
}