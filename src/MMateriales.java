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
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.Toolkit;



public class MMateriales extends JDialog implements ActionListener{

	private final JPanel contentPanel = new JPanel();
	private JTextField OrganicoProm;
	private JTextField SopladoProm;
	private JTextField PetProm;
	private JTextField CartonProm;
	private JTextField PapelProm;
	private JTextField BoteLataProm;
	private JTextField BoteAlumProm;
	private JTextField LataProm;
	private JTextField FierroProm;
	private JTextField VidrioProm;
	private JTextField MiscProm;
	private JTextField OtrosProm;
	private JTextField OrganicoMax;
	private JTextField OrganicoMin;
	private JTextField SopladoMax;
	private JTextField SopladoMin;
	private JTextField PetMax;
	private JTextField PetMin;
	private JTextField CartonMax;
	private JTextField CartonMin;
	private JTextField PapelMax;
	private JTextField PapelMin;
	private JTextField BoteLataMax;
	private JTextField BoteLataMin;
	private JTextField BoteAlumMax;
	private JTextField BoteAlumMin;
	private JTextField LataMax;
	private JTextField LataMin;
	private JTextField FierroMax;
	private JTextField FierroMin;
	private JTextField VidrioMax;
	private JTextField VidrioMin;
	private JTextField MiscMax;
	private JTextField MiscMin;
	private JTextField OtrosMax;
	private JTextField OtrosMin;
	private JTextField OrganicoPre;
	private JTextField SopladoPre;
	private JTextField PetPre;
	private JTextField CartonPre;
	private JTextField PapelPre;
	private JTextField BoteLataPre;
	private JTextField BoteAlumPre;
	private JTextField LataPre;
	private JTextField FierroPre;
	private JTextField VidrioPre;
	private JTextField MiscPre;
	private JTextField OtrosPre;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rdbtnPromedioGeneracin;
	private JRadioButton rdbtnMaxMin;
	private JButton okButton;
	private JButton cancelButton;
	private JLabel lblId;
	private JTextField textID;
	private boolean opcion=false;
	private boolean opcion2=false;
	private Simulacion simulacion;
	private int contador=0;
	private Random rnd;
	double organico, soplado, pet, carton, papel, botelata, botealum, lata, fierro, misce, vidrio, otros;
	double porganico, psoplado, ppet, pcarton, ppapel, pbotelata, pbotealum, plata, pfierro, pmisce, pvidrio, potros;
	
	public MMateriales(Simulacion sim) {
		setModal(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(SimMateriales.class.getResource("/Iconos/Tools.png")));
		setTitle("Modificar Datos de los Materiales");
		setBounds(100, 100, 880, 570);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.NORTH);
		
		simulacion = sim;
		rnd = new Random();
		contador=0;
		
		
		JLabel lblOrganico = new JLabel("Org\u00E1nico:");
		
		JLabel lblPlsticosoplado = new JLabel("Pl\u00E1stico (Soplado):");
		
		JLabel lblPlsticopet = new JLabel("Pl\u00E1stico (PET):");
		
		JLabel lblCartn = new JLabel("Cart\u00F3n:");
		
		JLabel lblPapel = new JLabel("Papel:");
		
		JLabel lblMetalboteLata = new JLabel("Metal (Bote Lata):");
		
		JLabel lblMetalboteAluminio = new JLabel("Metal (Bote Aluminio):");
		
		JLabel lblMetallata = new JLabel("Metal (Lata):");
		
		JLabel lblMetalfierroCorto = new JLabel("Metal (Fierro Corto):");
		
		JLabel lblTetrapackYVidrio = new JLabel("Tetrapack y Vidrio:");
		
		JLabel lblMiscelaneo = new JLabel("Miscel\u00E1neo:");
		
		JLabel lblOtros = new JLabel("Otros:");
		
		rdbtnPromedioGeneracin = new JRadioButton("Promedio de Generaci\u00F3n");
		rdbtnPromedioGeneracin.addActionListener(this);
		buttonGroup.add(rdbtnPromedioGeneracin);
		
		rdbtnMaxMin = new JRadioButton("Rango M\u00E1ximo y M\u00EDnimo");
		rdbtnMaxMin.addActionListener(this);
		buttonGroup.add(rdbtnMaxMin);
		
