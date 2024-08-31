package MiniProject3;

public class EmployeeDetails {

	private int eId;
	private String eName;
	private int eAge;
	private double eSal;
	
	

	public int geteId() {
		return eId;
	}

	public void seteId(int eId) {
		this.eId = eId;
	}

	public String geteName() {
		return eName;
	}

	public void seteName(String eName) {
		this.eName = eName;
	}

	public int geteAge() {
		return eAge;
	}

	public void seteAge(int eAge) {
		this.eAge = eAge;
	}

	public double geteSal() {
		return eSal;
	}

	public void seteSal(double eSal) {
		this.eSal = eSal;
	}

	@Override
	public String toString() {
		return "" + eId + "\t" + eName + "\t" + eAge + "\t" + eSal + "";
	}
	
	
	
}
