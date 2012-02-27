
public class Exercise3Tester {

	private static boolean debug = true;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		double[] input = new double[4];
//		int a = 0;
//		for (int i=0; i<input.length; i++){
//			input[i] = Double.parseDouble(args[a++]);
//		}
		
//		Exercise3 myExercise3 = new Exercise3(input);
		
		
		String[] inputStrings = new String[4];
		Complex[] input = new Complex[4];
		int a = 0;
		for (int i=0; i<input.length; i++){
			inputStrings[i] = args[a++];
			input[i] = getComplex(inputStrings[i]);
		}
		
//		Exercise3 myExercise3 = new Exercise3(input);
//		myExercise3.run();
	}

	private static Complex getComplex(String s) {
		// TODO Auto-generated method stub
		Complex ret = new Complex();
		
		//let's say I want to parse the second way in the hw
		//with parens
		String[] realAndImagTemp = s.split("[(,)]");
		String[] realAndImag = new String[realAndImagTemp.length - 1];
		for (int i=0; i<realAndImag.length; i++){
			realAndImag[i] = realAndImagTemp[i+1];
		}
//		for (int i=0; i<realAndImag.length; i++){
//			realAndImag[i] = removeParens(realAndImag[i]);
//		}
		
		ret.setRe(Double.parseDouble(realAndImag[0]));
		ret.setIm(Double.parseDouble(realAndImag[1]));
		
		if (debugging())
			System.out.println(ret);
		
		return ret;
	}
	
	public static boolean debugging(){
		return debug;
	}

//	private static String removeParens(String string) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
