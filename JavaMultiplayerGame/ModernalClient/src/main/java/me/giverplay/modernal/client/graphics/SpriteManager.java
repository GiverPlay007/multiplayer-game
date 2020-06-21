package me.giverplay.modernal.client.graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import me.giverplay.modernal.client.Game;
import me.giverplay.modernal.client.Log;

public class SpriteManager
{
	public static final int TILE_SIZE = 32;
	
	private static ArrayList<BufferedImage> tile_water = new ArrayList<>();
	private static ArrayList<BufferedImage> player = new ArrayList<>();
	private static ArrayList<BufferedImage> player_feedback = new ArrayList<>();
	private static ArrayList<BufferedImage> enemy = new ArrayList<>();
	private static ArrayList<BufferedImage> enemy_feedback = new ArrayList<>();
	private static ArrayList<BufferedImage> zombie = new ArrayList<>();
	private static ArrayList<BufferedImage> zombie_feedback = new ArrayList<>();
	
	private static BufferedImage tile_stone;
	private static BufferedImage tile_cobblestone;
	private static BufferedImage tile_grass;
	private static BufferedImage tile_dirt;
	private static BufferedImage tile_poordirt;
	private static BufferedImage tile_sand;
	
	private static BufferedImage sprite_ammo;
	private static BufferedImage life_pack;
	private static BufferedImage pistol;
	private static BufferedImage sprite_rifle;
	
	public static void init()
	{
		BufferedImage tiles = null, entity = null;
		
		try
		{
			tiles = ImageIO.read(Game.class.getResourceAsStream("/Tiles.png"));
			entity = ImageIO.read(Game.class.getResourceAsStream("/Entity.png"));
		}
		catch(IOException e)
		{
			Log.severe("Falha ao carregar sprites, finalizando");
			System.exit(0);
		}
		
		tile_stone 			 = tiles.getSubimage(0, 0, TILE_SIZE, TILE_SIZE);
		tile_cobblestone = tiles.getSubimage(TILE_SIZE, 0, TILE_SIZE, TILE_SIZE);
		tile_grass 			 = tiles.getSubimage(TILE_SIZE * 2, 0, TILE_SIZE, TILE_SIZE);
		tile_dirt 			 = tiles.getSubimage(TILE_SIZE * 3, 0, TILE_SIZE, TILE_SIZE);
		tile_poordirt 	 = tiles.getSubimage(TILE_SIZE * 4, 0, TILE_SIZE, TILE_SIZE);
		tile_sand 			 = tiles.getSubimage(TILE_SIZE * 5, 0, TILE_SIZE, TILE_SIZE);
		
		life_pack 	 = entity.getSubimage(0, TILE_SIZE * 7, TILE_SIZE, TILE_SIZE);
		sprite_ammo  = entity.getSubimage(TILE_SIZE, TILE_SIZE * 7, TILE_SIZE, TILE_SIZE);
		pistol 			 = entity.getSubimage(0, TILE_SIZE * 8, TILE_SIZE, TILE_SIZE);
		sprite_rifle = entity.getSubimage(TILE_SIZE, TILE_SIZE * 8, TILE_SIZE, TILE_SIZE);
		
		for(int i = 0; i < TILE_SIZE * 6; i += TILE_SIZE)
		{
			tile_water.add(tiles.getSubimage(i, TILE_SIZE, TILE_SIZE, TILE_SIZE));
		}
		
		for(int i = 0; i < TILE_SIZE * 8; i += TILE_SIZE)
		{
			player.add(entity.getSubimage(i, 0, TILE_SIZE, TILE_SIZE));
			player_feedback.add(entity.getSubimage(i, TILE_SIZE, TILE_SIZE, TILE_SIZE));
			
			enemy.add(entity.getSubimage(i, TILE_SIZE * 2, TILE_SIZE, TILE_SIZE));
			enemy_feedback.add(entity.getSubimage(i, TILE_SIZE * 3, TILE_SIZE, TILE_SIZE));
			
			zombie.add(entity.getSubimage(i, TILE_SIZE * 4, TILE_SIZE, TILE_SIZE));
			zombie_feedback.add(entity.getSubimage(i, TILE_SIZE * 5, TILE_SIZE, TILE_SIZE));
		}
	}
	
	public static BufferedImage getTile(TileEnum tile)
	{
		switch (tile)
		{
			case COBBLESTONE:
				return tile_cobblestone;
				
			case DIRT:
				return tile_dirt;
				
			case GRASS:
				return tile_grass;
				
			case POOR_DIRT:
				return tile_poordirt;
				
			case SAND:
				return tile_sand;
				
			case STONE:
				return tile_stone;
				
			default:
				return null;
		}
	}
	
	public static BufferedImage getCollectible(CollectibleEnum c)
	{
		switch (c)
		{
			case AMMO:
				return sprite_ammo;
				
			case LIFE_PACK:
				return life_pack;
				
			case PISTOL:
				return pistol;
			
			case RIFLE:
				return sprite_rifle;
				
			default:
				return null;
		}
	}
	
	public static ArrayList<BufferedImage> getEntity(SpriteEnum sprite, boolean feedback)
	{
		switch (sprite)
		{
			case ENEMY_DEFAULT:
				return !feedback ? enemy : enemy_feedback;
				
			case PLAYER:
				return !feedback ? player : player_feedback;
				
			case ZOMBIE:
				return !feedback ? zombie : zombie_feedback;
				
			default:
				return tile_water;
		}
	}
	
	public static ArrayList<BufferedImage> getWater()
	{
		return tile_water;
	}
}
