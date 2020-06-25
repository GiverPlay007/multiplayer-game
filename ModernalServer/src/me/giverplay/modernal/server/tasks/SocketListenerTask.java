package me.giverplay.modernal.server.tasks;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

import me.giverplay.modernal.server.Server;
import me.giverplay.modernal.server.entity.EntityPlayer;
import me.giverplay.modernal.server.net.Packet;
import me.giverplay.modernal.server.net.PacketEntry;
import me.giverplay.modernal.server.net.PacketHandler;
import me.giverplay.modernal.server.net.packets.PacketOutWorld;
import me.giverplay.modernal.server.objects.ServerLogger;

public class SocketListenerTask extends AbstractTask
{
	private PrintStream saida;
	private Scanner entrada;
	private Socket socket;
	private EntityPlayer player;
	
	private boolean logged = false;
	private boolean sair = false;
	
	public SocketListenerTask(Socket socket, String key)
	{
		super(key);
		
		try
		{
			entrada = new Scanner(socket.getInputStream());
			saida = new PrintStream(socket.getOutputStream());
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		this.socket = socket;
	}
	
	@Override
	public void run()
	{ 
		while(!sair)
		{
			try
			{
				String in = entrada.nextLine();
				PacketHandler.handlePacketEntry(new PacketEntry(this.socket, in, getTaskID()));
			}
			catch(Exception e)
			{
				break;
			}
		}
		
		ServerLogger.log("Desconectando " + player.getName());
		
		try
		{
			socket.close();
		} 
		catch (IOException e)
		{
			ServerLogger.warn("Erro ao fechar socket");
		}
		
		Server.getServer().getWorld().removePlayer(player.getName());
		Server.getServer().getTaskManager().remove(getTaskID());
	}
	
	public void sendPacket(Packet packet)
	{
		saida.println(packet.serialize());
	}
	
	public void auth(String nick)
	{
		ServerLogger.log("Usuário " + nick + " autenticado com sucesso");
		
		this.player = Server.getServer().getWorld().addPlayer(nick, this);
		this.logged = true;
		
		sendPacket(new PacketOutWorld());
	}
	
	public void disconnect()
	{
		sair = true;
	}
	
	public EntityPlayer getPlayer()
	{
		return this.player;
	}
	
	public boolean isLogged()
	{
		return this.logged;
	}
}
