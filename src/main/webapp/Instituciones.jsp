<%-- 
    Document   : Instituciones
    Created on : 05-12-2017, 07:43:05 PM
    Author     : Luis
--%>

<%@page import="com.sv.udb.controlador.CtrlMunicipios"%>
<%@page import="com.sv.udb.modelo.Municipios"%>
<%@page import="com.sv.udb.controlador.InstitucionCtrl"%>
<%@page import="com.sv.udb.modelo.Institucion"%>
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
                  <form method="POST" action="InstitucionesServ" name="demo" class="col  s8 offset-s2">
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
                      <div class="input-field col  s6 ">
                       <input type="text" name="dire" id="dire" value="${dire}"/>
                        <label for="dire">Dirección</label>
                     </div>
                        <div class="input-field col  s6">
                        <select id="cmbMuni" name="cmbMuni" >
                   <option value="" disabled selected>Seleccione un Municipio</option>
                    <%
                             for(Municipios temp: new CtrlMunicipios().combox())

                             { 
                                 int id=-1;
                                if (request.getAttribute("id_muni") != null)
                                {                       
                                     id =(Integer)request.getAttribute("id_muni");
                                }                      

                                 if(temp.getIdMuni()== id)
                                 {
                              %>
                                     <option value="<%=temp.getIdMuni()%>" SELECTED><%=temp.getDepa()%>/<%=temp.getMuni()%></option>;


                             <%}
                                 else
                                 {
                              %>
                                      <option value="<%=temp.getIdMuni()%>"><%=temp.getDepa()%>/<%=temp.getMuni()%></option>;


                             <%}
                             }
                             %>

                            </select>
                               <label>Departamento/Municipio</label>
                          </div>
                         </div>
                            <c:if test="${codi==null}">   
                       <input type="submit" class="btn blue-grey col s3 offset-s2" name="btnInsti" value="Guardar"/>  
                            </c:if>
                       <c:if test="${codi != '' and codi!=null}">
                       <input type="submit" class="btn blue-grey col s3 offset-s1" name="btnInsti" value="Actualizar"/>  <br>
                       </c:if>
                       </form>
                         </div>
                        <div class="row">
                       <h1  class="col s7 offset-s3">Instituciones  Registradas</h1>
                  <form method="POST" action="InstitucionesServ" name="Tabla"  class="col s8 offset-s2">
                  <table  class="striped ">  
                          <tr>
                                  <th>Cons</th>
                                  <th>Nombre</th>
                                  <th>Correo</th>
                                  <th>Dirección</th>
                                  <th>Ubicacion</th>
                                  <th>Estado</th>
                          </tr>
                          <%
                         for(Institucion temp: new InstitucionCtrl().consTodo())
                          { 
                          %>
                          <tr>
                              <td> 
             <input name="codi_muni" type="radio" id="<%=temp.getCodigo()%>" value="<%=temp.getCodigo()%>" />
                <label for="<%=temp.getCodigo()%>"></label></td>
                              <td><%=temp.getNomb()%></td>
                              <td><%=temp.getCorreo()%></td>
                              <td><%=temp.getDireccion()%></td>
                              <td><%=temp.getDepartamentoN()%>/<%=temp.getMunicipioN()%></td>
                              <td><%=temp.getEstadoS()%></td>
                          </tr>
                          <%

                           }
                          %>
                  </table>
                  <input type="submit" class="btn blue-grey col s3 offset-s2" name="btnInsti" value="Consultar"/> 
                  <input type="submit" class="btn blue-grey col s3 offset-s1" name="btnInsti" value="Modificar Estado"/>  
                   
              </form>
                  </div>
    </body>
      <script>
        
               $(document).ready(function() {
                   
    $('select').material_select();
  });
          </script>
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
