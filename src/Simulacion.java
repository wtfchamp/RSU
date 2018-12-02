import javax.swing.JOptionPane;


class Simulacion {
	Materiales materiales[];
	Lugar lugares[];
	Precio precio[];
	Usuario usuario[]; 
	private boolean val=false;	
	private int valor;
	private double TotalHab;
	private int tamaño, tamaño2;
	
	public Simulacion(){
		materiales = new Materiales[10];
		lugares = new Lugar[10];
		precio = new Precio[10];
		usuario= new Usuario[30];
	}
	public void Tamaño(int tamaño){
		this.tamaño=tamaño;
	}
	public int tamaño(){
		for(int i=0;i<10;i++){
			if((materiales[i]!=null)&&(lugares[i]!=null)&&(precio[i]!=null)){
				tamaño=i;
			}else{
				tamaño=i;
				break;
			}
		}
		return tamaño;
	}
	
	public int setTamaño(){
		for(int i=0;i<30;i++){
			if(usuario[i]!=null){
				tamaño2=i;
			}else{
				tamaño2=i;
				break;
			}
		}
		return tamaño2;
	}
	public void getTamaño(int tamaño2){
		this.tamaño2=tamaño2;
	}

	//Agregar Nuevos Datos
	public void DatosMateriales(int indice, double organico,double soplado,double pet,double carton,double papel,double botelata,double botealum,double lata,double fierro,double vidrio,double misce,double otros,String ID){
		materiales[indice]= new Materiales(organico, soplado, pet, carton, papel, botelata, botealum, lata, fierro, vidrio, misce, otros, ID);
	}
	
	public void DatosLugar(int indice,Lugar lug){
		lugares[indice]= lug;
	}

	public void Precio(int indice, double porganico, double psoplado,double ppet,double pcarton,double ppapel,double pbotelata,double pbotealum,double plata,double pfierro,double pmisce,double pvidrio,double potros){
		precio[indice]= new Precio(porganico, psoplado, ppet, pcarton, ppapel, pbotelata, pbotealum, plata, pfierro, pmisce, pvidrio, potros);
	}
	
	public void Usuario(int indice,String nombre, String apellidos, String cargo,String UHab, String ID){
		usuario[indice]= new Usuario(nombre, apellidos, cargo, UHab, ID);
	}
	
	//Modificar Datos
	public void setMateriales(int indice, double organico, double soplado, double pet, double carton, double papel, double botelata, double botealum, double lata, double fierro, double vidrio, double misce, double otros){
		materiales[indice].setOrganico(organico);
		materiales[indice].setSoplado(soplado);
		materiales[indice].setPet(pet);
		materiales[indice].setCarton(carton);
		materiales[indice].setPapel(papel);
		materiales[indice].setBoteLata(botelata);
		materiales[indice].setBoteAlum(botealum);
		materiales[indice].setLata(lata);
		materiales[indice].setFierro(fierro);
		materiales[indice].setVidrio(vidrio);
		materiales[indice].setMiscelaneo(misce);
		materiales[indice].setOtros(otros);
	}
	
	public void setPrecio(int indice,double organico, double soplado, double pet, double carton, double papel, double botelata, double botealum, double lata, double fierro, double vidrio, double misce, double otros){
		precio[indice].setOrganico(organico);
		precio[indice].setSoplado(soplado);
		precio[indice].setPet(pet);
		precio[indice].setCarton(carton);
		precio[indice].setPapel(papel);
		precio[indice].setBoteLata(botelata);
		precio[indice].setBoteAlum(botealum);
		precio[indice].setLata(lata);
		precio[indice].setFierro(fierro);
		precio[indice].setVidrio(vidrio);
		precio[indice].setMiscelaneo(misce);
		precio[indice].setOtros(otros);
	}
	
	public void setLugar(int indice, String estado, String municipio, String colonia, String codigop, String domicilio, String fracc, String nocasas, String habcasa, String tohabi, String ID){
		lugares[indice].setEstado(estado);
		lugares[indice].setMunicipio(municipio);
		lugares[indice].setColonia(colonia);
		lugares[indice].setCodigoP(codigop);
		lugares[indice].setDomicilio(domicilio);
		lugares[indice].setFracc(fracc);
		lugares[indice].setNoCasas(nocasas);
		lugares[indice].setHabCasa(habcasa);
		lugares[indice].setToHabi(tohabi);
	}
	
