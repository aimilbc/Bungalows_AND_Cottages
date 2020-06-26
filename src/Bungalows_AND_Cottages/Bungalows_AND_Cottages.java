package Bungalows_AND_Cottages;

import java.text.ParseException;
import java.util.InputMismatchException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;


public class Bungalows_AND_Cottages {
	private static Scanner in = new Scanner(System.in);
	static int confNum = 0;
	public static void main(String[] args) throws ParseException, InputMismatchException{
		FrontDesk frontdesk = new FrontDesk();
		String BungName, CottName;
		char subMenuNum;
		char pickedMenuNum;
		char editSubMenu;
		pickedMenuNum = mainMenu();
		while (Character.valueOf(pickedMenuNum).compareTo('S')!=0 && Character.valueOf(pickedMenuNum).compareTo('s')!=0) {
			if (Character.valueOf(pickedMenuNum).compareTo('C')==0 || Character.valueOf(pickedMenuNum).compareTo('c')==0) {
				subMenuNum = subMenu();
				if (Character.valueOf(subMenuNum).compareTo('1')==0) {
					try {
						char pickedBungObj = bungalowMenu();
						while(Character.valueOf(pickedBungObj).compareTo('1')!=0 && Character.valueOf(pickedBungObj).compareTo('2')!=0 
								&& Character.valueOf(pickedBungObj).compareTo('3')!=0 && Character.valueOf(pickedBungObj).compareTo('4')!=0 
								&& Character.valueOf(pickedBungObj).compareTo('5')!=0) 
						{
							System.out.println("Invalid input, please re-enter 1 - 5");
							pickedBungObj = bungalowMenu();
						}
						System.out.print("Enter check-in date in mm/dd/yyyy form: ");
						String from = in.nextLine();
						System.out.print("How many nithgts?: ");
						int Nyts = in.nextInt();
						in.nextLine();
//						System.out.pcrint("Enter check-out date in mm/dd/yyyy form: ");
//						String til = in.nextLine();
//						int Nyts = getDays(from, til);
						if (Character.valueOf(pickedBungObj).compareTo('1')==0)
							BungName = "Morning Glory";
						else if (Character.valueOf(pickedBungObj).compareTo('2')==0) 
							BungName = "The Shelly";
						else if (Character.valueOf(pickedBungObj).compareTo('3')==0) 
							BungName = "Dream Cove";
						else if (Character.valueOf(pickedBungObj).compareTo('4')==0)
							BungName = "Pacific Pleasure";
						else
							BungName = "Sunset Paradise";
						
						int av = availability(frontdesk, BungName, from, Nyts);
						if (av == 0) {
							System.out.print("Would like to be added on a waiting list? Y/N: ");
							char w = in.nextLine().charAt(0);
							while (Character.valueOf(w).compareTo('Y')!=0 && Character.valueOf(w).compareTo('y')!=0 && 
									Character.valueOf(w).compareTo('N')!=0 && Character.valueOf(w).compareTo('n')!=0) {
								System.out.print("Invalid input, please enter y or n");
								System.out.print("Would like to be added on a waiting list? Y/N: ");
								w = in.nextLine().charAt(0);
							}
							if (Character.valueOf(w).compareTo('Y')==0 || Character.valueOf(w).compareTo('y')==0 ) {
								frontdesk.addToWaitingLIST(createBooking(from, Nyts,BungName));
								System.out.println(frontdesk.getWAITING(frontdesk.getWAITINGSize()-1));
								//frontdesk.getAllWaitingList();
							}
						}
						else if(av == 1) {
							frontdesk.crateBooking(bungBooking(frontdesk, from, BungName, Nyts));
							System.out.println(frontdesk.getBooking(frontdesk.getSize()-1));
							//frontdesk.getAllBooking();
						}else {
							System.out.println("Something went wrong. At availability check");
						}
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						System.out.println("Your input was wrong. Re-enter again in mm/dd/yyyy form: ");
						e.printStackTrace();
					}
				}
				else if (Character.valueOf(subMenuNum).compareTo('2')==0){
					char pickedCottObj = cottageMenu();
					while(Character.valueOf(pickedCottObj).compareTo('1')!=0 && Character.valueOf(pickedCottObj).compareTo('2')!=0 && 
							Character.valueOf(pickedCottObj).compareTo('3')!=0 ) 
					{
						System.out.println("Invalid input, please re-enter 1 - 3");
						pickedCottObj = cottageMenu();
					}
					
					System.out.print("Enter check-in date in mm/dd/yyyy form: ");
					String from = in.nextLine();
					System.out.print("How many nithgts?: ");
					int Nyts = in.nextInt();
					in.nextLine();
//					System.out.pcrint("Enter check-out date in mm/dd/yyyy form: ");
//					String til = in.nextLine();
//					int Nyts = getDays(from, til);
					if (Character.valueOf(pickedCottObj).compareTo('1')==0)
						CottName = "Perlita de Oro";
					else if (Character.valueOf(pickedCottObj).compareTo('2')==0) 
						CottName = "The Mermaid";
					else
						CottName = "Poseidon's Lair";
					
					int av = availability(frontdesk, CottName, from, Nyts);
					if (av == 0) {
						System.out.println("Would like to be added on a waiting list? Y/N: ");
						char w = in.nextLine().charAt(0);
						while (Character.valueOf(w).compareTo('Y')!=0 && Character.valueOf(w).compareTo('y')!=0 && 
								Character.valueOf(w).compareTo('N')!=0 && Character.valueOf(w).compareTo('n')!=0) {
							System.out.print("Invalid input, please enter y or n");
							System.out.print("Would like to be added on a waiting list? Y/N: ");
							w = in.nextLine().charAt(0);
						}
						if (Character.valueOf(w).compareTo('Y')==0 || Character.valueOf(w).compareTo('y')==0 ) {
							frontdesk.addToWaitingLIST(createBooking(from, Nyts,CottName));
							System.out.println(frontdesk.getWAITING(frontdesk.getWAITINGSize()-1));
							//frontdesk.getAllWaitingList();
						}
					}else if(av == 1) {
						frontdesk.crateBooking(cottBooking(frontdesk, from, CottName, Nyts));
						System.out.println(frontdesk.getBooking(frontdesk.getSize()-1));
						//frontdesk.getAllBooking();
					}else
						System.out.println("Something went wrong. At availability check");
				}
			}
			else if(Character.valueOf(pickedMenuNum).compareTo('V')==0 || Character.valueOf(pickedMenuNum).compareTo('v')==0) {
				find(frontdesk);
				//int show = find(frontdesk);
				}
			if (Character.valueOf(pickedMenuNum).compareTo('E')==0 || Character.valueOf(pickedMenuNum).compareTo('e')==0) {
				int show = find(frontdesk);
				if (show != -1) {
					editSubMenu = editSUBmenu();
					while (Character.valueOf(editSubMenu).compareTo('N')!=0 && Character.valueOf(editSubMenu).compareTo('n')!=0 
							&& Character.valueOf(editSubMenu).compareTo('C')!=0 && Character.valueOf(editSubMenu).compareTo('c')!=0 
							&& Character.valueOf(editSubMenu).compareTo('E')!=0 && Character.valueOf(editSubMenu).compareTo('e')!=0) {
						System.out.println("Invalid input, try again.");
						editSubMenu = editSUBmenu();
					}
					if(Character.valueOf(editSubMenu).compareTo('N')==0 || Character.valueOf(editSubMenu).compareTo('n')==0) {
						System.out.println("Let's change the check-out date.");
						changeNights(frontdesk, show);
					}
					else if(Character.valueOf(editSubMenu).compareTo('C')==0 ||  Character.valueOf(editSubMenu).compareTo('c')==0) {
						cancel(frontdesk, show);
					}
				}
			}
			pickedMenuNum = mainMenu();
			}
		if (Character.valueOf(pickedMenuNum).compareTo('S')==0 || Character.valueOf(pickedMenuNum).compareTo('s')==0)
			System.exit(0);
		}
	
	
	public static char mainMenu() {
		char pickedNum;
		System.out.println("=============== Main Menu ===============");
		System.out.println("C)reate a new reservation");
		System.out.println("V)iew Reservation");
		System.out.println("E)dit an existing Reservation");
		System.out.println("S)hut Down");
		pickedNum = in.nextLine().charAt(0);
		return pickedNum ;
	}

