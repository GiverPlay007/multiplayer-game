package me.giverplay.zelda.server.entity;

import me.giverplay.zelda.server.inventory.Inventory;

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
