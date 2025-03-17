package DO;

public class JediDO {
	/****************
	*VARIABLES
	*****************/
	private int id; 
	private String nombre;
	private String apodoGuerra;
	private int edad;
	private int altura;
	private int nivelSabiduria;
	private int energiaFuerza;
	
	/****************
	*CONSTRUCTORES
	*****************/
	

	public JediDO() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 * @param id
	 * @param nombre
	 * @param apodoGuerra
	 * @param edad
	 * @param altura
	 * @param nivelSabiduria
	 * @param energiaFuerza
	 * @param w
	 */
	public JediDO(int id, String nombre, String apodoGuerra, int edad, int altura, int nivelSabiduria,
			int energiaFuerza) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apodoGuerra = apodoGuerra;
		this.edad = edad;
		this.altura = altura;
		this.nivelSabiduria = nivelSabiduria;
		this.energiaFuerza = energiaFuerza;
		
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
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public int getAltura() {
		return altura;
	}
	public void setAltura(int altura) {
		this.altura = altura;
	}
	public int getNivelSabiduria() {
		return nivelSabiduria;
	}
	public void setNivelSabiduria(int nivelSabiduria) {
		this.nivelSabiduria = nivelSabiduria;
	}
	public int getEnergiaFuerza() {
		return energiaFuerza;
	}
	public void setEnergiaFuerza(int energiaFuerza) {
		this.energiaFuerza = energiaFuerza;
	}

	
	
	/****************
	* TO STRING
	*****************/
	@Override
	public String toString() {
		return "JediDO [id=" + id + ", nombre=" + nombre + ", apodoGuerra=" + apodoGuerra + ", edad=" + edad
				+ ", altura=" + altura + ", nivelSabiduria=" + nivelSabiduria + ", energiaFuerza=" + energiaFuerza
				+ "]";
	}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      
	

}
