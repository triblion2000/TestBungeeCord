package me.triblion.Test;

import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by triblion on 05/03/2017.
 */
public class Test extends Plugin implements Listener {

    private Connection connection;
    private String host, database, username, password;
    private int port;

    @Override
    public void onEnable() {
        getLogger().info("The plugin has loaded");
        host = "localhost";
        port = 3306;
        database = "FrozenSuite";
        username = "triblion";
        password = "Password";
        try {
            openConnection();
            Statement statement = connection.createStatement();
            getLogger().info("Connected to database");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        getProxy().getPluginManager().registerListener(this, new Login());
        getProxy().getPluginManager().registerListener(this, new Logout());
    }

    @Override
    public void onDisable() {

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






//• Must be a bungee plugin.
// • Needs to count the number of unique players in a 24 hour & 1 month period.
// • Needs to count the number of unique players that visit the network in total
// • If a new player joins, send a message across the network welcoming the player (&6Welcome &3playername &6to The FrozenSoul Network!!)

