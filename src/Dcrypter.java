import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;

public class Dcrypter {
	String encryptedM;
	String message = "";
	public static void main(String[] args) {
		Dcrypter dec = new Dcrypter();
		dec.dcrypt();
	}

	public void dcrypt() {
		try {
			FileReader fr = new FileReader("/Users/league/Desktop/L3_Module_2/bin/intro_to_file_io/code.txt");
			int c = fr.read();
			encryptedM = "";
			while (c != -1) {
				encryptedM += (char)c;
				c = fr.read();
				System.out.println(encryptedM);
			}
			fr.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < encryptedM.length(); i++) {
			message += (char)(encryptedM.charAt(i)+(8));
		}
		System.out.println(message);
	}
}
