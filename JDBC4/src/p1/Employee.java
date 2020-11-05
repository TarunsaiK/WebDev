package p1;

import java.util.List;
import java.util.ArrayList;
import p2.EmployeeJDBCDemo;
public class Employee {
private int Empno;
private String Ename;
private String Job;
private double Salary;
public int getEmpno() {
	return Empno;
}
public void setEmpno(int empno) {
	Empno = empno;
}
public String getEname() {
	return Ename;
}
public void setEname(String ename) {
	Ename = ename;
}
public String getJob() {
	return Job;
}
public void setJob(String job) {
	Job = job;
}
public double getSalary() {
	return Salary;
}
public void setSalary(double salary) {
	Salary = salary;
}

public static void main(String[] ar)
{
	List<Employee> li=new ArrayList<Employee>();
	li=EmployeeJDBCDemo.getEmployeeList();
	for(Employee i:li)
	{
		System.out.println(i.getEmpno()+" "+i.getEname()+" "+i.getJob()+" "+i.getSalary());
	}
}
}
