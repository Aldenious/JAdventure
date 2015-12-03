package adventure.model;

import java.awt.Image;

public abstract class GameItem extends GameObject {
	
	public GameItem(Image image, String info) {
		super(image, info);
	}

	@Override
	public abstract boolean use();
}
