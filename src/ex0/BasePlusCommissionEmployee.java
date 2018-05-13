package ex0;

public class BasePlusCommissionEmployee extends CommissionEmployee {
	
	double baseSalary;
	
	public BasePlusCommissionEmployee(String fn, String ln , int _id , double grossSalesUser , double commisionUser , double baseSalaryUser ) {
		super(fn , ln ,_id , grossSalesUser ,commisionUser);
		baseSalary =baseSalaryUser;
	}
	
	public BasePlusCommissionEmployee() {
		super();
		baseSalary = 0;
	}

	public double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(double baseSalary) {
		if(baseSalary < 0) {
			throw new IllegalArgumentException("baseSalary should be greater then 0");
		}
		else {
			this.baseSalary = baseSalary;
		}
		
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		super.toString();
		System.out.println(this.baseSalary);
		return ("\n" + this.baseSalary);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(baseSalary);
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
		BasePlusCommissionEmployee other = (BasePlusCommissionEmployee) obj;
		if (Double.doubleToLongBits(baseSalary) != Double.doubleToLongBits(other.baseSalary))
			return false;
		return true;
	}
	@Override
	double earnings() {
		// TODO Auto-generated method stub
		return super.earnings() + this.baseSalary;
	}
	

}
