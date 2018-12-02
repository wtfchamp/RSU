import javax.swing.*;
import java.awt.Toolkit;
import java.io.*;


class RSUGA{

	//Metodo para usar la ventana de abrir Archivo y Explorar Disco
    public static  String explorarDiscoAbrir(){
    	JFrame frame = new JFrame();
    	frame.setIconImage(Toolkit.getDefaultToolkit().getImage(RSUGA.class.getResource("/Iconos/Folder.png")));
		JFileChooser chArchivo = new JFileChooser();
        chArchivo.setCurrentDirectory(new File(".")); //Directorio actual
        int retval = chArchivo.showOpenDialog(frame);
        //En retval regresa el boton que se oprimio: Ok o Cancelar
        if(retval == JFileChooser.APPROVE_OPTION) {
            File archivo = chArchivo.getSelectedFile();
            if (archivo != null) {
            	return (archivo.getPath());
            }
        }else
           if (retval == JFileChooser.CANCEL_OPTION) {
               return null;
            } 
           else
        	   if (retval == JFileChooser.ERROR_OPTION) {
                   JOptionPane.showMessageDialog(frame, "El archivo no fue seleccionado", "Advertencia", JOptionPane.WARNING_MESSAGE);
        	   }
        	   else {
                	JOptionPane.showMessageDialog(frame, "Ocurrio una operacion desconocida.", "ERROR", JOptionPane.ERROR_MESSAGE);
        	   }
        return null;
    }

    //Metodo para usar la ventana de guardar Archivo y Explorar Disco

    public static  String explorarDiscoGuardar(){
    	JFrame frame = new JFrame();
    	frame.setIconImage(Toolkit.getDefaultToolkit().getImage(RSUGA.class.getResource("/Iconos/Folder.png")));
    	JFileChooser chArchivo = new JFileChooser();
        chArchivo.setCurrentDirectory(new File(".")); //Directorio Actual
        int retval = chArchivo.showSaveDialog(frame);
        //En retval regresamos el boton que se oprimio: Ok o Cancelar
        if(retval == JFileChooser.APPROVE_OPTION) {
            File archivo = chArchivo.getSelectedFile();
            if (archivo != null) {
            	return (archivo.getPath());
            }
        }
        else
           if (retval == JFileChooser.CANCEL_OPTION) {
               return null;
            }
           else
        	   if (retval == JFileChooser.ERROR_OPTION) {
                   JOptionPane.showMessageDialog(frame, "El archivo no fue seleccionado", "Advertencia", JOptionPane.WARNING_MESSAGE);
        	   }
        	   else {
                	JOptionPane.showMessageDialog(frame, "Ocurrio una operaciï¿½n desconocida.", "ERROR", JOptionPane.ERROR_MESSAGE);
        	   }
        return null;
    }
    
/*
 *  Este metodo lee un un archivo secuencial de los datos de Lugar, Materiales y Precio de los Materiales
 */

