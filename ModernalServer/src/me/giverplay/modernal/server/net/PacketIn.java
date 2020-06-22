package me.giverplay.modernal.server.net;

public abstract class PacketIn extends Packet
{
	public PacketIn()
	{
		then("flow", "in"); // Para uma possível validação no PacketHandler
	}
}
