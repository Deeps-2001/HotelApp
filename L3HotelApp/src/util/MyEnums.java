package util;

public class MyEnums {

		public static enum  hotelNames{
		  
			SKYWALL_RESORT(1,"Skywall Resort"),
			MOONLIGHT_MANOR(2,"Moonlight Manor"),
			RADIANT_RESIDENCES(3,"Radiant Residences"),
			ENIGMA_INN(4,"Enigma Inn"),
			TWILIGHT_TERRACE(5,"Twilight Terrace"),
			AURORA_DREAM_HOTEL(6,"Aurora Dream Hotel");
			
			private int hotelId;
			private String hotelName;
			
			hotelNames(int hotelId,String hotelName) {
				this.hotelId = hotelId;
				this.hotelName = hotelName;
			}
			public int getHotelId() {
				return hotelId;
			}
			public String getHotelName() {
				return hotelName;
			}
		}
		
		public static enum locations{
			CHENNAI(1,"Chennai"),
			MADURAI(2,"Madurai"),
			SALEM(3,"Salem");
		
			private int locationId;
			private String locationName;
			
			locations(int locationId,String locationName){
				this.locationId = locationId;
				this.locationName = locationName;
			}
			public int getLocationId() {
				return locationId;
			}
			public String getLocationName() {
				return locationName;
			}
		 	
		}
}
