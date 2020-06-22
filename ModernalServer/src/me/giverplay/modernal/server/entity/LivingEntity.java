package me.giverplay.modernal.server.entity;

public class LivingEntity extends Entity
{
	private int health;
	private int maxHealth;
	
	public LivingEntity(String name, int x, int y)
	{
		super(name, x, y);
	}
	
	public int getHealth()
	{
		return this.health;
	}
	
	public void setHealth(int toSet)
	{
		this.health = (toSet > maxHealth ? maxHealth : toSet < 0 ? 0 : toSet);
	}
}
