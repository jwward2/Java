//Stuart Reges
//1/26/00
//
//CritterMain provides method main for a simple simulation program.
//
//CS335 students: you are welcome to alter the number of each critter
//added to the simulation if you want to experiment with different
//scenarios.  You will have to add two lines of code that add your
//own critters to the simulation.

public class CritterMain
{
	public static void main(String[] args)
	{
		CritterModel model = new CritterModel(100, 50);

		/** Add critters here **/

		model.add(50, Food.class);
		model.add(50, LandMine.class);
		model.add(50, FlyTrap.class);
		model.add(50, Rover.class);
		model.add(50, Wanderer.class);
		model.add(50, Porcupine.class);

		// Un-comment each line for each new Critter
		// model.add(50, Wanderer.class);

		// Place you new Critter with your own AI into a separate file for
		// submission
		// model.add(50, <your critter classname here>.class);


		/** ******************** */
		/** Don't make any changes below here */
		/** ******************** */

		CritterFrame f = new CritterFrame(model);
		f.setVisible(true);
	}
}