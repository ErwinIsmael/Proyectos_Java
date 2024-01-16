<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="java.util.*" %>



<%
  Map<String, String> errores = (Map<String, String>) request.getAttribute("errores");
%>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-2.2.4.min.js"
            integrity="sha256-BbhdlvQf/xTY9gja0Dq3HiwQF8LaCRTXxZKRutelT44="
            crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="//cdn.datatables.net/1.13.4/css/jquery.dataTables.min.css">



    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>


</head>
<body>




    <div class="container">
        <div class="row">
            <div class="col-12">
                <h2>Formulario Alta Cliente</h2>
            </div>
        </div>

        <br>
        <% if(errores != null && errores.size()>0){ %>
            <ul class="alert alert-danger mx-5 px-5">
                <% for(String error: errores.values()){%>
                <li><%=error%></li>
                <%}%>
            </ul>
            <%}%>

        <div class="row">
            <form action="<%=request.getContextPath()%>/clientes/alta" method="post">
                <div class="col-md-12">


                    <div class="form-group">
                        <label for="">Nombre</label>
                        <!-- input:text[name=Cadena][id=Cadena].form-control[value=Cadena] -->
                        <input type="text" name="nombre" id="nombre" class="form-control" value="${param.nombre}">
                        <%
                            if(errores != null && errores.containsKey("nombre")){
                                out.println("<span class='text-danger'>"+ errores.get("nombre") +"</span>");
                            }
                        %>
                    </div>
                    <!-- input:text[name=Cadena][id=Cadena].form-control[value=Cadena] -->

                    <div class="form-group">
                        <label for="">Apellido Paterno</label>
                        <!-- input:text[name=Cadena][id=Cadena].form-control[value=Cadena] -->
                        <input type="text" name="apPaterno" id="apPaterno" class="form-control" value="${param.apPaterno}">
                        <%
                            if(errores != null && errores.containsKey("apPaterno")){
                                out.println("<span class='text-danger'>"+ errores.get("apPaterno") +"</span>");
                            }
                        %>
                    </div>


                    <!-- input:text[name=Cadena][id=Cadena].form-control[value=Cadena] -->
                    <div class="form-group">
                        <label for="">Apellido Materno</label>
                        <!-- input:text[name=Cadena][id=Cadena].form-control[value=Cadena] -->
                        <input type="text" name="apMaterno" id="apMaterno" class="form-control" value="${param.apMaterno}">
                        <%
                            if(errores != null && errores.containsKey("apMaterno")){
                                out.println("<span class='text-danger'>"+ errores.get("apMaterno") +"</span>");
                            }
                        %>
                    </div>

                    <div class="form-group">
                        <label for="">Telefono</label>
                        <!-- input:text[name=Cadena][id=Cadena].form-control[value=Cadena] -->
                        <input type="text" name="telefono" id="telefono" class="form-control" value="${param.telefono}">
                        <%
                            if(errores != null && errores.containsKey("telefono")){
                                out.println("<span class='text-danger'>"+ errores.get("telefono") +"</span>");
                            }
                        %>
                    </div>

                    <div class="form-group">
                        <label for="">Correo electronico</label>
                        <input type="text" name="email" id="email" class="form-control" value="${param.email}">
                        <%
                            if(errores != null && errores.containsKey("email")){
                                out.println("<span class='text-danger'>"+ errores.get("email") +"</span>");
                            }
                        %>
                    </div>


                    <div class="form-group">

                        <button type="submit" class="btn btn-success">Guardar</button>

                    </div>
                </div>
            </form>
        </div>
    </div>
</body>
</html>