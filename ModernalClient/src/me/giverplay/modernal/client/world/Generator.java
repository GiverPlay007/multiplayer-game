package me.giverplay.modernal.client.world;

import org.json.JSONObject;

import me.giverplay.modernal.client.utils.RandomUtils;
import me.giverplay.modernal.client.world.tile.CobblestoneTile;
import me.giverplay.modernal.client.world.tile.DirtTile;
import me.giverplay.modernal.client.world.tile.GrassTile;
import me.giverplay.modernal.client.world.tile.PoorDirtTile;
import me.giverplay.modernal.client.world.tile.SandTile;
import me.giverplay.modernal.client.world.tile.StoneTile;
import me.giverplay.modernal.client.world.tile.WaterTile;

public class Generator
{
	public static final int RANDOM_PATH = 0;
	public static final int RANDOM_NOISE = 1;
	public static final int PERLIN_NOISE = 2;
	
	public static JSONObject generate(int width, int height, int algorithm)
	{
		JSONObject json = new JSONObject();
		JSONObject map = new JSONObject();
		
		Tile[] tiles;
		
		//if(algorithm == RANDOM_PATH)
		tiles = randomPath(width, height);
		
		for(Tile tile : tiles)
		{
			if(tile == null)
				continue;
			
			String coord = tile.getX() + ":" + tile.getY();
			map.put(coord, tile.getType().getClassName());
		}
		
		json.put("width", width);
		json.put("height", height);
		json.put("tiles", map);
		
		return json;
	}
	
	private static Tile[] randomPath(int width, int height)
	{
		Tile[] array = new Tile[width * height];
		int dir = 0;
		
		for(int xx = 0; xx < width; xx++)
			for(int yy = 0; yy < height; yy++)
				array[xx + yy * width] = new GrassTile(xx, yy);
		
		int xx = 1;
		int yy = 1;
		
		TileEnum[] materials = new TileEnum[] {TileEnum.COBBLESTONE_TILE, TileEnum.DIRT_TILE, TileEnum.POOR_DIRT_TILE,
				TileEnum.SAND_TILE, TileEnum.STONE_TILE, TileEnum.WATER_TILE, TileEnum.GRASS_TILE};
		
		TileEnum mat = materials[RandomUtils.getRandom().nextInt(materials.length)];
		
		for(int i = 0; i < 5000; i++)
		{
			if(dir == 0)
			{
				if(xx < width - 1)
				{
					xx++;
				}
			}
			else if(dir == 1)
			{
				if(xx > 1)
				{
					xx--;
				}
			}
			else if(dir == 2)
			{
				if(yy < height - 1)
				{
					yy++;
				}
			}
			else if(dir == 3)
			{
				if(yy > 1)
				{
					yy--;
				}
			}
			
			if(RandomUtils.getRandom().nextInt(100) < 30)
			{
				dir = RandomUtils.getRandom().nextInt(4);
			}
			
			switch (mat)
			{
				case POOR_DIRT_TILE:
					array[xx + yy * width] = new PoorDirtTile(xx, yy);
					break;
					
				case DIRT_TILE:
					array[xx + yy * width] = new DirtTile(xx, yy);
					break;
					
				case SAND_TILE:
					array[xx + yy * width] = new SandTile(xx, yy);
					break;
					
				case STONE_TILE:
					array[xx + yy * width] = new StoneTile(xx, yy);
					break;
					
				case COBBLESTONE_TILE:
					array[xx + yy * width] = new CobblestoneTile(xx, yy);
					break;
					
				case WATER_TILE:
					array[xx + yy * width] = new WaterTile(xx, yy);
					break;
					
				default:
					break;
			}
			
			if(RandomUtils.getRandom().nextInt(100) < 10)
			{
				mat = materials[RandomUtils.getRandom().nextInt(materials.length)];
			}
		}
		
		for(int xn = 0; xn < width; xn++)
		{
			array[xn] = new StoneTile(xn, 0);
			array[xn + (width - 1)* height] = new StoneTile(xn, (height - 1));
		}
		
		for(int yn = 1; yn < width; yn++)
		{
			array[width * yn] = new StoneTile(0, yn);
			array[(width - 1) + yn * height] = new StoneTile((width - 1), yn);
		}
		
		return array;
	}
}
