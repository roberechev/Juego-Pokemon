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
	public Pokemon p = new Pokemon("jeje", "pikachu", 10, 190, 10, 123);
	ArrayList<Pokemon> pl = new ArrayList<Pokemon>();

	public Fichero() {
		in = new Scanner(System.in);
		pl.add(p);
	}

	public void crearFicheroJson() {
		this.config = new File("./Pokemon.json");
		if (config.exists()) {
			config.delete();
		}
		if (config.length() == 0 || !config.exists()) {
			escribirPokemonJson(pl);

		}
		try {
			FileReader fr = new FileReader(config);
			BufferedReader br = new BufferedReader(fr);
			String lineaRuta = br.readLine();
			while (lineaRuta != null) {
				setRuta(lineaRuta);
				lineaRuta = br.readLine();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void escribirPokemonJson(ArrayList<Pokemon> listado_pokemon) {
		try {
			// Escribir en nuestro fichero
			FileWriter fw = new FileWriter(config);

			ruta = " {\"pokemons\": [{";
			for (Pokemon pokemon : listado_pokemon) {
				ruta = ruta + "\"" + "img" + "\"" + ":" + "\"" + pokemon.getImg() + "\"" + ",\r\n" + "\"" + "nombre"
						+ "\"" + ":" + "\"" + pokemon.getNombre() + "\"" + ",\r\n" + "\"" + "hp" + "\"" + ":"
						+ pokemon.getHp() + ",\r\n" + "\"" + "ataque" + "\"" + ":" + pokemon.getAtaque() + ",\r\n"
						+ "\"" + "defensa" + "\"" + ":" + pokemon.getDefensa() + ",\r\n" + "\"" + "velocidad" + "\""
						+ ":" + pokemon.getVelocidad() + "\r\n";
			}

			ruta = ruta + "}\r\n" + "  ]\r\n" + "}";
			fw.write(ruta);
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public File getF() {
		return f;
	}

	public void setF(File f) {
		this.f = f;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}
}
