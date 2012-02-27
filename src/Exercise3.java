
public class Exercise3 {

//	private double[][] u;
	private Complex[][] u;
	
//	public Exercise3(double[] input){
//		u = new double[2][2];
//		
//		int a = 0;
//		int b = 0;
//		for (int i=0; i<input.length; i++){
//			if (b>=2){
//				a++;
//				b=0;
//			}
//			u[a][b++] = input[i];
//			if (DEBUG == true){
//				//print out entries of matrix u
//				System.out.println("u_" + a + (b-1) + " = " + u[a][b-1]);
//			}
//		}	
//	}
	
	public Exercise3(Complex[] input){
		u = new Complex[2][2];
		
		int a = 0;
		int b = 0;
		for (int i=0; i<input.length; i++){
			if ( b > (u.length-1) ){
				a++;
				b=0;
			}
			u[a][b++] = input[i];
//			if (Exercise3Tester.debugging() == true){
//				//print out entries of matrix u
//				System.out.println("u_" + a + (b-1) + " = " + u[a][b-1]);
//			}
		}	
		if (Exercise3Tester.debugging() == true){
			//print out entries of matrix u
			System.out.println("u matrix");
			System.out.println("------------");
			for (int i=0; i<u.length; i++){
				for (int j=0; j<u.length; j++){
					System.out.println("u_" + i + j + " = " + u[i][j]);
				}
			}
			System.out.println();
		}
}
	
	public void run(){
		
	}
}
