package me.giverplay.modernal.client.entity.entities;

import static me.giverplay.modernal.client.graphics.SpriteManager.TILE_SIZE;

import java.awt.Graphics;

import me.giverplay.modernal.client.Game;
import me.giverplay.modernal.client.entity.Camera;
import me.giverplay.modernal.client.entity.HumanEntity;
import me.giverplay.modernal.client.listeners.InputHandler;

public class Player extends HumanEntity
{
	private static final int RIGHT = 0;
	private static final int LEFT = 1;
	private static final int UP = 2;
	private static final int DOWN  = 3;
	
	private Game game;
	private Camera camera;
	private InputHandler input;
	
	private int dir = 0;
	
	public Player(int x, int y)
	{
		super(Game.getNickname(), true, x, y, 100, 10, 12, 10, 20);
		
		game = Game.getGame();
		camera = game.getCamera();
		input = game.getInput();
	}
	
	@Override
	public void tick()
	{
		super.tick();
		
		updateInteraction();
		updateCamera();
	}
	
	@Override
	public void render(Graphics g)
	{
		super.render(g);
	}
	
	private void updateInteraction()
	{
		byte xi = 0;
		byte yi = 0;
		
		if(input.right.down)
			xi++;
		
		if(input.left.down)
			xi--;
		
		if(input.up.down)
			yi--;
		
		if(input.down.down)
			yi++;
		
		dir = yi > 0 ? DOWN : yi < 0 ? UP : xi > 0 ? RIGHT : xi < 0 ? LEFT : dir;
		
		isMoving = moveRelative(xi, yi);
		
		if(isMoving && game.isServerMode())
			game.getServerWrapper().updatePlayer(xi, yi, false);
	}
	
	private void updateCamera()
	{
		camera.setX(camera.clamp(getX() - (Game.WIDTH / 2), 0, game.getWorld().getHeight() * TILE_SIZE - Game.WIDTH));
		camera.setY(camera.clamp(getY() - (Game.HEIGHT / 2), 0, game.getWorld().getWidth() * TILE_SIZE - Game.HEIGHT));
	}
}
