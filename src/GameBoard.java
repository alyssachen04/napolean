import java.awt.*;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;

public class GameBoard implements Drawable, Updateable {

	Image testImage, backImage;
	public static final int OFFSET_X = 40, OFFSET_Y = 40;
	
	Image napoleanLogo;
	Image card1;

	// private int numdraws = 0;
	private Deck deck = new Deck();
	private Player one = new Player("Sahana", 50, 10);
	private Player two = new Player("Alyssa", 135, 10);
	private Player three = new Player("Sarah", 215, 10);
	private Player four = new Player("Mr. Hanson", 295, 10);
	private Player five = new Player("McKenna", 375, 10);	
	private Pile middle = new Pile(500, 10);
	public ArrayList <Player> playerList = new ArrayList <> ();
	private int bid = 0; // number napoleon + secretary need to win; compare NAPOLEON.captured + SECRETARY.captured to this later to figure out who wins 
	private int napolean = 0; 
	// private Player nPlayer;

	private int numdraws = 0;
	
	public GameBoard() {
		playerList.add(one);
		playerList.add(two);
		playerList.add(three);
		playerList.add(four);
		playerList.add(five);
		try {
			testImage = ImageIO.read(new File("images/cards/joker15.png"));
			backImage = ImageIO.read(new File("images/cards/b1fv.png"));
			card1 = ImageIO.read(new File ("images/cards/card1.png"));
			napoleanLogo = ImageIO.read(new File("images/cards/napolean_logo.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		//int testa = 0;
		int check = 0;
		do { 
			deck.shuffle();
			dealDeck();
			check = checkRoyal();
			//testa++;
		} while(check != -1);
		
	}

	public void playGame(){
		bid = bid();
		switchCenter(playerList.get(napolean), middle);

		/*for (int i = 0; i < 10; i++) {
			// round();
		}

		//gameOver(); */
	}

	public int checkRoyal(){
		for(int i = 0; i < playerList.size(); i++){
			int count = 0;
			for(int x = 0; x < playerList.get(i).toPlay.size(); x++){
				if(playerList.get(i).toPlay.getCard(x).getValue() >= 11){
					count++;
					break;
				}
			}
			if(count == 0){
				deck = new Deck();
				one.toPlay.clear();
				two.toPlay.clear();
				three.toPlay.clear();
				four.toPlay.clear();
				five.toPlay.clear();
				return count;
			}
		}
		return -1; // all have royalties 
	}


	/** @param g Graphics context onto which all Objects in the game
	 * draw themselves.  This should NOT change the Objects
	 */
	public void draw(Graphics g) {
		numdraws++;
		g.setColor(new Color(60, 200, 150));
		g.fillRect(0, 0, 3000, 2000);
		
		// this is just to test drawing a card
		//g.drawImage(testImage, 30, 80, null);
		//g.drawImage(backImage, 100, 80, null);
		//g.drawImage(backImage, 105, 100, null);
		
		one.draw(g);
		two.draw(g);
		three.draw(g);
		four.draw(g);
		five.draw(g);
		middle.draw(g);
		// g.drawImage(card1, 300, 200, null);
		g.drawImage(napoleanLogo, 800, 300, null);
	}


	/**
	 * This method is called by the game when a click has been made 
	 * on the panel.  Must determine if the click makes sense (is it 
	 * a valid location, If it is the first click, then note it and
	 * the next click will attempt a move (maybe).
	 * @param me
	 */
	public void justClicked(MouseEvent me) {
		Point p = me.getPoint();
		System.out.println("You just clicked "+p);
	}
	
	public int round() {
		ArrayList<Card> round = new ArrayList<>();
		// put cards in
		// ask every player for a card & then add card to round
		// if (3, )

		int a = highestCard(round);
		return a;
	}

	private int highestCard(ArrayList<Card> round) {
		int a = 0;
		for (int i = 1; i < round.size(); i++) {
			if (round.get(i).compareTo(round.get(a)) == 1 ){
				a = i; //round.get(i);
			}
		}
		return a;
	}

	public void dealDeck() {
		for (int i = 0; i < 10; i++) {
			one.toPlay.add(deck.deal());
			two.toPlay.add(deck.deal());
			three.toPlay.add(deck.deal());
			four.toPlay.add(deck.deal());
			five.toPlay.add(deck.deal());
		}
		middle.addPile(deck);
	}

	public void switchCenter(Player Napoleon, Pile middle) {
		/*
		show middle and napoleon cards
		click one, highlight
		click two, swap
		make a done button
		when done, 

		middle and napolean
		*/
		int pick = 0; 
		int swap = 0;
		Card c = middle.getCard(pick);
		middle.remove(pick);
		Napoleon.toPlay.add(c);
		Napoleon.toPlay.remove(swap);
		middle.add(c);
	}

	public int bid() {
		boolean oneTrue = true;
		boolean twoTrue = true;
		boolean threeTrue = true;
		boolean fourTrue = true;
		boolean fiveTrue = true;
		boolean oneBid, twoBid, threeBid, fourBid, fiveBid;
		int currentBid = 9;
		int winningPlayer = 0;
		while (currentBid < 16 && howManyTrue(oneTrue, twoTrue, threeTrue, fourTrue, fiveTrue)) {
			if (oneTrue) { 
				oneBid = one.increaseBid(1, currentBid); 
				//System.out.println("OneTrue is " + oneTrue);
				if (oneBid) {
					currentBid++;
					//System.out.println("Player one current bid: " + currentBid);
					winningPlayer = 1;
				}
				else {
					oneTrue = false;
				}
			}
			if (twoTrue) { 
				twoBid = one.increaseBid(2, currentBid); 
				if (twoBid) {
					currentBid++;
					winningPlayer = 2;
				}
				else {
					twoTrue = false;
				}
			}
			if (threeTrue) { 
				threeBid = one.increaseBid(3, currentBid); 
				if (threeBid) {
					currentBid++;
					winningPlayer = 3;
				}
				else {
					threeTrue = false;
				}
			}
			if (fourTrue) { 
				fourBid = one.increaseBid(4, currentBid); 
				if (fourBid) {
					currentBid++;
					winningPlayer = 4;
				}
				else {
					fourTrue = false;
				}
			}
			if (fiveTrue) { 
				fiveBid = one.increaseBid(5, currentBid); 
				if (fiveBid) {
					currentBid = currentBid++;
					winningPlayer = 5;
				}
				else {
					fiveTrue = false;
				}
			}
		}
		napolean = winningPlayer;
		System.out.println("Napolean is " + napolean);
		return currentBid;
	}

	private boolean howManyTrue(boolean one, boolean two, boolean three, boolean four, boolean five) {
		int count = 0;
		if (one) {
			count++;
		}
		if (two) {
			count++;
		}
		if (three) {
			count++;
		}
		if (four) {
			count++;
		}
		if (five) {
			count++;
		}
		return (count != 1);
	}

	@Override
	// this update will be called each time the timer in the KlondikeGame
	// goes off.  This will be convenient for animating.
	public void update(ActionEvent a) {
		
	}

}
