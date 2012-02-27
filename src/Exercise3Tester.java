
public class Exercise3Tester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		double[] input = new double[4];
		int a = 0;
		for (int i=0; i<input.length; i++){
			input[i] = Double.parseDouble(args[a++]);
		}
		
		Exercise3 myExercise3 = new Exercise3(input);
		myExercise3.run();
	}

}
