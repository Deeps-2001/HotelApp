package runner;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import methods.HotelManagementHandler;
import models.BookingDetails;
import models.HotelDetails;
import util.MyUtil;
import util.CustomException;

public class HotelRunner {
	public static void main(String[] args) throws CustomException {
		System.out.println("Welcome to Hotel Management app:");
		HotelManagementHandler obj = new HotelManagementHandler();
		Scanner sc = new Scanner(System.in);
		String decision;
		do {
			System.out.print("Enter your Name:");
			String name = sc.next();
			System.out.print("Hi " + name + ", Have a nice day! Here is the options in our hotel Management app"
					+ "\n1. Show All Hotel Details " + "\n2. Show Hotel Details Sort by Name"
					+ "\n3. Show Hotel Details Sort by Ratings" + "\n4. Search Hotel by Location"
					+ "\n5. Show Hotel Details Sort by Rooms Available" + "\n6.Show User Booking Data"
					+ "\nEnter your Choice:");
			int choice = MyUtil.checkInt(sc);
			Map<String, HotelDetails> hotelsVsDetails = obj.populateHotel();
			switch (choice) {
			case 1: {
				System.out.println("HOTEL DETAILS :");
				System.out.println(
						"--------------------------------------------------------------------------------------------------------");
				System.out.printf("%-20s | %-15s | %-15s | %-10s | %-10s%n", "HotelName", "RoomsAvailable", "Location",
						"Ratings", "Price Per Person");
				System.out.println(
						"--------------------------------------------------------------------------------------------------------");
				for (Map.Entry<String, HotelDetails> entry : hotelsVsDetails.entrySet()) {
					System.out.printf("%-20s | %-15d | %-15s | %-10.1f | %-10.2f%n", entry.getValue().getHotelName(),
							entry.getValue().getRoomAvailable(), entry.getValue().getLocationName(),
							entry.getValue().getRatings(), entry.getValue().getPrice());
				}
				break;
			}
			case 2: {

				List<HotelDetails> sortedHotels = obj.sortByName(hotelsVsDetails);
				System.out.println("SORT BY NAME:");
				System.out.println(
						"--------------------------------------------------------------------------------------------------------");
				System.out.printf("%-20s | %-15s | %-15s | %-10s | %-10s%n", "HotelName", "RoomsAvailable", "Location",
						"Ratings", "Price Per Person");
				System.out.println(
						"--------------------------------------------------------------------------------------------------------");
				for (int i = 0; i < sortedHotels.size(); i++) {
					System.out.printf("%-20s | %-15d | %-15s | %-10.1f | %-10.2f%n", sortedHotels.get(i).getHotelName(),
							sortedHotels.get(i).getRoomAvailable(), sortedHotels.get(i).getLocationName(),
							sortedHotels.get(i).getRatings(), sortedHotels.get(i).getPrice());
				}
				break;
			}
			case 3: {
				List<String> sortedHotels = obj.sortByHighRating(hotelsVsDetails);
				System.out.println("SORTED BY HIGH RATINGS");
				System.out.println(
						"--------------------------------------------------------------------------------------------------------");
				System.out.printf("%-20s | %-15s | %-15s | %-10s | %-10s%n", "HotelName", "RoomsAvailable", "Location",
						"Ratings", "Price Per Person");
				System.out.println(
						"--------------------------------------------------------------------------------------------------------");

				int len = sortedHotels.size();
				for (int i = 0; i < len; i++) {
					System.out.printf("%-20s | %-15d | %-15s | %-10.1f | %-10.2f%n",
							hotelsVsDetails.get(sortedHotels.get(i)).getHotelName(),
							hotelsVsDetails.get(sortedHotels.get(i)).getRoomAvailable(),
							hotelsVsDetails.get(sortedHotels.get(i)).getLocationName(),
							hotelsVsDetails.get(sortedHotels.get(i)).getRatings(),
							hotelsVsDetails.get(sortedHotels.get(i)).getPrice());
				}
				break;
			}
			case 4: {

				List<HotelDetails> locationList = obj.PopulateLocationList();
				int len = locationList.size();
				for (int i = 0; i < len; i++) {
					System.out.println(i + 1 + "." + locationList.get(i).getLocationName());
				}

				System.out.print("Select your Location :");
				int location = 0;
				boolean condition = true;
				while (condition) {
					if (sc.hasNext()) {
						location = sc.nextInt();
						sc.nextLine();
						if (location > len) {
							System.out.print("Entered value is Wrong!! Please Enter valid Location number :");
						} else {
							condition = false;
						}
					}
				}
				List<HotelDetails> sortedhotelList = obj.searchHotelByLocation(hotelsVsDetails, locationList, location);
				System.out.println("SORT BY GIVEN LOCATION :");
				System.out.println(
						"--------------------------------------------------------------------------------------------------------");
				System.out.printf("%-20s | %-20s | %-15s | %-15s | %-10s | %-10s%n", "S.No", "HotelName",
						"RoomsAvailable", "Location", "Ratings", "Price Per Person");
				System.out.println(
						"--------------------------------------------------------------------------------------------------------");
				for (int i = 0; i < sortedhotelList.size(); i++) {
					System.out.printf("%-20s | %-20s | %-15d | %-15s | %-10.1f | %-10.2f%n", i + 1,
							sortedhotelList.get(i).getHotelName(), sortedhotelList.get(i).getRoomAvailable(),
							sortedhotelList.get(i).getLocationName(), sortedhotelList.get(i).getRatings(),
							sortedhotelList.get(i).getPrice());
				}
				break;

			}
			case 5: {
				List<String> sortedHotels = obj.sortByRoomsAvail(hotelsVsDetails);
				System.out.println("SORTED BY HIGH RATINGS");
				System.out.println(
						"--------------------------------------------------------------------------------------------------------");
				System.out.printf("%-20s | %-15s | %-15s | %-10s | %-10s%n", "HotelName", "RoomsAvailable", "Location",
						"Ratings", "Price Per Person");
				System.out.println(
						"--------------------------------------------------------------------------------------------------------");

				int len = sortedHotels.size();
				for (int i = 0; i < len; i++) {
					System.out.printf("%-20s | %-15d | %-15s | %-10.1f | %-10.2f%n",
							hotelsVsDetails.get(sortedHotels.get(i)).getHotelName(),
							hotelsVsDetails.get(sortedHotels.get(i)).getRoomAvailable(),
							hotelsVsDetails.get(sortedHotels.get(i)).getLocationName(),
							hotelsVsDetails.get(sortedHotels.get(i)).getRatings(),
							hotelsVsDetails.get(sortedHotels.get(i)).getPrice());
				}

				break;
			}
			case 6: {
				System.out.println("Hi " + name + ", Have a nice day! Here are the options in our hotel Management app:");
				Map<String, HotelDetails> HotelListMap = obj.populateHotel();
				List<HotelDetails> locationList = obj.PopulateLocationList();
				int len = locationList.size();
				for (int i = 0; i < len; i++) {
					System.out.println(i + 1 + "." + locationList.get(i).getLocationName());
				}
				System.out.print("Select your Location :");
				int location = 0;
				boolean condition = true;
				while (condition) {
					if (sc.hasNext()) {
						location = sc.nextInt();
						sc.nextLine();
						if (location > len) {
							System.out.print("Entered value is Wrong!! Please Enter valid Location number :");
						} else {
							condition = false;
						}
					}
				}
				List<HotelDetails> sortedHotelList = obj.searchHotelByLocation(HotelListMap, locationList, location);
				System.out.println("SORT BY GIVEN LOCATION:");
				System.out.println(
						"--------------------------------------------------------------------------------------------------------");
				System.out.printf("%-20s | %-20s | %-15s | %-15s | %-10s | %-10s%n", "S.No", "HotelName",
						"RoomsAvailable", "Location", "Ratings", "Price Per Person");
				System.out.println(
						"--------------------------------------------------------------------------------------------------------");
				for (int i = 0; i < sortedHotelList.size(); i++) {
					System.out.printf("%-20s | %-20s | %-15d | %-15s | %-10.1f | %-10.2f%n", i + 1,
							sortedHotelList.get(i).getHotelName(), sortedHotelList.get(i).getRoomAvailable(),
							sortedHotelList.get(i).getLocationName(), sortedHotelList.get(i).getRatings(),
							sortedHotelList.get(i).getPrice());
				}
				System.out.print("Select your hotel options are mentioned above:");
				int hotelChoice = sc.nextInt();
				System.out.print("How many persons do you want to book for:");
				int personNum = sc.nextInt();
				Map<String, List<BookingDetails>> userNameVsbookingDetails = obj.bookHotel(name, sortedHotelList,
						hotelChoice, personNum);
				System.out.println("Hurray, Hotel Booked Successfully!!!");

				List<BookingDetails> allBookingDetails = new LinkedList<BookingDetails>();
				for (Map.Entry<String, List<BookingDetails>> entry : userNameVsbookingDetails.entrySet()) {

					List<BookingDetails> bookingDetailsList = entry.getValue();

					allBookingDetails.addAll(bookingDetailsList);
				}

				System.out.println("BOOKING DETAILS:");
				System.out.println(
						"--------------------------------------------------------------------------------------------------------");
				System.out.printf("%-20s | %-15s | %-15s | %-10s%n", "UserName", "HotelName", "Location",
						"Booking Cost");
				System.out.println(
						"--------------------------------------------------------------------------------------------------------");

				for (int i = 0; i < allBookingDetails.size(); i++) {
					System.out.printf("%-20s | %-15s | %-15s | %-10s%n", allBookingDetails.get(i).getUserName(),
							allBookingDetails.get(i).getBookedHotel(), allBookingDetails.get(i).getLocation(),
							allBookingDetails.get(i).getBookingCost());
				}
				break;
			}
			default: {
				System.out.println("No matching case.");
			}
			}
			System.out.print("Are you want to exit Enter yes/no:");
			decision = sc.next();
		} while (!decision.equalsIgnoreCase("yes"));
		System.out.println("Exiting the application. Goodbye!");
	}
}