		JLabel lblKghabitanteda = new JLabel("Kg/Habitante/D\u00EDa");
		
		JLabel label = new JLabel("Kg/Habitante/D\u00EDa");
		
		JLabel lblMximo = new JLabel("M\u00E1ximo");
		
		JLabel lblMnimo = new JLabel("M\u00EDnimo");
		
		OrganicoProm = new JTextField();
		OrganicoProm.setColumns(10);
		
		SopladoProm = new JTextField();
		SopladoProm.setColumns(10);
		
		PetProm = new JTextField();
		PetProm.setColumns(10);
		
		CartonProm = new JTextField();
		CartonProm.setColumns(10);
		
		PapelProm = new JTextField();
		PapelProm.setColumns(10);
		
		BoteLataProm = new JTextField();
		BoteLataProm.setColumns(10);
		
		BoteAlumProm = new JTextField();
		BoteAlumProm.setColumns(10);
		
		LataProm = new JTextField();
		LataProm.setColumns(10);
		
		FierroProm = new JTextField();
		FierroProm.setColumns(10);
		
		VidrioProm = new JTextField();
		VidrioProm.setColumns(10);
		
		MiscProm = new JTextField();
		MiscProm.setColumns(10);
		
		OtrosProm = new JTextField();
		OtrosProm.setColumns(10);
		
		OrganicoMax = new JTextField();
		OrganicoMax.setColumns(10);
		
		OrganicoMin = new JTextField();
		OrganicoMin.setColumns(10);
		
		SopladoMax = new JTextField();
		SopladoMax.setColumns(10);
		
		SopladoMin = new JTextField();
		SopladoMin.setColumns(10);
		
		PetMax = new JTextField();
		PetMax.setColumns(10);
		
		PetMin = new JTextField();
		PetMin.setColumns(10);
		
		CartonMax = new JTextField();
		CartonMax.setColumns(10);
		
		CartonMin = new JTextField();
		CartonMin.setColumns(10);
		
		PapelMax = new JTextField();
		PapelMax.setColumns(10);
		
		PapelMin = new JTextField();
		PapelMin.setColumns(10);
		
		BoteLataMax = new JTextField();
		BoteLataMax.setColumns(10);
		
		BoteLataMin = new JTextField();
		BoteLataMin.setColumns(10);
		
		BoteAlumMax = new JTextField();
		BoteAlumMax.setColumns(10);
		
		BoteAlumMin = new JTextField();
		BoteAlumMin.setColumns(10);
		
		LataMax = new JTextField();
		LataMax.setColumns(10);
		
		LataMin = new JTextField();
		LataMin.setColumns(10);
		
		FierroMax = new JTextField();
		FierroMax.setColumns(10);
		
		FierroMin = new JTextField();
		FierroMin.setColumns(10);
		
		VidrioMax = new JTextField();
		VidrioMax.setColumns(10);
		
		VidrioMin = new JTextField();
		VidrioMin.setColumns(10);
		
		MiscMax = new JTextField();
		MiscMax.setColumns(10);
		
		MiscMin = new JTextField();
		MiscMin.setColumns(10);
		
		OtrosMax = new JTextField();
		OtrosMax.setColumns(10);
		
		OtrosMin = new JTextField();
		OtrosMin.setColumns(10);
		
		JLabel lblPrecioDeMateriales = new JLabel("Precio de Materiales por Kg.");
		
		OrganicoPre = new JTextField();
		OrganicoPre.setColumns(10);
		
		SopladoPre = new JTextField();
		SopladoPre.setColumns(10);
		
		PetPre = new JTextField();
		PetPre.setColumns(10);
		
		CartonPre = new JTextField();
		CartonPre.setColumns(10);
		
		PapelPre = new JTextField();
		PapelPre.setColumns(10);
		
		BoteLataPre = new JTextField();
		BoteLataPre.setColumns(10);
		
		BoteAlumPre = new JTextField();
		BoteAlumPre.setColumns(10);
		
		LataPre = new JTextField();
		LataPre.setColumns(10);
		
		FierroPre = new JTextField();
		FierroPre.setColumns(10);
		
