package me.giverplay.modernal.server.net;

public abstract class PacketOut extends Packet
{
	public PacketOut()
	{
		then("flow", "out"); // Para uma possível validação no PacketHandler
	}
}
