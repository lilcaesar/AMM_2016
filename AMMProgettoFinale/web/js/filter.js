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
            if (listaProdotti.length !== 0) {
                var debug = document.getElementById("debug");
                debug.innerHTML = listaProdotti.length;
                $("#listaProdotti").empty();
                $("#ErroreFiltro").empty();
                for (var prodotto in listaProdotti)
                {
                    var tr = document.createElement("tr");
                    tr.setAttribute("id", "listaProdotti");

                    var td = document.createElement("td");
                    var txt = document.createTextNode(listaProdotti[prodotto].nome);
                    td.appendChild(txt);
                    tr.appendChild(td);


                    var td = document.createElement("td");
                    var img = document.createElement("img");
                    img.setAttribute("title", listaProdotti[prodotto].nome);
                    img.setAttribute("src", listaProdotti[prodotto].urlImmagine);
                    img.setAttribute("alt", listaProdotti[prodotto].nome);
                    img.setAttribute("width", 120);
                    img.setAttribute("height", 120);
                    td.appendChild(img);
                    tr.appendChild(td);


                    var td = document.createElement("td");
                    var txt = document.createTextNode(listaProdotti[prodotto].descrizione);
                    td.appendChild(txt);
                    tr.appendChild(td);


                    var td = document.createElement("td");
                    var txt = document.createTextNode(listaProdotti[prodotto].disponibilita);
                    td.appendChild(txt);
                    tr.appendChild(td);


                    var td = document.createElement("td");
                    var txt = document.createTextNode(listaProdotti[prodotto].prezzo);
                    td.appendChild(txt);
                    tr.appendChild(td);


                    var td = document.createElement("td");
                    var a = document.createElement("a");
                    a.setAttribute("href", "cliente.html?idProdotto=" + listaProdotti[prodotto].id);
                    a.innerHTML = 'Aggiungi al carrello';
                    td.appendChild(a);
                    tr.appendChild(td);

                    document.getElementById("tabella").appendChild(tr);
                }
            } else {
                $("#listaProdotti").empty();
                var txt = document.getElementById("ErroreFiltro");
                txt.innerHTML = 'Prodotto non presente';
            }
        }
    });
});
