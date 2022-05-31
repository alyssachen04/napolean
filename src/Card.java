import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.lang.Object;

import javax.imageio.ImageIO;

import java.awt.*;
import java.awt.Image;

/** represents a playing card that can draw itself. */
public class Card implements Drawable, Updateable, Comparable<Card>, ImageObserver {
    // need some instance variables
      private int suit;
      private int value;
      private int x;
      private int y;
      private int width;
      private int height;
      static private Image back; 
      private Image front;
      private Rectangle rectangle;
      private boolean selected;
      
      public Card(int suit, int value){ //constructor to make a card consists of its suit and value
        this.suit = suit;
        this.value = value;
        this.selected = false;
        try {
          back = ImageIO.read(new File("images/cards/b1fv.png"));
          width = back.getWidth(null);
          height = back.getHeight(null);
          rectangle = new Rectangle(width, height);
          cardImage();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }

      public void setLocation(int x, int y) {
        this.x = x;
        this.y = y;
        // System.out.println("Just set loc! "+this);
      }

      public void setSelected() {
        selected = true; 
      }

      public boolean pointOnCard(Point p) {
        if (rectangle.contains(p.getX(), p.getY())) {
          return true;
        }
        return false;
      }

      // add getters
      public String getSuit() { //if suit is a given case, return its string name
        switch (suit) {
          case 0: return "Diamonds";
          case 1: return "Hearts"; 
          case 2: return "Spades";
          case 3: return "Clubs";
          default: return "Joker"; // j1; anything else is joker
        }
      }
      // could also use an array and use index to get a suit
    
      public int getValue() {
        return this.value;
      }
      
      public Image cardImage() {
        String s = "images/cards/";
        switch (suit) {
          case 1: s += "h";
                break;
          case 3: s += "c";
                break;
          case 0: s += "d";
                break;
          case 2: s += "s";
                break;
          default: s += "joker";
        }
        
        s += this.value + ".png";

        Image testImage, frontImage;
        // open file then set to front //
        try {
          testImage = ImageIO.read(new File(s));
          if (front == null ) { 
            frontImage = ImageIO.read(new File(s));
            front = frontImage;
          }
          return testImage; 
        } catch (IOException e) {
          System.out.println(s);
          e.printStackTrace();
        }
        return null; 
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
        else if (value == 15) {
          return "Joker";
        }
        s += " of ";
        s += this.getSuit();
        s+=" x: "+x+" y: "+y;
        return s;
      }

      @Override
      public void update(ActionEvent a) {
            // TODO Auto-generated method stub
            
      }

      @Override
      public void draw(Graphics g) {
        System.out.println(this);
        g.drawImage(front, x, y, this);
        if (selected) 
        { 
          Graphics2D g2 = (Graphics2D) g;
          g2.setColor(Color.YELLOW);
          g2.drawRect(x, y, width, height);
        }
      }

      @Override
      public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
        // TODO Auto-generated method stub
        return false;
      }
}