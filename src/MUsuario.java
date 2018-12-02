import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Toolkit;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.SpringLayout;
import javax.swing.JLayeredPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;


public class MUsuario extends JDialog implements ActionListener{
	private JTextField textNombre;
	private JTextField textApellidos;
	private JTextField textCargo;
	private JTextField textUHab;
	private JTextField textID;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private Simulacion sim;
	private int tamaño=0;

	
	public MUsuario(Simulacion simulacion) {
		setTitle("Modificar Usuario");
		setIconImage(Toolkit.getDefaultToolkit().getImage(MUsuario.class.getResource("/Iconos/Document Edit.png")));
		setModal(true);
		setBounds(100, 100, 537, 358);
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);
		
		sim = simulacion;
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		springLayout.putConstraint(SpringLayout.WEST, btnAceptar, 134, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnAceptar, -21, SpringLayout.SOUTH, getContentPane());
		getContentPane().add(btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		springLayout.putConstraint(SpringLayout.NORTH, btnCancelar, 0, SpringLayout.NORTH, btnAceptar);
		springLayout.putConstraint(SpringLayout.WEST, btnCancelar, 70, SpringLayout.EAST, btnAceptar);
		getContentPane().add(btnCancelar);
		
		JLabel lblNombre = new JLabel("Nombre:");
		springLayout.putConstraint(SpringLayout.NORTH, lblNombre, 37, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblNombre, 96, SpringLayout.WEST, getContentPane());
		getContentPane().add(lblNombre);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		springLayout.putConstraint(SpringLayout.NORTH, lblApellidos, 30, SpringLayout.SOUTH, lblNombre);
		springLayout.putConstraint(SpringLayout.WEST, lblApellidos, 0, SpringLayout.WEST, lblNombre);
		getContentPane().add(lblApellidos);
		
		JLabel lblCargo = new JLabel("Cargo:");
		springLayout.putConstraint(SpringLayout.NORTH, lblCargo, 26, SpringLayout.SOUTH, lblApellidos);
		springLayout.putConstraint(SpringLayout.WEST, lblCargo, 0, SpringLayout.WEST, lblNombre);
		getContentPane().add(lblCargo);
		
		JLabel lblUHab = new JLabel("U. Habitacional:");
		springLayout.putConstraint(SpringLayout.WEST, lblUHab, 0, SpringLayout.WEST, lblNombre);
		springLayout.putConstraint(SpringLayout.SOUTH, lblUHab, -143, SpringLayout.SOUTH, getContentPane());
		getContentPane().add(lblUHab);
		
		JLabel lblID = new JLabel("ID:");
		springLayout.putConstraint(SpringLayout.NORTH, lblID, 26, SpringLayout.SOUTH, lblUHab);
		springLayout.putConstraint(SpringLayout.WEST, lblID, 0, SpringLayout.WEST, lblNombre);
		getContentPane().add(lblID);
		
		textNombre = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, textNombre, 83, SpringLayout.EAST, lblNombre);
		springLayout.putConstraint(SpringLayout.EAST, textNombre, 1, SpringLayout.EAST, btnCancelar);
		getContentPane().add(textNombre);
		textNombre.setColumns(10);
		
		textApellidos = new JTextField();
		springLayout.putConstraint(SpringLayout.SOUTH, textNombre, -24, SpringLayout.NORTH, textApellidos);
		springLayout.putConstraint(SpringLayout.EAST, textApellidos, 0, SpringLayout.EAST, btnCancelar);
		springLayout.putConstraint(SpringLayout.WEST, textApellidos, 0, SpringLayout.WEST, textNombre);
		getContentPane().add(textApellidos);
		textApellidos.setColumns(10);
		
		textCargo = new JTextField();
		springLayout.putConstraint(SpringLayout.SOUTH, textApellidos, -20, SpringLayout.NORTH, textCargo);
		springLayout.putConstraint(SpringLayout.EAST, textCargo, 0, SpringLayout.EAST, btnCancelar);
		springLayout.putConstraint(SpringLayout.WEST, textCargo, 0, SpringLayout.WEST, textNombre);
		springLayout.putConstraint(SpringLayout.SOUTH, textCargo, -178, SpringLayout.SOUTH, getContentPane());
		getContentPane().add(textCargo);
		textCargo.setColumns(10);
		
		textUHab = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textUHab, 18, SpringLayout.SOUTH, textCargo);
		springLayout.putConstraint(SpringLayout.WEST, textUHab, 0, SpringLayout.WEST, textNombre);
		springLayout.putConstraint(SpringLayout.EAST, textUHab, 0, SpringLayout.EAST, btnCancelar);
		getContentPane().add(textUHab);
		textUHab.setColumns(10);
		
		textID = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textID, 20, SpringLayout.SOUTH, textUHab);
		springLayout.putConstraint(SpringLayout.WEST, textID, 0, SpringLayout.WEST, textNombre);
		springLayout.putConstraint(SpringLayout.EAST, textID, 0, SpringLayout.EAST, btnCancelar);
		getContentPane().add(textID);
		textID.setColumns(10);
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==btnAceptar){
			try{
				sim.setUsuario(tamaño, textNombre.getText(), textApellidos.getText(), textCargo.getText(), textUHab.getText(), textID.getText());
				textNombre.setText("");
				textApellidos.setText("");
				textCargo.setText("");
				textUHab.setText("");
				textID.setText("");
				setVisible(false);
			}catch(Exception c){
				JOptionPane.showMessageDialog(null, "Favor de verificar la información.", "Aviso", JOptionPane.WARNING_MESSAGE);
			}
		}
		if(e.getSource()==btnCancelar){
			setVisible(false);
			textNombre.setText("");
			textApellidos.setText("");
			textCargo.setText("");
			textUHab.setText("");
			textID.setText("");
		}
	}
	
	public void setTexto(int indice){
		textNombre.setText(sim.usuario[indice].getNombre());
		textApellidos.setText(sim.usuario[indice].getApellidos());
		textCargo.setText(sim.usuario[indice].getCargo());
		textUHab.setText(sim.usuario[indice].getUHab());
		textID.setText(sim.usuario[indice].getID());
		tamaño=indice;
	}
}
