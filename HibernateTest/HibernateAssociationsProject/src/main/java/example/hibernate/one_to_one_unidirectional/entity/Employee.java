package example.hibernate.one_to_one_unidirectional.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Employee_Master")
public class Employee {
	@Id
	@Column(name = "emp_no")
	private int empNo;
	@Column(name = "emp_name")
	private String name;
	@Column(name = "emp_sal")
	private float sal;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "passport_id")//Refers to Foreign Key column of Employee_Master table which refers to PRIMARY KEY of Passport_Master table 

	private Passport passportRef;
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	public Employee(int empNo, String name, float sal, Passport passportRef) {
		super();
		this.empNo = empNo;
		this.name = name;
		this.sal = sal;
		this.passportRef = passportRef;
	}
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getSal() {
		return sal;
	}
	public void setSal(float sal) {
		this.sal = sal;
	}
	public Passport getPassportRef() {
		return passportRef;
	}
	public void setPassportRef(Passport passportRef) {
		this.passportRef = passportRef;
	}
	@Override
	public String toString() {
		return "Employee [empNo=" + empNo + ", name=" + name + ", sal=" + sal + ", passportRef=" + passportRef + "]";
	}

}
