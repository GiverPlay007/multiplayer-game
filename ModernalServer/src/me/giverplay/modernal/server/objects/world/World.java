package me.giverplay.modernal.server.objects.world;

import me.giverplay.modernal.server.entity.Entity;
import me.giverplay.modernal.server.entity.EntityPlayer;
import me.giverplay.modernal.server.net.packets.PacketInPlayerMove;
import me.giverplay.modernal.server.tasks.SocketListenerTask;

public interface World
{
	public Tile getTile(int x, int y);
	public void setTile(int x, int y, Tile tile);
	
	public void spawnEntity(Entity entity, Tile tile);
	public void spawnEntity(Class<Entity> clazz, Tile tile) throws IllegalArgumentException;
	
	public Tile[] getTiles(boolean ignoreDefault);
	
	public int getWidth();
	public int getHeight();
	
	public void handlePlayerMove(PacketInPlayerMove packet);
	public void removePlayer(String nick);
	
	public EntityPlayer addPlayer(String nick, SocketListenerTask task);
}
