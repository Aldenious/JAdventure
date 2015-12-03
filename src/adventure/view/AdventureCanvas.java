package adventure.view;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;

import adventure.model.Game;
import adventure.model.RoomSection;

public class AdventureCanvas extends Canvas
{
	private final Game game;
	RoomSection View;
	
	public AdventureCanvas(Game game) 
	{
		this.game = game;
		this.View = game.getPlayer().getViewing();
		setSize(new Dimension(View.getSizeX(),View.getSizeY()));
		GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
	}
	
	public void paint(Graphics g) 
	{	
		View = game.getPlayer().getViewing();
		g.setColor(Color.BLACK);
		g.fillRect(0,0,View.getSizeX(),View.getSizeY());
		View.draw(g);
	}
	
	@Override
    public Dimension getPreferredSize() {
    	return new Dimension(View.getSizeX(), View.getSizeY());
    }
}
