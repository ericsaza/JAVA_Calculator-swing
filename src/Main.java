
public class Main {

	public static void main(String[] args) {
		CalculatorPanel design = new CalculatorPanel();
		Window calculator = new Window();

		// Añadiremos el diseño hecho con JPanel dentro de la calculadora
		calculator.window.add(design);
		
	}

}
