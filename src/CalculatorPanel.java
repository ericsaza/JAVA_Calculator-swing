import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

// Importaremos la clase JPanel y la heredaremos
public class CalculatorPanel extends JPanel implements ActionListener {
	// Propiedades
	JLabel calculatorLabel;
	JButton buttonAC, buttonDEL;
	JButton buttonDivide;
	JButton button7, button8, button9, buttonMultiply;
	JButton button4, button5, button6, buttonMinus;
	JButton button1, button2, button3, buttonSum;
	JButton button0, buttonPoint, buttonEqual;
	JButton historyButton;
	private String labelText = "";
	private Float firstNumber;
	private Float secondNumber;
	private String operator;
	Font calculatorFont;

	// Constructores
	public CalculatorPanel() {
		this.setLocation(0, 0);
		this.setSize(400, 510);
		this.setLayout(null);
		this.setVisible(true);

		// Importamos la fuente
		try {
			calculatorFont = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/Calculator.ttf")).deriveFont(100f);
			GraphicsEnvironment graphicsE = GraphicsEnvironment.getLocalGraphicsEnvironment();
			graphicsE.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("fonts/Calculator.ttf")));
		} catch (IOException | FontFormatException error) {
			System.out.println(error);
		}
		// Añadimos el label donde se verá el calculo
		calculatorLabel = new JLabel(labelText);
		calculatorLabel.setBounds(10, 10, 367, 150);
		calculatorLabel.setBorder(new CompoundBorder(new EmptyBorder(10, 10, 10, 10), getBorder()));
		calculatorLabel.setFont(calculatorFont);
		calculatorLabel.setBackground(Color.lightGray);
		calculatorLabel.setOpaque(true);
		this.add(calculatorLabel);
		
		// Fila 1
		buttonAC = createButton("AC", 10, 167, 130, 50, new Color(232, 174, 174), new Color(0));
		buttonDEL = createButton("DEL", 152, 167, 130, 50, new Color(232, 174, 174), new Color(0));

		// Fila 2
		buttonDivide = createButton("÷", 292, 167, 85, 50, new Color(0), new Color(255, 255, 255));

		// Fila 3
		button7 = createButton("7", 10, 227, 85, 50, new Color(0), new Color(255, 255, 255));
		button8 = createButton("8", 105, 227, 85, 50, new Color(0), new Color(255, 255, 255));
		button9 = createButton("9", 197, 227, 85, 50, new Color(0), new Color(255, 255, 255));
		buttonMultiply = createButton("x", 292, 227, 85, 50, new Color(0), new Color(255, 255, 255));

		// Fila 4
		button4 = createButton("4", 10, 287, 85, 50, new Color(0), new Color(255, 255, 255));
		button5 = createButton("5", 105, 287, 85, 50, new Color(0), new Color(255, 255, 255));
		button6 = createButton("6", 197, 287, 85, 50, new Color(0), new Color(255, 255, 255));
		buttonMinus = createButton("-", 292, 287, 85, 50, new Color(0), new Color(255, 255, 255));

		// Fila 5
		button1 = createButton("1", 10, 347, 85, 50, new Color(0), new Color(255, 255, 255));
		button2 = createButton("2", 105, 347, 85, 50, new Color(0), new Color(255, 255, 255));
		button3 = createButton("3", 197, 347, 85, 50, new Color(0), new Color(255, 255, 255));
		buttonSum = createButton("+", 292, 347, 85, 50, new Color(0), new Color(255, 255, 255));

		// FIla 6
		button0 = createButton("0", 10, 407, 180, 50, new Color(0), new Color(255, 255, 255));
		buttonPoint = createButton(".", 197, 407, 85, 50, new Color(0), new Color(255, 255, 255));
		buttonEqual = createButton("=", 292, 407, 85, 50, new Color(0), new Color(255, 255, 255));

	}

	// Métodos
	@Override
	public void actionPerformed(ActionEvent event) {

		// Botón que borrará todo lo que hayas escrito
		if(event.getSource() == buttonAC) {
			labelText = "";
			calculatorLabel.setText("");
		}

		// Botón que el último caracter que hayas escrito
		if(event.getSource() == buttonDEL) {
			labelText = labelText.substring(0, labelText.length() - 1);
			calculatorLabel.setText(labelText);
		}

		// Botones de calculos
		operatorsAction(event, buttonSum, "+");
		operatorsAction(event, buttonMinus, "-");
		operatorsAction(event, buttonDivide, "÷");
		operatorsAction(event, buttonMultiply, "x");

		// Botones parentesis y punto
		buttonAction(event, buttonPoint);

		// Números
		buttonAction(event, button9);
		buttonAction(event, button8);
		buttonAction(event, button7);
		buttonAction(event, button6);
		buttonAction(event, button5);
		buttonAction(event, button4);
		buttonAction(event, button3);
		buttonAction(event, button2);
		buttonAction(event, button1);
		buttonAction(event, button0);

		// Botón de resultado
		if(event.getSource() == buttonEqual) {
			calculate();
		}
	}

	/**
	 * Método que crea los botonés dependiendo de los parametros
	 * @param value
	 * @param posX
	 * @param posY
	 * @param width
	 * @param height
	 * @param color
	 * @param foregroundColor
	 * @return
	 */
	public JButton createButton(String value, int posX, int posY, int width, int height, Color color, Color foregroundColor) {
		JButton button = new JButton(value);
		button.setBounds(posX, posY, width, height);
		button.setFont(new Font("Arial", Font.BOLD, 20));
		button.setBackground(color);
		button.setFocusable(false);
		button.addActionListener(this);
		button.setForeground(foregroundColor);
		this.add(button);
		return button;
	}

	/**
	 * Método que al recibir un botón, escribira su valor
	 * @param event
	 * @param button
	 */
	public void buttonAction(ActionEvent event, JButton button) {
		if(event.getSource() == button) {
			labelText += button.getText();
			calculatorLabel.setText(labelText);
		}
	}

	/**
	 * Método para poder hacer el calculo
	 */
	public void calculate() {
		labelText = calculatorLabel.getText();
		secondNumber = Float.parseFloat(labelText);
//		System.out.println(operator);
		if (operator == "+") {
			calculatorLabel.setText(Float.toString(firstNumber + secondNumber));
		}	else if (operator == "-") {
			calculatorLabel.setText(Float.toString(firstNumber - secondNumber));
		}	else if (operator == "÷") {
			calculatorLabel.setText(Float.toString(firstNumber / secondNumber));
		}	else if (operator == "x") {
			calculatorLabel.setText(Float.toString(firstNumber * secondNumber));
		}
	}

	/**
	 * Método que al recibir los valores, guarda el primer valor y vacia el JLabel
	 * @param event
	 * @param button
	 * @param operator: operador que tendrá el calculo
	 */
	public void operatorsAction(ActionEvent event, JButton button, String operator) {
		if(event.getSource() == button) {
			labelText = calculatorLabel.getText();
			firstNumber = Float.parseFloat(labelText);
			this.operator = operator;
			calculatorLabel.setText(labelText);
			calculatorLabel.setText("");
			labelText = "";
		}
	}
}
