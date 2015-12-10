package adventure.data;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import adventure.model.Door;
import adventure.model.Furniture;
import adventure.model.GameObject;
import adventure.model.Game;
import adventure.model.Player;
import adventure.model.Room;
import adventure.model.RoomSection;
import adventure.view.AdventureFrame;

/**
 * World is the Main controller class for this project.
 * It is also the "world" of this project, and is needed to create and assign
 * a world for the user. The world loads this into the game model, and runs the
 * game from there.
 * @author Aidan
 *
 */
public class World implements KeyListener, MouseListener {
	private final Game game;
	private final AdventureFrame frame;
	private Player player;
	private final static Image brickWall = loadImage("Brick_Wall.jpg");
	private final static Image woodTable = loadImage("wood_table.jpg");
	private final static Image woodWall = loadImage("wood_wall.jpg");
	private final static Image WoodDoor = loadImage("Wood_Door.jpg");
	
	/**
	 * This constructor is used to define what world is being utilized.
	 * To change the active world, change the game defined here.
	 */
	public World()
	{
		game = BasicGame();
		frame = new AdventureFrame("game", game, this, this);
		player = game.getPlayer();
	}
	
	// World definitions
	
	/**
	 * Test world, use to prove world creation and GUI.
	 * @return a test Game()
	 */
	public static Game BlankRoom()
	{
		ArrayList<Room> rooms = new ArrayList<Room>();
		rooms.add(new Room(brickWall));
		return new Game(rooms, new Player(rooms.get(0),rooms.get(0).getSections()[0],null));
	}
	
	/**
	 * Test world, use to to prove roomsection customisation.
	 * @return a test Game()
	 */
	public static Game SimpleRoom()
	{
		ArrayList<Room> rooms = new ArrayList<Room>();
		RoomSection[] room1 = new RoomSection[]{
				new RoomSection("test", brickWall),
				new RoomSection("test", brickWall),
				new RoomSection("test", woodWall),
				new RoomSection("test", woodWall) 
		};
		rooms.add(new Room("Room",brickWall,room1));
		return new Game(rooms, new Player(rooms.get(0),rooms.get(0).getSections()[0],null));
	}
	
	/**
	 * This world defines a basic game, with objects, and multiple rooms
	 * This should be used as a example as how to define a real world for Adventure.
	 * @return 
	 */
	public static Game BasicGame()
	{
		ArrayList<Room> rooms = new ArrayList<Room>();
		Room room1 = new Room("Room1",brickWall,null);
		Room room2 = new Room("Room2",woodWall,null);
		
		RoomSection[] room1Sec = new RoomSection[]{
				new RoomSection("North", brickWall,new ArrayList<GameObject>(){{
					this.add(new Door(room2,WoodDoor, "A wooden door",10,160));
					}}),
				new RoomSection("East", brickWall),
				new RoomSection("South", brickWall),
				new RoomSection("West", brickWall) 
		};
		room1.setSections(room1Sec);
		
		RoomSection[] room2Sec = new RoomSection[]{
				new RoomSection("North", woodWall,new ArrayList<GameObject>(){{
					this.add(new Door(room1,WoodDoor, "A wooden door",10,160));
					}}
				),
				new RoomSection("East", woodWall),
				new RoomSection("South", woodWall,new ArrayList<GameObject>(){{
					this.add(new Furniture(woodTable, "A wooden table",10,160));
					}}
				),
				new RoomSection("West", woodWall) 
		};
		room2.setSections(room2Sec);
		
		rooms.add(room1);
		rooms.add(room2);
		return new Game(rooms, new Player(rooms.get(0),rooms.get(0).getSections()[0],null));
	}
	
	//gameplay methods
	
	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("Clicked : " + e.getX() + "," +e.getY());
			for(GameObject o: player.getViewing().getContains())
			{
				if (o.intersects(e.getX(), e.getY()))
				{
					o.use(player);
					frame.repaint();
				}
			}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		if(code == KeyEvent.VK_RIGHT || code == KeyEvent.VK_KP_RIGHT) {	
			int i = player.getOccuping().getSectionIndex(player.getViewing());
			if(i + 1 >= player.getOccuping().getSections().length)
				player.setViewing(player.getOccuping().getSections()[0]);
			else
				player.setViewing(player.getOccuping().getSections()[i+1]);
			frame.repaint();
			System.out.println("The player turns to the right looking at room section " + i);
		} else if(code == KeyEvent.VK_LEFT || code == KeyEvent.VK_KP_LEFT) {				
			int i = player.getOccuping().getSectionIndex(player.getViewing());
			if(i - 1 < 0)
				player.setViewing(player.getOccuping().getSections()[player.getOccuping().getSections().length - 1]);
			else
				player.setViewing(player.getOccuping().getSections()[i-1]);
			System.out.println("The player turns to the left looking at room section " + i);
			frame.repaint();
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
	//helper methods
	
	private static final String IMAGE_PATH = "images/";
	
	/**
	 * Taken from DJP - pacman.ui.BoardCanvas
	 * Load an image from the file system, using a given filename.
	 * 
	 * @param filename
	 * @return
	 */
	public static Image loadImage(String filename) {
		// using the URL means the image loads when stored
		// in a jar or expanded into individual files.
		java.net.URL imageURL = World.class.getResource(IMAGE_PATH
				+ filename);

		try {
			Image img = ImageIO.read(imageURL);
			return img;
		} catch (IOException e) {
			// we've encountered an error loading the image. There's not much we
			// can actually do at this point, except to abort the game.
			throw new RuntimeException("Unable to load image: " + filename);
		}
	}
}
