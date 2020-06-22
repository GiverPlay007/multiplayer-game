package me.giverplay.modernal.server.net.packets;

import org.json.JSONObject;

import me.giverplay.modernal.server.net.PacketIn;

public class PacketInLogin extends PacketIn
{
	public PacketInLogin()
	{
		then("type", "LOGIN");
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
