package me.giverplay.modernal.server.objects.world.tiles;

import me.giverplay.modernal.server.objects.world.Tile;
import me.giverplay.modernal.server.objects.world.TileType;

public class StoneTile extends Tile
{
	public StoneTile(int x, int y)
	{
		super(x, y, TileType.STONE_TILE);
	}
}
