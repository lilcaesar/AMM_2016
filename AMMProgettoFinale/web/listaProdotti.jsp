<%-- 
    Document   : listaProdotti
    Created on : 13-lug-2016, 12.33.10
    Author     : root
--%>

<%@page contentType="application/json" pageEncoding="UTF-8"%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<json:array>
    <c:forEach var="prodotto" items="${listaProdotti}">
        <json:object>
            <json:property name="nome" value="${prodotto.getNome()}"/>
            <json:property name="urlImmagine" value="${prodotto.getURLImmagine()}"/>
            <json:property name="descrizione" value="${prodotto.getDescrizione()}"/>
            <json:property name="prezzo" value="${prodotto.getPrezzo()}"/>
            <json:property name="disponibilita" value="${prodotto.getDIsponibilita()}"/>
        </json:object>
    </c:forEach>
</json:array>