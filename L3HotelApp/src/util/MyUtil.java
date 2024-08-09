package util;

import java.util.Scanner;
import java.util.Objects;
public class MyUtil {
	
	public static void checkNull(Object input) throws CustomException {
		if(Objects.isNull(input)) {
			throw new CustomException("Input is null. Enter a valid input !");
		} 
	}
	 public static int checkInt(Scanner sc) {
		 int option = 0;
		 boolean condition = true;
		 while(condition) {
			 if(sc.hasNext()) {
				 option = sc.nextInt();
				 sc.nextLine();
				 if(option<0) {
					 System.out.println("Enter a Positive Integer");
				 }
				 else {
					 condition =false;
				 }
			 }
			 else {
				 System.out.println("Enter a vald Integer!");
				 sc.next();
			 }
			 
		 }
		return option;
		 
	 }
	 public static String checkNull(Scanner sc) {
		 String name = "";
		 boolean condition = true;
		 while(condition) {
			 if(sc.hasNext()) {
				 name = sc.next();
				 sc.nextLine();
				 if(name.equals(null)) {
					 System.out.println("Enter a Valid String");
				 }
				 else {
					 condition =false;
				 }
			 }
			 else {
				 System.out.println("Enter a valid String!");
				 sc.next();
			 }
			 
		 }
		return name;
		 
	 }
}
