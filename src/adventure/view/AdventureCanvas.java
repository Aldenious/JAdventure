package adventure.view;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;

import adventure.model.Game;
import adventure.model.RoomSection;

/**
 * AdventureCanvas provides the actual graphics panel to draw and house the
 * graphics for adventure. It is responsible for reporting to it's
 * AdventureFrame the size of the graphics, as well as providing the methods for
 * the individual graphical sections contained in the game model to print each
 * individual object.
 * 
 * @author Aidan
 *
 */
public class AdventureCanvas extends Canvas {
	private final Game game; // Game reference for canvas to draw
	private RoomSection View; // References the current view to draw which is
								// the RoomSection that the player is viewing,
								// inherited from the game.

	/**
	 * Creates and localizes the graphics canvas. Setting the size of the new
	 * canvas to the graphic's minimum size.
	 * 
	 * @param game
	 *            The game model for the canvas to reference for drawing, should
	 *            be Inherited from AdventureFrame.
	 */
	public AdventureCanvas(Game game) {
		this.game = game;
		this.View = game.getPlayer().getViewing();
		setSize(new Dimension(View.getSizeX(), View.getSizeY()));
		GraphicsEnvironment env = GraphicsEnvironment
				.getLocalGraphicsEnvironment();
	}

	/**
	 * Method called whenever any changes to the view may be altered, such as
	 * interacting with objects, or moving around a room. Repaints the
	 * background to be black first of all, in case the background is not
	 * square, then calls view's draw method which recursively draws all other
	 * object's in the RoomSection.
	 */
	public void paint(Graphics g) {
		View = game.getPlayer().getViewing();
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, View.getSizeX(), View.getSizeY());
		View.draw(g);
	}

	/**
	 * This method acts as a way to set the preferred size of the window whenever
	 * AdventureFrame requests the size of AdventureCanvas.
	 */
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(View.getSizeX(), View.getSizeY());
	}
}