	public static char subMenu() {
		char pickedNum;
		System.out.println("=============== Sub Menu ===============");
		System.out.println("1) Bungalows");
		System.out.println("2) Cottages");
		pickedNum = in.nextLine().charAt(0);
		return pickedNum;
	}
	
	public static char bungalowMenu() {
		char pickedBung;
		System.out.println("=============== Bungalows ===============");
		System.out.println("1) Morning Glory ($140 / night)");
		System.out.println("2) The Shelly ($110 / night)");
		System.out.println("3) Dream Cove ($160 / night)");
		System.out.println("4) Pacific Pleasure ($130 / night)");
		System.out.println("5) Sunset Paradise ($140 / night)");
		pickedBung = in.nextLine().charAt(0);
		return pickedBung;
	}
	
	public static char cottageMenu() {
		char pickedCott;
		System.out.println("=============== Cottages ===============");
		System.out.println("1) Perlita de Oro ($265 / night)");
		System.out.println("2) The Mermaid ($250 / night)");
		System.out.println("3) Poseidon's Lair ($350 / night)");
		pickedCott = in.nextLine().charAt(0);
		return pickedCott;
	}
	
	public static int getDays(String from, String to) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		Date d1 = sdf.parse(from);
		Date d2 = sdf.parse(to);
		long milliseconds = d1.getTime() - d2.getTime();
		int days = (int) (milliseconds / (-1000 * 60 * 60 * 24));
		return days;
	}

	public static int availability(FrontDesk f, String type, String d, int n) {
		int days=0;
		int i = 0;
		if(f.getSize() == 0) {
			System.out.println("Add to a Booking list.(No elemtns)");
			return 1;
		}
		else {
			while (i<f.getSize()) {
				//System.out.println(f.getType(i));
				if(f.getType(i).equals(type)) {
					try {
						days = getDays(f.getBooking(i).dateFrom, d);// existing date - requested date
						//System.out.println("Existing date: "+ f.getBooking(i).dateFrom + "\nRequesting date: " + d + "\nDays difference is: " + days);
						if(days == 0) {
							//System.out.println(days + ", " + n);
							System.out.println("Booking overlapping(same day).");
							return 0;
						}
						else if(days>0) {
							if(days < f.getBooking(i).nights) {
								//System.out.println(days + ", " + f.getBooking(i).nights + ", " + f.getBooking(i).confirmationNumber);
								System.out.println("Booking overlapping(starts within exsisting booking).");
								return 0;
								}
							else {
								//System.out.println(days + ", " + f.getBooking(i).nights + ", " + f.getBooking(i).confirmationNumber);
								System.out.println("Add to a Booking list.(starts out side of exsiting booking)");
								return 1;
								}
							}
						else if(days<0) {
							//System.out.println("Before: "+ days);
							days = days * -1;
							//System.out.println("After: "+ days);
							if(days < n) {
								//System.out.println(days + ", " + n);
								System.out.println("Booking overlapping(ends within/after existing booking).");
								return 0;
							}
							else {
								//System.out.println(days + ", " + n);
								System.out.println("Add to a Booking list.(ends out side of existing booking)");
								return 1;
								}
							}
						}
					catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						}
					}
				else
					i++;
				}
			System.out.println("Add to a Booking list.(Object is available)");
			return 1;
			}
		}
	
	public static Booking createBooking(String from, int nyts, String type) {
//		Random r = new Random();
//		int low = 1;
//		int high = 1000;
//		int confNum = r.nextInt(high-low) + low;
		confNum++;
		
		System.out.print("Enter the customer's name: ");
		String cusName = in.nextLine();
		System.out.print("Enter the guest count: ");
		String guestAmount = in.nextLine();
		System.out.print("Enter the customer's address: ");
		String address = in.nextLine();
		System.out.print("Enter the customer's phone number: ");
		String phone = in.nextLine();
		System.out.print("Enter the customer's email address: ");
		String email = in.nextLine();
		System.out.print("Enter the customer's credit card name: ");
		String cardName = in.nextLine();
		System.out.print("Enter the customer's credit card number: ");
		String cardNum = in.nextLine();
		System.out.print("Enter the customer's credit card expier date: ");
		String expDate = in.nextLine();
		System.out.print("Enter the customer's credit card security code: ");
		String serurityCode = in.nextLine();
		return new Booking(cusName, guestAmount, from, nyts, type, address, phone, email, cardName, cardNum, expDate, serurityCode, confNum);
	}

	public static Bungalow bungtempBooking(Booking b, double typeP) throws InputMismatchException {
		int optionNyts =0;
		Bungalow bung = new Bungalow(b.name, b.count, b.dateFrom, b.nights, b.type, b.address,b.phone,b.email,
				b.cardName, b.cardNum, b.expDate, b.seruciryCode, b.confirmationNumber,typeP, optionNyts);
		displayOPT(bung);
		optionNyts = in.nextInt();
		in.nextLine();
		bung.setOption(optionNyts);
		return bung;
	}
	
	public static Cottage cotttempBooking(Booking b, double typeP) {
		int optionNyts =0;
		Cottage cott = new Cottage(b.name, b.count,b.dateFrom, b.nights, 
				b.type, b.address,b.phone,b.email, b.cardName, b.cardNum, b.expDate, b.seruciryCode, b.confirmationNumber,typeP, optionNyts);
		displayOPT(cott);
		optionNyts = in.nextInt();
		in.nextLine();
		cott.setOption(optionNyts);
		return cott;
	}
	
	public static void displayOPT(Booking b) {
		b.displayOption();
	}

	public static Bungalow bungBooking(FrontDesk f, String from, String type, int Nyts) throws ParseException {
		double typePrice;
		
		Booking base = createBooking(from, Nyts, type);
		if(type.equals("Morning Glory")) {
			typePrice = 140;
			return bungtempBooking(base, typePrice);
		}else if(type.equals("The Shelly")) {
			typePrice = 110;
			return bungtempBooking(base, typePrice);
		}else if(type.equals("Dream Cove")) {
			typePrice = 160;
			return bungtempBooking(base, typePrice);
		}else if(type.equals("Pacific Pleasure")) {
			typePrice = 130;
			return bungtempBooking(base, typePrice);
		}else if(type.equals("Sunset Paradise")) {
			typePrice = 140;
			return bungtempBooking(base, typePrice);
			}
		System.out.println("Something went wrong with making Bungalow booking");
		return new Bungalow("NO", "NO","NO", 0, "NO", "NO","NO","NO", "NO","NO","NO", "NO", 0, 0,0);
		}

	public static Cottage cottBooking(FrontDesk f, String from, String type, int Nyts) {
		double typePrice;
		
		Booking base = createBooking(from, Nyts, type);
		if(type.equals("Perlita de Oro")) {
			typePrice = 140;
			return cotttempBooking(base, typePrice);
		}else if(type.equals("The Mermaid")) {
			typePrice = 110;
			return cotttempBooking(base, typePrice);
		}else if(type.equals("Poseidon's Lair")) {
			typePrice = 160;
			return cotttempBooking(base, typePrice);
		}
		System.out.println("Something went wrong when making Cottage booking");
		return new Cottage("NO", "NO","NO", 0, "NO", "NO","NO","NO", "NO","NO","NO", "NO", 0, 0,0);
		}
	
	public static int find(FrontDesk f) {
		int i = 0;
		System.out.print("Confirmation Number: ");
		int confNum = in.nextInt();
		in.nextLine();
		
		while (i < f.getSize()) {
			if(confNum ==f.getConfNumBooking(i)) {
				System.out.println(f.getBooking(i));
				return i;
				}
			else
				i++;
			}
		System.out.println("No data found.");
		return -1;
		
		
//		System.out.print("Under Booking List? Waiting List? B/W: ");
//		int i = 0;
//		char lookInto = in.nextLine().charAt(0);
//		while(Character.valueOf(lookInto).compareTo('B')!=0 && Character.valueOf(lookInto).compareTo('b')!=0  &&
//				Character.valueOf(lookInto).compareTo('W')!=0  && Character.valueOf(lookInto).compareTo('w')!=0 ) {
//			System.out.print("Invalid input, under Booking List? Waiting List? B/W: ");
//			lookInto = in.nextLine().charAt(0);
//		}
//		if(Character.valueOf(lookInto).compareTo('B')==0 || Character.valueOf(lookInto).compareTo('b')==0) {
//			System.out.print("Confirmation Number: ");
//			int confNum = in.nextInt();
//			in.nextLine();
//			
//			while (i < f.getSize()) {
//				if(confNum ==f.getConfNumBooking(i)) {
//					System.out.println(f.getBooking(i));
//					return i;
//					}
//				else
//					i++;
//				}
//			System.out.println("No data found.");
//			return -1;
//		}else {
//			System.out.print("Confirmation Number: ");
//			int confNum = in.nextInt();
//			in.nextLine();
//			
//			while (i < f.getWAITINGSize()) {
//				if(confNum ==f.getConfNumWaiting(i)) {
//					System.out.println(f.getWAITING(i));
//					return i;
//					}
//				else
//					i++;
//				}
//			System.out.println("No data found.");
//			return -1;
//		}
	}
	
	public static char editSUBmenu() {
		char sendBack = ' ';
		System.out.println("=============== Edit Submenu ===============");
		System.out.println("N)umber of nights");
		System.out.println("C)cancel Reservation");
		System.out.println("E)xist to Main");
		sendBack = in.nextLine().charAt(0);
		return sendBack;
	}
	
	public static void changeNights(FrontDesk f, int request) throws ParseException {
		int exist = 0;
		int days= 0;
		System.out.print("Enter the requested nights: ");
		int Nyts = in.nextInt();
		in.nextLine();
//		String til = in.nextLine();
//		int Nyts = getDays(f.getFrom(index), til);
		
		while (exist<f.getSize()) {
			if(f.getType(exist).equals(f.getType(request))) {
				if(f.getConfNumBooking(exist) == f.getConfNumBooking(request)) 
					exist++;
				else {
					try {
						days = getDays(f.getBooking(request).dateFrom, f.getBooking(exist).dateFrom);
						if(days >0) {  // the request booking is before the next existing booking.
							//days = getDays(til, f.getBooking(exist).dateFrom);
							if(days<Nyts) {
								//System.out.println(days + ", " + Nyts);
								System.out.println("Unable to change. Booking overlapping(ends within exsisting booking).");
								break;
								}
							else {
								//System.out.println(days + ", " + Nyts);
								System.out.println("Accept the request.(ends out side of exsiting booking)");
								f.getBooking(request).setNyts(Nyts);
								f.getBooking(request).toString();
								break;
							}
							}
						else {
							//System.out.println(days + ", " + Nyts);
							System.out.println("Accept the request.(ends out side of exsiting booking)");
							f.getBooking(request).setNyts(Nyts);
							f.getBooking(request).toString();
							break;
							}
						}
					catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						}
					}
				}
			else
				exist++;
			}
	}
	
	public static void cancel(FrontDesk f, int index) {
		f.getBooking(index).toString();
		f.removeBooking(f.getBooking(index));
	}
}
