package DO;

public class DroidekaDO {
	/****************
	*VARIABLES
	*****************/
	private int id;
	private String nombre;
	private String apodoGuerra;
	private String modelo;
	private int fuerza;
	private int horasInactividad;
	private int tiempoRefuerzoAdrenalina;
	
	
	/****************
	*CONSTRUCTORES
	*****************/
	public DroidekaDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @param id
	 * @param nombre
	 * @param apodoGuerra
	 * @param modelo
	 * @param fuerza
	 * @param horasInactividad
	 * @param tiempoRefuerzoAdrenalina
	 */
	public DroidekaDO(int id, String nombre, String apodoGuerra, String modelo, int fuerza, int horasInactividad,
			int tiempoRefuerzoAdrenalina) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apodoGuerra = apodoGuerra;
		this.modelo = modelo;
		this.fuerza = fuerza;
		this.horasInactividad = horasInactividad;
		this.tiempoRefuerzoAdrenalina = tiempoRefuerzoAdrenalina;
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

	public String getApodoGuerra() {
		return apodoGuerra;
	}

	public void setApodoGuerra(String apodoGuerra) {
		this.apodoGuerra = apodoGuerra;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getFuerza() {
		return fuerza;
	}

	public void setFuerza(int fuerza) {
		this.fuerza = fuerza;
	}

	public int getHorasInactividad() {
		return horasInactividad;
	}

	public void setHorasInactividad(int horasInactividad) {
		this.horasInactividad = horasInactividad;
	}

	public int getTiempoRefuerzoAdrenalina() {
		return tiempoRefuerzoAdrenalina;
	}

	public void setTiempoRefuerzoAdrenalina(int tiempoRefuerzoAdrenalina) {
		this.tiempoRefuerzoAdrenalina = tiempoRefuerzoAdrenalina;
	}

	
	
	
	/****************
	* TO STRING
	*****************/
	
	@Override
	public String toString() {
		return "DroidekaDO [id=" + id + ", nombre=" + nombre + ", apodoGuerra=" + apodoGuerra + ", modelo=" + modelo
				+ ", fuerza=" + fuerza + ", horasInactividad=" + horasInactividad + ", tiempoRefuerzoAdrenalina="
				+ tiempoRefuerzoAdrenalina + "]";
	}

}
