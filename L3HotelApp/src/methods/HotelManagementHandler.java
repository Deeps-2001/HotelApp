package methods;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import models.BookingDetails;
import models.HotelDetails;
import util.MyEnums.hotelNames;
import util.MyEnums.locations;

public class HotelManagementHandler {
	private static Map<String, List<BookingDetails>> userNameVsbookingDetails = new LinkedHashMap<>();
 
	public Map<String, HotelDetails> populateHotel() {

		Map<String, HotelDetails> hotelsVsDetails = new LinkedHashMap<>();

		HotelDetails hotel1 = new HotelDetails();
		hotel1.setHotelName(hotelNames.SKYWALL_RESORT.getHotelName());
		hotel1.setLocationName(locations.CHENNAI.getLocationName());
		hotel1.setRoomAvailable(5);
		hotel1.setRatings(4.5);
		hotel1.setPrice(200);
		hotelsVsDetails.put(hotelNames.SKYWALL_RESORT.getHotelName(), hotel1);

		HotelDetails hotel2 = new HotelDetails();
		hotel2.setHotelName(hotelNames.MOONLIGHT_MANOR.getHotelName());
		hotel2.setLocationName(locations.CHENNAI.getLocationName());
		hotel2.setRoomAvailable(6);
		hotel2.setRatings(3.5);
		hotel2.setPrice(200);
		hotelsVsDetails.put(hotelNames.MOONLIGHT_MANOR.getHotelName(), hotel2);

		HotelDetails hotel3 = new HotelDetails();
		hotel3.setHotelName(hotelNames.RADIANT_RESIDENCES.getHotelName());
		hotel3.setLocationName(locations.MADURAI.getLocationName());
		hotel3.setRoomAvailable(3);
		hotel3.setRatings(5);
		hotel3.setPrice(400);
		hotelsVsDetails.put(hotelNames.RADIANT_RESIDENCES.getHotelName(), hotel3);

		HotelDetails hotel4 = new HotelDetails();
		hotel4.setHotelName(hotelNames.ENIGMA_INN.getHotelName());
		hotel4.setLocationName(locations.MADURAI.getLocationName());
		hotel4.setRoomAvailable(4);
		hotel4.setRatings(2);
		hotel4.setPrice(600);
		hotelsVsDetails.put(hotelNames.ENIGMA_INN.getHotelName(), hotel4);

		HotelDetails hotel5 = new HotelDetails();
		hotel5.setHotelName(hotelNames.TWILIGHT_TERRACE.getHotelName());
		hotel5.setLocationName(locations.SALEM.getLocationName());
		hotel5.setRoomAvailable(2);
		hotel5.setRatings(4);
		hotel5.setPrice(300);
		hotelsVsDetails.put(hotelNames.TWILIGHT_TERRACE.getHotelName(), hotel5);

		HotelDetails hotel6 = new HotelDetails();
		hotel6.setHotelName(hotelNames.AURORA_DREAM_HOTEL.getHotelName());
		hotel6.setLocationName(locations.SALEM.getLocationName());
		hotel6.setRoomAvailable(2);
		hotel6.setRatings(3.5);
		hotel6.setPrice(350);
		hotelsVsDetails.put(hotelNames.AURORA_DREAM_HOTEL.getHotelName(), hotel6);
		return hotelsVsDetails;
	}

	public List<HotelDetails> sortByName(Map<String, HotelDetails> map) {
		List<String> hotelList = new LinkedList<>();
		List<HotelDetails> sortedHotelList = new LinkedList<>();
		for (Entry<String, HotelDetails> entry : map.entrySet()) {
			hotelList.add(entry.getKey());
		}
		Collections.sort(hotelList);
		for (int i = 0; i < map.size(); i++) {
			sortedHotelList.add(map.get(hotelList.get(i)));
		}
		return sortedHotelList;

	}

