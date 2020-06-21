package me.giverplay.zelda.client.world.tile;

import me.giverplay.zelda.client.graphics.TileEnum;
import me.giverplay.zelda.client.world.Tile;

public class SandTile extends Tile
{
	public SandTile(Integer x, Integer y)
	{
		super(x, y, TileEnum.SAND, false);
	}
}
