package ex0;

public class HourlyEmployee extends Employee {
	
	double houre;
	double paymentPerhoure;
	
	public HourlyEmployee(String fn, String ln , int _id , double userHoure , double userPayment ) {
		super(fn , ln ,_id);
		houre = userHoure;
		paymentPerhoure = userPayment ;
	}
	
	public HourlyEmployee() {
		super();
		houre = 0;
		paymentPerhoure = 0;
		
	}
	
	public double getHoure() {
		return houre;
	}

	public void setHoure(double houre) {
		if (houre < 0) {
			throw new IllegalArgumentException("houre can't be less than 0");
		}
		else {
			this.houre = houre;
		}
		
	}

	public double getPaymentPerhoure() {
		
		return paymentPerhoure;
	}

	public void setPaymentPerhoure(double paymentPerhoure) {
		if(paymentPerhoure < 0) {
			throw new IllegalArgumentException("paymentPerhoure should be greater then 0");
		}
		else {
			this.paymentPerhoure = paymentPerhoure;
		}
		
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(houre);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(paymentPerhoure);
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
		HourlyEmployee other = (HourlyEmployee) obj;
		if (Double.doubleToLongBits(houre) != Double.doubleToLongBits(other.houre))
			return false;
		if (Double.doubleToLongBits(paymentPerhoure) != Double.doubleToLongBits(other.paymentPerhoure))
			return false;
		return true;
	}

	@Override
	public String toString() {
		System.out.println(super.toString() + "\n" + this.houre + "\n" + this.paymentPerhoure);
		return ("\n" + this.houre + "\n" + this.paymentPerhoure);
	}
	@Override
	double earnings() {
		return  houre * paymentPerhoure;
	}

	

}
