import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class RSUPrincipal extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JButton btnUsuario;
	private JButton btnNuevo;
	private JButton btnModificar;
	private JButton btnGuardar;
	private JButton btnSalir;
	private Simulacion simulacion;
	private RSUSimulacion Nuevo;
	private RSUUsuarios  User;
	private RSUModificar modificar;
	private JButton btnAbrir;
	private JLabel label_1;
	private JLabel label_2;
	
	public RSUPrincipal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(RSUPrincipal.class.getResource("/Iconos/Home.png")));
		setTitle("Sistema de Simulaci\u00F3n de Residuos S\u00F3lidos Urbanos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 646, 435);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		simulacion = new Simulacion();
		Nuevo = new RSUSimulacion(simulacion);
		User = new RSUUsuarios(simulacion);
		modificar= new RSUModificar(simulacion);
		
		
		btnUsuario = new JButton("Usuario");
		sl_contentPane.putConstraint(SpringLayout.WEST, btnUsuario, 113, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnUsuario, -288, SpringLayout.SOUTH, contentPane);
		btnUsuario.addActionListener(this);
		contentPane.add(btnUsuario);
		
		btnNuevo = new JButton("Nuevo / Simular");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNuevo, 94, SpringLayout.SOUTH, btnUsuario);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNuevo, 0, SpringLayout.WEST, btnUsuario);
		btnNuevo.addActionListener(this);
		contentPane.add(btnNuevo);
		
		btnModificar = new JButton("Modificar");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnModificar, 0, SpringLayout.NORTH, btnNuevo);
		btnModificar.addActionListener(this);
		contentPane.add(btnModificar);
		
		btnGuardar = new JButton("Guardar");
		sl_contentPane.putConstraint(SpringLayout.EAST, btnModificar, 0, SpringLayout.EAST, btnGuardar);
		btnGuardar.addActionListener(this);
		contentPane.add(btnGuardar);
		
		btnSalir = new JButton("Salir");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnGuardar, 0, SpringLayout.NORTH, btnSalir);
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnSalir, 319, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnSalir, -10, SpringLayout.EAST, contentPane);
		btnSalir.addActionListener(this);
		contentPane.add(btnSalir);
		
		btnAbrir = new JButton("Abrir");
		sl_contentPane.putConstraint(SpringLayout.WEST, btnGuardar, 71, SpringLayout.EAST, btnAbrir);
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnAbrir, 0, SpringLayout.NORTH, btnGuardar);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnAbrir, 0, SpringLayout.WEST, btnUsuario);
		btnAbrir.addActionListener(this);
		contentPane.add(btnAbrir);
		
		JLabel label = new JLabel("");
		sl_contentPane.putConstraint(SpringLayout.NORTH, label, 32, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, label, 0, SpringLayout.WEST, contentPane);
		label.setIcon(new ImageIcon(RSUPrincipal.class.getResource("/Iconos/num1.jpg")));
		contentPane.add(label);
		
		label_1 = new JLabel("");
		sl_contentPane.putConstraint(SpringLayout.NORTH, label_1, 22, SpringLayout.SOUTH, label);
		sl_contentPane.putConstraint(SpringLayout.WEST, label_1, 0, SpringLayout.WEST, label);
		label_1.setIcon(new ImageIcon(RSUPrincipal.class.getResource("/Iconos/num2.jpg")));
		contentPane.add(label_1);
		
		label_2 = new JLabel("");
		sl_contentPane.putConstraint(SpringLayout.WEST, label_2, 0, SpringLayout.WEST, label);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, label_2, -10, SpringLayout.SOUTH, contentPane);
		label_2.setIcon(new ImageIcon(RSUPrincipal.class.getResource("/Iconos/num3.jpg")));
		contentPane.add(label_2);
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==btnUsuario){
			User.setVisible(true);
		}
		if(e.getSource()==btnNuevo){
			Nuevo.setVisible(true);
		}
		if(e.getSource()==btnModificar){
			modificar.setVisible(true);
		}
		if(e.getSource()==btnGuardar){
			String nombre= RSUGA.explorarDiscoGuardar();
			RSUGA.guardarArchivo(nombre, simulacion);
		}
		if(e.getSource()==btnAbrir){
			String nombre=RSUGA.explorarDiscoAbrir();
			RSUGA.abrirArchivo(nombre, simulacion);
		}
		if(e.getSource()==btnSalir){
			System.exit(0);
		}
	}
}
