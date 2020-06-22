package me.giverplay.modernal.server.net.packets;

import org.json.JSONObject;

import me.giverplay.modernal.server.Server;
import me.giverplay.modernal.server.net.PacketOut;
import me.giverplay.modernal.server.objects.world.ServerWorld;
import me.giverplay.modernal.server.objects.world.Tile;

public class PacketOutWorld extends PacketOut
{
	public PacketOutWorld()
	{
		then("type", "WORLD");
		then("width", Server.getServer().getWorld().getWidth());
		then("height", Server.getServer().getWorld().getHeight());
	}
	
	@Override
	public String serialize()
	{
		JSONObject json = new JSONObject();
		
		for(String key : data.keySet())
		{
			json.put(key, data.get(key));
		}
		
		Tile[] tiles = Server.getServer().getWorld().getTiles(true).clone(); // .clone() para não dar ConcurrentModificationException
		JSONObject map = new JSONObject();
		
		for(Tile tile : tiles)
		{
			if(tile == null)
				continue;
			
			String coord = tile.getX() + ":" + tile.getY();
			map.put(coord, tile.getType().getClassName());
		}

		json.put("tiles", map);
		json.put("players", ((ServerWorld) Server.getServer().getWorld()).getPlayersJson());
		
		return json.toString();
	}
}
