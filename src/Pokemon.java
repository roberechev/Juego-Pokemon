public class Pokemon {
	
	private String img;
	private String nombre;
	private int hp;
	private int ataque;
	private int defensa;
	private int velocidad;
	
	
	public Pokemon(String img, String nombre, int hp, int ataque, int defensa, int velocidad) {
		super();
		this.img = img;
		this.nombre = nombre;
		this.hp = hp;
		this.ataque = ataque;
		this.defensa = defensa;
		this.velocidad = velocidad;
	}


	public String getImg() {
		return img;
	}


	public void setImg(String img) {
		this.img = img;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getHp() {
		return hp;
	}


	public void setHp(int hp) {
		this.hp = hp;
	}


	public int getAtaque() {
		return ataque;
	}


	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}


	public int getDefensa() {
		return defensa;
	}


	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}


	public int getVelocidad() {
		return velocidad;
	}


	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}
	
	

}