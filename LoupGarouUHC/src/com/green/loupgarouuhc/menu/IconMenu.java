package com.green.loupgarouuhc.menu;

import java.util.Arrays;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

public class IconMenu implements Listener {
	 
    private String name;
    private int size;
    private OptionClickEventHandler handler;
    private InventoryClosedEventHandler closeHandler;
    private Plugin plugin;
    
    public Inventory inventory;
   
    public IconMenu(String name, int size, OptionClickEventHandler handler, InventoryClosedEventHandler closeHandler, Plugin plugin) {
        this.name = name;
        this.size = size;
        this.handler = handler;
        this.closeHandler = closeHandler;
        this.plugin = plugin;
        this.inventory = Bukkit.createInventory(null, size, name);
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }
   
    public IconMenu setOption(int position, ItemStack icon, String name, String... info) {
    	inventory.setItem(position, setItemNameAndLore(icon, name, info));
        return this;
    }
   
    public void open(Player player) {
        player.openInventory(inventory);
    }
   
    public void destroy() {
    	HandlerList.unregisterAll(this);
        handler = null;
        plugin = null;
        inventory = null;
    }
    
    public void close(Player player) {
    	final Player p = player;
        Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
            public void run() {
                p.closeInventory();
            }
        }, 1);
    }
    
    @EventHandler
    void onInventoryClick(InventoryClickEvent event) {
        if (event.getInventory().getTitle().equals(name)) {
            event.setCancelled(true);
            int slot = event.getRawSlot();
            if (slot >= 0 && slot < size) {
                OptionClickEvent e = new OptionClickEvent((Player)event.getWhoClicked(), slot);
                handler.onOptionClick(e);
                
                Player player = (Player)event.getWhoClicked();
                
                switch (e.action) {
					case Close:
						close(player);
						break;
					case Destroy:
						close(player);
						destroy();
						break;
					case Nothing: break;
				}
            }
        }
    }
    
    @EventHandler
    void onInventoryClosed(InventoryCloseEvent event) {
    	InventoryClosedEvent mustDestroy = new InventoryClosedEvent(false);
    	
    	closeHandler.onInventoryClosed(mustDestroy);
    	
    	if (mustDestroy.mustDestroy) {
        	destroy();
    	}
    }
    
    public interface InventoryClosedEventHandler {
        public void onInventoryClosed(InventoryClosedEvent event);       
    }
    
    public interface OptionClickEventHandler {
        public void onOptionClick(OptionClickEvent event);       
    }
    
    public static class InventoryClosedEvent {
    	public boolean mustDestroy = false;
    	
    	public InventoryClosedEvent(boolean mustDestroy) {
			this.mustDestroy = mustDestroy;
		}
    }
    
    public static class OptionClickEvent {
        private Player player;
        private int position;
        private ActionClick action;
       
        public OptionClickEvent(Player player, int position) {
            this.player = player;
            this.position = position;
            this.action = ActionClick.Nothing;
        }
       
        public Player getPlayer() {
            return player;
        }
       
        public int getPosition() {
            return position;
        }
       
        public ActionClick getClickAction() {
            return action;
        }
       
        public void setAction(ActionClick action) {
            this.action = action;
        }
        
        public static enum ActionClick {
        	Close,
        	Destroy,
        	Nothing
        }
    }
   
    private ItemStack setItemNameAndLore(ItemStack item, String name, String[] lore) {
        ItemMeta im = item.getItemMeta();
            im.setDisplayName(name);
            im.setLore(Arrays.asList(lore));
        item.setItemMeta(im);
        return item;
    }
   
}