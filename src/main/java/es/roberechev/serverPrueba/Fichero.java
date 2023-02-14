package es.roberechev.serverPrueba;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Fichero {
	private String ruta;

	public void crearFicheroJson(ArrayList<Pokemon> pl) {
		File f = new File("C:/Users/rober/pokemon.json");
		try {
			FileWriter fw = new FileWriter(f);
			fw.write(escribirPokemonJson(pl));
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private String escribirPokemonJson(ArrayList<Pokemon> listado_pokemon) {

		ruta = " {\"pokemons\":[";
		for (Pokemon pokemon : listado_pokemon) {
			ruta += "{" + "\"" + "img" + "\"" + ":" + "\"" + pokemon.getImg() + "\"" + ",\r\n" + "\"" + "nombre" + "\""
					+ ":" + "\"" + pokemon.getNombre() + "\"" + ",\r\n" + "\"" + "hp" + "\"" + ":" + pokemon.getHp()
					+ ",\r\n" + "\"" + "ataque" + "\"" + ":" + pokemon.getAtaque() + ",\r\n" + "\"" + "defensa" + "\""
					+ ":" + pokemon.getDefensa() + ",\r\n" + "\"" + "velocidad" + "\"" + ":" + pokemon.getVelocidad()
					+ "\r\n" + "},\r\n" + " \r\n";
		}

		ruta += "]}";

		return ruta;
	}

}
