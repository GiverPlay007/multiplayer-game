package me.giverplay.modernal.client.world;

public enum TileEnum
{
	GRASS_TILE("GrassTile"),
	STONE_TILE("StoneTile"),
	SAND_TILE("SandTile"),
	COBBLESTONE_TILE("CobblestoneTile"),
	WATER_TILE("WaterTile"),
	DIRT_TILE("DirtTile"),
	POOR_DIRT_TILE("PoorDirtTile");
	
	private String name;
	
	TileEnum(String className)
	{
		this.name = className;
	}
	
	public String getClassName()
	{
		return this.name;
	}
}
