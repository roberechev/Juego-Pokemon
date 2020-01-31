package pokemons;

import java.io.IOException;
import java.util.ArrayList;

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
		Scraping ac = new Scraping();
		ArrayList<Pokemon> pokemones = ac.scraping();
		String pag = "index.jsp";
		String url = "";
		String hp = "";
		try {
			String accion = request.getParameter("accion");

			if (accion.startsWith("combate")) {
				pag = "combate.jsp";
				String[] chpimg = accion.split(" ");
				hp = chpimg[1];
				url = chpimg[2];
				System.out.println(url);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		request.setAttribute("pokemonSeleccionadoHP", hp);
		request.setAttribute("pokemonSeleccionado", url);
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
