

class ResultadoP {
	private double ROrganico;
	private double RSoplado;
	private double RPet;
	private double RCarton;
	private double RPapel;
	private double RBoteL;
	private double RBoteA;
	private double RLata;
	private double RFierro;
	private double RMisce;
	private double RVidrio;
	private double ROtros;
	
	public ResultadoP(){
		this.ROrganico=0.0;
		this.RSoplado=0.0;
		this.RPet=0.0;
		this.RCarton=0.0;
		this.RPapel=0.0;
		this.RBoteL=0.0;
		this.RBoteA=0.0;
		this.RLata=0.0;
		this.RFierro=0.0;
		this.RMisce=0.0;
		this.RVidrio=0.0;
		this.ROtros=0.0;
				
	}
	
	public double getROrganico(){
		return ROrganico;
	}
	public double getRSoplado(){
		return RSoplado;
	}
	public double getRPet(){
		return RPet;
	}
	public double getRCarton(){
		return RCarton;
	}
	public double getRPapel(){
		return RPapel;
	}
	public double getRBoteLata(){
		return RBoteL;
	}
	public double getRBoteAlum(){
		return RBoteA;
	}
	public double getRLata(){
		return RLata;
	}
	public double getRFierro(){
		return RFierro;
	}
	public double getRMiscelaneo(){
		return RMisce;
	}
	public double getRVidrio(){
		return RVidrio;
	}
	public double getROtros(){
		return ROtros;
	}

		
	
	public void setROrganico(double organico){
		this.ROrganico=organico;
	}
	public void setRSoplado(double soplado){
		this.RSoplado=soplado;
	}
	public void setRPet(double pet){
		this.RPet=pet;
	}
	public void setRCarton(double carton){
		this.RCarton=carton;
	}
	public void setRPapel(double papel){
		this.RPapel=papel;
	}
	public void setRBoteLata(double botelata){
		this.RBoteL=botelata;
	}
	public void setRBoteAlum(double botealum){
		this.RBoteA=botealum;
	}
	public void setRLata(double lata){
		this.RLata=lata;
	}
	public void setRFierro(double fierro){
		this.RFierro=fierro;
	}
	public void setRMiscelaneo(double misce){
		this.RMisce=misce;
	}
	public void setRVidrio(double vidrio){
		this.RVidrio=vidrio;
	}
	public void setROtros(double otros){
		this.ROtros=otros;
	}
}
