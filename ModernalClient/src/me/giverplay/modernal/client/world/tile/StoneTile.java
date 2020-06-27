package me.giverplay.modernal.client.world.tile;

import me.giverplay.modernal.client.world.Tile;
import me.giverplay.modernal.client.world.TileEnum;

public class StoneTile extends Tile
{
	public StoneTile(Integer x, Integer y)
	{
		super(x, y, TileEnum.STONE_TILE, true);
	}
}
