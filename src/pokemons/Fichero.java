package pokemons;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Fichero {
	private File f;
	private File config;
	private Scanner in;
	private String ruta;
	ArrayList<Pokemon> prueba = new ArrayList<Pokemon>();

	public void crearFicheroJson(ArrayList<Pokemon> pl) {
		try {
			Pokemon p = new Pokemon("jeje", "pikachu", 10, 190, 10, 123, 1, 1, 1);
			prueba.add(p);
			FileWriter fw = new FileWriter(new File("pokemon.json"));
			fw.write(escribirPokemonJson(prueba));
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private String escribirPokemonJson(ArrayList<Pokemon> listado_pokemon) {
		ruta = " {\"pokemons\": [{";
		for (Pokemon pokemon : listado_pokemon) {
			ruta += ruta + "\"" + "img" + "\"" + ":" + "\"" + pokemon.getImg() + "\"" + ",\r\n" + "\"" + "nombre" + "\""
					+ ":" + "\"" + pokemon.getNombre() + "\"" + ",\r\n" + "\"" + "hp" + "\"" + ":" + pokemon.getHp()
					+ ",\r\n" + "\"" + "ataque" + "\"" + ":" + pokemon.getAtaque() + ",\r\n" + "\"" + "defensa" + "\""
					+ ":" + pokemon.getDefensa() + ",\r\n" + "\"" + "velocidad" + "\"" + ":" + pokemon.getVelocidad()
					+ ",\r\n";
		}

		ruta = ruta + "}\r\n" + "  ]\r\n" + "}";

		return ruta;
	}

}
