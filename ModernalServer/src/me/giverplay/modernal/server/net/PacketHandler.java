package me.giverplay.modernal.server.net;

import java.io.IOException;

import org.json.JSONObject;

import me.giverplay.modernal.server.Server;
import me.giverplay.modernal.server.net.packets.PacketInLogin;
import me.giverplay.modernal.server.net.packets.PacketInPlayerMove;
import me.giverplay.modernal.server.objects.ServerLogger;
import me.giverplay.modernal.server.tasks.SocketListenerTask;

public class PacketHandler
{
	public static void handlePacketEntry(PacketEntry entry)
	{		
		try
		{
			JSONObject json = new JSONObject(entry.getEntry());
			
			PacketEnum type = PacketEnum.valueOf(json.getString("type"));
			
			switch (type)
			{
				case LOGIN:
					handleLogin(entry);
					break;	
					
				case PLAYER_MOVE:
					handleMove(entry);
					break;
					
				default:
					ServerLogger.warn("Packet inválido");
			}
		}
		catch(Exception e)
		{
			ServerLogger.severe("Erro: " + e.getMessage() + " | " + e.getCause());
		}
	}
	
	private static void handleMove(PacketEntry entry)
	{
		JSONObject json = new JSONObject(entry.getEntry());
		String nick = json.getString("nickname");
		boolean bool = json.getBoolean("jumping");
		int x = json.getInt("x");
		int y = json.getInt("y");
		
		PacketInPlayerMove packet = new PacketInPlayerMove(nick, x, y, bool);
		Server.getServer().getWorld().handlePlayerMove(packet);
	}

	private static void handleLogin(PacketEntry entry)
	{
		JSONObject json = new JSONObject(entry.getEntry());
		String nick = json.getString("nickname");
		String pass = json.getString("password");
		
		PacketInLogin packet = (PacketInLogin) new PacketInLogin()
				.then("nickname", nick)
				.then("password", pass)
				.end();
		
		String result = validateLogin(packet);
		
		if(result == null)
		{
			try
			{
				entry.getClient().getOutputStream().write(("Login inválido, tente reiniciar o jogo").getBytes());
				entry.getClient().getOutputStream().flush();
				entry.getClient().close();
			}
			catch(IOException e)
			{
				ServerLogger.warn("Erro ao processar login do último cliente");
			}
			
			return;
		}

		((SocketListenerTask) Server.getServer().getTaskManager().getTask(entry.getID())).auth(result);	
	}
	
	public static String validateLogin(PacketInLogin packet)
	{
		JSONObject json = new JSONObject(packet.serialize());
		final String nick = json.getString("nickname");
		
		ServerLogger.log("Recebemos um jogador: Nick: " + nick);
		
		return nick;
	}
	
	public static void processInputPacket(PacketIn packet)
	{
		
	}
}
