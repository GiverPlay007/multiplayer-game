package me.giverplay.modernal.server.objects.world.tiles;

import me.giverplay.modernal.server.objects.world.Tile;
import me.giverplay.modernal.server.objects.world.TileType;

public class PoorDirtTile extends Tile
{
	public PoorDirtTile(int x, int y)
	{
		super(x, y, TileType.POOR_DIRT_TILE, false);
	}
}
