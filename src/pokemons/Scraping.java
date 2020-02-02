package pokemons;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Scraping {

	private final static String URL = "https://pokemondb.net/pokedex/all";

	public static ArrayList<Pokemon> scraping() {
		ArrayList<Pokemon> listadoPokemon = new ArrayList<Pokemon>();
		int contador = 0;
		try {

			Document d = Jsoup.connect(URL).get();

			Elements imagenesPokemon = d.getElementsByClass("img-fixed icon-pkmn");
			Elements nombresPokemon = d.getElementsByClass("ent-name");
			Elements estadisticasPokemon = d.getElementsByClass("cell-num");

			for (int i = 0; i < nombresPokemon.size(); i++) {
				Element imgUrl = imagenesPokemon.get(i);
				String img = imgUrl.attr("data-src");
				Element nombrePokemon = nombresPokemon.get(i);
				String nombre = nombrePokemon.text();

				int numero = Integer.parseInt(estadisticasPokemon.get(contador).text());
				int hp = Integer.parseInt(estadisticasPokemon.get(contador + 1).text());
				int ataque = Integer.parseInt(estadisticasPokemon.get(contador + 2).text());
				int defensa = Integer.parseInt(estadisticasPokemon.get(contador + 3).text());
				int ataqueEspecial = Integer.parseInt(estadisticasPokemon.get(contador + 4).text());
				int defensaEspecial = Integer.parseInt(estadisticasPokemon.get(contador + 5).text());
				int velocidad = Integer.parseInt(estadisticasPokemon.get(contador + 6).text());

				contador += 7;

				listadoPokemon.add(new Pokemon(img, nombre, numero, hp, ataque, defensa, ataqueEspecial,
						defensaEspecial, velocidad));

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listadoPokemon;

	}
}
