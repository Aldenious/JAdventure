package adventure.model;

import java.awt.Graphics;
import java.awt.Image;

public abstract class GameObject {
	private final Image image; //the objects manifestation in the gameworld
	private final String info; // Stored information on the object
	private int x,y; // object's position in the RoomSection - defined as pixel locations from top left?
	
	public abstract boolean use();

	public GameObject(Image image, String info) {
		this.image = image;
		this.info = info;
	}
	
	public void PrintInfo(){
		// TODO prints the given objects info to somewhere on the GUI for now, just prints to console
		System.out.println(info);
	}

	public void draw(Graphics g)
	{
		g.drawImage(image,x,y,null,null);
	}
	
	// Helper methods
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Image getImage() {
		return image;
	}

	public String getInfo() {
		return info;
	}

	/**
	 * This method returns if a given x and y position intercepts this objects
	 * Bounding box, defined as it's own image. No item should intercept each other
	 * in the world such that when a world is loaded, all positions should contain a
	 * unique object. This is mostly used as a method to facilitate said purpose.
	 * @param x
	 * @param y
	 * @return True/ False based on given X, Y co-ords.
	 */
	public boolean intersects(int x, int y)
	{
		if (x >= this.x && this.x + image.getWidth(null) >= x)
			if (y >= this.y && this.y + image.getHeight(null) >= y)
				return true;
		return false;
	}
}
