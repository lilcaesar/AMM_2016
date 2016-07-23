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
 * @author Mattia Samuel Mancosu
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

    public Utente getUtente(String username, String password) {/*Restituisco un utente in base all'username e la PW*/
        try {
            Connection conn = DriverManager.getConnection(connectionString, "mattiamancosu", "1234");

            /*Effettuo una query sulla tabella venditore*/
            String query = "select * from venditore where username = ? and password = ?";

            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, password);

            ResultSet res = stmt.executeQuery();

            /*Se la query mi restituisce un risultato vuol dire che l'utente cercato è un venditore, quindi ne setto i parametri..*/
            if (res.next()) {
                Venditore venditore = new Venditore();
                venditore.setId(res.getInt("id"));
                venditore.setNome(res.getString("nome"));
                venditore.setCognome(res.getString("cognome"));
                venditore.setUsername(res.getString("username"));
                venditore.setPassword(res.getString("password"));
                venditore.setSaldo(res.getDouble("saldo"));

                /*..e faccio una query per ottenere i prodotti dello stesso*/
                query = "select * from prodotto" + " where idVenditore = " + venditore.getId();
                Statement st = conn.createStatement();
                ResultSet res2 = st.executeQuery(query);

                /*Se la query restituisce risultati imposto i dati dei prodotti*/
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

            /*Se arrivo qui vuol dire che l'utente non è un venditore, effettuo una query per vedere se è un cliente*/
            query = "select * from cliente where username = ? and password = ?";
            stmt = conn.prepareStatement(query);

            stmt.setString(1, username);
            stmt.setString(2, password);
            res = stmt.executeQuery();

            /*Se ottengo risultato l'utente è un cliente e setto le variabili*/
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

    public Venditore getVenditore(int id) {/*Ottengo un venditore in base all'id*/
        try {
            Connection conn = DriverManager.getConnection(connectionString, "mattiamancosu", "1234");
            String query = "select * from venditore " + "where id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet res = stmt.executeQuery();

            /*Se la query mi restituisce un risultato vuol dire che l'id cercato è di un venditore, quindi ne setto i parametri..*/
            if (res.next()) {
                Venditore venditore = new Venditore();
                venditore.setId(res.getInt("id"));
                venditore.setNome(res.getString("nome"));
                venditore.setCognome(res.getString("cognome"));
                venditore.setUsername(res.getString("username"));
                venditore.setPassword(res.getString("password"));
                venditore.setSaldo(res.getDouble("saldo"));

                /*..e faccio una query per ottenere i prodotti dello stesso*/
                query = "select * from prodotto" + " where prodotto.idVenditore = " + venditore.getId();
                Statement st = conn.createStatement();
                ResultSet res2 = st.executeQuery(query);

                /*Se la query restituisce risultati imposto i dati dei prodotti*/
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

    public Cliente getCliente(int id) {/*Metodo simile alla precedente ma che restituisce un cliente*/
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

    public ArrayList<Venditore> getVenditori() {//Metodo ceh restituisce un array con tutti i venditori
        ArrayList<Venditore> venditori = new ArrayList<Venditore>();
        try {
            Connection conn = DriverManager.getConnection(connectionString, "mattiamancosu", "1234");
            Statement stmt = conn.createStatement();
            String query = "select * from " + "venditore'";
            ResultSet set = stmt.executeQuery(query);

            //Scorro la lista dei venditori finchè ne esistono e ne carico i dati in "venditori"
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

    public ArrayList<Cliente> getClienti() {//Metodo simile alla precedente ma per i clienti
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

    public Prodotto getProdotto(int id) {//Dato un idProdotto restituisco il prodotto
        try {
            Connection conn = DriverManager.getConnection(connectionString, "mattiamancosu", "1234");
            String query = "select * from prodotto where id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet res = stmt.executeQuery();

            //Se la query restituisce un risultato vuol dire che l'id prodotto era valido, quindi carico i dati da restituire
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

    public ArrayList<Prodotto> getProdotti() {//Metodo (chiamato dal cliente) che restituisce un array con tutti i prodotti in vendita, sintatticamente simile a quello per venditore e cliente
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

    public ArrayList<Prodotto> getProdotti(String s) {//Restituisco un array di prodotti contenente nel nome o nella descrizione la stringa fornita (metodo richiamato dal filtro)
        ArrayList<Prodotto> array = new ArrayList<Prodotto>();
        try {
            Connection conn = DriverManager.getConnection(connectionString, "mattiamancosu", "1234");
            String query = "select * from " + "prodotto where nome LIKE ? OR descrizione LIKE ?";
            PreparedStatement stmt = conn.prepareStatement(query);

            s = "%" + s + "%";//Mi assicuro che la stringa possa essere contenuta in qualunque parte del nome/descrizione
            stmt.setString(1, s);
            stmt.setString(2, s);
            ResultSet set = stmt.executeQuery();

            while (set.next()) {
                Prodotto o = new Prodotto();
                o.setId(set.getInt("id"));
                o.setNome(set.getString("nome"));
                o.setURLImmagine(set.getString("URLImmagine"));
                o.setDescrizione(set.getString("descrizione"));
                o.setPrezzo(set.getDouble("prezzo"));
                o.setDisponibilita(set.getInt("disponibilita"));
                array.add(o);
            }

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return array;
    }

    public Integer getIdVenditore(Integer idProdotto) {//Metodo che restituisce l'id di un venditore associato all'id di un prodotto dato
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
        //Metodo che aggiunge un prodotto alla tabella
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
        //Metodo che modifica un prodotto nella tabella(senza modificare il venditore)
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
        //Metodo che gestice l'acquisto di un prodotto
        Connection conn = DriverManager.getConnection(connectionString, "mattiamancosu", "1234");

        PreparedStatement modificaSaldoVenditore = null;
        PreparedStatement modificaSaldoCliente = null;
        PreparedStatement modificaDisponibilitaProdotto = null;

        //Creo le query per la modifica dei saldi del venditore e del cliente e per la modifica della disponibilità del prodotto
        String modificaCliente = "UPDATE cliente SET saldo = ? where id = ?";
        String modificaVenditore = "UPDATE venditore SET saldo = ? where id = ?";
        String modificaProdotto = "UPDATE prodotto SET disponibilita = ? where id = ?";
        try {
            conn.setAutoCommit(false);

            modificaSaldoVenditore = conn.prepareStatement(modificaVenditore);
            modificaSaldoCliente = conn.prepareStatement(modificaCliente);
            modificaDisponibilitaProdotto = conn.prepareStatement(modificaProdotto);

            Double saldoCliente = getCliente(idCliente).getSaldo();
            Double saldoVenditore = getVenditore(getIdVenditore(idProdotto)).getSaldo();
            Double prezzo = getProdotto(idProdotto).getPrezzo();
            Integer disponibilita = getProdotto(idProdotto).getDisponibilita();

            //COntrollo che il saldo del cliente sia sufficiente all'acquisto e che il prodotto sia disponibile
            if ((saldoCliente >= prezzo) && (disponibilita != 0)) {
                saldoCliente -= prezzo;
                saldoVenditore += prezzo;
                disponibilita--;
            } else {
                if (disponibilita == 0) {
                    return 3;//disponibilità esaurita
                }
                if (saldoCliente < prezzo) {
                    return 2;//Saldo insufficiente
                }
            }

            modificaSaldoVenditore.setDouble(1, saldoVenditore);
            modificaSaldoVenditore.setInt(2, getIdVenditore(idProdotto));

            modificaSaldoCliente.setDouble(1, saldoCliente);
            modificaSaldoCliente.setInt(2, idCliente);

            modificaDisponibilitaProdotto.setInt(1, disponibilita);
            modificaDisponibilitaProdotto.setInt(2, idProdotto);

            int r1 = modificaSaldoVenditore.executeUpdate();
            int r2 = modificaSaldoCliente.executeUpdate();
            int r3 = modificaDisponibilitaProdotto.executeUpdate();

            //In caso di fallimento di almeno una modifica effettuo la rollback
            if ((r1 != 1) || (r2 != 1) || (r3 != 1)) {
                conn.rollback();
            }
            conn.commit();
            return 1;

        } catch (SQLException e) {
            conn.rollback();
            throw e;
        } finally {//Mi assicuro che in caso di errore vengano chiuse le connessioni
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

    public void eliminaProdotto(int id) {//Metodo che dato un idProdotto elimina il prodotto corrispondente

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
