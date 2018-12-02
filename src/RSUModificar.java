import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import javax.swing.JLabel;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JRadioButton;
import javax.swing.ImageIcon;


public class RSUModificar extends JDialog implements ActionListener{

	private final JPanel contentPanel = new JPanel();
	private final ButtonGroup buttonGroup= new ButtonGroup();
	private JRadioButton rdLugar;
	private JRadioButton rdMP;
	private JButton btnOk;
	private JLabel lblNewLabel;
	private MID mid;


	public RSUModificar(Simulacion simulacion) {
		setTitle("\u00BFModificar Datos?");
		setIconImage(Toolkit.getDefaultToolkit().getImage(RSUModificar.class.getResource("/Iconos/Edit.png")));
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		SpringLayout sl_contentPanel = new SpringLayout();
		contentPanel.setLayout(sl_contentPanel);
		mid = new MID(simulacion);
		
		JLabel lblquDatosDesea = new JLabel("\u00BFQu\u00E9 datos desea modificar?");
		sl_contentPanel.putConstraint(SpringLayout.NORTH, lblquDatosDesea, 38, SpringLayout.NORTH, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.WEST, lblquDatosDesea, 139, SpringLayout.WEST, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.SOUTH, lblquDatosDesea, 74, SpringLayout.NORTH, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.EAST, lblquDatosDesea, 283, SpringLayout.WEST, contentPanel);
		contentPanel.add(lblquDatosDesea);
		
		rdLugar = new JRadioButton("Lugar");
		sl_contentPanel.putConstraint(SpringLayout.NORTH, rdLugar, 89, SpringLayout.NORTH, contentPanel);
		rdLugar.addActionListener(this);
		buttonGroup.add(rdLugar);
		contentPanel.add(rdLugar);
		
		rdMP = new JRadioButton("Materiales y Precio");
		sl_contentPanel.putConstraint(SpringLayout.EAST, rdLugar, -136, SpringLayout.WEST, rdMP);
		sl_contentPanel.putConstraint(SpringLayout.NORTH, rdMP, 0, SpringLayout.NORTH, rdLugar);
		sl_contentPanel.putConstraint(SpringLayout.EAST, rdMP, -52, SpringLayout.EAST, contentPanel);
		rdMP.addActionListener(this);
		buttonGroup.add(rdMP);
		contentPanel.add(rdMP);
		
		btnOk = new JButton("OK");
		btnOk.addActionListener(this);
		sl_contentPanel.putConstraint(SpringLayout.NORTH, btnOk, -64, SpringLayout.SOUTH, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.SOUTH, btnOk, -28, SpringLayout.SOUTH, contentPanel);
		contentPanel.add(btnOk);
		
		lblNewLabel = new JLabel("");
		sl_contentPanel.putConstraint(SpringLayout.WEST, btnOk, -122, SpringLayout.WEST, lblNewLabel);
		sl_contentPanel.putConstraint(SpringLayout.EAST, btnOk, -63, SpringLayout.WEST, lblNewLabel);
		sl_contentPanel.putConstraint(SpringLayout.NORTH, lblNewLabel, -128, SpringLayout.SOUTH, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.WEST, lblNewLabel, -128, SpringLayout.EAST, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.SOUTH, lblNewLabel, 0, SpringLayout.SOUTH, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.EAST, lblNewLabel, 0, SpringLayout.EAST, contentPanel);
		lblNewLabel.setIcon(new ImageIcon(RSUModificar.class.getResource("/Iconos/Document Edit.png")));
		contentPanel.add(lblNewLabel);
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==rdLugar){
			mid.Opcion('a');
			mid.setVisible(true);
		}
		if(e.getSource()==rdMP){
			mid.Opcion('b');
			mid.setVisible(true);
		}
		if(e.getSource()==btnOk){
			setVisible(false);
		}
	}
}
