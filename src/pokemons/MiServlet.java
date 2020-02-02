package pokemons;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MiServlet
 */
@WebServlet("/MiServlet")
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
		// response.getWriter().append("Served at: ").append(request.getContextPath());

		ArrayList<Pokemon> pokemones = Scraping.scraping();
		Combate.generarMapa(pokemones);
		Fichero f = new Fichero();
		f.crearFicheroJson(pokemones);
		String pag = "index.jsp";
		String nombre = "";

		try {
			String accion = request.getParameter("accion");

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
			// TODO: handle exception
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
