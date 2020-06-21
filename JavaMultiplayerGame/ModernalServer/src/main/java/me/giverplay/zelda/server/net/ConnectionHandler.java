package me.giverplay.zelda.server.net;

import java.io.IOException;

public class ConnectionHandler
{
	private SocketServer socket;
	
	public ConnectionHandler(int port) throws IOException
	{
		this.socket = new SocketServer(port);
	}
	
	public SocketServer getConnection()
	{
		return this.socket;
	}
}
