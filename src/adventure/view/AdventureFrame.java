package adventure.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

import adventure.model.Game;

/**
 * AdventureFrame is the main component for the View component in MVC. It is
 * responsible for housing, creating, and handling the window specifications of
 * the view. It delagates the actual graphical tasks to be printed to the screen
 * to it's internal AdventureCanvas.
 * 
 * @author Aidan
 *
 */
public class AdventureFrame extends JFrame {
	private final AdventureCanvas canvas; // The actual graphics canvas
											// adventure will draw too.

	/**
	 * Creates a new graphics frame for adventure. THIS SHOULD ONLY BE CALLED BY
	 * WORLD. Instantiates and links up with the model to make sure that it is
	 * displaying the correct information, and creates a new AdventureCanvas to
	 * link to itself, and display the graphics. Finally, it assigns both mouse
	 * and key listeners to the Adventure Canvas to listen to mouse, and key
	 * events. 
	 * 
	 * @param title
	 * 			title for the frame to reference.
	 * @param game
	 * 			the game model for the view to reference and draw.
	 * @param mouse
	 * 			A mouse listener to listen to mouse events on the canvas.
	 * @param keys
	 * 			A key listener to listen to key events on the canvas.
	 */
	public AdventureFrame(String title, Game game, MouseListener mouse,
			KeyListener key) {
		super(title);

		canvas = new AdventureCanvas(game);
		setLayout(new BorderLayout());
		if (key != null && mouse != null) { //safety checks for the listeners
			canvas.addKeyListener(key);
			canvas.addMouseListener(mouse);
		}
		add(canvas, BorderLayout.CENTER);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Display window
		setVisible(true);
		canvas.requestFocus();
	}

	/**
	 * Repaints the graphics, and resizes the screen to contain the size of the
	 * new room being painted It First shifts the screen toward the center of
	 * the display, and then resizes the window so that the window is
	 * Appropriately sized to fit the bounds of the current displayed objects in
	 * a RoomSection Finally, it calls the canvas to redraw it's graphics.
	 */
	public void repaint() {
		// Center window in screen
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension scrnsize = toolkit.getScreenSize();
		setBounds((scrnsize.width - getWidth()) / 2,
				(scrnsize.height - getHeight()) / 2, getWidth(), getHeight());
		setResizable(true);
		pack();

		canvas.repaint();
	}
}
