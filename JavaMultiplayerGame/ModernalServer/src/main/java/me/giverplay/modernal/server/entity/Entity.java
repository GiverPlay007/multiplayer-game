package me.giverplay.modernal.server.entity;

import me.giverplay.modernal.server.objects.GameObject;

public class Entity extends GameObject
{
	private int x, y;
	
	public Entity(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	public int getX()
	{
		return this.x;
	}
	
	public int getY()
	{
		return this.y;
	}
	
	public void setX(int x)
	{
		this.x = x;
	}
	
	public void setY(int y)
	{
		this.y = y;
	}

	@Override
	public void tick()
	{
		// TODO Auto-generated method stub
		
	}
}
