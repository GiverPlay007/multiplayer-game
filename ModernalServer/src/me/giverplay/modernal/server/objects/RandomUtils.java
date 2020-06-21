package me.giverplay.modernal.server.objects;

import java.security.SecureRandom;

public class RandomUtils
{
	private static final SecureRandom rand = new SecureRandom();
	private static final String CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	
	public static String generateKey(int size)
	{
		String result = "";
		
		for(int i = 0; i <= size; i++)
		{
			result += CHARS.charAt(rand.nextInt(CHARS.length()));
		}
		
		return result.trim();
	}

	public static SecureRandom getRandom()
	{
		return rand;
	}
}
