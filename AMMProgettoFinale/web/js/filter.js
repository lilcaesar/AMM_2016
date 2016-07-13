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
                    url: "Filter",
                    data: {
                        cmd: "search",
                        text: text
                    },
                    dataType: 'json',
                    success: function (data, state) {
                        aggiornaListaProdotti(data);
                    },
                    error: function (data, state) {
                    }
                });

        // Funzione che viene richiamata in caso di successo
        function aggiornaListaProdotti(listaProdotti)
        {
            $("#listaProdotti").empty();
            for (var prodotto in listaProdotti)
            {
                var tr = document.createElement("tr");

                // colonna per il nome
                var td = document.createElement("td");
                var txt = document.createTextNode(listaOggetti[oggetto].name);
                td.appendChild(txt);
                tr.appendChild(td);
                
                // colonna per l'immagine 
                var td = document.createElement("td");
                td.setAttribute("class", "urlImmagine");
                var img = document.createElement("img");
                img.setAttribute("title", listaProdotti[prodotto].name);//dai campi name del vettore json
                img.setAttribute("src", listaProdotti[prodotto].urlImmagine);
                img.setAttribute("alt", listaProdotti[prodotto].name);
                img.setAttribute("width", 120);
                img.setAttribute("height", 120);
                td.appendChild(img);
                tr.appendChild(td);

                //colonna per la descrizione
                var td = document.createElement("td");
                var txt = document.createTextNode(listaProdotti[prodotto].descrizione);
                td.appendChild(txt);
                tr.appendChild(td);
                
                // colonna per la quantità
                var td = document.createElement("td");
                td.setAttribute("class", "disponibilita");
                var txt = document.createTextNode(listaProdotti[prodotto].disponibilita);
                td.appendChild(txt);
                tr.appendChild(td);

                // colonna per il prezzo
                var td = document.createElement("td");
                td.setAttribute("class", "prezzo");
                var txt = document.createTextNode(listaProdotti[prodotto].prezzo);
                td.appendChild(txt);
                tr.appendChild(td);                

                // colonna per il link all'acquisto
                var td = document.createElement("td");
                td.setAttribute("class", "link");
                var a = document.createElement("a");
                a.setAttribute("href", "cliente.html?idOggetto=" + listaOggetti[oggetto].id);
                a.innerHTML = 'Aggiungi al carrello';
                td.appendChild(a);
                tr.appendChild(td);
                // inserisce la riga appena creata nella tabella
                document.getElementById("table").appendChild(tr);
            }
        }
    });
});
