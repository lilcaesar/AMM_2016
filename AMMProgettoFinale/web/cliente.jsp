<%-- 
    Document   : cliente
    Created on : 9-lug-2016, 11.52.24
    Author     : root
--%>

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
                <table>
                    <tr>
                        <th>Oggetto</th>
                        <th>Immagine</th>
                        <th>Disponibilità</th>
                        <th>Prezzo</th>
                        <th>Carrello</th>
                    </tr>
                    <tr>
                        <td>STORM Racing Drone (RTF / Type-A V2)</td>
                        <td>
                            <img title="drone" alt="immagine drone"
                                 src="img/drone.jpg" width="240" height="240">
                        </td>
                        <td>4</td>
                        <td>399 euro</td>
                        <td><a href="./cliente.html">Aggiungi al carrello</a></td>
                    </tr>
                    <tr>
                        <td>RadioLink AT9</td>
                        <td>
                            <img title="radiocomando" alt="immagine radiocomando"
                                 src="img/radiocomando.jpg" width="240" height="240">
                        </td>
                        <td>5</td>
                        <td>199 euro</td>
                        <td><a href="./cliente.html">Aggiungi al carrello</a></td>
                    </tr>
                    <tr>
                        <td>Walkera FPV Goggle 2</td>
                        <td>
                            <img title="visore" alt="immagine visore"
                                 src="img/visore.jpg" width="240" height="240">
                        </td>
                        <td>3</td>
                        <td>99 euro</td>
                        <td><a href="./cliente.html">Aggiungi al carrello</a></td>
                    </tr>
                    <tr>
                        <td>5.8Ghz Clover Leaf Antenna(Female Receptacle/Angled)</td>
                        <td>
                            <img title="antenna" alt="immagine antenna"
                                 src="img/antenna.jpg" width="240" height="240">
                        </td>
                        <td>3</td>
                        <td>29 euro</td>
                        <td><a href="./cliente.html">Aggiungi al carrello</a></td>
                    </tr>
                    <tr>
                        <td>Set Ricambi STORM Racing Drone (RTF / Type-A V2)</td>
                        <td>
                            <img title="ricambio" alt="immagine ricambio"
                                 src="img/ricambio.jpg" width="240" height="320">
                        </td>
                        <td>10</td>
                        <td>120 euro</td>
                        <td><a href="./cliente.jsp">Aggiungi al carrello</a></td>
                    </tr>
                </table>
            </div>
        </div>
            
        <jsp:include page="footer.jsp"/>
        
    </body>
</html>
