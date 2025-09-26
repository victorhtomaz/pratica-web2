package br.pratica.servlets.parametrosEx;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class InitParametersTestServlet
 */
@WebServlet(urlPatterns = "/init-parameters-test-other", initParams = {@WebInitParam(name = "raca", value = "vira lata")})
public class InitParametersTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String donoParameter = "dono";
	private final String animalParameter = "animal";
	private final String racaParameter = "raca";
       
    public InitParametersTestServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		ServletConfig config = getServletConfig();
		
		String dono = config.getInitParameter(donoParameter);
		String animal = config.getInitParameter(animalParameter);
		String raca = config.getInitParameter(racaParameter);
		
		out.println("<p>Dono: " + dono + "</p>");
		out.println("<p>Animal: " + animal + "</p>");
		out.println("<p>Raça: " + raca + "</p>");
	}
}
