import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.util.*;

/** A Deck is a special kind of Pile that essentially is Initialized to be 
    a complete standard deck of cards with 52 cards.  13 of each suit*/
public class Deck extends Pile{

// no new list because all Piles have a list so new list = second list

  public Deck(){
		initDeck();
	}

	/* Initializes the Cards in this deck, constructing them all and
	 *  placing them into the data structure holding them.*/			
	private void initDeck() {
    for (int i = 0; i < 4; i++) {
      for (int j = 2; j < 15; j++) {
        Card c = new Card(i,j);
        add(c);
      }
    } 
    Card j = new Card(5,1);
    add(j);
  }

    @Override
    public void draw(Graphics g) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void update(ActionEvent a) {
        // TODO Auto-generated method stub
        
    }

}
