package adventure.model;

import java.awt.Image;

public class Door extends GameProp {
	private Room target;
	
	public Door(Room target,Image image, String info , int x, int y) {
		super(image, info,x,y);
		this.target = target;
	}

	@Override
	public boolean use(Player player) {
		player.setOccuping(target);
		player.setViewing(target.getSections()[0]);
		System.out.println("You walk through to " +target.getName());
		return true;
	}
}
