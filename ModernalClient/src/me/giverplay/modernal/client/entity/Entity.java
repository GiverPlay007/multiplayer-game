package me.giverplay.modernal.client.entity;

import java.awt.Graphics;

public abstract class Entity
{
	protected double x;
	protected double y;
	
	protected int mx;
	protected int my;
	protected int mw;
	protected int mh;
	
	private String name;
	
	private boolean showNick;
	
	public Entity(String name, boolean showNick, int x, int y, int mx, int my, int mw, int mh)
	{
		this.setX(x);
		this.setY(y);
		this.name = name;
		this.showNick = showNick;
		this.mx = mx;
		this.my = my;
		this.mw = mw;
		this.mh = mw;
	}

	public abstract void tick();
	public abstract void render(Graphics g);
	
	public int getX()
	{
		return (int) x;
	}

	public void setX(int x)
	{
		this.x = x;
	}

	public int getY()
	{
		return (int) y;
	}

	public void setY(int y)
	{
		this.y = y;
	}
	
	public void moveY(double toMove)
	{
		this.y += toMove;
	}
	
	public void moveX(double toMove)
	{
		this.x += toMove;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setShowName(boolean toSet)
	{
		this.showNick = toSet;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public boolean showName()
	{
		return this.showNick;
	}
}
