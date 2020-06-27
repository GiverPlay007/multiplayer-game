package me.giverplay.modernal.client.world.tile;

import me.giverplay.modernal.client.world.Tile;
import me.giverplay.modernal.client.world.TileEnum;

public class DirtTile extends Tile
{
	public DirtTile(Integer x, Integer y)
	{
		super(x, y, TileEnum.DIRT_TILE, false);
	}
}
