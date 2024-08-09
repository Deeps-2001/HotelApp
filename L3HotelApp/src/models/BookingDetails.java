package models;

public class BookingDetails {

	private String userName;
	private String bookedHotel;
	private double bookingCost;
	private int personCount;
	private String location;
	

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getBookedHotel() {
		return bookedHotel;
	}
	public void setBookedHotel(String selectedHotel) {
		this.bookedHotel = selectedHotel;
	}
	public double getBookingCost() {
		return bookingCost;
	}
	public void setBookingCost(double totalAmount) {
		this.bookingCost = totalAmount;
	}
	public int getPersonCount() {
		return personCount;
	}
	public void setPersonCount(int personCount) {
		this.personCount = personCount;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	
	
}
