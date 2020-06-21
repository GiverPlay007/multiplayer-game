package me.giverplay.modernal.server.net;

import me.giverplay.modernal.server.objects.ServerLogger;

public class BadPacketException extends Exception
{
	private static final long serialVersionUID = 1L;
	
	public BadPacketException(PacketEntry entry)
	{
		ServerLogger.warn("Packet quebrado recebido");
	}
}
