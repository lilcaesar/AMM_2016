<%-- 
    Document   : modificaProdotto
    Created on : 12-lug-2016, 15.40.08
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
                            <a href="./venditore.jsp"> Sezione venditore </a>
                        </li>
                    </ul>
                </nav>
            </div>

            <jsp:include page="sidebarDestra.jsp"/>

            <div id="content">
                <!--Mi assicuro che il venditore sia loggato-->
                <c:choose>
                    <c:when test="${loggedIn == true && venditore.getId()==id}">
                        <h1>Modifica prodotto</h1>
                        <form method="post" action="venditore.html">
                            <!--FOrm in cui stampo i dati sul prodotto da modificare scelto e ne permetto la modifica-->
                            <div id="modificaOggettoForm" class="form">
                                <label for="name">Nome oggetto</label>
                                <input type="text" name="name" id="name" value="${prodottoDaModificare.getNome()}"/>
                                <label for="urlImmagine">URL</label>
                                <input type="url" name="urlImmagine" id="urlImmagine" value="${prodottoDaModificare.getURLImmagine()}"/>
                                <label for="descrizione">Descrizione</label>
                                <textarea rows="4" cols="20" name="descrizione" id="descrizione">"${prodottoDaModificare.getDescrizione()}"</textarea>
                                <label for="prezzo">Prezzo</label>
                                <input type="number" name="prezzo" id="prezzo" value="${prodottoDaModificare.getPrezzo()}"/>
                                <label for="disponibilita">Disponibilità</label>
                                <input type="number" name="disponibilita" id="disponibilita" value="${prodottoDaModificare.getDisponibilita()}"/>
                            </div>
                            <div id="modificaOggettoSubmit">
                                <input type="hidden" name="idProdottoModificato" id="idProdottoModificato" value="${idProdottoDaModificare}"/>
                                <input type="submit" name="prodottoModificato" value="Modifica"/>
                                <input type="reset" value="Reimposta"/>
                            </div>
                            <!--Link alla pagina del controller-->
                            <a href="controller.jsp">Vai al tuo account!</a>
                        </form>
                    </c:when>
                    <c:otherwise>
                        <!--Venditore non loggato-->
                        <jsp:include page="erroreLogin.jsp"/>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>

        <jsp:include page="footer.jsp"/>

    </body>
</html>
