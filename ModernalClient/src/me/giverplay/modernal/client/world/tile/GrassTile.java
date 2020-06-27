package me.giverplay.modernal.client.world.tile;

import me.giverplay.modernal.client.world.Tile;
import me.giverplay.modernal.client.world.TileEnum;

public class GrassTile extends Tile
{
	public GrassTile(Integer x, Integer y)
	{
		super(x, y, TileEnum.GRASS_TILE, false);
	}
}
