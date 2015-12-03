package adventure.model;

import java.util.ArrayList;

public class Game {
	private final ArrayList<Room> GameRooms;
	private final Player player;
	
	public Game(ArrayList<Room> gameRooms, Player player) {
		GameRooms = gameRooms;
		this.player = player;
	}

	public ArrayList<Room> getGameRooms() {
		return GameRooms;
	}

	public Player getPlayer() {
		return player;
	}
}
