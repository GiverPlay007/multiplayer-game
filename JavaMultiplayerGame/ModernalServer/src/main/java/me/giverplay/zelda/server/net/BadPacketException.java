package me.giverplay.zelda.server.net;

import me.giverplay.zelda.server.objects.ServerLogger;

public class BadPacketException extends Exception
{
	private static final long serialVersionUID = 1L;
	
	public BadPacketException(PacketEntry entry)
	{
		ServerLogger.warn("Packet quebrado recebido");
	}
}
