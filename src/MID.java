import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MID extends JDialog implements ActionListener{

	private final JPanel contentPanel = new JPanel();
	private JTextField textID;
	private JLabel lblIntrozucaElId;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private MUsuario musuario;
	private MMateriales mmateriales;
	private MLugar mlugar;
	private char opcion;
	private Simulacion sim;


	public MID(Simulacion simulacion) {
		setTitle("Ingresar ID");
		setIconImage(Toolkit.getDefaultToolkit().getImage(MID.class.getResource("/Iconos/Edit.png")));
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		SpringLayout sl_contentPanel = new SpringLayout();
		sim= simulacion;
		musuario= new MUsuario(simulacion);
		mmateriales= new MMateriales(simulacion);
		mlugar= new MLugar(simulacion);
		
		contentPanel.setLayout(sl_contentPanel);
		{
			lblIntrozucaElId = new JLabel("Introduzca el ID de los datos a modificar:");
			contentPanel.add(lblIntrozucaElId);
		}
		{
			textID = new JTextField();
			sl_contentPanel.putConstraint(SpringLayout.NORTH, textID, 81, SpringLayout.NORTH, contentPanel);
			sl_contentPanel.putConstraint(SpringLayout.SOUTH, lblIntrozucaElId, -31, SpringLayout.NORTH, textID);
			sl_contentPanel.putConstraint(SpringLayout.WEST, textID, 138, SpringLayout.WEST, contentPanel);
			sl_contentPanel.putConstraint(SpringLayout.EAST, textID, -164, SpringLayout.EAST, contentPanel);
			contentPanel.add(textID);
			textID.setColumns(10);
		}
		{
			btnAceptar = new JButton("Aceptar");
			btnAceptar.addActionListener(this);
			sl_contentPanel.putConstraint(SpringLayout.WEST, lblIntrozucaElId, 0, SpringLayout.WEST, btnAceptar);
			contentPanel.add(btnAceptar);
		}
		{
			btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(this);
			sl_contentPanel.putConstraint(SpringLayout.NORTH, btnCancelar, 58, SpringLayout.SOUTH, textID);
			sl_contentPanel.putConstraint(SpringLayout.NORTH, btnAceptar, 0, SpringLayout.NORTH, btnCancelar);
			sl_contentPanel.putConstraint(SpringLayout.EAST, btnAceptar, -41, SpringLayout.WEST, btnCancelar);
			contentPanel.add(btnCancelar);
		}
		{
			JLabel label = new JLabel("");
			sl_contentPanel.putConstraint(SpringLayout.EAST, btnCancelar, -6, SpringLayout.WEST, label);
			sl_contentPanel.putConstraint(SpringLayout.SOUTH, label, 0, SpringLayout.SOUTH, contentPanel);
			sl_contentPanel.putConstraint(SpringLayout.EAST, label, 0, SpringLayout.EAST, contentPanel);
			label.setIcon(new ImageIcon(MID.class.getResource("/Iconos/Find Search.png")));
			contentPanel.add(label);
		}
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==btnAceptar){
			if(this.opcion=='a'){
				if(sim.getLugar(textID.getText())==true){
					setVisible(false);
					mlugar.setTexto(sim.getPosicion());
					mlugar.setVisible(true);
					textID.setText("");
				}else{
					JOptionPane.showMessageDialog(null, "El ID no es el correcto.\nVerifique su información.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
				}
			}
			if(this.opcion=='b'){
				if(sim.getMaterialesPrecio(textID.getText())==true){
					setVisible(false);
					mmateriales.setTexto(sim.getPosicion());
					mmateriales.setVisible(true);
					textID.setText("");
				}else{
					JOptionPane.showMessageDialog(null, "El ID no es el correcto.\nVerifique su información.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
				}
			}
			if(this.opcion=='c'){
				if(sim.getUsuario(textID.getText())==true){
					setVisible(false);
					musuario.setTexto(sim.getPosicion());
					musuario.setVisible(true);
					textID.setText("");
				}else{
					JOptionPane.showMessageDialog(null, "El ID no es el correcto.\nVerifique su información.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}
		if(e.getSource()==btnCancelar){
			setVisible(false);
			textID.setText("");
		}
	}
	public void Opcion(char opcion){
		this.opcion=opcion;
	}

}
