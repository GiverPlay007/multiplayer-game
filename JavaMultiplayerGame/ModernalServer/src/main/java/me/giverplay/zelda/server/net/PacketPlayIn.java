package me.giverplay.zelda.server.net;

public abstract class PacketPlayIn extends Packet
{
	public PacketPlayIn()
	{
		then("flow", "in"); // Para uma possível validação no PacketHandler
	}
}
