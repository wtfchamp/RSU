import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTable.PrintMode;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.SpringLayout;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.Toolkit;
import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.util.*;


public class SimResultado extends JDialog implements ActionListener{

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private Simulacion sim;
	private int i=0;
	private String informacion;
	private JButton btnAnterior;
	private JButton btnSiguiente;
	private JTextArea textArea;
	private JButton btnImprimir;
	private JButton btnOk;


	public SimResultado(Simulacion simulacion) {
		setTitle("Tabla de Resultados de la Simulaci\u00F3n");
		setIconImage(Toolkit.getDefaultToolkit().getImage(SimResultado.class.getResource("/Iconos/Symbol - Check.png")));
		setModal(true);
		setBounds(100, 100, 1025, 465);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		SpringLayout sl_contentPanel = new SpringLayout();
		contentPanel.setLayout(sl_contentPanel);
		
		sim= simulacion;
		
		JScrollPane scrollText = new JScrollPane();
		sl_contentPanel.putConstraint(SpringLayout.NORTH, scrollText, 10, SpringLayout.NORTH, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.WEST, scrollText, 10, SpringLayout.WEST, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.SOUTH, scrollText, 83, SpringLayout.NORTH, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.EAST, scrollText, -11, SpringLayout.EAST, contentPanel);
		contentPanel.add(scrollText);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		scrollText.setViewportView(textArea);
		
		JScrollPane scrollTabla = new JScrollPane();
		sl_contentPanel.putConstraint(SpringLayout.NORTH, scrollTabla, 6, SpringLayout.SOUTH, scrollText);
		sl_contentPanel.putConstraint(SpringLayout.WEST, scrollTabla, 10, SpringLayout.WEST, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.SOUTH, scrollTabla, -45, SpringLayout.SOUTH, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.EAST, scrollTabla, 0, SpringLayout.EAST, scrollText);
		contentPanel.add(scrollTabla);
		table = new JTable();
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"Diario", "", null, null, "", null, null, null, "", null, null, null, null, null},
				{"Semanal", null, null, null, null, null, null, null, null, null, null, null, null, null},
				{"Mensual", null, null, null, null, null, null, null, null, null, null, null, null, null},
				{"Anual", null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{"Dinero generado con promedio ", "", null, null, null, null, null, null, null, null, null, null, null, ""},
				{"Diario", null, null, null, null, null, null, null, null, null, null, null, null, null},
				{"Semanal", null, null, null, null, null, null, null, null, null, null, null, null, null},
				{"Mensual", null, null, null, null, null, null, null, null, null, null, null, null, null},
				{"Anual", null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"Generaci\u00F3n RSU con promedio", "Org\u00E1nico", "Pl\u00E1stico (Sopl\u00E1do)", "Pl\u00E1stico (PET)", "Cart\u00F3n", "Papel", "Metal (Bote Lata)", "Metal (Bote Aluminio)", "Metal (Lata)", "Metal (Fierro Corto)", "Miscel\u00E1neo", "Tetrapack y Vidrio", "Otros", "Total"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false, false, false, false, false, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(184);
		table.getColumnModel().getColumn(2).setPreferredWidth(116);
		table.getColumnModel().getColumn(3).setPreferredWidth(103);
		table.getColumnModel().getColumn(6).setPreferredWidth(122);
		table.getColumnModel().getColumn(7).setPreferredWidth(137);
		table.getColumnModel().getColumn(8).setPreferredWidth(97);
		table.getColumnModel().getColumn(9).setPreferredWidth(126);
		table.getColumnModel().getColumn(10).setPreferredWidth(97);
		table.getColumnModel().getColumn(11).setPreferredWidth(123);
		table.getColumnModel().getColumn(13).setPreferredWidth(114);
		scrollTabla.setViewportView(table);
		
		btnAnterior = new JButton("Anterior");
		btnAnterior.addActionListener(this);
		sl_contentPanel.putConstraint(SpringLayout.WEST, btnAnterior, 324, SpringLayout.WEST, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.SOUTH, btnAnterior, -10, SpringLayout.SOUTH, contentPanel);
		contentPanel.add(btnAnterior);
		
		btnSiguiente = new JButton("Siguiente");
		btnSiguiente.addActionListener(this);
		sl_contentPanel.putConstraint(SpringLayout.NORTH, btnSiguiente, 0, SpringLayout.NORTH, btnAnterior);
		sl_contentPanel.putConstraint(SpringLayout.WEST, btnSiguiente, 203, SpringLayout.EAST, btnAnterior);
		contentPanel.add(btnSiguiente);
		
		btnImprimir = new JButton("Imprimir");
		btnImprimir.addActionListener(this);
		sl_contentPanel.putConstraint(SpringLayout.SOUTH, btnImprimir, 0, SpringLayout.SOUTH, btnAnterior);
		sl_contentPanel.putConstraint(SpringLayout.EAST, btnImprimir, -10, SpringLayout.EAST, contentPanel);
		contentPanel.add(btnImprimir);
		
		btnOk = new JButton("Ok");
		btnOk.addActionListener(this);
		sl_contentPanel.putConstraint(SpringLayout.NORTH, btnOk, 0, SpringLayout.NORTH, btnAnterior);
		sl_contentPanel.putConstraint(SpringLayout.WEST, btnOk, 10, SpringLayout.WEST, contentPanel);
		contentPanel.add(btnOk);
	}
	
public void actionPerformed(ActionEvent e){
		if(e.getSource()==btnAnterior){
			if(i>=0){
				i--;
				if(i<0){
					i=0;
				}
				try{
					informacion= sim.TablaString(i);
					textArea.setText(informacion);
					DecimalFormat formato = new DecimalFormat("###,##0.00");
					//Resultados de la simulacion, RSU generado diariamente
					table.setValueAt(formato.format(sim.materiales[i].Resul1.getROrganico())+" kg", 0, 1);
					table.setValueAt(formato.format(sim.materiales[i].Resul1.getRSoplado())+" kg", 0, 2);
					table.setValueAt(formato.format(sim.materiales[i].Resul1.getRPet())+" kg", 0, 3);
					table.setValueAt(formato.format(sim.materiales[i].Resul1.getRCarton())+" kg", 0, 4);
					table.setValueAt(formato.format(sim.materiales[i].Resul1.getRPapel())+" kg", 0, 5);
					table.setValueAt(formato.format(sim.materiales[i].Resul1.getRBoteLata())+" kg", 0, 6);
					table.setValueAt(formato.format(sim.materiales[i].Resul1.getRBoteAlum())+" kg", 0, 7);
					table.setValueAt(formato.format(sim.materiales[i].Resul1.getRLata())+" kg", 0, 8);
					table.setValueAt(formato.format(sim.materiales[i].Resul1.getRFierro())+" kg", 0, 9);
					table.setValueAt(formato.format(sim.materiales[i].Resul1.getRMiscelaneo())+" kg", 0, 10);
					table.setValueAt(formato.format(sim.materiales[i].Resul1.getRVidrio())+" kg", 0, 11);
					table.setValueAt(formato.format(sim.materiales[i].Resul1.getROtros())+" kg", 0, 12);
					table.setValueAt(formato.format(sim.materiales[i].Resul1.getROrganico()+sim.materiales[i].Resul1.getRSoplado()+
													sim.materiales[i].Resul1.getRPet()+sim.materiales[i].Resul1.getRCarton()+
													sim.materiales[i].Resul1.getRPapel()+sim.materiales[i].Resul1.getRBoteLata()+
													sim.materiales[i].Resul1.getRBoteAlum()+sim.materiales[i].Resul1.getRLata()+
													sim.materiales[i].Resul1.getRFierro()+sim.materiales[i].Resul1.getRMiscelaneo()+
													sim.materiales[i].Resul1.getRVidrio()+sim.materiales[i].Resul1.getROtros())+" kg", 0, 13);
					//RSU generado semanalmente/////////////////////////////////////////////
					table.setValueAt(formato.format(sim.materiales[i].Resul2.getROrganico())+" kg", 1, 1);
					table.setValueAt(formato.format(sim.materiales[i].Resul2.getRSoplado())+" kg", 1, 2);
					table.setValueAt(formato.format(sim.materiales[i].Resul2.getRPet())+" kg", 1, 3);
					table.setValueAt(formato.format(sim.materiales[i].Resul2.getRCarton())+" kg", 1, 4);
					table.setValueAt(formato.format(sim.materiales[i].Resul2.getRPapel())+" kg", 1, 5);
					table.setValueAt(formato.format(sim.materiales[i].Resul2.getRBoteLata())+" kg", 1, 6);
					table.setValueAt(formato.format(sim.materiales[i].Resul2.getRBoteAlum())+" kg", 1, 7);
					table.setValueAt(formato.format(sim.materiales[i].Resul2.getRLata())+" kg", 1, 8);
					table.setValueAt(formato.format(sim.materiales[i].Resul2.getRFierro())+" kg", 1, 9);
					table.setValueAt(formato.format(sim.materiales[i].Resul2.getRMiscelaneo())+" kg", 1, 10);
					table.setValueAt(formato.format(sim.materiales[i].Resul2.getRVidrio())+" kg", 1, 11);
					table.setValueAt(formato.format(sim.materiales[i].Resul2.getROtros())+" kg", 1, 12);
					table.setValueAt(formato.format(sim.materiales[i].Resul2.getROrganico()+sim.materiales[i].Resul2.getRSoplado()+
													sim.materiales[i].Resul2.getRPet()+sim.materiales[i].Resul2.getRCarton()+
													sim.materiales[i].Resul2.getRPapel()+sim.materiales[i].Resul2.getRBoteLata()+
													sim.materiales[i].Resul2.getRBoteAlum()+sim.materiales[i].Resul2.getRLata()+
													sim.materiales[i].Resul2.getRFierro()+sim.materiales[i].Resul2.getRMiscelaneo()+
													sim.materiales[i].Resul2.getRVidrio()+sim.materiales[i].Resul2.getROtros())+" kg", 1, 13);
					//RSU generado mensualmente////////////////////////////////////////////
					table.setValueAt(formato.format(sim.materiales[i].Resul3.getROrganico())+" kg", 2, 1);
					table.setValueAt(formato.format(sim.materiales[i].Resul3.getRSoplado())+" kg", 2, 2);
					table.setValueAt(formato.format(sim.materiales[i].Resul3.getRPet())+" kg", 2, 3);
					table.setValueAt(formato.format(sim.materiales[i].Resul3.getRCarton())+" kg", 2, 4);
					table.setValueAt(formato.format(sim.materiales[i].Resul3.getRPapel())+" kg", 2, 5);
					table.setValueAt(formato.format(sim.materiales[i].Resul3.getRBoteLata())+" kg", 2, 6);
					table.setValueAt(formato.format(sim.materiales[i].Resul3.getRBoteAlum())+" kg", 2, 7);
					table.setValueAt(formato.format(sim.materiales[i].Resul3.getRLata())+" kg", 2, 8);
					table.setValueAt(formato.format(sim.materiales[i].Resul3.getRFierro())+" kg", 2, 9);
					table.setValueAt(formato.format(sim.materiales[i].Resul3.getRMiscelaneo())+" kg", 2, 10);
					table.setValueAt(formato.format(sim.materiales[i].Resul3.getRVidrio())+" kg", 2, 11);
					table.setValueAt(formato.format(sim.materiales[i].Resul3.getROtros())+" kg", 2, 12);
					table.setValueAt(formato.format(sim.materiales[i].Resul3.getROrganico()+sim.materiales[i].Resul3.getRSoplado()+
													sim.materiales[i].Resul3.getRPet()+sim.materiales[i].Resul3.getRCarton()+
													sim.materiales[i].Resul3.getRPapel()+sim.materiales[i].Resul3.getRBoteLata()+
													sim.materiales[i].Resul3.getRBoteAlum()+sim.materiales[i].Resul3.getRLata()+
													sim.materiales[i].Resul3.getRFierro()+sim.materiales[i].Resul3.getRMiscelaneo()+
													sim.materiales[i].Resul3.getRVidrio()+sim.materiales[i].Resul3.getROtros())+" kg", 2, 13);
					//RSU generado anualmente//////////////////////////////////////////////
					table.setValueAt(formato.format(sim.materiales[i].Resul4.getROrganico())+" kg", 3, 1);
					table.setValueAt(formato.format(sim.materiales[i].Resul4.getRSoplado())+" kg", 3, 2);
					table.setValueAt(formato.format(sim.materiales[i].Resul4.getRPet())+" kg", 3, 3);
					table.setValueAt(formato.format(sim.materiales[i].Resul4.getRCarton())+" kg", 3, 4);
					table.setValueAt(formato.format(sim.materiales[i].Resul4.getRPapel())+" kg", 3, 5);
					table.setValueAt(formato.format(sim.materiales[i].Resul4.getRBoteLata())+" kg", 3, 6);
					table.setValueAt(formato.format(sim.materiales[i].Resul4.getRBoteAlum())+" kg", 3, 7);
					table.setValueAt(formato.format(sim.materiales[i].Resul4.getRLata())+" kg", 3, 8);
					table.setValueAt(formato.format(sim.materiales[i].Resul4.getRFierro())+" kg", 3, 9);
					table.setValueAt(formato.format(sim.materiales[i].Resul4.getRMiscelaneo())+" kg", 3, 10);
					table.setValueAt(formato.format(sim.materiales[i].Resul4.getRVidrio())+" kg", 3, 11);
					table.setValueAt(formato.format(sim.materiales[i].Resul4.getROtros())+" kg", 3, 12);
					table.setValueAt(formato.format(sim.materiales[i].Resul4.getROrganico()+sim.materiales[i].Resul4.getRSoplado()+
													sim.materiales[i].Resul4.getRPet()+sim.materiales[i].Resul4.getRCarton()+
													sim.materiales[i].Resul4.getRPapel()+sim.materiales[i].Resul4.getRBoteLata()+
													sim.materiales[i].Resul4.getRBoteAlum()+sim.materiales[i].Resul4.getRLata()+
													sim.materiales[i].Resul4.getRFierro()+sim.materiales[i].Resul4.getRMiscelaneo()+
													sim.materiales[i].Resul4.getRVidrio()+sim.materiales[i].Resul4.getROtros())+" kg", 3, 13);
					///////////////////////////////////////////////////////////////////////
					//Dinero Generado por RSU diariamente
					//////////////////////////////////////////////////////////////////////					
					table.setValueAt("$ "+formato.format(sim.precio[i].Resul1.getROrganico()), 7, 1);
					table.setValueAt("$ "+formato.format(sim.precio[i].Resul1.getRSoplado()), 7, 2);
					table.setValueAt("$ "+formato.format(sim.precio[i].Resul1.getRPet()), 7, 3);
					table.setValueAt("$ "+formato.format(sim.precio[i].Resul1.getRCarton()), 7, 4);
					table.setValueAt("$ "+formato.format(sim.precio[i].Resul1.getRPapel()), 7, 5);
					table.setValueAt("$ "+formato.format(sim.precio[i].Resul1.getRBoteLata()), 7, 6);
					table.setValueAt("$ "+formato.format(sim.precio[i].Resul1.getRBoteAlum()), 7, 7);
					table.setValueAt("$ "+formato.format(sim.precio[i].Resul1.getRLata()), 7, 8);
					table.setValueAt("$ "+formato.format(sim.precio[i].Resul1.getRFierro()), 7, 9);
					table.setValueAt("$ "+formato.format(sim.precio[i].Resul1.getRMiscelaneo()), 7, 10);
					table.setValueAt("$ "+formato.format(sim.precio[i].Resul1.getRVidrio()), 7, 11);
					table.setValueAt("$ "+formato.format(sim.precio[i].Resul1.getROtros()), 7, 12);
					table.setValueAt("$ "+formato.format(sim.precio[i].Resul1.getROrganico()+sim.precio[i].Resul1.getRSoplado()+
														sim.precio[i].Resul1.getRPet()+sim.precio[i].Resul1.getRCarton()+
														sim.precio[i].Resul1.getRPapel()+sim.precio[i].Resul1.getRBoteLata()+
														sim.precio[i].Resul1.getRBoteAlum()+sim.precio[i].Resul1.getRLata()+
														sim.precio[i].Resul1.getRFierro()+sim.precio[i].Resul1.getRMiscelaneo()+
														sim.precio[i].Resul1.getRVidrio()+sim.precio[i].Resul1.getROtros()), 7, 13);
					//RSU generado semanalmente///////////////////////////////////////////////
					table.setValueAt("$ "+formato.format(sim.precio[i].Resul2.getROrganico()), 8, 1);
					table.setValueAt("$ "+formato.format(sim.precio[i].Resul2.getRSoplado()), 8, 2);
					table.setValueAt("$ "+formato.format(sim.precio[i].Resul2.getRPet()), 8, 3);
					table.setValueAt("$ "+formato.format(sim.precio[i].Resul2.getRCarton()), 8, 4);
					table.setValueAt("$ "+formato.format(sim.precio[i].Resul2.getRPapel()), 8, 5);
					table.setValueAt("$ "+formato.format(sim.precio[i].Resul2.getRBoteLata()), 8, 6);
					table.setValueAt("$ "+formato.format(sim.precio[i].Resul2.getRBoteAlum()), 8, 7);
					table.setValueAt("$ "+formato.format(sim.precio[i].Resul2.getRLata()), 8, 8);
					table.setValueAt("$ "+formato.format(sim.precio[i].Resul2.getRFierro()), 8, 9);
					table.setValueAt("$ "+formato.format(sim.precio[i].Resul2.getRMiscelaneo()), 8, 10);
					table.setValueAt("$ "+formato.format(sim.precio[i].Resul2.getRVidrio()), 8, 11);
					table.setValueAt("$ "+formato.format(sim.precio[i].Resul2.getROtros()), 8, 12);
					table.setValueAt("$ "+formato.format(sim.precio[i].Resul2.getROrganico()+sim.precio[i].Resul2.getRSoplado()+
														sim.precio[i].Resul2.getRPet()+sim.precio[i].Resul2.getRCarton()+
														sim.precio[i].Resul2.getRPapel()+sim.precio[i].Resul2.getRBoteLata()+
														sim.precio[i].Resul2.getRBoteAlum()+sim.precio[i].Resul2.getRLata()+
														sim.precio[i].Resul2.getRFierro()+sim.precio[i].Resul2.getRMiscelaneo()+
														sim.precio[i].Resul2.getRVidrio()+sim.precio[i].Resul2.getROtros()), 8, 13);
					//RSU generado mensualmente////////////////////////////////////////////////
					table.setValueAt("$ "+formato.format(sim.precio[i].Resul3.getROrganico()), 9, 1);
					table.setValueAt("$ "+formato.format(sim.precio[i].Resul3.getRSoplado()), 9, 2);
					table.setValueAt("$ "+formato.format(sim.precio[i].Resul3.getRPet()), 9, 3);
					table.setValueAt("$ "+formato.format(sim.precio[i].Resul3.getRCarton()), 9, 4);
					table.setValueAt("$ "+formato.format(sim.precio[i].Resul3.getRPapel()), 9, 5);
					table.setValueAt("$ "+formato.format(sim.precio[i].Resul3.getRBoteLata()), 9, 6);
					table.setValueAt("$ "+formato.format(sim.precio[i].Resul3.getRBoteAlum()), 9, 7);
					table.setValueAt("$ "+formato.format(sim.precio[i].Resul3.getRLata()), 9, 8);
					table.setValueAt("$ "+formato.format(sim.precio[i].Resul3.getRFierro()), 9, 9);
					table.setValueAt("$ "+formato.format(sim.precio[i].Resul3.getRMiscelaneo()), 9, 10);
					table.setValueAt("$ "+formato.format(sim.precio[i].Resul3.getRVidrio()), 9, 11);
					table.setValueAt("$ "+formato.format(sim.precio[i].Resul3.getROtros()), 9, 12);
					table.setValueAt("$ "+formato.format(sim.precio[i].Resul3.getROrganico()+sim.precio[i].Resul3.getRSoplado()+
														sim.precio[i].Resul3.getRPet()+sim.precio[i].Resul3.getRCarton()+
														sim.precio[i].Resul3.getRPapel()+sim.precio[i].Resul3.getRBoteLata()+
														sim.precio[i].Resul3.getRBoteAlum()+sim.precio[i].Resul3.getRLata()+
														sim.precio[i].Resul3.getRFierro()+sim.precio[i].Resul3.getRMiscelaneo()+
														sim.precio[i].Resul3.getRVidrio()+sim.precio[i].Resul3.getROtros()), 9, 13);
					//RSU generado anualmente////////////////////////////////////////////////
					table.setValueAt("$ "+formato.format(sim.precio[i].Resul4.getROrganico()), 10, 1);
					table.setValueAt("$ "+formato.format(sim.precio[i].Resul4.getRSoplado()), 10, 2);
					table.setValueAt("$ "+formato.format(sim.precio[i].Resul4.getRPet()), 10, 3);
					table.setValueAt("$ "+formato.format(sim.precio[i].Resul4.getRCarton()), 10, 4);
					table.setValueAt("$ "+formato.format(sim.precio[i].Resul4.getRPapel()), 10, 5);
					table.setValueAt("$ "+formato.format(sim.precio[i].Resul4.getRBoteLata()), 10, 6);
					table.setValueAt("$ "+formato.format(sim.precio[i].Resul4.getRBoteAlum()), 10, 7);
					table.setValueAt("$ "+formato.format(sim.precio[i].Resul4.getRLata()), 10, 8);
					table.setValueAt("$ "+formato.format(sim.precio[i].Resul4.getRFierro()), 10, 9);
					table.setValueAt("$ "+formato.format(sim.precio[i].Resul4.getRMiscelaneo()), 10, 10);
					table.setValueAt("$ "+formato.format(sim.precio[i].Resul4.getRVidrio()), 10, 11);
					table.setValueAt("$ "+formato.format(sim.precio[i].Resul4.getROtros()), 10, 12);
					table.setValueAt("$ "+formato.format(sim.precio[i].Resul4.getROrganico()+sim.precio[i].Resul4.getRSoplado()+
														sim.precio[i].Resul4.getRPet()+sim.precio[i].Resul4.getRCarton()+
														sim.precio[i].Resul4.getRPapel()+sim.precio[i].Resul4.getRBoteLata()+
														sim.precio[i].Resul4.getRBoteAlum()+sim.precio[i].Resul4.getRLata()+
														sim.precio[i].Resul4.getRFierro()+sim.precio[i].Resul4.getRMiscelaneo()+
														sim.precio[i].Resul4.getRVidrio()+sim.precio[i].Resul4.getROtros()), 10, 13);
					////////////////////////////////////////////////////////////////////////////
				}catch(Exception c){
					JOptionPane.showMessageDialog(null, "No existen datos para mostrar en la tabla.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
					System.out.println("error "+c.getMessage());
				}
			}
			else{
				JOptionPane.showMessageDialog(null, "No hay más datos que mostrar", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			}	
		}
		if(e.getSource()==btnSiguiente){
			if(i<10){
				try{
					i++;
					if(i>=10){
						i=9;
					}
					informacion= sim.TablaString(i);
					textArea.setText(informacion);
					DecimalFormat formato = new DecimalFormat("###,##0.00");
					//Resultados de la simulacion, RSU generado diariamente
					table.setValueAt(formato.format(sim.materiales[i].Resul1.getROrganico())+" kg", 0, 1);
					table.setValueAt(formato.format(sim.materiales[i].Resul1.getRSoplado())+" kg", 0, 2);
					table.setValueAt(formato.format(sim.materiales[i].Resul1.getRPet())+" kg", 0, 3);
					table.setValueAt(formato.format(sim.materiales[i].Resul1.getRCarton())+" kg", 0, 4);
					table.setValueAt(formato.format(sim.materiales[i].Resul1.getRPapel())+" kg", 0, 5);
					table.setValueAt(formato.format(sim.materiales[i].Resul1.getRBoteLata())+" kg", 0, 6);
					table.setValueAt(formato.format(sim.materiales[i].Resul1.getRBoteAlum())+" kg", 0, 7);
					table.setValueAt(formato.format(sim.materiales[i].Resul1.getRLata())+" kg", 0, 8);
					table.setValueAt(formato.format(sim.materiales[i].Resul1.getRFierro())+" kg", 0, 9);
					table.setValueAt(formato.format(sim.materiales[i].Resul1.getRMiscelaneo())+" kg", 0, 10);
					table.setValueAt(formato.format(sim.materiales[i].Resul1.getRVidrio())+" kg", 0, 11);
					table.setValueAt(formato.format(sim.materiales[i].Resul1.getROtros())+" kg", 0, 12);
					table.setValueAt(formato.format(sim.materiales[i].Resul1.getROrganico()+sim.materiales[i].Resul1.getRSoplado()+
													sim.materiales[i].Resul1.getRPet()+sim.materiales[i].Resul1.getRCarton()+
													sim.materiales[i].Resul1.getRPapel()+sim.materiales[i].Resul1.getRBoteLata()+
													sim.materiales[i].Resul1.getRBoteAlum()+sim.materiales[i].Resul1.getRLata()+
													sim.materiales[i].Resul1.getRFierro()+sim.materiales[i].Resul1.getRMiscelaneo()+
													sim.materiales[i].Resul1.getRVidrio()+sim.materiales[i].Resul1.getROtros())+" kg", 0, 13);
					//RSU generado semanalmente/////////////////////////////////////////////
					table.setValueAt(formato.format(sim.materiales[i].Resul2.getROrganico())+" kg", 1, 1);
					table.setValueAt(formato.format(sim.materiales[i].Resul2.getRSoplado())+" kg", 1, 2);
					table.setValueAt(formato.format(sim.materiales[i].Resul2.getRPet())+" kg", 1, 3);
					table.setValueAt(formato.format(sim.materiales[i].Resul2.getRCarton())+" kg", 1, 4);
					table.setValueAt(formato.format(sim.materiales[i].Resul2.getRPapel())+" kg", 1, 5);
					table.setValueAt(formato.format(sim.materiales[i].Resul2.getRBoteLata())+" kg", 1, 6);
					table.setValueAt(formato.format(sim.materiales[i].Resul2.getRBoteAlum())+" kg", 1, 7);
					table.setValueAt(formato.format(sim.materiales[i].Resul2.getRLata())+" kg", 1, 8);
					table.setValueAt(formato.format(sim.materiales[i].Resul2.getRFierro())+" kg", 1, 9);
					table.setValueAt(formato.format(sim.materiales[i].Resul2.getRMiscelaneo())+" kg", 1, 10);
					table.setValueAt(formato.format(sim.materiales[i].Resul2.getRVidrio())+" kg", 1, 11);
					table.setValueAt(formato.format(sim.materiales[i].Resul2.getROtros())+" kg", 1, 12);
					table.setValueAt(formato.format(sim.materiales[i].Resul2.getROrganico()+sim.materiales[i].Resul2.getRSoplado()+
													sim.materiales[i].Resul2.getRPet()+sim.materiales[i].Resul2.getRCarton()+
													sim.materiales[i].Resul2.getRPapel()+sim.materiales[i].Resul2.getRBoteLata()+
													sim.materiales[i].Resul2.getRBoteAlum()+sim.materiales[i].Resul2.getRLata()+
													sim.materiales[i].Resul2.getRFierro()+sim.materiales[i].Resul2.getRMiscelaneo()+
													sim.materiales[i].Resul2.getRVidrio()+sim.materiales[i].Resul2.getROtros())+" kg", 1, 13);
					//RSU generado mensualmente////////////////////////////////////////////
					table.setValueAt(formato.format(sim.materiales[i].Resul3.getROrganico())+" kg", 2, 1);
					table.setValueAt(formato.format(sim.materiales[i].Resul3.getRSoplado())+" kg", 2, 2);
					table.setValueAt(formato.format(sim.materiales[i].Resul3.getRPet())+" kg", 2, 3);
					table.setValueAt(formato.format(sim.materiales[i].Resul3.getRCarton())+" kg", 2, 4);
					table.setValueAt(formato.format(sim.materiales[i].Resul3.getRPapel())+" kg", 2, 5);
					table.setValueAt(formato.format(sim.materiales[i].Resul3.getRBoteLata())+" kg", 2, 6);
					table.setValueAt(formato.format(sim.materiales[i].Resul3.getRBoteAlum())+" kg", 2, 7);
					table.setValueAt(formato.format(sim.materiales[i].Resul3.getRLata())+" kg", 2, 8);
					table.setValueAt(formato.format(sim.materiales[i].Resul3.getRFierro())+" kg", 2, 9);
					table.setValueAt(formato.format(sim.materiales[i].Resul3.getRMiscelaneo())+" kg", 2, 10);
					table.setValueAt(formato.format(sim.materiales[i].Resul3.getRVidrio())+" kg", 2, 11);
					table.setValueAt(formato.format(sim.materiales[i].Resul3.getROtros())+" kg", 2, 12);
					table.setValueAt(formato.format(sim.materiales[i].Resul3.getROrganico()+sim.materiales[i].Resul3.getRSoplado()+
													sim.materiales[i].Resul3.getRPet()+sim.materiales[i].Resul3.getRCarton()+
													sim.materiales[i].Resul3.getRPapel()+sim.materiales[i].Resul3.getRBoteLata()+
													sim.materiales[i].Resul3.getRBoteAlum()+sim.materiales[i].Resul3.getRLata()+
													sim.materiales[i].Resul3.getRFierro()+sim.materiales[i].Resul3.getRMiscelaneo()+
													sim.materiales[i].Resul3.getRVidrio()+sim.materiales[i].Resul3.getROtros())+" kg", 2, 12);
					//RSU generado anualmente//////////////////////////////////////////////
					table.setValueAt(formato.format(sim.materiales[i].Resul4.getROrganico())+" kg", 3, 1);
					table.setValueAt(formato.format(sim.materiales[i].Resul4.getRSoplado())+" kg", 3, 2);
					table.setValueAt(formato.format(sim.materiales[i].Resul4.getRPet())+" kg", 3, 3);
					table.setValueAt(formato.format(sim.materiales[i].Resul4.getRCarton())+" kg", 3, 4);
					table.setValueAt(formato.format(sim.materiales[i].Resul4.getRPapel())+" kg", 3, 5);
					table.setValueAt(formato.format(sim.materiales[i].Resul4.getRBoteLata())+" kg", 3, 6);
					table.setValueAt(formato.format(sim.materiales[i].Resul4.getRBoteAlum())+" kg", 3, 7);
					table.setValueAt(formato.format(sim.materiales[i].Resul4.getRLata())+" kg", 3, 8);
					table.setValueAt(formato.format(sim.materiales[i].Resul4.getRFierro())+" kg", 3, 9);
					table.setValueAt(formato.format(sim.materiales[i].Resul4.getRMiscelaneo())+" kg", 3, 10);
					table.setValueAt(formato.format(sim.materiales[i].Resul4.getRVidrio())+" kg", 3, 11);
					table.setValueAt(formato.format(sim.materiales[i].Resul4.getROtros())+" kg", 3, 12);
					table.setValueAt(formato.format(sim.materiales[i].Resul4.getROrganico()+sim.materiales[i].Resul4.getRSoplado()+
													sim.materiales[i].Resul4.getRPet()+sim.materiales[i].Resul4.getRCarton()+
													sim.materiales[i].Resul4.getRPapel()+sim.materiales[i].Resul4.getRBoteLata()+
													sim.materiales[i].Resul4.getRBoteAlum()+sim.materiales[i].Resul4.getRLata()+
													sim.materiales[i].Resul4.getRFierro()+sim.materiales[i].Resul4.getRMiscelaneo()+
													sim.materiales[i].Resul4.getRVidrio()+sim.materiales[i].Resul4.getROtros())+" kg", 3, 13);
					///////////////////////////////////////////////////////////////////////
					//Dinero Generado por RSU diariamente
					//////////////////////////////////////////////////////////////////////					
					table.setValueAt("$ "+formato.format(sim.precio[i].Resul1.getROrganico()), 7, 1);
					table.setValueAt("$ "+formato.format(sim.precio[i].Resul1.getRSoplado()), 7, 2);
					table.setValueAt("$ "+formato.format(sim.precio[i].Resul1.getRPet()), 7, 3);
					table.setValueAt("$ "+formato.format(sim.precio[i].Resul1.getRCarton()), 7, 4);
					table.setValueAt("$ "+formato.format(sim.precio[i].Resul1.getRPapel()), 7, 5);
					table.setValueAt("$ "+formato.format(sim.precio[i].Resul1.getRBoteLata()), 7, 6);
					table.setValueAt("$ "+formato.format(sim.precio[i].Resul1.getRBoteAlum()), 7, 7);
					table.setValueAt("$ "+formato.format(sim.precio[i].Resul1.getRLata()), 7, 8);
					table.setValueAt("$ "+formato.format(sim.precio[i].Resul1.getRFierro()), 7, 9);
					table.setValueAt("$ "+formato.format(sim.precio[i].Resul1.getRMiscelaneo()), 7, 10);
					table.setValueAt("$ "+formato.format(sim.precio[i].Resul1.getRVidrio()), 7, 11);
					table.setValueAt("$ "+formato.format(sim.precio[i].Resul1.getROtros()), 7, 12);
					table.setValueAt("$ "+formato.format(sim.precio[i].Resul1.getROrganico()+sim.precio[i].Resul1.getRSoplado()+
										 				sim.precio[i].Resul1.getRPet()+sim.precio[i].Resul1.getRCarton()+
														sim.precio[i].Resul1.getRPapel()+sim.precio[i].Resul1.getRBoteLata()+
														sim.precio[i].Resul1.getRBoteAlum()+sim.precio[i].Resul1.getRLata()+
														sim.precio[i].Resul1.getRFierro()+sim.precio[i].Resul1.getRMiscelaneo()+
														sim.precio[i].Resul1.getRVidrio()+sim.precio[i].Resul1.getROtros()), 7, 13);
					//RSU generado semanalmente///////////////////////////////////////////////
					table.setValueAt("$ "+formato.format(sim.precio[i].Resul2.getROrganico()), 8, 1);
					table.setValueAt("$ "+formato.format(sim.precio[i].Resul2.getRSoplado()), 8, 2);
					table.setValueAt("$ "+formato.format(sim.precio[i].Resul2.getRPet()), 8, 3);
					table.setValueAt("$ "+formato.format(sim.precio[i].Resul2.getRCarton()), 8, 4);
					table.setValueAt("$ "+formato.format(sim.precio[i].Resul2.getRPapel()), 7, 5);
					table.setValueAt("$ "+formato.format(sim.precio[i].Resul2.getRBoteLata()), 8, 6);
					table.setValueAt("$ "+formato.format(sim.precio[i].Resul2.getRBoteAlum()), 8, 7);
					table.setValueAt("$ "+formato.format(sim.precio[i].Resul2.getRLata()), 8, 8);
					table.setValueAt("$ "+formato.format(sim.precio[i].Resul2.getRFierro()), 8, 9);
					table.setValueAt("$ "+formato.format(sim.precio[i].Resul2.getRMiscelaneo()), 8, 10);
					table.setValueAt("$ "+formato.format(sim.precio[i].Resul2.getRVidrio()), 8, 11);
					table.setValueAt("$ "+formato.format(sim.precio[i].Resul2.getROtros()), 8, 12);
					table.setValueAt("$ "+formato.format(sim.precio[i].Resul2.getROrganico()+sim.precio[i].Resul2.getRSoplado()+
														sim.precio[i].Resul2.getRPet()+sim.precio[i].Resul2.getRCarton()+
														sim.precio[i].Resul2.getRPapel()+sim.precio[i].Resul2.getRBoteLata()+
														sim.precio[i].Resul2.getRBoteAlum()+sim.precio[i].Resul2.getRLata()+
														sim.precio[i].Resul2.getRFierro()+sim.precio[i].Resul2.getRMiscelaneo()+
														sim.precio[i].Resul2.getRVidrio()+sim.precio[i].Resul2.getROtros()), 8, 13);
					//RSU generado mensualmente////////////////////////////////////////////////
					table.setValueAt("$ "+formato.format(sim.precio[i].Resul3.getROrganico()), 9, 1);
					table.setValueAt("$ "+formato.format(sim.precio[i].Resul3.getRSoplado()), 9, 2);
					table.setValueAt("$ "+formato.format(sim.precio[i].Resul3.getRPet()), 9, 3);
					table.setValueAt("$ "+formato.format(sim.precio[i].Resul3.getRCarton()), 9, 4);
					table.setValueAt("$ "+formato.format(sim.precio[i].Resul3.getRPapel()), 9, 5);
					table.setValueAt("$ "+formato.format(sim.precio[i].Resul3.getRBoteLata()), 9, 6);
					table.setValueAt("$ "+formato.format(sim.precio[i].Resul3.getRBoteAlum()), 9, 7);
					table.setValueAt("$ "+formato.format(sim.precio[i].Resul3.getRLata()), 9, 8);
					table.setValueAt("$ "+formato.format(sim.precio[i].Resul3.getRFierro()), 9, 9);
					table.setValueAt("$ "+formato.format(sim.precio[i].Resul3.getRMiscelaneo()), 9, 10);
					table.setValueAt("$ "+formato.format(sim.precio[i].Resul3.getRVidrio()), 9, 11);
					table.setValueAt("$ "+formato.format(sim.precio[i].Resul3.getROtros()), 9, 12);
					table.setValueAt("$ "+formato.format(sim.precio[i].Resul3.getROrganico()+sim.precio[i].Resul3.getRSoplado()+
														sim.precio[i].Resul3.getRPet()+sim.precio[i].Resul3.getRCarton()+
														sim.precio[i].Resul3.getRPapel()+sim.precio[i].Resul3.getRBoteLata()+
														sim.precio[i].Resul3.getRBoteAlum()+sim.precio[i].Resul3.getRLata()+
														sim.precio[i].Resul3.getRFierro()+sim.precio[i].Resul3.getRMiscelaneo()+
														sim.precio[i].Resul3.getRVidrio()+sim.precio[i].Resul3.getROtros()), 9, 13);
					//RSU generado anualmente////////////////////////////////////////////////
					table.setValueAt("$ "+formato.format(sim.precio[i].Resul4.getROrganico()), 10, 1);
					table.setValueAt("$ "+formato.format(sim.precio[i].Resul4.getRSoplado()), 10, 2);
					table.setValueAt("$ "+formato.format(sim.precio[i].Resul4.getRPet()), 10, 3);
					table.setValueAt("$ "+formato.format(sim.precio[i].Resul4.getRCarton()), 10, 4);
					table.setValueAt("$ "+formato.format(sim.precio[i].Resul4.getRPapel()), 10, 5);
					table.setValueAt("$ "+formato.format(sim.precio[i].Resul4.getRBoteLata()), 10, 6);
					table.setValueAt("$ "+formato.format(sim.precio[i].Resul4.getRBoteAlum()), 10, 7);
					table.setValueAt("$ "+formato.format(sim.precio[i].Resul4.getRLata()), 10, 8);
					table.setValueAt("$ "+formato.format(sim.precio[i].Resul4.getRFierro()), 10, 9);
					table.setValueAt("$ "+formato.format(sim.precio[i].Resul4.getRMiscelaneo()), 10, 10);
					table.setValueAt("$ "+formato.format(sim.precio[i].Resul4.getRVidrio()), 10, 11);
					table.setValueAt("$ "+formato.format(sim.precio[i].Resul4.getROtros()), 10, 12);
					table.setValueAt("$ "+formato.format(sim.precio[i].Resul4.getROrganico()+sim.precio[i].Resul4.getRSoplado()+
														sim.precio[i].Resul4.getRPet()+sim.precio[i].Resul4.getRCarton()+
														sim.precio[i].Resul4.getRPapel()+sim.precio[i].Resul4.getRBoteLata()+
														sim.precio[i].Resul4.getRBoteAlum()+sim.precio[i].Resul4.getRLata()+
														sim.precio[i].Resul4.getRFierro()+sim.precio[i].Resul4.getRMiscelaneo()+
														sim.precio[i].Resul4.getRVidrio()+sim.precio[i].Resul4.getROtros()), 10, 13);
					////////////////////////////////////////////////////////////////////////////
				}catch(Exception c){
					JOptionPane.showMessageDialog(null, "No existen datos para mostrar en la tabla.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
					
				}
			}
			else{
				JOptionPane.showMessageDialog(null, "No hay más datos que mostrar", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		
		if(e.getSource()==btnImprimir){
			try { 
          	  // tabla1.print();//envia los datos de la tabla a la impresora
          	  MessageFormat headerFormat = new MessageFormat("Tabla de Resultados de la U. Habitacional: "+sim.lugares[i].getFracc());
          	  MessageFormat footerFormat = new MessageFormat(new GregorianCalendar().get(Calendar.DAY_OF_MONTH)+"/"+new GregorianCalendar().get(Calendar.MONTH)+"/"+ new GregorianCalendar().get(Calendar.YEAR));
          	  table.print(PrintMode.FIT_WIDTH, headerFormat, footerFormat);
            }catch (PrinterException ex) {
          	  	JOptionPane.showMessageDialog(null, "No se ha podido imprimir correctamente, intentalo más tarde.");
            }catch(Exception r){
            	JOptionPane.showMessageDialog(null, "No existen datos para imprimir.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            }
		}
		
		if(e.getSource()==btnOk){
			setVisible(false);
		}
		
	}	

public void setTexto(){
	try{
		informacion= sim.TablaString(0);
		textArea.setText(informacion);
		DecimalFormat formato = new DecimalFormat("###,##0.00");
		table.setValueAt(formato.format(sim.materiales[0].Resul1.getROrganico())+" kg", 0, 1);
		table.setValueAt(formato.format(sim.materiales[0].Resul1.getRSoplado())+" kg", 0, 2);
		table.setValueAt(formato.format(sim.materiales[0].Resul1.getRPet())+" kg", 0, 3);
		table.setValueAt(formato.format(sim.materiales[0].Resul1.getRCarton())+" kg", 0, 4);
		table.setValueAt(formato.format(sim.materiales[0].Resul1.getRPapel())+" kg", 0, 5);
		table.setValueAt(formato.format(sim.materiales[0].Resul1.getRBoteLata())+" kg", 0, 6);
		table.setValueAt(formato.format(sim.materiales[0].Resul1.getRBoteAlum())+" kg", 0, 7);
		table.setValueAt(formato.format(sim.materiales[0].Resul1.getRLata())+" kg", 0, 8);
		table.setValueAt(formato.format(sim.materiales[0].Resul1.getRFierro())+" kg", 0, 9);
		table.setValueAt(formato.format(sim.materiales[0].Resul1.getRMiscelaneo())+" kg", 0, 10);
		table.setValueAt(formato.format(sim.materiales[0].Resul1.getRVidrio())+" kg", 0, 11);
		table.setValueAt(formato.format(sim.materiales[0].Resul1.getROtros())+" kg", 0, 12);
		table.setValueAt(formato.format(sim.materiales[0].Resul1.getROrganico()+sim.materiales[0].Resul1.getRSoplado()+
										sim.materiales[0].Resul1.getRPet()+sim.materiales[0].Resul1.getRCarton()+
										sim.materiales[0].Resul1.getRPapel()+sim.materiales[0].Resul1.getRBoteLata()+
										sim.materiales[0].Resul1.getRBoteAlum()+sim.materiales[0].Resul1.getRLata()+
										sim.materiales[0].Resul1.getRFierro()+sim.materiales[0].Resul1.getRMiscelaneo()+
										sim.materiales[0].Resul1.getRVidrio()+sim.materiales[0].Resul1.getROtros())+" kg", 0, 13);
		//RSU generado semanalmente/////////////////////////////////////////////
		table.setValueAt(formato.format(sim.materiales[0].Resul2.getROrganico())+" kg", 1, 1);
		table.setValueAt(formato.format(sim.materiales[0].Resul2.getRSoplado())+" kg", 1, 2);
		table.setValueAt(formato.format(sim.materiales[0].Resul2.getRPet())+" kg", 1, 3);
		table.setValueAt(formato.format(sim.materiales[0].Resul2.getRCarton())+" kg", 1, 4);
		table.setValueAt(formato.format(sim.materiales[0].Resul2.getRPapel())+" kg", 1, 5);
		table.setValueAt(formato.format(sim.materiales[0].Resul2.getRBoteLata())+" kg", 1, 6);
		table.setValueAt(formato.format(sim.materiales[0].Resul2.getRBoteAlum())+" kg", 1, 7);
		table.setValueAt(formato.format(sim.materiales[0].Resul2.getRLata())+" kg", 1, 8);
		table.setValueAt(formato.format(sim.materiales[0].Resul2.getRFierro())+" kg", 1, 9);
		table.setValueAt(formato.format(sim.materiales[0].Resul2.getRMiscelaneo())+" kg", 1, 10);
		table.setValueAt(formato.format(sim.materiales[0].Resul2.getRVidrio())+" kg", 1, 11);
		table.setValueAt(formato.format(sim.materiales[0].Resul2.getROtros())+" kg", 1, 12);
		table.setValueAt(formato.format(sim.materiales[0].Resul2.getROrganico()+sim.materiales[0].Resul2.getRSoplado()+
										sim.materiales[0].Resul2.getRPet()+sim.materiales[0].Resul2.getRCarton()+
										sim.materiales[0].Resul2.getRPapel()+sim.materiales[0].Resul2.getRBoteLata()+
										sim.materiales[0].Resul2.getRBoteAlum()+sim.materiales[0].Resul2.getRLata()+
										sim.materiales[0].Resul2.getRFierro()+sim.materiales[0].Resul2.getRMiscelaneo()+
										sim.materiales[0].Resul2.getRVidrio()+sim.materiales[0].Resul2.getROtros())+" kg", 1, 13);
		//RSU generado mensualmente////////////////////////////////////////////
		table.setValueAt(formato.format(sim.materiales[0].Resul3.getROrganico())+" kg", 2, 1);
		table.setValueAt(formato.format(sim.materiales[0].Resul3.getRSoplado())+" kg", 2, 2);
		table.setValueAt(formato.format(sim.materiales[0].Resul3.getRPet())+" kg", 2, 3);
		table.setValueAt(formato.format(sim.materiales[0].Resul3.getRCarton())+" kg", 2, 4);
		table.setValueAt(formato.format(sim.materiales[0].Resul3.getRPapel())+" kg", 2, 5);
		table.setValueAt(formato.format(sim.materiales[0].Resul3.getRBoteLata())+" kg", 2, 6);
		table.setValueAt(formato.format(sim.materiales[0].Resul3.getRBoteAlum())+" kg", 2, 7);
		table.setValueAt(formato.format(sim.materiales[0].Resul3.getRLata())+" kg", 2, 8);
		table.setValueAt(formato.format(sim.materiales[0].Resul3.getRFierro())+" kg", 2, 9);
		table.setValueAt(formato.format(sim.materiales[0].Resul3.getRMiscelaneo())+" kg", 2, 10);
		table.setValueAt(formato.format(sim.materiales[0].Resul3.getRVidrio())+" kg", 2, 11);
		table.setValueAt(formato.format(sim.materiales[0].Resul3.getROtros())+" kg", 2, 12);
		table.setValueAt(formato.format(sim.materiales[0].Resul3.getROrganico()+sim.materiales[0].Resul3.getRSoplado()+
										sim.materiales[0].Resul3.getRPet()+sim.materiales[0].Resul3.getRCarton()+
										sim.materiales[0].Resul3.getRPapel()+sim.materiales[0].Resul3.getRBoteLata()+
										sim.materiales[0].Resul3.getRBoteAlum()+sim.materiales[0].Resul3.getRLata()+
										sim.materiales[0].Resul3.getRFierro()+sim.materiales[0].Resul3.getRMiscelaneo()+
										sim.materiales[0].Resul3.getRVidrio()+sim.materiales[0].Resul3.getROtros())+" kg", 2, 13);
		//RSU generado anualmente//////////////////////////////////////////////
		table.setValueAt(formato.format(sim.materiales[0].Resul4.getROrganico())+" kg", 3, 1);
		table.setValueAt(formato.format(sim.materiales[0].Resul4.getRSoplado())+" kg", 3, 2);
		table.setValueAt(formato.format(sim.materiales[0].Resul4.getRPet())+" kg", 3, 3);
		table.setValueAt(formato.format(sim.materiales[0].Resul4.getRCarton())+" kg", 3, 4);
		table.setValueAt(formato.format(sim.materiales[0].Resul4.getRPapel())+" kg", 3, 5);
		table.setValueAt(formato.format(sim.materiales[0].Resul4.getRBoteLata())+" kg", 3, 6);
		table.setValueAt(formato.format(sim.materiales[0].Resul4.getRBoteAlum())+" kg", 3, 7);
		table.setValueAt(formato.format(sim.materiales[0].Resul4.getRLata())+" kg", 3, 8);
		table.setValueAt(formato.format(sim.materiales[0].Resul4.getRFierro())+" kg", 3, 9);
		table.setValueAt(formato.format(sim.materiales[0].Resul4.getRMiscelaneo())+" kg", 3, 10);
		table.setValueAt(formato.format(sim.materiales[0].Resul4.getRVidrio())+" kg", 3, 11);
		table.setValueAt(formato.format(sim.materiales[0].Resul4.getROtros())+" kg", 3, 12);
		table.setValueAt(formato.format(sim.materiales[0].Resul4.getROrganico()+sim.materiales[0].Resul4.getRSoplado()+
										sim.materiales[0].Resul4.getRPet()+sim.materiales[0].Resul4.getRCarton()+
										sim.materiales[0].Resul4.getRPapel()+sim.materiales[0].Resul4.getRBoteLata()+
										sim.materiales[0].Resul4.getRBoteAlum()+sim.materiales[0].Resul4.getRLata()+
										sim.materiales[0].Resul4.getRFierro()+sim.materiales[0].Resul4.getRMiscelaneo()+
										sim.materiales[0].Resul4.getRVidrio()+sim.materiales[0].Resul4.getROtros())+" kg", 3, 13);
		///////////////////////////////////////////////////////////////////////
		//Dinero Generado por RSU diariamente
		//////////////////////////////////////////////////////////////////////					
		table.setValueAt("$ "+formato.format(sim.precio[0].Resul1.getROrganico()), 7, 1);
		table.setValueAt("$ "+formato.format(sim.precio[0].Resul1.getRSoplado()), 7, 2);
		table.setValueAt("$ "+formato.format(sim.precio[0].Resul1.getRPet()), 7, 3);
		table.setValueAt("$ "+formato.format(sim.precio[0].Resul1.getRCarton()), 7, 4);
		table.setValueAt("$ "+formato.format(sim.precio[0].Resul1.getRPapel()), 7, 5);
		table.setValueAt("$ "+formato.format(sim.precio[0].Resul1.getRBoteLata()), 7, 6);
		table.setValueAt("$ "+formato.format(sim.precio[0].Resul1.getRBoteAlum()), 7, 7);
		table.setValueAt("$ "+formato.format(sim.precio[0].Resul1.getRLata()), 7, 8);
		table.setValueAt("$ "+formato.format(sim.precio[0].Resul1.getRFierro()), 7, 9);
		table.setValueAt("$ "+formato.format(sim.precio[0].Resul1.getRMiscelaneo()), 7, 10);
		table.setValueAt("$ "+formato.format(sim.precio[0].Resul1.getRVidrio()), 7, 11);
		table.setValueAt("$ "+formato.format(sim.precio[0].Resul1.getROtros()), 7, 12);
		table.setValueAt("$ "+formato.format(sim.precio[0].Resul1.getROrganico()+sim.precio[0].Resul1.getRSoplado()+
											sim.precio[0].Resul1.getRPet()+sim.precio[0].Resul1.getRCarton()+
											sim.precio[0].Resul1.getRPapel()+sim.precio[0].Resul1.getRBoteLata()+
											sim.precio[0].Resul1.getRBoteAlum()+sim.precio[0].Resul1.getRLata()+
											sim.precio[0].Resul1.getRFierro()+sim.precio[0].Resul1.getRMiscelaneo()+
											sim.precio[0].Resul1.getRVidrio()+sim.precio[0].Resul1.getROtros()), 7, 13);
		//RSU generado semanalmente///////////////////////////////////////////////
		table.setValueAt("$ "+formato.format(sim.precio[0].Resul2.getROrganico()), 8, 1);
		table.setValueAt("$ "+formato.format(sim.precio[0].Resul2.getRSoplado()), 8, 2);
		table.setValueAt("$ "+formato.format(sim.precio[0].Resul2.getRPet()), 8, 3);
		table.setValueAt("$ "+formato.format(sim.precio[0].Resul2.getRCarton()), 8, 4);
		table.setValueAt("$ "+formato.format(sim.precio[0].Resul2.getRPapel()), 8, 5);
		table.setValueAt("$ "+formato.format(sim.precio[0].Resul2.getRBoteLata()), 8, 6);
		table.setValueAt("$ "+formato.format(sim.precio[0].Resul2.getRBoteAlum()), 8, 7);
		table.setValueAt("$ "+formato.format(sim.precio[0].Resul2.getRLata()), 8, 8);
		table.setValueAt("$ "+formato.format(sim.precio[0].Resul2.getRFierro()), 8, 9);
		table.setValueAt("$ "+formato.format(sim.precio[0].Resul2.getRMiscelaneo()), 8, 10);
		table.setValueAt("$ "+formato.format(sim.precio[0].Resul2.getRVidrio()), 8, 11);
		table.setValueAt("$ "+formato.format(sim.precio[0].Resul2.getROtros()), 8, 12);
		table.setValueAt("$ "+formato.format(sim.precio[0].Resul2.getROrganico()+sim.precio[0].Resul2.getRSoplado()+
											sim.precio[0].Resul2.getRPet()+sim.precio[0].Resul2.getRCarton()+
											sim.precio[0].Resul2.getRPapel()+sim.precio[0].Resul2.getRBoteLata()+
											sim.precio[0].Resul2.getRBoteAlum()+sim.precio[0].Resul2.getRLata()+
											sim.precio[0].Resul2.getRFierro()+sim.precio[0].Resul2.getRMiscelaneo()+
											sim.precio[0].Resul2.getRVidrio()+sim.precio[0].Resul2.getROtros()), 8, 13);
		//RSU generado mensualmente///////////////////////////////////////////////
		table.setValueAt("$ "+formato.format(sim.precio[0].Resul3.getROrganico()), 9, 1);
		table.setValueAt("$ "+formato.format(sim.precio[0].Resul3.getRSoplado()), 9, 2);
		table.setValueAt("$ "+formato.format(sim.precio[0].Resul3.getRPet()), 9, 3);
		table.setValueAt("$ "+formato.format(sim.precio[0].Resul3.getRCarton()), 9, 4);
		table.setValueAt("$ "+formato.format(sim.precio[0].Resul3.getRPapel()), 9, 5);
		table.setValueAt("$ "+formato.format(sim.precio[0].Resul3.getRBoteLata()), 9, 6);
		table.setValueAt("$ "+formato.format(sim.precio[0].Resul3.getRBoteAlum()), 9, 7);
		table.setValueAt("$ "+formato.format(sim.precio[0].Resul3.getRLata()), 9, 8);
		table.setValueAt("$ "+formato.format(sim.precio[0].Resul3.getRFierro()), 9, 9);
		table.setValueAt("$ "+formato.format(sim.precio[0].Resul3.getRMiscelaneo()), 9, 10);
		table.setValueAt("$ "+formato.format(sim.precio[0].Resul3.getRVidrio()), 9, 11);
		table.setValueAt("$ "+formato.format(sim.precio[0].Resul3.getROtros()), 9, 12);
		table.setValueAt("$ "+formato.format(sim.precio[0].Resul3.getROrganico()+sim.precio[0].Resul3.getRSoplado()+
											sim.precio[0].Resul3.getRPet()+sim.precio[0].Resul3.getRCarton()+
											sim.precio[0].Resul3.getRPapel()+sim.precio[0].Resul3.getRBoteLata()+
											sim.precio[0].Resul3.getRBoteAlum()+sim.precio[0].Resul3.getRLata()+
											sim.precio[0].Resul3.getRFierro()+sim.precio[0].Resul3.getRMiscelaneo()+
											sim.precio[0].Resul3.getRVidrio()+sim.precio[0].Resul3.getROtros()), 9, 13);
		//RSU generado anualmente///////////////////////////////////////////////		
		table.setValueAt("$ "+formato.format(sim.precio[0].Resul4.getROrganico()), 10, 1);
		table.setValueAt("$ "+formato.format(sim.precio[0].Resul4.getRSoplado()), 10, 2);
		table.setValueAt("$ "+formato.format(sim.precio[0].Resul4.getRPet()), 10, 3);
		table.setValueAt("$ "+formato.format(sim.precio[0].Resul4.getRCarton()), 10, 4);
		table.setValueAt("$ "+formato.format(sim.precio[0].Resul4.getRPapel()), 10, 5);
		table.setValueAt("$ "+formato.format(sim.precio[0].Resul4.getRBoteLata()), 10, 6);
		table.setValueAt("$ "+formato.format(sim.precio[0].Resul4.getRBoteAlum()), 10, 7);
		table.setValueAt("$ "+formato.format(sim.precio[0].Resul4.getRLata()), 10, 8);
		table.setValueAt("$ "+formato.format(sim.precio[0].Resul4.getRFierro()), 10, 9);
		table.setValueAt("$ "+formato.format(sim.precio[0].Resul4.getRMiscelaneo()), 10, 10);
		table.setValueAt("$ "+formato.format(sim.precio[0].Resul4.getRVidrio()), 10, 11);
		table.setValueAt("$ "+formato.format(sim.precio[0].Resul4.getROtros()), 10, 12);
		table.setValueAt("$ "+formato.format(sim.precio[0].Resul4.getROrganico()+sim.precio[0].Resul4.getRSoplado()+
											sim.precio[0].Resul4.getRPet()+sim.precio[0].Resul4.getRCarton()+
											sim.precio[0].Resul4.getRPapel()+sim.precio[0].Resul4.getRBoteLata()+
											sim.precio[0].Resul4.getRBoteAlum()+sim.precio[0].Resul4.getRLata()+
											sim.precio[0].Resul4.getRFierro()+sim.precio[0].Resul4.getRMiscelaneo()+
											sim.precio[0].Resul4.getRVidrio()+sim.precio[0].Resul4.getROtros()), 10, 13);
		///////////////////////////////////////////////////////////////////////////
	}catch(Exception c){
		JOptionPane.showMessageDialog(null, "No existen datos para mostrar en tabla", "Error", JOptionPane.ERROR_MESSAGE);
		setVisible(false);
	}
}
}
