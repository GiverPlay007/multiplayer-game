package me.giverplay.modernal.server.net;

import java.io.IOException;
import java.net.ServerSocket;

public class SocketServer
{
	private ServerSocket listener;
	
	public SocketServer(int port) throws IOException
	{
		this.listener = new ServerSocket(port);
	}
	
	public ServerSocket getListener()
	{
		return this.listener;
	}
}
