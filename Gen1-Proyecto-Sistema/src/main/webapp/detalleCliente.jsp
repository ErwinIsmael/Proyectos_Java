<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="java.util.*" %>
<%@page import="com.jimenez.app.rutas.models.*" %>


<%
  Cliente cliente = (Cliente) request.getAttribute("cliente");
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
    <script src="//cdn.datatables.net/1.13.4/js/jquery.dataTables.min.js"></script>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/sweetalert2@11.10.3/dist/sweetalert2.min.css" integrity="sha256-h2Gkn+H33lnKlQTNntQyLXMWq7/9XI2rlPCsLsVcUBs=" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11.10.3/dist/sweetalert2.all.min.js" integrity="sha256-xkymBp70qMSHnInLEXDWb34pyON8sBGMA1S84vQILx4=" crossorigin="anonymous"></script>



      <style>

          .swal2-title {
                        font-size: 30px !important;
                    }
                .swal2-html-container{
                  font-size: 20px !important;
                }

                .swal2-confirm {
                  font-size: 13px !important;
                }
                .swal2-cancel{
                    font-size: 13px !important;
                }


        .swal2-icon{
            height: 70px !important;
            width: 70px !important;
        }



      body {
          margin: 0;
            font-family: "Open Sans", -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, Oxygen-Sans, Ubuntu, Cantarell, "Helvetica Neue", Helvetica, Arial, sans-serif;

      }


      .dashboard {
          display: -webkit-box;
          display: -webkit-flex;
          display: -ms-flexbox;
          display: flex;
          min-height: 100vh;
      }

      .dashboard-app {
          display: -webkit-box;
          display: -webkit-flex;
          display: -ms-flexbox;
          display: flex;
          -webkit-box-orient: vertical;
          -webkit-box-direction: normal;
          -webkit-flex-direction: column;
          -ms-flex-direction: column;
          flex-direction: column;
          -webkit-box-flex: 2;
          -webkit-flex-grow: 2;
          -ms-flex-positive: 2;
          flex-grow: 2;
          margin-top: 84px;
      }

      .dashboard-content {
          -webkit-box-flex: 2;
          -webkit-flex-grow: 2;
          -ms-flex-positive: 2;
          flex-grow: 2;
          padding: 25px;
      }

      .dashboard-nav {
          min-width: 238px;
          position: fixed;
          left: 0;
          top: 0;
          bottom: 0;
          overflow: auto;
          background-color: #373193;
      }

      .dashboard-compact .dashboard-nav {
          display: none;
      }

      .dashboard-nav header {
          min-height: 84px;
          padding: 8px 27px;
          display: -webkit-box;
          display: -webkit-flex;
          display: -ms-flexbox;
          display: flex;
          -webkit-box-pack: center;
          -webkit-justify-content: center;
          -ms-flex-pack: center;
          justify-content: center;
          -webkit-box-align: center;
          -webkit-align-items: center;
          -ms-flex-align: center;
          align-items: center;
      }

      .dashboard-nav header .menu-toggle {
          display: none;
          margin-right: auto;
      }

      .dashboard-nav a {
          color: #515151;
      }

      .dashboard-nav a:hover {
          text-decoration: none;
      }

      .dashboard-nav {
          background-color: #443ea2;
      }

      .dashboard-nav a {
          color: #fff;
      }

      .brand-logo {
          font-family: "Nunito", sans-serif;
          font-weight: bold;
          font-size: 20px;
          display: -webkit-box;
          display: -webkit-flex;
          display: -ms-flexbox;
          display: flex;
          color: #515151;
          -webkit-box-align: center;
          -webkit-align-items: center;
          -ms-flex-align: center;
          align-items: center;
      }

      .brand-logo:focus, .brand-logo:active, .brand-logo:hover {
          color: #dbdbdb;
          text-decoration: none;
      }

      .brand-logo i {
          color: #d2d1d1;
          font-size: 27px;
          margin-right: 10px;
      }

      .dashboard-nav-list {
          display: -webkit-box;
          display: -webkit-flex;
          display: -ms-flexbox;
          display: flex;
          -webkit-box-orient: vertical;
          -webkit-box-direction: normal;
          -webkit-flex-direction: column;
          -ms-flex-direction: column;
          flex-direction: column;
      }

      .dashboard-nav-item {
          min-height: 56px;
          padding: 8px 20px 8px 70px;
          display: -webkit-box;
          display: -webkit-flex;
          display: -ms-flexbox;
          display: flex;
          -webkit-box-align: center;
          -webkit-align-items: center;
          -ms-flex-align: center;
          align-items: center;
          letter-spacing: 0.02em;
          transition: ease-out 0.5s;
      }

      .dashboard-nav-item i {
          width: 36px;
          font-size: 19px;
          margin-left: -40px;
      }

      .dashboard-nav-item:hover {
          background: rgba(255, 255, 255, 0.04);
      }

      .active {
          background: rgba(0, 0, 0, 0.1);
      }

      .dashboard-nav-dropdown {
          display: -webkit-box;
          display: -webkit-flex;
          display: -ms-flexbox;
          display: flex;
          -webkit-box-orient: vertical;
          -webkit-box-direction: normal;
          -webkit-flex-direction: column;
          -ms-flex-direction: column;
          flex-direction: column;
      }

      .dashboard-nav-dropdown.show {
          background: rgba(255, 255, 255, 0.04);
      }

      .dashboard-nav-dropdown.show > .dashboard-nav-dropdown-toggle {
          font-weight: bold;
      }

      .dashboard-nav-dropdown.show > .dashboard-nav-dropdown-toggle:after {
          -webkit-transform: none;
          -o-transform: none;
          transform: none;
      }

      .dashboard-nav-dropdown.show > .dashboard-nav-dropdown-menu {
          display: -webkit-box;
          display: -webkit-flex;
          display: -ms-flexbox;
          display: flex;
      }

      .dashboard-nav-dropdown-toggle:after {
          content: "";
          margin-left: auto;
          display: inline-block;
          width: 0;
          height: 0;
          border-left: 5px solid transparent;
          border-right: 5px solid transparent;
          border-top: 5px solid rgba(81, 81, 81, 0.8);
          -webkit-transform: rotate(90deg);
          -o-transform: rotate(90deg);
          transform: rotate(90deg);
      }

      .dashboard-nav .dashboard-nav-dropdown-toggle:after {
          border-top-color: rgba(255, 255, 255, 0.72);
      }

      .dashboard-nav-dropdown-menu {
          display: none;
          -webkit-box-orient: vertical;
          -webkit-box-direction: normal;
          -webkit-flex-direction: column;
          -ms-flex-direction: column;
          flex-direction: column;
      }

      .dashboard-nav-dropdown-item {
          min-height: 40px;
          padding: 8px 20px 8px 70px;
          display: -webkit-box;
          display: -webkit-flex;
          display: -ms-flexbox;
          display: flex;
          -webkit-box-align: center;
          -webkit-align-items: center;
          -ms-flex-align: center;
          align-items: center;
          transition: ease-out 0.5s;
      }

      .dashboard-nav-dropdown-item:hover {
          background: rgba(255, 255, 255, 0.04);
      }

      .menu-toggle {
          position: relative;
          width: 42px;
          height: 42px;
          display: -webkit-box;
          display: -webkit-flex;
          display: -ms-flexbox;
          display: flex;
          -webkit-box-align: center;
          -webkit-align-items: center;
          -ms-flex-align: center;
          align-items: center;
          -webkit-box-pack: center;
          -webkit-justify-content: center;
          -ms-flex-pack: center;
          justify-content: center;
          color: #443ea2;
      }

      .menu-toggle:hover, .menu-toggle:active, .menu-toggle:focus {
          text-decoration: none;
          color: #875de5;
      }

      .menu-toggle i {
          font-size: 20px;
      }

      .dashboard-toolbar {
          min-height: 84px;
          background-color: #dfdfdf;
          display: -webkit-box;
          display: -webkit-flex;
          display: -ms-flexbox;
          display: flex;
          -webkit-box-align: center;
          -webkit-align-items: center;
          -ms-flex-align: center;
          align-items: center;
          padding: 8px 27px;
          position: fixed;
          top: 0;
          right: 0;
          left: 0;
          z-index: 1000;
      }

      .nav-item-divider {
          height: 1px;
          margin: 1rem 0;
          overflow: hidden;
          background-color: rgba(236, 238, 239, 0.3);
      }

      @media (min-width: 992px) {
          .dashboard-app {
              margin-left: 238px;
          }

          .dashboard-compact .dashboard-app {
              margin-left: 0;
          }
      }


      @media (max-width: 768px) {
          .dashboard-content {
              padding: 15px 0px;
          }
      }

      @media (max-width: 992px) {
          .dashboard-nav {
              display: none;
              position: fixed;
              top: 0;
              right: 0;
              left: 0;
              bottom: 0;
              z-index: 1070;
          }

          .dashboard-nav.mobile-show {
              display: block;
          }
      }

      @media (max-width: 992px) {
          .dashboard-nav header .menu-toggle {
              display: -webkit-box;
              display: -webkit-flex;
              display: -ms-flexbox;
              display: flex;
          }
      }

      @media (min-width: 992px) {
          .dashboard-toolbar {
              left: 238px;
          }

          .dashboard-compact .dashboard-toolbar {
              left: 0;
          }
      }
      </style>
