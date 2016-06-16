/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AMMProgettoFinale;

/**
 *
 * @author root
 */
public class prodotto {
    private String nome;
    private double prezzo;
    private int disponibilita;

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the prezzo
     */
    public double getPrezzo() {
        return prezzo;
    }

    /**
     * @param prezzo the prezzo to set
     */
    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    /**
     * @return the disponibilita
     */
    public int getDisponibilita() {
        return disponibilita;
    }

    /**
     * @param disponibilita the disponibilita to set
     */
    public void setDisponibilita(int disponibilita) {
        this.disponibilita = disponibilita;
    }
}
