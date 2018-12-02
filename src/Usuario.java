
	public class Usuario {

	private String Nombre;
	private String Apellidos;
	private String Cargo;
	private String UHab;
	private String ID;
	
	
	public Usuario(String nombre, String apellidos, String cargo, String UHab, String Id){
		this.Nombre=nombre;
		this.Apellidos=apellidos;
		this.Cargo=cargo;
		this.UHab=UHab;
		this.ID=ID;
	}
	
	public String getNombre(){
		return Nombre;
	}public String getApellidos(){
		return Apellidos;
	}
	public String getCargo(){
		return Cargo;
	}
	public String getID(){
		return ID;
	}
	public String getUHab(){
		return UHab;
	}
	
	
	public void setNombre(String Nombre){
		this.Nombre=Nombre;
	}
	public void setApellidos(String Apellidos){
		this.Apellidos=Apellidos;
	}
	public void setCargo(String Cargo){
		this.Cargo=Cargo;
	}
	public void setUhab(String uhab){
		this.UHab=uhab;
	}
	public void setID(String ID){
		this.ID=ID;
	}
}
