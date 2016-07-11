<%-- 
    Document   : cliente
    Created on : 9-lug-2016, 11.52.24
    Author     : root
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
                <!--Tabella dei prodotti-->
                <c:choose>
                    <c:when test="${loggedIn == true && cliente.getId()==id}">
                        <table>
                            <tr>
                                <th>Oggetto</th>
                                <th>Immagine</th>
                                <th>Disponibilità</th>
                                <th>Prezzo</th>
                                <th>Carrello</th>
                            </tr>
                            
                            <c:forEach var="prodotto" items="${listaProdotti}">
                                <tr>
                                    <td>${prodotto.getNome()}</td>
                                    <td> <img title="${prodotto.getNome()}" alt="${prodotto.getNome()}"  src="${prodotto.getURLImmagine()}" width="240" height="240"> </td>
                                    <td>${prodotto.getDisponibilita()}</td>
                                    <td>${prodotto.getPrezzo()}</td>
                                    <td> <a href="cliente.html?idProdotto=${prodotto.getId()}">Aggiungi al carrello</a> </td>
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
