package me.giverplay.zelda.server.objects.world.tiles;

import me.giverplay.zelda.server.objects.world.Tile;
import me.giverplay.zelda.server.objects.world.TileType;

public class DirtTile extends Tile
{
	public DirtTile(int x, int y)
	{
		super(x, y, TileType.DIRT_TILE);
	}
}
