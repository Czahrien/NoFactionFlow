/**
 * File: NoFactionFlow.java
 * Description: A plugin to register the NoFactionFlowListener.
 */
package com.gmail.czahrien.NoFactionFlow;

import org.bukkit.plugin.java.JavaPlugin;


/**
 * A Plugin that registers the event listener!
 * @author Czahrien
 */
public class NoFactionFlow extends JavaPlugin {
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new NoFactionFlowListener(), this);
    }
}
