package br.pratica;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * Servlet implementation class FrutaServlet
 */
@WebServlet("/fruta-fav")
public class FrutaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrutaServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		Enumeration<String> parameters = request.getParameterNames();
		
		String nomeParameter = parameters.nextElement();
		String frutaParameter = "";
		if (parameters.hasMoreElements()) {
			frutaParameter = parameters.nextElement();
		}
		
		String nome = request.getParameter(nomeParameter);
		
		out.println("<h1>" + nome + "</h1>");
		
		if (!frutaParameter.isEmpty()) {
			String[] frutas = request.getParameterValues(frutaParameter);
			
			for (String fruta : frutas) {
				out.println("<h3>" + fruta + "</h3>");
			}
		}
		
		out.println("<p>" + nomeParameter + "</p>");
		out.println("<p>" + frutaParameter + "</p>");
	}
}
