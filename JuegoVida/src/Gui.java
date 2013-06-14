import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JToolBar;


public class Gui extends JFrame implements ActionListener{
	JToolBar barra;
	JButton siguiente;
	JButton comenzar;
	JButton pausar;
	Escenario escenario = new Escenario();
	
	public Gui(){
		siguiente = new JButton("Siguiente");
		comenzar = new JButton("Comenzar");
		barra = new JToolBar();
		
		barra.add(siguiente);
		barra.add(comenzar);
		add(barra, BorderLayout.NORTH);
		barra.setFloatable(false);
		
		siguiente.addActionListener(this);
		comenzar.addActionListener(this);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// parrilla = new int [250][250];
		add(escenario, BorderLayout.CENTER);
		pack();
		
	}
	
	
	public static void main(String[] args) {
		Gui gui = new Gui();	
		gui.setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==siguiente){
			escenario.generar();
		}
		if(e.getSource()==comenzar){
			escenario.iniciarHilo();
		}
		
	}
}

	
