<%@page import="control.UserDAO"%>
<%@page import="model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Controle de usuario</title>

	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
	<script type="text/javascript" src="bootstrap/js/bootstrap.js"></script>
	<link rel="stylesheet" href="bootstrap/css/bootstrap.css">
	<link rel="stylesheet" href="style.css">
	
	<style>
		body,html{
			height:100%;
		}
		
        body {
            background-image:url(./img/fundoLogin.jpg);  
            background-repeat: no-repeat;
            background-size: cover;
            
        }
        
     </style>
     
</head>
<body>

     <section class="section-2 container-fluid p-0">
           
<br><br>

            <div class="purchase text-center">
            
            <div class="row">
            <%
            User u = new User();
            UserDAO ud = new UserDAO();
            
            for(User uu : ud.listaUsuarios()) {
            	
            
            %>
            <div class="cards col-md-2 text-center">
                <div class="d-flex flex-row justify-content-center flex-wrap">
                    <div class="card">
                        <div class="card-body">
                            <div class="title">
                                <h5 class="card-title"><%=uu.getUser() %></h5>
                            </div>
                            <p class="card-text">
                                <img src="img/iconeLogin.png" width="45px" height="45px" alt="">
                            </p>
                                
                              <form method="get" action="editarUser.jsp">
                                <input type="hidden" name="codUser" value="<%=uu.getCodigoUser()%>">
                               	<button class="btn px-5 py-2 mb-5" type="submit" style="font-weight:bold;">Editar</button>
                              </form>
                              
                               <form method="get" action="Processa">
                               <input type="hidden" name="acao" value="excluirUser">
                                <input type="hidden" name="codUser" value="<%=uu.getCodigoUser()%>">
                               	<button class="btn px-2 py-2 mb-2" type="submit" style="font-weight:bold;">Excluir</button>
                              </form>
                               
                        </div>
                    </div>
                   
                </div>
            </div>
            <%} %>
        </div>
        </div>
       
        </section>
</body>
</html>