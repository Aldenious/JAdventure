package adventure.model;

import java.awt.Image;

public class Door extends GameProp {
	private Room target;
	private Key lockedBy;
	
	public Door(Room target,Image image, String info , int x, int y) {
		super(image, info,x,y);
		this.target = target;
		this.lockedBy = null;
	}
	
	public Door(Room target,Key lockedBy ,Image image, String info , int x, int y) {
		super(image, info,x,y);
		this.target = target;
		this.lockedBy = lockedBy;
	}

	@Override
	public boolean use(Player player) {
		if(lockedBy == null || player.getInv().contains(lockedBy) )
		{
			player.setOccuping(target);
			player.setViewing(target.getSections()[0]);
			System.out.println("You walk through to " +target.getName());
		}
		else
		{
			System.out.println("The door is locked, look for a key");
		}
		return true;
	}
}
