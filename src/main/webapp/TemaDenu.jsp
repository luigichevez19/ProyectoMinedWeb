<%-- 
    Document   : TemaDenu
    Created on : 13-may-2017, 6:27:35
    Author     : Walter
--%>

<%@page import="com.sv.udb.controlador.TemasCtrl"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type='text/css' rel='stylesheet' href='css/icons.css'/>
        <link type='text/css' rel='stylesheet' href='webjars/materialize/0.98.0/dist/css/materialize.min.css'/>
        <meta name='viewport' content='width=device-width, initial-scale=1.0'/>
        <script type="text/javascript" src="webjars/jquery/3.2.1/dist/jquery.min.js"></script>
        <script type='text/javascript' src='webjars/materialize/0.98.0/dist/js/jquery.min.js'></script>
        <script type='text/javascript' src='webjars/materialize/0.98.0/dist/js/materialize.min.js'></script>
        <title>Tema de denuncia</title>
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
        <form method="POST" class="col  s8 offset-s2" action="TemaDenuServ" name="demo" >
            <div class="row">
                <input type="text" name="codi" id="codi" value= "${codi}" hidden="hidden"/><br>
                <div class="input-field col  s6 ">
                    <input type="text" name="tema" id="tema" value="${tema}"/>
                    <label for="tema">Tema de denuncia</label>
                </div>  
                <c:if test="${codi==null}">
                    <input type="submit" class="btn blue-grey col s3 offset-s2" name="btnTema" value="Guardar"/>  
                </c:if>
                <c:if test="${codi != '' and codi!=null}">
                    <input type="submit" class="btn blue-grey col s3 offset-s1" name="btnTema" value="Actualizar"/>  <br>
                </c:if>
            </div>
        </form>
            <h1  class="col s7 offset-s3">Temas registrados</h1>
        <form method="POST" action="TemaDenuServ" name="Tabla"  class="col s8 offset-s2">
            <table  class="striped">  
                <tr>
                        <th>Cons</th>
                        <th>Tema</th>
                </tr>
                <%
                request.setAttribute("listTemaJSTL",new TemasCtrl().consTodo());
                        %>
                <c:forEach items="${listTemaJSTL}" var="temp">
                    <tr>
                        <td> 
                            <input name="codiTemaRadi" type="radio" id="${temp.getIdTema()}" value="${temp.getIdTema()}" />
                            <label for="${temp.getIdTema()}"></label>
                        </td>
                        <td>${temp.getTema()}</td>
                    </tr>                    
                </c:forEach>              
            </table> 
            <input type="submit" class="btn blue-grey col s3 offset-s2" name="btnTema" value="Consultar"/>  
            <c:if test="${codi != '' and codi!=null}">
                <input type="submit" class="btn blue-grey col s3 offset-s1" name="btnTema" value="Eliminar"/>  
            </c:if>
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
