package me.giverplay.zelda.server.objects.world.tiles;

import me.giverplay.zelda.server.objects.world.Tile;
import me.giverplay.zelda.server.objects.world.TileType;

public class GrassTile extends Tile
{
	public GrassTile(int x, int y)
	{
		super(x, y, TileType.GRASS_TILE);
	}
}
