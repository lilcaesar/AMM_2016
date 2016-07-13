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

    public void setConnectionString(String s) {
        this.connectionString = s;
    }

    public String getConnectionString() {
        return this.connectionString;
    }

    public Utente getUtente(String username, String password) {
        try {
            Connection conn = DriverManager.getConnection(connectionString, "mattiamancosu", "1234");

            String query = "select * from venditore where username = ? and password = ?";

            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, password);

            ResultSet res = stmt.executeQuery();

            if (res.next()) {
                Venditore venditore = new Venditore();
                venditore.setId(res.getInt("id"));
                venditore.setNome(res.getString("nome"));
                venditore.setCognome(res.getString("cognome"));
                venditore.setUsername(res.getString("username"));
                venditore.setPassword(res.getString("password"));
                venditore.setSaldo(res.getDouble("saldo"));

                query = "select * from prodotto" + " where idVenditore = " + venditore.getId();
                Statement st = conn.createStatement();
                ResultSet res2 = st.executeQuery(query);

                while (res2.next()) {
                    Prodotto p = new Prodotto();
                    p.setId(res2.getInt("id"));
                    p.setNome(res2.getString("nome"));
                    p.setURLImmagine(res2.getString("URLImmagine"));
                    p.setDescrizione(res2.getString("descrizione"));
                    p.setPrezzo(res2.getDouble("prezzo"));
                    p.setDisponibilita(res2.getInt("disponibilita"));
                    venditore.getProdottiVenditore().add(p);
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

            if (res.next()) {
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Venditore getVenditore(int id) {
        try {
            Connection conn = DriverManager.getConnection(connectionString, "mattiamancosu", "1234");
            String query = "select * from venditore " + "where id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet res = stmt.executeQuery();

            if (res.next()) {
                Venditore venditore = new Venditore();
                venditore.setId(res.getInt("id"));
                venditore.setNome(res.getString("nome"));
                venditore.setCognome(res.getString("cognome"));
                venditore.setUsername(res.getString("username"));
                venditore.setPassword(res.getString("password"));
                venditore.setSaldo(res.getDouble("saldo"));
                query = "select * from prodotto" + " where prodotto.idVenditore = " + venditore.getId();
                Statement st = conn.createStatement();
                ResultSet res2 = st.executeQuery(query);

                while (res2.next()) {
                    Prodotto p = new Prodotto();
                    p.setId(res2.getInt("id"));
                    p.setNome(res2.getString("nome"));
                    p.setURLImmagine(res2.getString("URLImmagine"));
                    p.setDescrizione(res2.getString("descrizione"));
                    p.setPrezzo(res2.getDouble("prezzo"));
                    p.setDisponibilita(res2.getInt("disponibilita"));
                    venditore.getProdottiVenditore().add(p);
                }
                st.close();
                stmt.close();
                conn.close();
                return venditore;
            }
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Cliente getCliente(int id) {
        try {
            Connection conn = DriverManager.getConnection(connectionString, "mattiamancosu", "1234");
            String query = "select * from cliente where id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet res = stmt.executeQuery();

            if (res.next()) {
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Venditore> getVenditori() {
        ArrayList<Venditore> venditori = new ArrayList<Venditore>();
        try {
            Connection conn = DriverManager.getConnection(connectionString, "mattiamancosu", "1234");
            Statement stmt = conn.createStatement();
            String query = "select * from " + "venditore'";
            ResultSet set = stmt.executeQuery(query);

            while (set.next()) {
                Venditore venditore = new Venditore();
                venditore.setId(set.getInt("id"));
                venditore.setNome(set.getString("nome"));
                venditore.setCognome(set.getString("cognome"));
                venditore.setUsername(set.getString("username"));
                venditore.setPassword(set.getString("password"));
                venditore.setSaldo(set.getDouble("saldo"));
                venditori.add(venditore);
            }

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return venditori;
    }

    public ArrayList<Cliente> getClienti() {
        ArrayList<Cliente> clienti = new ArrayList<Cliente>();
        try {
            Connection conn = DriverManager.getConnection(connectionString, "mattiamancosu", "1234");
            Statement stmt = conn.createStatement();
            String query = "select * from cliente";
            ResultSet set = stmt.executeQuery(query);

            while (set.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(set.getInt("id"));
                cliente.setNome(set.getString("nome"));
                cliente.setCognome(set.getString("cognome"));
                cliente.setUsername(set.getString("username"));
                cliente.setPassword(set.getString("password"));
                cliente.setSaldo(set.getDouble("saldo"));
                clienti.add(cliente);
            }

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clienti;
    }

    public Prodotto getProdotto(int id) {
        try {
            Connection conn = DriverManager.getConnection(connectionString, "mattiamancosu", "1234");
            String query = "select * from prodotto where id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet res = stmt.executeQuery();

            if (res.next()) {
                Prodotto p = new Prodotto();
                p.setId(res.getInt("id"));
                p.setNome(res.getString("nome"));
                p.setURLImmagine(res.getString("URLImmagine"));
                p.setDescrizione(res.getString("descrizione"));
                p.setPrezzo(res.getDouble("prezzo"));
                p.setDisponibilita(res.getInt("disponibilita"));

                stmt.close();
                conn.close();
                return p;
            }

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Prodotto> getProdotti() {
        ArrayList<Prodotto> prodotti = new ArrayList<Prodotto>();
        try {
            Connection conn = DriverManager.getConnection(connectionString, "mattiamancosu", "1234");
            Statement stmt = conn.createStatement();
            String query = "select * from prodotto";
            ResultSet set = stmt.executeQuery(query);

            while (set.next()) {
                Prodotto p = new Prodotto();
                p.setId(set.getInt("id"));
                p.setNome(set.getString("nome"));
                p.setURLImmagine(set.getString("URLImmagine"));
                p.setDescrizione(set.getString("descrizione"));
                p.setPrezzo(set.getDouble("prezzo"));
                p.setDisponibilita(set.getInt("disponibilita"));
                prodotti.add(p);
            }

            stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return prodotti;
    }

    public Integer getIdVenditore(Integer idProdotto) {
        Integer idVenditore = 0;
        try {
            Connection conn = DriverManager.getConnection(connectionString, "mattiamancosu", "1234");
            String query = "select * from prodotto where id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, idProdotto);
            ResultSet res = stmt.executeQuery();
            if (res.next()) {
                idVenditore = res.getInt("idVenditore");
            }
            stmt.close();
            conn.close();
            return idVenditore;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void aggiungiProdotto(String nome, Double prezzo, Integer disponibilita, String URLImmagine, String descrizione, Integer idVenditore) {

        try {
            Connection c = DriverManager.getConnection(connectionString, "mattiamancosu", "1234");

            String query = "INSERT INTO prodotto (id, nome, prezzo, disponibilita, descrizione, URLImmagine, idVenditore)"
                    + " VALUES (default, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = c.prepareStatement(query);
            stmt.setString(1, nome);
            stmt.setDouble(2, prezzo);
            stmt.setInt(3, disponibilita);
            stmt.setString(4, descrizione);
            stmt.setString(5, URLImmagine);
            stmt.setInt(6, idVenditore);

            stmt.executeUpdate();
            stmt.close();
            c.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void modificaProdotto(Integer id, String nome, String URLImmagine, String descrizione, Double prezzo, Integer disponibilita) {

        try {
            Connection conn = DriverManager.getConnection(connectionString, "mattiamancosu", "1234");
            String query = "UPDATE prodotto SET nome = ? , URLImmagine = ? , descrizione = ?, prezzo = ?, disponibilita = ? WHERE id = ?";
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, nome);
            st.setString(2, URLImmagine);
            st.setString(3, descrizione);
            st.setDouble(4, prezzo);
            st.setInt(5, disponibilita);
            st.setInt(6, id);

            st.executeUpdate();
            st.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public Integer aquisto(int idCliente, int idProdotto) throws SQLException {
        Connection conn = DriverManager.getConnection(connectionString, "mattiamancosu", "1234");

        PreparedStatement modificaSaldoVenditore = null;
        PreparedStatement modificaSaldoCliente = null;
        PreparedStatement modificaDisponibilitaProdotto = null;

        String modificaCliente = "UPDATE cliente SET saldo = ? where id = ?";
        String modificaVenditore = "UPDATE venditore SET saldo = ? where id = ?";
        String modificaProdotto = "UPDATE prodotto SET disponibilita = ? where id = ?";
        try {
            conn.setAutoCommit(false);
            
            modificaSaldoVenditore = conn.prepareStatement(modificaVenditore);
            modificaSaldoCliente = conn.prepareStatement(modificaCliente);
            modificaDisponibilitaProdotto = conn.prepareStatement(modificaProdotto);

            Double saldoC = getCliente(idCliente).getSaldo();
            Double saldoV = getVenditore(getIdVenditore(idProdotto)).getSaldo();
            Double prezzo = getProdotto(idProdotto).getPrezzo();
            Integer disponibilita = getProdotto(idProdotto).getDisponibilita();
            
            if ((saldoC > prezzo) && (disponibilita != 0)) {
                saldoC -= prezzo;
                saldoV += prezzo;
                disponibilita--;
            } else {
                if (disponibilita == 0) {
                    return 3;//disponibilità esaurita
                }
                return 2;//fondi insufficienti
            }

            modificaSaldoVenditore.setDouble(1, saldoV);
            modificaSaldoVenditore.setInt(2, getIdVenditore(idProdotto));

            modificaSaldoCliente.setDouble(1, saldoC);
            modificaSaldoCliente.setInt(2, idCliente);

            modificaDisponibilitaProdotto.setInt(1, disponibilita);
            modificaDisponibilitaProdotto.setInt(2, idProdotto);

            int r1 = modificaSaldoVenditore.executeUpdate();
            int r2 = modificaSaldoCliente.executeUpdate();
            int r3 = modificaDisponibilitaProdotto.executeUpdate();

            if ((r1 != 1) || (r2 != 1) || (r3 != 1)) {
                conn.rollback();
            }
            conn.commit();
            return 1;

        } catch (SQLException e) {
            conn.rollback();
            throw e;
        } finally {
            if (modificaSaldoVenditore != null) {
                modificaSaldoVenditore.close();
            }
            if (modificaSaldoCliente != null) {
                modificaSaldoCliente.close();
            }
            if (modificaDisponibilitaProdotto != null) {
                modificaDisponibilitaProdotto.close();
            }

            conn.setAutoCommit(true);
            conn.close();
        }
    }
    
    public void eliminaProdotto(int id) {

        try {
            Connection conn = DriverManager.getConnection(connectionString, "mattiamancosu", "1234");

            String query = "DELETE FROM prodotto " + "WHERE id = " + id;
            
            Statement st = conn.createStatement();

            st.executeUpdate(query);

            st.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
