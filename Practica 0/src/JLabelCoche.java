import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.ImageObserver;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class JLabelCoche extends JLabel{
	private static final long serialVersionUID = 1L;
	public static final int TAMANYO_COCHE = 100;
	private double miGiro = 1.5707963267948966D;
	
	public JLabelCoche() {
		try {
			this.setIcon(new ImageIcon(JLabelCoche.class.getResource("coche.png").toURI().toURL()));
		} catch(Exception e) {
			System.err.println("coche.png no encontrado");
			e.printStackTrace();
		}
		 this.setBounds(0, 0, 100, 100);
	}
	
	public void setGiro(double gradosGiro) {
	      this.miGiro = gradosGiro / 180.0D * 3.141592653589793D;
	      this.miGiro = -this.miGiro;
	      ++this.miGiro;
	   }
	
	
	
	protected void paintComponent(Graphics g) {
	      Image img = ((ImageIcon)this.getIcon()).getImage();
	      Graphics2D g2 = (Graphics2D)g;
	      g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	      g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
	      g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	      g2.rotate(this.miGiro, 50.0D, 50.0D);
	      g2.drawImage(img, 0, 0, 100, 100, (ImageObserver)null);
	   }
}
