package me.giverplay.zelda.server.objects;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import me.giverplay.zelda.server.Server;

public class ServerLogger
{
	private static Logger LOGGER;
	
	static 
	{
		InputStream stream = Server.class.getResourceAsStream("/logger.properties");
		try 
		{
			LogManager.getLogManager().readConfiguration(stream);
			LOGGER = Logger.getLogger("Server");
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	public static void log(String log)
	{
		info(log);
	}
	
	public static void warn(String warn)
	{
		LOGGER.log(Level.WARNING, warn);
	}
	
	public static void info(String info)
	{
		LOGGER.log(Level.INFO, info);
	}
	
	public static void severe(String sev)
	{
		LOGGER.log(Level.SEVERE, sev);
	}
	
	public static void logToFile(String toLog)
	{
		
	}
}
