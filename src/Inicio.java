import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SpringLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class Inicio extends JFrame implements ActionListener{
	private JButton btnEntrar;
	static Inicio frame;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Inicio();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Inicio() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Inicio.class.getResource("/Iconos/Dashboard.png")));
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 781, 530);
		PanelImagen p = new PanelImagen();
		p.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(p);
		SpringLayout sl_p = new SpringLayout();
		p.setLayout(sl_p);
		
		btnEntrar = new JButton("Entrar");
		sl_p.putConstraint(SpringLayout.NORTH, btnEntrar, -80, SpringLayout.SOUTH, p);
		sl_p.putConstraint(SpringLayout.WEST, btnEntrar, -123, SpringLayout.EAST, p);
		sl_p.putConstraint(SpringLayout.SOUTH, btnEntrar, -43, SpringLayout.SOUTH, p);
		sl_p.putConstraint(SpringLayout.EAST, btnEntrar, -26, SpringLayout.EAST, p);
		btnEntrar.addActionListener(this);
		p.add(btnEntrar);
		
		JLabel lblBuap = new JLabel("");
		sl_p.putConstraint(SpringLayout.WEST, lblBuap, 10, SpringLayout.WEST, p);
		sl_p.putConstraint(SpringLayout.SOUTH, lblBuap, 133, SpringLayout.NORTH, p);
		sl_p.putConstraint(SpringLayout.EAST, lblBuap, 147, SpringLayout.WEST, p);
		lblBuap.setIcon(new ImageIcon(Inicio.class.getResource("/Iconos/buap.png")));
		p.add(lblBuap);
		
		JLabel labelItp = new JLabel("");
		sl_p.putConstraint(SpringLayout.NORTH, lblBuap, 0, SpringLayout.NORTH, labelItp);
		sl_p.putConstraint(SpringLayout.NORTH, labelItp, 0, SpringLayout.NORTH, p);
		sl_p.putConstraint(SpringLayout.WEST, labelItp, -150, SpringLayout.EAST, p);
		sl_p.putConstraint(SpringLayout.SOUTH, labelItp, -299, SpringLayout.NORTH, btnEntrar);
		sl_p.putConstraint(SpringLayout.EAST, labelItp, -10, SpringLayout.EAST, p);
		labelItp.setIcon(new ImageIcon(Inicio.class.getResource("/Iconos/Intp.png")));
		p.add(labelItp);
	}
	
	
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==btnEntrar){
			RSUPrincipal rsu = new RSUPrincipal();
			rsu.setVisible(true);
			frame.dispose();
		}
	}
}
