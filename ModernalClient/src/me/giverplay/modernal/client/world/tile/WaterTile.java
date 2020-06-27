package me.giverplay.modernal.client.world.tile;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import me.giverplay.modernal.client.Game;
import me.giverplay.modernal.client.entity.Camera;
import me.giverplay.modernal.client.graphics.SpriteManager;
import me.giverplay.modernal.client.world.Tile;
import me.giverplay.modernal.client.world.TileEnum;

public class WaterTile extends Tile
{
	private static final int maxFrames = 10;
	private int frame = 0;
	private int index = 0;;
	
	private ArrayList<BufferedImage> images;
	
	public WaterTile(Integer x, Integer y)
	{
		super(x, y, TileEnum.WATER_TILE, true);
		
		images = SpriteManager.getWater();
	}
	
	@Override
	public void render(Graphics g)
	{
		frame++;
		
		if(frame > maxFrames)
		{
			frame = 0;
			index++;
		}
		
		if(index >= images.size())
		{
			index = 0;
		}
		
		Camera cam = Game.getGame().getCamera();
		
		g.drawImage(images.get(index), getX() - cam.getX(), getY() - cam.getY(), null);
	}
}
