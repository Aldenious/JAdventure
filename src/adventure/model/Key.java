package adventure.model;

import java.awt.Image;

public class Key extends GameItem {

	public Key(Image image, String info, int x, int y) {
		super(image, info, x, y);
	}

	@Override
	public boolean use(Player player) {
		return super.use(player);
	}
	

}
