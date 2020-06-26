package me.giverplay.modernal.server.net.packets;

import org.json.JSONObject;

import me.giverplay.modernal.server.net.PacketOut;

public class PacketOutPlayerQuit extends PacketOut
{
	public PacketOutPlayerQuit()
	{
		then("type", "PLAYER_QUIT");
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
