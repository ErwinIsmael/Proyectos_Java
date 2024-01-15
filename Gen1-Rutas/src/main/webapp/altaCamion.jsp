<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="java.util.*" %>
<%@page import="com.jimenez.app.rutas.models.enums.*" %>



<%
  Map<String, String> errores = (Map<String, String>) request.getAttribute("errores");
%>

 <%Marcas[] marcasEnum = Marcas.values();%>
 <%Tipos[] tiposEnum = Tipos.values();%>


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

    <nav class="navbar navbar-inverse">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header" id="div1">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                                    <a class="navbar-brand" href="#" id="enlace1">Rutas App</a>
            </div>




            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                            aria-haspopup="true" aria-expanded="false">Choferes<span
                                class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="<%=request.getContextPath()%>/choferes/listar">Lista Choferes</a></li>
                            <li><a href="<%=request.getContextPath()%>/choferes/alta">Alta Choferes</a></li>


                        </ul>


                    </li>


                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                            aria-haspopup="true" aria-expanded="false">Camiones<span
                                class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="<%=request.getContextPath()%>/camiones/listar">Lista Camiones</a></li>
                            <li><a href="<%=request.getContextPath()%>/camiones/alta">Alta Camion</a></li>


                        </ul>
                    </li>


                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                            aria-haspopup="true" aria-expanded="false">Rutas<span
                                class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="<%=request.getContextPath()%>/rutas/alta">Alta Ruta</a></li>


                        </ul>
                    </li>

                </ul>
            </div><!-- /.navbar-collapse -->
        </div><!-- /.container-fluid -->
      </nav>



    <div class="container">
        <div class="row">
            <div class="col-12">
                <h2>Formulario Alta Camion</h2>
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
            <form action="<%=request.getContextPath()%>/camiones/alta" method="post">
                <div class="col-md-12">
                    <div class="form-group">
                        <label for="">Matricula</label>
                        <!-- input:text[name=Cadena][id=Cadena].form-control[value=Cadena] -->
                        <input type="text" name="matricula" id="matricula" class="form-control" value="${param.matricula}">
                        <%
                            if(errores != null && errores.containsKey("matricula")){
                                out.println("<span class='text-danger'>"+ errores.get("matricula") +"</span>");
                            }
                        %>
                    </div>
                    <!-- input:text[name=Cadena][id=Cadena].form-control[value=Cadena] -->

                    <div class="form-group">
                        <label for="">Tipo camion</label>
                        <select class="form-control" id="tipoCamion" name="tipoCamion" value="${param.tipoCamion}">
                            <option style="display:none;">--seleccionar--</option>
                            <% for (Tipos tipo : tiposEnum) { %>
                                  <option ><%= tipo.name() %></option>
                            <% } %>
                        </select>
                    </div>


                    <!-- input:text[name=Cadena][id=Cadena].form-control[value=Cadena] -->

                    <div class="form-group">
                        <label for="">Modelo</label>
                        <select class="form-control" id="modelo" name="modelo" value="${param.modelo}">
                            <option style="display:none;">--seleccionar--</option>
                            <%
                            int currentYear = java.time.Year.now().getValue();
                            for (int year = 2003; year <= currentYear + 1; year++) {
                            %>
                                <option><%= year %></option>
                            <% } %>
                        </select>
                        <%
                            if(errores != null && errores.containsKey("modelo")){
                                out.println("<span class='text-danger'>"+ errores.get("modelo") +"</span>");
                            }
                        %>
                    </div>




         <!-- input:text[name=Cadena][id=Cadena].form-control[value=Cadena] -->

                <div class="form-group">
                    <label for="">Marca</label>

                    <select class="form-control" id="marca" name="marca" value="${param.marca}">
                        <option style="display:none;">--seleccionar--</option>
                        <% for (Marcas marca : marcasEnum) { %>
                              <option ><%= marca.name() %></option>
                        <% } %>
                    </select>
                    <%
                        if(errores != null && errores.containsKey("marca")){
                            out.println("<span class='text-danger'>"+ errores.get("marca") +"</span>");
                        }
                    %>
                </div>
                    <div class="form-group">
                        <label for="">Capacidad</label>
                        <!-- input:text[name=Cadena][id=Cadena].form-control[value=Cadena] -->
                        <input type="text" name="capacidad" id="capacidad" class="form-control" value="${param.capacidad}">
                        <%
                            if(errores != null && errores.containsKey("capacidad")){
                                out.println("<span class='text-danger'>"+ errores.get("capacidad") +"</span>");
                            }
                        %>
                    </div>

                    <div class="form-group">
                        <label for="">Kilometraje</label>
                        <!-- input:text[name=Cadena][id=Cadena].form-control[value=Cadena] -->
                        <input type="text" name="kilometraje" id="kilometraje" class="form-control" value="${param.kilometraje}">
                        <%
                            if(errores != null && errores.containsKey("kilometraje")){
                                out.println("<span class='text-danger'>"+ errores.get("kilometraje") +"</span>");
                            }
                        %>
                    </div>

                    <div class="form-group">
                        <label for="">Disponibilidad</label>
                        <!-- input:text[name=Cadena][id=Cadena].form-control[value=Cadena] -->
                        <!-- input:checkbox[name=disponibilidad][id=disponibilidad].form-check-input[value=Cadena][checked] -->
                        <input type="checkbox" name="disponibilidad" id="disponibilidad" class="form-check-input" value="${param.disponibilidad}" checked>
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