package me.giverplay.modernal.client.world.tile;

import me.giverplay.modernal.client.graphics.TileEnum;
import me.giverplay.modernal.client.world.Tile;

public class StoneTile extends Tile
{
	public StoneTile(Integer x, Integer y)
	{
		super(x, y, TileEnum.STONE, true);
	}
}
