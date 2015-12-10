package adventure.model;

import java.awt.Image;

public abstract class GameItem extends GameObject {

	public GameItem(Image image, String info, int x, int y) {
		super(image, info, x, y);
	}

	@Override
	public boolean use(Player player) {

		// item is not in player's inventory
		// thus, pickup item!
		if (player.getInv().contains(this)) // check to see if it is
													// inventory.
		{
			if (player.getViewing().getContents().contains(this)) 
			// test to see if the item is in the player's view
				player.getViewing().getContents().remove(this); 
				// and if so, remove this from View's section
			
			player.getInv().add(this);
			System.out.println("You pickup " + this.getInfo());
			return true;
		}
		return false; // TODO implement logic for usage in inventory. Currently
						// impossible to interact directly with inventories.
	}
}
