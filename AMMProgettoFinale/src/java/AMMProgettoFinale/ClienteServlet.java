/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AMMProgettoFinale;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "cliente", urlPatterns = {"/cliente.html"})
public class ClienteServlet extends HttpServlet {

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

        HttpSession session = request.getSession(false);
        
        /*Se viene richiesto l'acquisto di un prodotto dalla pagina del cliente reindirizzo alla pagina del carrello*/
        if (request.getParameter("idProdotto") != null) {
            Integer idProdotto = Integer.parseInt(request.getParameter("idProdotto"));
            request.setAttribute("prodotto", Factory.getInstance().getProdotto(idProdotto));
            request.getRequestDispatcher("carrello.jsp").forward(request, response);
        }
        
        /*Se viene confermato l'aquisto nel carrello effettuo la transazione*/
        if (request.getParameter("idProdottoCarrello") != null) {
            Integer idProdottoCarrello = Integer.parseInt(request.getParameter("idProdottoCarrello"));
            Integer idCliente = (Integer) (session.getAttribute("id"));
            Integer risultatoOperazione = 0;
            try {
                /*Risultato operazione contiene il valore ritornato dalla funzione "acquisto" nella factory*/
                risultatoOperazione = Factory.getInstance().aquisto(idCliente, idProdottoCarrello);
            } catch (SQLException ex) {
                Logger.getLogger(ClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            switch (risultatoOperazione) {
                case 1:
                    /*Successo dell'operazione*/
                    request.setAttribute("risultatoAcquisto", "Aquisto effettuato correttamente");
                    request.setAttribute("prodotto", Factory.getInstance().getProdotto(Integer.parseInt(request.getParameter("idProdottoCarrello"))));
                    session.setAttribute("saldo", Factory.getInstance().getCliente(idCliente).getSaldo());
                    session.setAttribute("listaProdotti", Factory.getInstance().getProdotti());
                    request.getRequestDispatcher("carrello.jsp").forward(request, response);
                    break;
                case 2:
                    /*Fallimento dell'operazione per saldo insufficiente*/
                    request.setAttribute("risultatoAcquisto", "Aquisto fallito, saldo insufficiente");
                    request.setAttribute("prodotto", Factory.getInstance().getProdotto(Integer.parseInt(request.getParameter("idProdottoCarrello"))));
                    request.getRequestDispatcher("carrello.jsp").forward(request, response);
                    break;
                case 3:
                    /*Fallimento dell'operazione per disponibilità insufficiente*/
                    request.setAttribute("risultatoAcquisto", "Aquisto fallito, disponibilità insufficiente");
                    request.setAttribute("prodotto", Factory.getInstance().getProdotto(Integer.parseInt(request.getParameter("idProdottoCarrello"))));
                    request.getRequestDispatcher("carrello.jsp").forward(request, response);
                    break;
                default:
                    /*Fallimento generico*/
                    request.setAttribute("risultatoAcquisto", "Aquisto fallito, errore sconosciuto");
                    request.setAttribute("prodotto", Factory.getInstance().getProdotto(Integer.parseInt(request.getParameter("idProdottoCarrello"))));
                    request.getRequestDispatcher("carrello.jsp").forward(request, response);
            }
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
