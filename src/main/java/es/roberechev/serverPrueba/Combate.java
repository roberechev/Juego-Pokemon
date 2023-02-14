package es.roberechev.serverPrueba;

import java.util.ArrayList;
import java.util.HashMap;

public class Combate {

	private static HashMap<String, Pokemon> mapaPokemon = new HashMap<>();

	public static void combate(Pokemon p1, Pokemon p2) {
		System.out.println(p1.getNombre() + " VS " + p2.getNombre());
		System.out.println(p1.getHp() + " VS " + p2.getHp());

		if (p1.getHp() > 0 && p2.getHp() > 0) {

			if (p1.getVelocidad() > p2.getVelocidad()) {
				int damage = Math.round(p1.getAtaque() / p2.getDefensa() * 10 + 1);
				p2.setHp(p2.getHp() - damage);

				if (p2.getHp() > 0) {
					damage = Math.round(p2.getAtaque() / p1.getDefensa() * 10 + 1);
					p1.setHp(p1.getHp() - damage);
				}

			} else {
				int damage = Math.round(p2.getAtaque() / p1.getDefensa() * 10 + 1);
				p1.setHp(p1.getHp() - damage);

				if (p1.getHp() > 0) {
					damage = Math.round(p1.getAtaque() / p2.getDefensa() * 10 + 1);
					p2.setHp(p2.getHp() - damage);
				}

			}

		}
		
		System.out.println(p1.getHp() + " VS " + p2.getHp());

	}

	public static void generarMapa(ArrayList<Pokemon> pokemons) {
		for (Pokemon pokemon : pokemons) {
			mapaPokemon.put(pokemon.getNombre(), pokemon);
		}
	}

	public static Pokemon getPokemon(String nombre) {

		return mapaPokemon.get(nombre);

	}

}
