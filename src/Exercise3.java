
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
		Complex[] eU0 = new Complex[2];
		Complex[] eU1 = new Complex[2];
		Complex[] eU30 = new Complex[2];
		Complex[] eU31 = new Complex[2];
		
		Complex qubit00 = new Complex(1, 0);
		Complex qubit01 = new Complex(0, 0);
		Complex[] qubit0 = {qubit00, qubit01};
		
		Complex qubit10 = new Complex(0, 0);
		Complex qubit11 = new Complex(1, 0);
		Complex[] qubit1 = {qubit10, qubit11};
		
		eU0 = matrixProduct2by1(u, qubit0);
		eU1 = matrixProduct2by1(u, qubit1);
		
		Complex[][] u3 = calculateU3();
		eU30 = matrixProduct2by1(u3, qubit0);
		eU31 = matrixProduct2by1(u3, qubit1);
		
		double norm0 = norm(vectorSubtraction(eU0, eU30));
		double norm1 = norm(vectorSubtraction(eU1, eU31));
		
		if (norm0 < 0.0001 && norm1 < 0.0001){
			equivalent = true;
		}
		
		if (Exercise3Tester.debugging()){
			System.out.println("norm0 = " + norm0);
			System.out.println("norm1 = " + norm1);
			System.out.println();
		}
		
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
		for (int i=0; i<2; i++){
			for (int j=0; j<2; j++){
				product[i][j] = new Complex(0, 0);
			}
		}
		
		for (int rowIndex=0; rowIndex<2; rowIndex++){
			for (int columnIndex=0; columnIndex<2; columnIndex++){
				for (int a=0; a<2; a++){
					product[rowIndex][columnIndex] = product[rowIndex][columnIndex].add(m1[rowIndex][a].mul(m2[a][columnIndex]));
				}
			}
		}
		return product;
	}
	
	private Complex[] matrixProduct2by1(Complex[][] m1, Complex[] m2){
		if (m1.length!=2 && m2.length!=1)
			return null;
		
		Complex[] product = new Complex[2];
		product[0] = new Complex(0, 0);
		product[1] = new Complex(0, 0);
		
		for (int rowIndex=0; rowIndex<2; rowIndex++){
			for (int a=0; a<2; a++){
				product[rowIndex] = product[rowIndex].add(m1[rowIndex][a].mul(m2[a]));
			}
		}
		
		return product;
	}
	
	/**
	 * returns subtraction of two vectors of equal dimension.
	 * @param v1
	 * @param v2
	 * @return
	 */
	private Complex[] vectorSubtraction(Complex[] v1, Complex[] v2){
		if (v1.length!=v2.length)
			return null;
		
		Complex[] ret = new Complex[v1.length];
		
		for (int i=0; i<v1.length; i++){
			ret[i] = v1[i].sub(v2[i]);
		}
		
		return ret;
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
