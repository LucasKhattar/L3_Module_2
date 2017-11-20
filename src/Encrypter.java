import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class Encrypter {
	public static void main(String[] args) {
		Encrypter enc = new Encrypter();
		enc.encrypt();
	}

	public void encrypt() {
		String message = JOptionPane.showInputDialog(null,"Tell Me Something");
		String encrypted = "";
		for (int i = 0; i < message.length(); i++) {
			encrypted += (char)(message.charAt(i)-(8));
		}
		try {
			FileWriter fw = new FileWriter("src/intro_to_file_io/code.txt");
			fw.write(encrypted);	
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}