package me.triblion.Test;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.ServerDisconnectEvent;
import net.md_5.bungee.api.plugin.Listener;

import java.util.List;

/**
 * Created by triblion on 07/03/2017.
 */
public class Logout implements Listener {

    public void onPostLogout(ServerDisconnectEvent event) {
        for (ProxiedPlayer player : ProxyServer.getInstance().getPlayers()) {
            player.sendMessage(new TextComponent(event.getPlayer().getName() + "has left the network"));
        }
    }
}
