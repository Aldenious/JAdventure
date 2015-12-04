package adventure.model;

import java.awt.Image;

public abstract class GameItem extends GameObject {
	
	public GameItem(Image image, String info , int x, int y) {
		super(image, info, x,y);
	}

	@Override
	public abstract boolean use(Player player);
}
