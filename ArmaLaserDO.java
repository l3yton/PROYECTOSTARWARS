package DO;

public class ArmaLaserDO {
	/****************
	*VARIABLES
	*****************/
	private int id;
	private String nombre;
	private int puntosRecarga;
	private int danio;
	private String tipo;


	/****************
	*CONSTRUCTORES
	*****************/
	public ArmaLaserDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @param id
	 * @param nombre
	 * @param puntosRecarga
	 * @param danio (daño)
	 * @param tipo
	 */
	public ArmaLaserDO(int id, String nombre, int puntosRecarga, int danio, String tipo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.puntosRecarga = puntosRecarga;
		this.danio = danio;
		this.tipo = tipo;
	}


	
	
	
	/****************
	*GETTERS AND SETTERS
	*****************/
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPuntosRecarga() {
		return puntosRecarga;
	}

	public void setPuntosRecarga(int puntosRecarga) {
		this.puntosRecarga = puntosRecarga;
	}

	public int getDanio() {
		return danio;
	}

	public void setDanio(int danio) {
		this.danio = danio;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	
	
	/****************
	* TO STRING
	*****************/
	
	@Override
	public String toString() {
		return "ArmaLaserDO [id=" + id + ", nombre=" + nombre + ", puntosRecarga=" + puntosRecarga + ", danio=" + danio
				+ ", tipo=" + tipo + "]";
	}
}
