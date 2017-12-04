import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Tasks implements ActionListener {
	public static void main(String[] args) {
		Tasks t = new Tasks();
		t.runner();
	}

	JButton add = new JButton();
	JButton remove = new JButton();
	JButton save = new JButton();
	JButton load = new JButton();
	ArrayList<String> tasks = new ArrayList<String>();

	public void runner() {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();

		frame.setVisible(true);
		frame.add(panel);
		panel.add(add);
		add.setText("Add");
		panel.add(remove);
		remove.setText("Remove");
		panel.add(save);
		save.setText("Save");
		panel.add(load);
		load.setText("Load");
		add.addActionListener(this);
		remove.addActionListener(this);
		save.addActionListener(this);
		load.addActionListener(this);
		frame.pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(add)) {
			String task = JOptionPane.showInputDialog(null, "Tell Me A Task To Add On To The List");
			tasks.add(task);
		} else if (e.getSource().equals(remove)) {
			String rem = JOptionPane.showInputDialog(null, "What Task Will You Like To Remove?");
			if (tasks.contains(rem)) {
				JOptionPane.showMessageDialog(null, "Removed " + rem);
				tasks.remove(rem);
			} else {
				JOptionPane.showMessageDialog(null, "Sorry There Was No Task Called " + rem);
			}
		} else if (e.getSource().equals(save)) {
			JOptionPane.showMessageDialog(null, "Saving...");
			try {
				FileWriter fw = new FileWriter("src/intro_to_file_io/tasks.txt");
				for (int i = 0; i < tasks.size(); i++) {
					fw.write(tasks.get(i) + "\n");
				}

				fw.close();
			} catch (IOException i) {
				i.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "Done!");
		} else if (e.getSource().equals(load)) {
			try {
				BufferedReader br = new BufferedReader(new FileReader("src/intro_to_file_io/tasks.txt"));

				String line = br.readLine();
				String loaf = "";
				tasks.clear();
				while (line != null) {
					loaf += "\n" + line;
					tasks.add(line);
					line = br.readLine();
				}
				JOptionPane.showMessageDialog(null, "Your Tasks Are: " + loaf);
				br.close();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException i) {
				// TODO Auto-generated catch block
				i.printStackTrace();
			}
		}

	}
}
