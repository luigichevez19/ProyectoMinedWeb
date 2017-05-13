<%-- 
    Document   : Autoridades
    Created on : 05-12-2017, 11:07:36 PM
    Author     : Luis
--%>

<%@page import="com.sv.udb.modelo.Autoridad"%>
<%@page import="com.sv.udb.controlador.AutoridadCtrl"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
              <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
           <!-- Import Google Icon Font -->
    <link type='text/css' rel='stylesheet' href='css/icons.css'/>
  
    <!-- Import materialize.css -->
    <link type='text/css' rel='stylesheet' href='webjars/materialize/0.98.0/dist/css/materialize.min.css'  media='screen,projection'/>
    <!-- Let browser know website is optimized for mobile -->
    <meta name='viewport' content='width=device-width, initial-scale=1.0'/>
     <script type="text/javascript" src="webjars/jquery/3.2.1/dist/jquery.min.js"></script>
    <script type='text/javascript' src='webjars/materialize/0.98.0/dist/js/jquery.min.js'></script>
    <script type='text/javascript' src='webjars/materialize/0.98.0/dist/js/materialize.min.js'></script>
        <title>Mined</title>
    </head>
    <body>
                  <!-- Dropdown Structure -->
            <ul id='dropdown' class='dropdown-content'>
              <li><a href='InstitucionesServ'>Instituciones</a></li>
              <li><a href='AutoridadesServ'>Autoridades</a></li>
              <li><a href="UsuarioServ">Usuarios</a></li>
            </ul>
                <!-- Dropdown Structure -->
            <ul id='dropdown2' class='dropdown-content'>
              <li><a href='DenunciasServ'>Denuncias</a></li>
              <li><a href='TemaDenuServ'>Tema Denuncia</a></li>
            </ul>
                   <!-- Dropdown Structure -->
            <ul id='dropdown3' class='dropdown-content'>
              <li><a href='DepaServ'>Departamentos</a></li>
              <li><a href='MuniServ'>Municipio</a></li>
            </ul>
                         <nav>   
                                <div class='nav-wrapper green'>

                                <ul id='nav-mobile' class='right hide-on-med-and-down'>
                                        <li><a class='dropdown-button' href='#!' data-activates='dropdown'>Administrativo<i class='material-icons right'>arrow_drop_down</i></a></li>
                                        <li><a class='dropdown-button' href='#!' data-activates='dropdown2'>Denuncia<i class='material-icons right'>arrow_drop_down</i></a></li>
                                         <li><a class='dropdown-button' href='#!' data-activates='dropdown3'>Geografia<i class='material-icons right'>arrow_drop_down</i></a></li>
                                </ul>
                                </div>
			  </nav>

                  <h1 class="col s4 offset-s4">${mensAlert}</h1>
                  <div class="row">
                  <form method="POST" action="AutoridadesServ" name="demo" class="col  s8 offset-s2">
                    <div class="row">
                        <input type="text" name="codi" id="codi" value= "${codi}" hidden="hidden"/><br>
                        <div class="input-field col  s6 ">
                        <input type="text" name="nomb" id="nomb" value="${nomb}"/>
                        <label for="nomb">Nombre Institucion</label>
                          </div>
                        <div class="input-field col  s6 ">
                         <input type="text" name="correo" id="dire" value="${correo}"/>
                          <label for="correo">Correo</label>
                           </div>
                     </div>
                        <c:if test="${codi==null}">
                       <input type="submit" class="btn blue-grey col s3 offset-s2" name="btnAuto" value="Guardar"/>  
                        </c:if>
                       <c:if test="${codi != '' and codi!=null}">
                       <input type="submit" class="btn blue-grey col s3 offset-s1" name="btnAuto" value="Actualizar"/>  <br>
                       </c:if>
                       </form>
                         </div>
                        <div class="row">
                       <h1  class="col s7 offset-s3">Autoridades  Registradas</h1>
                  <form method="POST" action="AutoridadesServ" name="Tabla"  class="col s8 offset-s2">
                  <table  class="striped ">  
                          <tr>
                                  <th>Cons</th>
                                  <th>Nombre</th>
                                  <th>Correo</th>
                                 <th>Estado</th>
                          </tr>
                          <%
                         for(Autoridad temp: new AutoridadCtrl().consTodo())
                          { 
                          %>
                          <tr>
                              <td> 
             <input name="codi_auto" type="radio" id="<%=temp.getCodi()%>" value="<%=temp.getCodi()%>" />
                <label for="<%=temp.getCodi()%>"></label></td>
                              <td><%=temp.getNomb()%></td>
                              <td><%=temp.getCorreo()%></td>
                              <td><%=temp.getEstadoS()%></td>
                          </tr>
                          <%

                           }
                          %>
                  </table>
                  <input type="submit" class="btn blue-grey col s3 offset-s2" name="btnAuto" value="Consultar"/>  
                  <input type="submit" class="btn blue-grey col s3 offset-s1" name="btnAuto" value="Modificar Estado"/> 
                
              </form>
                  </div>
    </body>
     <script type='text/javascript'> 
	
	    $(document).ready(function()
	    { 
		    	$('select').material_select();
	    		Materialize.updateTextFields();
				$('.dropdown-button').dropdown(
				{
					hover: true, // Activate on hover
		  		 	 belowOrigin: true
				});
		 });
	</script>
</html>
