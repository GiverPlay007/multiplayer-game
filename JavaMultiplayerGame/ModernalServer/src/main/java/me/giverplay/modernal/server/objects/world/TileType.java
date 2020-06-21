package me.giverplay.modernal.server.objects.world;

public enum TileType
{
	GRASS_TILE("GrassTile"),
	STONE_TILE("StoneTile"),
	SAND_TILE("SandTile"),
	COBBLESTONE_TILE("CobblestoneTile"),
	WATER_TILE("WaterTile"),
	DIRT_TILE("DirtTile"),
	POOR_DIRT_TILE("PoorDirtTile");
	
	private String name;
	
	TileType(String className)
	{
		this.name = className;
	}
	
	public String getClassName()
	{
		return this.name;
	}
	
}
