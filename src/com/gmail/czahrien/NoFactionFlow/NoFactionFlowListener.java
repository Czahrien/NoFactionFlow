/**
 * File: NoFactionFlowListener.java
 * Description: Prevents Invictum's lolcanos. Now none of you will know the
 *              true glory of the lolcano. Your loss, not ours.
 */
package com.gmail.czahrien.NoFactionFlow;

import com.massivecraft.factions.Board;
import com.massivecraft.factions.FLocation;
import com.massivecraft.factions.Faction;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFromToEvent;


/**
 * A Listener containing the BlockFromToEvent Listener which implements the
 * desired behavior.
 * @author Czahrien
 */
public class NoFactionFlowListener implements Listener {
    public NoFactionFlowListener() {}
    
    /**
     * Simple listener that lets fluid flow into faction land if and only if
     * it started in the same faction's land. Additionally this allows for
     * fluid to flow out of a faction's land and into wilderness.
     * 
     * @param e The event.
     */
    @EventHandler
    public void blockFromTo(BlockFromToEvent e) {
        Faction srcFac = Board.getFactionAt(new FLocation(e.getBlock().getLocation()));
        Faction dstFac = Board.getFactionAt(new FLocation (e.getToBlock().getLocation()));
        
        // Cancel if the destination is not wilderness and the destination is
        // not the current faction's land.
        if(!dstFac.isNone() && !dstFac.equals(srcFac)) {
            e.setCancelled(true);
        }        
    }
    
}
