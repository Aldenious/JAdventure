package adventure.model;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import adventure.model.GameObject;

/**
 * RoomSection is designed to be the main component of the game. A view of the
 * game is restricted only to a individual room section at a time. RoomSection's
 * are designed to be grouped into Rooms, and that you can freely move around
 * from RoomSection to roomSection in a room without any restrictions. Room
 * Sections are thus responsible for anything visual the game may present.
 * 
 * All RoomSections Have to be assigned to a room, Vice Versa, all rooms have to
 * have at least one RoomSection to display anything inside of the room.
 * 
 * @author Aidan
 *
 */
public class RoomSection {
	private final String Name;
	private final int sizeX, sizeY; // defines the height and length of a room
									// when
	// viewed from any given view. Inherited from the background.
	private final Image background; // This is the default backdrop of a room,
									// all walls
	// are painted with this. Inherited from room.
	private ArrayList<GameObject> contains; // this contains list details
											// everything

	// contained in this section, stored as
	// objects.

	/**
	 * Constructor for use in creating blank room sections, for both game and
	 * testing purposes
	 * 
	 * @param name
	 *            Names the RoomSection
	 * @param background
	 *            Background image for the RoomSection
	 */
	public RoomSection(String name, Image background) {
		this.Name = name;
		this.sizeX = background.getWidth(null);
		this.sizeY = background.getHeight(null);
		this.background = background;
		this.contains = new ArrayList<GameObject>();
	}

	/**
	 * Default Constructor, use this to populate the RoomSection! This
	 * Constructor expects individually created RoomSections, including
	 * potentially unique backgrounds. It also expects a ArrayList of the
	 * contents of this section.
	 * 
	 * @param name
	 *            Names the RoomSection
	 * @param background
	 *            Background image for the RoomSection
	 * @param arrayList
	 *            Provides the contents of the RoomSection, as GameObject's
	 */
	public RoomSection(String name, Image background,
			ArrayList<GameObject> arrayList) {
		this.Name = name;
		this.sizeX = background.getWidth(null);
		this.sizeY = background.getHeight(null);
		this.background = background;
		this.contains = arrayList;
	}

	/**
	 * This Constructor is used to define a RoomSection based off the inherited
	 * Image used by the given room. This still expects a ArrayList of objects
	 * in the Section.
	 * 
	 * @param name
	 *            Names the RoomSection
	 * @param room
	 *            Room the inherited attributes of this section are defined by
	 *            Ie, Utilizes this Room's background image.
	 * @param arrayList
	 *            Provides the contents of the RoomSection, as GameObject's
	 */
	public RoomSection(String name, Room room, ArrayList<GameObject> arrayList) {
		this.Name = name;
		this.sizeX = room.getBackground().getWidth(null);
		this.sizeY = room.getBackground().getHeight(null);
		this.background = room.getBackground();
		this.contains = arrayList;
	}

	/**
	 * Draws the RoomSection and the individual contents of the RoomSection This
	 * method is called when updating the player's view, and for every change a
	 * player may make to the view. Ie Walking into a new room, changing
	 * sections or activating objects.
	 * 
	 * @param g 
	 * 		graphic's component, for adventure this is AdventureCanvas.
	 */
	public void draw(Graphics g) {
		g.drawImage(background, 0, 0, null, null);
		if (contains != null) {
			for (GameObject o : contains) {
				o.draw(g);
			}
		}
	}

	/**
	 * Returns the ArrayList of Contents of The RoomSection, specified as
	 * GameObject's
	 * 
	 * @return contains 
	 * 			ArrayList of GameObject's, contents of this current RoomSection
	 */
	public ArrayList<GameObject> getContains() {
		return contains;
	}

	/**
	 * This is used to assign the contents of the RoomSection. THIS SHOULD ONLY
	 * BE USED ON WORLD CREATION, or other times when the room's contents starts
	 * from scratch.
	 * 
	 * @param contains
	 * 		ArrayList of GameObject's, contents of this current RoomSection
	 */
	public void setContains(ArrayList<GameObject> contains) {
		this.contains = contains;
	}

	/**
	 * Return's the horizontal size of the RoomSection, defined by it's
	 * background.
	 * 
	 * @return sizeX
	 * 		 Horizontal size of RoomSection, Measured in Pixels
	 */
	public int getSizeX() {
		return sizeX;
	}

	/**
	 * Return's the vertical size of the RoomSection, defined by it's
	 * background.
	 * 
	 * @return sizeY
	 * 		Vertical size of RoomSection, Measured in Pixels
	 */
	public int getSizeY() {
		return sizeY;
	}

	/**
	 * Returns the background of this RoomSection
	 * 
	 * @return Background image
	 */
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
	// TODO Taking too long, manually create object positions for now.
	// public boolean AddToSection(GameObject object, int Xinsertfrom) {
	// /*
	// * calculate height and width of object, ie calculate top left corner of
	// * image then the maximum x, and the maximum y of the object.
	// */
	// int x = Xinsertfrom, y = object.getImage().getHeight(null) - this.sizeY;
	// int maxX = object.getImage().getWidth(null), maxY = this.sizeY;
	//
	// // test Xbounds
	// if (maxX > this.sizeX)
	// // log a error
	// System.out.println("Adding item failed in section " + this.Name
	// + " due to out of bounds");
	//
	// // Loop till a unique bounding box position is found
	//
	// boolean result = true;
	// for (GameObject other : contains) {
	// // find the other's bounding box
	// int otherMaxY = other.getY() + other.getImage().getHeight(null);
	// int otherMaxX = other.getX() + other.getImage().getWidth(null);
	// if (x < other.getX() && maxX < other.getX() || x > otherMaxX
	// && maxX > otherMaxX) {
	// // placement is allowed, no conflicts
	//
	// }
	// else // there is a object that colides with th
	// }
	// }
}
