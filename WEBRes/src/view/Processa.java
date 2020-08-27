package view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import control.ItemPedidoDAO;
import control.PedidoDAO;
import control.ProdutoDAO;
import control.UserDAO;
import model.ItemPedido;
import model.Pedido;
import model.Produto;
import model.User;

@WebServlet("/Processa")

public class Processa extends HttpServlet{
	
	private Produto p;
	private ProdutoDAO pd;
	
	private Pedido pe;
	private PedidoDAO ped;
	
	private ItemPedido ip;
	private ItemPedidoDAO ipd;
	
	private User u;
	private UserDAO ud;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String acao = req.getParameter("acao") != null ? req.getParameter("acao") : "";
		PrintWriter out = resp.getWriter();
		acao = req.getParameter("acao");
		
		if(acao.contentEquals("cadastrarProduto")) {
			p = new Produto();
			pd = new ProdutoDAO();
			
			String tipoProd = req.getParameter("tipoProd");
			String nomeProd = req.getParameter("nomeProd");
			String descricaoProd = req.getParameter("descricaoProd");
			double precoProd = Double.parseDouble(req.getParameter("precoProd"));
			
			p.setTipo(tipoProd);
			p.setNome(nomeProd);
			p.setDescricao(descricaoProd);
			p.setPreco(precoProd);
			
			try {
				if(pd.cadastraProduto(p)){
					resp.sendRedirect("controleProduto.jsp");
				}else{
					out.print("Erro ao cadastrar");
				}
			} catch (SQLException e) {
				out.print("Erro" + e);
			}
		}
		
		
		
		if(acao.contentEquals("editarProduto")) {
			p = new Produto();
			pd = new ProdutoDAO();
			
			String nomeEdit = req.getParameter("nomeEdit").toString();
			String descricaoEdit = req.getParameter("descricaoEdit").toString();
			String precoEdit = req.getParameter("precoEdit");
			String codEdit = req.getParameter("codEditCapturado");
			
			p.setNome(nomeEdit);
			p.setDescricao(descricaoEdit);
			p.setPreco(Double.parseDouble(precoEdit));
			
			boolean editado = pd.editar(p, Integer.parseInt(codEdit));
			
			if(editado == true) {
				resp.sendRedirect("controleProduto.jsp");
			}else {
				
			}
			
		}
		
		
		
		
		if(acao.equals("excluirProd")) {
			pd = new ProdutoDAO();
			String excluircod = req.getParameter("codExcluir");
			pd.excluir(Integer.parseInt(excluircod));
			resp.sendRedirect("controleProduto.jsp");
		}
		
		
		
		if(acao.contentEquals("aquiPEDIDO")) {
			pe = new Pedido();
			ped = new PedidoDAO();
			
			String comanda = req.getParameter("comanda").toString();
			
			pe.setComanda(comanda);
			try {
				int pedido = ped.cadastraPedido(pe);
				if(pedido != 0) {
					resp.sendRedirect("cardapio.jsp");
				}else {
					out.print("Erro ao cadastrar");
				}
				HttpSession hs = req.getSession();
				hs.setAttribute("nPedido",pedido);
			} catch (SQLException e1) {
				out.print("Erro" + e1);
			}
		}
		
		if(acao.equals("cip")) {
			ip = new ItemPedido();
			ipd = new ItemPedidoDAO();
			
			int codCapturaProd = Integer.parseInt(req.getParameter("codCapturaProd"));
			int quantia = Integer.parseInt(req.getParameter("quantia"));
			HttpSession hs = req.getSession();
			ip.setPedido(Integer.parseInt(hs.getAttribute("nPedido").toString()));
			ip.setCodProd(codCapturaProd);
			ip.setQuantidade(quantia);
			//ip.setTotal(0);
			
			try {
				if(ipd.cadastraItemPedido(ip)) {
					System.out.println("CADASTROU");
					resp.sendRedirect("cardapio.jsp");
				}else { 
					resp.sendRedirect("cardapio.jsp");
					System.out.println("erro ao cadastrar item pedido");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	
		if(acao.equals("excluirIP")) {
			ipd = new ItemPedidoDAO();
			String excluirItem = req.getParameter("idIP");
			ipd.excluir(Integer.parseInt(excluirItem));
			resp.sendRedirect("terminoPedido.jsp");
		}
		
		if(acao.equals("logout")){
			HttpSession	hs = req.getSession();
			hs.invalidate();
			resp.sendRedirect("inicio.jsp");
		}
		
		
		if(acao.equals("cadastraUsuario")) {
			u = new User();
			ud = new UserDAO();
			
			String user = req.getParameter("cadastraUser");
			String senha = req.getParameter("cadastraSenha");
			
			u.setUser(user);
			u.setSenha(senha);
			
			try {
				if(ud.cadastraUsuario(u)) {
					resp.sendRedirect("controleUser.jsp");
				}else {
					out.print("Erro");
				}
			} catch (SQLException e) {
				out.print("Erro" + e);
			}
		}

		if(acao.equals("editarUsuario")) {
			u = new User();
			ud = new UserDAO();
			
			String user = req.getParameter("userEdit");
			String senha = req.getParameter("senhaEdit"); 
			String codUser = req.getParameter("codUser");
			
			u.setUser(user);
			u.setSenha(senha);
			
			boolean editaUser = ud.editar(u, Integer.parseInt(codUser));
			
			if(editaUser == true) {
				resp.sendRedirect("controleUser.jsp");
			}else {
				out.print("Erro ao editar");
			}
			
		}
		
		if(acao.equals("excluirUser")) {
			ud = new UserDAO();
			String userExcluir = req.getParameter("codUser");
			ud.excluir(Integer.parseInt(userExcluir));
			resp.sendRedirect("controleUser.jsp");
		}
		
	}
}

