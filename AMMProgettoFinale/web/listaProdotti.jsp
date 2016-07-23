<%-- 
    Document   : listaProdotti
    Created on : 13-lug-2016, 12.33.10
    Author     : root
--%>
<!--Pagina richiamata durante l'utilizzo del filtro-->
<%@page contentType="application/json" pageEncoding="UTF-8"%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<json:array>
    <!--Prelevo i dati dalla lista passata come parametro-->
    <c:forEach var="prodotto" items="${listaProdotti}">
        <!--E li assegno come proprietà json per poterle stampare in futuro-->
        <json:object>
            <json:property name="id" value="${prodotto.getId()}"/>
            <json:property name="nome" value="${prodotto.getNome()}"/>
            <json:property name="urlImmagine" value="${prodotto.getURLImmagine()}"/>
            <json:property name="descrizione" value="${prodotto.getDescrizione()}"/>
            <json:property name="prezzo" value="${prodotto.getPrezzo()}"/>
            <json:property name="disponibilita" value="${prodotto.getDisponibilita()}"/>
        </json:object>
    </c:forEach>
</json:array>