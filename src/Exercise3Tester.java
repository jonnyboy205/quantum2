
public class Exercise3Tester {

	private static boolean debug = true;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] inputStrings = new String[4];
		Complex[] input = new Complex[4];
		int a = 0;
		for (int i=0; i<input.length; i++){
			inputStrings[i] = args[a++];
			input[i] = getComplex(inputStrings[i]);
		}
		if (debugging()){
			System.out.println("input");
			System.out.println("--------");
			for (int i=0; i<input.length; i++){
				System.out.println(input[i]);
			}
			System.out.println();
		}
		
		Exercise3 myExercise3 = new Exercise3(input);
		myExercise3.run();
	}

	private static Complex getComplex(String s) {
		Complex ret = new Complex();
		
		//let's say I want to parse the second way in the hw
		//with parens
		String[] realAndImagTemp = s.split("[(,)]");
		String[] realAndImag = new String[realAndImagTemp.length - 1];
		for (int i=0; i<realAndImag.length; i++){
			realAndImag[i] = realAndImagTemp[i+1];
		}
		
		ret.setRe(Double.parseDouble(realAndImag[0]));
		ret.setIm(Double.parseDouble(realAndImag[1]));
		
		return ret;
	}
	
	public static boolean debugging(){
		return debug;
	}

}
