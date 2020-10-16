package green;

public class DivideOperator implements Operator {

	public String getName() {
		// TODO Auto-generated method stub
		return "/";
	}

	public double execute(double a, double b) throws Exception {
		// TODO Auto-generated method stub
		return a/b;
	}

}
