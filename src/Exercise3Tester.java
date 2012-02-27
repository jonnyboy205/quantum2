
public class Exercise3Tester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		double[][] u = new double[2][2];
//		
//		//take U as input
//		int a = 0;
//		for (int i=0; i<u.length; i++){ //loop rows
//			for (int j=0; j<u.length; j++){ //loop columns
//				u[i][j] = Double.parseDouble(args[a++]);
//			}
//		}
		
		double[] input = new double[4];
		int a = 0;
		for (int i=0; i<input.length; i++){
			input[i] = Double.parseDouble(args[a++]);
		}
		
//		Exercise3 myExercise3 = new Exercise3(u);
		Exercise3 myExercise3 = new Exercise3(input);
		myExercise3.run();
	}

}