	public void setUsuario(int indice,String nombre, String apellidos, String cargo, String UHab, String ID){
		usuario[indice].setNombre(nombre);
		usuario[indice].setApellidos(apellidos);
		usuario[indice].setCargo(cargo);
		usuario[indice].setUhab(UHab);
		usuario[indice].setID(ID);
	}
	
	
	//Buscar el indice donde se encuentran los datos para modificar
	public boolean getUsuario(String ID){
		valor=0;
		try{
		for(int i=0;i<30;i++){
			if(usuario[i]!=null){
				if(usuario[i].getID().equalsIgnoreCase(ID)==true){
					val=true;
					valor=i;
					break;
				}
			}
			else{
				val=false;
				break;
			}
		}
		}catch(Exception y){
			JOptionPane.showMessageDialog(null, "No existen datos.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
		}
		return val;
	}
	
	public boolean getLugar(String ID){
		valor=0;
		try{
		for(int i=0;i<10;i++){
			if(lugares[i]!=null){
				if(lugares[i].getID().equalsIgnoreCase(ID)==true){
					val=true;
					valor=i;
					break;
				}
			}
			else{
				val=false;
				break;
			}
		}
		}catch(Exception y){
			JOptionPane.showMessageDialog(null, "No existen datos.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
		}
		return val; 
	}
	
	public boolean getMaterialesPrecio(String ID){
		valor=0;
		try{
		for(int i=0;i<10;i++){
			if(materiales[i]!=null){
				if(materiales[i].getID().equalsIgnoreCase(ID)==true){
					val=true;
					valor=i;
					break;
				}
			}
			else{
				val=false;
				break;
			}
		}
		}catch(Exception y){
			JOptionPane.showMessageDialog(null, "No existen datos.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
		}
		return val;
	 }
	//Retorna el indice del valor del dato que se busca para mostrar información.
	public int getPosicion(){
		 return valor;
	 }
	 	 
	 
	 //Eliminar Usuario
	 public boolean eliminarUsuario(String Id){
		 boolean band=false;
		 int i=0,j=0;
		 
		try{
			 if(usuario[0]==null){
				 band=false;
			 }else{
				 while(usuario[i]!=null){
					 if(usuario[i].getID().equalsIgnoreCase(Id)==true){
						 band= true;
						 j=i;
						do{
							 usuario[j]=usuario[j+1];
							 j++;
						 }while(usuario[j]!=null);
						 break;
					 }
					 i++;
				 }
			 }        
		}catch(Exception f){
			JOptionPane.showMessageDialog(null, "Usuario no encontrado.\nVerifique su información", "Aviso", JOptionPane.INFORMATION_MESSAGE);
		}
		 return band;
	 }
	 //Metodo de Simulacion
	 public void Simular(){
		 try{
		 for(int i=0;i<=10;i++){
		 
			TotalHab=Double.parseDouble(lugares[i].getToHabi());
			
			
			//Materiales Resultado
			materiales[i].setResul1(
					(materiales[i].getOrganico()*TotalHab),
					(materiales[i].getSoplado()*TotalHab), 
					(materiales[i].getPet()*TotalHab), 
					(materiales[i].getCarton()*TotalHab), 
					(materiales[i].getPapel()*TotalHab), 
					(materiales[i].getBoteLata()*TotalHab), 
					(materiales[i].getBoteAlum()*TotalHab), 
					(materiales[i].getLata()*TotalHab), 
					(materiales[i].getFierro()*TotalHab),
					(materiales[i].getMiscelaneo()*TotalHab), 
					(materiales[i].getVidrio()*TotalHab), 
					(materiales[i].getOtros()*TotalHab));
			materiales[i].setResul2(
					(materiales[i].Resul1.getROrganico()*7),
					(materiales[i].Resul1.getRSoplado()*7),
					(materiales[i].Resul1.getRPet()*7),
					(materiales[i].Resul1.getRCarton()*7),
					(materiales[i].Resul1.getRPapel()*7), 
					(materiales[i].Resul1.getRBoteLata()*7), 
					(materiales[i].Resul1.getRBoteAlum()*7), 
					(materiales[i].Resul1.getRLata()*7), 
					(materiales[i].Resul1.getRFierro()*7), 
					(materiales[i].Resul1.getRMiscelaneo()*7), 
					(materiales[i].Resul1.getRVidrio()*7), 
					(materiales[i].Resul1.getROtros()*7));
			materiales[i].setResul3(
					(materiales[i].Resul2.getROrganico()*4), 
					(materiales[i].Resul2.getRSoplado()*4), 
					(materiales[i].Resul2.getRPet()*4), 
					(materiales[i].Resul2.getRCarton()*4), 
					(materiales[i].Resul2.getRPapel()*4), 
					(materiales[i].Resul2.getRBoteLata()*4), 
					(materiales[i].Resul2.getRBoteAlum()*4), 
					(materiales[i].Resul2.getRLata()*4), 
					(materiales[i].Resul2.getRFierro()*4), 
					(materiales[i].Resul2.getRMiscelaneo()*4), 
					(materiales[i].Resul2.getRVidrio()*4), 
					(materiales[i].Resul2.getROtros()*4));
			materiales[i].setResul4(
					(materiales[i].Resul3.getROrganico()*12), 
					(materiales[i].Resul3.getRSoplado()*12), 
					(materiales[i].Resul3.getRPet()*12), 
					(materiales[i].Resul3.getRCarton()*12), 
					(materiales[i].Resul3.getRPapel()*12), 
					(materiales[i].Resul3.getRBoteLata()*12), 
					(materiales[i].Resul3.getRBoteAlum()*12), 
					(materiales[i].Resul3.getRLata()*12), 
					(materiales[i].Resul3.getRFierro()*12), 
					(materiales[i].Resul3.getRMiscelaneo()*12), 
					(materiales[i].Resul3.getRVidrio()*12), 
					(materiales[i].Resul3.getROtros()*12));
			
			
			//Precio Resultado
			
			
			precio[i].setResul1(
					(precio[i].getOrganico()*materiales[i].Resul1.getROrganico()),
					(precio[i].getSoplado()*materiales[i].Resul1.getRSoplado()), 
					(precio[i].getPet()*materiales[i].Resul1.getRPet()), 
					(precio[i].getCarton()*materiales[i].Resul1.getRCarton()), 
					(precio[i].getPapel()*materiales[i].Resul1.getRPapel()), 
					(precio[i].getBoteLata()*materiales[i].Resul1.getRBoteLata()), 
					(precio[i].getBoteAlum()*materiales[i].Resul1.getRBoteAlum()), 
					(precio[i].getLata()*materiales[i].Resul1.getRLata()), 
					(precio[i].getFierro()*materiales[i].Resul1.getRFierro()),
					(precio[i].getMiscelaneo()*materiales[i].Resul1.getRMiscelaneo()), 
					(precio[i].getVidrio()*materiales[i].Resul1.getRVidrio()), 
					(precio[i].getOtros()*materiales[i].Resul1.getROtros()));
			precio[i].setResul2(
					(precio[i].getOrganico()*materiales[i].Resul2.getROrganico()),
					(precio[i].getSoplado()*materiales[i].Resul2.getRSoplado()), 
					(precio[i].getPet()*materiales[i].Resul2.getRPet()), 
					(precio[i].getCarton()*materiales[i].Resul2.getRCarton()), 
					(precio[i].getPapel()*materiales[i].Resul2.getRPapel()), 
					(precio[i].getBoteLata()*materiales[i].Resul2.getRBoteLata()), 
					(precio[i].getBoteAlum()*materiales[i].Resul2.getRBoteAlum()), 
					(precio[i].getLata()*materiales[i].Resul2.getRLata()), 
					(precio[i].getFierro()*materiales[i].Resul2.getRFierro()),
					(precio[i].getMiscelaneo()*materiales[i].Resul2.getRMiscelaneo()), 
					(precio[i].getVidrio()*materiales[i].Resul2.getRVidrio()), 
					(precio[i].getOtros()*materiales[i].Resul2.getROtros()));
			precio[i].setResul3(
					(precio[i].getOrganico()*materiales[i].Resul3.getROrganico()),
					(precio[i].getSoplado()*materiales[i].Resul3.getRSoplado()), 
					(precio[i].getPet()*materiales[i].Resul3.getRPet()), 
					(precio[i].getCarton()*materiales[i].Resul3.getRCarton()), 
					(precio[i].getPapel()*materiales[i].Resul3.getRPapel()), 
					(precio[i].getBoteLata()*materiales[i].Resul3.getRBoteLata()), 
					(precio[i].getBoteAlum()*materiales[i].Resul3.getRBoteAlum()), 
					(precio[i].getLata()*materiales[i].Resul3.getRLata()), 
					(precio[i].getFierro()*materiales[i].Resul3.getRFierro()),
					(precio[i].getMiscelaneo()*materiales[i].Resul3.getRMiscelaneo()), 
					(precio[i].getVidrio()*materiales[i].Resul3.getRVidrio()), 
					(precio[i].getOtros()*materiales[i].Resul3.getROtros()));
			precio[i].setResul4(
					(precio[i].getOrganico()*materiales[i].Resul4.getROrganico()),
					(precio[i].getSoplado()*materiales[i].Resul4.getRSoplado()), 
					(precio[i].getPet()*materiales[i].Resul4.getRPet()), 
					(precio[i].getCarton()*materiales[i].Resul4.getRCarton()), 
					(precio[i].getPapel()*materiales[i].Resul4.getRPapel()), 
					(precio[i].getBoteLata()*materiales[i].Resul4.getRBoteLata()), 
					(precio[i].getBoteAlum()*materiales[i].Resul4.getRBoteAlum()), 
					(precio[i].getLata()*materiales[i].Resul4.getRLata()), 
					(precio[i].getFierro()*materiales[i].Resul4.getRFierro()),
					(precio[i].getMiscelaneo()*materiales[i].Resul4.getRMiscelaneo()), 
					(precio[i].getVidrio()*materiales[i].Resul4.getRVidrio()), 
					(precio[i].getOtros()*materiales[i].Resul4.getROtros()));
			
		}
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Listo", "", JOptionPane.INFORMATION_MESSAGE);
		}
		
	 }
	
	 //Mostrar información en la Tabla
	 public String TablaString(int indice){
		 return "Estado: "+lugares[indice].getEstado()+
				 "\tMunicipio: "+lugares[indice].getMunicipio()+
				 "\t\tColonia: "+lugares[indice].getColonia()+
				 "\t\tC.P.: "+lugares[indice].getCodigoP()+
				 "\t\tDomicilio: "+lugares[indice].getDomicilio()+
				 "\nFraccionamiento o U. Habitacional: "+lugares[indice].getFracc()+
				 "\tNo. de Casas: "+lugares[indice].getNoCasas()+
				 "\tPromedio de Habitantes por Casa: "+lugares[indice].getHabCasa()+
				 "\tNúmero total de habitantes por casa: "+lugares[indice].getToHabi();
	 }
	 //Mostrar informacion en laGráfica
	 public String GraficaString(int indice){
		 return "Estado: "+lugares[indice].getEstado()+
				 "\nMunicipio: "+lugares[indice].getMunicipio()+
				 "\nColonia: "+lugares[indice].getColonia()+
				 "\nC.P.: "+lugares[indice].getCodigoP()+
				 "\nDomicilio: "+lugares[indice].getDomicilio()+
				 "\nFraccionamiento o U. Habitacional: "+lugares[indice].getFracc()+
				 "\nNo. de Casas: "+lugares[indice].getNoCasas()+
				 "\nPromedio de Habitantes por Casa: "+lugares[indice].getHabCasa()+
				 "\nNúmero total de habitantes: "+lugares[indice].getToHabi();
	 }
	 

	
}
