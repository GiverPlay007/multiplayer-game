package me.giverplay.modernal.server.objects.world;

import me.giverplay.modernal.server.objects.RandomUtils;
import me.giverplay.modernal.server.objects.world.tiles.CobblestoneTile;
import me.giverplay.modernal.server.objects.world.tiles.DirtTile;
import me.giverplay.modernal.server.objects.world.tiles.PoorDirtTile;
import me.giverplay.modernal.server.objects.world.tiles.SandTile;
import me.giverplay.modernal.server.objects.world.tiles.StoneTile;
import me.giverplay.modernal.server.objects.world.tiles.WaterTile;

public class Generator
{
	public static final int NOISE = 1;
	public static final int RANDOM_PATH = 0;
	
	public static Tile[] generate(int width, int height, int algorithm)
	{
		return randomPath(width, height);
	}
	
	public static Tile[] randomPath(int width, int height)
	{
		Tile[] array = new Tile[width * height];
		int dir = 0;
		
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
		
		int xx = 1;
		int yy = 1;
		
		TileType[] materials = new TileType[] {TileType.COBBLESTONE_TILE, TileType.DIRT_TILE, TileType.POOR_DIRT_TILE,
																					TileType.SAND_TILE, TileType.STONE_TILE, TileType.WATER_TILE};
		
		TileType mat = materials[RandomUtils.getRandom().nextInt(materials.length)];
		
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
		
		return array;
	}
}
