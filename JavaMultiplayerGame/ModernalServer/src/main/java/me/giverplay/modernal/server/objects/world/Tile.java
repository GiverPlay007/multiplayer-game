package me.giverplay.modernal.server.objects.world;

public class Tile
{
	private int x = 0;
	private int y = 0;
	
	public Tile(int x, int y, TileType type)
	{
		this.x = x;
		this.y = y;
		this.type = type;
	}
	
	private TileType type;
	
	public int getX()
	{
		return this.x;
	}
	
	public int getY()
	{
		return this.y;
	}
	
	public TileType getType()
	{
		return type;
	}
}
