import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

//Stuart Reges
//1/26/00
//
//Class CritterFrame provides the user interface for a simple simulation
//program.

class CritterFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	private CritterModel myModel;
	private CritterPanel myPicture;
	private ScorePanel myScores;
	private javax.swing.Timer myTimer;
	private static final int MAX_DELAY = 140;

	public CritterFrame(CritterModel model) {
		// create frame and order list
		setTitle("CS227 critter simulation");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container contentPane = getContentPane();
		myModel = model;

		// set up critter picture panel and set size
		int cpWidth = CritterPanel.FONT_SIZE * model.getWidth() / 2 + 270;
		int cpHeight = CritterPanel.FONT_SIZE * model.getHeight();
		myPicture = new CritterPanel(myModel);
		myScores = new ScorePanel(myModel);
		setSize(cpWidth + 160,
				cpHeight + 100);
		contentPane.add(myPicture, "Center");
		contentPane.add(myScores, "East");
		addTimer();

		// add timer controls to the south
		JPanel p = new JPanel();
		JButton b1 = new JButton("start");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myTimer.start();
			}
		});
		p.add(b1);
		JButton b2 = new JButton("stop");
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myTimer.stop();
			}
		});
		p.add(b2);
		JButton b3 = new JButton("step");
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myModel.update();
				myScores.update();
				myPicture.repaint();
			}
		});
		p.add(b3);

		final JSlider speedBar = new JSlider(1, MAX_DELAY);
		speedBar.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent ce) {
				myTimer.setDelay(1000 / (speedBar.getValue()));
			}
		});

		p.add(new JLabel(" Slow"));
		p.add(speedBar);
		p.add(new JLabel("Fast "));

		contentPane.add(p, "South");

	}

	private void addTimer()
	// post: creates a timer that calls the model's update
	// method and repaints the display
	{
		ActionListener updater = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myModel.update();
				myScores.update();
				myPicture.repaint();
			}
		};
		myTimer = new javax.swing.Timer(MAX_DELAY / 2, updater);
	}
}