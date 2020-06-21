package me.giverplay.zelda.server.net.packets;

import org.json.JSONObject;

import me.giverplay.zelda.server.Server;
import me.giverplay.zelda.server.net.PacketPlayOut;
import me.giverplay.zelda.server.objects.world.Tile;

public class PacketPlayOutWorld extends PacketPlayOut
{
	public PacketPlayOutWorld()
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
		
		return json.toString();
	}
}
