package me.giverplay.modernal.server.net.packets;

import org.json.JSONObject;

import me.giverplay.modernal.server.net.PacketIn;

public class PacketInPlayerMove extends PacketIn
{
	public PacketInPlayerMove(String nick, int x, int y, boolean jump)
	{
		then("type", "PLAYER_MOVE");
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
