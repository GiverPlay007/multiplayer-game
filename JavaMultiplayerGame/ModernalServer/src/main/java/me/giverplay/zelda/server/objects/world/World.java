package me.giverplay.zelda.server.objects.world;

import me.giverplay.zelda.server.entity.Entity;
import me.giverplay.zelda.server.net.packets.PacketPlayInPlayerMove;

public interface World
{
	public Tile getTile(int x, int y);
	public void setTile(int x, int y, Tile tile);
	
	public void spawnEntity(Entity entity, Tile tile);
	public void spawnEntity(Class<Entity> clazz, Tile tile) throws IllegalArgumentException;
	
	public Tile[] getTiles(boolean ignoreDefault);
	
	public int getWidth();
	public int getHeight();
	public void handlePlayerMove(PacketPlayInPlayerMove packet);
}
