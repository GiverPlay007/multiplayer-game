package me.giverplay.modernal.server.net;

public abstract class PacketPlayIn extends Packet
{
	public PacketPlayIn()
	{
		then("flow", "in"); // Para uma possível validação no PacketHandler
	}
}
