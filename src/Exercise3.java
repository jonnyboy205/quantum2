
public class Exercise3 {

	private Complex[][] u;
	
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
		}	
		
		if (Exercise3Tester.debugging() == true){
			printU();
		}
}

	private void printU() {
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
	
	/**
	 * Calculate equivalence of C1(U) and C2(U^3)
	 */
	public boolean run(){
		boolean equivalent = false;
		
		//TODO actual calculation
//		Complex[] e = new Complex();
//		
//		double norm = norm(e);
		
		return equivalent;
	}
	
	private Complex[][] calculateU3(){
		Complex[][] u3 = new Complex[2][2];
		
		Complex[][] u2 = matrixProduct2by2(u, u);
		u3 = matrixProduct2by2(u2, u);
		
		return u3;
	}
	
	private Complex[][] matrixProduct2by2(Complex[][] m1, Complex[][] m2){
		if (m1.length!=2 && m2.length!=2)
			return null;
		
		Complex[][] product = new Complex[2][2];
		for (int rowIndex=0; rowIndex<2; rowIndex++){
			for (int columnIndex=0; columnIndex<2; columnIndex++){
				for (int a=0; a<2; a++){
					product[rowIndex][columnIndex] = m1[rowIndex][a].mul(m2[a][columnIndex]);
				}
			}
		}
		return product;
	}
	
	private Complex[] matrixProduct2by1(Complex[][] m1, Complex[] m2){
		if (m1.length!=2 && m2.length!=1)
			return null;
		
		Complex[] product = new Complex[2];
		for (int rowIndex=0; rowIndex<2; rowIndex++){
			for (int a=0; a<2; a++){
				product[rowIndex] = m1[rowIndex][a].mul(m2[a]);
			}
		}
		
		return product;
	}
	
	private double norm(Complex[] vector){
		double ret = 0;
//		Complex complexRet = new Complex();
		
		for (int i=0; i<vector.length; i++){
//			complexRet = complexRet.add((vector[i].getConjugate()).mul(vector[i]));
			ret += (vector[i].getConjugate()).mul(vector[i]).getRe();
		}
		
		ret = Math.sqrt(ret);
		
		return ret;
	}
}
