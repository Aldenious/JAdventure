package adventure.model;

public class Player {
	private Room occuping;
	private RoomSection viewing;
	private Inventory inv;

	public Player(Room occuping, RoomSection viewing, Inventory inv) {
		this.occuping = occuping;
		this.viewing = viewing;
		this.inv = inv;
	}
	
	public Room getOccuping() {
		return occuping;
	}

	public void setOccuping(Room occuping) {
		occuping = occuping;
	}

	public RoomSection getViewing() {
		return viewing;
	}

	public void setViewing(RoomSection viewing) {
		this.viewing = viewing;
	}

	public Inventory getInv() {
		return inv;
	}

	public void setInv(Inventory inv) {
		this.inv = inv;
	}
}
