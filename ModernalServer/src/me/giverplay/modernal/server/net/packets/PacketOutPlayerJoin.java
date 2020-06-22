package me.giverplay.modernal.server.net.packets;

import org.json.JSONObject;

import me.giverplay.modernal.server.net.PacketOut;

public class PacketOutPlayerJoin extends PacketOut
{
	public PacketOutPlayerJoin()
	{
		then("type", "PLAYER_JOIN");
	}
	
	@Override
	public String serialize()
	{
		JSONObject json = new JSONObject();
		
		for(String key : data.keySet())
		{
			json.put(key, data.get(key));
		}
		
		return json.toString();
	}
}
