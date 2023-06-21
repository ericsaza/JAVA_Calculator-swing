import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Window {

	// Propiedades
	JFrame window;
//	ImageIcon iconImage = new ImageIcon(getClass().getClassLoader().getResource("img/icon.png"));

	// Constructores
	public Window() {
		window = new JFrame();

		window.setLocation(0, 0);
		window.setSize(400, 510);
		window.setResizable(false);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLayout(null);
		window.setTitle("Calculator");
//		window.setIconImage(iconImage.getImage());
		window.setVisible(true);
		
		// la función repaint() se utiliza para solicitar una actualización de la representación visual de un componente en la interfaz gráfica. 
		window.repaint();
	}

	// Métodos
	
	
}
