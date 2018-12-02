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
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Toolkit;

import javax.swing.ImageIcon;


public class EUsuario extends JDialog implements ActionListener{

	private final JPanel contentPanel = new JPanel();
	private JButton btnAceptar;
	private JTextField textID;
	private JLabel lblIngresaElId;
	private Simulacion sim;
	private JButton btnCancelar;
	private JLabel label;
	
	public EUsuario(Simulacion simulacion) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(EUsuario.class.getResource("/Iconos/Symbol - Delete.png")));
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		SpringLayout sl_contentPanel = new SpringLayout();
		contentPanel.setLayout(sl_contentPanel);
		sim=simulacion;
		
		{
			btnAceptar = new JButton("Aceptar");
			btnAceptar.addActionListener(this);
			contentPanel.add(btnAceptar);
		}
		{
			btnCancelar = new JButton("Cancelar");
			sl_contentPanel.putConstraint(SpringLayout.NORTH, btnAceptar, 0, SpringLayout.NORTH, btnCancelar);
			sl_contentPanel.putConstraint(SpringLayout.EAST, btnAceptar, -60, SpringLayout.WEST, btnCancelar);
			sl_contentPanel.putConstraint(SpringLayout.SOUTH, btnCancelar, -27, SpringLayout.SOUTH, contentPanel);
			btnCancelar.addActionListener(this);
			contentPanel.add(btnCancelar);
		}
		{
			lblIngresaElId = new JLabel("Ingresa el ID del Usuario a Eliminar");
			sl_contentPanel.putConstraint(SpringLayout.WEST, lblIngresaElId, 91, SpringLayout.WEST, contentPanel);
			contentPanel.add(lblIngresaElId);
		}
		{
			textID = new JTextField();
			sl_contentPanel.putConstraint(SpringLayout.NORTH, textID, 87, SpringLayout.NORTH, contentPanel);
			sl_contentPanel.putConstraint(SpringLayout.WEST, textID, 81, SpringLayout.WEST, contentPanel);
			sl_contentPanel.putConstraint(SpringLayout.EAST, textID, -154, SpringLayout.EAST, contentPanel);
			sl_contentPanel.putConstraint(SpringLayout.SOUTH, lblIngresaElId, -20, SpringLayout.NORTH, textID);
			contentPanel.add(textID);
			textID.setColumns(10);
		}
		{
			label = new JLabel("");
			sl_contentPanel.putConstraint(SpringLayout.EAST, btnCancelar, -6, SpringLayout.WEST, label);
			sl_contentPanel.putConstraint(SpringLayout.SOUTH, label, 0, SpringLayout.SOUTH, contentPanel);
			sl_contentPanel.putConstraint(SpringLayout.EAST, label, 0, SpringLayout.EAST, contentPanel);
			label.setIcon(new ImageIcon(EUsuario.class.getResource("/Iconos/Find Search.png")));
			contentPanel.add(label);
		}
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==btnAceptar){
			if(sim.eliminarUsuario(textID.getText())==true){
				JOptionPane.showMessageDialog(null, "Usuario eliminado con éxito", "Aviso", JOptionPane.INFORMATION_MESSAGE);
				setVisible(false);
				textID.setText("");
			}else{
				JOptionPane.showMessageDialog(null, "No se encontró el usuario o no existe información.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
				setVisible(true);
			}
		}
		if(e.getSource()==btnCancelar){
			setVisible(false);
			textID.setText("");
		}
	}

}
