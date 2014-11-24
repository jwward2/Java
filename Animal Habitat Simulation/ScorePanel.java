import java.awt.BorderLayout;
import java.awt.Font;
import java.util.HashMap;
import java.util.Set;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

// Seungwoo Sun
class ScorePanel extends JPanel {

	private static final long serialVersionUID = 2435464017111895431L;

	private CritterModel myModel;
	private JTextArea names, scores;
	private HashMap<String, Integer> critters;

	public ScorePanel(CritterModel model) {
		super();
		myModel = model;
		this.setLayout(new BorderLayout());
		initTextAreas();
		initNameLists();
		this.setVisible(true);
	}

	private void initNameLists() {
		// creates the original map, then updates the map
		// so that it includes the count of each critter.
		critters = new HashMap<String, Integer>();
		Set<Critter> critterSet = myModel.myList.keySet();
		for (Critter critter : critterSet) {
			String name = critter.getClass().toString().substring(6);
			critters.put(name, 0);
		}
		update();
	}

	private void initTextAreas() {
		names = new JTextArea();
		names.setEditable(false);
		names.setFont(new Font("Monospaced", Font.BOLD, 14));

		scores = new JTextArea();
		scores.setFont(new Font("Monospaced", Font.BOLD, 14));
		scores.setEditable(false);

		JScrollPane namePane = new JScrollPane(names);
		JScrollPane scorePane = new JScrollPane(scores);

		this.add(namePane, BorderLayout.WEST);
		this.add(scorePane, BorderLayout.CENTER);
	}

	void update() {
		names.setText(" Names:           \n");
		scores.setText(" Alive:           \n");
		// zeroes out each critter count
		Set<String> nameSet = critters.keySet();
		for (String name : nameSet) {
			critters.put(name, 0);
		}
		// counts each critter
		Set<Critter> critterSet = myModel.myList.keySet();
		for (Critter critter : critterSet) {
			String name = critter.getClass().toString().substring(6);
			critters.put(name, critters.get(name) + 1);
		}
		// Finds the current winner
		String nameOfWinner = "";
		int maxCount = 0;
		for (String name : nameSet) {
			if (critters.get(name) > maxCount) {
				nameOfWinner = name;
				maxCount = critters.get(name);
			}
		}
		// updates the lists
		for (String name : nameSet) {
			String nameToPrint = name;
			int score = critters.get(name);
			scores.setText(scores.getText() + " " + score + '\n');
			// long names are truncated
			if (name.length() > 15)
				nameToPrint = name.substring(0, 12) + "...";
			nameToPrint = "  " + nameToPrint;
			// the current winner is distinguished with an arrow
			if (name.equals(nameOfWinner)) {
				nameToPrint = "->" + nameToPrint.substring(2);
			}
			names.setText(names.getText() + nameToPrint + '\n');
		}
	}

}
