package ex0;

public class CommissionEmployee extends Employee  {

	double grossSales ;
	double commision;
	
	public double getGrossSales() {
		return grossSales;
	}

	public void setGrossSales(double grossSales) {
		if(grossSales < 0) {
			throw new IllegalArgumentException("grossSales should be greater then 0");
		}
		else {
			this.grossSales = grossSales;
		}
		
	}

	public double getCommision() {
		return commision;
	}

	public void setCommision(double commision) {
		if(commision < 0) {
			throw new IllegalArgumentException("commision should be greater then 0");
		}
		else {
			this.commision = commision;
		}
	}

	public CommissionEmployee(String fn, String ln , int _id , double grossSalesUser , double commisionUser ) {
		super(fn , ln ,_id);
		grossSales = grossSalesUser;
		commision = commisionUser ;
	}
	
	public CommissionEmployee() {
		super();
		grossSales = 0;
		commision = 0;
	}
	
	@Override
	public String toString() {	
		System.out.println(super.toString() + "\n" + this.grossSales + "\n" + this.commision);
		return ("\n" + this.grossSales + "\n" + this.commision);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(commision);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(grossSales);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		CommissionEmployee other = (CommissionEmployee) obj;
		if (Double.doubleToLongBits(commision) != Double.doubleToLongBits(other.commision))
			return false;
		if (Double.doubleToLongBits(grossSales) != Double.doubleToLongBits(other.grossSales))
			return false;
		return true;
	}
	
	@Override
	double earnings() {
		return ((commision / 100) * grossSales);
	}
	
	
}
