package me.giverplay.modernal.client.world;

import java.awt.Graphics;
import java.lang.reflect.Constructor;

import me.giverplay.modernal.client.Game;
import me.giverplay.modernal.client.Log;
import me.giverplay.modernal.client.entity.Camera;
import me.giverplay.modernal.client.graphics.SpriteManager;
import me.giverplay.modernal.client.graphics.TileEnum;

public class Tile
{
	private int x, y;
	private TileEnum tile;
	
	private boolean rigid;
	
	public static Tile getTileByName(String nome, int x, int y)
	{
		try
		{
			Class<?> clazz = Class.forName("me.giverplay.modernal.client.world.tile." + nome);
			Constructor<?> cons = clazz.getConstructor(Integer.class, Integer.class);
			Object obj = cons.newInstance(x, y);
			
			return (Tile) obj;
		}
		catch(Exception e)
		{
			Log.severe("Falha ao instanciar tile (reflection): " + e.getCause() + " | " + e.getMessage());
			return null;
		}
	}
	
	public Tile(int x, int y, TileEnum tile, boolean rigid)
	{
		this.x = x;
		this.y = y;
		this.tile = tile;
		this.rigid = rigid;
	}
	
	public void render(Graphics g)
	{
		Camera cam = Game.getGame().getCamera();
		g.drawImage(SpriteManager.getTile(tile), x - cam.getX(), y - cam.getY(), null);
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	public boolean isRigid()
	{
		return this.rigid;
	}
}
