package me.giverplay.modernal.server.net.packets;

import org.json.JSONObject;

import me.giverplay.modernal.server.net.PacketOut;

public class PacketOutPlayerMove extends PacketOut
{
	public PacketOutPlayerMove()
	{
		then("type", "UPDATE_PLAYER");
	}
	
	public PacketOutPlayerMove(PacketInPlayerMove packet)
	{
		// Talvez não seja a forma mais eficiente;
		JSONObject json = new JSONObject(packet.serialize());
		
		then("type", "UPDATE_PLAYER");
		then("update_type", "PLAYER_MOVE");
		then("nickname", json.getString("nickname"));
		then("x", json.getInt("x"));
		then("y", json.getInt("y"));
		then("jump", json.getBoolean("jumping"));
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
