package me.giverplay.modernal.server.entity;

import me.giverplay.modernal.server.inventory.Inventory;

public class HumanEntity extends LivingEntity
{
	private Inventory inv = null;

	public HumanEntity(String name, int x, int y)
	{
		super(name, x, y);
	}
	
	public Inventory getInventory()
	{
		return this.inv;
	}
}
