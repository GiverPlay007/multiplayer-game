package me.giverplay.modernal.server.net.packets;

import me.giverplay.modernal.server.net.PacketIn;

public class PacketInKeepAlive extends PacketIn
{
	public PacketInKeepAlive()
	{
		then("type", "KEEP_ALIVE");
	}
	
	@Override
	public String serialize()
	{
		// TODO
		return null;
	}
}
