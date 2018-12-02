
class Precio {
	private double Organico;
	private double Soplado;
	private double Pet;
	private double Carton;
	private double Papel;
	private double BoteLata;
	private double BoteAlum;
	private double Lata;
	private double Fierro;
	private double Misce;
	private double Vidrio;
	private double Otros;
	ResultadoP Resul1;
	ResultadoP Resul2;
	ResultadoP Resul3;
	ResultadoP Resul4;


	
	public Precio(double organico, double soplado, double pet, double carton, double papel, double botelata, double botealum, double lata, double fierro, double vidrio, double misce, double otros){
		this.Organico=organico;
		this.Soplado=soplado;
		this.Pet=pet;
		this.Carton=carton;
		this.Papel=papel;
		this.BoteLata=botelata;
		this.BoteAlum=botealum;
		this.Lata=lata;
		this.Fierro=fierro;
		this.Misce=misce;
		this.Vidrio=vidrio;
		this.Otros=otros;
		Resul1= new ResultadoP();
		Resul2=new ResultadoP();
		Resul3=new ResultadoP();
		Resul4=new ResultadoP();
	}
	
	public double getOrganico(){
		return Organico;
	}
	public double getSoplado(){
		return Soplado;
	}
	public double getPet(){
		return Pet;
	}
	public double getCarton(){
		return Carton;
	}
	public double getPapel(){
		return Papel;
	}
	public double getBoteLata(){
		return BoteLata;
	}
	public double getBoteAlum(){
		return BoteAlum;
	}
	public double getLata(){
		return Lata;
	}
	public double getFierro(){
		return Fierro;
	}
	public double getMiscelaneo(){
		return Misce;
	}
	public double getVidrio(){
		return Vidrio;
	}
	public double getOtros(){
		return Otros;
	}
	

		
	
	public void setOrganico(double organico){
		this.Organico=organico;
	}
	public void setSoplado(double soplado){
		this.Soplado=soplado;
	}
	public void setPet(double pet){
		this.Pet=pet;
	}
	public void setCarton(double carton){
		this.Carton=carton;
	}
	public void setPapel(double papel){
		this.Papel=papel;
	}
	public void setBoteLata(double botelata){
		this.BoteLata=botelata;
	}
	public void setBoteAlum(double botealum){
		this.BoteAlum=botealum;
	}
	public void setLata(double lata){
		this.Lata=lata;
	}
	public void setFierro(double fierro){
		this.Fierro=fierro;
	}
	public void setMiscelaneo(double misce){
		this.Misce=misce;
	}
	public void setVidrio(double vidrio){
		this.Vidrio=vidrio;
	}
	public void setOtros(double otros){
		this.Otros=otros;
	}
	public void setResul1(double rorg, double rsopl, double rpet, double rcart, double rpapel, 
			double rbotel, double rbotea, double rlata, double rfierro, double rmisce, double rvidrio,
			double rotros){
		this.Resul1.setROrganico(rorg);
		this.Resul1.setRSoplado(rsopl);
		this.Resul1.setRPet(rpet);
		this.Resul1.setRCarton(rcart);
		this.Resul1.setRPapel(rpapel);
		this.Resul1.setRBoteLata(rbotel);
		this.Resul1.setRBoteAlum(rbotea);
		this.Resul1.setRLata(rlata);
		this.Resul1.setRFierro(rfierro);
		this.Resul1.setRMiscelaneo(rmisce);
		this.Resul1.setRVidrio(rvidrio);
		this.Resul1.setROtros(rotros);
	}
	public void setResul2(double rorg, double rsopl, double rpet, double rcart, double rpapel, 
			double rbotel, double rbotea, double rlata, double rfierro, double rmisce, double rvidrio,
			double rotros){
		this.Resul2.setROrganico(rorg);
		this.Resul2.setRSoplado(rsopl);
		this.Resul2.setRPet(rpet);
		this.Resul2.setRCarton(rcart);
		this.Resul2.setRPapel(rpapel);
		this.Resul2.setRBoteLata(rbotel);
		this.Resul2.setRBoteAlum(rbotea);
		this.Resul2.setRLata(rlata);
		this.Resul2.setRFierro(rfierro);
		this.Resul2.setRMiscelaneo(rmisce);
		this.Resul2.setRVidrio(rvidrio);
		this.Resul2.setROtros(rotros);
	}
	public void setResul3(double rorg, double rsopl, double rpet, double rcart, double rpapel, 
			double rbotel, double rbotea, double rlata, double rfierro, double rmisce, double rvidrio,
			double rotros){
		this.Resul3.setROrganico(rorg);
		this.Resul3.setRSoplado(rsopl);
		this.Resul3.setRPet(rpet);
		this.Resul3.setRCarton(rcart);
		this.Resul3.setRPapel(rpapel);
		this.Resul3.setRBoteLata(rbotel);
		this.Resul3.setRBoteAlum(rbotea);
		this.Resul3.setRLata(rlata);
		this.Resul3.setRFierro(rfierro);
		this.Resul3.setRMiscelaneo(rmisce);
		this.Resul3.setRVidrio(rvidrio);
		this.Resul3.setROtros(rotros);
	}
	public void setResul4(double rorg, double rsopl, double rpet, double rcart, double rpapel, 
			double rbotel, double rbotea, double rlata, double rfierro, double rmisce, double rvidrio,
			double rotros){
		this.Resul4.setROrganico(rorg);
		this.Resul4.setRSoplado(rsopl);
		this.Resul4.setRPet(rpet);
		this.Resul4.setRCarton(rcart);
		this.Resul4.setRPapel(rpapel);
		this.Resul4.setRBoteLata(rbotel);
		this.Resul4.setRBoteAlum(rbotea);
		this.Resul4.setRLata(rlata);
		this.Resul4.setRFierro(rfierro);
		this.Resul4.setRMiscelaneo(rmisce);
		this.Resul4.setRVidrio(rvidrio);
		this.Resul4.setROtros(rotros);
	}

}
