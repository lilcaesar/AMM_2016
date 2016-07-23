/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AMMProgettoFinale;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Mattia Samuel Mancosu
 */
@WebServlet(name = "venditore", urlPatterns = {"/venditore.html"})
public class VenditoreServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Sessione
        HttpSession session = request.getSession(false);

        //Se è stata effettuata una submit
        if (request.getParameter("submit") != null) {
            //Se anche uno solo dei campi in ingresso è vuoto rimando l'utente alla pagina precedente
            if ((request.getParameter("name").isEmpty()) || (request.getParameter("urlImmagine").isEmpty()) || (request.getParameter("descrizione").isEmpty()) || (request.getParameter("prezzo").isEmpty()) || (request.getParameter("disponibilita").isEmpty())) {
                request.getRequestDispatcher("venditore.jsp").forward(request, response);
            }
            //altrimenti prelevo i dati
            String name = request.getParameter("name");
            String urlImmagine = request.getParameter("urlImmagine");
            String descrizione = request.getParameter("descrizione");
            Double prezzo = Double.parseDouble(request.getParameter("prezzo"));
            Integer disponibilita = Integer.parseInt(request.getParameter("disponibilita"));

            Integer idVenditore = (Integer) (session.getAttribute("id"));

            //creo un nuovo oggetto di Prodotto usando come attributi i dati precedentemente prelevati
            Prodotto p = new Prodotto();
            p.setDescrizione(descrizione);
            p.setDisponibilita(disponibilita);
            p.setNome(name);
            p.setPrezzo(prezzo);
            p.setURLImmagine(urlImmagine);

            //Richiamo il metodo di Factory che aggiunge il prodotto appena creato
            Factory.getInstance().aggiungiProdotto(name, prezzo, disponibilita, urlImmagine, descrizione, idVenditore);

            //Passo come parametro il nuovo prodotto alla pagina di riepilogo e reindirizzo l'utente
            request.setAttribute("prodotto", p);
            request.setAttribute("operazione", "Ecco il prodotto che hai inserito");
            session.setAttribute("listaProdottiVenditore", Factory.getInstance().getVenditore((Integer) session.getAttribute("id")).getProdottiVenditore());
            request.getRequestDispatcher("riepilogoOperazione.jsp").forward(request, response);
        }

        //Se è presente un idProdottoDaModificare..
        if (request.getParameter("idProdottoDaModificare") != null) {
            //Passo id e prodotto alla pagina di modifica per effettuare l'operazione
            Integer idProdottoDaModificare = Integer.parseInt(request.getParameter("idProdottoDaModificare"));
            request.setAttribute("idProdottoDaModificare", idProdottoDaModificare);
            request.setAttribute("prodottoDaModificare",Factory.getInstance().getProdotto(idProdottoDaModificare));
            request.getRequestDispatcher("modificaProdotto.jsp").forward(request, response);
        }

        //Questo parametro è presente dopo che è stata effettuata una modifica
        if (request.getParameter("prodottoModificato") != null) {
            //Prelevo tutti i dati dal prodotto preso in ingresso
            String name = Factory.getInstance().getProdotto(Integer.parseInt(request.getParameter("idProdottoModificato"))).getNome();
            String urlImmagine = Factory.getInstance().getProdotto(Integer.parseInt(request.getParameter("idProdottoModificato"))).getURLImmagine();
            String descrizione = Factory.getInstance().getProdotto(Integer.parseInt(request.getParameter("idProdottoModificato"))).getDescrizione();
            Double prezzo = Factory.getInstance().getProdotto(Integer.parseInt(request.getParameter("idProdottoModificato"))).getPrezzo();
            Integer disponibilita = Factory.getInstance().getProdotto(Integer.parseInt(request.getParameter("idProdottoModificato"))).getDisponibilita();
            
            //Controllo che nessuno dei dati sia vuoto
            if(!(request.getParameter("name").isEmpty())){
                name = request.getParameter("name");
            }            
            if(!(request.getParameter("urlImmagine").isEmpty())){
                urlImmagine = request.getParameter("urlImmagine");
            }
            if(!(request.getParameter("descrizione").isEmpty())){
                descrizione = request.getParameter("descrizione");
            }
            if(!(request.getParameter("prezzo").isEmpty())){
                prezzo = Double.parseDouble(request.getParameter("prezzo"));
            }
            if(!(request.getParameter("disponibilita").isEmpty())){
                disponibilita = Integer.parseInt(request.getParameter("disponibilita"));
            }
            
            Integer idProdottoModificato = Integer.parseInt(request.getParameter("idProdottoModificato"));

            //Effettuo la modifica e reindirizzo alla pagina personale del venditore
            Factory.getInstance().modificaProdotto(idProdottoModificato, name, urlImmagine, descrizione, prezzo, disponibilita);

            request.setAttribute("operazione", "Ecco il prodotto modificato");

            session.setAttribute("listaProdottiVenditore", Factory.getInstance().getVenditore((Integer) session.getAttribute("id")).getProdottiVenditore());
            request.getRequestDispatcher("controller.jsp").forward(request, response);
        }

        //Se il parametro per l'eliminizione di un prodotto è settato
        if (request.getParameter("idProdottoDaEliminare") != null) {
            //elimino il prodotto e reindirizzo alla pagina personale del venditore
            Factory.getInstance().eliminaProdotto(Integer.parseInt(request.getParameter("idProdottoDaEliminare")));
            session.setAttribute("listaProdottiVenditore", Factory.getInstance().getVenditore((Integer) session.getAttribute("id")).getProdottiVenditore());
            request.getRequestDispatcher("controller.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