</head>
<body>
<div class="loader"></div>
    <div class='dashboard'>
        <div class="dashboard-nav">
            <header>
                <a href="#!" class="menu-toggle">
                    <i class="fas fa-bars"></i>
                </a>
                <a href="#" class="brand-logo">
                    <i class="fas fa-anchor"></i>
                    <span>Uniformes</span>
                </a>
            </header>

            <nav class="dashboard-nav-list">
                <a href="<%=request.getContextPath()%>/clientes/menu" class="dashboard-nav-item">
                    <i class="fas fa-home"></i>
                    Menu
                </a>
                <a href="<%=request.getContextPath()%>/pedidos/alta" class="dashboard-nav-item active">
                    <i class="fas fa-tachometer-alt"></i>
                    Pedidos
                </a>

                <div class='dashboard-nav-dropdown'>
                    <a href="#!" class="dashboard-nav-item dashboard-nav-dropdown-toggle">
                        <i class="fas fa-photo-video"></i> Clientes
                    </a>
                <div class='dashboard-nav-dropdown-menu'>
                    <a href="<%=request.getContextPath()%>/clientes/listar" class="dashboard-nav-dropdown-item">Lista de Clientes</a>
                    <a href="<%=request.getContextPath()%>/clientes/alta" class="dashboard-nav-dropdown-item">Alta de Clientes</a>
                </div>
                </div>

                <div class='dashboard-nav-dropdown'>
                    <a href="#!" class="dashboard-nav-item dashboard-nav-dropdown-toggle">
                        <i class="fas fa-photo-video"></i> Escuelas
                    </a>
                <div class='dashboard-nav-dropdown-menu'>
                    <a href="<%=request.getContextPath()%>/escuelas/listar" class="dashboard-nav-dropdown-item">Lista de Escuelas</a>
                    <a href="<%=request.getContextPath()%>/escuelas/alta" class="dashboard-nav-dropdown-item">Alta de Escuelas</a>
                </div>
                </div>

                <div class='dashboard-nav-dropdown'>
                    <a href="#!" class="dashboard-nav-item dashboard-nav-dropdown-toggle">
                        <i class="fas fa-users"></i> Uniformes
                    </a>
                    <div class='dashboard-nav-dropdown-menu'>
                        <a href="<%=request.getContextPath()%>/uniformes/lista" class="dashboard-nav-dropdown-item">Lista de Uniformes</a>
                        <a href="<%=request.getContextPath()%>/uniformes/alta" class="dashboard-nav-dropdown-item">Agregar nuevo uniforme</a>
                    </div>
                </div>

                <div class='dashboard-nav-dropdown'>
                    <a href="#!" class="dashboard-nav-item dashboard-nav-dropdown-toggle">
                        <i class="fas fa-money-check-alt"></i> Pedidos
                    </a>
                <div class='dashboard-nav-dropdown-menu'>
                    <a href="<%=request.getContextPath()%>/pedidos/alta" class="dashboard-nav-dropdown-item">Levantar nuevo Pedido</a>
                </div>
                </div>
                <a href="#" class="dashboard-nav-item"><i class="fas fa-cogs"></i> Settings </a><a
                        href="#" class="dashboard-nav-item"><i class="fas fa-user"></i> Profile </a>
              <div class="nav-item-divider"></div>
              <a
                        href="#" class="dashboard-nav-item"><i class="fas fa-sign-out-alt"></i> Logout </a>
            </nav>
        </div>
        <div class='dashboard-app'>
            <header class='dashboard-toolbar'><a href="#!" class="menu-toggle"><i class="fas fa-bars"></i></a></header>
            <div class='dashboard-content'>
                <div class="container">
                    <div class='card-header'>


             <!-- **************************   CONTENIDO DE DASHBOARD ************************************  -->


             <div class="container">
                <div class="row">
                    <div class="col-12">
                        <div class="card border">
                            <div class="card-header">
                                <h3><strong>Detalle del cliente</strong></h3>
                            </div>
                        </div>

                        <div class="card-body">
                            <ul class="list-group">
                                <li class="list-group-item"><strong>Nombre: </strong><%=cliente.getNombre() %></li>
                                <li class="list-group-item"><strong>Apellido Materno: </strong><%=cliente.getApPaterno()%></li>
                                <li class="list-group-item"><strong>Apellido Materno: </strong><%=cliente.getApMaterno() %></li>
                                <li class="list-group-item"><strong>Telefono: </strong><%=cliente.getTelefono() %></li>
                                <li class="list-group-item"><strong>Correo electronico: </strong><%=cliente.getEmail() %></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>


<!-- ****************************** FIN CONTENIDO DASHBOARD ************************************-->
                    </div>


                </div>
            </div>
        </div>
    </div>



    <!-- *************************COMIENZA TARJETA FLOTANTE ****************************-->


<!--******************INICIO DE SCRIPTS ***********************************-->
<script>
 const mobileScreen = window.matchMedia("(max-width: 990px )");
 $(document).ready(function () {
     $(".dashboard-nav-dropdown-toggle").click(function () {
         $(this).closest(".dashboard-nav-dropdown")
             .toggleClass("show")
             .find(".dashboard-nav-dropdown")
             .removeClass("show");
         $(this).parent()
             .siblings()
             .removeClass("show");
     });
     $(".menu-toggle").click(function () {
         if (mobileScreen.matches) {
             $(".dashboard-nav").toggleClass("mobile-show");
         } else {
             $(".dashboard").toggleClass("dashboard-compact");
         }
     });
 });
</script>
</body>
</html>