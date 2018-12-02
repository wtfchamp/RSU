
class Lugar {

	private String Estado;
	private String Municipio;
	private String Colonia;
	private String CodigoP;
	private String Domicilio;
	private String Fracc;
	private String NoCasas;
	private String HabCasa;
	private String ToHabi;
	private String ID;
	
	public Lugar(){
		
	}
	
	public Lugar(String estado, String municipio, String colonia, String codigop, String domicilio, String fracc, String nocasas, String habcasa, String tohabi, String ID){
		this.Estado=estado;
		this.Municipio=municipio;
		this.Colonia=colonia;
		this.CodigoP=codigop;
		this.Domicilio=domicilio;
		this.Fracc=fracc;
		this.NoCasas=nocasas;
		this.HabCasa=habcasa;
		this.ToHabi=tohabi;
		this.ID=ID;
	}
	public String getEstado(){
		return Estado;
	}
	public String getMunicipio(){
		return Municipio;
	}
	public String getColonia(){
		return Colonia;
	}
	public String getCodigoP(){
		return CodigoP;
	}
	public String getDomicilio(){
		return Domicilio;
	}
	public String getFracc(){
		return Fracc;
	}
	public String getNoCasas(){
		return NoCasas;
	}
	public String getHabCasa(){
		return HabCasa;
	}
	public String getToHabi(){
		return ToHabi;
	}
	public String getID(){
		return ID;
	}
	public void setEstado(String Estado){
		this.Estado=Estado;
	}
	public void setMunicipio(String Municipio){
		this.Municipio=Municipio;
	}
	public void setColonia(String Colonia){
		this.Colonia=Colonia;
	}
	public void setCodigoP(String Codigo){
		this.CodigoP=Codigo;
	}
	public void setDomicilio(String Domicilio){
		this.Domicilio=Domicilio;
	}
	public void setFracc(String Fracc){
		this.Fracc=Fracc;
	}
	public void setNoCasas(String NoCasas){
		this.NoCasas=NoCasas;
	}
	public void setHabCasa(String HabCasa){
		this.HabCasa=HabCasa;
	}
	public void setToHabi(String ToHabi){
		this.ToHabi=ToHabi;
	}
	public void setID(String ID){
		this.ID=ID;
	}
	
	
	
}
