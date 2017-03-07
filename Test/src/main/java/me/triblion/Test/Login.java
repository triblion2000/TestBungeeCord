package me.triblion.Test;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.PostLoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static sun.audio.AudioPlayer.player;

/**
 * Created by triblion on 07/03/2017.
 */
public class Login implements Listener {

    private Connection connection;
    private String host, database, username, password;
    private int port;

    @EventHandler
    public void onPostLogin(PostLoginEvent event) {
        host = "localhost";
        port = 3306;
        database = "FrozenSuite";
        username = "triblion";
        password = "Password";
        for (ProxiedPlayer player : ProxyServer.getInstance().getPlayers()) {
            player.sendMessage(new TextComponent(event.getPlayer().getName() + "has joined the network"));
            player.getUniqueId();
            try {
                connection.createStatement();
                
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    public void openConnection() throws SQLException, ClassNotFoundException {
        if(connection !=null && !connection.isClosed()) {
            return;
        }

        synchronized (this) {
            if(connection !=null && !connection.isClosed()) {
                return;
            }

            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://" + this.host + ":" + this.port + "/" + this.database, this.username, this.password);
        }
    }
}
