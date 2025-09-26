package br.pratica.servlets;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import br.pratica.models.Cliente;
import br.pratica.models.Fruta;

/**
 * Servlet implementation class FrutaServlet
 */
@WebServlet("/fruta-fav")
public class FrutaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private final List<Fruta> frutas;
    private final String nomeParameter = "nome";
    private final String frutaParameter = "fruta";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrutaServlet() {
        super();
        
        frutas = new ArrayList<Fruta>(
        		Arrays.asList(
        				new Fruta(1, "Banana"),
        				new Fruta(2, "Laranja"),
        				new Fruta(3, "Tangerina"),
        				new Fruta(4, "Abacate"),
        				new Fruta(5, "Manga"),
        				new Fruta(6, "Uva Verde")
        				)
        		);
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		ServletContext context = getServletContext();
		
		List<Cliente> clientes = (List<Cliente>) context.getAttribute(ContextAttribute.CLIENTES_ATTRIBUTE);
		if (clientes == null)
			clientes = new ArrayList<Cliente>();
		
		String nome = request.getParameter(nomeParameter);
		String[] idsFrutasStr = request.getParameterValues(frutaParameter);
		if (nome == null) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Parametros incorretos");
			return;
		}
		
		Cliente cliente = new Cliente(nome);
		
		if (idsFrutasStr != null) {
			List<Integer> idsFrutas = Arrays.stream(idsFrutasStr)
				    .map((String id) -> Integer.parseInt(id))
				    .collect(Collectors.toList());
			
			for (Fruta fruta : frutas) {
				if (idsFrutas.contains(fruta.getId())){
					cliente.adicionaFruta(fruta);
				}
			}
		}	

		clientes.add(cliente);
		context.setAttribute(ContextAttribute.CLIENTES_ATTRIBUTE, clientes);
		
		out.println("<h1>Lista de clientes</h1>");
		out.println("<ul>");
		for (Cliente cl : clientes) {
			out.println("<li>" + cl.getNome());
			out.println("<ul>");
			for (Fruta fruta : cl.getFrutasFavoritas()) {
				out.println("<li>" + fruta.getNome() + "</li>");
			}
			out.println("</ul>");
			out.println("</li>");
		}
		out.println("</ul>");
		out.println("<a href=\"index.html\">Voltar para página principal</a>");
	}
}
