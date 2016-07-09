<%-- 
    Document   : login
    Created on : 9-lug-2016, 11.52.56
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Mattia Samuel Mancosu">
        <meta name="description" content="Pagina di login">
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
                            <a href="./cliente.jsp"> Sezione cliente </a>
                        </li>
                    </ul>
                </nav>
            </div>
            
            <jsp:include page="sidebarDestra.jsp"/>
            
            <div id="content">
                <h2>Login</h2>
                <!--Form per il login-->
                <form method="post" action="login.html">
                    <div id="loginForm" class="form">
                        <label for="utente">Nome utente</label>
                        <input type="text" name="utente"
                               id="utente" />
                        <label for="password">Password</label>
                        <input type="password" name="password" id="password" />
                    </div>
                    <div id="loginSubmit">
                        <input type="submit" name="submit" value="Invia"/>
                        <input type="reset" value="Reimposta"/>
                    </div>
                </form>
            </div>
        </div>
        
        <jsp:include page="footer.jsp"/>
            
    </body>
</html>
