import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Toolkit;


public class SimLugar extends JDialog implements ActionListener{

	private final JPanel contentPanel = new JPanel();
	private JTextField textEstado;
	private JTextField textMunicipio;
	private JTextField textColonia;
	private JTextField textCodigoP;
	private JTextField textDomicilio;
	private JTextField textFracc;
	private JTextField textNoCasas;
	private JTextField textHabCasa;
	private JTextField textToHabi;
	private JButton okButton;
	private JButton cancelButton;
	private JLabel lblId;
	private JTextField textID;
	private Simulacion simulacion;
	private int contador=0; 
	
	public SimLugar(Simulacion simula) {
		setModal(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(SimLugar.class.getResource("/Iconos/Map.png")));
		setResizable(false);
		setBounds(100, 100, 599, 450);
		setTitle("Datos del Lugar");
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		simulacion= simula;
		contador=simulacion.tamaño();
		
		JLabel lblEstado = new JLabel("Estado:");
		
		textEstado = new JTextField();
		textEstado.setColumns(10);
		
		JLabel lblMunicipio = new JLabel("Municipio:");
		
		JLabel lblColonia = new JLabel("Colonia:");
		
		textMunicipio = new JTextField();
		textMunicipio.setColumns(10);
		
		textColonia = new JTextField();
		textColonia.setColumns(10);
		
		JLabel lblCP = new JLabel("C.P.:");
		
		textCodigoP = new JTextField();
		textCodigoP.setColumns(10);
		
		JLabel lblCalle = new JLabel("Domicilio:");
		
		textDomicilio = new JTextField();
		textDomicilio.setColumns(10);
		
		JLabel lblNombreFrac = new JLabel("Fraccionamiento \u00F3 U. Habitacional:");
		
		textFracc = new JTextField();
		textFracc.setColumns(10);
		
		JLabel lblNoCasas = new JLabel("N\u00FAmero de casas:");
		
		textNoCasas = new JTextField();
		textNoCasas.setColumns(10);
		
		JLabel lblHabCasa = new JLabel("Promedio de habitantes por casa:");
		
		JLabel lblToHabi = new JLabel("N\u00FAmero total de habitantes:");
		
		
		textHabCasa = new JTextField();
		textHabCasa.setColumns(10);
		
		textToHabi = new JTextField();
		textToHabi.setEditable(false);
		textToHabi.setColumns(10);
		
		lblId = new JLabel("ID:");
		
		textID = new JTextField();
		textID.setColumns(10);
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblEstado)
								.addComponent(lblMunicipio)
								.addComponent(lblColonia)
								.addComponent(lblCP)
								.addComponent(lblCalle)
								.addComponent(lblNombreFrac)
								.addComponent(lblNoCasas)
								.addComponent(lblToHabi)
								.addComponent(lblHabCasa))
							.addGap(129)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(textToHabi, 244, 244, Short.MAX_VALUE)
								.addComponent(textNoCasas)
								.addComponent(textFracc)
								.addComponent(textDomicilio, Alignment.TRAILING)
								.addComponent(textCodigoP)
								.addComponent(textColonia)
								.addComponent(textMunicipio)
								.addComponent(textEstado, GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
								.addComponent(textHabCasa)))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(149)
							.addComponent(lblId)
							.addGap(18)
							.addComponent(textID, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(34, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(23)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEstado)
						.addComponent(textEstado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMunicipio)
						.addComponent(textMunicipio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textColonia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblColonia))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textCodigoP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCP))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textDomicilio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCalle))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombreFrac)
						.addComponent(textFracc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNoCasas)
						.addComponent(textNoCasas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblHabCasa)
						.addComponent(textHabCasa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblToHabi)
						.addComponent(textToHabi, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(48)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblId)
						.addComponent(textID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(19, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("Aceptar");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
				okButton.addActionListener(this);
			}
			{
				cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
				cancelButton.addActionListener(this);
			}
		}
		this.upText();
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==okButton){
			if(contador<10){
				try{
					Lugar lug= new Lugar(textEstado.getText(), textMunicipio.getText(), textColonia.getText(), textCodigoP.getText(), textDomicilio.getText(), textFracc.getText(), textNoCasas.getText(), textHabCasa.getText(), textToHabi.getText(),textID.getText());
					simulacion.DatosLugar(contador, lug);
					textEstado.setText("");
					textMunicipio.setText("");
					textColonia.setText("");
					textCodigoP.setText("");
					textDomicilio.setText("");
					textFracc.setText("");
					textNoCasas.setText("");
					textHabCasa.setText("");
					textToHabi.setText("");
					setVisible(false);
					contador++;
				}catch(Exception c){
					JOptionPane.showMessageDialog(null, "Verifique que todos los datos\n estén completos", "Aviso", JOptionPane.WARNING_MESSAGE);
				System.out.println(c.getMessage());
					setVisible(true);
				}
			}
			else{
				JOptionPane.showMessageDialog(null, "Solo se permiten datos de 10 lugares\npara la simulación.", "Aviso", JOptionPane.WARNING_MESSAGE);
			}			
		}
		if(e.getSource()==cancelButton){
			textEstado.setText("");
			textMunicipio.setText("");
			textColonia.setText("");
			textCodigoP.setText("");
			textDomicilio.setText("");
			textFracc.setText("");
			textNoCasas.setText("");
			textHabCasa.setText("");
			textToHabi.setText("");
			
			setVisible(false);
		}		
	}
	
	public void upText(){
		/*while(true){
			if((textNoCasas.getText().equalsIgnoreCase("") && textHabCasa.getText().equalsIgnoreCase("")) == (textNoCasas.getText().equalsIgnoreCase("") || textHabCasa.getText().equalsIgnoreCase(""))){
				try{
					textToHabi.setText(String.valueOf(Integer.parseInt(textNoCasas.getText())*Integer.parseInt(textHabCasa.getText())));
					break;
				}catch(Exception d){
					JOptionPane.showMessageDialog(null, "Verifique que los datos\n estén correctos", "Aviso", JOptionPane.WARNING_MESSAGE);
					System.out.println(d.getMessage());
				}
			}
		}*/
	}
}
