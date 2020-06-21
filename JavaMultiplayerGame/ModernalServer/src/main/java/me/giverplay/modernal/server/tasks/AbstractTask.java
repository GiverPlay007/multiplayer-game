package me.giverplay.modernal.server.tasks;

public abstract class AbstractTask extends Thread implements Runnable
{
	private String ID;
	
	public AbstractTask(String ID)
	{
		this.ID = ID;
	}
	
	public String getTaskID()
	{
		return this.ID;
	}
}
