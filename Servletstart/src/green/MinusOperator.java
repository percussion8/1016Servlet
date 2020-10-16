package green;

public class MinusOperator implements Operator {

	public String getName() {
		// TODO Auto-generated method stub
		return "-";
	}

	public double execute(double a, double b) throws Exception {
		System.out.println();// TODO Auto-generated method stub
		return a-b;
	}

}
