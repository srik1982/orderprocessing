package srikarao.mockito.tests.orderprocessing.dto;

public class Order {
	int id;
	String status;
	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Order(int id, String status) {
		super();
		this.id = id;
		this.status = status;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
