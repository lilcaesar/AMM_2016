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
 * @author root
 */
@WebServlet(name = "venditore", urlPatterns = {"/venditore.html"})
public class venditore extends HttpServlet {

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

        if (request.getParameter("submit") != null) {
            if ((request.getParameter("name").isEmpty()) || (request.getParameter("urlImmagine").isEmpty()) || (request.getParameter("descrizione").isEmpty()) || (request.getParameter("prezzo").isEmpty()) || (request.getParameter("disponibilita").isEmpty())) {
                request.getRequestDispatcher("venditore.jsp").forward(request, response);
            }
            String name = request.getParameter("name");
            String urlImmagine = request.getParameter("urlImmagine");
            String descrizione = request.getParameter("descrizione");
            Double prezzo = Double.parseDouble(request.getParameter("prezzo"));
            Integer disponibilita = Integer.parseInt(request.getParameter("disponibilita"));

            Integer idVenditore = (Integer) (session.getAttribute("id"));

            Prodotto p = new Prodotto();
            p.setDescrizione(descrizione);
            p.setDisponibilita(disponibilita);
            p.setNome(name);
            p.setPrezzo(prezzo);
            p.setURLImmagine(urlImmagine);

            Factory.getInstance().aggiungiProdotto(name, prezzo, disponibilita, urlImmagine, descrizione, idVenditore);

            request.setAttribute("prodotto", p);
            request.setAttribute("operazione", "Ecco il prodotto che hai inserito");
            session.setAttribute("listaProdottiVenditore", Factory.getInstance().getVenditore((Integer) session.getAttribute("id")).getProdottiVenditore());
            request.getRequestDispatcher("riepilogoOperazione.jsp").forward(request, response);
        }

        if (request.getParameter("idProdottoDaModificare") != null) {
            Integer idProdottoDaModificare = Integer.parseInt(request.getParameter("idProdottoDaModificare"));
            request.setAttribute("idProdottoDaModificare", idProdottoDaModificare);
            request.getRequestDispatcher("modificaProdotto.jsp").forward(request, response);
        }

        if (request.getParameter("prodottoModificato") != null) {

            String name = Factory.getInstance().getProdotto(Integer.parseInt(request.getParameter("idProdottoDaModificare"))).getNome();
            String urlImmagine = Factory.getInstance().getProdotto(Integer.parseInt(request.getParameter("idProdottoDaModificare"))).getURLImmagine();
            String descrizione = Factory.getInstance().getProdotto(Integer.parseInt(request.getParameter("idProdottoDaModificare"))).getDescrizione();
            Double prezzo = Factory.getInstance().getProdotto(Integer.parseInt(request.getParameter("idProdottoDaModificare"))).getPrezzo();
            Integer disponibilita = Factory.getInstance().getProdotto(Integer.parseInt(request.getParameter("idProdottoDaModificare"))).getDisponibilita();
            
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
            
            Integer idProdottoModificato = Integer.parseInt(request.getParameter("idProdottoDaModificare"));

            Factory.getInstance().modificaProdotto(idProdottoModificato, name, urlImmagine, descrizione, prezzo, disponibilita);

            request.setAttribute("operazione", "Ecco il prodotto modificato");

            session.setAttribute("listaProdottiVenditore", Factory.getInstance().getVenditore((Integer) session.getAttribute("id")).getProdottiVenditore());
            request.getRequestDispatcher("controller.jsp").forward(request, response);
        }

        if (request.getParameter("idProdottoDaEliminare") != null) {
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
