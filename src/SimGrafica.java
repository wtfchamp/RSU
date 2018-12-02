import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.SpringLayout;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

import java.awt.Paint;
import java.awt.Color;


public class SimGrafica extends JDialog implements ActionListener{

	private final JPanel PanelPrincipal = new JPanel();
	private JScrollPane scrollPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGraficas = new ButtonGroup();
	private JRadioButton rdGeneral;
	private JRadioButton rdEspecifica;
	private boolean opcion1, opcion2, opcion3, opcion4;
	private JButton Anterior;
	private JPanel panelGrafica;
	private JButton btnOk;
	private JButton Siguiente;
	private DefaultCategoryDataset data;
	private ChartPanel Cpanel;
	private JFreeChart chart= null;
//	private CategoryPlot plot;
	private int i=0,j=0,op=1, op2=1;
	private Simulacion sim;
	private String etiqueta="", informacion="",titulo="", gentipo="";
	private JTextArea textArea;
	private JRadioButton rdMaterialesPre;
	private JRadioButton rdMateriales;

	public SimGrafica(Simulacion simulacion) {
		setTitle("Gr\u00E1ficas de Resultados la Simulaci\u00F3n");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 1160, 500);
		getContentPane().setLayout(new BorderLayout());
		PanelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(PanelPrincipal, BorderLayout.CENTER);
		SpringLayout sl_PanelPrincipal = new SpringLayout();
		PanelPrincipal.setLayout(sl_PanelPrincipal);
		{
			scrollPane = new JScrollPane();
			sl_PanelPrincipal.putConstraint(SpringLayout.NORTH, scrollPane, 10, SpringLayout.NORTH, PanelPrincipal);
			sl_PanelPrincipal.putConstraint(SpringLayout.WEST, scrollPane, 10, SpringLayout.WEST, PanelPrincipal);
			sl_PanelPrincipal.putConstraint(SpringLayout.SOUTH, scrollPane, 417, SpringLayout.NORTH, PanelPrincipal);
			sl_PanelPrincipal.putConstraint(SpringLayout.EAST, scrollPane, 324, SpringLayout.WEST, PanelPrincipal);
			PanelPrincipal.add(scrollPane);
			
			textArea = new JTextArea();
			textArea.setEditable(false);
			scrollPane.setViewportView(textArea);
		}
		
		sim = simulacion;
		
		panelGrafica = new JPanel();
		sl_PanelPrincipal.putConstraint(SpringLayout.NORTH, panelGrafica, 10, SpringLayout.NORTH, PanelPrincipal);
		sl_PanelPrincipal.putConstraint(SpringLayout.WEST, panelGrafica, 6, SpringLayout.EAST, scrollPane);
		sl_PanelPrincipal.putConstraint(SpringLayout.SOUTH, panelGrafica, 417, SpringLayout.NORTH, PanelPrincipal);
		sl_PanelPrincipal.putConstraint(SpringLayout.EAST, panelGrafica, -10, SpringLayout.EAST, PanelPrincipal);
		PanelPrincipal.add(panelGrafica);
		
		rdGeneral = new JRadioButton("Vista General");
		rdGeneral.addActionListener(this);
		buttonGroup.add(rdGeneral);
		sl_PanelPrincipal.putConstraint(SpringLayout.NORTH, rdGeneral, 6, SpringLayout.SOUTH, panelGrafica);
		sl_PanelPrincipal.putConstraint(SpringLayout.WEST, rdGeneral, 0, SpringLayout.WEST, panelGrafica);
		PanelPrincipal.add(rdGeneral);
		
		rdEspecifica = new JRadioButton("Vista Espec\u00EDfica");
		rdEspecifica.addActionListener(this);
		buttonGroup.add(rdEspecifica);
		
		sl_PanelPrincipal.putConstraint(SpringLayout.NORTH, rdEspecifica, 6, SpringLayout.SOUTH, panelGrafica);
		sl_PanelPrincipal.putConstraint(SpringLayout.WEST, rdEspecifica, 6, SpringLayout.EAST, rdGeneral);
		PanelPrincipal.add(rdEspecifica);
		
		Anterior = new JButton("Anterior");
		Anterior.addActionListener(this);
		sl_PanelPrincipal.putConstraint(SpringLayout.NORTH, Anterior, 6, SpringLayout.SOUTH, panelGrafica);
		sl_PanelPrincipal.putConstraint(SpringLayout.WEST, Anterior, 22, SpringLayout.EAST, rdEspecifica);
		PanelPrincipal.add(Anterior);
		
		Siguiente = new JButton("Siguiente");
		Siguiente.addActionListener(this);
		sl_PanelPrincipal.putConstraint(SpringLayout.NORTH, Siguiente, 6, SpringLayout.SOUTH, panelGrafica);
		sl_PanelPrincipal.putConstraint(SpringLayout.WEST, Siguiente, 22, SpringLayout.EAST, Anterior);
		PanelPrincipal.add(Siguiente);
		
		btnOk = new JButton("Ok");
		btnOk.addActionListener(this);
		sl_PanelPrincipal.putConstraint(SpringLayout.NORTH, btnOk, 6, SpringLayout.SOUTH, panelGrafica);
		sl_PanelPrincipal.putConstraint(SpringLayout.EAST, btnOk, 0, SpringLayout.EAST, panelGrafica);
		PanelPrincipal.add(btnOk);
		
		rdMaterialesPre = new JRadioButton("Materiales Precio");
		rdMaterialesPre.addActionListener(this);
		buttonGraficas.add(rdMaterialesPre);
		sl_PanelPrincipal.putConstraint(SpringLayout.NORTH, rdMaterialesPre, 6, SpringLayout.SOUTH, scrollPane);
		sl_PanelPrincipal.putConstraint(SpringLayout.EAST, rdMaterialesPre, -28, SpringLayout.WEST, rdGeneral);
		PanelPrincipal.add(rdMaterialesPre);
		
