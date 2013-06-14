import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JPanel;

public class EspacioCelular {
	
	private Celula [][] celulas;
	private int filas;
	private int columnas;
	
	
	public EspacioCelular(){
		
	}
	
	public EspacioCelular(int filas, int columnas){
		celulas = new Celula [this.filas = filas][this.columnas = columnas];
		for (int i=0; i<filas; i++)
			for (int j=0; j<columnas; j++)
				celulas[i][j] = new Celula(Celula.MUERTA);
	}
	
	public void espacioCelularAleatorio(int aleatorio) {
		Random r = new Random();
		int aux;
		for (int i = 0; i<celulas.length; i++){
			for (int j = 0; j<celulas[i].length; j++){
				aux = r.nextInt(aleatorio);
				if (aux == 0)
					celulas[i][j].setEstado(Celula.VIVA);
				else
					celulas[i][j].setEstado(Celula.MUERTA);
			}
		}
	}
	
	
	private int getVecinas(int fil, int col){
		int vecinas = 0;
		for (int i=fil-1; i<=fil+1; i++)
			for (int j=col-1; j<=col+1; j++) {
				try {
				if ((i != fil || j != col) && 
					(celulas[i][j].getEstado() == Celula.VIVA || celulas[i][j].getEstado() == Celula.APUNTO_MORIR))
					vecinas++;
				} catch (IndexOutOfBoundsException e){}
			}
		return vecinas;
	}
	
	public void sgteGeneracion(){
		int vecinas;
		for (int i = 0; i<celulas.length; i++)
			for (int j = 0; j<celulas[0].length; j++){
				vecinas = getVecinas(i, j);
				if (celulas[i][j].getEstado() == Celula.VIVA && (vecinas < 2 || vecinas > 3))
					celulas[i][j].setEstado(Celula.APUNTO_MORIR);
				if (celulas[i][j].getEstado() == Celula.MUERTA && vecinas == 3)
					celulas[i][j].setEstado(Celula.APUNTO_VIVIR);

			}
		
		for (int i = 0; i<celulas.length; i++)
			for (int j = 0; j<celulas[0].length; j++){
				if (celulas[i][j].getEstado() == Celula.APUNTO_MORIR)
					celulas[i][j].setEstado(Celula.MUERTA);
				if (celulas[i][j].getEstado() == Celula.APUNTO_VIVIR)
					celulas[i][j].setEstado(Celula.VIVA);
			}
		}
	
	public Celula [][] getArray(){
		return celulas;
	}
	
	
	
}
