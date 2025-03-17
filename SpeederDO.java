package DO;

public class SpeederDO {
	/****************
	*VARIABLES
	*****************/
	private int id;
	private String numSerie;
	private String marca;
	private int velocidadMaxima;
	private String armamento;
	private int municion;
	private String estado;
	
	
	/****************
	*CONSTRUCTORES
	*****************/
	public SpeederDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @param id
	 * @param numSerie
	 * @param marca
	 * @param velocidadMaxima
	 * @param armamento
	 * @param municion
	 * @param estado
	 */
	public SpeederDO(int id, String numSerie, String marca, int velocidadMaxima, String armamento, int municion,
			String estado) {
		super();
		this.id = id;
		this.numSerie = numSerie;
		this.marca = marca;
		this.velocidadMaxima = velocidadMaxima;
		this.armamento = armamento;
		this.municion = municion;
		this.estado = estado;
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

	public String getNumSerie() {
		return numSerie;
	}

	public void setNumSerie(String numSerie) {
		this.numSerie = numSerie;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getVelocidadMaxima() {
		return velocidadMaxima;
	}

	public void setVelocidadMaxima(int velocidadMaxima) {
		this.velocidadMaxima = velocidadMaxima;
	}

	public String getArmamento() {
		return armamento;
	}

	public void setArmamento(String armamento) {
		this.armamento = armamento;
	}

	public int getMunicion() {
		return municion;
	}

	public void setMunicion(int municion) {
		this.municion = municion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	
	
	
	/****************
	* TO STRING
	*****************/

	@Override
	public String toString() {
		return "SpeederDO [id=" + id + ", numSerie=" + numSerie + ", marca=" + marca + ", velocidadMaxima="
				+ velocidadMaxima + ", armamento=" + armamento + ", municion=" + municion + ", estado=" + estado + "]";
	}
	

}
