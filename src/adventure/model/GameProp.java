package adventure.model;

import java.awt.Image;

/**
 * GameProp defines the static, non pickupable item logic for Adventure, This
 * includes Doors, and furniture, but all items once placed in the world, should
 * not be directly be moved by the player.
 * 
 * @author Aidan
 *
 */
public abstract class GameProp extends GameObject {

	public GameProp(Image image, String info, int x, int y) {
		super(image, info, x, y);
	}

	@Override
	public abstract boolean use(Player player);
}
