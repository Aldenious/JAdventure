package adventure.model;

import java.util.ArrayList;

public class Inventory {
	private ArrayList<GameItem> storedItems;
	
	public Inventory() {
		this.storedItems = new ArrayList<GameItem>();
	}
	
	public void add(GameItem item){
		storedItems.add(item);
	}
	
	public ArrayList<GameItem> getInv(){
		return this.storedItems;
	}
	
	public Boolean contains(GameItem item){
		if (storedItems != null)
		{
			for(GameItem i: storedItems){
				if (i == item)
					return true;
			}
		}
		return false;
	}
}
