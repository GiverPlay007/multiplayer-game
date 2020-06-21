package me.giverplay.zelda.server.inventory;

public interface Inventory extends Iterable<Item>
{
	public Item getItem(int slot);
	
	public int firstEmpty();
	
	public void setItem(int slot, Item item);
	public void addItem(Item item);
	public void clear();
	
	public void remove(int slot);
	public void remove(int slot, int amount);
	public void remove(Item item, int amount);
	public void remove(ItemType type, int amount);
	
	public boolean hasItem(Item item);
	public boolean hasItem(ItemType type);
	public boolean hasItem(Item item, int amount);
	public boolean hasItem(ItemType type, int amount);
}
