
public class Celula {
	public static final int VIVA = 1;
	public static final int MUERTA = 0;
	public static final int APUNTO_MORIR = 3;
	public static final int APUNTO_VIVIR = 4;
	
	private int estado;
	
	public Celula(){
		estado = VIVA;
	}
	
	public Celula( int estado){
		this.estado = estado;
	}
	
	public void setEstado(int estado){
		this.estado = estado;
	}
	
	public int getEstado(){
		return estado;
	}
}
