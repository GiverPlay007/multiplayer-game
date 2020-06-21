package me.giverplay.zelda.server.objects.world.tiles;

import me.giverplay.zelda.server.objects.world.Tile;
import me.giverplay.zelda.server.objects.world.TileType;

public class SandTile extends Tile
{
	public SandTile(int x, int y)
	{
		super(x, y, TileType.SAND_TILE);
	}
}
