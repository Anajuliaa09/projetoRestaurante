/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.92
 * Generated at: 2019-12-16 13:17:43 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.Produto;
import java.util.List;
import control.ProdutoDAO;

public final class cardapio_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<!DOCTYPE html>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\r\n");
      out.write("    <title>Cardapio</title>\r\n");
      out.write("\r\n");
      out.write("    <script type=\"text/javascript\" src=\"bootstrap/js/bootstrap.js\"></script>\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"bootstrap/css/bootstrap.css\">\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"style.css\">\r\n");
      out.write("\r\n");
      out.write("    <style>\r\n");
      out.write("        #escritaNomeLanche {\r\n");
      out.write("            font-family: Verdana, Geneva, Tahoma, sans-serif;\r\n");
      out.write("            font-size: 4vh;\r\n");
      out.write("            color: white;\r\n");
      out.write("            font-weight: bold;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        #escritaDescricaoLanche {\r\n");
      out.write("            font-family: Verdana, Geneva, Tahoma, sans-serif;\r\n");
      out.write("            font-size: 2vh;\r\n");
      out.write("            color: white;\r\n");
      out.write("            font-weight: bold;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        #escritaPrecoLanche {\r\n");
      out.write("            font-family: Verdana, Geneva, Tahoma, sans-serif;\r\n");
      out.write("            font-size: 3vh;\r\n");
      out.write("            color: white;\r\n");
      out.write("            font-weight: bold;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        body {\r\n");
      out.write("            background-image:url(./img/fundo4.jpg);  \r\n");
      out.write("            background-repeat: no-repeat;\r\n");
      out.write("            background-size: cover;\r\n");
      out.write("        }\r\n");
      out.write("        \r\n");
      out.write("        #quantidade {\r\n");
      out.write("        width:90px;\r\n");
      out.write("        }\r\n");
      out.write("    \r\n");
      out.write("    \t#adicionar {\r\n");
      out.write("    \twidth:90px;\r\n");
      out.write("    \t}\r\n");
      out.write("    \t\r\n");
      out.write("    \t#cardLanche {\r\n");
      out.write("    \tbackground-color:rgba(10, 0, 0, 0.6);\r\n");
      out.write("    \t}\r\n");
      out.write("    </style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("        <nav class=\"navbar navbar-expand-lg\">\r\n");
      out.write("                <a class=\"navbar-brand\" href=\"#\" id=\"escola\" style=\"color: black; font-weight: bold;\">CARDAPIO</a>\r\n");
      out.write("                    <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarSupportedContent\" aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\r\n");
      out.write("                      <span class=\"navbar-toggler-icon\"></span>\r\n");
      out.write("                   </button>\r\n");
      out.write("          \r\n");
      out.write("            <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\r\n");
      out.write("            \r\n");
      out.write("                  <ul class=\"navbar-nav mr-auto\">\r\n");
      out.write("                  \r\n");
      out.write("                    <li class=\"nav-item active\">\r\n");
      out.write("                      <a class=\"nav-link\" href=\"finalizacaoPedido.jsp\" style=\"color: black; font-weight: bold;\">Finalizar pedido<span class=\"sr-only\">(current)</span></a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    \r\n");
      out.write("                    <li class=\"nav-item\">\r\n");
      out.write("                      <a class=\"nav-link\" href=\"inicio.jsp\" style=\"color: black; font-weight: bold;\">Inicio</a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    \r\n");
      out.write("                    </ul>\r\n");
      out.write("                  \r\n");
      out.write("                  <form class=\"form-inline my-2 my-lg-0\">\r\n");
      out.write("                        <input class=\"form-control mr-sm-2\" id=\"busca2\" type=\"search\" placeholder=\"Qual lanche deseja?\" aria-label=\"Search\" >\r\n");
      out.write("                        <button class=\"btn btn-danger my-2 my-sm-0\" type=\"submit\">Buscar</button>\r\n");
      out.write("                  </form>\r\n");
      out.write("              \r\n");
      out.write("            </div>\r\n");
      out.write("          </nav>\r\n");
      out.write("          \r\n");
      out.write("    <div class=\"container-fluid\">\r\n");
      out.write("        <div class=\"row mb-5\">\r\n");
      out.write("            <div class=\"col-1\"></div>\r\n");
      out.write("     <div class=\"col-10 cards\" id=\"cartao\">\r\n");
      out.write("               ");

               ProdutoDAO pd = new ProdutoDAO(); 
               Produto p = new Produto();
            		   
               
               for(Produto pr : pd.listaProdutos()){
            	      
               
      out.write("\r\n");
      out.write("               <div class=\"card mt-3\" id=\"cardLanche\">\r\n");
      out.write("                    <div class=\"card-header\" id=\"escritaNomeLanche\">\r\n");
      out.write("                    \r\n");
      out.write("                            ");
      out.print(pr.getNome() );
      out.write("\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"card-body\">\r\n");
      out.write("                        <div class=\"row\">\r\n");
      out.write("                            <div class=\"col-8\" id=\"escritaDescricaoLanche\">\r\n");
      out.write("                               ");
      out.print(pr.getDescricao() );
      out.write("\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"col-2 text-center\" id=\"escritaPrecoLanche\">\r\n");
      out.write("                                ");
      out.print(pr.getPreco() );
      out.write(" R$\r\n");
      out.write("                            </div>\r\n");
      out.write("                            \r\n");
      out.write("                            <div class=\"col-2 text-center\" id=\"escritaPrecoLanche\">\r\n");
      out.write("                            <form method=\"get\" action=\"Processa\"> \r\n");
      out.write("                            \t\t<input type=\"hidden\" name=\"codCapturaProd\" value=\"");
      out.print(pr.getCodigo() );
      out.write("\"> \r\n");
      out.write("                            \t\t<input class=\"form-control mb-1\" type=\"text\" name=\"quantia\" id=\"quantidade\" placeholder=\"Quantia\">\r\n");
      out.write("                            \t\t<input type=\"hidden\" name=\"acao\" value=\"cip\">\r\n");
      out.write("                                    <input class=\"btn btn-danger btn-block\" id=\"adicionar\" type=\"submit\" style=\"color: rgba(219, 140, 83, 0.9);\">\r\n");
      out.write("                           </form>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            <div class=\"col-2 text-center\">\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                ");
} 
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    \r\n");
      out.write("    \t\r\n");
      out.write("\t<script>\r\n");
      out.write("\t\tvar busca = document.querySelector(\"#busca2\");\r\n");
      out.write("\t\tbusca.addEventListener(\"keyup\",filtro);\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tfunction filtro(){\r\n");
      out.write("\t\t\tvar card = document.querySelectorAll(\".card\");\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tfor(var i=0;i<card.length;i++){\r\n");
      out.write("\t\t\t\tvar col = card[i].querySelectorAll(\".card-header\")[0];\r\n");
      out.write("\t\t\t\tvar value = col.innerHTML;\t\r\n");
      out.write("\t\t\t\tif(value.includes(busca.value)){\r\n");
      out.write("\t\t\t\t\tcard[i].style.display = \"\";\r\n");
      out.write("\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\tcard[i].style.display = \"none\";\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t</script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
