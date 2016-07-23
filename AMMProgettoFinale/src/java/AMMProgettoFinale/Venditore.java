/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AMMProgettoFinale;

import java.util.ArrayList;

/**
 *
 * @author Mattia Samuel Mancosu
 */
public class Venditore extends Utente {

    private ArrayList<Prodotto> prodottiVenditore = new ArrayList<>();

    public Venditore() {
        super();
    }

    /**
     * @return the prodottiVenditore
     */
    public ArrayList<Prodotto> getProdottiVenditore() {
        return prodottiVenditore;
    }

    /**
     * @param prodottiVenditore the prodottiVenditore to set
     */
    public void setProdottiVenditore(ArrayList<Prodotto> prodottiVenditore) {
        this.prodottiVenditore = prodottiVenditore;
    }
}
