package me.giverplay.zelda.server.net;

public abstract class PacketPlayOut extends Packet
{
	public PacketPlayOut()
	{
		then("flow", "out"); // Para uma possível validação no PacketHandler
	}
}
