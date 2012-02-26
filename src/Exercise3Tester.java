
public class Exercise3Tester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] u = new int[2][2]; 
		
		//take U as input
		int a = 0;
		for (int i=0; i<u.length; i++){ //loop rows
			for (int j=0; j<u.length; j++){ //loop columns
				u[i][j] = Integer.parseInt(args[a++]);
			}
		}
		
		Exercise3 myExercise3 = new Exercise3(u);
		myExercise3.run();
	}

}
