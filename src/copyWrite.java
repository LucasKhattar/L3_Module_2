import java.io.FileWriter;
import java.io.IOException;

public class copyWrite {
	public static void main(String[] args) {}
	public static void CopyW() {
		try {
			FileWriter fw1 = new FileWriter("src/intro_to_file_io/code.txt", true);
			FileWriter fw2 = new FileWriter("src/intro_to_file_io/dcrypyter.java", true);
			FileWriter fw3 = new FileWriter("src/intro_to_file_io/code.txt", true);
			fw1.close();
			fw2.close();
			fw3.close();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
}
