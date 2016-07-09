<%-- 
    Document   : descrizione
    Created on : 9-lug-2016, 11.46.53
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Descrizione sito</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Mattia Samuel Mancosu">
        <meta name="description" content="Descrizione sito eCommerce">
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
                            <a href="./venditore.jsp"> Sezione venditore </a>
                        </li>
                        <li>
                            <a href="./cliente.jsp"> Sezione cliente </a>
                        </li>
                        <li>
                            <a href="./login.jsp"> Login </a>
                        </li>
                    </ul>
                </nav>
            </div>
            <div id="content">
                <p>Il miglior sito di eCommerce di Quartucciu 
                    specializzato nella rivendita di droni, radiocomandi, visori e 
                    accessori legati all'esperienza di volo in prima persona tramite 
                    droni di vario tipo.</p>
                <!--Lista alle sezioni interne della pagina-->
                <ol>
                    <li>
                        <a href="#negozio">Negozio online</a>
                        <ol>
                            <li>
                                <a href="#droni">Droni</a>
                            </li>
                            <li>
                                <a href="#radiocomandi">Radiocomandi</a>
                            </li>
                            <li>
                                <a href="#visori">Visori</a>
                            </li>
                            <li>
                                <a href="#ricambi">Ricambi</a>
                            </li>
                            <li>
                                <a href="#accessori">Accessori</a>
                            </li>
                        </ol>
                    </li>

                    <li>
                        <a href="#venditori">Sezione venditori</a>
                    </li>

                    <li>
                        <a href="#clienti">Sezione clienti</a>
                    </li>

                </ol>
                <h2 id="negozio">Negozio online</h2>
                <h3 id="droni">Droni</h3>
                <p>Verrà fornita una vasta gamma di droni organizzati per varie 
                    categorie, come:</p>
                <ol>            
                    <li>Dimensioni(dai nano-droni ai classici "250" fino a quelli che 
                        superano il metro di diametro).</li>
                    <li>Numero di motori(3,4 o 6).</li>
                    <li>Tipo(drone da corsa o drone per filmati).</li>
                </ol>
                <h3 id="radiocomandi">Radiocomandi</h3>
                <p>Saranno disponibili radiocomandi di tutte le fasce, dai più semplici 
                    non programmabili fino a quelli con schermi led per la gestione dei 
                    canali di ricezione e degli eventuali accessori montati nei droni.</p>
                <h3 id="visori">Visori e ricevitori</h3>
                <p>Una sezione legata alla rivendita di visori 2D e 3D e di ricevitori 
                    per droni e controller programmabili.</p>
                <h3 id="ricambi">Ricambi</h3>
                <p>Sezione più generale riguardante i ricambi per i droni(eliche, 
                    motori, batterie e moduli radio), per i visori(antenne direzionali 
                    e omnidirezionali).</p>
                <h3 id="accessori">Accessori</h3>
                <p>Accessori come barre al led per il riconoscimento in gara, decalcomanie e decorazioni.</p>
                <h2 id="venditori">Sezione venditori</h2>
                <p>Inserisci il tuo prodotto da mettere in vendita sul nostro sito!</p>
                <h2 id="clienti">Sezione clienti</h2>
                <p>Una lista dei prodotti attualmente disponibili nei nostri magazzini.</p>
            </div>
        </div>
        <footer>            
            <a href="http://validator.w3.org/check/referer">
                <img style="border:0;width:100px;height:30px"
                     src="http://www.w3.org/Icons/valid-xhtml10"
                     alt="Validatore HTML" />
            </a>
            <a href="http://jigsaw.w3.org/css-validator/check/referer">
                <img style="border:0;width:100px;height:30px"
                     src="http://jigsaw.w3.org/css-validator/images/vcss"
                     alt="Validatore CSS" />
            </a>
        </footer>
    </body>    
</html>
