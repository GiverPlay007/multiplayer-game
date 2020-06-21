package me.giverplay.modernal.server.net;

public abstract class PacketPlayOut extends Packet
{
	public PacketPlayOut()
	{
		then("flow", "out"); // Para uma possível validação no PacketHandler
	}
}
