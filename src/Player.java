import java.util.ArrayList;

public class Player {
	Pile toPlay;// This is the Pile of Cards that I will play
  	private Pile capturedCards;// Pile of cards that I have won
	private String name;// This player's name

	public Player(String s){
    	this.name = s;
		toPlay = new Pile(); // player's cards
		capturedCards = new Pile(); // royalties captured
	}

  	public String getName() {
    	return name;
  	}

	/** Don't need to change this*/
	public Card getCard(){
		// make sure there's a card to play
		if(toPlay.size()<=0) {
			return null; 
		}
		// let player pick card
		return pick();
	}
	
	private Card pick() {
		// show cards
	//	for (Card c: toPlay) {

	//	}
		return null;
	}

	public void addCard(Card c){
		capturedCards.add(c);
	}
  	public void add(Pile p){
    	while (p.size() > 0) {
      		addCard(p.deal());
    	}
  	}

	// leave the method below alone
	public int cardsLeft(){
		return capturedCards.size()+toPlay.size();
	}

   	
}
