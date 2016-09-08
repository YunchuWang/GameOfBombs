package game;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferStrategy;

import javax.swing.JPanel;

import mapCollection.GridConstants;
import mapCollection.IceMap;
import mapCollection.Map;
import characterCollection.Player;
import characterCollection.PlayerOne;

public class Game extends Canvas implements Runnable, KeyListener{
	
	Player p1;
	Map map;
	public BufferStrategy strategy;
	boolean gameRunning;
	public static int gridWidth;
	public static int gridHeight;
	public static int maxWidth;
	public static int maxHeight;
	
	public Game(Map map) {
		this.p1 = new PlayerOne(gridWidth * .9,gridHeight * .9);
		this.map = map;
		
		gameRunning = true;
		setBackground(Color.BLUE); 
	    addKeyListener(this);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int keyCode = e.getKeyCode();
	    if (keyCode == KeyEvent.VK_LEFT) 
	    	p1.moveLeft();
	    else if (keyCode == KeyEvent.VK_RIGHT)
	    	p1.moveRight();
	    else if (keyCode == KeyEvent.VK_UP)
	    	p1.moveUp();
	    else if (keyCode == KeyEvent.VK_DOWN)
	    	p1.moveDown();
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		int keyCode = e.getKeyCode();
//	    int d;
	    if (keyCode == KeyEvent.VK_LEFT) 
	    	p1.setDx(0);
	    else if (keyCode == KeyEvent.VK_RIGHT)
	    	p1.setDx(0);
	    else if (keyCode == KeyEvent.VK_UP)
	    	p1.setDy(0);
	    else if (keyCode == KeyEvent.VK_DOWN)
	    	p1.setDy(0);
		
	}
	@Override
	public void run() {
		long lastLoopTime = System.nanoTime();
		final int TARGET_FPS = 60;
		final long OPTIMAL_TIME = 1000000000 / TARGET_FPS;   
		while(gameRunning) {
			
			long now = System.nanoTime();
		    long updateLength = now - lastLoopTime;
		    lastLoopTime = now;
		    double delta = updateLength / ((double)OPTIMAL_TIME);

		    // update the game logic
		    updateAll(delta,map);
		    //draw graphics 
		    render();
	        try {
	        	Thread.sleep( (lastLoopTime-System.nanoTime() + OPTIMAL_TIME)/1000000);
	        } catch (Exception ex) {}
		}
	}

	private void updateAll(double delta, Map map) {
		// TODO Auto-generated method stub
		p1.update(delta,map);
		
	}

	private void render() {
		// TODO Auto-generated method stub
		Graphics g = strategy.getDrawGraphics();
	    g.setColor(Color.CYAN);
	    g.fillRect(0,0,Game.maxWidth,Game.maxHeight);
	    g.setColor(Color.RED);
	    int[][] grids = map.getGrids();
	    for(int i = 0; i < grids.length; i++) {
	    	for(int j = 0; j < grids[0].length; j++) {
	    		if(grids[i][j] == GridConstants.BRICK) {
	    			g.fillRect(j * Game.gridWidth, i * Game.gridHeight, Game.gridWidth, Game.gridHeight);
	    		}
	    	}
	    }
	    g.setColor(Color.gray);
	    Rectangle2D.Double player = new Rectangle2D.Double(p1.getX(), p1.getY(), p1.getWidth(), p1.getHeight());
//	    g.fillRect(p1.getX(), p1.getY(), p1.getWidth(), p1.getHeight());
	    ((Graphics2D) g).fill(player);
	    g.dispose();
	    strategy.show();
		
	}
	
}
