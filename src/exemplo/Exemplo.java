package exemplo;

import static javax.swing.JOptionPane.*;
import static java.lang.Integer.parseInt;

public class Exemplo {
    public static void main(String[] args) {
        int valor1, valor2, resultado;
        valor1 = parseInt(showInputDialog("Informe o primeiro valor"));
        valor2 = parseInt(showInputDialog("Informe o segundo valor"));
        resultado = valor1 + valor2;
        showMessageDialog(null, "resultado = " + resultado);
    }
}
