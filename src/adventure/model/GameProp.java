package adventure.model;

import java.awt.Image;

public abstract class GameProp extends GameObject {

	public GameProp(Image image, String info , int x, int y) {
		super(image, info, x, y);
	}

	@Override
	public abstract boolean use(Player player);
}
