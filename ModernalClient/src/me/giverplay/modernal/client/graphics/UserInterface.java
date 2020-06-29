package me.giverplay.modernal.client.graphics;

import java.awt.Color;
import java.awt.Graphics;

import me.giverplay.modernal.client.Game;
import me.giverplay.modernal.client.entity.entities.Player;
import me.giverplay.modernal.client.listeners.InputHandler;

public class UserInterface
{
	private Game game;
	private InputHandler in;
	
	public UserInterface(Game game)
	{
		this.game = game;
	}
	
  public void tick()
  {
  	if(in == null)
  		in = game.getInput();
  }
  
  public void render(Graphics g)
  {
  	game.addPendingRender(new Runnable()
		{
			@Override
			public void run()
			{				
				Player player = game.getPlayer();
				int coe = calcLife(player.getMaxLife());
				
				player.ModifyLife(+1);
				
				g.setColor(Color.BLACK);
				g.drawRect(12, 12, coe + 1, 26);
				
				g.setColor(Color.RED);
				g.fillRect(13, 13, coe, 25);
				
				g.setColor(Color.GREEN);
				g.fillRect(13, 13, calcLife(player.getLife()), 25);
			}
		});
  }
  
  private int calcLife(int life) 
  {  	
  	return 250 * life / 100;
  }
}
