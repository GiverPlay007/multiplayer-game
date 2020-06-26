package me.giverplay.modernal.server.entity;

import me.giverplay.modernal.server.Server;
import me.giverplay.modernal.server.objects.world.Tile;
import me.giverplay.modernal.server.objects.world.World;

public class LivingEntity extends Entity
{
	private int health;
	private int maxHealth;
	private int mx = 10;
	private int my = 12;
	private int mw = 10;
	private int mh = 20;
	
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
	
	public void moveRelative(int x, int y)
	{
		int speed = y != 0 && x != 0 ? 2 : 3;
		
		if(moveAllowed((int) (getX() + speed * x) + mx, getY() + my, mw, mh))
		{
			moveX(x * speed);
		}
		
		if(moveAllowed(getX() + mx, (int) ((getY() + speed * y) + my), mw, mh))
		{
			moveY(y * speed);
		}
	}
	
	public boolean moveAllowed(int xn, int yn, int width, int height) // isFree
	{
		int x1 = xn / 32;
		int y1 = yn / 32;
		
		int x2 = (xn + width -1) / 32;
		int y2 = yn / 32;
		
		int x3 = xn / 32;
		int y3 = (yn + height -1) / 32;
		
		int x4 = (xn + width -1) / 32;
		int y4 = (yn + height -1) / 32;
		
		World world = Server.getServer().getWorld();
		Tile[] tiles = world.getTiles(false);
		
		int index1 = x1 + (y1 * world.getWidth());
		int index2 = x2 + (y2 * world.getWidth());
		int index3 = x3 + (y3 * world.getWidth());
		int index4 = x4 + (y4 * world.getWidth());
		
		return !(tiles[index1].isRigid()
				|| tiles[index2].isRigid()
				|| tiles[index3].isRigid()
				|| tiles[index4].isRigid());
		
	}
}
