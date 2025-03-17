package DO;

public class ClonDO {
	/****************
	*VARIABLES
	*****************/
	private int id;
	private String nombre;
	private String apodoGuerra = "";
	private String modelo = "";
	private int fuerza;
	private int inteligencia;
	private int horasInactividad;
	private int tiempoRefuerzoAdrenalina;
	private int rolEnSpeeder;
	private int Speeder_id;
	private int Jedi_id;
	
	/****************
	*CONSTRUCTORES
	*****************/
	public ClonDO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 * @param id
	 * @param apodoGuerra
	 * @param modelo
	 * @param fuerza
	 * @param intelignecia
	 * @param horasInactividad
	 * @param tiempoRefuerzoAdrenalina
	 * @param rolEnSpeeder
	 * @param speeder_id
	 * @param jedi_id
	 */
	public ClonDO(int id, String apodoGuerra, String modelo, int fuerza, int inteligencia, int horasInactividad,
			int tiempoRefuerzoAdrenalina, int rolEnSpeeder, int speeder_id, int jedi_id , String nombre) {
		super();
		this.id = id;
		this.apodoGuerra = apodoGuerra;
		this.modelo = modelo;
		this.fuerza = fuerza;
		this.inteligencia = inteligencia;
		this.horasInactividad = horasInactividad;
		this.tiempoRefuerzoAdrenalina = tiempoRefuerzoAdrenalina;
		this.rolEnSpeeder = rolEnSpeeder;
		Speeder_id = speeder_id;
		Jedi_id = jedi_id;
		this.nombre = nombre;
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

	public int getInteligencia() {
		return inteligencia;
	}

	public void setInteligencia(int inteligencia) {
		this.inteligencia = inteligencia;
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

	public int getRolEnSpeeder() {
		return rolEnSpeeder;
	}

	public void setRolEnSpeeder(int rolEnSpeeder) {
		this.rolEnSpeeder = rolEnSpeeder;
	}

	public int getSpeeder_id() {
		return Speeder_id;
	}

	public void setSpeeder_id(int speeder_id) {
		Speeder_id = speeder_id;
	}

	public int getJedi_id() {
		return Jedi_id;
	}

	public void setJedi_id(int jedi_id) {
		Jedi_id = jedi_id;
	}
	
	



	
	
	
	/****************
	* TO STRING
	*****************/
	@Override
	public String toString() {
		return "ClonDO [id=" + id + ", apodoGuerra=" + apodoGuerra + ", modelo=" + modelo + ", fuerza=" + fuerza
				+ ", inteligencia=" + inteligencia + ", horasInactividad=" + horasInactividad
				+ ", tiempoRefuerzoAdrenalina=" + tiempoRefuerzoAdrenalina + ", rolEnSpeeder=" + rolEnSpeeder
				+ ", Speeder_id=" + Speeder_id + ", Jedi_id=" + Jedi_id + "]";
	}

}