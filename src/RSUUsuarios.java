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


public class RSUUsuarios extends JDialog implements ActionListener{

	private final JPanel contentPanel = new JPanel();
	private Simulacion simulacion;
	private JButton btnNuevoUsuario;
	private JButton btnModificarUsuario;
	private JButton btnEliminarUsuario;
	private JButton btnOk;
	private NUsuario datos;
	private EUsuario eusuario;
	private MID mid;
	
	public RSUUsuarios(Simulacion sim) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(RSUUsuarios.class.getResource("/Iconos/Buddy Group.png")));
		setModal(true);
		setTitle("Usuarios");
		setBounds(100, 100, 550, 350);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		SpringLayout sl_contentPanel = new SpringLayout();
		contentPanel.setLayout(sl_contentPanel);
		simulacion=sim;
		datos= new NUsuario(sim);
		eusuario=  new EUsuario(sim);
		mid= new MID(sim);
		
		
		btnNuevoUsuario = new JButton("Nuevo Usuario");
		btnNuevoUsuario.addActionListener(this);
		sl_contentPanel.putConstraint(SpringLayout.NORTH, btnNuevoUsuario, 27, SpringLayout.NORTH, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.WEST, btnNuevoUsuario, 33, SpringLayout.WEST, contentPanel);
		contentPanel.add(btnNuevoUsuario);
		
		btnModificarUsuario = new JButton("Modificar Usuario");
		btnModificarUsuario.addActionListener(this);
		sl_contentPanel.putConstraint(SpringLayout.NORTH, btnModificarUsuario, 44, SpringLayout.SOUTH, btnNuevoUsuario);
		sl_contentPanel.putConstraint(SpringLayout.WEST, btnModificarUsuario, 0, SpringLayout.WEST, btnNuevoUsuario);
		contentPanel.add(btnModificarUsuario);
		
		btnEliminarUsuario = new JButton("Eliminar Usuario");
		btnEliminarUsuario.addActionListener(this);
		sl_contentPanel.putConstraint(SpringLayout.NORTH, btnEliminarUsuario, 42, SpringLayout.SOUTH, btnModificarUsuario);
		sl_contentPanel.putConstraint(SpringLayout.WEST, btnEliminarUsuario, 0, SpringLayout.WEST, btnNuevoUsuario);
		contentPanel.add(btnEliminarUsuario);
		
		btnOk = new JButton("Ok");
		btnOk.addActionListener(this);
		sl_contentPanel.putConstraint(SpringLayout.WEST, btnOk, -84, SpringLayout.EAST, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.SOUTH, btnOk, -5, SpringLayout.SOUTH, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.EAST, btnOk, -18, SpringLayout.EAST, contentPanel);
		contentPanel.add(btnOk);
		
		JLabel lblNewLabel = new JLabel("");
		sl_contentPanel.putConstraint(SpringLayout.NORTH, lblNewLabel, 127, SpringLayout.NORTH, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.WEST, lblNewLabel, 219, SpringLayout.EAST, btnEliminarUsuario);
		sl_contentPanel.putConstraint(SpringLayout.SOUTH, lblNewLabel, -6, SpringLayout.NORTH, btnOk);
		sl_contentPanel.putConstraint(SpringLayout.EAST, lblNewLabel, -35, SpringLayout.EAST, contentPanel);
		lblNewLabel.setIcon(new ImageIcon(RSUUsuarios.class.getResource("/Iconos/User.png")));
		contentPanel.add(lblNewLabel);
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==btnNuevoUsuario){
			datos.setVisible(true);
		}
		if(e.getSource()==btnModificarUsuario){
			mid.Opcion('c');
			mid.setVisible(true);
		}
		if(e.getSource()==btnEliminarUsuario){
			eusuario.setVisible(true);
		}
		if(e.getSource()==btnOk){
			setVisible(false);
		}
	}
	
}
