package dayoon_lee_exercise2;

public class Employee {

	int empId;
	String empName;
	String empDate;
	double salary;

	public Employee(int empId, String empName, String empDate, double salary)
	{
		this.empId = empId;
		this.empName = empName;
		this.empDate = empDate;
		setSalary(salary);
	}
	
	public int getEmpId() {return empId;}
	
	public String getEmpName() {return empName;}
	
	public String getDate() {return empDate;}
	
	public double getSalary() {return salary;}
	
	public void setSalary(double salary) {
		if (salary < 0)
		{
			throw new IllegalArgumentException("Salary must be grater than 0");
	    }
		
		this.salary = salary;
	}
	
	@Override
	public String toString()
	{
		return String.format("%d\t\t\t%s\t\t%s\t\t$%.2f%n", empId, empName, empDate, salary);
	}
}