		VidrioPre = new JTextField();
		VidrioPre.setColumns(10);
		
		MiscPre = new JTextField();
		MiscPre.setColumns(10);
		
		OtrosPre = new JTextField();
		OtrosPre.setColumns(10);
		
		lblId = new JLabel("ID:");
		
		textID = new JTextField();
		textID.setColumns(10);
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblOrganico)
						.addComponent(lblPlsticosoplado)
						.addComponent(lblPlsticopet)
						.addComponent(lblCartn)
						.addComponent(lblPapel)
						.addComponent(lblMetalboteLata)
						.addComponent(lblMetalboteAluminio)
						.addComponent(lblMetallata)
						.addComponent(lblMetalfierroCorto)
						.addComponent(lblTetrapackYVidrio)
						.addComponent(lblMiscelaneo)
						.addComponent(lblOtros))
					.addGap(21)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(lblKghabitanteda)
							.addGap(135)
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addGap(119)
							.addComponent(lblId))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(rdbtnPromedioGeneracin)
							.addGap(51)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addComponent(lblMximo)
									.addGap(77)
									.addComponent(lblMnimo))
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addComponent(rdbtnMaxMin)
									.addGap(152)
									.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
										.addComponent(OrganicoPre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblPrecioDeMateriales)
										.addComponent(SopladoPre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(PetPre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(CartonPre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(PapelPre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(BoteLataPre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(BoteAlumPre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(LataPre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(FierroPre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(VidrioPre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(MiscPre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(OtrosPre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(textID, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)))))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(OrganicoProm)
								.addComponent(SopladoProm)
								.addComponent(PetProm)
								.addComponent(CartonProm)
								.addComponent(PapelProm)
								.addComponent(BoteLataProm)
								.addComponent(LataProm)
								.addComponent(FierroProm)
								.addComponent(VidrioProm)
								.addComponent(MiscProm)
								.addComponent(OtrosProm)
								.addComponent(BoteAlumProm))
							.addGap(69)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(OrganicoMax, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(SopladoMax, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(PetMax, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(CartonMax, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(PapelMax, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(BoteLataMax, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(BoteAlumMax, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(LataMax, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(FierroMax, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(VidrioMax, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(MiscMax, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(OtrosMax, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(32)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(OtrosMin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(MiscMin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(VidrioMin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(FierroMin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(LataMin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(BoteAlumMin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(BoteLataMin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(PapelMin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(CartonMin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(PetMin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(SopladoMin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(OrganicoMin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(121, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(rdbtnPromedioGeneracin)
						.addComponent(rdbtnMaxMin)
						.addComponent(lblPrecioDeMateriales))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMximo)
						.addComponent(lblMnimo))
					.addGap(20)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblOrganico)
						.addComponent(OrganicoProm, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(OrganicoMax, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(OrganicoMin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(OrganicoPre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPlsticosoplado)
						.addComponent(SopladoProm, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(SopladoMax, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(SopladoMin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(SopladoPre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPlsticopet)
						.addComponent(PetProm, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(PetMax, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(PetMin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(PetPre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCartn)
						.addComponent(CartonProm, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(CartonMax, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(CartonMin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(CartonPre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPapel)
						.addComponent(PapelProm, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(PapelMax, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(PapelMin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(PapelPre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMetalboteLata)
						.addComponent(BoteLataProm, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(BoteLataMax, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(BoteLataMin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(BoteLataPre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMetalboteAluminio)
						.addComponent(BoteAlumProm, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(BoteAlumMax, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(BoteAlumMin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(BoteAlumPre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMetallata)
						.addComponent(LataProm, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(LataMax, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(LataMin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(LataPre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMetalfierroCorto)
						.addComponent(FierroProm, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(FierroMax, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(FierroMin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(FierroPre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTetrapackYVidrio)
						.addComponent(VidrioProm, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(VidrioMax, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(VidrioMin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(VidrioPre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMiscelaneo)
						.addComponent(MiscProm, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(MiscMax, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(MiscMin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(MiscPre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblOtros)
						.addComponent(OtrosProm, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(OtrosMax, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(OtrosMin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(OtrosPre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblKghabitanteda)
								.addComponent(label))
							.addContainerGap())
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblId)
							.addComponent(textID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
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
	}
	
	public void actionPerformed(ActionEvent e){

		if(e.getSource()==rdbtnPromedioGeneracin){
			opcion=true;
			opcion2=false;
			OrganicoProm.setEditable(true);
			OrganicoProm.setText("");
			SopladoProm.setEditable(true);
			SopladoProm.setText("");
			PetProm.setEditable(true);
			PetProm.setText("");
			CartonProm.setEditable(true);
			CartonProm.setText("");
			PapelProm.setEditable(true);
			PapelProm.setText("");
			BoteLataProm.setEditable(true);
			BoteLataProm.setText("");
			BoteAlumProm.setEditable(true);
			BoteAlumProm.setText("");
			LataProm.setEditable(true);
			LataProm.setText("");
			FierroProm.setEditable(true);
			FierroProm.setText("");
			VidrioProm.setEditable(true);
			VidrioProm.setText("");
			MiscProm.setEditable(true);
			MiscProm.setText("");
			OtrosProm.setEditable(true);
			OtrosProm.setText("");
			//Visible False
			OrganicoMax.setEditable(false);
			OrganicoMax.setText("");
			OrganicoMin.setEditable(false);
			OrganicoMin.setText("");
			SopladoMax.setEditable(false);
			SopladoMax.setText("");
			SopladoMin.setEditable(false);
			SopladoMin.setText("");
			PetMax.setEditable(false);
			PetMax.setText("");
			PetMin.setEditable(false);
			PetMin.setText("");
			CartonMax.setEditable(false);
			CartonMax.setText("");
			CartonMin.setEditable(false);
			CartonMin.setText("");
			PapelMax.setEditable(false);
			PapelMax.setText("");
			PapelMin.setEditable(false);
			PapelMin.setText("");
			BoteLataMax.setEditable(false);
			BoteLataMax.setText("");
			BoteLataMin.setEditable(false);
			BoteLataMin.setText("");
			BoteAlumMax.setEditable(false);
			BoteAlumMax.setText("");
			BoteAlumMin.setEditable(false);
			BoteAlumMin.setText("");
			LataMax.setEditable(false);
			LataMax.setText("");
			LataMin.setEditable(false);
			LataMin.setText("");
			FierroMax.setEditable(false);
			FierroMax.setText("");
			FierroMin.setEditable(false);
			FierroMin.setText("");
			VidrioMax.setEditable(false);
			VidrioMax.setText("");
			VidrioMin.setEditable(false);
			VidrioMin.setText("");
			MiscMax.setEditable(false);
			MiscMax.setText("");
			MiscMin.setEditable(false);
			MiscMin.setText("");
			OtrosMax.setEditable(false);
			OtrosMax.setText("");
			OtrosMin.setEditable(false);
			OtrosMin.setText("");
			
		}
		
		
		if(e.getSource()==rdbtnMaxMin){
			opcion2=true;
			opcion=false;
			OrganicoMax.setEditable(true);
			OrganicoMax.setText("");
			OrganicoMin.setEditable(true);
			OrganicoMin.setText("");
			SopladoMax.setEditable(true);
			SopladoMax.setText("");
			SopladoMin.setEditable(true);
			SopladoMin.setText("");
			PetMax.setEditable(true);
			PetMax.setText("");
			PetMin.setEditable(true);
			PetMin.setText("");
			CartonMax.setEditable(true);
			CartonMax.setText("");
			CartonMin.setEditable(true);
			CartonMin.setText("");
			PapelMax.setEditable(true);
			PapelMax.setText("");
			PapelMin.setEditable(true);
			PapelMin.setText("");
			BoteLataMax.setEditable(true);
			BoteLataMax.setText("");
			BoteLataMin.setEditable(true);
			BoteLataMin.setText("");
			BoteAlumMax.setEditable(true);
			BoteAlumMax.setText("");
			BoteAlumMin.setEditable(true);
			BoteAlumMin.setText("");
			LataMax.setEditable(true);
			LataMax.setText("");
			LataMin.setEditable(true);
			LataMin.setText("");
			FierroMax.setEditable(true);
			FierroMax.setText("");
			FierroMin.setEditable(true);
			FierroMin.setText("");
			VidrioMax.setEditable(true);
			VidrioMax.setText("");
			VidrioMin.setEditable(true);
			VidrioMin.setText("");
			MiscMax.setEditable(true);
			MiscMax.setText("");
			MiscMin.setEditable(true);
			MiscMin.setText("");
			OtrosMax.setEditable(true);
			OtrosMax.setText("");
			OtrosMin.setEditable(true);
			OtrosMin.setText("");
			
			//Visible False
			OrganicoProm.setEditable(false);
			OrganicoProm.setText("");
			SopladoProm.setEditable(false);
			SopladoProm.setText("");
			PetProm.setEditable(false);
			PetProm.setText("");
			CartonProm.setEditable(false);
			CartonProm.setText("");
			PapelProm.setEditable(false);
			PapelProm.setText("");
			BoteLataProm.setEditable(false);
			BoteLataProm.setText("");
			BoteAlumProm.setEditable(false);
			BoteAlumProm.setText("");
			LataProm.setEditable(false);
			LataProm.setText("");
			FierroProm.setEditable(false);
			FierroProm.setText("");
			VidrioProm.setEditable(false);
			VidrioProm.setText("");
			MiscProm.setEditable(false);
			MiscProm.setText("");
			OtrosProm.setEditable(false);
			OtrosProm.setText("");
		}
		
		if(e.getSource()==okButton){
			
			if(opcion==true){
				try{
					organico=Double.parseDouble(OrganicoProm.getText());
					soplado=Double.parseDouble(SopladoProm.getText());
					pet=Double.parseDouble(PetProm.getText());
					carton=Double.parseDouble(CartonProm.getText());
					papel=Double.parseDouble(PapelProm.getText());
					botelata=Double.parseDouble(BoteLataProm.getText());
					botealum=Double.parseDouble(BoteAlumProm.getText());
					lata=Double.parseDouble(LataProm.getText());
					fierro=Double.parseDouble(FierroProm.getText());
					misce=Double.parseDouble(MiscProm.getText());
					vidrio=Double.parseDouble(VidrioProm.getText());
					otros=Double.parseDouble(OtrosProm.getText());
														
					simulacion.setMateriales(contador, organico, soplado, pet, carton, papel, botelata, botealum, lata, fierro, vidrio, misce, otros);

					porganico=Double.parseDouble(OrganicoPre.getText());
					psoplado=Double.parseDouble(SopladoPre.getText());
					ppet=Double.parseDouble(PetPre.getText());
					pcarton=Double.parseDouble(CartonPre.getText());
					ppapel=Double.parseDouble(PapelPre.getText());
					pbotelata=Double.parseDouble(BoteLataPre.getText());
					pbotealum=Double.parseDouble(BoteAlumPre.getText());
					plata=Double.parseDouble(LataPre.getText());
					pfierro=Double.parseDouble(FierroPre.getText());
					pvidrio=Double.parseDouble(VidrioPre.getText());
					pmisce=Double.parseDouble(MiscPre.getText());
					potros=Double.parseDouble(OtrosPre.getText());	
							
					simulacion.setPrecio(contador, porganico, psoplado, ppet, pcarton, ppapel, pbotelata, pbotealum, plata, pfierro, pmisce, pvidrio, potros);
						
					setVisible(false);
						
					OrganicoProm.setText("");
					SopladoProm.setText("");
					PetProm.setText("");
					CartonProm.setText("");
					PapelProm.setText("");
					BoteLataProm.setText("");
					BoteAlumProm.setText("");
					LataProm.setText("");
					FierroProm.setText("");
					VidrioProm.setText("");
					MiscProm.setText("");
					OtrosProm.setText("");
						
					OrganicoPre.setText("");
					SopladoPre.setText("");
					PetPre.setText("");
					CartonPre.setText("");
					PapelPre.setText("");
					BoteLataPre.setText("");
					BoteAlumPre.setText("");
					LataPre.setText("");
					FierroPre.setText("");
					VidrioPre.setText("");
					MiscPre.setText("");
					OtrosPre.setText("");
							
					}catch(Exception c){
						JOptionPane.showMessageDialog(null, "Formato de datos invalido.\nFavor de verificar.", "Aviso", JOptionPane.WARNING_MESSAGE);
						setVisible(true);
					}
				
			}
			else if(opcion2==true){
				try{
					organico=this.getPromedioRandom(Double.parseDouble(OrganicoMax.getText()),Double.parseDouble(OrganicoMin.getText()));
					soplado=this.getPromedioRandom(Double.parseDouble(SopladoMax.getText()),Double.parseDouble(SopladoMin.getText()));
					pet=this.getPromedioRandom(Double.parseDouble(PetMax.getText()),Double.parseDouble(PetMin.getText()));
					carton=this.getPromedioRandom(Double.parseDouble(CartonMax.getText()),Double.parseDouble(CartonMin.getText()));
					papel=this.getPromedioRandom(Double.parseDouble(PapelMax.getText()), Double.parseDouble(PapelMin.getText()));
					botelata=this.getPromedioRandom(Double.parseDouble(BoteLataMax.getText()),Double.parseDouble(BoteLataMin.getText()));
					botealum=this.getPromedioRandom(Double.parseDouble(BoteAlumMax.getText()),Double.parseDouble(BoteAlumMin.getText()));
					lata=this.getPromedioRandom(Double.parseDouble(LataMax.getText()), Double.parseDouble(LataMin.getText()));
					fierro=this.getPromedioRandom(Double.parseDouble(FierroMax.getText()),Double.parseDouble(FierroMin.getText()));
					misce=this.getPromedioRandom(Double.parseDouble(MiscMax.getText()), Double.parseDouble(MiscMin.getText()));
					vidrio=this.getPromedioRandom(Double.parseDouble(VidrioMax.getText()), Double.parseDouble(VidrioMin.getText()));
					otros=this.getPromedioRandom(Double.parseDouble(OtrosMax.getText()),Double.parseDouble(OtrosMin.getText()));
						
					simulacion.setMateriales(contador, organico, soplado, pet, carton, papel, botelata, botealum, lata, fierro, vidrio, misce, otros);
						
					porganico=Double.parseDouble(OrganicoPre.getText());
					psoplado=Double.parseDouble(SopladoPre.getText());
					ppet=Double.parseDouble(PetPre.getText());
					pcarton=Double.parseDouble(CartonPre.getText());
					ppapel=Double.parseDouble(PapelPre.getText());
					pbotelata=Double.parseDouble(BoteLataPre.getText());
					pbotealum=Double.parseDouble(BoteAlumPre.getText());
					plata=Double.parseDouble(LataPre.getText());
					pfierro=Double.parseDouble(FierroPre.getText());
					pvidrio=Double.parseDouble(VidrioPre.getText());
					pmisce=Double.parseDouble(MiscPre.getText());
					potros=Double.parseDouble(OtrosPre.getText());
						
					simulacion.setPrecio(contador, porganico, psoplado, ppet, pcarton, ppapel, pbotelata, pbotealum, plata, pfierro, pmisce, pvidrio, potros);
					
					setVisible(false);

					OrganicoMax.setText("");
					OrganicoMin.setText("");
					SopladoMax.setText("");
					SopladoMin.setText("");
					PetMax.setText("");
					PetMin.setText("");
					CartonMax.setText("");
					CartonMin.setText("");
					PapelMax.setText("");
					PapelMin.setText("");
					BoteLataMax.setText("");
					BoteLataMin.setText("");
					BoteAlumMax.setText("");
					BoteAlumMin.setText("");
					LataMax.setText("");
					LataMin.setText("");
					FierroMax.setText("");
					FierroMin.setText("");
					VidrioMax.setText("");
					VidrioMin.setText("");
					MiscMax.setText("");
					MiscMin.setText("");
					OtrosMax.setText("");
					OtrosMin.setText("");
						
					OrganicoPre.setText("");
					SopladoPre.setText("");
					PetPre.setText("");
					CartonPre.setText("");
					PapelPre.setText("");
					BoteLataPre.setText("");
					BoteAlumPre.setText("");
					LataPre.setText("");
					FierroPre.setText("");
					VidrioPre.setText("");
					MiscPre.setText("");
					OtrosPre.setText("");
						
					}catch(Exception c){
						JOptionPane.showMessageDialog(null, "Formato de datos invalido.\nFavor de verificar.", "Aviso", JOptionPane.WARNING_MESSAGE);
						setVisible(true);
					}
			}
		}
		
		if(e.getSource()==cancelButton){
			setVisible(false);
			OrganicoProm.setText("");
			SopladoProm.setText("");
			PetProm.setText("");
			CartonProm.setText("");
			PapelProm.setText("");
			BoteLataProm.setText("");
			BoteAlumProm.setText("");
			LataProm.setText("");
			FierroProm.setText("");
			VidrioProm.setText("");
			MiscProm.setText("");
			OtrosProm.setText("");
				
			OrganicoPre.setText("");
			SopladoPre.setText("");
			PetPre.setText("");
			CartonPre.setText("");
			PapelPre.setText("");
			BoteLataPre.setText("");
			BoteAlumPre.setText("");
			LataPre.setText("");
			FierroPre.setText("");
			VidrioPre.setText("");
			MiscPre.setText("");
			OtrosPre.setText("");
			
			OrganicoMax.setText("");
			OrganicoMin.setText("");
			SopladoMax.setText("");
			SopladoMin.setText("");
			PetMax.setText("");
			PetMin.setText("");
			CartonMax.setText("");
			CartonMin.setText("");
			PapelMax.setText("");
			PapelMin.setText("");
			BoteLataMax.setText("");
			BoteLataMin.setText("");
			BoteAlumMax.setText("");
			BoteAlumMin.setText("");
			LataMax.setText("");
			LataMin.setText("");
			FierroMax.setText("");
			FierroMin.setText("");
			VidrioMax.setText("");
			VidrioMin.setText("");
			MiscMax.setText("");
			MiscMin.setText("");
			OtrosMax.setText("");
			OtrosMin.setText("");
		}
		
	}
	
	public double getPromedioRandom(double Maximo, double Minimo){
		
		return (double)(rnd.nextDouble()*Maximo+Minimo);
		
	}
	public void setTexto(int indice){
		OrganicoProm.setText(Double.toString(simulacion.materiales[indice].getOrganico()));
		SopladoProm.setText(Double.toString(simulacion.materiales[indice].getSoplado()));
		PetProm.setText(Double.toString(simulacion.materiales[indice].getPet()));
		CartonProm.setText(Double.toString(simulacion.materiales[indice].getCarton()));
		PapelProm.setText(Double.toString(simulacion.materiales[indice].getPapel()));
		BoteLataProm.setText(Double.toString(simulacion.materiales[indice].getBoteLata()));
		BoteAlumProm.setText(Double.toString(simulacion.materiales[indice].getBoteAlum()));
		LataProm.setText(Double.toString(simulacion.materiales[indice].getLata()));
		FierroProm.setText(Double.toString(simulacion.materiales[indice].getFierro()));
		VidrioProm.setText(Double.toString(simulacion.materiales[indice].getVidrio()));
		MiscProm.setText(Double.toString(simulacion.materiales[indice].getMiscelaneo()));
		OtrosProm.setText(Double.toString(simulacion.materiales[indice].getOtros()));
		
		OrganicoPre.setText(Double.toString(simulacion.precio[indice].getOrganico()));
		SopladoPre.setText(Double.toString(simulacion.precio[indice].getSoplado()));
		PetPre.setText(Double.toString(simulacion.precio[indice].getPet()));
		CartonPre.setText(Double.toString(simulacion.precio[indice].getCarton()));
		PapelPre.setText(Double.toString(simulacion.precio[indice].getPapel()));
		BoteLataPre.setText(Double.toString(simulacion.precio[indice].getBoteLata()));
		BoteAlumPre.setText(Double.toString(simulacion.precio[indice].getBoteAlum()));
		LataPre.setText(Double.toString(simulacion.precio[indice].getLata()));
		FierroPre.setText(Double.toString(simulacion.precio[indice].getFierro()));
		VidrioPre.setText(Double.toString(simulacion.precio[indice].getVidrio()));
		MiscPre.setText(Double.toString(simulacion.precio[indice].getMiscelaneo()));
		OtrosPre.setText(Double.toString(simulacion.precio[indice].getOtros()));
		contador=indice;
	}
}

