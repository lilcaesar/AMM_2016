<%-- 
    Document   : cliente
    Created on : 9-lug-2016, 11.52.24
    Author     : Mattia Samuel Mancosu
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Cliente</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Mattia Samuel Mancosu">
        <meta name="description" content="Pagina del cliente">
        <meta name="keywords" content="eCommerce, drone, RC, FPV, FirstPersonView">
        <link href="./style.css" rel="stylesheet" type="text/css" media="screen" />
        <script src="js/jquery-2.2.4.min.js" type="text/javascript"></script>
        <script src="js/filter.js" type="text/javascript"></script>
    </head>
    <body>
        <div id="page">           
            <header>
                <h1 id="titoloSito">FirstPersonView Store</h1>
            </header>
            <!--Sezione con i link per navigare nel sito-->
            <div  id="sidebarSinistra">
                <nav>
                    <ul>
                        <li>
                            <a href="./descrizione.jsp"> Descrizione sito </a>
                        </li>
                        <li>
                            <a href="./login.jsp"> Login </a>
                        </li>
                    </ul>
                </nav>
            </div>

            <jsp:include page="sidebarDestra.jsp"/>

            <div id="content">
                <!--Controllo che l'utente sia loggato e che sia un cliente-->
                <c:choose>
                    <c:when test="${loggedIn == true && cliente.getId()==id}">
                        <!--Input utilizzato per il filtro-->
                        <label for="Filtra">Cerca Prodotto</label>
                        <input type="text" id="Filtra"/>
                        <table id="tabella">
                            <tr>
                                <th>Oggetto</th>
                                <th>Immagine</th>
                                <th>Descrizione</th>
                                <th>Disponibilità</th>
                                <th>Prezzo</th>
                                <th>Carrello</th>
                            </tr>

                            <!--Creo la tabella dei prodotti-->
                            <c:forEach var="prodotto" items="${listaProdotti}">
                                <tr class="listaProdotti">
                                    <td>${prodotto.getNome()}</td>
                                    <td> <img title="${prodotto.getNome()}" alt="${prodotto.getNome()}"  src="${prodotto.getURLImmagine()}" width="120" height="120"> </td>
                                    <td>${prodotto.getDescrizione()}</td>
                                    <td>${prodotto.getDisponibilita()}</td>
                                    <td>${prodotto.getPrezzo()}</td>
                                    <td> <a href="cliente.html?idProdotto=${prodotto.getId()}">Aggiungi al carrello</a> </td>
                                </tr>
                            </c:forEach>
                        </table>
                        <p id="ErroreFiltro"></p> <!--Mostrato solo in caso di mancanza di prodotti nella ricerca(Vedi filter.js)-->
                    </c:when>
                    <c:otherwise>
                        <!--Utente non loggato-->
                        <jsp:include page="erroreLogin.jsp"/>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>

        <jsp:include page="footer.jsp"/>

    </body>
</html>
