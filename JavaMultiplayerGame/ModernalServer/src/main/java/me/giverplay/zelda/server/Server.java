package me.giverplay.zelda.server;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TimeZone;

import me.giverplay.zelda.server.entity.EntityPlayer;
import me.giverplay.zelda.server.net.ConnectionHandler;
import me.giverplay.zelda.server.objects.ServerLogger;
import me.giverplay.zelda.server.objects.world.Generator;
import me.giverplay.zelda.server.objects.world.ServerWorld;
import me.giverplay.zelda.server.objects.world.World;
import me.giverplay.zelda.server.tasks.TaskManager;

public class Server
{
	private static Server server;
	
	private HashMap<String, EntityPlayer> players = new HashMap<String, EntityPlayer>();
	private ArrayList<String> playersArray = new ArrayList<>(); // previnir erro de sincronia
	private ConnectionHandler handler;
	private TaskManager ts;
	private World world;
	
	public static void main(String[] args)
	{
		TimeZone.setDefault(TimeZone.getTimeZone("America/Sao_Paulo"));
		
		if(args.length > 0)
		{
			if(args[0].equalsIgnoreCase("-r"))
			{
				// resetar os dados do servidor
			}
		}
		
		ServerLogger.info("Iniciando servidor");
		
		server = new Server();
		
		ServerLogger.info("Servidor iniciado com sucesso");
	}
	
	public static Server getServer()
	{
		return server;
	}
	
	public Server()
	{
		server = this;
		
		try
		{
			handler = new ConnectionHandler(25871);
		}
		catch(IOException e)
		{
			ServerLogger.warn("Erro ConnectionHandler");
		}
		
		ts = new TaskManager();
		this.world = new ServerWorld(50, 50, Generator.generate(50, 50, Generator.RANDOM_PATH));
	}
	
	public ConnectionHandler getConnectionHandler()
	{
		return this.handler;
	}
	
	public HashMap<String, EntityPlayer> getPlayers()
	{
		return this.players;
	}
	
	public void registerPlayer(String nick, EntityPlayer player)
	{
		players.put(nick, player);
		playersArray.add(nick);
	}
	
	public TaskManager getTaskManager()
	{
		return this.ts;
	}
	
	public void removePlayer(String nick)
	{
		players.remove(nick);
		playersArray.remove(nick);
	}
	
	public int getPlayersCount()
	{
		return playersArray.size();
	}
	
	public ArrayList<String> getPlayersArray()
	{
		return this.playersArray;
	}

	public World getWorld()
	{
		return this.world;
	}
}