package me.giverplay.zelda.client.world.tile;

import me.giverplay.zelda.client.graphics.TileEnum;
import me.giverplay.zelda.client.world.Tile;

public class GrassTile extends Tile
{
	public GrassTile(Integer x, Integer y)
	{
		super(x, y, TileEnum.GRASS, false);
	}
}
