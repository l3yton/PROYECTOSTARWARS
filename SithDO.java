package DO;

public class SithDO {
	/****************
	*VARIABLES
	*****************/
	private int id;
	private String nombre;
	private String apodoGuerra;
	private int edad;
	private int altura;
	private int nivelMaldad;
	private int energiaOscura;
	
	/****************
	*CONSTRUCTORES
	*****************/
	public SithDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SithDO(int id, String nombre, String apodoGuerra, int edad, int altura, int nivelMaldad, int energiaOscura) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apodoGuerra = apodoGuerra;
		this.edad = edad;
		this.altura = altura;
		this.nivelMaldad = nivelMaldad;
		this.energiaOscura = energiaOscura;
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

	public int getNivelMaldad() {
		return nivelMaldad;
	}

	public void setNivelMaldad(int nivelMaldad) {
		this.nivelMaldad = nivelMaldad;
	}

	public int getEnergiaOscura() {
		return energiaOscura;
	}

	public void setEnergiaOscura(int energiaOscura) {
		this.energiaOscura = energiaOscura;
	}

	
	
	
	
	
	/****************
	* TO STRING
	*****************/
	@Override
	public String toString() {
		return "SithDO [id=" + id + ", nombre=" + nombre + ", apodoGuerra=" + apodoGuerra + ", edad=" + edad
				+ ", altura=" + altura + ", nivelMaldad=" + nivelMaldad + ", energiaOscura=" + energiaOscura + "]";
	}

	
	
}
