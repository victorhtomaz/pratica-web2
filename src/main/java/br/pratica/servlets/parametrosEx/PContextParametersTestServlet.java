package br.pratica.servlets.parametrosEx;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class ContextParametersTestServlet
 */
@WebServlet("/context-parameters-test-1")
public class PContextParametersTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

       
    public PContextParametersTestServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		ServletContext context = getServletContext();
		
		String marca = context.getInitParameter(SharedParameter.MARCA);
		String modelo = context.getInitParameter(SharedParameter.MODELO);
		
		out.println("<h1>Servlet 1</h1>");
		out.println("<p>Marca: " + marca + "</p>");
		out.println("<p>Modelo: " + modelo + "</p>");
	}

}