    public static void abrirArchivo(String nombreArchivo, Simulacion simulacion){
    	int i=0,j=0;
    	String Estado, Municipio, Colonia, CodigoP, Domicilio, Fracc, NoCasas, HabCasa, ToHabi, ID;
    	Double organico, soplado, pet, carton, papel, botelata, botealum, lata, fierro, vidrio, misce, otros;
    	Double organicop, sopladop, petp, cartonp, papelp, botelatap, botealump, latap, fierrop, vidriop, miscep, otrosp;
    	String nombre, apellidos, cargo, UHab;
    	
        DataInputStream entrada= null;

       //abrir archivo para lectura
        try
        {
            entrada = new DataInputStream( new FileInputStream(nombreArchivo));
        }
        catch (IOException e){
            JOptionPane.showMessageDialog(null, "Error en apertura de archivo\n"+e.toString(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }catch(Exception c){
        	
        }
        
        
        //Leer los datos del  archivo
        try {
        	//ciclo infinito, terminará cuando se acaben los datos
            while(true){
            	//Se leen los datos del Lugar
            	Estado= entrada.readUTF();
            	Municipio= entrada.readUTF();
            	Colonia= entrada.readUTF();
            	CodigoP= entrada.readUTF();
            	Domicilio= entrada.readUTF();
            	Fracc= entrada.readUTF();
            	NoCasas= entrada.readUTF();
            	HabCasa= entrada.readUTF();
            	ToHabi= entrada.readUTF();
            	ID= entrada.readUTF();
            	//Agregamos los datos del Lugar a la simulacion
            	Lugar lugar = new Lugar(Estado, Municipio, Colonia, CodigoP, Domicilio, Fracc, NoCasas, HabCasa, ToHabi, ID);
            	simulacion.DatosLugar(i, lugar);
            	//Se leen los datos de los Materiales
            	organico= entrada.readDouble();
            	soplado= entrada.readDouble();
            	pet= entrada.readDouble();
            	carton= entrada.readDouble();
            	papel= entrada.readDouble();
            	botelata= entrada.readDouble();
            	botealum= entrada.readDouble();
            	lata= entrada.readDouble();
            	fierro= entrada.readDouble();
            	vidrio= entrada.readDouble();
            	misce= entrada.readDouble();
            	otros= entrada.readDouble();
            	ID= entrada.readUTF();
            	//Agregamos los datos de los Materiales a la Simulacion
            	simulacion.DatosMateriales(i, organico, soplado, pet, carton, papel, botelata, botealum, lata, fierro, vidrio, misce, otros, ID);
            	//Se leen los datos de los Precios de los Materiales
            	organicop= entrada.readDouble();
            	sopladop= entrada.readDouble();
            	petp= entrada.readDouble();
            	cartonp= entrada.readDouble();
            	papelp= entrada.readDouble();
            	botelatap= entrada.readDouble();
            	botealump= entrada.readDouble();
            	latap= entrada.readDouble();
            	fierrop= entrada.readDouble();
            	vidriop= entrada.readDouble();
            	miscep= entrada.readDouble();
            	otrosp= entrada.readDouble();
            	//Agregamos los datos de los Precios de los Materiales a la Simulacion
            	simulacion.Precio(i, organicop,sopladop, petp, cartonp, papelp, botelatap, botealump, latap, fierrop, miscep, vidriop, otrosp);
            	//Se agregan los datos de los Usuarios de cadav Fraccionamiento o U. Habitacional 3 por cada Fracc
            	//Primer Usuario
            	nombre= entrada.readUTF();
            	apellidos= entrada.readUTF();
            	cargo= entrada.readUTF();
            	UHab= entrada.readUTF();
            	ID= entrada.readUTF();
            	//Primer usuario
            	simulacion.Usuario(j, nombre, apellidos, cargo, UHab, ID);
            	j++;
            	//Segundo usuario
            	nombre= entrada.readUTF();
            	apellidos= entrada.readUTF();
            	cargo= entrada.readUTF();
            	UHab= entrada.readUTF();
            	ID= entrada.readUTF();
            	//Segundo usuario
            	simulacion.Usuario(j, nombre, apellidos, cargo, UHab, ID);
            	j++;
            	//Tercer usuario
            	nombre= entrada.readUTF();
            	apellidos= entrada.readUTF();
            	cargo= entrada.readUTF();
            	UHab= entrada.readUTF();
            	ID= entrada.readUTF();
            	//Tercer usuario
            	simulacion.Usuario(j, nombre, apellidos, cargo, UHab, ID);
            	j++;
            	//Se terminan de leer datos
            	
            	i++;
            	simulacion.Tamaño(i);
            }
        }
        catch (EOFException eof){
           //ya no hay mas registros (datos) -- En este caso no hacemos nada
        }
        catch (IOException e){
              JOptionPane.showMessageDialog(null, "Error en lectura de archivo\n"+e.toString(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }catch(Exception c){
        	
        }

        try {
         entrada.close();
        }
        catch (IOException e){
              JOptionPane.showMessageDialog(null, "Error en el cierre de archivo\n"+e.toString(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }catch(Exception c){
        	
        }
    }

    
    
    
    //Escribe en un archivo secuencial los datos de Lugar, Materiales y Precio de los Materiales
    public static void guardarArchivo(String nombreArchivo, Simulacion simulacion){
    	int i=0,j=0;
    	DataOutputStream salida=null; //Habilita salida de datos a un archivo
        //Abrir archivo para escritura
        try
        {
            salida = new DataOutputStream( new FileOutputStream(nombreArchivo, false));
        }
        catch (IOException e){
            JOptionPane.showMessageDialog(null, "Error en apertura de archivo\n"+e.toString(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }catch(Exception c){
        	
        }
        //Enviar los datos al archivo
        try {
            while((simulacion.lugares[i]!=null)&&(simulacion.materiales[i]!=null)&&(simulacion.precio[i]!=null)&&i<10){
            	//Se escriben los datos de la simulacion en el archivo
            	//Se escribe los datos del Lugar
            	salida.writeUTF(simulacion.lugares[i].getEstado());
            	salida.writeUTF(simulacion.lugares[i].getMunicipio());
            	salida.writeUTF(simulacion.lugares[i].getColonia());
            	salida.writeUTF(simulacion.lugares[i].getCodigoP());
            	salida.writeUTF(simulacion.lugares[i].getDomicilio());
            	salida.writeUTF(simulacion.lugares[i].getFracc());
            	salida.writeUTF(simulacion.lugares[i].getNoCasas());
            	salida.writeUTF(simulacion.lugares[i].getHabCasa());
            	salida.writeUTF(simulacion.lugares[i].getToHabi());
            	salida.writeUTF(simulacion.lugares[i].getID());
            	//Se escriben los datos de los Materiales
            	salida.writeDouble(simulacion.materiales[i].getOrganico());
            	salida.writeDouble(simulacion.materiales[i].getSoplado());
            	salida.writeDouble(simulacion.materiales[i].getPet());
            	salida.writeDouble(simulacion.materiales[i].getCarton());
            	salida.writeDouble(simulacion.materiales[i].getPapel());
            	salida.writeDouble(simulacion.materiales[i].getBoteLata());
            	salida.writeDouble(simulacion.materiales[i].getBoteAlum());
            	salida.writeDouble(simulacion.materiales[i].getLata());
            	salida.writeDouble(simulacion.materiales[i].getFierro());
            	salida.writeDouble(simulacion.materiales[i].getVidrio());
            	salida.writeDouble(simulacion.materiales[i].getMiscelaneo());
            	salida.writeDouble(simulacion.materiales[i].getOrganico());
            	salida.writeUTF(simulacion.materiales[i].getID());
            	//Se escriben los datos de los Precios de los Materiales
            	salida.writeDouble(simulacion.precio[i].getOrganico());
            	salida.writeDouble(simulacion.precio[i].getSoplado());
            	salida.writeDouble(simulacion.precio[i].getPet());
            	salida.writeDouble(simulacion.precio[i].getCarton());
            	salida.writeDouble(simulacion.precio[i].getPapel());
            	salida.writeDouble(simulacion.precio[i].getBoteLata());
            	salida.writeDouble(simulacion.precio[i].getBoteAlum());
            	salida.writeDouble(simulacion.precio[i].getLata());
            	salida.writeDouble(simulacion.precio[i].getFierro());
            	salida.writeDouble(simulacion.precio[i].getVidrio());
            	salida.writeDouble(simulacion.precio[i].getMiscelaneo());
            	salida.writeDouble(simulacion.precio[i].getOrganico());
            	//Se escriben los datos de los tres ususarios de cada Fraccioanmiento o U. Hab.
            	//Primer Usuario
            	salida.writeUTF(simulacion.usuario[j].getNombre());
            	salida.writeUTF(simulacion.usuario[j].getApellidos());
            	salida.writeUTF(simulacion.usuario[j].getCargo());
            	salida.writeUTF(simulacion.usuario[j].getUHab());
            	salida.writeUTF(simulacion.usuario[j].getID());
            	j++;
            	//Primer Usuario
            	salida.writeUTF(simulacion.usuario[j].getNombre());
            	salida.writeUTF(simulacion.usuario[j].getApellidos());
            	salida.writeUTF(simulacion.usuario[j].getCargo());
            	salida.writeUTF(simulacion.usuario[j].getUHab());
            	salida.writeUTF(simulacion.usuario[j].getID());
            	j++;
            	//Primer Usuario
            	salida.writeUTF(simulacion.usuario[j].getNombre());
            	salida.writeUTF(simulacion.usuario[j].getApellidos());
            	salida.writeUTF(simulacion.usuario[j].getCargo());
            	salida.writeUTF(simulacion.usuario[j].getUHab());
            	salida.writeUTF(simulacion.usuario[j].getID());
            	j++;
            	//Se terminan de escribir los datos por Fracc. o U.Hab.
            	
            	
            	
            	
            	i++;
            }
        }catch (IOException e){
              JOptionPane.showMessageDialog(null, "Error en escritura de archivo\n"+e.toString(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }catch(Exception c){
        	
        }
        try {
         salida.close();
        }catch (IOException e){
              JOptionPane.showMessageDialog(null, "Error cierre de archivo\n"+e.toString(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }catch(Exception c){
        	
        }
   }

}
