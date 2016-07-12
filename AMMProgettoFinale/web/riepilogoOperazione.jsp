<%-- 
    Document   : inserimentoProdotto
    Created on : 10-lug-2016, 16.51.03
    Author     : root
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Inserimento Prodotto</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Mattia Samuel Mancosu">
        <meta name="description" content="Pagina di inserimento prodotto">
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
                <h1>Conferma operazione prodotto</h1>
                <h3>${operazione}</h3>
                <ul>
                    <li>${prodotto.getNome()}</li>
                    <li><image src="${prodotto.getURLImmagine()}"  alt="Immagine di ${prodotto.getNome()}"></li>
                    <li>${prodotto.getDescrizione()}</li>
                    <li> ${prodotto.getDisponibilita()}</li>
                    <li>${prodotto.getPrezzo()}</li>
                </ul>
            </div>
        </div>

        <jsp:include page="footer.jsp"/>

    </body>
</html>
