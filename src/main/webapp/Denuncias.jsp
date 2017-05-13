<%-- 
    Document   : Denuncias
    Created on : 12-may-2017, 19:20:34
    Author     : Walter
--%>

<%@page import="com.sv.udb.controlador.InstitucionCtrl"%>
<%@page import="com.sv.udb.modelo.Institucion"%>
<%@page import="com.sv.udb.controlador.AutoridadCtrl"%>
<%@page import="com.sv.udb.modelo.Autoridad"%>
<%@page import="com.sv.udb.controlador.TemasCtrl"%>
<%@page import="com.sv.udb.modelo.Temas"%>
<%@page import="com.sv.udb.modelo.Temas"%>
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
        <title>Denuncias</title>
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

        <div class="container">
            <form method="POST" class="col s8 offset-s2" action="DenunciasServ" name="demo" autocomplete="off">
                <div id="reloj" style="font-size:20px;"></div>
                <div class="row">
                    <div class="input-field col  s6 ">
                        <input type="text" name="vict" id="nomb" class="validate"/>
                        <label for="vict">Nombre de la victima</label>
                    </div>
                    <div class="input-field col  s6 ">
                        <input type="number" name="edad" id="edad" min="0" max="19" class="validate"/>
                        <label for="edad">Edad</label>
                    </div>
                    <div class="input-field col  s6 ">
                        <select id="genero" name="genero">
                            <option value="" disabled selected>Elija el genero</option>
                            <option value="1">Masculino</option>
                            <option value="2">Femenino</option>
                        </select>
                        <label>Genero</label>
                    </div>
                    <div class="input-field col  s6 ">
                        <input type="text" name="tele" id="tele" class="validate"/>
                        <label for="tele">Numero de telefono</label>
                    </div>
                    
                    <div class="input-field col  s6">
                        <select id="cmbTema" name="cmbTema" >
                            <option value="" disabled selected>Seleccione un tema</option>
                            <% for(Temas temp: new TemasCtrl().consTodo()) { %>
                            <option value="<%=temp.getIdTema()%>" ><%=temp.getTema()%></option>              
                            <% } %>     
                        </select>
                        <label>Tema de denuncia</label>
                    </div>
                        
                    <div class="input-field col  s6">
                        <select id="cmbAuto" name="cmbAuto" >
                            <option value="" disabled selected>Seleccione una autoridad</option>
                            <% for(Autoridad temp: new AutoridadCtrl().consTodo()) { %>
                            <option value="<%=temp.getCodi()%>" ><%=temp.getNomb()%></option>              
                            <% } %>     
                        </select>
                        <label>Autoridad</label>
                    </div>
                    <div class="input-field col  s6">
                        <select id="cmbInst" name="cmbInst" >
                            <option value="" disabled selected>Seleccione una autoridad</option>
                            <% for(Institucion temp: new InstitucionCtrl().consTodo()) { %>
                            <option value="<%=temp.getCodigo()%>" ><%=temp.getNomb()%></option>              
                            <% } %>     
                        </select>
                        <label>Institucion denunciada</label>
                    </div>
                    <div class="input-field col s12">
                        <input type="text" id="autocomplete-input" class="autocomplete">
                        <label for="autocomplete-input">Institucion educativa</label>
                    </div>
                    <div class="input-field col  s6 ">
                        <select id="cmbAccion" name="cmbAccion">
                            <option value="" disabled selected>Escoja una opcion </option>
                            <option value="1">Archivar</option>
                            <option value="2">Tomar contacto</option>
                            <option value="3">Remitir</option>
                        </select>
                        <label>Genero</label>
                    </div>
                    <input type="submit" class="btn blue-grey col s3 offset-s2" name="btnEqui" value="Guardar"/> 
                </div>
            </form>
        </div>
        
        <script type="text/javascript">
            function startTime(){
            today=new Date();
            d=today.getDate();
            me=today.getMonth()+1;
            y=today.getFullYear();
            h=today.getHours();
            m=today.getMinutes();
            s=today.getSeconds();
            m=checkTime(m);
            s=checkTime(s);
            document.getElementById('reloj').innerHTML=d+"/"+me+"/"+y+" "+h+":"+m+":"+s;
            t=setTimeout('startTime()',500);}
            function checkTime(i)
            {if (i<10) {i="0" + i;}return i;}
            window.onload=function(){
                startTime();};
        </script>
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
    </body>
    
</html>
