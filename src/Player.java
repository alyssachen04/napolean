import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;
import java.awt.event.*;

public class Player implements Drawable {
	private Pile toPlay;// This is the Pile of Cards that I will play
  	private Pile capturedCards;// Pile of cards that I have won
	private String name;// This player's name
	
	public Player(String s, int x, int y){
    	this.name = s;
		toPlay = new Pile(x, y); // player's cards
		capturedCards = new Pile(); // royalties captured
	}

  	public String getName() {
    	return name;
	}

	public Pile getToPlay() {
		return toPlay;
	}

	public void addToPlay(Card c){
		toPlay.add(c);
	}

	public boolean increaseBid(int player, int bid) {
		JFrame f = new JFrame();
		String s = "Player " + player + ", would you like to bid? Current bid is " + bid;
		int a = JOptionPane.showConfirmDialog(f, s);

		if (a == JOptionPane.YES_OPTION) {
			return true;
		}
		return false;
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

	@Override
	public void draw(Graphics g) {
		toPlay.draw(g);
	}

   	
}
