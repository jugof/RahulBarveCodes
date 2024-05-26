package example.spring.annotations.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Customer {
	private String id;
	private String name;
	//@Autowired
	@Autowired(required = false)//Making it optional
	@Qualifier("myAddress2")//Qualifies the bean with its ID
	private Address permanentAddress;
	public Customer() {
		// TODO Auto-generated constructor stub
	}
	public Customer(String id, String name, Address permanentAddress) {
		this.id = id;
		this.name = name;
		this.permanentAddress = permanentAddress;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getPermanentAddress() {
		return permanentAddress;
	}
	public void setPermanentAddress(Address permanentAddress) {
		this.permanentAddress = permanentAddress;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", permanentAddress=" + permanentAddress + "]";
	}

}
