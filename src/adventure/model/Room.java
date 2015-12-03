package adventure.model;

import java.awt.Image;

public class Room {
	private final String name;
	private final int sizeX, sizeY; // defines the height and length of a room
									// when viewed
	// from any given view.
	private final Image background; // This is the default backdrop of a room,
									// all walls are
	// painted with this.
	private final RoomSection[] sections; // This defines the number of
											// 'Sections' a given

	// i.e. the amount of views contained in it,
	// typically four: n,s,e,w.

	/*
	 * This allows a variable number of room section in the model Typically not
	 * used, and shouldn't be attempted without testing Instead, use the defined
	 * four sections model.
	 */
	public Room(String name, Image background, RoomSection[] sections) {
		this.name = name;
		this.sizeX = background.getWidth(null);
		this.sizeY = background.getHeight(null);
		this.background = background;
		this.sections = sections;
	}

	// test method for creating blank rooms, with room sections containing no
	// items
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
	
	public int getSectionIndex(RoomSection section)
	{
		int i = 0;
		for (RoomSection s: sections)
		{
			if (s == section)
				return i;
			i++;
		}
		return -1;
		
	}

	public String getName() {
		return name;
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

	public RoomSection[] getSections() {
		return sections;
	}

}
