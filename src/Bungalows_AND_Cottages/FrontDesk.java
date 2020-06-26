package Bungalows_AND_Cottages;

import java.util.ArrayList;
import java.util.List;

/**
 * FrontDesk implements Subject
 * @author Aimi Ross
 * @version 1.0.0
 * @since 10/28/2019
 * **/
public class FrontDesk implements Subject{
	private List<Booking> AllBooking;
	private List<Booking> WaitList;
	
	/**
	 * default constructor, creating arrayLists for booking and the customer's name
	 */
	public FrontDesk() {
		AllBooking = new ArrayList<>();
		WaitList = new ArrayList<>();
	}
	
	/**
	 * create a booking list
	 */
	@Override
	public void crateBooking(Booking b) {
		AllBooking.add(b);
	}
	
	/**
	 * removing customers from the list
	 */
	@Override
	public void removeBooking(Booking b) {
		b.displayDeposit();
		System.out.print(b.type + " is now ready.");
		notifyToGuest(b.type);
		AllBooking.remove(b);
	}
	
	/**
	 * notify to the customer
	 */
	@Override
	public void notifyToGuest(String type) {
		int i =0;
		
		if (WaitList.size() == 0)
			System.out.println(type + " is available for a new booking.");
		else while (i < WaitList.size()) {
			if(WaitList.get(i).type.equals(type)) {
				System.out.println(" Confirm with \"" + WaitList.get(i).name + "\"");
				System.out.println(WaitList.get(i).toString());
				WaitList.get(i).update(this);
				break;
			}else
				i++;
		}
	}
	
	/**
	 * adding customers to the list
	 */
	@Override
	public void addToWaitingLIST(Booking b) {
		WaitList.add(b);
	}
	
	/**
	 * removing customers from the list
	 */
	@Override
	public void removeFromTheLIST(Booking b) {
		WaitList.remove(b);
	}
	
	/**
	 * display all the booking(no waiting list)
	 */
	public void getAllBooking() {
		for (int i = 0; i < AllBooking.size(); i++)
			System.out.println(AllBooking.get(i));  //  CHECK IF IT GETS ALL INFO I NEEDED
	}
	
	/**
	 * display all the waiting list
	 */
	public void getAllWaitingList() {
		for (int i = 0; i < WaitList.size(); i++)
			System.out.println(WaitList.get(i));  //  CHECK IF IT GETS ALL INFO I NEEDED
	}
	
	/**
	 * getter
	 * @return booking list size
	 */
	public int getSize() {
		return AllBooking.size();
	}
	
	/**
	 * getter
	 * @return waiting list size
	 */
	public int getWAITINGSize() {
		return WaitList.size();
	}
	
	/**
	 * getter
	 * @param i: index of array list
	 * @return type
	 */
	public String getType(int i) {
		return AllBooking.get(i).type;
	}
	
	/**
	 * getter
	 * @param i: index of array list
	 * @return booking info for that index
	 */
	public Booking getBooking(int i) {
		return AllBooking.get(i);
	}
	
	/**
	 * getter
	 * @param i: index of array list
	 * @return waiting list info for that index
	 */
	public Booking getWAITING(int i) {
		return WaitList.get(i);
	}
	
	/**
	 * getter
	 * @param i: index of array list
	 * @return booking's confirmation number
	 */
	public int getConfNumBooking(int i) {
		return AllBooking.get(i).confirmationNumber;
	}
	
	/**
	 * getter 
	 * @param i: index of array list
	 * @return waiting list's confirmation number
	 */
	public int getConfNumWaiting(int i) {
		return WaitList.get(i).confirmationNumber;
	}
	
	/**
	 * getter
	 * @param i: index
	 * @return 
	 */
	public String getFrom(int i) {
		return AllBooking.get(i).dateFrom;
	}
	
}
