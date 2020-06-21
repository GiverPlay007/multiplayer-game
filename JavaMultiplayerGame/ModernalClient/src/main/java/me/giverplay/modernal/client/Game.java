package me.giverplay.modernal.client;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JFrame;

import me.giverplay.modernal.client.entity.Camera;
import me.giverplay.modernal.client.entity.entities.Player;
import me.giverplay.modernal.client.graphics.ImageOutput;
import me.giverplay.modernal.client.graphics.SpriteManager;
import me.giverplay.modernal.client.listeners.InputHandler;
import me.giverplay.modernal.client.world.World;

public class Game extends Canvas
{
	public static final long serialVersionUID = 1L;
	
	public static final int WIDTH = 380;
	public static final int HEIGHT = 260;
	public static final int SCALE = 2;
	
	private static String nick;
	private static String pass;
	
	private static boolean serverMode = false;
	private static boolean allReady = false;
	
	public static int FPS = 0;
	
	private static Game game;
	private static GameTask task;
	private static ServerTask server;
	
	private JFrame frame;
	private BufferedImage screen;
	
	private InputHandler input;
	private ImageOutput output;
	private Camera camera;
	private Player player;
	private World world;
	
	private boolean isRunning = false;
	
	public static void main(String[] args)
	{
		if(args.length < 3)
		{
			Log.severe("Você não está autenticado pelo launcher, finalizando processo");
			System.exit(-1);
		}
		
		nick = args[0];
		pass = args[1];
		serverMode = Boolean.valueOf(args[2]);
		
		setupStatic();		

		game = new Game();
		game.start();
	}
	
	public static void setupStatic()
	{
		SpriteManager.init();
	}
	
	public static String getNickname()
	{
		return nick;
	}
	
	public static String getPassword()
	{
		return pass;
	}
	
	public static boolean allReady()
	{
		return allReady;
	}
	
	public static Game getGame()
	{
		return game;
	}
	
	public static void setAllReady(boolean toSet)
	{
		allReady = toSet;
	}
	
	public Game()
	{
		if(serverMode)
		{
			try
			{
				server = new ServerTask(this, new Socket("02.fh-inter.host", 25871));
			} 
			catch (UnknownHostException e)
			{
				Log.severe("Falha ao conectar com o servidor");
				System.exit(-1);
			} 
			catch (IOException e)
			{
				Log.severe("Falha ao estabelecer conexão");
				System.exit(-1);
			}
		}
		
		setupFrame();
		setupAssets();
	}
	
	private void setupFrame()
	{
		setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		frame = new JFrame("Tec tec tec tec tec tec tec tec tec");
		frame.add(this);
		frame.setResizable(false);
		frame.setUndecorated(false);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		requestFocus();
	}
	
	private void setupAssets()
	{
		game = this;
		
		screen = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		output = new ImageOutput(this);
		
		input = new InputHandler(this);
		camera = new Camera(100, 100);
		player = new Player(32, 32);
		server.start();
	}
	
	public synchronized void start()
	{
		isRunning = true;
		task = new GameTask(this);
		task.start();
	}
	
	public synchronized void stop()
	{
		isRunning = false;
	}
	
	public synchronized void tick()
	{
		if(!allReady)
		{
			updateGame();
			return;
		}
		
		if(!hasFocus())
			input.releaseAll();
		
		input.tick();
		player.tick();
	}
	
	public synchronized void render()
	{
		BufferStrategy bs = getBufferStrategy();
		
		if(bs == null)
		{
			createBufferStrategy(3);
			return;
		}
		
		if(allReady)
			output.render(screen);
		
		Graphics graphics = bs.getDrawGraphics();
		graphics.drawImage(screen, 0, 0, WIDTH * SCALE, HEIGHT * SCALE, null);
		
		output.renderNickname(player);
		
		bs.show();
	}
	
	public void updateGame()
	{
		if(!server.checkReady())
			return;
		
		world = new World(server.getWorld());
		allReady = true;
	}
	
	public Player getPlayer()
	{
		return this.player;
	}
	
	public BufferedImage getScreen()
	{
		return this.screen;
	}
	
	public Camera getCamera()
	{
		return this.camera;
	}
	
	public ImageOutput getOutput()
	{
		return this.output;
	}
	
	public boolean isRunning()
	{
		return this.isRunning;
	}
	
	public InputHandler getInput()
	{
		return this.input;
	}
	
	public World getWorld()
	{
		return world;
	}
	
	public ServerTask getServerWrapper()
	{
		return server;
	}
}
