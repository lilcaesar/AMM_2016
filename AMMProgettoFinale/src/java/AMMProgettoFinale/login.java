/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AMMProgettoFinale;

import java.io.IOException;
import java.io.PrintWriter;
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
 * @author root
 */
@WebServlet(name = "login", urlPatterns = {"/login.html"}, loadOnStartup = 0)
public class login extends HttpServlet {

    private static final String JDBC_DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    private static final String DB_CLEAN_PATH = "../../web/WEB-INF/db/ammdb";
    private static final String DB_BUILD_PATH = "WEB-INF/db/ammdb";

    @Override
    public void init() {
        String dbConnection = "jdbc:derby:" + this.getServletContext().getRealPath("/") + DB_BUILD_PATH;
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(login.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        Factory.getInstance().setConnectionString(dbConnection);
    }

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
        HttpSession session = request.getSession(true);

        if (request.getParameter("submit") != null) {
            // Preleva i dati inviati
            String username = request.getParameter("utente");
            String password = request.getParameter("password");

            Utente u = Factory.getInstance().getUtente(username, password);
            //Se l'utente esiste
            if (u != null) {
                //Setto i parametri di sessione
                session.setAttribute("loggedIn", true);
                session.setAttribute("id", u.getId());

                //Se l'utente è un cliente
                if (u instanceof Cliente) {
                    //richiamo la pagina del cliente passandogli come parametro la lista dei prodotti
                    session.setAttribute("cliente", u);
                    request.setAttribute("listaProdotti", Factory.getInstance().getProdotti());
                    request.getRequestDispatcher("cliente.jsp").forward(request, response);
                } else {
                    //Altrimenti carico la pagina del venditore e passo come parametro i prodotti del venditore loggato
                    session.setAttribute("venditore", u);
                    session.setAttribute("listaProdottiVenditore", Factory.getInstance().getVenditore(u.getId()).getProdottiVenditore()); //Non uso u.getProdottiVenditore poichè u risulta ancora un oggetto di tipo Utente
                    request.getRequestDispatcher("venditore.jsp").forward(request, response);
                }
            }
        }
        request.getRequestDispatcher("login.jsp").forward(request, response);

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
