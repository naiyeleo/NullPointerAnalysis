package example;


public class ExampleWithException {
	String string1, string2;
	int val;

	public static void main(String[] args) {
		try {
			ExampleWithException rTEExampleException = new ExampleWithException(args[0].length());
			if (args.length == 1) {
				rTEExampleException.method2();
				rTEExampleException.method4();
			} else {
				int num = Integer.parseInt(args[1]);
				rTEExampleException.method1(num);
			}
			rTEExampleException.method4(1);
		} catch (NullPointerException e) {
//			 Analysis analysis = new Analysis(e.getStackTrace());
//			 analysis.createDispatcher();
			 for(StackTraceElement ste:e.getStackTrace()){
				 System.out.println("Error:" + ste.toString());
			 }
		}
	}

	public ExampleWithException(int i) {
		val = i;
		string1 = null;
		string2 = null;
		if (val > 1) {
			string2 = new String("abc");
		}
	}

	public void method1(int j) {
		if (j == 0) {
			String tempStr = null;
			string1 = tempStr;
		} else {
			string1 = null;
		}
	}

	public void method2() {
		
		string1 = string2;
	}

	public void method4(int i) {
		if (val > 1) {
			string2.charAt(0);
		}
		string1.charAt(0);
	}

	public void method4() {

		method4(1);
	}
}
