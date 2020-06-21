package me.giverplay.modernal.client.world.tile;

import me.giverplay.modernal.client.graphics.TileEnum;
import me.giverplay.modernal.client.world.Tile;

public class DirtTile extends Tile
{
	public DirtTile(Integer x, Integer y)
	{
		super(x, y, TileEnum.DIRT, false);
	}
}
