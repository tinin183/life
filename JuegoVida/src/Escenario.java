import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Paint;

import javax.swing.JPanel;


public class Escenario extends JPanel{
	Thread t = new Thread();
	private int TAMA�O = 10;
	private final int MARGEN = 30;
	EspacioCelular espacio = new EspacioCelular(20, 40);
	boolean prueba=true;
	
	private int ancho= espacio.getArray()[0].length*TAMA�O;
	private int alto= espacio.getArray().length*TAMA�O;
	
	public Escenario(){
		setPreferredSize( new Dimension(ancho + MARGEN*2,alto+MARGEN*2));
		espacio.espacioCelularAleatorio(8);
		t=null;
	}
	
	
	public void paint(Graphics g){
		
		
		//BACKGROUND
		g.setColor(Color.white);
		g.fillRect(0, 0, ancho+MARGEN*2, alto+MARGEN*2);
		
		for(int i =0; i<espacio.getArray().length;i++){
			for(int j=0; j<espacio.getArray()[0].length;j++){
				if(espacio.getArray()[i][j].getEstado() == Celula.VIVA && j%2 == 0){
				g.setColor(Color.red);
				g.fillOval((TAMA�O*j)+MARGEN, (TAMA�O*i)+MARGEN, TAMA�O, TAMA�O);
				}
				if(espacio.getArray()[i][j].getEstado() == Celula.VIVA && j%2 == 1){
					g.setColor(Color.black);
					g.fillOval((TAMA�O*j)+MARGEN, (TAMA�O*i)+MARGEN, TAMA�O, TAMA�O);
					}
			}
		}
	}
		
	public EspacioCelular getEspacio(){
		return espacio;
	}	
	
	
	public void generar(){
		espacio.sgteGeneracion();
		repaint();	
	}
	
	public void iniciarHilo(){
		if (t == null){
			t = new Thread(new Runnable() {
				public void run() {
					Thread aux = Thread.currentThread();
					while (t == aux) {
						espacio.sgteGeneracion();
						repaint();
						try { Thread.sleep(150); } catch (InterruptedException e1) {}
					}
				}
			});
			t.start();
		}
		else
			t = null;
	}
	
	
}
