package me.giverplay.modernal.server.entity;

import me.giverplay.modernal.server.inventory.Inventory;
import me.giverplay.modernal.server.inventory.Item;
import me.giverplay.modernal.server.net.Packet;
import me.giverplay.modernal.server.objects.SoundType;
import me.giverplay.modernal.server.objects.Toast;

public interface Player
{
	public void damage(int toDamage);
	public void health(int toHealth);
	public void sendToast(Toast toast);
	public void playSound(SoundType sound, int volume, int pitch);
	public void setEquippedItem(Item item);
	
	public Inventory getInventory();
	
	public boolean sendPacket(Packet packet);
	public boolean hasEquippedItem();
}
