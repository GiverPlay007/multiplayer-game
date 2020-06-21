package me.giverplay.modernal.server.entity;

import me.giverplay.modernal.server.inventory.Inventory;

public class HumanEntity extends LivingEntity
{
	private Inventory inv = null;

	public HumanEntity(int x, int y)
	{
		super(x, y);
	}
	
	public Inventory getInventory()
	{
		return this.inv;
	}
}
