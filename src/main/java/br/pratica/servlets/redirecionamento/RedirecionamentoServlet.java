package br.pratica.servlets.redirecionamento;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class RedirecionamentoServlet
 */
@WebServlet("/redireciona")
public class RedirecionamentoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RedirecionamentoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String url = "https://portal.ufrrj.br/";
		String url = "destino";
		redirecionaComSendRedirect(response, url);
		
		//redirecionaPeloCabeçalho(response, url);
	}
	
	private void redirecionaComSendRedirect(HttpServletResponse response, String url) throws IOException {
		url = response.encodeRedirectURL(url);
		response.sendRedirect(url);
	}
	
	private void redirecionaPeloCabeçalho(HttpServletResponse response, String url) {
		url = response.encodeRedirectURL(url);
		response.setStatus(HttpServletResponse.SC_FOUND);
		response.setHeader("Location", url);
	}
}
