package example.spring.core;

public class Customer {
	private String id;
	private String name;
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
