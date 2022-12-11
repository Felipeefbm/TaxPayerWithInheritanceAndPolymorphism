package entities;

public class Individual extends TaxPayer{
	
	private Double healthExpenditures;

	
	public Individual (String name, Double anualIncome, Double healthExpenditures) {
		super(name, anualIncome);
		this.healthExpenditures = healthExpenditures;
	}
	
	public double getHealthExpenditures() {
		return healthExpenditures;
	}

	public void setHealthExpenditures(double healthExpenditures) {
		this.healthExpenditures = healthExpenditures;
	}
		
	
	@Override
	public Double tax() {
		double tax =00;
		double sum = 0;
		
		if(getAnualIncome() < 20000.00) {
			tax = 0.15;
		}
		else if(super.getAnualIncome() >= 20000.00) {
			tax = 0.25;
		}
		
		sum = (getAnualIncome() * tax) - (healthExpenditures * 0.50);
		
		return sum;
	}

}
