package Bungalows_AND_Cottages;
/**
 * interface Subject
 * @author Aimi Ross
 * @version 1.0.0
 * @since 10/28/2019
 * **/

public abstract interface Subject {
	void crateBooking(Booking b);
	void addToWaitingLIST(Booking b);
	void removeBooking(Booking b);
	void removeFromTheLIST(Booking b);
	void notifyToGuest(String s);
}
