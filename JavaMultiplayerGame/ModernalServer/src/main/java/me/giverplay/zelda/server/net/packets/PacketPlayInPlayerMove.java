package me.giverplay.zelda.server.net.packets;

import org.json.JSONObject;

import me.giverplay.zelda.server.net.PacketPlayIn;

public class PacketPlayInPlayerMove extends PacketPlayIn
{
	public PacketPlayInPlayerMove(String nick, int x, int y, boolean jump)
	{
		then("nickname", nick);
		then("x", x);
		then("y", y);
		then("jumping", jump);
		end();
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
