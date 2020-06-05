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
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    </head>
    <body>

        <div class="mx-auto mt-5" style="width: 800px;">

            <div class="card shadow">

                <div class="card-body ">

                    <h5 class="card-title">Cargar archivo</h5>

                    <form action="controller?action=carga" enctype="MULTIPART/FORM-DATA" method="post">

                        <div class="form-row">

                            <div class="form-group col-md-12">

                                <div class="custom-file">
                                    <input type="file" name="file" class="custom-file-input" id="customFile" />
                                    <label class="custom-file-label" for="customFile">Seleccionar...</label>
                                </div>

                            </div>

                            <div class="form-group col-md-4">

                                <button class="btn btn-sm btn-success btn-block" type="submit"><i class="fa fa-upload" aria-hidden="true"></i> Subir</button>

                            </div>

                            <div class="form-group col-md-4">

                                <a class="btn btn-sm btn-primary btn-block" href="index.jsp"><i class="fa fa-reply" aria-hidden="true"></i> Regresar</a>

                            </div>

                        </div>

                    </form>

                </div>


            </div>



        </div>


    </body>
</html>
