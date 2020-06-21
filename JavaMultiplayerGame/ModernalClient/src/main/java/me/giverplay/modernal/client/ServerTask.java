package me.giverplay.modernal.client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

import org.json.JSONException;
import org.json.JSONObject;

public class ServerTask extends Thread implements Runnable
{
	private Scanner entrada;
	private PrintWriter saida;
	private JSONObject worldData = null;
	
	public ServerTask(Game game, Socket socket)
	{
		
		try
		{
			entrada = new Scanner(socket.getInputStream());
			saida = new PrintWriter(socket.getOutputStream(), true);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		JSONObject json = new JSONObject();
		json.put("type", "LOGIN");
		json.put("nickname", Game.getNickname());
		json.put("password", Game.getPassword());
		sendPacket(json);
	}
	
	@Override
	public void run()
	{
		while(Game.getGame().isRunning())
		{
			try
			{
				String entry = entrada.nextLine();
				handleEntry(new JSONObject(entry));
			} 
			catch (JSONException e)
			{
				Log.warn("Recebendo JSON mal formada");
			}
		}
	}
	
	private void handleEntry(JSONObject json)
	{
		String entry = json.getString("type");
		Log.info(json.toString());
		switch (entry)
		{
			case "WORLD":
				worldData = json;
				break;
				
			case "UPDATE_PLAYER":
				Game.getGame().getWorld().updatePlayer(json);
				break;
				
			case "UPDATE_ENTITY":
				Game.getGame().getWorld().updateEntity(json);
				break;
				
			default:
				break;
		}
	}
	
	public void sendPacket(JSONObject json)
	{
		saida.println(json.toString());
	}
	
	public void updatePlayer(int x, int y, boolean jump)
	{
		JSONObject json = new JSONObject();
		
		json.put("type", "PLAYER_MOVE");
		json.put("nickname", Game.getNickname());
		json.put("x", x);
		json.put("y", y);
		json.put("jumping", jump);
		
		sendPacket(json);
	}
	
	public boolean checkReady()
	{
		return worldData != null;
	}
	
	public JSONObject getWorld()
	{
		return worldData;
	}
}
