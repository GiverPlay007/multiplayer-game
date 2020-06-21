package me.giverplay.zelda.server.net.packets;

import org.json.JSONObject;

import me.giverplay.zelda.server.net.PacketPlayIn;

public class PacketPlayInLogin extends PacketPlayIn
{
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
