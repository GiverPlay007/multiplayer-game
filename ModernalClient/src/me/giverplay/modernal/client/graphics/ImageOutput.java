package me.giverplay.modernal.client.graphics;

import static me.giverplay.modernal.client.Game.SCALE;
import static me.giverplay.modernal.client.graphics.SpriteManager.TILE_SIZE;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import me.giverplay.modernal.client.Game;
import me.giverplay.modernal.client.entity.Camera;
import me.giverplay.modernal.client.entity.Entity;
import me.giverplay.modernal.client.entity.entities.Player;

public class ImageOutput
{
	private Game game;
	private Player player;
	
	public ImageOutput(Game game)
	{
		this.game = game;
		this.player = game.getPlayer();
	}
	
	public void render(BufferedImage image)
	{
		if(player == null)
			player = game.getPlayer();
		
		Graphics g2 = image.getGraphics();
		
		g2.setColor(new Color(0, 0, 0));
		g2.fillRect(0, 0, Game.WIDTH * Game.SCALE, Game.HEIGHT * Game.SCALE);
		
		game.getWorld().render(g2);
		player.render(g2);
		
		g2.dispose();
	}
	
	public Graphics getSmoothGraphics()
	{
		return game.getBufferStrategy().getDrawGraphics();
	}
	
	public void renderNickname(Entity ent)
	{
		if(!ent.showName())
			return;
		
		Camera cam = game.getCamera();
		
		Graphics g = getSmoothGraphics();
		g.setColor(Color.BLACK);
		g.setFont(FontUtils.getFont(11, Font.PLAIN));

		g.drawString(ent.getName(), (ent.getX() - cam.getX() + TILE_SIZE - g.getFontMetrics(g.getFont()).stringWidth(ent.getName()) / 2) * SCALE, (ent.getY() - cam.getY() - 5) * SCALE);
	}
}
