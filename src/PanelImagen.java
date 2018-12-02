import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;
	public class PanelImagen extends javax.swing.JPanel {
		public PanelImagen(){
			this.setSize(500,800);
		}
		@Override
		public void paintComponent (Graphics g){
			Dimension tamanio = getSize();
			ImageIcon imagenFondo = new ImageIcon(getClass().getResource("/Iconos/yoreciclo.jpg"));
			g.drawImage(imagenFondo.getImage(),0,0,tamanio.width, tamanio.height, null);
			setOpaque(false);
			super.paintComponent(g);
		}
}