package entities;

public class Company extends  TaxPayer{
	
	private int numberOfEmployees;

	public Company() {
		super();
	}
	
	public Company(String name, Double anualIncome, int numberOfEmployees) {
		super(name, anualIncome);
		this.numberOfEmployees = numberOfEmployees;
	}
	
	public double getNumberOfEmployees() {
		return numberOfEmployees;
	}

	public void setNumberOfEmployees(int numberOfEmployees) {
		this.numberOfEmployees = numberOfEmployees;
	}

	
	@Override
	public Double tax() {
		double tax = 0.16;
		double sum = 0;
		
		if (numberOfEmployees > 10) {
			tax = 0.14;
		}
		
		sum = (getAnualIncome() * tax);
		
		return sum;
	}

}
