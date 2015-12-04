package adventure.model;

import java.awt.Image;

public class Furniture extends GameProp {

	public Furniture(Image image, String info , int x, int y) {
		super(image, info,x,y);
	}

	@Override
	public boolean use(Player player) {
		PrintInfo();
		return true;
	}

}
