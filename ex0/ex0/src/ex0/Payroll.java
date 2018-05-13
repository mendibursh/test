// mendi bursh
// 305496655

package ex0;

public class Payroll {

	public static void main(String[] args) {
		
		HourlyEmployee mendi = new HourlyEmployee("mendi", "bursh", 305496655, 100, 5);
		CommissionEmployee shternie = new CommissionEmployee("shternie", "bursh", 210045944, 140, 5);
		BasePlusCommissionEmployee benny = new BasePlusCommissionEmployee("benny", "bursh", 3439578, 150, 50, 1500);
		
		Employee [] listEmployee = new Employee [3];
		listEmployee[0] = mendi;
		listEmployee[1] = shternie;
		listEmployee[2] = benny;
		
		
		for (Employee employee : listEmployee) {
			try {
				if (employee instanceof BasePlusCommissionEmployee) {
					employee.toString();
					System.out.println( employee.earnings() * 1.1 + "\n");
				}
				else {
					employee.toString();
					System.out.println(employee.earnings() + "\n");
				}
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
		}	
	}

}
