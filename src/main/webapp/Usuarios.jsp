<%-- 
    Document   : Usuarios
    Created on : 13-may-2017, 1:04:47
    Author     : oscar
--%>
<%@page import="com.sv.udb.controlador.CtrlUsuarios"%>
<%@page import="com.sv.udb.modelo.Usuarios"%>
<%@page import="com.sv.udb.controlador.DepartamentosCtrl"%>
<%@page import="com.sv.udb.modelo.Departamentos"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Piezas</title>
         <link type='text/css' rel='stylesheet' href='css/icons.css'/>
  
    <!-- Import materialize.css -->
    <link type='text/css' rel='stylesheet' href='webjars/materialize/0.98.0/dist/css/materialize.min.css'  media='screen,projection'/>
    <!-- Let browser know website is optimized for mobile -->
    <meta name='viewport' content='width=device-width, initial-scale=1.0'/>
     <script type="text/javascript" src="webjars/jquery/3.2.1/dist/jquery.min.js"></script>
    <script type='text/javascript' src='webjars/materialize/0.98.0/dist/js/jquery.min.js'></script>
    <script type='text/javascript' src='webjars/materialize/0.98.0/dist/js/materialize.min.js'></script>
    </head>
    <body>
        <!--COPIAR DESDE AQUI -->
<!--<div class="navbar-fixed">
	<nav class="blue darken-4">
    <div class="nav-wrapper">
      <a href="#!" class="brand-logo center">Parcial 2 periodo</a>
      <a href="#" data-activates="mobile-demo" class="button-collapse"><i class="material-icons">menu</i></a>
      <ul class="right hide-on-med-and-down">
        <li><a href="index.jsp">Piezas</a></li>
        <li><a href="proveedores.jsp">Proveedores</a></li>       
        <li><a href="bodega.jsp">Bodega</a></li>       
      </ul>

       
    </div>
  </nav>

</div>-->

<!--<ul class="side-nav" id="mobile-demo">
        <li><a href="index.jsp">Piezas</a></li>
        <li><a href="proveedores.jsp">Proveedores</a></li>       
        <li><a href="bodega.jsp">Bodega</a></li>
      </ul>-->

<br>
<br>
<%
            String accion =(String)request.getAttribute("accion");
            String value;
            String clssEditBton;
            if(accion == "Editar")
            {
                 clssEditBton = "";
                 value = "Limpiar" ;
            }
            else
            { 
                clssEditBton = "display: none";
                 value="Guardar";
            }
        %>


<div class="container">
	<div class="row">
            <h1>${mensAlert}</h1>		
                    <form method="POST" action="UsuarioServ" name="Demo" >
                        
                         <input  type="hidden" name="codi" id="codi" value="${codi}">
        
			<div class="col s12">	
				<div class="card-panel white z-depth-5">
        			<div class="row">
        				<div class="col s12">
        					<h3 class="center-align black-text">Usuarios</h3>
        				</div>
        			</div>
        			<div class="row">
  					<div class="input-field col s6">
					     <input  name="usuario" id="first_name" type="text" class="validate" value="${usuario}">
					     <label for="first_name" >Usuario</label>
                                        </div>

					        
    				</div>
                                  <div class="row">
  					<div class="input-field col s6">
					     <input  name="nombre" id="nomb" type="text" class="validate" value="${nombre}">
					     <label for="nomb" >Nombre</label>
                                        </div>					       
                                    </div>
                                   <div class="row">
  					<div class="input-field col s6">
					     <input  name="apellido" id="apell" type="text" class="validate" value="${apellido}">
					     <label for="apell" >Apellido</label>
                                        </div>					       
                                    </div>
                                    <div class="row">
  					<div class="input-field col s6">
					     <input  name="contra" id="contra" type="text" class="validate" value="${contra}">
					     <label for="contra" >Contraseña</label>
                                        </div>					       
                                    </div>
                                 
                                <div class="divider"></div>
        			<br>
        			<div class="row">
        				<c:if test="${codi == null}">
                                        <div class="col s6 m4">
							<input class="btn waves-effect blue darken-4 waves-light" type="submit" name="btnUsua" value="Guardar">		    		
	  					</div>
                                    </c:if>        		
                                    <c:if test= "${codi != null and codi != ''}">
                                        <div class="col s6 m4">
                                                    <input class="btn red waves-effect waves-light" type="submit" name="btnUsua" style="<%=clssEditBton%>" value="Eliminar">
		    					
		  				
	  					</div>
	  					<div class="col s6 m4">
							<input class="btn blue darken-4 waves-effect waves-light" type="submit" name="btnUsua" style="<%=clssEditBton%>" value="Editar">
		    					
		  					
	  					</div>
                                    </c:if>
        			</div>                                                  
        			</div>
        			
                            </div>			
			</form>
			<br>
			<br>
			<div class="divider"></div>
                        
			<!-- TABLA -->
			<div class="row">
                             <div class="col s12">
        					<h3 class="center-align black-text">Registros</h3>
                                    </div>
			   <form method="POST" action="UsuaServ" name="tabla">
					<div class="col s12">
						
							<table class="table table-striped">
								<tr>
									<th class="center-align">Cons</th>
									<th class="center-align">Usuario</th>
									<th class="center-align">Nombres</th>
                                                                        <th class="center-align">Apellidos</th>
                                                                        
								</tr>
                                        <% 
                                 
                                    for(Usuarios temp : new CtrlUsuarios().consTodo())
                                    {   
                                         
                                 %>
                           <tr>
                               <td class="center-align"><p><input type="radio" id="test<%=temp.getIdUsuario() %>" name="codiUsuaRadi" value="<%=temp.getIdUsuario() %>"/><label for="test<%=temp.getIdUsuario() %>">Selecciona</label></p></td>
                               <td class="center-align"><%= temp.getUsuario() %></td>             
                               <td class="center-align"><%= temp.getNombres() %></td>             
                               <td class="center-align"><%= temp.getApellidos() %></td>             
                           </tr>
                                <%      
                                
                                    }
                                 %>
							</table>
															
					</div>

					<div class="col s12">
						<button class="btn blue darken-4 waves-effect waves-light" type="submit" name="btnUsua" value="Consultar">
	    					<i class="material-icons right">send</i>
	  					</button>
	  				</div>					
				</form>
			</div>	
			
			
		</div>
		
	</div>
	


<script type="text/javascript">
	 $(document).ready(function() {
    $('select').material_select();
     $(".button-collapse").sideNav();
  });
      
</script>
    </body>
</html>