package me.giverplay.zelda.client.entity;

import java.awt.Graphics;

import me.giverplay.zelda.client.Game;
import me.giverplay.zelda.client.graphics.CollectibleEnum;
import me.giverplay.zelda.client.graphics.SpriteManager;

public class Collectible extends Entity
{
	private CollectibleEnum coll;
	
	public Collectible(CollectibleEnum coll, String name, int x, int y, int mx, int my, int mw, int mh)
	{
		super(name, false, x, y, mx, my, mw, mh);
		
		this.coll = coll;
	}
	
	@Override
	public void render(Graphics g)
	{
		Camera cam = Game.getGame().getCamera();
		g.drawImage(SpriteManager.getCollectible(coll), getX() - cam.getX(), getY() - cam.getY(), null);
	}
	
	@Override
	public void tick()
	{
		
	}
	
	public void collect()
	{
		
	}
}
