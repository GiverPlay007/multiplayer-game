package me.giverplay.modernal.client.world.tile;

import me.giverplay.modernal.client.world.Tile;
import me.giverplay.modernal.client.world.TileEnum;

public class SandTile extends Tile
{
	public SandTile(Integer x, Integer y)
	{
		super(x, y, TileEnum.SAND_TILE, false);
	}
}
