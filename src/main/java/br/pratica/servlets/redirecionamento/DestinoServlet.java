package br.pratica.servlets.redirecionamento;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class DestinoServlet
 */
@WebServlet("/destino")
public class DestinoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public DestinoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		out.println("<h1>Você foi redirecionado</h1>");
	}


}
