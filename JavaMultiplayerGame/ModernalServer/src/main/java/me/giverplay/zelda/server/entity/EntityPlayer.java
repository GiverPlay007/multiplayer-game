package me.giverplay.zelda.server.entity;

import me.giverplay.zelda.server.inventory.Item;
import me.giverplay.zelda.server.net.Packet;
import me.giverplay.zelda.server.objects.SoundType;
import me.giverplay.zelda.server.objects.Toast;

public class EntityPlayer extends HumanEntity implements Player
{
	private String nick;
	
	public EntityPlayer(String nick, int x, int y)
	{
		super(x, y);
		
		this.nick = nick;
	}
	
	public void setName(String name)
	{
		this.nick = name;
	}
	
	public String getName()
	{
		return nick;
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
	public boolean sendPacket(Packet packet)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasEquippedItem()
	{
		// TODO Auto-generated method stub
		return false;
	}
}
