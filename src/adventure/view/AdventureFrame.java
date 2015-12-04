package adventure.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

import adventure.model.Game;

public class AdventureFrame extends JFrame {
	private final AdventureCanvas canvas;

	public AdventureFrame(String title, Game game, MouseListener mouse,
			KeyListener... keys) {
		super(title);

		canvas = new AdventureCanvas(game);
		setLayout(new BorderLayout());
		if (keys != null) {
			for (KeyListener k : keys) {
				canvas.addKeyListener(k);
			}
		}
		canvas.addMouseListener(mouse);
		add(canvas, BorderLayout.CENTER);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Display window
		setVisible(true);
		canvas.requestFocus();
	}

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
