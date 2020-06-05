<%-- 
    Document   : index
    Created on : 04-jun-2020, 17:31:15
    Author     : Jaasiel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Archivos</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" 
              integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    </head>
    <body>

        <img class="mx-auto d-block mt-5" src="img/LOGO2.png" width="200" alt="UMG" loading="lazy">

        <div class="mx-auto mt-5 " style="width: 400px;">

            <div class="list-group shadow">
                <a href="index.jsp" class="text-center list-group-item list-group-item-action active">
                    Menú - Administrador de archivos
                </a>
                <a href="controller?action=toupload" class="list-group-item list-group-item-action">Cargar archivos</a>
                <a href="controller?action=todownload" class="list-group-item list-group-item-action">Ver archivos cargados</a>
            </div>


        </div>

    </body>
</html>
