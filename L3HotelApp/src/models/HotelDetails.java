package models;

public class HotelDetails {
	private String hotelName;
	private String locationName;
	private double pricePerPerson;
	private int roomAvailable;
	private double ratings;
	
	
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public String getLocationName() {
		return locationName;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
 
	public void setPrice(double price) {
		this.pricePerPerson = price;
	}
	public double getPrice() {
		return pricePerPerson;
	}
	public int getRoomAvailable() {
		return roomAvailable;
	}
	public void setRoomAvailable(int roomAvailable) {
		this.roomAvailable = roomAvailable;
	}
	public double getRatings() {
		return ratings;
	}
	public void setRatings(double ratings) {
		this.ratings = ratings;
	}

}
