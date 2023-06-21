import java.awt.Image;
import java.io.File;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Window {

	// Propiedades
	JFrame window;
	

	// Constructores
	public Window() {
		window = new JFrame();

		try {
			Image icon = ImageIO.read(getClass().getResource("icon.png"));
			window.setIconImage(icon);
		} catch (Exception error) {
			System.out.println(error);
		}
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
