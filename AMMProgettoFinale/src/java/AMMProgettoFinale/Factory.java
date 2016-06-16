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
    
    public void setConnectionString(String s){
	this.connectionString = s;
    }
    public String getConnectionString(){
	return this.connectionString;
    }
    
    public Utente getUtente(String username, String password)
    {
        try{
            Connection conn= DriverManager.getConnection(connectionString, "mattiamancosu", "1234");
            
            String query = "select * from venditore where username = ? and password = ?";
            
            PreparedStatement stmt= conn.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, password);
            
            ResultSet res = stmt.executeQuery();
            
            if(res.next())
            {
                Venditore venditore = new Venditore();
                venditore.setId(res.getInt("id"));
                venditore.setNome(res.getString("nome"));
                venditore.setCognome(res.getString("cognome"));
                venditore.setUsername(res.getString("username"));
                venditore.setPassword(res.getString("password"));
                venditore.setSaldo(res.getDouble("saldo"));
                
                query = "select * from prodotto"
                        + " where idVenditore = "+ venditore.getId();
                Statement st= conn.createStatement();
                ResultSet res2= st.executeQuery(query);
                
                while(res2.next())
                {
                    Prodotto o = new Prodotto();
                    o.setId(res2.getInt("id"));
                    o.setNome(res2.getString("nome"));
                    o.setURLImmagine(res2.getString("imageURL"));
                    o.setDescrizione(res2.getString("descrizione"));
                    o.setPrezzo(res2.getDouble("prezzo"));
                    o.setDisponibilita(res2.getInt("disponibilita"));
                    venditore.getProdottiVenditore().add(o);
                }
                
                st.close();
                stmt.close();
                conn.close();
                return venditore;
            }
            
            
            query = "select * from cliente where username = ? and password = ?";
            stmt = conn.prepareStatement(query);
            
            stmt.setString(1, username);
            stmt.setString(2, password);
            res = stmt.executeQuery();
            
            if (res.next())
            {
                Cliente cliente = new Cliente();
                cliente.setId(res.getInt("id"));
                cliente.setNome(res.getString("nome"));
                cliente.setCognome(res.getString("cognome"));
                cliente.setUsername(res.getString("username"));
                cliente.setPassword(res.getString("password"));
                cliente.setSaldo(res.getDouble("saldo"));
                
                stmt.close();
                conn.close();
                return cliente;
            }
            stmt.close();
            conn.close();
        }
        catch(SQLException e)
        {
        
        }
        return null;
    }
}
