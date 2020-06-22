package me.giverplay.modernal.server.tasks;

import me.giverplay.modernal.server.Server;
import me.giverplay.modernal.server.objects.world.World;

public class ServerTask extends AbstractTask
{
	public ServerTask(String ID)
	{
		super(ID);
	}
	
	@Override
	public void run()
	{
		long lastTime = System.nanoTime();
		
		double ticks = 60.0D;
		double ns = 1000000000 / ticks;
		double delta = 0.0D;
		
		while(true)
		{
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			
			if(delta >= 1)
			{
				World world = Server.getServer().getWorld();
				
				if(world != null)
					world.tick();
				
				delta--;
			}
		}
	}
}
