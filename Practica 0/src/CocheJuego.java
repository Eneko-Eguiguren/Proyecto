
public class CocheJuego extends Coche {

	

	private JLabelCoche miGrafico = new JLabelCoche();
	
	  public JLabelCoche getGrafico() {
	      return this.miGrafico;
	   }
	
	public void setPosX(double posX) {
	      super.setPosX(posX);
	      this.miGrafico.setLocation((int)posX, (int)this.posY);
	   }

	   public void setPosY(double posY) {
	      super.setPosY(posY);
	      this.miGrafico.setLocation((int)this.posX, (int)posY);
	   }

	   public void setDireccionActual(double dir) {
	      super.setMiDireccionActual(dir);
	      this.miGrafico.setGiro(this.miDireccionActual);
	      this.miGrafico.repaint();
	   }

}
