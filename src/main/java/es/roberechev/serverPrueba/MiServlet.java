package es.roberechev.serverPrueba;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Servlet implementation class miServletP
 */
public class MiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Pokemon p;
	private Pokemon p2;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MiServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		PrintWriter printer = response.getWriter();
//		printer.println("<html><body>");
//		printer.println("<h1>Prueba</h1>");
//		printer.println("</body></html>");
		//String pag = "/es/roberechev/serverPrueba/index.jsp";
		
		ArrayList<Pokemon> pokemones = Scraping.scraping();
		for (Pokemon pokemon : pokemones) {
			System.out.println(pokemon);
		}
		Combate.generarMapa(pokemones);
		//request.setAttribute("pokemones", pokemones);
		String pag = "index.jsp";
		System.out.println(pag);
		String nombre = "";
//		Fichero f = new Fichero();
//		f.crearFicheroJson(pokemones);
		
		
		try {
			String accion = request.getParameter("accion");
			System.out.println(accion);

			if (accion.startsWith("combate")) {
				pag = "combate.jsp";
				String[] chpimg = accion.split(" ");
				nombre = chpimg[1];
				p = Combate.getPokemon(nombre);
				p2 = pokemones.get((int) Math.round(Math.random() * (800 + 1)));
			} else if (accion.equalsIgnoreCase("ATACAR")) {
				Combate.combate(p, p2);
				pag = "combate.jsp";
			}
		} catch (Exception e) {
			System.out.println("fallo");
		}
  

		request.setAttribute("pokemonSeleccionado", p);
		request.setAttribute("pokemonRandom", p2);
		request.setAttribute("pokemones", pokemones);
		request.getRequestDispatcher(pag).forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
