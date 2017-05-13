<%-- 
    Document   : Municipios
    Created on : 12-may-2017, 23:30:43
    Author     : oscar
--%>

<%@page import="com.sv.udb.controlador.DepartamentosCtrl"%>
<%@page import="com.sv.udb.modelo.Departamentos"%>
<%@page import="com.sv.udb.controlador.CtrlMunicipios"%>
<%@page import="com.sv.udb.modelo.Municipios"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
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
            int id;
            String value;
            String clssEditBton;
            if(accion == "Editar")
            {
                 
                 value = "Limpiar" ;
            }
            else
            { 
                
                 value="Guardar";
            }
        %>


<div class="container">
	<div class="row">
            <h1>${mensAlert}</h1>		
                    <form method="POST" action="MuniServ" name="Demo" >
                        
                         <input  type="hidden" name="codi" id="codi" value="${codi}">
        
			<div class="col s12">	
				<div class="card-panel white z-depth-5">
        			<div class="row">
        				<div class="col s12">
        					<h3 class="center-align black-text">Municipios</h3>
        				</div>
        			</div>
        			<div class="row">
  					<div class="input-field col s6">
					     <input  name="nombre" id="first_name" type="text" class="validate" value="${nombre}">
					     <label for="first_name" >Nombre</label>
                                        </div>
                                             <div class="input-field col s6">
                                              <select class="form-control" name="codDepa">
                            <%
                                Integer codEqui =(Integer)request.getAttribute("codDepa");
                                String selec;
                                  if(codEqui == null)
                                  {
                                      codEqui = -1;
                                  }

                                  //para seleccionar el equipo al que pertenece
                                for(Departamentos temp : new DepartamentosCtrl().consTodo())
                                {
                                    id = temp.getIdDepa();
                                    if(id == codEqui)
                                    {
                                        selec = "selected='selected'";
                                    }
                                    else
                                    {
                                        selec = "";
                                    }

                            %>
                            <option value="<%=temp.getIdDepa()%>" <%=selec%> ><%= temp.getNombreDepa() %></option>
                            <%
                                }

                            %>
                        </select>
                       </div>

					        
    				</div>
                                  
                                <div class="divider"></div>
        			<br>
        			<div class="row">
                                    <c:if test="${codi == null}">
                                        <div class="col s6 m4">
							<input class="btn waves-effect blue darken-4 waves-light" type="submit" name="btnMuni" value="<%=value%>">		    		
	  					</div>
                                    </c:if>        		
                                    <c:if test= "${codi != null and codi != ''}">
                                        <div class="col s6 m4">
                                                    <input class="btn red waves-effect waves-light" type="submit" name="btnMuni"  value="Eliminar">
		    					
		  				
	  					</div>
	  					<div class="col s6 m4">
							<input class="btn blue darken-4 waves-effect waves-light" type="submit" name="btnMuni"  value="Editar">
		    					
		  					
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
			   <form method="POST" action="DepaServ" name="tabla">
					<div class="col s12">
						
							<table class="table table-striped">
								<tr>
									<th class="center-align">Cons</th>
									<th class="center-align">Nombre</th>
                                                                        <th class="center-align">Departamento</th>
									
								</tr>
                                        <% 
                                 
                                    for(Municipios temp : new CtrlMunicipios().consTodo())
                                    {   
                                         Departamentos objeDepa = new DepartamentosCtrl().consUno(temp.getIdDept());
                                 %>
                           <tr>
                               <td class="center-align"><p><input type="radio" id="test<%=temp.getIdMuni()%>" name="codiMuniRadi" value="<%=temp.getIdMuni()%>"/><label for="test<%=temp.getIdMuni()%>">Selecciona</label></p></td>
                               <td class="center-align"><%= temp.getMuni() %></td>
                               <td class="center-align"><%= objeDepa.getNombreDepa() %></td>
                           </tr>
                                <%      
                                
                                    }
                                 %>
							</table>
															
					</div>

					<div class="col s12">
						<button class="btn blue darken-4 waves-effect waves-light" type="submit" name="btnMuni" value="Consultar">
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
    </body>
</html>
