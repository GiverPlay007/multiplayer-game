package me.giverplay.zelda.client.world.tile;

import me.giverplay.zelda.client.graphics.TileEnum;
import me.giverplay.zelda.client.world.Tile;

public class DirtTile extends Tile
{
	public DirtTile(Integer x, Integer y)
	{
		super(x, y, TileEnum.DIRT, false);
	}
}
