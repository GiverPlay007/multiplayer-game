package me.giverplay.zelda.client.world;

import java.awt.Graphics;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import me.giverplay.zelda.client.Game;
import me.giverplay.zelda.client.Log;
import me.giverplay.zelda.client.entity.Camera;
import me.giverplay.zelda.client.graphics.SpriteManager;
import me.giverplay.zelda.client.graphics.TileEnum;

public class Tile
{
	private int x, y;
	private TileEnum tile;
	
	private boolean rigid;
	
	public static Tile getTileByName(String nome, int x, int y)
	{
		try
		{
			Class<?> clazz = Class.forName("me.giverplay.zelda.client.world.tile." + nome);
			Constructor<?> cons = clazz.getConstructor(Integer.class, Integer.class);
			Object obj = cons.newInstance(x, y);
			
			return (Tile) obj;
		}
		catch(NullPointerException e)
		{
			Log.severe("NullPointerException");
			return null;
		}
		catch(ClassNotFoundException e)
		{
			Log.severe("Tipo de Tile não existente");
			return null;
		} 
		catch (NoSuchMethodException e)
		{
			Log.severe("Construtor indisponível");
			return null;
		} 
		catch (SecurityException e)
		{
			Log.severe("Sec");
			return null;
		} 
		catch (InstantiationException e)
		{
			Log.severe("Inst");
			return null;
		} 
		catch (IllegalAccessException e)
		{
			Log.severe("Ill AC");
			return null;
		} 
		catch (IllegalArgumentException e)
		{
			Log.severe("Ill Arg");
			return null;
		} 
		catch (InvocationTargetException e)
		{
			Log.severe("Inv");
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
