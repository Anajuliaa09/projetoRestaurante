<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de produto</title>
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
            background-image:url(./img/plano2.jpg);  
            background-repeat: no-repeat;
            background-size: cover;
            
        }
               
		input[type=text]:hover, textarea:hover{ 
	      	border:1px solid rgba(219, 140, 83, 0.9);
		}
				
		#escritaCadProd {
			font-family: Verdana, Geneva, Tahoma, sans-serif;
            font-size: 4vh;
            color: white;
		}
		.c{
			box-shadow:3px 2px 8px 2px rgb(59,57, 57);
		}
		
    </style>
</head>

<body>
        <nav class="navbar navbar-expand-lg">
                <a class="navbar-brand" href="adm.jsp" id="escola" style="color: white;">CONTROLE</a>
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                      <span class="navbar-toggler-icon"></span>
                   </button>
          
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
            
                  <ul class="navbar-nav mr-auto">
                    
                    <li class="nav-item">
                      <a class="nav-link" href="cadastraUser.jsp" style="color: white;">Cadastrar User</a>
                    </li>
                    
                    <li class="nav-item">
                      <a class="nav-link" href="controleUser.jsp" style="color: white;">Controle de Usuario</a>
                    </li>
                    
                    <li class="nav-item">
                      <a class="nav-link" href="controleProduto.jsp" style="color: white;">Controle de produtos</a>
                    </li>
                    
                  </ul>
            </div>
          </nav>

	<div class="container mt-5">           
        <div class="row ">
   			<div class="col-8">
   			
   			</div>
   			<div class="col-lg-4 col-sm-12">
   				<div class="card c">
   					<div class="card-header">
   						<h5>Cadastrar produto</h1>
   					</div>
   					<div class="card-body">
   						<form method="get" action="Processa">
   						
   							<div class="form-group">
   								<label>Tipo</label>
   								<select name="tipoProd" class="form-control">
   									<option value="selecione" disabled selected >Qual o tipo?</option>
   									<option value="lanche">Lanche</option>
   									<option value="porcao">Por��o</option>
   									<option value="bebida">Bebida</option>
   								</select>
   							</div>
   							
   							<div class="form-group">
   								<label>Nome</label>
   								<input type="text" name="nomeProd" class="form-control">
   							</div>
   							<div class="form-group">
   								<label>Descri��o</label>
   								<input type="text" name="descricaoProd" class="form-control">
   							</div>
   					
   							<div class="form-group">
   								<label>Pre�o</label>
   								<input type="text" name="precoProd" class="form-control">
   							</div>
   							<input type="hidden" name="acao" value="cadastrarProduto">
   							<input type="submit" class="btn btn-danger btn-block">
   						</form>
   					</div>
   				</div>
   			</div>
        </div>
    </div>
  
	

</body>
</html>