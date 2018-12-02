import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;

import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JTextField;


public class NUsuario extends JDialog implements ActionListener{

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JLabel lblNombre;
	private JTextField txtApellidos;
	private JTextField txtCargo;
	private JTextField txtUHab;
	private JLabel lblId;
	private JTextField txtID;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private Simulacion sim;
	private int tamaño;

	public NUsuario(Simulacion simulacion) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(NUsuario.class.getResource("/Iconos/Buddy.png")));
		setModal(true);
		setTitle("Nuevo Usuario");
		setBounds(100, 100, 450, 331);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		SpringLayout sl_contentPanel = new SpringLayout();
		contentPanel.setLayout(sl_contentPanel);
		sim=simulacion;
		{
			lblNombre = new JLabel("Nombre:");
			sl_contentPanel.putConstraint(SpringLayout.WEST, lblNombre, 10, SpringLayout.WEST, contentPanel);
			contentPanel.add(lblNombre);
		}
		tamaño=this.sim.setTamaño();
		
		txtNombre = new JTextField();
		sl_contentPanel.putConstraint(SpringLayout.WEST, txtNombre, 52, SpringLayout.EAST, lblNombre);
		sl_contentPanel.putConstraint(SpringLayout.EAST, txtNombre, -141, SpringLayout.EAST, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.NORTH, lblNombre, 3, SpringLayout.NORTH, txtNombre);
		sl_contentPanel.putConstraint(SpringLayout.NORTH, txtNombre, 32, SpringLayout.NORTH, contentPanel);
		contentPanel.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		sl_contentPanel.putConstraint(SpringLayout.NORTH, lblApellidos, 24, SpringLayout.SOUTH, lblNombre);
		sl_contentPanel.putConstraint(SpringLayout.WEST, lblApellidos, 0, SpringLayout.WEST, lblNombre);
		contentPanel.add(lblApellidos);
		
		txtApellidos = new JTextField();
		sl_contentPanel.putConstraint(SpringLayout.NORTH, txtApellidos, 18, SpringLayout.SOUTH, txtNombre);
		sl_contentPanel.putConstraint(SpringLayout.WEST, txtApellidos, 0, SpringLayout.WEST, txtNombre);
		sl_contentPanel.putConstraint(SpringLayout.EAST, txtApellidos, -141, SpringLayout.EAST, contentPanel);
		contentPanel.add(txtApellidos);
		txtApellidos.setColumns(10);
		
		JLabel lblCargo = new JLabel("Cargo:");
		sl_contentPanel.putConstraint(SpringLayout.NORTH, lblCargo, 23, SpringLayout.SOUTH, lblApellidos);
		sl_contentPanel.putConstraint(SpringLayout.WEST, lblCargo, 0, SpringLayout.WEST, lblNombre);
		contentPanel.add(lblCargo);
		
		txtCargo = new JTextField();
		sl_contentPanel.putConstraint(SpringLayout.NORTH, txtCargo, 0, SpringLayout.NORTH, lblCargo);
		sl_contentPanel.putConstraint(SpringLayout.WEST, txtCargo, 0, SpringLayout.WEST, txtNombre);
		sl_contentPanel.putConstraint(SpringLayout.EAST, txtCargo, -141, SpringLayout.EAST, contentPanel);
		contentPanel.add(txtCargo);
		txtCargo.setColumns(10);
		
		JLabel lblUHabitacional = new JLabel("U. Habitacional:");
		sl_contentPanel.putConstraint(SpringLayout.NORTH, lblUHabitacional, 25, SpringLayout.SOUTH, lblCargo);
		sl_contentPanel.putConstraint(SpringLayout.WEST, lblUHabitacional, 0, SpringLayout.WEST, lblNombre);
		contentPanel.add(lblUHabitacional);
		
		txtUHab = new JTextField();
		sl_contentPanel.putConstraint(SpringLayout.NORTH, txtUHab, -3, SpringLayout.NORTH, lblUHabitacional);
		sl_contentPanel.putConstraint(SpringLayout.WEST, txtUHab, 0, SpringLayout.WEST, txtNombre);
		sl_contentPanel.putConstraint(SpringLayout.EAST, txtUHab, 0, SpringLayout.EAST, txtNombre);
		contentPanel.add(txtUHab);
		txtUHab.setColumns(10);
		
		lblId = new JLabel("ID:");
		sl_contentPanel.putConstraint(SpringLayout.NORTH, lblId, 23, SpringLayout.SOUTH, lblUHabitacional);
		sl_contentPanel.putConstraint(SpringLayout.WEST, lblId, 0, SpringLayout.WEST, lblNombre);
		contentPanel.add(lblId);
		
		txtID = new JTextField();
		sl_contentPanel.putConstraint(SpringLayout.NORTH, txtID, -3, SpringLayout.NORTH, lblId);
		sl_contentPanel.putConstraint(SpringLayout.WEST, txtID, 0, SpringLayout.WEST, txtNombre);
		sl_contentPanel.putConstraint(SpringLayout.EAST, txtID, 258, SpringLayout.EAST, lblId);
		contentPanel.add(txtID);
		txtID.setColumns(10);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);		
		sl_contentPanel.putConstraint(SpringLayout.WEST, btnAceptar, 92, SpringLayout.WEST, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.SOUTH, btnAceptar, -10, SpringLayout.SOUTH, contentPanel);
		contentPanel.add(btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		sl_contentPanel.putConstraint(SpringLayout.NORTH, btnCancelar, 0, SpringLayout.NORTH, btnAceptar);
		sl_contentPanel.putConstraint(SpringLayout.WEST, btnCancelar, 45, SpringLayout.EAST, btnAceptar);
		contentPanel.add(btnCancelar);
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==btnAceptar){
			try{
				if(tamaño<30){

					sim.Usuario(tamaño, txtNombre.getText(), txtApellidos.getText(), txtCargo.getText(), txtUHab.getText(), txtID.getText());
					txtNombre.setText("");
					txtApellidos.setText("");
					txtCargo.setText("");
					txtUHab.setText("");
					txtID.setText("");
					setVisible(false);
					tamaño++;
				}
				else{
					JOptionPane.showMessageDialog(null, "No hay lugar para más usuarios,\nlo sentimos.", "Aviso", JOptionPane.WARNING_MESSAGE);
				}
			}catch(Exception c){
				JOptionPane.showMessageDialog(null, "Favor de verificar la información.", "Aviso", JOptionPane.WARNING_MESSAGE);
			}
		}
		if(e.getSource()==btnCancelar){
			txtNombre.setText("");
			txtApellidos.setText("");
			txtCargo.setText("");
			txtUHab.setText("");
			txtID.setText("");
			setVisible(false);
		}
	}
}
