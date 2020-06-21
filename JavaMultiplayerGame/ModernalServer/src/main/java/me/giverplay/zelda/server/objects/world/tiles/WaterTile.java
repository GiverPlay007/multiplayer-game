package me.giverplay.zelda.server.objects.world.tiles;

import me.giverplay.zelda.server.objects.world.Tile;
import me.giverplay.zelda.server.objects.world.TileType;

public class WaterTile extends Tile
{
	public WaterTile(int x, int y)
	{
		super(x, y, TileType.WATER_TILE);
	}
}
