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
