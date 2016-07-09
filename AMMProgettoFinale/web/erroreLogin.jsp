<%-- 
    Document   : erroreLogin
    Created on : 9-lug-2016, 16.06.48
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>ERRORE LOGIN</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Mattia Samuel Mancosu">
        <meta name="description" content="Errore Login">
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
                            <a href="./login.jsp"> Login </a>
                        </li>
                    </ul>
                </nav>
            </div>
            <div id="content">
                <h1 id="erroreLogin">ERRORE LOGIN</h1>
                <a href="./login.jsp">Premere qui per effettuare l'accesso</a>
            </div>
        </div>
        <jsp:include page="footer.jsp"/>
    </body>    
</html>
