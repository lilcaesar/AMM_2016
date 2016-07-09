<%-- 
    Document   : carrello
    Created on : 9-lug-2016, 12.39.26
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Carrello</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Mattia Samuel Mancosu">
        <meta name="description" content="Carrello">
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
                            <a href="./descrizione.jsp">Descrizione</a>
                        </li>
                        <li>
                            <a href="./login.jsp">Login</a>
                        </li>
                    </ul>
                </nav>
            </div>

            <jsp:include page="sidebarDestra.jsp"/>

            <div id="content">

                <ul>
                    <li>${prodotto.getNome()}</td>
                    <li> <img title="${prodotto.getNome()}" alt="${prodotto.getNome()}"  src="${prodotto.getImmagine()}"> </td>
                    <li>${prodotto.getDisponibilita()}</td>
                    <li>${prodotto.getPrezzo()}</td>
                    <li> <a href="cliente.html?idAcquisto="${prodotto.getId()}">Conferma acquisto</a> </td>
                </ul>

            </div>
        </div>

        <jsp:include page="footer.jsp"/>

    </body>    
</html>

