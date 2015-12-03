package adventure.model;

import java.awt.Image;

public class Furniture extends GameProp {

	public Furniture(Image image, String info) {
		super(image, info);
	}

	@Override
	public boolean use() {
		PrintInfo();
		return true;
	}

}
