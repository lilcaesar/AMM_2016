/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function ()
{
   $("#Filtra").keyup(function()
    {  
        // Preleva il valore
        var text = $("#Filtra").val();
       
        $.ajax(
        {
            url: "Filter",
            data:{
              cmd: "search",
              text: text
            },
            dataType: 'json',
            success : function(data, state){
                aggiornaListaProdotti(data);
            },
            error : function(data, state){
            }
        });
        
       // Funzione che viene richiamata in caso di successo
        function aggiornaListaProdotti(listaProdotti)
        {
            $("#listaProdotti").empty();
            for(var prodotto in listaProdotti)
            {
                // Crea un nuovo tag td
                var newtd = document.createElement("td");
                newtd.setAttribute("nome", "prodotto");
                var text = document.createTextNode(listaProdotti[prodotto].nome);
                newtd.appendChild(text);
                // Crea link
                var link = document.createElement("a");
                link.setAttribute("href", "Registra?alunnoId="+listaAlunni[alunno].id);
                var registraTxt = document.createTextNode("Registra esame");
                link.appendChild(registraTxt);
                newtd.appendChild(link);
                
                // Aggiunge il tag li al tag ul
                $("#listaProdotti").append(newtd);
            }
        }
    }); 
});
