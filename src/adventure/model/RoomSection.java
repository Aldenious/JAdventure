package adventure.model;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import adventure.model.GameObject;

public class RoomSection {
	final String Name;
	final int sizeX, sizeY; // defines the height and length of a room when
							// viewed from any given view. Inherited from room.
	final Image background; // This is the default backdrop of a room, all walls
							// are painted with this. Inherited from room.
	ArrayList<GameObject> contains; // this contains list details everything
									// contained in this section, stored as
									// objects.

	/**
	 * Constructor for use in creating blank room sections, for both game and
	 * testing purposes
	 */
	public RoomSection(String name, Image background) {
		this.Name = name;
		this.sizeX = background.getWidth(null);
		this.sizeY = background.getHeight(null);
		this.background = background;
		this.contains = new ArrayList<GameObject>();
	}

	/**
	 * Default Constructor, use this to populate the room section!
	 * 
	 * @param background
	 * @param arrayList
	 */
	public RoomSection(String name, Image background,
			ArrayList<GameObject> arrayList) {
		this.Name = name;
		this.sizeX = background.getWidth(null);
		this.sizeY = background.getHeight(null);
		this.background = background;
		this.contains = arrayList;
	}

	public void draw(Graphics g) {
		g.drawImage(background, 0, 0, null, null);
		if (contains != null) {
			for (GameObject o : contains) {
				o.draw(g);
			}
		}
	}

	public ArrayList<GameObject> getContains() {
		return contains;
	}

	public void setContains(ArrayList<GameObject> contains) {
		this.contains = contains;
	}

	public int getSizeX() {
		return sizeX;
	}

	public int getSizeY() {
		return sizeY;
	}

	public Image getBackground() {
		return background;
	}

	/**
	 * This method adds Object to this Section (Presumed current view while in
	 * game or a given room at world creation) at a given X axis insert, This
	 * allows the game to not concern itself with items placed in front of other
	 * items, as any collisions like this are simply placed ontop of conflicting
	 * items, returning true if successful. Else, it returns false.
	 * 
	 * @param Section
	 * @param Object
	 * @param Xinsertfrom
	 */
	//TODO Taking too long, manually create object positions for now.
//	public boolean AddToSection(GameObject object, int Xinsertfrom) {
//		/*
//		 * calculate height and width of object, ie calculate top left corner of
//		 * image then the maximum x, and the maximum y of the object.
//		 */
//		int x = Xinsertfrom, y = object.getImage().getHeight(null) - this.sizeY;
//		int maxX = object.getImage().getWidth(null), maxY = this.sizeY;
//
//		// test Xbounds
//		if (maxX > this.sizeX)
//			// log a error
//			System.out.println("Adding item failed in section " + this.Name
//					+ " due to out of bounds");
//
//		// Loop till a unique bounding box position is found
//
//		boolean result = true;
//		for (GameObject other : contains) {
//			// find the other's bounding box
//			int otherMaxY = other.getY() + other.getImage().getHeight(null);
//			int otherMaxX = other.getX() + other.getImage().getWidth(null);
//			if (x < other.getX() && maxX < other.getX() || x > otherMaxX
//					&& maxX > otherMaxX) {
//				// placement is allowed, no conflicts
//				
//			}
//			else // there is a object that colides with th
//		}
//	}
}
