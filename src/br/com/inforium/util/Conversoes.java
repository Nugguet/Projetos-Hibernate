package br.com.inforium.util;
import java.util.Date;
import javax.swing.JOptionPane;
public class Conversoes {
	public static void main(String[] args) {
		double num1;
		long num2;
		int num3;
		float num4;
		Date data = new Date();
		num1 = Double.parseDouble(JOptionPane
				.showInputDialog("Digite um numero Double"));
		num2 = Long.parseLong(JOptionPane
				.showInputDialog("Digite um numero Longo"));
		num3 = Integer.parseInt(JOptionPane
				.showInputDialog("Digite um numero Inteiro"));
		num4 = Float.parseFloat(JOptionPane
				.showInputDialog("Digite um numero Flutuante"));
		conversao(num1);
		conversao(num2);
		conversao(num3);
		conversao(num4);
		conversao(data);
	}

	public static void conversao(Date data) {
		JOptionPane.showMessageDialog(null, data);
	}

	public static void conversao(double num) {
		JOptionPane.showMessageDialog(null, "Teste conversao =" + num);
	}

}
