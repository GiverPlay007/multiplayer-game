package me.giverplay.modernal.server;

import java.io.IOException;
import java.util.TimeZone;

import me.giverplay.modernal.server.net.ConnectionHandler;
import me.giverplay.modernal.server.objects.ServerLogger;
import me.giverplay.modernal.server.objects.world.Generator;
import me.giverplay.modernal.server.objects.world.ServerWorld;
import me.giverplay.modernal.server.objects.world.World;
import me.giverplay.modernal.server.tasks.TaskManager;

public class Server
{
	private static Server server;
	
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
	
	public TaskManager getTaskManager()
	{
		return this.ts;
	}

	public World getWorld()
	{
		return this.world;
	}
}