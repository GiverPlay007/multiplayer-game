package me.giverplay.modernal.server.net;

import java.net.Socket;

public class PacketEntry
{
	private String entry;
	private Socket socket;
	private String ID;
	
	public PacketEntry(Socket socket, String entry, String taskID)
	{
		this.socket = socket;
		this.entry = entry;
		this.ID = taskID;
	}
	
	public Socket getClient()
	{
		return this.socket;
	}
	
	public String getEntry()
	{
		return this.entry;
	}
	
	public String getID()
	{
		return ID;
	}
}
