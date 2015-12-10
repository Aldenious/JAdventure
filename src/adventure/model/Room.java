package adventure.model;

import java.awt.Image;

/**
 * Room is the main container class for Adventure It contains the definition of
 * the Room the player is currently playing in, but importantly, not the view of
 * the current section the player is looking at. Room Serves to link up
 * individual RoomSections into a coherent "Room"
 * 
 * @author Aidan
 *
 */
public class Room {
	private final String name;
	private final int sizeX, sizeY; // defines the height and length of a room
									// when viewed
	// from any given view.
	private final Image background; // This is the default backdrop of a room,
									// all walls are
	// painted with this.
	private RoomSection[] sections; // This defines the number of
									// 'Sections' a given

	// i.e. the amount of views contained in it,
	// typically four: n,s,e,w.

	/**
	 * This Constructor allows the ability to construct a room using a variable
	 * number of sections, individualized contents of those sections, and the
	 * ability to define a default background to this room.
	 * 
	 * @param name
	 *            Names this room
	 * @param background
	 *            Default Background image of the given RoomSections
	 * @param sections
	 *            Array of all potential RoomSections inside this room.
	 */
	public Room(String name, Image background, RoomSection[] sections) {
		this.name = name;
		this.sizeX = background.getWidth(null);
		this.sizeY = background.getHeight(null);
		this.background = background;
		this.sections = sections;
	}

	/**
	 * This constructor generates a blank room, devoid of objects This is a test
	 * constructor to test
	 * 
	 * @param background
	 *            background of this test room
	 */
	public Room(Image background) {
		this.name = "test";
		this.sizeX = background.getWidth(null);
		this.sizeY = background.getHeight(null);
		this.background = background;
		this.sections = new RoomSection[] {
				new RoomSection("test", background),
				new RoomSection("test", background),
				new RoomSection("test", background),
				new RoomSection("test", background) };

	}

	/**
	 * This function takes a RoomSection and tests to see if the room section is
	 * contained within the room. This is used by world to identify the index of
	 * a given section. It returns -1 if the RoomSection is not contained in
	 * this room.
	 * 
	 * @param section
	 *            a generic RoomSection to be indexed
	 * @return i The index of the RoomSection if contained in this Room, else -1
	 */
	public int getSectionIndex(RoomSection section) {
		int i = 0;
		for (RoomSection s : sections) {
			if (s == section)
				return i;
			i++;
		}
		return -1;

	}

	/**
	 * Returns the name of this room
	 * 
	 * @return name of Room
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns the default horizontal size of the room, given by it's default
	 * background
	 * 
	 * @return Horizontal size of room by default, measured in pixels.
	 */
	public int getSizeX() {
		return sizeX;
	}

	/**
	 * Returns the default Vertical size of the room, given by it's default
	 * background
	 * 
	 * @return Vertical size of room by default, measured in pixels.
	 */
	public int getSizeY() {
		return sizeY;
	}

	/**
	 * Returns the default background image of Room
	 * 
	 * @return Default Background
	 */
	public Image getBackground() {
		return background;
	}

	/**
	 * Returns the array of RoomSections Contained in this room
	 * 
	 * @return Array of RoomSection
	 */
	public RoomSection[] getSections() {
		return sections;
	}

	/**
	 * Sets the array of RoomSection to a given array of RoomSections NOTE: THIS
	 * SHOULD ONLY BE USED AT WORLD CREATION, OR ANYOTHER TIME A ROOM HAS TO
	 * CHANGE.
	 * 
	 * @param sections
	 * 
	 */
	public void setSections(RoomSection[] sections) {
		this.sections = sections;
	}

}
