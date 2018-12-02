import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.ImageIcon;


public class RSUSimulacion extends JDialog implements ActionListener{

	private final JPanel contentPanel = new JPanel();
	private JButton btnLugar;
	private JButton btnMateriales;
	private JButton btnSimulacion;
	private JButton btnGrafica;
	private JButton cancelButton;
	private SimLugar lugar;
	private SimMateriales materiales;
	private SimResultado resultado;
	private SimGrafica grafica;
	private Simulacion simulacion;
	
	public RSUSimulacion(Simulacion sim) {
		setModal(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(RSUSimulacion.class.getResource("/Iconos/Document Edit.png")));
		setTitle("Nueva Simulaci\u00F3n");
		setBounds(100, 100, 561, 380);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		SpringLayout sl_contentPanel = new SpringLayout();
		lugar= new SimLugar(sim);
		materiales = new SimMateriales(sim);
		resultado= new SimResultado(sim);
		grafica= new SimGrafica(sim);
		simulacion=sim;
		contentPanel.setLayout(sl_contentPanel);
		{
			btnLugar = new JButton("Datos del Lugar");
			btnLugar.addActionListener(this);
			contentPanel.add(btnLugar);
		}
		{
			btnMateriales = new JButton("Datos de Materiales");
			sl_contentPanel.putConstraint(SpringLayout.NORTH, btnMateriales, 98, SpringLayout.NORTH, contentPanel);
			sl_contentPanel.putConstraint(SpringLayout.WEST, btnLugar, 0, SpringLayout.WEST, btnMateriales);
			sl_contentPanel.putConstraint(SpringLayout.SOUTH, btnLugar, -35, SpringLayout.NORTH, btnMateriales);
			btnMateriales.addActionListener(this);
			contentPanel.add(btnMateriales);
		}
		{
			btnSimulacion = new JButton("Comenzar Simulaci\u00F3n");
			sl_contentPanel.putConstraint(SpringLayout.NORTH, btnSimulacion, 37, SpringLayout.SOUTH, btnMateriales);
			sl_contentPanel.putConstraint(SpringLayout.WEST, btnSimulacion, 83, SpringLayout.WEST, contentPanel);
			sl_contentPanel.putConstraint(SpringLayout.WEST, btnMateriales, 0, SpringLayout.WEST, btnSimulacion);
			btnSimulacion.addActionListener(this);
			contentPanel.add(btnSimulacion);
		}
		{
			btnGrafica = new JButton("Gr\u00E1fica de la Simulaci\u00F3n");
			sl_contentPanel.putConstraint(SpringLayout.NORTH, btnGrafica, 40, SpringLayout.SOUTH, btnSimulacion);
			sl_contentPanel.putConstraint(SpringLayout.WEST, btnGrafica, 0, SpringLayout.WEST, btnLugar);
			btnGrafica.addActionListener(this);
			contentPanel.add(btnGrafica);
		}
		{
			JLabel lblIcono = new JLabel("");
			sl_contentPanel.putConstraint(SpringLayout.NORTH, lblIcono, 162, SpringLayout.NORTH, contentPanel);
			sl_contentPanel.putConstraint(SpringLayout.WEST, lblIcono, 120, SpringLayout.EAST, btnGrafica);
			sl_contentPanel.putConstraint(SpringLayout.SOUTH, lblIcono, 0, SpringLayout.SOUTH, contentPanel);
			sl_contentPanel.putConstraint(SpringLayout.EAST, lblIcono, -11, SpringLayout.EAST, contentPanel);
			lblIcono.setIcon(new ImageIcon(RSUSimulacion.class.getResource("/Iconos/Settings.png")));
			contentPanel.add(lblIcono);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				cancelButton = new JButton("Ok");
				cancelButton.setActionCommand("Cancel");
				cancelButton.addActionListener(this);
				buttonPane.add(cancelButton);
			}
		}
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==btnLugar){
			lugar.setVisible(true);
		}
		if(e.getSource()==btnMateriales){
			materiales.setVisible(true);
		}
		if(e.getSource()==btnSimulacion){
			simulacion.Simular();
			resultado.setTexto();
			resultado.setVisible(true);
			
		}
		if(e.getSource()==btnGrafica){
			grafica.setVisible(true);
		}
		if(e.getSource()==cancelButton){
			this.setVisible(false);
		}
	}

}
