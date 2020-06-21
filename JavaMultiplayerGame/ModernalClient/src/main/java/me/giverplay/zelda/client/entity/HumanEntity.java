package me.giverplay.zelda.client.entity;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import me.giverplay.zelda.client.Game;
import me.giverplay.zelda.client.graphics.SpriteEnum;
import me.giverplay.zelda.client.graphics.SpriteManager;

public class HumanEntity extends LivingEntity
{
	public static final int MAX_ANIM_FRAMES = 10;
	
	private ArrayList<BufferedImage> sprites = SpriteManager.getEntity(SpriteEnum.PLAYER, false);
	
	private int anim_frame = 0;
	private int anim = 0;
	
	public HumanEntity(String name, boolean show, int x, int y, int mx, int my, int mw, int mh)
	{
		super(name, show, x, y, mx, my, mw, mh);
	}
	
	public HumanEntity(String name, boolean showName, int x, int y, int life, int mx, int my, int mw, int mh)
	{
		super(name, showName, x, y, life, mx, my, mw, mh);
	}
	
	@Override
	public void tick()
	{
		if(isMoving)
		{
			anim_frame++;
			
			if(anim_frame > MAX_ANIM_FRAMES)
			{
				anim_frame = 0;
				anim++;
				
				if(anim >= sprites.size())
					anim = 0;
			}
		}
	}
	
	@Override
	public void render(Graphics g)
	{
		Camera camera = Game.getGame().getCamera();
		g.drawImage(sprites.get(anim), getX() - camera.getX(), getY() - camera.getY(), null);
	}
}
