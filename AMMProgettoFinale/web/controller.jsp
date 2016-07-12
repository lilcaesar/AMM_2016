<%-- 
    Document   : controller
    Created on : 12-lug-2016, 11.54.40
    Author     : root
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Il tuo account</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Mattia Samuel Mancosu">
        <meta name="description" content="Profilo del venditore">
        <meta name="keywords" content="eCommerce, drone, RC, FPV, FirstPersonView">
        <link href="./style.css" rel="stylesheet" type="text/css" media="screen" />
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
                            <a href="./venditore.jsp"> Sezione venditore </a>
                        </li>
                        <li>
                            <a href="./login.jsp"> Login </a>
                        </li>
                    </ul>
                </nav>
            </div>

            <jsp:include page="sidebarDestra.jsp"/>

            <div id="content">
                <!--Tabella dei prodotti-->
                <c:choose>
                    <c:when test="${loggedIn == true && venditore.getId()==id}">
                        <table>
                            <tr>
                                <th>Oggetto</th>
                                <th>Immagine</th>
                                <th>Disponibilità</th>
                                <th>Prezzo</th>
                                <th>Modifica</th>
                                <th>Elimina</th>
                            </tr>
                            
                            <c:forEach var="prodotto" items="${venditore.getProdottiVenditore()}">
                                <tr>
                                    <td>${prodotto.getNome()}</td>
                                    <td> <img title="${prodotto.getNome()}" alt="${prodotto.getNome()}"  src="${prodotto.getURLImmagine()}" width="240" height="240"> </td>
                                    <td>${prodotto.getDisponibilita()}</td>
                                    <td>${prodotto.getPrezzo()}</td>
                                    <td> <a href="venditore.html?idProdottoDaModificare=${prodotto.getId()}">Modifica</a> </td>
                                    <td> <a href="venditore.html?idProdottoDaEliminare=${prodotto.getId()}">Elimina</a> </td>
                                </tr>
                            </c:forEach>
                        </table>
                    </c:when>
                    <c:otherwise>
                        <jsp:include page="erroreLogin.jsp"/>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>

        <jsp:include page="footer.jsp"/>

    </body>
</html>
