<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Szczegóły kota</title>
</head>
<body>
<a href="lista">Powrót do listy kotów</a><br />
<table border="1">
    <tbody>
    <tr>
        <th>Imię</th>
        <td>${cat.name}</td>
    </tr>
    <tr>
        <th>Data urodzenia</th>
        <td><fmt:formatDate pattern="dd.MM.yyyy" value="${cat.dateBirth}" /></td>
    </tr>
    <tr>
        <th>Waga</th>
        <td><fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${cat.weight}" /> kg</td>
    </tr>
    <tr>
        <th>Imię opiekuna</th>
        <td>${cat.nameHandler}</td>
    </tr>
    </tbody>
</table>
</body>
</html>