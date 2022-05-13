import java.awt.Graphics;
import java.awt.event.ActionEvent;

/** represents a playing card that can draw itself. */
public class Card implements Drawable, Updateable, Comparable<Card> {
    // need some instance variables
      private int suit;
      private int value;
    
        public Card(int suit, int value){ //constructor to make a card consists of its suit and value
        this.suit = suit;
        this.value = value;
        }
        
      // add getters
      public String getSuit() { //if suit is a given case, return its string name
        switch (suit) {
          case 1: return "Diamonds";
          case 2: return "Hearts"; 
          case 3: return "Spades";
          case 4: return "Clubs";
          default: return "Joker"; // j1; anything else is joker
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