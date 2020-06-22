package me.giverplay.modernal.server.entity;

import me.giverplay.modernal.server.inventory.Item;
import me.giverplay.modernal.server.net.Packet;
import me.giverplay.modernal.server.objects.SoundType;
import me.giverplay.modernal.server.objects.Toast;
import me.giverplay.modernal.server.tasks.SocketListenerTask;

public class EntityPlayer extends HumanEntity implements Player
{
	private SocketListenerTask task;
	
	public EntityPlayer(String nick, SocketListenerTask task, int x, int y)
	{
		super(nick, x, y);
		
		this.task = task;
	}
	
	@Override
	public void damage(int toDamage)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void health(int toHealth)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendToast(Toast toast)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void playSound(SoundType sound, int volume, int pitch)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setEquippedItem(Item item)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendPacket(Packet packet)
	{
		task.sendPacket(packet);
	}

	@Override
	public boolean hasEquippedItem()
	{
		// TODO Auto-generated method stub
		return false;
	}
}
