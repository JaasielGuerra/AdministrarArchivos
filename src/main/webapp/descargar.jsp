<%-- 
    Document   : descargar
    Created on : 04-jun-2020, 23:32:50
    Author     : Jaasiel
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Archivos</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" 
              integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    </head>
    <body>
        <div class="mx-auto mt-5 " style="width: 1200px;">

            <table class="table table-bordered table-sm">
                <thead class="thead-dark">
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Nombre</th>
                        <th scope="col">Tipo</th>
                        <th scope="col">Tamaño</th>
                        <th scope="col"></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${dts}" var="row">
                        <tr>
                            <th scope="row"><c:out value="${row.no}"/></th>
                            <td><c:out value="${row.name}"/></td>
                            <td><c:out value="${row.type}"/></td>
                            <td><c:out value="${row.size}"/> KB</td>
                            <td> 
                                <a class="badge badge-success" 
                                   href="controller?action=descargar&file=<c:out value="${row.name}"/>">
                                    <i class="fa fa-download" aria-hidden="true"></i>
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

            <div class="form-group">

                <a class="btn btn-sm btn-primary btn-block" href="index.jsp"><i class="fa fa-reply" aria-hidden="true"></i> Regresar</a>

            </div>

        </div>
    </body>
</html>
