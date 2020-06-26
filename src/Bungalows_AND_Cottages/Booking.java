package Bungalows_AND_Cottages;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * class Booking implements observer
 * @author Aimi Ross
 * @version 1.0.0
 * @since 10/28/2019
 * **/
public class Booking implements Observer{
	String name;
	String count;
	String dateFrom;
	//String dateTo;
	int nights;
	String type;
	String address;
	String phone;
	String email;
	String cardName;
	String cardNum;
	String expDate;
	String seruciryCode;
	int confirmationNumber = 0;
	
	/**
	 * default constructor
	 */
	public Booking() {}
	
/**
 * constructor booking
 * @param n: name
 * @param c: amount of guest 
 * @param from: check-in
 * @param nyt: nights counts
 * @param bungType: Bungalow's name
 * @param addss: address
 * @param phn: phone
 * @param e: email
 * @param cName: name of credit card
 * @param cNum: number of credit card
 * @param eDate: Expiration date of credit card
 * @param sCode: Security code of credit card
 * @param i: confirmation number
 */
	public Booking(String n, String c, String from, int nyt, String bungType, String addss, String phn, 
			String e, String cName, String cNum, String eDate, String sCode, int i) {
		this.name = n;
		this.count = c;
		this.dateFrom = from;
		//this.dateTo = to;
		this.nights = nyt;
		this.type = bungType;
		this.address = addss;
		this.phone = phn;
		this.email = e;
		this.cardName = cName;
		this.cardNum = cNum;
		this.expDate = eDate;
		this.seruciryCode = sCode;
		this.confirmationNumber = i;
	}
	
	/**
	 * getter
	 * @return name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * getter
	 * @return from
	 */
	public String getFrom() {
		return dateFrom;
	}
	
	/**
	 * getter
	 * @return to
	 */
	public int getTo() {
		return nights;
	}
	
	/**
	 * getter
	 * @return type
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * display a option
	 */
	public void displayOption() {}
	
	/**
	 * booking info to string
	 */
	public String toString() {
		return "\nConfirmation Number: " + confirmationNumber + "\nType:\t\t" + type + "\nFrom:\t\t" 
				+ dateFrom + "\nNight(s):\t"+ nights + " nights\nName:\t\t" + name + "\nGuest(s):\t" + count + "\nCard info:\t" + cardName + " " 
				+ cardNum + " " + expDate + " " + seruciryCode;
		
		}
	
	/**
	 * setter
	 * @param n: night
	 */
	public void setNyts(int n) {
		nights = n;
	}
	
