/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function ()
{
    $("#Filtra").keyup(function ()
    {
        // Preleva il valore
        var text = $("#Filtra").val();

        $.ajax(
                {
                    url: "filter.json",
                    data: {
                        cmd: "search",
                        text: text
                    },
                    dataType: 'json',
                    success: function (data, state) {
                        caricaListaProdotti(data);
                    },
                    error: function (data, state) {
                    }
                });


        function caricaListaProdotti(listaProdotti)
        {
            if (listaProdotti.length !== 0) {   //Se trovo prodotti nella lista
                $(".listaProdotti").empty();    //Svuoto la tabella e la scritta di errore
                $("#ErroreFiltro").empty();
                for (var prodotto in listaProdotti) //Per ogni prodotto che trovo creo...
                {
                    var tr = document.createElement("tr");
                    tr.setAttribute("class", "listaProdotti");

                    //...la colonna del nome..
                    var td = document.createElement("td");
                    var txt = document.createTextNode(listaProdotti[prodotto].nome);
                    td.appendChild(txt);
                    tr.appendChild(td);

                    //..dell'immagine...
                    var td = document.createElement("td");
                    var img = document.createElement("img");
                    img.setAttribute("title", listaProdotti[prodotto].nome);
                    img.setAttribute("src", listaProdotti[prodotto].urlImmagine);
                    img.setAttribute("alt", listaProdotti[prodotto].nome);
                    img.setAttribute("width", 120);
                    img.setAttribute("height", 120);
                    td.appendChild(img);
                    tr.appendChild(td);

                    //..della descrizione...
                    var td = document.createElement("td");
                    var txt = document.createTextNode(listaProdotti[prodotto].descrizione);
                    td.appendChild(txt);
                    tr.appendChild(td);

                    //...della disponibilità...
                    var td = document.createElement("td");
                    var txt = document.createTextNode(listaProdotti[prodotto].disponibilita);
                    td.appendChild(txt);
                    tr.appendChild(td);

                    //...del prezzo...
                    var td = document.createElement("td");
                    var txt = document.createTextNode(listaProdotti[prodotto].prezzo);
                    td.appendChild(txt);
                    tr.appendChild(td);

                    //...e il link per l'acquisto
                    var td = document.createElement("td");
                    var a = document.createElement("a");
                    a.setAttribute("href", "cliente.html?idProdotto=" + listaProdotti[prodotto].id);
                    a.innerHTML = 'Aggiungi al carrello';
                    td.appendChild(a);
                    tr.appendChild(td);

                    document.getElementById("tabella").appendChild(tr);
                }
            } else {//Altrimenti segnalo la mancanza di prodotti
                $(".listaProdotti").empty();
                var txt = document.getElementById("ErroreFiltro");
                txt.innerHTML = 'Prodotto non presente';
            }
        }
    });
});
