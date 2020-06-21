package me.giverplay.zelda.server.tasks;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

import me.giverplay.zelda.server.entity.EntityPlayer;
import me.giverplay.zelda.server.net.Packet;
import me.giverplay.zelda.server.net.PacketEntry;
import me.giverplay.zelda.server.net.PacketHandler;
import me.giverplay.zelda.server.net.packets.PacketPlayOutWorld;
import me.giverplay.zelda.server.objects.ServerLogger;

@SuppressWarnings("unused")
public class SocketListenerTask extends AbstractTask
{
	private PrintStream saida;
	private Scanner entrada;
	private Socket socket;
	private EntityPlayer player;
	
	private boolean logged = false;
	
	private int error = 0;
	
	public SocketListenerTask(Socket socket, String key)
	{
		super(key);
		
		try
		{
			entrada = new Scanner(socket.getInputStream());
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.socket = socket;
	}
	
	@Override
	public void run()
	{ 
		boolean sair = false;
		
		while(!sair)
		{
			String in = entrada.nextLine();
			PacketHandler.handlePacketEntry(new PacketEntry(this.socket, in, getTaskID()));
		}
	}
	
	public void sendPacket(Packet packet)
	{
		try
		{
			saida = new PrintStream(socket.getOutputStream());
			saida.println(packet.serialize());
		}
		catch(IOException e)
		{
			ServerLogger.warn("Erro SocketListenerTask: " + e.getMessage());
		}
	}
	
	public void auth(String nick)
	{
		ServerLogger.log("Usuário autenticado com sucesso");
		this.logged = true;
		
		sendPacket(new PacketPlayOutWorld());
	}
}
