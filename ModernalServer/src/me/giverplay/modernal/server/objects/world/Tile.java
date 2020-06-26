package me.giverplay.modernal.server.objects.world;

public class Tile
{
	private boolean isRigid;
	
	private int x = 0;
	private int y = 0;
	
	public Tile(int x, int y, TileType type, boolean rigid)
	{
		this.x = x;
		this.y = y;
		this.type = type;
		this.isRigid = rigid;
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
	
	public boolean isRigid()
	{
		return this.isRigid;
	}
}
