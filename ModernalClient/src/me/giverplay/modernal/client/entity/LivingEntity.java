package me.giverplay.modernal.client.entity;

import static me.giverplay.modernal.client.graphics.SpriteManager.TILE_SIZE;

import java.awt.Graphics;

import me.giverplay.modernal.client.Game;
import me.giverplay.modernal.client.world.Tile;
import me.giverplay.modernal.client.world.World;

public class LivingEntity extends Entity
{
	protected boolean isMoving = false;
	protected boolean isDamaged = false;
	
	private int life = 100;
	private int maxLife = 100;
	
	public LivingEntity(String name, boolean show, int x, int y, int mx, int my, int mw, int mh)
	{
		super(name, show, x, y, mx, my, mw, mh);
	}
	
	public LivingEntity(String name, boolean show, int x, int y, int maxLife, int mx, int my, int mw, int mh)
	{
		super(name, show, x, y, mx, my, mw, mh);
		
		this.setMaxLife(maxLife);
		this.life = maxLife;
	}
	
	@Override
	public void tick()
	{
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void render(Graphics g)
	{

	}

	public int getLife()
	{
		return life;
	}

	public void ModifyLife(int toModify)
	{
		this.life += toModify;
		
		if(life > maxLife) life = maxLife;
		if(life < 0) life = 0;
	}

	public int getMaxLife()
	{
		return maxLife;
	}

	public void setMaxLife(int maxLife)
	{
		this.maxLife = maxLife;
	}
	
	public boolean moveRelative(int x, int y)
	{
		if(x == 0 && y == 0) 
			return false;
		
		double speed = y != 0 && x != 0 ? 2 : 3;
		byte changes = 0;
		
		if(moveAllowed((int) (getX() + speed * x) + mx, getY() + my, mw, mh))
		{
			moveX(x * speed);
			changes++;
		}
		
		if(moveAllowed(getX() + mx, (int) ((getY() + speed * y) + my), mw, mh))
		{
			moveY(y * speed);
			changes++;
		}
		
		return changes != 0;
	}
	
	public boolean moveAllowed(int xn, int yn, int width, int height) // isFree
	{
		int x1 = xn / TILE_SIZE;
		int y1 = yn / TILE_SIZE;
		
		int x2 = (xn + width -1) / TILE_SIZE;
		int y2 = yn / TILE_SIZE;
		
		int x3 = xn / TILE_SIZE;
		int y3 = (yn + height -1) / TILE_SIZE;
		
		int x4 = (xn + width -1) / TILE_SIZE;
		int y4 = (yn + height -1) / TILE_SIZE;
		
		World world = Game.getGame().getWorld();
		Tile[] tiles = world.getTiles();
		
		int index1 = x1 + (y1 * world.getWidth());
		int index2 = x2 + (y2 * world.getWidth());
		int index3 = x3 + (y3 * world.getWidth());
		int index4 = x4 + (y4 * world.getWidth());
		
		return !(tiles[index1].isRigid()
				|| tiles[index2].isRigid()
				|| tiles[index3].isRigid()
				|| tiles[index4].isRigid());
	}
	
	public void setLife(int set)
	{
		this.life = set;
	}
	
	public void jump()
	{
		
	}
}
