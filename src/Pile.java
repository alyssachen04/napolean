
/** A Pile is a collection of cards.  This needs to be
 * Drawable because it will be shown on the GUI. Put code
 * here that ALL Piles share.  The ways in which Piles are 
 * different belong in the subclasses.  The draw method should 
 * be implemented here.  Updateable may have empty implementation.
 * You WILL write subclasses of Pile
 */
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.util.*;

public class Pile implements Drawable, Updateable{
  
  private ArrayList<Card> pile = new ArrayList<>();
  private int x;
  private int y;

  public Pile(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public Pile() {
    x = 0; 
    y = 0;
  }
	// returns the number of Cards left in the Pile
	public int size(){
    return pile.size();
	}

  public void clear(){
    pile.clear();
  }

  public Card getCard(int x){
    if(pile.size()!=0){
      return pile.get(x);
    }
    else{
      return null;
    }
  }

 	/** Randomizes the cards in this deck. 
	* You MUST use the following algorithm:
	* If the size is < 2, return;
	* If the size == 2, "flip a coin", swap if "heads"
	* If the size > 2 repeat the following steps size() * 2 times:
	* select two different indexes (make sure they are different)
	* swap them in the ArrayList
	*/ 
	public void shuffle() {
    int in, ij;
    if (pile.size() == 2) {
      if ((int)(Math.random()*2) == 0) {
        Card x = pile.get(0);
        Card y = pile.get(1);
        pile.set(0, y);
        pile.set(1, x);
      }
    }
    else if (pile.size() > 2) {
      for (int i = 0; i < pile.size()*2; i++) {
        do {
          in = (int)(Math.random()*pile.size());
          ij = (int)(Math.random()*pile.size());
        } while (in == ij);
        Card x = pile.get(in);
        Card y = pile.get(ij);
        pile.set(in, y);
        pile.set(ij, x);
      }
    }
	}

	/**
	 Returns the "top" Card from this Pile, removing it from its data structure
  */

// issue: at deal, all cards are in deck. none in pile
	public Card deal(){
    Card c = null;
    if (pile.size() > 0) {
      c = pile.remove(0);
    }
    return c;
	}

  /**  Adds every Card from p to this Pile
      You should not have to change this method.
  */
  public void addPile(Pile p){
    while(p.size()>0){
      this.add(p.deal());
    }
  }
  
	public void add(Card c) {
    pile.add(c);
	}

  public void remove(int x) {
    pile.remove(x);
  }

	/** This returns a String representation of this Pile.  It should return a String built out of the Cards that the pile contains
	*/

	@Override
	public String toString(){
		String s = "";
    for (Card p : pile) {
      s += p;
      s += "\n";
    }
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