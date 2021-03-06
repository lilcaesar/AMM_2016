<%-- 
    Document   : venditore
    Created on : 9-lug-2016, 11.52.40
    Author     : Mattia Samuel Mancosu
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Venditore</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Mattia Samuel Mancosu">
        <meta name="description" content="Pagina del Venditore">
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
                        <li>
                            <a href="./cliente.jsp"> Sezione cliente </a>
                        </li>
                    </ul>
                </nav>
            </div>

            <jsp:include page="sidebarDestra.jsp"/>

            <div id="content">
                <!--Controllo che l'utente sia loggato-->
                <c:choose>
                    <c:when test="${loggedIn == true && venditore.getId()==id}">
                        <h1>Inserimento nuovo prodotto</h1>
                        <!--Form per l'inserimento di un nuovo oggeto-->
                        <form method="post" action="venditore.html">
                            <div id="nuovoOggettoForm" class="form">
                                <label for="name">Nome prodottoo</label>
                                <input type="text" name="name" id="name"/>
                                <label for="urlImmagine">URL</label>
                                <input type="url" name="urlImmagine" id="urlImmagine"/>
                                <label for="descrizione">Descrizione</label>
                                <textarea rows="4" cols="20" name="descrizione" id="descrizione">Descrizione</textarea>
                                <label for="prezzo">Prezzo</label>
                                <input type="number" name="prezzo" id="prezzo"/>
                                <label for="disponibilita">Disponibilità</label>
                                <input type="number" name="disponibilita" id="disponibilita"/>
                            </div>
                            <div id="nuovoOggettoSubmit">
                                <input type="submit" name="submit" value="Invia"/>
                                <input type="reset" value="Reimposta"/>
                            </div>
                            <a href="controller.jsp">Vai al tuo account!</a>
                        </form>
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
