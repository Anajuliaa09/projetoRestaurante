<%@page import="control.ItemPedidoDAO"%>
<%@page import="model.ItemPedido"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de pedido</title>

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
            background-image:url(./img/finalizar.jpg);  
            background-repeat: no-repeat;
            background-size: cover;
            
        }
        
        #tt {
        float: left;
        color: white;
        font-weight: bold;
        }
        
        
     </style>
     
     
</head>
<body>
     <br><br><br><br>
     <center>
     <a href="cardapio.jsp"><button class="btn btn-lg btn-dark">Adicionar mais Itens</button></a>
     </center>
     
    <div class="container mt-5">
    	<div class="row mt-5 justify-content-center">
    		<div class="col-12 col-lg-6 col-md-6 table-responsive ">
    			<table class="table table-dark">
    				<thead>
    					<tr>
    						<th>ID</th>
    						<th>Pedido</th>
    						<th>Produto</th>
    						<th>Valor</th>
    						<th>Quantidade</th>
    						<th>Total</th>
    						<th>Excluir</th>
    					</tr>
    				</thead>
    				<tbody>
    				
    				<%
    				int pedido = 0;
    				if(session.getAttribute("nPedido") != null){
    					pedido = Integer.parseInt(session.getAttribute("nPedido")+"");
    				}
    				
    					ItemPedido ip = new ItemPedido();
    					ItemPedidoDAO ipd = new ItemPedidoDAO();
    					
    					for(ItemPedido i : ipd.listaPedidos(pedido)) {
    						
    					
    				%>
    					<tr>
    					
    					<% 
    					double precoUni = 0;
    					precoUni = ipd.precoProd(i.getCodProd());
    					%>
    						<td><%=i.getId_iPedido() %></td>
    						<td><%=i.getPedido() %></td>
    						<td><%=ipd.nomeProd(i.getCodProd())%></td>
    						<td><%=ipd.precoProd(i.getCodProd()) %></td>
    						<td><%=i.getQuantidade() %></td>
    						<td class="valor-calculado"><%=i.getConta(precoUni) %></td>
    						
    			
    						
    						<td>
	    						<form method="get" action="Processa">
	                                <input type="hidden" name="acao" value="excluirIP" /> 
	                                <input type="hidden" name="idIP" value="<%=i.getId_iPedido() %>" />
	                                <input type="submit" value="*" class="btn btn-danger"  />
                            	</form>	
    						</td>
    					</tr>
    					<%} %>
    				</tbody>
    			</table>
    			
    			    <form class="form-inline my-2 my-lg-0" id="p">
                        <input class="form-control mr-sm-2" id="qtdtotal" disabled>
                        <input class="form-control mr-sm-2" id="recebe">
                        <button class="btn btn-danger my-2 my-sm-0" onclick="troco()">Calcular</button>
                  </form>
                  <br>
                  <form class="form-inline my-2 my-lg-0" method="get" action="Processa">
                  	 <input class="form-control mr-sm-2" id="resultado" disabled>
                  	 <input type="hidden" name="acao" value="logout">
                  	 <button class="btn btn-danger my-2 my-sm-0" type="submit">Finalizar</button>
                  </form>
                  
                  
    		</div>
    	</div>
    </div>
     
<script>
	const p = document.querySelector("#p");
	
	p.addEventListener("click",(e)=>{
	    e.preventDefault();
	});

	var els = document.getElementsByClassName("valor-calculado");
	var valorcalculado = 0;
	[].forEach.call(els, function (el) 
	{
	  valorcalculado += parseInt(el.innerHTML);
	});
	
	document.getElementById("qtdtotal").value = "Valor total: " + valorcalculado + "R$";
	
	function troco() {
		var recebe = document.getElementById("recebe").value;
		var rTroco = 0;
		var rTroco = parseInt(recebe) - valorcalculado;
		document.getElementById("resultado").value = "Troco:" + rTroco + "R$";
	}	
</script>


</body>
</html>