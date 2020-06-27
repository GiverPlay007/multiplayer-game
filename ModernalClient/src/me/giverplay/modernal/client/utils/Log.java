package me.giverplay.modernal.client.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import me.giverplay.modernal.client.Game;

public class Log
{
	private static Logger LOGGER;
	
	static 
	{
		InputStream stream = Game.class.getResourceAsStream("/logger.properties");
		try 
		{
			LogManager.getLogManager().readConfiguration(stream);
			LOGGER = Logger.getLogger("Game");
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
