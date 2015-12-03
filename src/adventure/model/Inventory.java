package adventure.model;

import java.util.ArrayList;

public class Inventory {
	ArrayList<GameItem> contains;
	
	public Inventory() {
		this.contains = new ArrayList<GameItem>();
	}
	
	public void add(GameItem item){
		contains.add(item);
	}
	
	public ArrayList<GameItem> getInv(){
		return this.contains;
	}
}
