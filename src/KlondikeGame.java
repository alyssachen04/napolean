import java.awt.*;
import java.awt.Graphics;
import java.awt.event.*;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/** for simplicity's sake i'm keeping it as Klondike Game but it's Napolean */
public class KlondikeGame {
	//#region vars
	public static final int width = 50;
	public static final int height = 78;
	public static final double gap = width * 0.4; //20 in this case
	public static final int DELAY_INTERVAL = 50, INIT_W = 1000, INIT_H = 500; //init_w once 1000, init_h once 800
	private JFrame frame = new JFrame("Klondike");
	private JPanel panel;
	private final Dimension DIM = new Dimension(INIT_W,INIT_H);
	private GameBoard board = new GameBoard();
	private Timer timer = new Timer(1000, null);
	//#endregion vars
	
	public static void main(String[] args) {
		new KlondikeGame().start();
	}

	private void start() {
		panel = new JPanel() {
			@Override 
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				// System.out.println("look at the new view!!");
				board.draw(g);
			}
		};
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent me) {
				clickedAt(me);
			}
		});
		panel.setPreferredSize(DIM);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
		timer.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				board.update(e);
				panel.repaint();
			}
		});
		board.playGame();
	}

	protected void clickedAt(MouseEvent me) {
		board.justClicked(me);
		//System.out.println("mouse was clicked");
		panel.repaint();
	}

}