	/**
	 * getting update(asking to keep the booking or not)
	 */
	@Override
	public Booking update(Subject j) {
		Scanner in = new Scanner(System.in);
		double typePrice = 0;
		System.out.println("Keep this booking?? Y/N: ");
		char action = in.nextLine().charAt(0);
		while (Character.valueOf(action).compareTo('Y')!=0 && Character.valueOf(action).compareTo('y')!=0 &&
				Character.valueOf(action).compareTo('N')!=0 && Character.valueOf(action).compareTo('n')!=0) {
			System.out.println("Invalid input, Keep this booking?? Y/N: ");
			action = in.nextLine().charAt(0);
		}
		if(Character.valueOf(action).compareTo('N')==0 || Character.valueOf(action).compareTo('n')==0) {
			j.removeFromTheLIST(this);
			j.notifyToGuest(this.type);
			}
		else if (Character.valueOf(action).compareTo('Y')==0 || Character.valueOf(action).compareTo('y')==0){
			System.out.println("Entered the bracket... ");
			System.out.println(this.type);
			if(this.type.equals("Perlita de Oro") || this.type.equals("The Mermaid") || this.type.equals("Poseidon's Lair")) {
				System.out.println("Entered the Cottage bracket... ");
				j.removeFromTheLIST(this);
				
				if(this.type.equals("Perlita de Oro")) {
					typePrice = 265;
					System.out.println("Option: cable TV access for $5 / night");
					System.out.print("How many nights would you like to have the option?: ");
					int optionNyts = in.nextInt();
					in.nextLine();
					j.crateBooking(new Cottage (this.name,this.count,this.dateFrom,this.nights, 
							this.type, this.address, this.phone, this.email, 
							this.cardName, this.cardNum, this.expDate, this.seruciryCode,this.confirmationNumber,typePrice,optionNyts));
				}else if(this.type.equals("The Mermaid")) {
					typePrice = 250;
					System.out.println("Option: cable TV access for $5 / night");
					System.out.print("How many nights would you like to have the option?: ");
					int optionNyts = in.nextInt();
					in.nextLine();
					j.crateBooking(new Cottage (this.name,this.count,this.dateFrom,this.nights, 
							this.type, this.address, this.phone, this.email, 
							this.cardName, this.cardNum, this.expDate, this.seruciryCode,this.confirmationNumber,typePrice,optionNyts));
				}else if(this.type.equals("Poseidon's Lair")) {
					typePrice = 350;
					System.out.println("Option: cable TV access for $5 / night");
					System.out.print("How many nights would you like to have the option?: ");
					int optionNyts = in.nextInt();
					in.nextLine();
					j.crateBooking(new Cottage (this.name,this.count,this.dateFrom,this.nights, 
							this.type, this.address, this.phone, this.email, 
							this.cardName, this.cardNum, this.expDate, this.seruciryCode,this.confirmationNumber,typePrice,optionNyts));
					}
				}
			else {
				System.out.println("Entered the Bungalow bracket... ");
				j.removeFromTheLIST(this);

				if(this.type.equals("Morning Glory")) {
					System.out.println("Entered the Morning Glory bracket... ");
					typePrice = 140;
					System.out.println("Option: A portable AC rental for $20 / night");
					System.out.print("How many nights would you like to have the option?: ");
					int optionNyts = in.nextInt();
					in.nextLine();
					j.crateBooking(new Bungalow (this.name,this.count,this.dateFrom,this.nights, 
							this.type, this.address, this.phone, this.email, 
							this.cardName, this.cardNum, this.expDate, this.seruciryCode,this.confirmationNumber,typePrice,optionNyts));
				}else if(this.type.equals("The Shelly")) {
					typePrice = 110;
					System.out.println("Option: A portable AC rental for $20 / night");
					System.out.print("How many nights would you like to have the option?: ");
					int optionNyts = in.nextInt();
					in.nextLine();
					j.crateBooking(new Bungalow (this.name,this.count,this.dateFrom,this.nights, 
							this.type, this.address, this.phone, this.email, 
							this.cardName, this.cardNum, this.expDate, this.seruciryCode,this.confirmationNumber,typePrice,optionNyts));
				}else if(this.type.equals("Dream Cove")) {
					typePrice = 160;
					System.out.println("Option: A portable AC rental for $20 / night");
					System.out.print("How many nights would you like to have the option?: ");
					int optionNyts = in.nextInt();
					in.nextLine();
					j.crateBooking(new Bungalow (this.name,this.count,this.dateFrom,this.nights, 
							this.type, this.address, this.phone, this.email, 
							this.cardName, this.cardNum, this.expDate, this.seruciryCode,this.confirmationNumber,typePrice,optionNyts));
					}
				else if(this.type.equals("Pacific Pleasure")) {
					typePrice = 130;
					System.out.println("Option: A portable AC rental for $20 / night");
					System.out.print("How many nights would you like to have the option?: ");
					int optionNyts = in.nextInt();
					in.nextLine();
					j.crateBooking(new Bungalow (this.name,this.count,this.dateFrom,this.nights, 
							this.type, this.address, this.phone, this.email, 
							this.cardName, this.cardNum, this.expDate, this.seruciryCode,this.confirmationNumber,typePrice,optionNyts));
				}else if(this.type.equals("Sunset Paradise")) {
					typePrice = 140;
					System.out.println("Option: A portable AC rental for $20 / night");
					System.out.print("How many nights would you like to have the option?: ");
					int optionNyts = in.nextInt();
					in.nextLine();
					j.crateBooking(new Bungalow (this.name,this.count,this.dateFrom,this.nights, 
							this.type, this.address, this.phone, this.email, 
							this.cardName, this.cardNum, this.expDate, this.seruciryCode,this.confirmationNumber,typePrice,optionNyts));
					}
			}
	}
		return this;
}
	/**
	 * display the refund status
	 */
	public void displayDeposit() {}
}
