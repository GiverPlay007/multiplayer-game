package me.giverplay.zelda.client.world.tile;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import me.giverplay.zelda.client.Game;
import me.giverplay.zelda.client.entity.Camera;
import me.giverplay.zelda.client.graphics.SpriteManager;
import me.giverplay.zelda.client.world.Tile;

public class WaterTile extends Tile
{
	private static final int maxFrames = 10;
	private int frame = 0;
	private int index = 0;;
	
	private ArrayList<BufferedImage> images;
	
	public WaterTile(Integer x, Integer y)
	{
		super(x, y, null, true);
		
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
