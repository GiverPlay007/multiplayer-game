package me.giverplay.zelda.server.tasks;

import java.io.IOException;
import java.net.Socket;

import me.giverplay.zelda.server.Server;
import me.giverplay.zelda.server.objects.ServerLogger;

public class SocketTask extends AbstractTask
{
	public SocketTask(String ID)
	{
		super(ID); 
	}

	@Override
	public void run()
	{
		Server server = Server.getServer();
		
		while(true)
		{
			try
			{
				Socket socket = server.getConnectionHandler().getConnection().getListener().accept();
				Server.getServer().getTaskManager().handleNewClientTask(socket);
				
				ServerLogger.log("Cliente novo conectado, aguardando autenticação");
			} 
			catch (IOException e)
			{
				ServerLogger.log("Falha ao estabelecer conexão com o cliente");
				e.printStackTrace();
			}
			
			try
			{
				Thread.sleep(1000 / 50);
			}
			catch(InterruptedException e)
			{
				ServerLogger.warn("Atividade interrompida");
			}
		}
	}
}
