package adventure.model;

import java.awt.Image;

public abstract class GameProp extends GameObject {

	public GameProp(Image image, String info) {
		super(image, info);
	}

	@Override
	public abstract boolean use();
}
