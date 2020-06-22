package me.giverplay.modernal.server.objects.world;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONObject;

import me.giverplay.modernal.server.entity.Entity;
import me.giverplay.modernal.server.entity.EntityPlayer;
import me.giverplay.modernal.server.net.PacketOut;
import me.giverplay.modernal.server.net.packets.PacketInPlayerMove;
import me.giverplay.modernal.server.net.packets.PacketOutPlayerJoin;
import me.giverplay.modernal.server.net.packets.PacketOutPlayerMove;
import me.giverplay.modernal.server.net.packets.PacketOutPlayerQuit;
import me.giverplay.modernal.server.objects.GameObject;
import me.giverplay.modernal.server.tasks.SocketListenerTask;

public class ServerWorld extends GameObject implements World
{
	@SuppressWarnings("unused")
	private HashMap<String, Entity> entities = new HashMap<>();
	private HashMap<String, EntityPlayer> players = new HashMap<>();
	
	private ArrayList<Runnable> pendingTasks = new ArrayList<>();
	
	private Tile[] tiles;
	
	private JSONObject playerJson = new JSONObject();
	
	private int width;
	private int height;
	
	public ServerWorld(int width, int height, Tile[] tiles)
	{
		this.tiles = tiles;
		this.width = width;
		this.height = height;
		
		new Thread(() -> {
			
			while(true)
				for(int i = 0; i < pendingTasks.size(); i++) // Evitar modificações concorrentes nas HashMaps
				{
					Runnable task = pendingTasks.get(i);
					task.run();
					pendingTasks.remove(task);
				}
			
		}).start();
	}
	
	public JSONObject getPlayersJson()
	{
		return this.playerJson;
	}
	
	private void updatePlayersJSON()
	{
		playerJson = new JSONObject();
		
		for(EntityPlayer player : players.values())
		{
			JSONObject json = new JSONObject();
			json.put("x", player.getX());
			json.put("y", player.getY());
			
			playerJson.put(player.getName(), json);
		}
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
	public void handlePlayerMove(PacketInPlayerMove packet)
	{
		JSONObject json = new JSONObject(packet.serialize());
		
		String nickname = json.getString("nickname");
		
		for(String nick : players.keySet())
		{
			if (nick.equals(nickname))
				continue;
			
			players.get(nick).sendPacket(new PacketOutPlayerMove(packet));
		}
	}
	
	@Override
	public EntityPlayer addPlayer(String nick, SocketListenerTask task)
	{
		EntityPlayer player = new EntityPlayer(nick, task, 10, 10);
		
		pendingTasks.add(new Runnable()
		{
			@Override
			public void run()
			{
				PacketOutPlayerJoin packet = new PacketOutPlayerJoin();
				packet.then("nickname", nick);
				packet.then("x", 10);
				packet.then("y", 10);
				packet.end();
				
				broadcast(packet);
				players.put(nick, player);
				updatePlayersJSON();
			}
		});
		
		return player;
	}
	
	@Override
	public void removePlayer(String nick)
	{
		pendingTasks.add(new Runnable()
		{
			@Override
			public void run()
			{
				players.remove(nick);
				PacketOutPlayerQuit packet = new PacketOutPlayerQuit();
				packet.then("nickname", nick);
				packet.end();
				broadcast(packet);
				updatePlayersJSON();
			}
		});
	}
	
	private void broadcast(PacketOut packet)
	{
		for(EntityPlayer ep : players.values())
		{
			ep.sendPacket(packet);
		}
	}
	
	public void registerBroadcast(PacketOut packet)
	{
		pendingTasks.add(new Runnable()
		{
			@Override
			public void run()
			{
				broadcast(packet);
			}
		});
	}
}