	public List<String> sortByHighRating(Map<String, HotelDetails> map) {
		Map<String, Double> hotelList = new LinkedHashMap<>();
		List<String> sortedHotelList = new LinkedList<>();
		for (Map.Entry<String, HotelDetails> entry : map.entrySet()) {
			hotelList.put(entry.getKey(), entry.getValue().getRatings());
		}
		List<Map.Entry<String, Double>> entryList = new LinkedList<>(hotelList.entrySet());
		entryList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
		for (Map.Entry<String, Double> entry : entryList) {
			sortedHotelList.add(entry.getKey());
		}
		return sortedHotelList;

	}
	public List<HotelDetails> PopulateLocationList(){
		HotelDetails location1 = new HotelDetails();
		HotelDetails location2 = new HotelDetails();
		HotelDetails location3 = new HotelDetails();
		location1.setLocationName(locations.CHENNAI.getLocationName());
		location2.setLocationName(locations.MADURAI.getLocationName());
		location3.setLocationName(locations.SALEM.getLocationName());
		List<HotelDetails> locationList = new LinkedList<>();
		locationList.add(location1);
		locationList.add(location2);
		locationList.add(location3);
		
		return locationList;
	}
	public List<HotelDetails> searchHotelByLocation(Map<String, HotelDetails> map,List<HotelDetails>locationList,int location) {
		List<HotelDetails> hotelList = new LinkedList<>();
		List<HotelDetails> sortedHotelList = new LinkedList<>();
		for (Entry<String, HotelDetails> entry : map.entrySet()) {
			hotelList.add(entry.getValue());
		}
		for (int i = 0; i < hotelList.size(); i++) {
			
			if (locationList.get(location-1).getLocationName().equals(hotelList.get(i).getLocationName())) {
				sortedHotelList.add(hotelList.get(i));
			}
		}
		return sortedHotelList;
	}

	public List<String> sortByRoomsAvail(Map<String, HotelDetails> map) {
		Map<String, Integer> hotelList = new LinkedHashMap<>();
		List<String> sortedHotelList = new LinkedList<>();
		for (Map.Entry<String, HotelDetails> entry : map.entrySet()) {
			hotelList.put(entry.getKey(), entry.getValue().getRoomAvailable());
		}
		List<Map.Entry<String, Integer>> entryList = new LinkedList<>(hotelList.entrySet());
//		entryList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
		 for (int i = 0; i < entryList.size() - 1; i++) {
	            for (int j = 0; j < entryList.size() - i - 1; j++) {
	                if (entryList.get(j).getValue() > entryList.get(j + 1).getValue()) {	   // Swap the entries
	                    Map.Entry<String, Integer> temp = entryList.get(j);
	                    entryList.set(j, entryList.get(j + 1));
	                    entryList.set(j + 1, temp);
	                }
	            }
	        }
		
		for (Entry<String, Integer> entry : entryList) {
			sortedHotelList.add(entry.getKey());
		}
		return sortedHotelList;

	}

	public Map<String,List<BookingDetails>> bookHotel(String userName,List<HotelDetails> sortedHotelList,int selectedHotelChoice,int personCount) {
		
			 String bookedHotel = sortedHotelList.get(selectedHotelChoice-1).getHotelName();
			 String bookedLocation = sortedHotelList.get(selectedHotelChoice-1).getLocationName();
			 double actualAmount = sortedHotelList.get(selectedHotelChoice-1).getPrice();
			 double bookingCost = personCount*actualAmount;
			 BookingDetails booking = new BookingDetails();
				booking.setUserName(userName);
				booking.setBookedHotel(bookedHotel);
				booking.setPersonCount(personCount);
				booking.setLocation(bookedLocation);
				booking.setBookingCost(bookingCost); 
			
			if(booking!=null) {
					if(userNameVsbookingDetails.get(booking.getUserName())==null) {
						List<BookingDetails> bookingList = new LinkedList<BookingDetails>();
						bookingList.add(booking);
						userNameVsbookingDetails.put(booking.getUserName(),bookingList);
					}
					else {
						List<BookingDetails> bookingList = userNameVsbookingDetails.get(booking.getUserName());
						bookingList.add(booking);
						userNameVsbookingDetails.put(booking.getUserName(), bookingList);
				}	
			}
				return userNameVsbookingDetails;
	}
	
 

}