		rdMateriales = new JRadioButton("Materiales Producci\u00F3n");
		rdMateriales.addActionListener(this);
		buttonGraficas.add(rdMateriales);
		sl_PanelPrincipal.putConstraint(SpringLayout.NORTH, rdMateriales, 0, SpringLayout.NORTH, rdGeneral);
		sl_PanelPrincipal.putConstraint(SpringLayout.EAST, rdMateriales, -26, SpringLayout.WEST, rdMaterialesPre);
		PanelPrincipal.add(rdMateriales);
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==rdMateriales){
			opcion3=true;
			opcion4=false;
			titulo="Simulación de Generación de RSU";
			gentipo="Generación de RSU en Kilogramos";
		}
		if(e.getSource()==rdMaterialesPre){
			opcion4=true;
			opcion3=false;
			titulo="Simulación de Generación de Ingresos";
			gentipo="Generación de Ingresos en Pesos $";
		}
		if(e.getSource()==rdEspecifica){
			opcion2=true;
			opcion1=false;
		}
		if(e.getSource()==rdGeneral){
			opcion1=true;
			opcion2=false;
		}
		//Boton Anterior
		if(e.getSource()==Anterior){
			//Vista General Anterior
			if(opcion1==true){
				switch(op){
					case 1: {
						if(i==0){
							op=1;
						}else{
							op=4;
							i--;
						}
						try{
							informacion= sim.GraficaString(i);
							textArea.setText(informacion);
						}catch(Exception f){
							JOptionPane.showMessageDialog(null, "No existen datos para Mostrar.", "Error", JOptionPane.ERROR_MESSAGE);
						}
						panelGrafica.removeAll();
						panelGrafica.add(this.VistaGeneralA());
						panelGrafica.repaint();
						break;
					}
					case 2:{
						op--;
						panelGrafica.removeAll();
						panelGrafica.add(this.VistaGeneralA());
						panelGrafica.repaint();
						break;
					}
					case 3:{
						op--;
						panelGrafica.removeAll();
						panelGrafica.add(this.VistaGeneralA());
						panelGrafica.repaint();
						break;
					}
					case 4:{
						op--;
						panelGrafica.removeAll();
						panelGrafica.add(this.VistaGeneralA());
						panelGrafica.repaint();
						break;
					}				
				}
			}
			//Vista Especifica Anterior
			if(opcion2==true){
				switch(op2){
				case 1:{
					if(j==0){
						op2=1;
					}else{
						if(opcion4==true){
							op2=8;
						}else{
							op2=12;
						}
						j--;
					}
					try{
						informacion= sim.GraficaString(j);
						textArea.setText(informacion);
					}catch(Exception f){
						JOptionPane.showMessageDialog(null, "No existen datos para Mostrar.", "Error", JOptionPane.ERROR_MESSAGE);
					}
					panelGrafica.removeAll();
					panelGrafica.add(this.VistaEspecificaA());
					panelGrafica.repaint();
					break;
				}
				case 2:{
					op2--;
					panelGrafica.removeAll();
					panelGrafica.add(this.VistaEspecificaA());
					panelGrafica.repaint();
					break;
				}
				case 3:{
					op2--;
					panelGrafica.removeAll();
					panelGrafica.add(this.VistaEspecificaA());
					panelGrafica.repaint();
					break;
				}
				case 4:{
					op2--;
					panelGrafica.removeAll();
					panelGrafica.add(this.VistaEspecificaA());
					panelGrafica.repaint();
					break;
				}
				case 5:{
					op2--;
					panelGrafica.removeAll();
					panelGrafica.add(this.VistaEspecificaA());
					panelGrafica.repaint();
					break;
				}
				case 6:{
					op2--;
					panelGrafica.removeAll();
					panelGrafica.add(this.VistaEspecificaA());
					panelGrafica.repaint();
					break;
				}
				case 7:{
					op2--;
					panelGrafica.removeAll();
					panelGrafica.add(this.VistaEspecificaA());
					panelGrafica.repaint();
					break;
				}
				case 8:{
					op2--;
					panelGrafica.removeAll();
					panelGrafica.add(this.VistaEspecificaA());
					panelGrafica.repaint();
					break;
				}
				case 9:{
					op2--;
					panelGrafica.removeAll();
					panelGrafica.add(this.VistaEspecificaA());
					panelGrafica.repaint();
					break;
				}
				case 10:{
					op2--;
					panelGrafica.removeAll();
					panelGrafica.add(this.VistaEspecificaA());
					panelGrafica.repaint();
					break;
				}
				case 11:{
					op2--;
					panelGrafica.removeAll();
					panelGrafica.add(this.VistaEspecificaA());
					panelGrafica.repaint();
					//op2--;
					break;
				}
				case 12:{
					op2--;
					panelGrafica.removeAll();
					panelGrafica.add(this.VistaEspecificaA());
					panelGrafica.repaint();
					break;
				}
				
				}
			}
		}
		
		
		//Boton Siguiente
		if(e.getSource()==Siguiente){
			//Vista General Siguiente
			if(opcion1==true){
				switch(op){
				case 1:{
					op++;
					panelGrafica.removeAll();
					panelGrafica.add(this.VistaGeneralS());
					panelGrafica.repaint();
					break;
				}
				case 2:{
					op++;
					panelGrafica.removeAll();
					panelGrafica.add(this.VistaGeneralS());
					panelGrafica.repaint();
					break;
				}
				case 3:{
					op++;
					panelGrafica.removeAll();
					panelGrafica.add(this.VistaGeneralS());
					panelGrafica.repaint();
					break;
				}
				case 4:{
					if(i>=10){
						op=4;
					}else{
						op=1;
						i++;
					}
					try{
						informacion= sim.GraficaString(i);
						textArea.setText(informacion);
					}catch(Exception f){
						JOptionPane.showMessageDialog(null, "No existen datos para Mostrar.", "Error", JOptionPane.ERROR_MESSAGE);
					}
					panelGrafica.removeAll();
					panelGrafica.add(this.VistaGeneralS());
					panelGrafica.repaint();
					break;
				}				
			}
			}
			
			//Vista Especifica Siguiente
			if(opcion2==true){
				switch(op2){
				case 1:{
					op2++;
					panelGrafica.removeAll();
					panelGrafica.add(this.VistaEspecificaS());
					panelGrafica.repaint();
					break;
				}
				case 2:{
					op2++;
					panelGrafica.removeAll();
					panelGrafica.add(this.VistaEspecificaS());
					panelGrafica.repaint();
					break;
				}
				case 3:{
					op2++;
					panelGrafica.removeAll();
					panelGrafica.add(this.VistaEspecificaS());
					panelGrafica.repaint();
					break;
				}
				case 4:{
					op2++;
					panelGrafica.removeAll();
					panelGrafica.add(this.VistaEspecificaS());
					panelGrafica.repaint();
					break;
				}
				case 5:{
					op2++;
					panelGrafica.removeAll();
					panelGrafica.add(this.VistaEspecificaS());
					panelGrafica.repaint();
					break;
				}
				case 6:{
					op2++;
					panelGrafica.removeAll();
					panelGrafica.add(this.VistaEspecificaS());
					panelGrafica.repaint();
					break;
				}
				case 7:{
					op2++;
					panelGrafica.removeAll();
					panelGrafica.add(this.VistaEspecificaS());
					panelGrafica.repaint();
					break;
				}
				case 8:{
					if(opcion4=true){
						if(j>=10){
							op2=8;
						}else{
							op2=1;
							j++;
						}
						try{
							informacion= sim.GraficaString(j);
							textArea.setText(informacion);
						}catch(Exception f){
							JOptionPane.showMessageDialog(null, "No existen datos para Mostrar.", "Error", JOptionPane.ERROR_MESSAGE);
						}
					}else{
						op2++;
					}
					panelGrafica.removeAll();
					panelGrafica.add(this.VistaEspecificaS());
					panelGrafica.repaint();
					break;
				}
				case 9:{
					op2++;
					panelGrafica.removeAll();
					panelGrafica.add(this.VistaEspecificaS());
					panelGrafica.repaint();
					break;
				}
				case 10:{
					op2++;
					panelGrafica.removeAll();
					panelGrafica.add(this.VistaEspecificaS());
					panelGrafica.repaint();
					break;
				}
				case 11:{
					op2++;
					panelGrafica.removeAll();
					panelGrafica.add(this.VistaEspecificaS());
					panelGrafica.repaint();
					break;
				}
				case 12:{
					if(j>=10){
						op2=12;
					}else{
						op2=1;
						j++;
					}
					try{
						informacion= sim.GraficaString(j);
						textArea.setText(informacion);
					}catch(Exception f){
						JOptionPane.showMessageDialog(null, "No existen datos para Mostrar.", "Error", JOptionPane.ERROR_MESSAGE);
					}
					panelGrafica.removeAll();
					panelGrafica.add(this.VistaEspecificaS());
					panelGrafica.repaint();
					break;
				}
				}
			}
		}
		if(e.getSource()==btnOk){
			setVisible(false);
		}
	}
	
	/*Hay que tener en cuenta que siempre se deben de limpiar las variables
	 * para evitar que la informacion se traslape y no funcione adecuadamente.
	 */
	
	
	//Metodo Vista General Anterior
	public ChartPanel VistaGeneralA(){
		data = new DefaultCategoryDataset();
		
			try{
				//addValue(simre, Materiales, materiales)
				if(opcion3==true){
					if(op==1){
						//Produccion Diaria
						etiqueta="Diaria";
						data.addValue(sim.materiales[i].Resul1.getROrganico(),"DIARIO","Orgánico");
						data.addValue(sim.materiales[i].Resul1.getRSoplado(),"DIARIO","Soplado");
						data.addValue(sim.materiales[i].Resul1.getRPet(),"DIARIO","PET");
						data.addValue(sim.materiales[i].Resul1.getRCarton(),"DIARIO","Cartón");
						data.addValue(sim.materiales[i].Resul1.getRPapel(),"DIARIO","Papel");
						data.addValue(sim.materiales[i].Resul1.getRBoteLata(),"DIARIO","Bote de Lata");
						data.addValue(sim.materiales[i].Resul1.getRBoteAlum(),"DIARIO","Bote de Aluminio");
						data.addValue(sim.materiales[i].Resul1.getRLata(),"DIARIO","Lata");
						data.addValue(sim.materiales[i].Resul1.getRFierro(),"DIARIO","Fierro");
						data.addValue(sim.materiales[i].Resul1.getRMiscelaneo(),"DIARIO","Misceláneo");
						data.addValue(sim.materiales[i].Resul1.getRVidrio(),"DIARIO","Vidrio");
						data.addValue(sim.materiales[i].Resul1.getROtros(),"DIARIO","Otros");
						
					}
					
					if(op==2){
						//Produccion Semanal
						etiqueta="Semanal";
						data.addValue(sim.materiales[i].Resul2.getROrganico(),"SEMANAL","Orgánico");
						data.addValue(sim.materiales[i].Resul2.getRSoplado(),"SEMANAL","Soplado");
						data.addValue(sim.materiales[i].Resul2.getRPet(),"SEMANAL","PET");
						data.addValue(sim.materiales[i].Resul2.getRCarton(),"SEMANAL","Cartón");
						data.addValue(sim.materiales[i].Resul2.getRPapel(),"SEMANAL","Papel");
						data.addValue(sim.materiales[i].Resul2.getRBoteLata(),"SEMANAL","Bote de Lata");
						data.addValue(sim.materiales[i].Resul2.getRBoteAlum(),"SEMANAL","Bote de Aluminio");
						data.addValue(sim.materiales[i].Resul2.getRLata(),"SEMANAL","Lata");
						data.addValue(sim.materiales[i].Resul2.getRFierro(),"SEMANAL","Fierro");
						data.addValue(sim.materiales[i].Resul2.getRMiscelaneo(),"SEMANAL","Misceláneo");
						data.addValue(sim.materiales[i].Resul2.getRVidrio(),"SEMANAL","Vidrio");
						data.addValue(sim.materiales[i].Resul2.getROtros(),"SEMANAL","Otros");
					}
					
					
					if(op==3){
						//Produccion Mensual
						etiqueta="Mensual";
						data.addValue(sim.materiales[i].Resul3.getROrganico(),"MENSUAL","Orgánico");
						data.addValue(sim.materiales[i].Resul3.getRSoplado(),"MENSUAL","Soplado");
						data.addValue(sim.materiales[i].Resul3.getRPet(),"MENSUAL","PET");
						data.addValue(sim.materiales[i].Resul3.getRCarton(),"MENSUAL","Cartón");
						data.addValue(sim.materiales[i].Resul3.getRPapel(),"MENSUAL","Papel");
						data.addValue(sim.materiales[i].Resul3.getRBoteLata(),"MENSUAL","Bote de Lata");
						data.addValue(sim.materiales[i].Resul3.getRBoteAlum(),"MENSUAL","Bote de Aluminio");
						data.addValue(sim.materiales[i].Resul3.getRLata(),"MENSUAL","Lata");
						data.addValue(sim.materiales[i].Resul3.getRFierro(),"MENSUAL","Fierro");
						data.addValue(sim.materiales[i].Resul3.getRMiscelaneo(),"MENSUAL","Misceláneo");
						data.addValue(sim.materiales[i].Resul3.getRVidrio(),"MENSUAL","Vidrio");
						data.addValue(sim.materiales[i].Resul3.getROtros(),"MENSUAL","Otros");
					}
					
					
					if(op==4){
						//Produccion Anual
						etiqueta="Anual";
						data.addValue(sim.materiales[i].Resul4.getROrganico(),"ANUAL","Orgánico");
						data.addValue(sim.materiales[i].Resul4.getRSoplado(),"ANUAL","Soplado");
						data.addValue(sim.materiales[i].Resul4.getRPet(),"ANUAL","PET");
						data.addValue(sim.materiales[i].Resul4.getRCarton(),"ANUAL","Cartón");
						data.addValue(sim.materiales[i].Resul4.getRPapel(),"ANUAL","Papel");
						data.addValue(sim.materiales[i].Resul4.getRBoteLata(),"ANUAL","Bote de Lata");
						data.addValue(sim.materiales[i].Resul4.getRBoteAlum(),"ANUAL","Bote de Aluminio");
						data.addValue(sim.materiales[i].Resul4.getRLata(),"ANUAL","Lata");
						data.addValue(sim.materiales[i].Resul4.getRFierro(),"ANUAL","Fierro");
						data.addValue(sim.materiales[i].Resul4.getRMiscelaneo(),"ANUAL","Misceláneo");
						data.addValue(sim.materiales[i].Resul4.getRVidrio(),"ANUAL","Vidrio");
						data.addValue(sim.materiales[i].Resul4.getROtros(),"ANUAL","Otros");
					}
				}
				if(opcion4==true){
					if(op==1){
						//Produccion Diaria
						etiqueta="Diaria";
						data.addValue(sim.precio[i].Resul1.getRSoplado(),"DIARIO","Soplado");
						data.addValue(sim.precio[i].Resul1.getRPet(),"DIARIO","PET");
						data.addValue(sim.precio[i].Resul1.getRCarton(),"DIARIO","Cartón");
						data.addValue(sim.precio[i].Resul1.getRPapel(),"DIARIO","Papel");
						data.addValue(sim.precio[i].Resul1.getRBoteLata(),"DIARIO","Bote de Lata");
						data.addValue(sim.precio[i].Resul1.getRBoteAlum(),"DIARIO","Bote de Aluminio");
						data.addValue(sim.precio[i].Resul1.getRLata(),"DIARIO","Lata");
						data.addValue(sim.precio[i].Resul1.getRFierro(),"DIARIO","Fierro");
						
					}
					
					if(op==2){
						//Produccion Semanal
						etiqueta="Semanal";
						data.addValue(sim.precio[i].Resul2.getRSoplado(),"SEMANAL","Soplado");
						data.addValue(sim.precio[i].Resul2.getRPet(),"SEMANAL","PET");
						data.addValue(sim.precio[i].Resul2.getRCarton(),"SEMANAL","Cartón");
						data.addValue(sim.precio[i].Resul2.getRPapel(),"SEMANAL","Papel");
						data.addValue(sim.precio[i].Resul2.getRBoteLata(),"SEMANAL","Bote de Lata");
						data.addValue(sim.precio[i].Resul2.getRBoteAlum(),"SEMANAL","Bote de Aluminio");
						data.addValue(sim.precio[i].Resul2.getRLata(),"SEMANAL","Lata");
						data.addValue(sim.precio[i].Resul2.getRFierro(),"SEMANAL","Fierro");
					}
					
					
					if(op==3){
						//Produccion Mensual
						etiqueta="Mensual";
						data.addValue(sim.precio[i].Resul3.getRSoplado(),"MENSUAL","Soplado");
						data.addValue(sim.precio[i].Resul3.getRPet(),"MENSUAL","PET");
						data.addValue(sim.precio[i].Resul3.getRCarton(),"MENSUAL","Cartón");
						data.addValue(sim.precio[i].Resul3.getRPapel(),"MENSUAL","Papel");
						data.addValue(sim.precio[i].Resul3.getRBoteLata(),"MENSUAL","Bote de Lata");
						data.addValue(sim.precio[i].Resul3.getRBoteAlum(),"MENSUAL","Bote de Aluminio");
						data.addValue(sim.precio[i].Resul3.getRLata(),"MENSUAL","Lata");
						data.addValue(sim.precio[i].Resul3.getRFierro(),"MENSUAL","Fierro");
					
					}
					if(op==4){
						//Produccion Anual
						etiqueta="Anual";
						data.addValue(sim.precio[i].Resul4.getRSoplado(),"ANUAL","Soplado");
						data.addValue(sim.precio[i].Resul4.getRPet(),"ANUAL","PET");
						data.addValue(sim.precio[i].Resul4.getRCarton(),"ANUAL","Cartón");
						data.addValue(sim.precio[i].Resul4.getRPapel(),"ANUAL","Papel");
						data.addValue(sim.precio[i].Resul4.getRBoteLata(),"ANUAL","Bote de Lata");
						data.addValue(sim.precio[i].Resul4.getRBoteAlum(),"ANUAL","Bote de Aluminio");
						data.addValue(sim.precio[i].Resul4.getRLata(),"ANUAL","Lata");
						data.addValue(sim.precio[i].Resul4.getRFierro(),"ANUAL","Fierro");
					}
				}
			
			}catch(Exception g){
				JOptionPane.showMessageDialog(null, "No existen datos para graficar.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			}
		

		chart=null;
		chart = ChartFactory.createBarChart(titulo, "Materiales - Generación: "+etiqueta, gentipo, data, PlotOrientation.VERTICAL, false, true, false);	
		
		CategoryPlot plot = (CategoryPlot) chart.getPlot();
		plot.setDomainGridlinesVisible(true);
		
		final CategoryItemRenderer renderer = new CustomRenderer(
	            new Paint[] {Color.green,
	            	new Color(224,255,255),
	            	new Color(224,238,238),
	                new Color(184,134,11),
	                Color.white,
	                new Color(112,128,144),
	                new Color(211,211,211),
	                new Color(105,105,105),
	                new Color(190,190,190),
	                new Color(0,191,255),
	                new Color(0,250,154),
	                new Color(245,245,220)}
	        );
		
		plot.setRenderer(renderer);
		
		final CategoryAxis domainAxis = plot.getDomainAxis();
        domainAxis.setCategoryLabelPositions(
            CategoryLabelPositions.createUpRotationLabelPositions(Math.PI / 6.0)
        );
		Cpanel = new ChartPanel(chart);
		Cpanel.setBounds(5, 10, 800, 350);
		return Cpanel;
		
	}
	//Metodo Vista General Siguiente
	public ChartPanel VistaGeneralS(){
		data = new DefaultCategoryDataset();

			try{
				//addValue(simre, Materiales, materiales)
				if(opcion3==true){
					if(op==1){
						//Produccion Diaria
						etiqueta="Diaria";
						data.addValue(sim.materiales[i].Resul1.getROrganico(),"DIARIO","Orgánico");
						data.addValue(sim.materiales[i].Resul1.getRSoplado(),"DIARIO","Soplado");
						data.addValue(sim.materiales[i].Resul1.getRPet(),"DIARIO","PET");
						data.addValue(sim.materiales[i].Resul1.getRCarton(),"DIARIO","Cartón");
						data.addValue(sim.materiales[i].Resul1.getRPapel(),"DIARIO","Papel");
						data.addValue(sim.materiales[i].Resul1.getRBoteLata(),"DIARIO","Bote de Lata");
						data.addValue(sim.materiales[i].Resul1.getRBoteAlum(),"DIARIO","Bote de Aluminio");
						data.addValue(sim.materiales[i].Resul1.getRLata(),"DIARIO","Lata");
						data.addValue(sim.materiales[i].Resul1.getRFierro(),"DIARIO","Fierro");
						data.addValue(sim.materiales[i].Resul1.getRMiscelaneo(),"DIARIO","Misceláneo");
						data.addValue(sim.materiales[i].Resul1.getRVidrio(),"DIARIO","Vidrio");
						data.addValue(sim.materiales[i].Resul1.getROtros(),"DIARIO","Otros");
						
					}
					
					if(op==2){
						//Produccion Semanal
						etiqueta="Semanal";
						data.addValue(sim.materiales[i].Resul2.getROrganico(),"SEMANAL","Orgánico");
						data.addValue(sim.materiales[i].Resul2.getRSoplado(),"SEMANAL","Soplado");
						data.addValue(sim.materiales[i].Resul2.getRPet(),"SEMANAL","PET");
						data.addValue(sim.materiales[i].Resul2.getRCarton(),"SEMANAL","Cartón");
						data.addValue(sim.materiales[i].Resul2.getRPapel(),"SEMANAL","Papel");
						data.addValue(sim.materiales[i].Resul2.getRBoteLata(),"SEMANAL","Bote de Lata");
						data.addValue(sim.materiales[i].Resul2.getRBoteAlum(),"SEMANAL","Bote de Aluminio");
						data.addValue(sim.materiales[i].Resul2.getRLata(),"SEMANAL","Lata");
						data.addValue(sim.materiales[i].Resul2.getRFierro(),"SEMANAL","Fierro");
						data.addValue(sim.materiales[i].Resul2.getRMiscelaneo(),"SEMANAL","Misceláneo");
						data.addValue(sim.materiales[i].Resul2.getRVidrio(),"SEMANAL","Vidrio");
						data.addValue(sim.materiales[i].Resul2.getROtros(),"SEMANAL","Otros");
					}
					
					
					if(op==3){
						//Produccion Mensual
						etiqueta="Mensual";
						data.addValue(sim.materiales[i].Resul3.getROrganico(),"MENSUAL","Orgánico");
						data.addValue(sim.materiales[i].Resul3.getRSoplado(),"MENSUAL","Soplado");
						data.addValue(sim.materiales[i].Resul3.getRPet(),"MENSUAL","PET");
						data.addValue(sim.materiales[i].Resul3.getRCarton(),"MENSUAL","Cartón");
						data.addValue(sim.materiales[i].Resul3.getRPapel(),"MENSUAL","Papel");
						data.addValue(sim.materiales[i].Resul3.getRBoteLata(),"MENSUAL","Bote de Lata");
						data.addValue(sim.materiales[i].Resul3.getRBoteAlum(),"MENSUAL","Bote de Aluminio");
						data.addValue(sim.materiales[i].Resul3.getRLata(),"MENSUAL","Lata");
						data.addValue(sim.materiales[i].Resul3.getRFierro(),"MENSUAL","Fierro");
						data.addValue(sim.materiales[i].Resul3.getRMiscelaneo(),"MENSUAL","Misceláneo");
						data.addValue(sim.materiales[i].Resul3.getRVidrio(),"MENSUAL","Vidrio");
						data.addValue(sim.materiales[i].Resul3.getROtros(),"MENSUAL","Otros");
					}
					
					
					if(op==4){
						//Produccion Anual
						etiqueta="Anual";
						data.addValue(sim.materiales[i].Resul4.getROrganico(),"ANUAL","Orgánico");
						data.addValue(sim.materiales[i].Resul4.getRSoplado(),"ANUAL","Soplado");
						data.addValue(sim.materiales[i].Resul4.getRPet(),"ANUAL","PET");
						data.addValue(sim.materiales[i].Resul4.getRCarton(),"ANUAL","Cartón");
						data.addValue(sim.materiales[i].Resul4.getRPapel(),"ANUAL","Papel");
						data.addValue(sim.materiales[i].Resul4.getRBoteLata(),"ANUAL","Bote de Lata");
						data.addValue(sim.materiales[i].Resul4.getRBoteAlum(),"ANUAL","Bote de Aluminio");
						data.addValue(sim.materiales[i].Resul4.getRLata(),"ANUAL","Lata");
						data.addValue(sim.materiales[i].Resul4.getRFierro(),"ANUAL","Fierro");
						data.addValue(sim.materiales[i].Resul4.getRMiscelaneo(),"ANUAL","Misceláneo");
						data.addValue(sim.materiales[i].Resul4.getRVidrio(),"ANUAL","Vidrio");
						data.addValue(sim.materiales[i].Resul4.getROtros(),"ANUAL","Otros");
					}
				}
				if(opcion4==true){
					if(op==1){
						//Produccion Diaria
						etiqueta="Diaria";
						data.addValue(sim.precio[i].Resul1.getRSoplado(),"DIARIO","Soplado");
						data.addValue(sim.precio[i].Resul1.getRPet(),"DIARIO","PET");
						data.addValue(sim.precio[i].Resul1.getRCarton(),"DIARIO","Cartón");
						data.addValue(sim.precio[i].Resul1.getRPapel(),"DIARIO","Papel");
						data.addValue(sim.precio[i].Resul1.getRBoteLata(),"DIARIO","Bote de Lata");
						data.addValue(sim.precio[i].Resul1.getRBoteAlum(),"DIARIO","Bote de Aluminio");
						data.addValue(sim.precio[i].Resul1.getRLata(),"DIARIO","Lata");
						data.addValue(sim.precio[i].Resul1.getRFierro(),"DIARIO","Fierro");
						
					}
					
					if(op==2){
						//Produccion Semanal
						etiqueta="Semanal";
						data.addValue(sim.precio[i].Resul2.getRSoplado(),"SEMANAL","Soplado");
						data.addValue(sim.precio[i].Resul2.getRPet(),"SEMANAL","PET");
						data.addValue(sim.precio[i].Resul2.getRCarton(),"SEMANAL","Cartón");
						data.addValue(sim.precio[i].Resul2.getRPapel(),"SEMANAL","Papel");
						data.addValue(sim.precio[i].Resul2.getRBoteLata(),"SEMANAL","Bote de Lata");
						data.addValue(sim.precio[i].Resul2.getRBoteAlum(),"SEMANAL","Bote de Aluminio");
						data.addValue(sim.precio[i].Resul2.getRLata(),"SEMANAL","Lata");
						data.addValue(sim.precio[i].Resul2.getRFierro(),"SEMANAL","Fierro");
					}
					
					
					if(op==3){
						//Produccion Mensual
						etiqueta="Mensual";
						data.addValue(sim.precio[i].Resul3.getRSoplado(),"MENSUAL","Soplado");
						data.addValue(sim.precio[i].Resul3.getRPet(),"MENSUAL","PET");
						data.addValue(sim.precio[i].Resul3.getRCarton(),"MENSUAL","Cartón");
						data.addValue(sim.precio[i].Resul3.getRPapel(),"MENSUAL","Papel");
						data.addValue(sim.precio[i].Resul3.getRBoteLata(),"MENSUAL","Bote de Lata");
						data.addValue(sim.precio[i].Resul3.getRBoteAlum(),"MENSUAL","Bote de Aluminio");
						data.addValue(sim.precio[i].Resul3.getRLata(),"MENSUAL","Lata");
						data.addValue(sim.precio[i].Resul3.getRFierro(),"MENSUAL","Fierro");
					
					}
					if(op==4){
						//Produccion Anual
						etiqueta="Anual";
						data.addValue(sim.precio[i].Resul4.getRSoplado(),"ANUAL","Soplado");
						data.addValue(sim.precio[i].Resul4.getRPet(),"ANUAL","PET");
						data.addValue(sim.precio[i].Resul4.getRCarton(),"ANUAL","Cartón");
						data.addValue(sim.precio[i].Resul4.getRPapel(),"ANUAL","Papel");
						data.addValue(sim.precio[i].Resul4.getRBoteLata(),"ANUAL","Bote de Lata");
						data.addValue(sim.precio[i].Resul4.getRBoteAlum(),"ANUAL","Bote de Aluminio");
						data.addValue(sim.precio[i].Resul4.getRLata(),"ANUAL","Lata");
						data.addValue(sim.precio[i].Resul4.getRFierro(),"ANUAL","Fierro");
					}
				}
				
			
			}catch(Exception g){
				JOptionPane.showMessageDialog(null, "No existen datos para graficar.", "Error", JOptionPane.ERROR_MESSAGE);
			}
		
		
		chart=null;
		chart = ChartFactory.createBarChart(titulo, "Materiales - Generación: "+etiqueta, gentipo, data, PlotOrientation.VERTICAL, false, true, false);	
		
		CategoryPlot plot = (CategoryPlot) chart.getPlot();
		plot.setDomainGridlinesVisible(true);
		
		final CategoryItemRenderer renderer = new CustomRenderer(
	            new Paint[] {Color.green,
	            	new Color(224,255,255),
	            	new Color(224,238,238),
	                new Color(184,134,11),
	                Color.white,
	                new Color(112,128,144),
	                new Color(211,211,211),
	                new Color(105,105,105),
	                new Color(190,190,190),
	                new Color(0,191,255),
	                new Color(0,250,154),
	                new Color(245,245,220)}
	        );
		
		plot.setRenderer(renderer);
		
		final CategoryAxis domainAxis = plot.getDomainAxis();
        domainAxis.setCategoryLabelPositions(
            CategoryLabelPositions.createUpRotationLabelPositions(Math.PI / 6.0)
        );
		
		Cpanel = new ChartPanel(chart);
		Cpanel.setBounds(5, 10, 800, 350);
//		}
		return Cpanel;
		
	}

	
	
	//Metodo Vista Especifica Anterior
	public ChartPanel VistaEspecificaA(){
		data = new DefaultCategoryDataset();
			try{
				
				if(opcion3==true){
					if(op2==1){
						etiqueta="Orgánico - Generación";
						data.addValue(sim.materiales[j].Resul1.getROrganico(),"Diario", "Diario");
						data.addValue(sim.materiales[j].Resul2.getROrganico(),"Semanal", "Semanal");
						data.addValue(sim.materiales[j].Resul3.getROrganico(),"Mensual", "Mensual");
						data.addValue(sim.materiales[j].Resul4.getROrganico(),"Anual", "Anual");
					}
					if(op2==2){
						etiqueta="Plástico (Soplado) - Generación";
						data.addValue(sim.materiales[j].Resul1.getRSoplado(),"Diario", "Diario");
						data.addValue(sim.materiales[j].Resul2.getRSoplado(),"Semanal", "Semanal");
						data.addValue(sim.materiales[j].Resul3.getRSoplado(),"Mensual", "Mensual");
						data.addValue(sim.materiales[j].Resul4.getRSoplado(),"Anual", "Anual");
					}
					if(op2==3){
						etiqueta="Plástico (PET)- Generación";
						data.addValue(sim.materiales[j].Resul1.getRPet(),"Diario", "Diario");
						data.addValue(sim.materiales[j].Resul2.getRPet(),"Semanal", "Semanal");
						data.addValue(sim.materiales[j].Resul3.getRPet(),"Mensual", "Mensual");
						data.addValue(sim.materiales[j].Resul4.getRPet(),"Anual", "Anual");
					}
					if(op2==4){
						etiqueta="Cartón - Generación";
						data.addValue(sim.materiales[j].Resul1.getRCarton(),"Diario", "Diario");
						data.addValue(sim.materiales[j].Resul2.getRCarton(),"Semanal", "Semanal");
						data.addValue(sim.materiales[j].Resul3.getRCarton(),"Mensual", "Mensual");
						data.addValue(sim.materiales[j].Resul4.getRCarton(),"Anual", "Anual");
					}
					if(op2==5){
						etiqueta="Papel - Generación";
						data.addValue(sim.materiales[j].Resul1.getRPapel(),"Diario", "Diario");
						data.addValue(sim.materiales[j].Resul2.getRPapel(),"Semanal", "Semanal");
						data.addValue(sim.materiales[j].Resul3.getRPapel(),"Mensual", "Mensual");
						data.addValue(sim.materiales[j].Resul4.getRPapel(),"Anual", "Anual");
					}
					if(op2==6){
						etiqueta="Metal (Bote de Lata) - Generación";
						data.addValue(sim.materiales[j].Resul1.getRBoteLata(),"Diario", "Diario");
						data.addValue(sim.materiales[j].Resul2.getRBoteLata(),"Semanal", "Semanal");
						data.addValue(sim.materiales[j].Resul3.getRBoteLata(),"Mensual", "Mensual");
						data.addValue(sim.materiales[j].Resul4.getRBoteLata(),"Anual", "Anual");
					}
					if(op2==7){
						etiqueta="Metal (Bote de Aluminio) - Generación";
						data.addValue(sim.materiales[j].Resul1.getRBoteAlum(),"Diario", "Diario");
						data.addValue(sim.materiales[j].Resul2.getRBoteAlum(),"Semanal", "Semanal");
						data.addValue(sim.materiales[j].Resul3.getRBoteAlum(),"Mensual", "Mensual");
						data.addValue(sim.materiales[j].Resul4.getRBoteAlum(),"Anual", "Anual");
					}
					if(op2==8){
						etiqueta="Metal (Lata) - Generación";
						data.addValue(sim.materiales[j].Resul1.getRLata(),"Diario", "Diario");
						data.addValue(sim.materiales[j].Resul2.getRLata(),"Semanal", "Semanal");
						data.addValue(sim.materiales[j].Resul3.getRLata(),"Mensual", "Mensual");
						data.addValue(sim.materiales[j].Resul4.getRLata(),"Anual", "Anual");
					}
					if(op2==9){
						etiqueta="Metal (Fierro Corto) - Gneración";
						data.addValue(sim.materiales[j].Resul1.getRFierro(),"Diario", "Diario");
						data.addValue(sim.materiales[j].Resul2.getRFierro(),"Semanal", "Semanal");
						data.addValue(sim.materiales[j].Resul3.getRFierro(),"Mensual", "Mensual");
						data.addValue(sim.materiales[j].Resul4.getRFierro(),"Anual", "Anual");
					}
					if(op2==10){
						etiqueta="Misceláneo - Generación";
						data.addValue(sim.materiales[j].Resul1.getRMiscelaneo(),"Diario", "Diario");
						data.addValue(sim.materiales[j].Resul2.getRMiscelaneo(),"Semanal", "Semanal");
						data.addValue(sim.materiales[j].Resul3.getRMiscelaneo(),"Mensual", "Mensual");
						data.addValue(sim.materiales[j].Resul4.getRMiscelaneo(),"Anual", "Anual");
					}
					if(op2==11){
						etiqueta="Vidrio - Generación";
						data.addValue(sim.materiales[j].Resul1.getRVidrio(),"Diario", "Diario");
						data.addValue(sim.materiales[j].Resul2.getRVidrio(),"Semanal", "Semanal");
						data.addValue(sim.materiales[j].Resul3.getRVidrio(),"Mensual", "Mensual");
						data.addValue(sim.materiales[j].Resul4.getRVidrio(),"Anual", "Anual");
					}
					if(op2==12){
						etiqueta="Otros - Generación";
						data.addValue(sim.materiales[j].Resul1.getROtros(),"Diario", "Diario");
						data.addValue(sim.materiales[j].Resul2.getROtros(),"Semanal", "Semanal");
						data.addValue(sim.materiales[j].Resul3.getROtros(),"Mensual", "Mensual");
						data.addValue(sim.materiales[j].Resul4.getROtros(),"Anual", "Anual");
					}
				}
				
				
				if(opcion4==true){
					if(op2==1){
						etiqueta="Plástico (Soplado) - Generación";
						data.addValue(sim.materiales[j].Resul1.getRSoplado(),"Diario", "Diario");
						data.addValue(sim.materiales[j].Resul2.getRSoplado(),"Semanal", "Semanal");
						data.addValue(sim.materiales[j].Resul3.getRSoplado(),"Mensual", "Mensual");
						data.addValue(sim.materiales[j].Resul4.getRSoplado(),"Anual", "Anual");
					}
					if(op2==2){
						etiqueta="Plástico (PET)- Generación";
						data.addValue(sim.materiales[j].Resul1.getRPet(),"Diario", "Diario");
						data.addValue(sim.materiales[j].Resul2.getRPet(),"Semanal", "Semanal");
						data.addValue(sim.materiales[j].Resul3.getRPet(),"Mensual", "Mensual");
						data.addValue(sim.materiales[j].Resul4.getRPet(),"Anual", "Anual");
					}
					if(op2==3){
						etiqueta="Cartón - Generación";
						data.addValue(sim.materiales[j].Resul1.getRCarton(),"Diario", "Diario");
						data.addValue(sim.materiales[j].Resul2.getRCarton(),"Semanal", "Semanal");
						data.addValue(sim.materiales[j].Resul3.getRCarton(),"Mensual", "Mensual");
						data.addValue(sim.materiales[j].Resul4.getRCarton(),"Anual", "Anual");
					}
					if(op2==4){
						etiqueta="Papel - Generación";
						data.addValue(sim.materiales[j].Resul1.getRPapel(),"Diario", "Diario");
						data.addValue(sim.materiales[j].Resul2.getRPapel(),"Semanal", "Semanal");
						data.addValue(sim.materiales[j].Resul3.getRPapel(),"Mensual", "Mensual");
						data.addValue(sim.materiales[j].Resul4.getRPapel(),"Anual", "Anual");
					}
					if(op2==5){
						etiqueta="Metal (Bote de Lata) - Generación";
						data.addValue(sim.materiales[j].Resul1.getRBoteLata(),"Diario", "Diario");
						data.addValue(sim.materiales[j].Resul2.getRBoteLata(),"Semanal", "Semanal");
						data.addValue(sim.materiales[j].Resul3.getRBoteLata(),"Mensual", "Mensual");
						data.addValue(sim.materiales[j].Resul4.getRBoteLata(),"Anual", "Anual");
					}
					if(op2==6){
						etiqueta="Metal (Bote de Aluminio) - Generación";
						data.addValue(sim.materiales[j].Resul1.getRBoteAlum(),"Diario", "Diario");
						data.addValue(sim.materiales[j].Resul2.getRBoteAlum(),"Semanal", "Semanal");
						data.addValue(sim.materiales[j].Resul3.getRBoteAlum(),"Mensual", "Mensual");
						data.addValue(sim.materiales[j].Resul4.getRBoteAlum(),"Anual", "Anual");
					}
					if(op2==7){
						etiqueta="Metal (Lata) - Generación";
						data.addValue(sim.materiales[j].Resul1.getRLata(),"Diario", "Diario");
						data.addValue(sim.materiales[j].Resul2.getRLata(),"Semanal", "Semanal");
						data.addValue(sim.materiales[j].Resul3.getRLata(),"Mensual", "Mensual");
						data.addValue(sim.materiales[j].Resul4.getRLata(),"Anual", "Anual");
					}
					if(op2==8){
						etiqueta="Metal (Fierro Corto) - Generación";
						data.addValue(sim.materiales[j].Resul1.getRFierro(),"Diario", "Diario");
						data.addValue(sim.materiales[j].Resul2.getRFierro(),"Semanal", "Semanal");
						data.addValue(sim.materiales[j].Resul3.getRFierro(),"Mensual", "Mensual");
						data.addValue(sim.materiales[j].Resul4.getRFierro(),"Anual", "Anual");
					}
				}	
				
			}catch(Exception f){
				JOptionPane.showMessageDialog(null, "No existen datos para graficar.", "Error", JOptionPane.ERROR_MESSAGE);
			}
			
		chart=null;
		chart = ChartFactory.createBarChart(titulo, etiqueta, gentipo, data, PlotOrientation.VERTICAL, true, true, true);
		
		CategoryPlot plot = (CategoryPlot) chart.getPlot();
		plot.setDomainGridlinesVisible(true);
		
		final CategoryItemRenderer renderer = new CustomRenderer(
	            new Paint[] {Color.red, Color.blue,new Color(224,255,255),
	                Color.yellow}
	        );
		plot.setRenderer(renderer);
		
		
		Cpanel = new ChartPanel(chart);
		Cpanel.setBounds(5, 10, 410, 350);
		return Cpanel;
	}
	
	//Metodo Vista Especifica Siguiente
	public ChartPanel VistaEspecificaS(){
		data = new DefaultCategoryDataset();
			try{
				if(opcion3==true){
					if(op2==1){
						etiqueta="Orgánico - Generación";
						data.addValue(sim.materiales[j].Resul1.getROrganico(),"Diario", "Diario");
						data.addValue(sim.materiales[j].Resul2.getROrganico(),"Semanal", "Semanal");
						data.addValue(sim.materiales[j].Resul3.getROrganico(),"Mensual", "Mensual");
						data.addValue(sim.materiales[j].Resul4.getROrganico(),"Anual", "Anual");
					}
					if(op2==2){
						etiqueta="Plástico (Sopládo) - Generación";
						data.addValue(sim.materiales[j].Resul1.getRSoplado(),"Diario", "Diario");
						data.addValue(sim.materiales[j].Resul2.getRSoplado(),"Semanal", "Semanal");
						data.addValue(sim.materiales[j].Resul3.getRSoplado(),"Mensual", "Mensual");
						data.addValue(sim.materiales[j].Resul4.getRSoplado(),"Anual", "Anual");
					}
					if(op2==3){
						etiqueta="Plástico (PET) - Generación";
						data.addValue(sim.materiales[j].Resul1.getRPet(),"Diario", "Diario");
						data.addValue(sim.materiales[j].Resul2.getRPet(),"Semanal", "Semanal");
						data.addValue(sim.materiales[j].Resul3.getRPet(),"Mensual", "Mensual");
						data.addValue(sim.materiales[j].Resul4.getRPet(),"Anual", "Anual");
					}
					if(op2==4){
						etiqueta="Cartón - Generación";
						data.addValue(sim.materiales[j].Resul1.getRCarton(),"Diario", "Diario");
						data.addValue(sim.materiales[j].Resul2.getRCarton(),"Semanal", "Semanal");
						data.addValue(sim.materiales[j].Resul3.getRCarton(),"Mensual", "Mensual");
						data.addValue(sim.materiales[j].Resul4.getRCarton(),"Anual", "Anual");
					}
					if(op2==5){
						etiqueta="Papel  - Generación";
						data.addValue(sim.materiales[j].Resul1.getRPapel(),"Diario", "Diario");
						data.addValue(sim.materiales[j].Resul2.getRPapel(),"Semanal", "Semanal");
						data.addValue(sim.materiales[j].Resul3.getRPapel(),"Mensual", "Mensual");
						data.addValue(sim.materiales[j].Resul4.getRPapel(),"Anual", "Anual");
					}
					if(op2==6){
						etiqueta="Metal (Bote de Lata)  - Generación";
						data.addValue(sim.materiales[j].Resul1.getRBoteLata(),"Diario", "Diario");
						data.addValue(sim.materiales[j].Resul2.getRBoteLata(),"Semanal", "Semanal");
						data.addValue(sim.materiales[j].Resul3.getRBoteLata(),"Mensual", "Mensual");
						data.addValue(sim.materiales[j].Resul4.getRBoteLata(),"Anual", "Anual");
					}
					if(op2==7){
						etiqueta="Metal (Bote de Aluminio)  - Generación";
						data.addValue(sim.materiales[j].Resul1.getRBoteAlum(),"Diario", "Diario");
						data.addValue(sim.materiales[j].Resul2.getRBoteAlum(),"Semanal", "Semanal");
						data.addValue(sim.materiales[j].Resul3.getRBoteAlum(),"Mensual", "Mensual");
						data.addValue(sim.materiales[j].Resul4.getRBoteAlum(),"Anual", "Anual");
					}
					if(op2==8){
						etiqueta="Metal (Lata)  - Generación";
						data.addValue(sim.materiales[j].Resul1.getRLata(),"Diario", "Diario");
						data.addValue(sim.materiales[j].Resul2.getRLata(),"Semanal", "Semanal");
						data.addValue(sim.materiales[j].Resul3.getRLata(),"Mensual", "Mensual");
						data.addValue(sim.materiales[j].Resul4.getRLata(),"Anual", "Anual");
					}
					if(op2==9){
						etiqueta="Metal (Fierro Corto)  - Generación";
						data.addValue(sim.materiales[j].Resul1.getRFierro(),"Diario", "Diario");
						data.addValue(sim.materiales[j].Resul2.getRFierro(),"Semanal", "Semanal");
						data.addValue(sim.materiales[j].Resul3.getRFierro(),"Mensual", "Mensual");
						data.addValue(sim.materiales[j].Resul4.getRFierro(),"Anual", "Anual");
					}
					if(op2==10){
						etiqueta="Misceláneo - Generación";
						data.addValue(sim.materiales[j].Resul1.getRMiscelaneo(),"Diario", "Diario");
						data.addValue(sim.materiales[j].Resul2.getRMiscelaneo(),"Semanal", "Semanal");
						data.addValue(sim.materiales[j].Resul3.getRMiscelaneo(),"Mensual", "Mensual");
						data.addValue(sim.materiales[j].Resul4.getRMiscelaneo(),"Anual", "Anual");
					}
					if(op2==11){
						etiqueta="Tetrapack y Vidrio  - Generación";
						data.addValue(sim.materiales[j].Resul1.getRVidrio(),"Diario", "Diario");
						data.addValue(sim.materiales[j].Resul2.getRVidrio(),"Semanal", "Semanal");
						data.addValue(sim.materiales[j].Resul3.getRVidrio(),"Mensual", "Mensual");
						data.addValue(sim.materiales[j].Resul4.getRVidrio(),"Anual", "Anual");
					}
					if(op2==12){
						etiqueta="Otros  - Generación";
						data.addValue(sim.materiales[j].Resul1.getROtros(),"Diario", "Diario");
						data.addValue(sim.materiales[j].Resul2.getROtros(),"Semanal", "Semanal");
						data.addValue(sim.materiales[j].Resul3.getROtros(),"Mensual", "Mensual");
						data.addValue(sim.materiales[j].Resul4.getROtros(),"Anual", "Anual");
					}
				}
				
				
				if(opcion4==true){
					if(op2==1){
						etiqueta="Plástico (Sopládo) - Generación";
						data.addValue(sim.materiales[j].Resul1.getRSoplado(),"Diario", "Diario");
						data.addValue(sim.materiales[j].Resul2.getRSoplado(),"Semanal", "Semanal");
						data.addValue(sim.materiales[j].Resul3.getRSoplado(),"Mensual", "Mensual");
						data.addValue(sim.materiales[j].Resul4.getRSoplado(),"Anual", "Anual");
					}
					if(op2==2){
						etiqueta="Plástico (PET) - Generación";
						data.addValue(sim.materiales[j].Resul1.getRPet(),"Diario", "Diario");
						data.addValue(sim.materiales[j].Resul2.getRPet(),"Semanal", "Semanal");
						data.addValue(sim.materiales[j].Resul3.getRPet(),"Mensual", "Mensual");
						data.addValue(sim.materiales[j].Resul4.getRPet(),"Anual", "Anual");
					}
					if(op2==3){
						etiqueta="Cartón - Generación";
						data.addValue(sim.materiales[j].Resul1.getRCarton(),"Diario", "Diario");
						data.addValue(sim.materiales[j].Resul2.getRCarton(),"Semanal", "Semanal");
						data.addValue(sim.materiales[j].Resul3.getRCarton(),"Mensual", "Mensual");
						data.addValue(sim.materiales[j].Resul4.getRCarton(),"Anual", "Anual");
					}
					if(op2==4){
						etiqueta="Papel  - Generación";
						data.addValue(sim.materiales[j].Resul1.getRPapel(),"Diario", "Diario");
						data.addValue(sim.materiales[j].Resul2.getRPapel(),"Semanal", "Semanal");
						data.addValue(sim.materiales[j].Resul3.getRPapel(),"Mensual", "Mensual");
						data.addValue(sim.materiales[j].Resul4.getRPapel(),"Anual", "Anual");
					}
					if(op2==5){
						etiqueta="Metal (Bote de Lata)  - Generación";
						data.addValue(sim.materiales[j].Resul1.getRBoteLata(),"Diario", "Diario");
						data.addValue(sim.materiales[j].Resul2.getRBoteLata(),"Semanal", "Semanal");
						data.addValue(sim.materiales[j].Resul3.getRBoteLata(),"Mensual", "Mensual");
						data.addValue(sim.materiales[j].Resul4.getRBoteLata(),"Anual", "Anual");
					}
					if(op2==6){
						etiqueta="Metal (Bote de Aluminio)  - Generación";
						data.addValue(sim.materiales[j].Resul1.getRBoteAlum(),"Diario", "Diario");
						data.addValue(sim.materiales[j].Resul2.getRBoteAlum(),"Semanal", "Semanal");
						data.addValue(sim.materiales[j].Resul3.getRBoteAlum(),"Mensual", "Mensual");
						data.addValue(sim.materiales[j].Resul4.getRBoteAlum(),"Anual", "Anual");
					}
					if(op2==7){
						etiqueta="Metal (Lata)  - Generación";
						data.addValue(sim.materiales[j].Resul1.getRLata(),"Diario", "Diario");
						data.addValue(sim.materiales[j].Resul2.getRLata(),"Semanal", "Semanal");
						data.addValue(sim.materiales[j].Resul3.getRLata(),"Mensual", "Mensual");
						data.addValue(sim.materiales[j].Resul4.getRLata(),"Anual", "Anual");
					}
					if(op2==8){
						etiqueta="Metal (Fierro Corto)  - Generación";
						data.addValue(sim.materiales[j].Resul1.getRFierro(),"Diario", "Diario");
						data.addValue(sim.materiales[j].Resul2.getRFierro(),"Semanal", "Semanal");
						data.addValue(sim.materiales[j].Resul3.getRFierro(),"Mensual", "Mensual");
						data.addValue(sim.materiales[j].Resul4.getRFierro(),"Anual", "Anual");
						
					}
				}
				
			}catch(Exception f){
				JOptionPane.showMessageDialog(null, "No existen datos para graficar.", "Error", JOptionPane.ERROR_MESSAGE);
			}
			
		
		chart=null;
		chart = ChartFactory.createBarChart(titulo, etiqueta, gentipo, data, PlotOrientation.VERTICAL, true, true, true);
		CategoryPlot plot = (CategoryPlot) chart.getPlot();
		plot.setDomainGridlinesVisible(true);
		
		final CategoryItemRenderer renderer = new CustomRenderer(
	            new Paint[] {Color.red, Color.blue,new Color(224,255,255),
	                Color.yellow}
	        );
		plot.setRenderer(renderer);
		
		Cpanel = new ChartPanel(chart);
		Cpanel.setBounds(5, 10, 410, 350);
		return Cpanel;
	}

	//Clase para poder modificar el color de las barras de la Grafica
	class CustomRenderer extends BarRenderer {

	        /** The colors. */
	        private Paint[] colors;

	        /**
	         * Creates a new renderer.
	         *
	         * @param colors  the colors.
	         */
	        public CustomRenderer(final Paint[] colors) {
	            this.colors = colors;
	        }

	        /**
	         * Returns the paint for an item.  Overrides the default behaviour inherited from
	         * AbstractSeriesRenderer.
	         *
	         * @param row  the series.
	         * @param column  the category.
	         *
	         * @return The item color.
	         */
	        public Paint getItemPaint(final int row, final int column) {
	            return this.colors[column % this.colors.length];
	        }
	 }
}
