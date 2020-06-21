package me.giverplay.modernal.server.objects.world;

import java.util.HashMap;

import me.giverplay.modernal.server.entity.Entity;
import me.giverplay.modernal.server.entity.EntityPlayer;
import me.giverplay.modernal.server.net.packets.PacketPlayInPlayerMove;
import me.giverplay.modernal.server.objects.GameObject;
import me.giverplay.modernal.server.objects.ServerLogger;

public class ServerWorld extends GameObject implements World
{
	@SuppressWarnings("unused")
	private HashMap<String, Entity> entities = new HashMap<>();
	private HashMap<String, EntityPlayer> players = new HashMap<>();
	
	private Tile[] tiles;
	
	private int width;
	private int height;
	
	public ServerWorld(int width, int height, Tile[] tiles)
	{
		this.tiles = tiles;
		this.width = width;
		this.height = height;
	}
	
	@Override
	public void tick()
	{
		
	}
	
	@Override
	public Tile getTile(int x, int y)
	{
		return this.tiles[x + y * width];
	}

	@Override
	public void setTile(int x, int y, Tile tile)
	{
		this.tiles[x + y * width] = tile;
	}

	@Override
	public void spawnEntity(Entity entity, Tile tile)
	{
		// TODO Auto-generated method stub
	}

	@Override
	public void spawnEntity(Class<Entity> clazz, Tile tile) throws IllegalArgumentException
	{
		// TODO Auto-generated method stub
	}

	@Override
	public Tile[] getTiles(boolean ignoreDefault)
	{
		return tiles;
	}

	@Override
	public int getWidth()
	{
		return this.width;
	}

	@Override
	public int getHeight()
	{
		return this.height;
	}
	
	@Override
	public void handlePlayerMove(PacketPlayInPlayerMove packet)
	{
		// TODO Auto-generated method stub
		ServerLogger.log("Recebi o pacote");
	}
	
	@Override
	public EntityPlayer addPlayer(String nick)
	{
		EntityPlayer player = new EntityPlayer(nick, 10, 10);
		players.put(nick, player);
		
		return player;
	}
	
	@Override
	public void removePlayer(String nick)
	{
		
	}
}
