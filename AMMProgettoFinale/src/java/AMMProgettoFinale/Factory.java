/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AMMProgettoFinale;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author root
 */
public class Factory {

    private static Factory singleton;
    String connectionString;

    public static Factory getInstance() {
        if (singleton == null) {
            singleton = new Factory();
        }
        return singleton;
    }

    private Factory() {

    }
    
    public Cliente getCliente(String username, String password)
    {
        try
        {
            Connection conn = DriverManager
                    .getConnection(connectionString, 
                            "alessandrocarcangiu",
                            "0000");
            // sql command
            String query = "select * from cliente where "
                    + "password = ? and username = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            // dati
            stmt.setString(1, password);
            stmt.setString(2, username);
            //
            ResultSet set = stmt.executeQuery();
            
            if(set.next())
            {
                Cliente cliente = new Cliente();
                cliente.setId(set.getInt("id"));
                cliente.setNome(set.getString("nome"));
                cliente.setCognome(set.getString("cognome"));
                cliente.username = set.getString("username");
                cliente.password = set.getString("password");
                Statement st = conn.createStatement();
                ResultSet res2 = st.executeQuery(query);
                while(res2.next())
                {
                    
                }
                st.close();
                stmt.close();
                conn.close();
                
                return cliente;
            }
            stmt = conn.prepareStatement(query);
            // dati
            stmt.setString(1, password);
            stmt.setString(2, username);
            //
            set = stmt.executeQuery();
            
            stmt.close();
            conn.close();
        }
        catch(SQLException e)
        {
            
        }
        return null;
    }
}
