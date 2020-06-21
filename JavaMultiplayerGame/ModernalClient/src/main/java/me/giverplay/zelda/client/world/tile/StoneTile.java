package me.giverplay.zelda.client.world.tile;

import me.giverplay.zelda.client.graphics.TileEnum;
import me.giverplay.zelda.client.world.Tile;

public class StoneTile extends Tile
{
	public StoneTile(Integer x, Integer y)
	{
		super(x, y, TileEnum.STONE, true);
	}
}
