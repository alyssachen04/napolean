import java.awt.*;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class GameBoard implements Drawable, Updateable {

	Image testImage, backImage;
	public static final int OFFSET_X = 40, OFFSET_Y = 20;
	 
	// private int numdraws = 0;
	private Deck deck = new Deck();
	private Player one = new Player("Sahana");
	private Player two = new Player("Alyssa");
	private Player three = new Player("Sarah");
	private Player four = new Player("Mr. Hanson");
	private Player five = new Player("McKenna");	
	private Pile middle = new Pile();
	public ArrayList <Player> playerList = new ArrayList <> ();

	private int numdraws = 0;
	
	public GameBoard() {
		playerList.add(one);
		playerList.add(two);
		playerList.add(three);
		playerList.add(four);
		playerList.add(five);
		try {
			testImage = ImageIO.read(new File("images/cards/dj.png"));
			backImage = ImageIO.read(new File("images/cards/b1fv.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		int check = 0;
		do { 
			dealDeck();
			check = checkRoyal();
		while(check != -1);
			// bid();
		// switchCenter();

		for (int i = 0; i < 10; i++) {
			// round();
		}

		//gameOver();
		
	}

	public void checkRoyal(){
		for(int i = 0; i<playerList.size(); i++){
			int count = 0;
			for(int x = 0; x < playerList.get(i).toPlay.size(); x++){
				if(playerList.get(i).toPlay.getCard(x).getValue() >= 11){
					count++;
					break;
				}
			}
			if(count == 0){
				//dealDeck();
			}
		}
	}


	/** @param g Graphics context onto which all Objects in the game
	 * draw themselves.  This should NOT change the Objects
	 */
	public void draw(Graphics g) {
		numdraws++;
		g.setColor(new Color(40, 155, 70));
		g.fillRect(0, 0, 3000, 2000);
		
		// this is just to test drawing a card
		g.drawImage(testImage, 30, 80, null);
		g.drawImage(backImage, 100, 80, null);
		g.drawImage(backImage, 105, 100, null);
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
	
	public void round() {

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

	@Override
	// this update will be called each time the timer in the KlondikeGame
	// goes off.  This will be convenient for animating.
	public void update(ActionEvent a) {
		
		
	}

}
