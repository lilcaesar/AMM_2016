<%-- 
    Document   : carrello
    Created on : 9-lug-2016, 12.39.26
    Author     : Mattia Samuel Mancosu
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
                <h1>Conferma acquisto prodotto</h1>
                <h3>Ecco il prodotto che vuoi aquistare</h3>
                <!--Stampo i dati inerenti al prodotto passato allo script per l'acquisto-->
                <ul>
                    <li>${prodotto.getNome()}</li>
                    <li> <img title="${prodotto.getNome()}"  src="${prodotto.getURLImmagine()}" alt="${prodotto.getNome()}"> </li>
                    <li>${prodotto.getDisponibilita()}</li>
                    <li>${prodotto.getPrezzo()}</li>
                    <li><a href="cliente.html?idProdottoCarrello=${prodotto.getId()}">CONFERMA!</a></li>
                    <p>${risultatoAcquisto}</p> <!--Notifico l'utente di come è andata la transazione-->
                </ul>
            </div>
        </div>

        <jsp:include page="footer.jsp"/>

    </body>    
</html>

