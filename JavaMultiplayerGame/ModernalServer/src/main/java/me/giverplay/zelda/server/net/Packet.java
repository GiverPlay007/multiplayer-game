package me.giverplay.zelda.server.net;

import java.util.HashMap;

public abstract class Packet
{
	protected HashMap<String, Object> data = new HashMap<>();
	
	private boolean immutable = false;
	
	public Packet()
	{
		
	}
	
	public Packet(String json)
	{
		
	}
	
	public Packet then(String tagKey, Object tagValue)
	{
		if(immutable)
			throw new IllegalStateException("Packets finalizados não podem ser alterados");
			
		data.put(tagKey, tagValue);
		return this;
	}
	
	public Packet end()
	{
		if(immutable)
			throw new IllegalStateException("Packets finalizados não podem ser alterados");
		
		immutable = true;
		return this;
	}
	
	public abstract String serialize();
}
